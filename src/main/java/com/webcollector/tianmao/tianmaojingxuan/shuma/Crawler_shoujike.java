package com.webcollector.tianmao.tianmaojingxuan.shuma;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 手机壳
 * 
 * @author liyongqiang
 *
 */
public class Crawler_shoujike extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbwugAPE&keyword=%E6%89%8B%E6%9C%BA%E5%A3%B3&refpid=mm_10011550_0_0&clk1=e4a76b57e9c005e422bd88ffdca294c6&page=";

	public Crawler_shoujike(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}

	}

	public static void main(String[] args) throws Exception {
		Crawler_shoujike ce = new Crawler_shoujike("crawl", true);
		ce.setThreads(10);
		ce.setTopN(10000);
		ce.start(10);

	}

}
