package com.webcollector.tianmao.tianmaojingxuan.nvzhuang;

public class nvzhuang_main {

	public static void main(String[] args) throws Exception {
		Crawler_chenshan cc = new Crawler_chenshan("crawl", true);
		cc.setThreads(10);
		cc.setTopN(1000);
		cc.start(10);
		Crawler_lianyiqun cl = new Crawler_lianyiqun("crawl", true);
		cl.setThreads(10);
		cl.setTopN(1000);
		cl.start(10);
		Crawler_niuzaiku cm = new Crawler_niuzaiku("crawl", true);
		cm.setThreads(10);
		cm.setTopN(1000);
		cm.start(10);
		Crawler_txu ct = new Crawler_txu("crawl", true);
		ct.setThreads(10);
		ct.setTopN(1000);
		ct.start(10);
		Crawler_waitao cwt = new Crawler_waitao("crawl", true);
		cwt.setThreads(10);
		cwt.setTopN(1000);
		cwt.start(10);
		Crawler_weiyi cwy = new Crawler_weiyi("crawl", true);
		cwy.setThreads(10);
		cwy.setTopN(1000);
		cwy.start(10);
	}
}
