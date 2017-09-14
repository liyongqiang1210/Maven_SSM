package com.webcollector.tianmao.tianmaojingxuan.jiaju;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 电脑桌
 * @author Li Yongqiang
 *
 */
public class Crawler_diannaozhuo extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbpBv3qw&keyword=%E7%94%B5%E8%84%91%E6%A1%8C&refpid=mm_10011550_0_0&clk1=faeba818ef51bbe7791b340c2f0c6c55&page="; 
	public Crawler_diannaozhuo(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_diannaozhuo cs = new Crawler_diannaozhuo("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(10);
	}
}
