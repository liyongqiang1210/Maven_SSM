package com.webcollector.tianmao.tianmaojingxuan.nanzhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 冲锋衣
 * @author Li Yongqiang
 *
 */
public class Crawler_chongfengyi extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025db7WD7rH&keyword=%E8%BF%9E%E8%A1%A3%E8%A3%99&refpid=mm_10011550_0_0&clk1=2a87579536548c22ac327c3478abb256&page=";

	public Crawler_chongfengyi(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					URL+i+"&_input_charset=utf-8");
		}

	}
	public static void main(String[] args) throws Exception {
		Crawler_chongfengyi cw = new Crawler_chongfengyi("crawl", true);
		cw.setThreads(10);
		cw.setTopN(10000);
		cw.start(10);

	}

}
