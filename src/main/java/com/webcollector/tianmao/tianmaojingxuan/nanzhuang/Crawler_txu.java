package com.webcollector.tianmao.tianmaojingxuan.nanzhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * T恤
 * @author liyongqiang
 *
 */
public class Crawler_txu extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbqkWR1P&keyword=t%E6%81%A4%E7%94%B7&refpid=mm_10011550_0_0&clk1=d18d9e9c7154c6b2df77a4a7bfd79942&page=";

	public Crawler_txu(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					URL+i+"&_input_charset=utf-8");
		}


	}
	public static void main(String[] args) throws Exception {
		Crawler_txu cw = new Crawler_txu("crawl", true);
		cw.setThreads(10);
		cw.setTopN(10000);
		cw.start(10);

	}

}
