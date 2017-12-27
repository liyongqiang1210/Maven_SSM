package com.webcollector.tianmao.tianmaojingxuan.meizhuang;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class Crawler_mianmo extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbkVu0qA&keyword=%E9%9D%A2%E8%86%9C&refpid=mm_10011550_0_0&clk1=f1a188eca19405d4ec2357b540b437d1&page="; 
	public Crawler_mianmo(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_mianmo cs = new Crawler_mianmo("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(10);
	}
}
