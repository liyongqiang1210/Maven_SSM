package com.webcollector.tianmao.tianmaojingxuan.meishi;

public class meishi_main {

	public static void main(String[] args) throws Exception {
		Crawler_chaye cc = new Crawler_chaye("crawl_chaye", true);
		cc.setThreads(2);
		cc.setTopN(100);
		cc.start(100);
		
		Crawler_kafei ck = new Crawler_kafei("crawl_kafei", true);
		ck.setThreads(2);
		ck.setTopN(100);
		ck.start(100);
		
	}
}
