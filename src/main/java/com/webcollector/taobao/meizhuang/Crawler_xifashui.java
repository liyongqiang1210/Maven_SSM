package com.webcollector.taobao.meizhuang;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_xifashui extends TaoBaoCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbJMPf2y&keyword=%E6%B4%97%E5%8F%91%E6%B0%B4&refpid=mm_10011550_0_0&clk1=e06ad806e2c0233bf789601c86a80a97&page="; 
	public Crawler_xifashui(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_xifashui cs = new Crawler_xifashui("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(10);
	}
}
