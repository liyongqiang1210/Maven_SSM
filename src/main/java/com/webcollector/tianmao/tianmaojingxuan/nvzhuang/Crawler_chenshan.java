package com.webcollector.tianmao.tianmaojingxuan.nvzhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 衬衫
 * 
 * @author liyongqiang
 *
 */
public class Crawler_chenshan extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.2.54f025dbDz7AcG&keyword=%E8%A1%AC%E8%A1%AB%E5%A5%B3&refpid=mm_10011550_0_0&clk1=cd7a16d0da94f6a685546c8ac01bdfd1&page=1";

	public Crawler_chenshan(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}
	}

	public static void main(String[] args) throws Exception {
		Crawler_chenshan cw = new Crawler_chenshan("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
