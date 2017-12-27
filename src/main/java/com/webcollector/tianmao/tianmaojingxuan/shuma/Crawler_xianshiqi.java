package com.webcollector.tianmao.tianmaojingxuan.shuma;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 显示器
 * 
 * @author liyongqiang
 *
 */
public class Crawler_xianshiqi extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbC0VIby&keyword=%E6%98%BE%E7%A4%BA%E5%99%A8&refpid=mm_10011550_0_0&clk1=9d9f2d60e519747e0a7fe2c733512429&page=";

	public Crawler_xianshiqi(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}
	}

	public static void main(String[] args) throws Exception {
		Crawler_xianshiqi ce = new Crawler_xianshiqi("crawl", true);
		ce.setThreads(10);
		ce.setTopN(10000);
		ce.start(10);

	}

}
