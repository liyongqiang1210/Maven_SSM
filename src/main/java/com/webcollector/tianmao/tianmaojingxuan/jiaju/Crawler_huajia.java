package com.webcollector.tianmao.tianmaojingxuan.jiaju;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_huajia extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025db4ypgnu&keyword=%E8%8A%B1%E6%9E%B6&refpid=mm_10011550_0_0&clk1=72fad05fe501fbb25b6977c594b2333b&page="; 
	public Crawler_huajia(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_huajia cs = new Crawler_huajia("crawl1", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(100);
	}
}
