package com.webcollector.tianmao.tianmaojingxuan.meishi;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 巧克力
 * @author Li Yongqiang
 *
 */
public class Crawler_qiaokeli extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbsGMMeX&keyword=%E5%B7%A7%E5%85%8B%E5%8A%9B&refpid=mm_10011550_0_0&clk1=4e5342122ed6062e49c15d166245c163&page="; 
	public Crawler_qiaokeli(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_qiaokeli cs = new Crawler_qiaokeli("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(20);
	}
}
