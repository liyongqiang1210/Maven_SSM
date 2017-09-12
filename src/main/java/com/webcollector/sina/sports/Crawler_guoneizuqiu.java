package com.webcollector.sina.sports;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.webcollector.jdbc.JDBCTemplate_sina;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawler_guoneizuqiu extends BreadthCrawler {
	private Log log = LogFactory.getLog(Crawler_guoneizuqiu.class);

	public Crawler_guoneizuqiu(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		// 全部
		this.addSeed(
				"http://feed.mix.sina.com.cn/api/roll/get?pageid=87&lid=552&num=30&versionNumber=1.2.4&page=1&encode=utf-8&callback=feedCardJsonpCallback&_=1504600818897");
		// 中超
		this.addSeed(
				"http://feed.mix.sina.com.cn/api/roll/get?pageid=87&lid=545&num=30&versionNumber=1.2.4&page=1&encode=utf-8&callback=feedCardJsonpCallback&_=1504600870673");
		// 亚冠
		this.addSeed(
				"http://feed.mix.sina.com.cn/api/roll/get?pageid=87&lid=546&num=30&versionNumber=1.2.4&page=1&encode=utf-8&callback=feedCardJsonpCallback&_=1504600966443");
		// 国足
		this.addSeed(
				"http://feed.mix.sina.com.cn/api/roll/get?pageid=87&lid=547&num=30&versionNumber=1.2.4&page=1&encode=utf-8&callback=feedCardJsonpCallback&_=1504600933212");
		// 中甲
		this.addSeed(
				"http://feed.mix.sina.com.cn/api/roll/get?pageid=87&lid=548&num=30&versionNumber=1.2.4&page=1&encode=utf-8&callback=feedCardJsonpCallback&_=1504601114230");
		// 足协杯
		this.addSeed(
				"http://feed.mix.sina.com.cn/api/roll/get?pageid=87&lid=549&num=30&versionNumber=1.2.4&page=1&encode=utf-8&callback=feedCardJsonpCallback&_=1504601063020");
		// 女足
		this.addSeed(
				"http://feed.mix.sina.com.cn/api/roll/get?pageid=87&lid=550&num=30&versionNumber=1.2.4&page=1&encode=utf-8&callback=feedCardJsonpCallback&_=1504601096854");
		// 其他
		this.addSeed(
				"http://feed.mix.sina.com.cn/api/roll/get?pageid=87&lid=551&num=30&versionNumber=1.2.4&page=1&encode=utf-8&callback=feedCardJsonpCallback&_=1504601139779");
	}

	public void visit(Page page, CrawlDatums next) {

		JDBCTemplate_sina jdbc = new JDBCTemplate_sina();
		String type = "国内足球";
		@SuppressWarnings("deprecation")
		String data = page.getDoc().toString();
		String str = data.substring(data.indexOf("\"data\":["), data.lastIndexOf("]")+1);
		String json = str.substring(str.indexOf("["), str.length());
		JSONArray json_array = new JSONArray(json);
		for (int i = 0; i < json_array.length(); i++) {
				JSONObject json_object = (JSONObject) json_array.get(i);
				String web_url = json_object.getString("url");
				String title = json_object.getString("title");
				String source =json_object.getString("media_name");
				String text = null;
				String release_time = null;
				int is_title = jdbc.getTitle(title);
				if(is_title == 0){
					
					try {
						Document doc = Jsoup.connect(web_url).method(Method.GET).execute().parse();
						Elements els_text = doc.select("article.article-a");
						text = els_text.toString();
						Elements els_rtime = doc.select("span.article-a__time");
						release_time = els_rtime.text().replaceAll("年|月", "-").replaceAll("日", " ");
						log.debug("################文章title:"+title);
						log.debug("################文章url:"+web_url);
						log.debug("################来源:"+source);
						log.debug("################发布时间:"+release_time);
						log.debug("################文章text:"+text);
						jdbc.insertNews(type, title, web_url, release_time, source, text);
					} catch (IOException e) {
						log.debug(e.getMessage());
					}
				}else{
					log.debug("###################此条数据已经存在--"+title+"##########################");
				}
				
		}
		
	}

	public static void main(String[] args) throws Exception {
		Crawler_guoneizuqiu cs = new Crawler_guoneizuqiu("crawl", true);
		cs.setThreads(1);
		cs.setTopN(1000);
		cs.start(5);
	}

}
