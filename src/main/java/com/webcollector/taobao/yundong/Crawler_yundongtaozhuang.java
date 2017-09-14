package com.webcollector.taobao.yundong;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 运动套装
 * @author Li Yongqiang
 *
 */
public class Crawler_yundongtaozhuang extends TaoBaoCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbZ9Cv1k&keyword=%E8%BF%90%E5%8A%A8%E5%A5%97%E8%A3%85&refpid=mm_10011550_0_0&clk1=dcc16fd5004a07fcd41c511dbb916c33&page=";

	public Crawler_yundongtaozhuang(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}

	}
	public static void main(String[] args) throws Exception {
		Crawler_yundongtaozhuang cw = new Crawler_yundongtaozhuang("crawl", true);
		cw.setThreads(10);
		cw.setTopN(10000);
		cw.start(10);

	}

}
