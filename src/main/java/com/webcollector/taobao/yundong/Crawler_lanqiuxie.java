package com.webcollector.taobao.yundong;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 篮球鞋
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_lanqiuxie extends TaoBaoCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbvrY0xQ&keyword=%E7%AF%AE%E7%90%83%E9%9E%8B&refpid=mm_10011550_0_0&clk1=30972be171b9247996d94eed679601c9&page=";

	public Crawler_lanqiuxie(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}

	}

	public static void main(String[] args) throws Exception {
		Crawler_lanqiuxie cw = new Crawler_lanqiuxie("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
