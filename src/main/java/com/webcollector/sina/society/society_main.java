package com.webcollector.sina.society;

public class society_main {

	public static void main(String[] args) throws Exception {
		
		Crawler_qwys cs = new Crawler_qwys("crawl", true);
		cs.setThreads(2);
		cs.setTopN(100);
		cs.start(5);
		Crawler_shwx cs1 = new Crawler_shwx("crawl", true);
		cs1.setThreads(2);
		cs1.setTopN(100);
		cs1.start(5);
		Crawler_shyf cs11 = new Crawler_shyf("crawl", true);
		cs11.setThreads(2);
		cs11.setTopN(100);
		cs11.start(5);
		Crawler_zqsk cs111 = new Crawler_zqsk("crawl", true);
		cs111.setThreads(2);
		cs111.setTopN(100);
		cs111.start(5);
	}
}
