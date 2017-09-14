package com.webcollector.tianmao.tianmaojingxuan.meizhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_yanshuang extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbd5aiOp&keyword=%E7%9C%BC%E9%9C%9C&refpid=mm_10011550_0_0&clk1=252436376e308b910c0be858a99f95e3&page="; 
	public Crawler_yanshuang(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_yanshuang cs = new Crawler_yanshuang("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(10);
	}
}
