package com.webcollector.sina.military;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webcollector.jdbc.JDBCTemplate_sina;
import com.webcollector.util.DateUtil;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawler_jssd extends BreadthCrawler {

	public static Log log = LogFactory.getLog(Crawler_jssd.class);
	private static final String URL = "http://mil.news.sina.com.cn/jssd/";
	private static final String TYPE = "深度";
	private static final String SHTML_REGEX = ".*jssd\\/2017.*\\/.*\\.shtml";

	public Crawler_jssd(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		this.addSeed(URL);

	}

	public void visit(Page page, CrawlDatums next) {

		JDBCTemplate_sina jdbc = new JDBCTemplate_sina();
		log.debug(
				"----------------------START(国际军情) 日期：" + new DateUtil().getToday() + "-----------------------------");
		@SuppressWarnings("deprecation")
		Document doc = page.getDoc();
		Elements els = doc.select("a[href]");
		for (Element el : els) {
			// 获取文章标题
			String title = el.text();
			// 查询数据库是否存在此条数据
			int i = jdbc.getTitle(title);
			// 如果存在的话继续下一步，否则结束
			if (i == 0) {
				String shtml_url = el.absUrl("href");
				// 获取我们需要的url
				if (shtml_url.matches(SHTML_REGEX)) {

					try {
						log.debug("文章标题：" + el.text());

						// 获取文章的url
						String web_url = shtml_url;
						log.debug("shtml_url:\n" + shtml_url);

						// 打开这个url转换为document文档
						Document shtml_doc = Jsoup.connect(shtml_url).method(Method.GET).execute().parse();

						// 获取发布时间
						String release_time = shtml_doc.select("span.titer").text().replaceAll("年|月", "-").replace("日",
								"");

						// 获取来源
						String source = shtml_doc.select("a.ent1.fred").text();

						log.debug("发布时间：" + release_time + "  来源：" + source);

						// 获取文章内容
						String text = "\"" + shtml_doc.select("div#artibody.content").toString() + "\"";
						log.debug("文章正文：\n" + text);

						// 存到数据库
						jdbc.insertNews(TYPE, title, web_url, release_time, source, text);

					} catch (IOException e) {
						log.error(e);
					}
				} else {
					log.debug("######################数据库已经存在此条信息--" + title + "#####################");
				}
			}
		}

		log.debug("-----------------------END(国际军情) 日期：" + new DateUtil().getToday() + "--------------------------");
	}

	/*public static void main(String[] args) throws Exception {
		Crawler_jssd cj = new Crawler_jssd("crawl", true);
		cj.setThreads(2);
		cj.setTopN(5000);
		cj.start(5);
	}*/
}
