package com.webcollector.taobao.yundong;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 钓鱼竿
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_diaoyugan extends TaoBaoCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025db1zzHXA&keyword=%E9%92%93%E7%AB%BF&refpid=mm_10011550_0_0&clk1=ae224ea65f9c1977c16976631ddc8e96&page=";

	public Crawler_diaoyugan(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}

	}

	public static void main(String[] args) throws Exception {
		Crawler_diaoyugan cw = new Crawler_diaoyugan("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
