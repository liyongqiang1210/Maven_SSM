package com.webcollector.tianmao.tianmaojingxuan.nanzhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 夹克
 * @author Li Yongqiang
 *
 */
public class Crawler_jiake extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbx0yRrm&keyword=%E5%A4%B9%E5%85%8B%E7%94%B7&refpid=mm_10011550_0_0&clk1=d07ace645129aa005cd003cf1619375c&page=1&_input_charset=utf-8";

	public Crawler_jiake(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					URL+i+"&_input_charset=utf-8");
		}


	}
	public static void main(String[] args) throws Exception {
		Crawler_jiake cw = new Crawler_jiake("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
