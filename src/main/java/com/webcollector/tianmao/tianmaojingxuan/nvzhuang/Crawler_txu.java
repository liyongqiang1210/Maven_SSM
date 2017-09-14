package com.webcollector.tianmao.tianmaojingxuan.nvzhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * T恤
 * 
 * @author liyongqiang
 *
 */
public class Crawler_txu extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.3.54f025dbe4dEVp&keyword=t%E6%81%A4%E5%A5%B3&refpid=mm_10011550_0_0&clk1=902ddf8d5fac73fc034905e332b55914&page=";

	public Crawler_txu(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}
	}

	public static void main(String[] args) throws Exception {
		Crawler_txu cw = new Crawler_txu("crawl", true);
		cw.setThreads(10);
		cw.setTopN(10000);
		cw.start(10);

	}

}
