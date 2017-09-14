package com.webcollector.taobao.meishi;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 零食
 * @author Li Yongqiang
 *
 */
public class Crawler_lingshi extends TaoBaoCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbCS6z20&keyword=%E9%9B%B6%E9%A3%9F&refpid=mm_10011550_0_0&clk1=131fdcd6c6f95102c9253dec72383c9d&page="; 
	public Crawler_lingshi(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_lingshi cs = new Crawler_lingshi("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(20);
	}
}
