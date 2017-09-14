package com.webcollector.tianmao.tianmaojingxuan.shuma;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 耳机
 * @author liyongqiang
 *
 */
public class Crawler_erji extends TianMaoJingXuanCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbOvZbyN&keyword=%E8%80%B3%E6%9C%BA&refpid=mm_10011550_0_0&clk1=4884cc04486feb476edb6cb1e5d98ea3&page=";

	public Crawler_erji(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(URL + i + "&_input_charset=utf-8");
		}

	}

	public static void main(String[] args) throws Exception {
		Crawler_erji ce = new Crawler_erji("crawl", true);
		ce.setThreads(10);
		ce.setTopN(10000);
		ce.start(10);

	}

}
