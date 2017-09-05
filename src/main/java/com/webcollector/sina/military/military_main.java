package com.webcollector.sina.military;

public class military_main {

	public static void main(String[] args) throws Exception {
		
		Crawler_gjjq cg = new Crawler_gjjq("crawl", true);
		cg.setThreads(2);
		cg.setTopN(100);
		cg.start(5);
		Crawler_jssd cj = new Crawler_jssd("crawl", true);
		cj.setThreads(2);
		cj.setTopN(100);
		cj.start(5);
		Crawler_zgjq nc = new Crawler_zgjq("crawl", true);
		nc.setThreads(2);
		nc.setTopN(100);
		nc.start(7);
	}
}
