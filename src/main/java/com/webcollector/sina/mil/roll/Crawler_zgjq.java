package com.webcollector.sina.mil.roll;

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

public class Crawler_zgjq extends BreadthCrawler {

	// 新闻url
	private static final String ZGJQ_URL = "http://roll.mil.news.sina.com.cn/col/zgjq/index.shtml";
	private static final String TYPE = "中国军情";
	// 获取新闻页面正则
	private String shtml_regex = ".*china\\/" + new DateUtil().getToday() + "\\/.*\\.shtml";
	// News的属性
	private String title = null;
	private String text = null;
	private String source = null;
	private String release_time = null;
	private String web_url = null;

	public static Log log = LogFactory.getLog(Crawler_zgjq.class);

	public Crawler_zgjq(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		this.addSeed(ZGJQ_URL);
	}

	@SuppressWarnings("deprecation")
	public void visit(Page page, CrawlDatums next) {

		JDBCTemplate jdbc = new JDBCTemplate();

		Document doc = page.getDoc();

		Elements els = doc.select("a[href]");
		for (Element el : els) {
			String shtml_url = el.absUrl("href");
			if (shtml_url.matches(shtml_regex)) {

				if (shtml_url.matches(shtml_regex)) {

					try {
						log.debug("--------------------------START------------------------------");
						// 获取到文章的标题
						title = el.text();
						// 打印出文章的标题
						log.debug("title: " + title);
						// 获取文章的url
						web_url = shtml_url;
						// 打印出文章的url
						log.debug(web_url);
						// 打开这个url连接
						// 获取某篇文章的doc文档
						Document shtml_doc = Jsoup.connect(shtml_url).method(Method.GET).execute().parse();
						// 下面开始分析这个文档
						// 获取正文内容
						text = "\"" + shtml_doc.select("div#artibody.content").toString() + "\"";
						log.debug(text);
						// 获取发布时间与数据来源
						String ts = shtml_doc.select("div#page-tools > span").text();
						// 截取发布时间
						release_time = ts.substring(0, 17).replaceAll("年|月", "-").replace("日", "");
						// 截取数据来源
						source = ts.substring(17, ts.length());
						log.debug("发布时间：" + release_time);
						log.debug("数据来源: " + source);

						// 存到数据库
						String sql = "insert into news (id,type,title,text,source,web_url,release_time,create_time) value (?,?,?,?,?,?,?,?)";
						jdbc.jdbc(TYPE, title, web_url, release_time, source, text, sql);
						log.debug("---------------------------END--------------------------------");
					} catch (IOException e) {
						log.error("中国军情爬取异常：" + e);
					}

				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		Crawler_zgjq nc = new Crawler_zgjq("crawl", true);
		nc.setThreads(2);
		nc.setTopN(5000);
		nc.start(7);
	}

}
