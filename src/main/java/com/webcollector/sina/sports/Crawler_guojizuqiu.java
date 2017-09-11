package com.webcollector.sina.sports;

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

public class Crawler_guojizuqiu extends BreadthCrawler {
	private Log log = LogFactory.getLog(Crawler_guojizuqiu.class);
	private static final String URL_REGEX = ".*\\/(g|global)\\/.*\\/"+new DateUtil().getToday()+"/.*\\.shtml";
	public Crawler_guojizuqiu(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		//欧冠
		this.addSeed("http://sports.sina.com.cn/g/championsleague/");
		//英超
		this.addSeed("http://sports.sina.com.cn/g/premierleague/index.shtml");
		//西甲
		this.addSeed("http://sports.sina.com.cn/g/laliga/");
		//意甲
		this.addSeed("http://sports.sina.com.cn/g/seriea/");
		//德甲
		this.addSeed("http://sports.sina.com.cn/g/bundesliga/");
		//世预赛
		this.addSeed("http://sports.sina.com.cn/g/2018worldcupeq/");
		//联合会杯
		this.addSeed("http://sports.sina.com.cn/g/confederationscup2017/");
		//欧联
		this.addSeed("http://sports.sina.com.cn/g/europaleague1718/");
		//南美
		this.addSeed("http://sports.sina.com.cn/g/southamerica/");
		//深度策划
		this.addSeed("http://sports.sina.com.cn/g/southamerica/");
	}

	public void visit(Page page, CrawlDatums next) {

		JDBCTemplate_sina jdbc = new JDBCTemplate_sina();
		String type = "国际足球";
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
					String news_text = els_text.toString().substring(160, 350);
					release_time = news_text.substring(news_text.indexOf("article-a__time")+17,49).replaceAll("年|月", "-").replaceAll("日", " ").replace("<", "")+":00";
					source = news_text.substring(news_text.indexOf("article-a__source")+105,news_text.lastIndexOf("</span>"));
					log.debug("################文章title:"+title);
					log.debug("################文章url:"+web_url);
					log.debug("################来源:"+source);
					log.debug("################发布时间:"+release_time);
					log.debug("################文章text:"+text);
					jdbc.insertNews(type, title, web_url, release_time, source, news_text);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		Crawler_guojizuqiu cs = new Crawler_guojizuqiu("crawl", true);
		cs.setThreads(1);
		cs.setTopN(1000);
		cs.start(5);
	}

}
