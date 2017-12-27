package com.webcollector.tianmao.tianmaojingxuan.muying;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 童鞋
 * @author Li Yongqiang
 *
 */
public class Crawler_tongxie extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbe1PypA&keyword=%E7%AB%A5%E9%9E%8B&refpid=mm_10011550_0_0&clk1=a9df9796bcafb85d03cd9f3ae5fd43d2&page=";

	public Crawler_tongxie(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					URL+i+"&_input_charset=utf-8");
		}

	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Crawler_tongxie cw = new Crawler_tongxie("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
