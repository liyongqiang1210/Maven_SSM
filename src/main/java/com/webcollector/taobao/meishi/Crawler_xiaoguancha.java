package com.webcollector.taobao.meishi;

import com.webcollector.taobao.TaoBaoCrawler;

/**
 * 小罐茶
 * @author Li Yongqiang
 *
 */
public class Crawler_xiaoguancha extends TaoBaoCrawler{

	private String url = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.1.54f025dbP1Hi0I&keyword=%E5%B0%8F%E7%BD%90%E8%8C%B6&refpid=mm_10011550_0_0&clk1=025e873c55223f2dd190865a4b300570&page="; 
	public Crawler_xiaoguancha(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					url+i+"&_input_charset=utf-8");
		}
	}


	public static void main(String[] args) throws Exception {
		Crawler_xiaoguancha cs = new Crawler_xiaoguancha("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(20);
		
	}
}
