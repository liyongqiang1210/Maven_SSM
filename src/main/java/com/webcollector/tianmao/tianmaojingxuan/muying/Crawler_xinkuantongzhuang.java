package com.webcollector.tianmao.tianmaojingxuan.muying;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 新款童装
 * @author Li Yongqiang
 *
 */
public class Crawler_xinkuantongzhuang extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbiwXDXt&keyword=%E7%AB%A5%E8%A3%85%E6%96%B0%E6%AC%BE&refpid=mm_10011550_0_0&clk1=1ff479af196be6bad8fcb154eb134ead&page=";
	public Crawler_xinkuantongzhuang(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					URL+i+"&_input_charset=utf-8");
		}

	}
	public static void main(String[] args) throws Exception {
		Crawler_xinkuantongzhuang cw = new Crawler_xinkuantongzhuang("crawl", true);
		cw.setThreads(10);
		cw.setTopN(10000);
		cw.start(20);

	}

}
