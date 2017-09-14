package com.webcollector.tianmao.tianmaojingxuan.yundong;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 运动鞋
 * @author Li Yongqiang
 *
 */
public class Crawler_yundongxie extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025db121qCu&keyword=%E8%BF%90%E5%8A%A8%E9%9E%8B&refpid=mm_10011550_0_0&clk1=adbfb9682f6128dc1d71c8f2cde0c7b4&page=";

	public Crawler_yundongxie(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					URL+i+"&_input_charset=utf-8");
		}

	}
	public static void main(String[] args) throws Exception {
		Crawler_yundongxie cw = new Crawler_yundongxie("crawl", true);
		cw.setThreads(10);
		cw.setTopN(10000);
		cw.start(10);

	}

}
