package com.webcollector.taobao.meishi;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 茶叶
 * @author Li Yongqiang
 *
 */
public class Crawler_chaye extends TaoBaoCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbEIoDHb&keyword=%E8%8C%B6%E5%8F%B6&refpid=mm_10011550_0_0&clk1=05a2a5a51ee749361170b4bb39f73028&page="; 
	public Crawler_chaye(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_chaye cs = new Crawler_chaye("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(20);
	}
}
