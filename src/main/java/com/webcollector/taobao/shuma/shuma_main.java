package com.webcollector.taobao.shuma;

public class shuma_main {

	public static void main(String[] args) throws Exception {
		Crawler_choudianbao cc = new Crawler_choudianbao("crawl", true);
		cc.setThreads(10);
		cc.setTopN(1000);
		cc.start(10);
		Crawler_erji ce = new Crawler_erji("crawl", true);
		ce.setThreads(10);
		ce.setTopN(1000);
		ce.start(10);
		Crawler_jixiejianpan cj = new Crawler_jixiejianpan("crawl", true);
		cj.setThreads(10);
		cj.setTopN(1000);
		cj.start(10);
		Crawler_shoujike cs = new Crawler_shoujike("crawl", true);
		cs.setThreads(10);
		cs.setTopN(1000);
		cs.start(10);
		Crawler_xianshiqi cx = new Crawler_xianshiqi("crawl", true);
		cx.setThreads(10);
		cx.setTopN(1000);
		cx.start(10);
		Crawler_yidongyingpan cy = new Crawler_yidongyingpan("crawl", true);
		cy.setThreads(50);
		cy.setTopN(1000);
		cy.start(10);
	}
}
