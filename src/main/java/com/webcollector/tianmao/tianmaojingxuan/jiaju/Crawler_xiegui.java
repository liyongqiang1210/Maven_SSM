package com.webcollector.tianmao.tianmaojingxuan.jiaju;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_xiegui extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.2.54f025dbrUrp0e&keyword=%E9%9E%8B%E6%9F%9C&refpid=mm_10011550_0_0&clk1=ed827e214420b72b9d3279546a8743ed&page="; 
	public Crawler_xiegui(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_xiegui cs = new Crawler_xiegui("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(10);
	}
}
