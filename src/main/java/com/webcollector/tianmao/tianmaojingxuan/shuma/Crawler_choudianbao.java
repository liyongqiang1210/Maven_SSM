package com.webcollector.tianmao.tianmaojingxuan.shuma;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 充电宝
 * 
 * @author liyongqiang
 *
 */
public class Crawler_choudianbao extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbcCTAj3&keyword=%E5%85%85%E7%94%B5%E5%AE%9D&refpid=mm_10011550_0_0&clk1=d1637362ff621df1a66742a1b2a28aaf&page=";

	public Crawler_choudianbao(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}

	}

	public static void main(String[] args) throws Exception {
		Crawler_choudianbao ce = new Crawler_choudianbao("crawl", true);
		ce.setThreads(10);
		ce.setTopN(10000);
		ce.start(10);

	}

}
