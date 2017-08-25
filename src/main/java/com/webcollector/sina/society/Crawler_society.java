package com.webcollector.sina.society;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webcollector.jdbc.JDBCTemplate;
import com.webcollector.util.DateUtil;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawler_society extends BreadthCrawler {

	private static final String URL = "http://news.sina.com.cn/society/";
	// 文章分类正则
	private static final String TYPE＿REGEX = ".*\\/news\\/shxw\\/[a-z]{0,10}\\/index.shtml";
	private static final String SHTML_REGEX = ".*" + new DateUtil().getToday() + "\\/.*\\.shtml";
	private Log log = LogFactory.getLog(Crawler_society.class);

	public Crawler_society(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		this.addSeed(URL);
	}

	public void visit(Page page, CrawlDatums next) {

		

		JDBCTemplate jdbc = new JDBCTemplate();

		@SuppressWarnings("deprecation")
		Document doc = page.getDoc();
		Elements els = doc.select("a[href]");
		for (Element el : els) {

			// 获取url
			String type_url = el.absUrl("href");

			// 匹配到我们需要的新闻分类的url
			if (type_url.matches(TYPE＿REGEX)) {

				try {
					// 获取新闻分类
					String type = el.text();
					log.debug("文章分类：" + type);

					// 打开分类网页的url并转换为Document文档
					Document type_doc = Jsoup.connect(type_url).method(Method.GET).execute().parse();

					// 开始分析这个网页
					Elements type_els = type_doc.select("a[href]");
					for (Element type_el : type_els) {

						// 进入到文章的url
						String shtml_url = type_el.absUrl("href");

						if (shtml_url.matches(SHTML_REGEX)) {
							
							// 获取文章网址
							String web_url = shtml_url;

							// 请求url并转换为document文档
							Document shtml_doc = Jsoup.connect(web_url).method(Method.GET).execute().parse();

							// 获取文章标题
							String title = type_el.select("a[href]").text();
							
							log.debug("---------------------------"+title+"-START--------------------------------");
							log.debug("文章标题：" + title);
							log.debug("文章网址：" + web_url);
							
							// 获取文章内容
							String text = shtml_doc.select("div#artibody.article.article_16").toString();
							log.debug("文章内容：" + text);

							// 获取文章发布时间
							String release_time = shtml_doc.select("span#navtimeSource").text().substring(0, 16)
									.replaceAll("年|月", "-").replace("日", " ");
							log.debug("文章发布时间：" + release_time);

							// 获取文章来源
							String source = shtml_doc.select("span#navtimeSource").text().substring(17);
							log.debug("文章来源：" + source);

							// 存到数据库
							String sql = "insert into news (id,type,title,text,source,web_url,release_time,create_time) value (?,?,?,?,?,?,?,?)";
							jdbc.jdbc(type, title, web_url, release_time, source, text, sql);
							log.debug("---------------------------"+title+"-END--------------------------------");
						}
					}

				} catch (IOException e) {
					log.error("社会新闻爬取异常：" + e);
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		Crawler_society cs = new Crawler_society("crawl", true);
		cs.setThreads(2);
		cs.setTopN(100);
		cs.start(5);
	}

}
