package com.webcollector.sina.main;

import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webcollector.jdbc.JDBCTemplate_sina;
import com.webcollector.util.DateUtil;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawler_main extends BreadthCrawler {

	private static final String URL = "http://www.sina.com.cn/";
	private Logger log = Logger.getLogger(Crawler_main.class);

	public Crawler_main(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		this.addSeed(URL);
	}

	public void visit(Page page, CrawlDatums next) {
		JDBCTemplate_sina jdbc = new JDBCTemplate_sina();
		@SuppressWarnings("deprecation")
		Document doc = page.getDoc();
		Elements els = doc.select("div.main-nav");
		for (Element el : els) {
			Elements els_a = el.select("a[href]");
			for (Element el_a : els_a) {
				/*String name = el_a.text();
				String url = el_a.absUrl("href");
				String create_time = new DateUtil().getYMDHMS();
				String creater = "liyongqiang";
				log.error("文章标题：" + el_a.text());
				log.error("文章url ：" + el_a.absUrl("href"));
				String sql = "insert into website_two (id,name,url,website_one_id,is_useful,create_time,update_time,creater,modifier)  values (?,?,?,1,1,?,null,?,null)";
				jdbc.jdbc_website_two(name, url, create_time, creater);*/
			}

		}
	}

	public static void main(String[] args) throws Exception {
		Crawler_main cm = new Crawler_main("crawl", true);
		cm.setThreads(100);
		cm.setTopN(2);
		cm.start(2);
	}

}
