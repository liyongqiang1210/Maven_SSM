package com.webcollector.sina.mil.roll;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webcollector.util.DateUtil;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawler_zgjq extends BreadthCrawler {

	//新闻url
	private static final String ZGJQ_URL = "http://roll.mil.news.sina.com.cn/col/zgjq/index.shtml";
	private static final String TYPE = "中国军情";
	//获取新闻页面正则
	private String shtml_regex = ".*china\\/"+new DateUtil().getToday()+"\\/.*\\.shtml";
	//News的属性
	private String title = null;
	private String text = null;
	private String author = null;
	private String picture_url = null;
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
		
		Document doc = page.getDoc();
		
		Elements els = doc.select("a[href]");
		for (Element el : els) {
			String shtml_url = el.absUrl("href");
			if(shtml_url.matches(shtml_regex)){
				//获取到文章的标题
				title = el.text();
				//打印出文章的标题
				log.debug("title: "+title);
				if(shtml_url.matches(shtml_regex)){
					//打印出文章的url
					log.debug(shtml_url);
					//打开这个url连接
					try {
						//获取某篇文章的doc文档
						Document shtml_doc = Jsoup.connect(shtml_url).method(Method.GET).execute().parse();
						//下面开始分析这个文档
						//获取正文内容
						text = shtml_doc.select("div#artibody > p").text();
						log.debug(shtml_doc.select("div#artibody > p").text());
						//获取发布时间
						shtml_doc.select("div#page-tools > span");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
