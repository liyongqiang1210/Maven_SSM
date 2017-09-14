package com.webcollector.tianmao.tianmaojingxuan.nvzhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 外衣
 * 
 * @author liyongqiang
 *
 */
public class Crawler_weiyi extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbig20re&keyword=%E5%8D%AB%E8%A1%A3%E5%A5%B3&refpid=mm_10011550_0_0&clk1=404c2fe5bc3d2eac53535eb7b0395092&page=";

	public Crawler_weiyi(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}
	}

	public static void main(String[] args) throws Exception {
		Crawler_weiyi cw = new Crawler_weiyi("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
