package com.webcollector.taobao.yundong;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 万斯
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_wansi extends TaoBaoCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbkenU3k&keyword=%E4%B8%87%E6%96%AF&refpid=mm_10011550_0_0&clk1=c7ab56be7a8bef4ed570f3e0583a4ee7&page=";

	public Crawler_wansi(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}

	}

	public static void main(String[] args) throws Exception {
		Crawler_wansi cw = new Crawler_wansi("crawl", true);
		cw.setThreads(10);
		cw.setTopN(10000);
		cw.start(10);

	}

}
