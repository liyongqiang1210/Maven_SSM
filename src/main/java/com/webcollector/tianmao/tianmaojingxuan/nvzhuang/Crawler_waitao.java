package com.webcollector.tianmao.tianmaojingxuan.nvzhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 外套
 * 
 * @author liyongqiang
 *
 */
public class Crawler_waitao extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.2.54f025db2tjowM&keyword=%E5%A4%96%E5%A5%97%E5%A5%B3&refpid=mm_10011550_0_0&clk1=962d918c9b611bc56a7e56acd22946c6&page=";

	public Crawler_waitao(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}
	}

	public static void main(String[] args) throws Exception {
		Crawler_waitao cw = new Crawler_waitao("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
