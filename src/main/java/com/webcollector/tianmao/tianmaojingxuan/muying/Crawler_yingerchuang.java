package com.webcollector.tianmao.tianmaojingxuan.muying;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 婴儿床
 * @author Li Yongqiang
 *
 */
public class Crawler_yingerchuang extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbqtvaqi&keyword=%E5%A9%B4%E5%84%BF%E5%BA%8A&refpid=mm_10011550_0_0&clk1=83102928c5cfe4c16fde0f52a90081c9&page=";
	public Crawler_yingerchuang(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					URL+i+"&_input_charset=utf-8");
		}

	}
	public static void main(String[] args) throws Exception {
		Crawler_yingerchuang cw = new Crawler_yingerchuang("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
