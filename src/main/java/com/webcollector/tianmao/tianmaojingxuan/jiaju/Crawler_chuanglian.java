package com.webcollector.tianmao.tianmaojingxuan.jiaju;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_chuanglian extends TianMaoJingXuanCrawler {

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbAQUXo9&keyword=%E6%B2%99%E5%8F%91&refpid=mm_10011550_0_0&clk1=c7c5bae424233869474a1024738ee917&page=";

	public Crawler_chuanglian(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		/*
		 * this.addSeed( url+"4"+"&_input_charset=utf-8");
		 */
		for (int i = 16; i <21; i++) {
			this.addSeed(url + i + "&_input_charset=utf-8");
		}
	}

	public static void main(String[] args) throws Exception {
		Crawler_chuanglian cs = new Crawler_chuanglian("crawl", true);
		cs.setThreads(10);
		cs.setTopN(5000);
		cs.start(10);
		cs.setResumable(true);
	}
}
