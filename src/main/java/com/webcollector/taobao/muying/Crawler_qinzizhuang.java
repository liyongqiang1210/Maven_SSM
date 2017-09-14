package com.webcollector.taobao.muying;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 亲子装
 * @author Li Yongqiang
 *
 */
public class Crawler_qinzizhuang extends TaoBaoCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbfg3soT&keyword=%E4%BA%B2%E5%AD%90%E8%A3%85&refpid=mm_10011550_0_0&clk1=740c0f990d8153a403c02cb9a81f2be6&page=";
	public Crawler_qinzizhuang(String crawlPath, boolean autoParse) {
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
		Crawler_qinzizhuang cw = new Crawler_qinzizhuang("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
