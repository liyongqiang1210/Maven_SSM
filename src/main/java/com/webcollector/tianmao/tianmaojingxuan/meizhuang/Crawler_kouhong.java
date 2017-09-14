package com.webcollector.tianmao.tianmaojingxuan.meizhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_kouhong extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbF4dtSS&keyword=%E5%8F%A3%E7%BA%A2&refpid=mm_10011550_0_0&clk1=cbc07f9b159c3cab4a50143696dba4fc&page="; 
	public Crawler_kouhong(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_kouhong cs = new Crawler_kouhong("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(10);
	}
}
