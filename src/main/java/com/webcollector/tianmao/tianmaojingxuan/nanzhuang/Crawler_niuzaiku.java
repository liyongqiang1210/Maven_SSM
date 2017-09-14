package com.webcollector.tianmao.tianmaojingxuan.nanzhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 牛仔裤
 * @author Li Yongqiang
 *
 */
public class Crawler_niuzaiku extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbKFlaD5&keyword=%E7%89%9B%E4%BB%94%E8%A3%A4&refpid=mm_10011550_0_0&clk1=17f08a50116bdd93518d8852371e6ff9&page=";

	public Crawler_niuzaiku(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					URL+i+"&_input_charset=utf-8");
		}


	}

	public static void main(String[] args) throws Exception {
		Crawler_niuzaiku cw = new Crawler_niuzaiku("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
