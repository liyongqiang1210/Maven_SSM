package com.webcollector.sina.international;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webcollector.jdbc.JDBCTemplate_sina;
import com.webcollector.util.DateUtil;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawler_gjgd extends BreadthCrawler {

	private static final String URL = "http://roll.news.sina.com.cn/s/channel.php";
	private static final String SHTML_REGEX = ".*\\/" + new DateUtil().getToday()+"\\/.*\\.shtml";
	private Log log = LogFactory.getLog(Crawler_gjgd.class);

	public Crawler_gjgd(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		this.addSeed(URL);
		//this.addRegex(URL_REGEX);
	}

	public void visit(Page page, CrawlDatums next) {

		Map<String,String> map =new HashMap<String, String>();
		map.put("ch", "01");
		map.put("col", "91");
		map.put("offset_page", "0");
		map.put("offset_num", "0");
		map.put("num", "0");
		map.put("page", "1");
		try {
			Document doc = Jsoup.connect(URL).data(map).method(Method.GET).execute().parse();
		
		JDBCTemplate_sina jdbc = new JDBCTemplate_sina();
		String type = "国际滚动";
		Elements els = doc.select("a[href]");
		for (Element el : els) {

			// 获取url
			String shtml_url = el.absUrl("href");
			// 获取文章标题
			String title = el.select("a[href]").text();
			// 匹配到我们需要的新闻的url
			if (shtml_url.matches(SHTML_REGEX)) {

				try {
					// 获取文章网址
					String web_url = shtml_url;

					// 请求url并转换为document文档
					Document shtml_doc = Jsoup.connect(web_url).method(Method.GET).timeout(10000).execute().parse();

					log.debug("---------------------------" + title + "-START--------------------------------");
					log.debug("文章标题：" + title);
					log.debug("文章网址：" + web_url);

					// 获取文章内容
					String text = "\"" + shtml_doc.select("div#artibody.article.article_16").toString() + "\"";
					log.debug("文章内容：" + text);

					// 获取文章发布时间
					String release_time = shtml_doc.select("span#navtimeSource").text().substring(0, 16)
							.replaceAll("年|月", "-").replace("日", " ");
					log.debug("文章发布时间：" + release_time);

					// 获取文章来源
					String source = shtml_doc.select("span#navtimeSource").text().substring(17);
					log.debug("文章来源：" + source);

					// 存到数据库
					jdbc.insertNews(type, title, web_url, release_time, source, text);
					log.debug("---------------------------" + title + "-END--------------------------------");

				} catch (IOException e) {
					log.error("国际滚动爬取异常：" + e);
				}
			}

		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public static void main(String[] args) throws Exception {
		Crawler_gjgd cs = new Crawler_gjgd("crawl", true);
		cs.setThreads(2);
		cs.setTopN(100);
		cs.start(5);
	}*/

}
