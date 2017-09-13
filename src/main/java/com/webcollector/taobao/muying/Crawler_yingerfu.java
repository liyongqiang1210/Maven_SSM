package com.webcollector.taobao.muying;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 婴儿服
 * @author Li Yongqiang
 *
 */
public class Crawler_yingerfu extends TaoBaoCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dblPl8iy&keyword=%E5%A9%B4%E5%84%BF%E6%9C%8D&refpid=mm_10011550_0_0&clk1=9963d84066d8a14f3900129b3235606f&page=";

	public Crawler_yingerfu(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					URL+i+"&_input_charset=utf-8");
		}

	}
	public static void main(String[] args) throws Exception {
		Crawler_yingerfu cw = new Crawler_yingerfu("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
