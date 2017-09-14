package com.webcollector.taobao.jiaju;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_yigui extends TaoBaoCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbOVVIEL&keyword=%E8%A1%A3%E6%9F%9C&refpid=mm_10011550_0_0&clk1=0824062942c5ae1aea5d6fdc87b17d92&page="; 
	public Crawler_yigui(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_yigui cs = new Crawler_yigui("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(10);
	}
}
