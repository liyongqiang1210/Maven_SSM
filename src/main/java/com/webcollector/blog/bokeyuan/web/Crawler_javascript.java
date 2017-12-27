package com.webcollector.blog.bokeyuan.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webcollector.jdbc.JDBCTemplate_bokeyuan;
import com.webcollector.sina.domestic.Crawler_gatxw;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawler_javascript extends BreadthCrawler {

	private Log log = LogFactory.getLog(Crawler_gatxw.class);

	public Crawler_javascript(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 0; i <= 100; i++) {
			this.addSeed("https://www.cnblogs.com/cate/jquery/" + i);
		}

	}

	public void visit(Page page, CrawlDatums next) {

		JDBCTemplate_bokeyuan jb = new JDBCTemplate_bokeyuan();
		@SuppressWarnings("deprecation")
		Document doc = page.getDoc();
		Elements els = doc.select("h3>a.titlelnk");
		for (Element el : els) {
			// 文章类型
			String type = "jquery";
			// 获取文章标题
			String title = el.select("a").text();
			log.debug("文章标题:" + title);
			// 获取博客的url地址
			String url = el.absUrl("href");
			log.debug("博客url地址:" + url);
			//插入到数据库
			//jb.insertNews(type, url, title);
		}

	}
	public static void main(String[] args) throws Exception {
		Crawler_javascript cs =new Crawler_javascript("crawl", true);
		cs.setThreads(1);
		cs.setTopN(100);
		cs.start(2);
	}

}
