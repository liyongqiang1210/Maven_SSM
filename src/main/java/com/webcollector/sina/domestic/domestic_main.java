package com.webcollector.sina.domestic;

public class domestic_main {

	public static void main(String[] args) throws Exception {
		
		//港澳台新闻
		Crawler_gatxw cg = new Crawler_gatxw("crawl", true);
		cg.setThreads(2);
		cg.setTopN(500);
		cg.start(5);
		
		Crawler_gdxw cg2 = new Crawler_gdxw("crawl", true);
		cg2.setThreads(2);
		cg2.setTopN(500);
		cg2.start(5);
		
		Crawler_zsfx cz = new Crawler_zsfx("crawl", true);
		cz.setThreads(2);
		cz.setTopN(500);
		cz.start(5);
	}
}