package com.webcollector.sina.international;

public class international_main {

	public static void main(String[] args) throws Exception {
		
		Crawler_hqqw cs = new Crawler_hqqw("crawl", true);
		cs.setThreads(2);
		cs.setTopN(100);
		cs.start(5);
		
		Crawler_hqsy cs2 = new Crawler_hqsy("crawl", true);
		cs2.setThreads(2);
		cs2.setTopN(100);
		cs2.start(5);
		//有问题未处理
	/*	Crawler_gjgd cs3 = new Crawler_gjgd("crawl", true);
		cs3.setThreads(2);
		cs3.setTopN(100);
		cs3.start(5);*/
	}
}
