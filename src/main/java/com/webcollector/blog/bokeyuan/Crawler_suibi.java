package com.webcollector.blog.bokeyuan;

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

public abstract class Crawler_suibi extends BreadthCrawler {

	private Log log = LogFactory.getLog(Crawler_gatxw.class);

	public Crawler_suibi(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 0; i <= 200; i++) {
			this.addSeed("https://www.cnblogs.com/cate/all/" + i);
		}

	}

	public void visit(Page page, CrawlDatums next) {

		JDBCTemplate_bokeyuan jb = new JDBCTemplate_bokeyuan();
		@SuppressWarnings("deprecation")
		Document doc = page.getDoc();
		Elements els = doc.select("h3>a.titlelnk");
		for (Element el : els) {
			// 文章类型
			String type = "随笔";
			// 获取文章标题
			String title = el.select("a").text();
			log.debug("文章标题:" + title);
			// 获取博客的url地址
			String url = el.absUrl("href");
			log.debug("博客url地址:" + url);
			jb.insertNews(type, url, title);
		}

	}

}
