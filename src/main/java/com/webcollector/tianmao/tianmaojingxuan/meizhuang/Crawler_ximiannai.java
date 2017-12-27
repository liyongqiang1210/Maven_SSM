package com.webcollector.tianmao.tianmaojingxuan.meizhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_ximiannai extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.2.54f025dbxfbzCe&keyword=%E6%B4%97%E9%9D%A2%E5%A5%B6&refpid=mm_10011550_0_0&clk1=1983ef5c5f1a55c94df5a193d6d075d3&page="; 
	public Crawler_ximiannai(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_ximiannai cs = new Crawler_ximiannai("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(10);
	}
}
