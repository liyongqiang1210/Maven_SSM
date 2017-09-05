package com.webcollector.sina.sports;

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

public class Crawler_zhongguozuqiu extends BreadthCrawler {
	private Log log = LogFactory.getLog(Crawler_zhongguozuqiu.class);
	private static final String URL = "http://sports.sina.com.cn/csl/";
	private static final String SHTML_REGEX = ".*\\/" + new DateUtil().getToday() + "\\/.*\\.shtml";

	public Crawler_zhongguozuqiu(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		this.addSeed(URL);
	}

	public void visit(Page page, CrawlDatums next) {

		JDBCTemplate jdbc = new JDBCTemplate();
		String type = "中国足球";

		@SuppressWarnings("deprecation")
		Elements els = page.getDoc().select("li>a");
		for (Element el : els) {

			// 获取url
			String shtml_url = el.absUrl("href");
			// 获取文章标题
			String title = el.select("a[href]").text();
			// 匹配到我们需要的新闻的url
			if (shtml_url.matches(SHTML_REGEX)) {
				// 查询数据库是否存在此条数据
				int i = jdbc.getTitle(title);
				// 如果存在的话继续下一步，否则结束
				if (i == 0) {
					try {
						// 获取文章网址
						String web_url = shtml_url;
						System.out.println(web_url);

						// 请求url并转换为document文档
						Document shtml_doc = Jsoup.connect(web_url).method(Method.GET).timeout(10000).execute().parse();

						// 获取文章内容
						String text = "\"" + shtml_doc.select("article.article-a").toString() + "\"";

						// 获取文章发布时间
						String release_time = shtml_doc.select("span.article-a__time").text().substring(0, 16)
								.replaceAll("年|月", "-").replace("日", " ");

						// 获取文章来源
						String source = shtml_doc.select("a.article-a__sourcename").text();

						log.debug("---------------------------" + title + "-START--------------------------------");
						log.debug("文章标题：" + title);
						log.debug("文章网址：" + web_url);
						log.debug("文章发布时间：" + release_time);
						log.debug("文章来源：" + source);
						log.debug("文章内容：" + text);

						// 存到数据库
						jdbc.insertNews(type, title, web_url, release_time, source, text);
						log.debug("---------------------------" + title + "-END--------------------------------");

					} catch (IOException e) {
						log.error("中国足球爬取异常：" + e);
					}
				} else {
					log.debug("######################数据库已经存在此条信息--" + title + "#####################");
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		Crawler_zhongguozuqiu cs = new Crawler_zhongguozuqiu("crawl", true);
		cs.setThreads(2);
		cs.setTopN(1000);
		cs.start(5);
	}

}
