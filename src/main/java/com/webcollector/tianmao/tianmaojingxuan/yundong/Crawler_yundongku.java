package com.webcollector.tianmao.tianmaojingxuan.yundong;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 运动裤
 * @author Li Yongqiang
 *
 */
public class Crawler_yundongku extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025db9jFBIg&keyword=%E8%BF%90%E5%8A%A8%E8%A3%A4&refpid=mm_10011550_0_0&clk1=200e59799263c153734b117a75bc5603&page=";

	public Crawler_yundongku(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}

	}
	
	public static void main(String[] args) throws Exception {
		Crawler_yundongku cw = new Crawler_yundongku("crawl", true);
		cw.setThreads(10);
		cw.setTopN(10000);
		cw.start(10);

	}

}
