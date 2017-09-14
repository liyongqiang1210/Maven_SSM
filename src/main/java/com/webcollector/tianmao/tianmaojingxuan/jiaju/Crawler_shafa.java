package com.webcollector.tianmao.tianmaojingxuan.jiaju;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_shafa extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbAQUXo9&keyword=%E6%B2%99%E5%8F%91&refpid=mm_10011550_0_0&clk1=c7c5bae424233869474a1024738ee917&page="; 
	public Crawler_shafa(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_shafa cs = new Crawler_shafa("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(10);
	}
}
