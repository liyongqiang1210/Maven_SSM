package com.webcollector.other;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

/**
 * 爬去模板之家的html模板
 * 
 * @author liyongqiang
 *
 */
public class HtmlTemplateCrawler extends BreadthCrawler {

	// 爬取的网址
	private String url = "http://www.cssmoban.com/";
	// 用这个正则去过滤不是自己要的url
	private String hrefRegex = ".*\\/tags\\.asp\\?n=.*";
	private String shtmlRegex = ".*\\/cssthemes\\/\\d{4,6}\\.shtml";
	private String DownloadsRegex = ".*\\/cssthemes\\d{0-2}\\/.*\\.zip";

	public HtmlTemplateCrawler(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		this.addSeed(url);
	}

	public Map<String, String> getCookies(String url) throws IOException {
		Connection conn = Jsoup.connect(url);
		conn.method(Method.GET);
		conn.followRedirects(false);
		Response response = conn.execute();
		return response.cookies();
	}

	public void visit(Page page, CrawlDatums next) {

		// 将页面转化为Document
		@SuppressWarnings("deprecation")
		Document doc = page.getDoc();
		// 这里的select方法用的是jsoup的方法，就是选择所有a标签下的href属性
		Elements els = doc.select("a[href]");
		// 循环遍历
		for (Element el : els) {
			// 获取href属性的url 第一层
			String url = el.absUrl("href");

			if (url.matches(hrefRegex)) {
				// 获取网站的分类名字
				String title = el.text();
				 System.out.println("title:"+title);
				// System.out.println("模板url: "+url);
				String toUrl = url;
				try {
					// 获取网页cookies
					Map<String, String> map = this.getCookies(toUrl);
					// 根据爬到的url进入到这个网页
					Document doc2 = Jsoup.connect(toUrl).cookies(map).timeout(5000).get();
					Elements els2 = doc2.select("a[href]");
					for (Element el2 : els2) {
						// 网页的第二层
						String shtmlUrl = el2.absUrl("href");
						if (shtmlUrl.matches(shtmlRegex)) {
							// 得到我们需要的url
							String toShtmlUrl = shtmlUrl;
							//System.out.println("shtml：" + toShtmlUrl);
							// 进入到网页的第三层
							// 获取网页cookies
						//	Map<String, String> map2 = this.getCookies(toShtmlUrl);
							Document doc3 = Jsoup.connect(toShtmlUrl).cookies(map).timeout(50000).get();
							Elements els3 = doc3.select("a[href]");
							System.out.println(els3);
							for (Element el3 : els3) {
								// 获取到下载模板的url链接
								String downlaodsUrl = el3.absUrl("href");
								System.out.println("downloadsUrl:"+downlaodsUrl);
								// 过滤掉不匹配的url
								/*if (downlaodsUrl.matches(DownloadsRegex)) {
									String toDownloadsUrl = downlaodsUrl;
									System.out.println("toDownloadsUrl: " + toDownloadsUrl);
								}*/
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		HtmlTemplateCrawler htc = new HtmlTemplateCrawler("crawl", true);
		htc.setThreads(2);
		htc.setTopN(5000);
		htc.start(5);
	}

}
