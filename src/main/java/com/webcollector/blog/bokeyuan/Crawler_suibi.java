package com.webcollector.blog.bokeyuan;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawler_suibi extends BreadthCrawler {


	public Crawler_suibi(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		this.addSeed("https://www.cnblogs.com/cate/108724/#p4");
		
	}

	public void visit(Page page, CrawlDatums next) {

		@SuppressWarnings("deprecation")
		Document doc = page.getDoc();
		Elements els = doc.select("h3>a.titlelnk");
		int i = 0;
		for (Element el : els) {
			// 获取文章标题
			String title = el.select("a").text();
			System.out.println("文章标题:" + title);
			// 获取博客的url地址
			String href = el.absUrl("href");
			System.out.println("博客url地址:" + href);
			i++;
		}

	}

	public static void main(String[] args) throws Exception {
			Crawler_suibi cs = new Crawler_suibi("crawl", true);
			cs.setThreads(1);
			cs.setTopN(100);
			cs.start(5);
		
	}

}
