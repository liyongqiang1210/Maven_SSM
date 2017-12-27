package com.webcollector.tianmao.tianmaojingxuan.shuma;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 机械键盘
 * 
 * @author liyongqiang
 *
 */
public class Crawler_jixiejianpan extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.2.54f025dbLKr0hB&keyword=%E6%9C%BA%E6%A2%B0%E9%94%AE%E7%9B%98&refpid=mm_10011550_0_0&clk1=85c7594ca34a267a33426c80dae893bc&page=";

	public Crawler_jixiejianpan(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}

	}

	public static void main(String[] args) throws Exception {
		Crawler_jixiejianpan ce = new Crawler_jixiejianpan("crawl", true);
		ce.setThreads(50);
		ce.setTopN(1000);
		ce.start(10);

	}

}
