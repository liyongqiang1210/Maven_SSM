package com.webcollector.tianmao.tianmaojingxuan.meishi;

import com.webcollector.tianmao.tianmaojingxuan.TianMaoJingXuanCrawler;

/**
 * 咖啡
 * @author Li Yongqiang
 *
 */
public class Crawler_kafei extends TianMaoJingXuanCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbWCwF7j&keyword=%E5%92%96%E5%95%A1&refpid=mm_10011550_0_0&clk1=06f616c5de5a57ea0db6a41be31f2d75&page="; 
	public Crawler_kafei(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_kafei cs = new Crawler_kafei("crawl", true);
		cs.setThreads(10);
		cs.setTopN(1000);
		cs.start(2);
	}
}
