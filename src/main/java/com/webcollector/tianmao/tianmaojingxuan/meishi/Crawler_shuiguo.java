package com.webcollector.tianmao.tianmaojingxuan.meishi;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 水果
 * @author Li Yongqiang
 *
 */
public class Crawler_shuiguo extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbZPcY5Y&keyword=%E6%B0%B4%E6%9E%9C&refpid=mm_10011550_0_0&clk1=83eebeb9f6a8a46ffe2436ff2fdd94a3&page="; 
	public Crawler_shuiguo(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_shuiguo cs = new Crawler_shuiguo("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(20);
	}
}
