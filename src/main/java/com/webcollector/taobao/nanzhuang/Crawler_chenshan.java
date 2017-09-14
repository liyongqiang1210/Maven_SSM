package com.webcollector.taobao.nanzhuang;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 衬衫
 * @author Li Yongqiang
 *
 */
public class Crawler_chenshan extends TaoBaoCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.2.54f025dbuyFYKu&keyword=%E8%A1%AC%E8%A1%AB%E7%94%B7&refpid=mm_10011550_0_0&clk1=3fd27aa72174ff10a37d79e217d156e3&page=";

	public Crawler_chenshan(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					URL+i+"&_input_charset=utf-8");
		}	

	}

	public static void main(String[] args) throws Exception {
		Crawler_chenshan cw = new Crawler_chenshan("crawl", true);
		cw.setThreads(10);
		cw.setTopN(1000);
		cw.start(20);

	}

}
