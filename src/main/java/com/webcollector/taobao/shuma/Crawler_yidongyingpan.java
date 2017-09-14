package com.webcollector.taobao.shuma;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 移动硬盘
 * 
 * @author liyongqiang
 *
 */
public class Crawler_yidongyingpan extends TaoBaoCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.2.54f025dbLEWdTG&keyword=%E7%A7%BB%E5%8A%A8%E7%A1%AC%E7%9B%98&refpid=mm_10011550_0_0&clk1=467d952ce03638b2426d5020fd9dfa60&page=";

	public Crawler_yidongyingpan(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}

	}

	public static void main(String[] args) throws Exception {
		Crawler_yidongyingpan ce = new Crawler_yidongyingpan("crawl", true);
		ce.setThreads(10);
		ce.setTopN(10000);
		ce.start(10);

	}

}
