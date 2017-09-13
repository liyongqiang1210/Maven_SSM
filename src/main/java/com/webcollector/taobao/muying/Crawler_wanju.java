package com.webcollector.taobao.muying;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_wanju extends TaoBaoCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbfzVskX&keyword=%E7%8E%A9%E5%85%B7&refpid=mm_10011550_0_0&clk1=4ce743de44b73fa8869bb6c862cfabbc&page=";
	public Crawler_wanju(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					URL+i+"&_input_charset=utf-8");
		}

	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Crawler_wanju cw = new Crawler_wanju("crawl", true);
		cw.setThreads(10);
		cw.setTopN(10000);
		cw.start(20);

	}

}
