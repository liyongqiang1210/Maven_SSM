package com.webcollector.sina.sports;

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

public class Crawler_cba extends BreadthCrawler {
	private Log log = LogFactory.getLog(Crawler_cba.class);
	private static final String URL_REGEX = ".*\\/basketball\\/nba\\/"+new DateUtil().getToday()+"/.*\\.shtml";
	public Crawler_cba(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		//NBA
		this.addSeed("http://sports.sina.com.cn/nba/");
	}

	public void visit(Page page, CrawlDatums next) {

		JDBCTemplate jdbc = new JDBCTemplate();
		String type = "NBA";
		@SuppressWarnings("deprecation")
		Document doc = page.getDoc();
		Elements els = doc.select("a[href]");
		for (Element el : els) {
			String toURL = el.absUrl("href");
			
			String web_url = toURL;
			String title = el.select("a[href]").text();
			String text = null;
			String release_time = null;
			String source = null;
			if(toURL.matches(URL_REGEX)){
				try {
					Document doc_news = Jsoup.connect(web_url).method(Method.GET).execute().parse();
					Elements els_text = doc_news.select("article.article-a");
					text = els_text.toString();
					//用截取字符串的方式截取到我们需要的那段字符
					release_time = doc_news.select("span.article-a__time").text().replaceAll("年|月", "-").replaceAll("日", " ")+":00";
					source = doc_news.select("span.article-a__source > a").text();
					log.debug("################文章title:"+title);
					log.debug("################文章url:"+web_url);
					log.debug("################来源:"+source);
					log.debug("################发布时间:"+release_time);
					log.debug("################文章text:"+text);
					jdbc.insertNews(type, title, web_url, release_time, source, text);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		Crawler_cba cba = new Crawler_cba("crawl", true);
		cba.setThreads(1);
		cba.setTopN(200);
		cba.start(5);
	}

}
