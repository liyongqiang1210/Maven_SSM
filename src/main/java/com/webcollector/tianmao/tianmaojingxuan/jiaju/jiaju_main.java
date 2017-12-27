package com.webcollector.tianmao.tianmaojingxuan.jiaju;

public class jiaju_main {

	public static void main(String[] args) throws Exception {
		Crawler_yigui cy = new Crawler_yigui("crawl_yigui", true);
		cy.setThreads(2);
		cy.setTopN(100);
		cy.start(100);
		
		Crawler_diannaozhuo cd = new Crawler_diannaozhuo("crawl_diannaozhuo", true);
		cd.setThreads(2);
		cd.setTopN(100);
		cd.start(100);
		
		Crawler_huajia ch = new Crawler_huajia("crawl_huajia", true);
		ch.setThreads(2);
		ch.setTopN(100);
		ch.start(100);
		
		Crawler_shafa cs = new Crawler_shafa("crawl_shafa", true);
		cs.setThreads(2);
		cs.setTopN(100);
		cs.start(100);
		
		Crawler_xiegui cx = new Crawler_xiegui("crawl_xiegui", true);
		cx.setThreads(2);
		cx.setTopN(100);
		cx.start(100);
		
		Crawler_yigui cyg = new Crawler_yigui("crawl_yigui", true);
		cyg.setThreads(2);
		cyg.setTopN(100);
		cyg.start(100);
	}
}
