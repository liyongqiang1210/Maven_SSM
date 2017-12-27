package com.webcollector.tianmao.tianmaojingxuan.meizhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_xiangshui extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbPOHFUi&keyword=%E9%A6%99%E6%B0%B4&refpid=mm_10011550_0_0&clk1=439654a1a9bd18f0306d51ac3c4c7bae&page="; 
	public Crawler_xiangshui(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_xiangshui cs = new Crawler_xiangshui("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(10);
	}
}
