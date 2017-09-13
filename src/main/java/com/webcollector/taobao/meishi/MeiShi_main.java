package com.webcollector.taobao.meishi;

public class MeiShi_main {
	
	public static void main(String[] args) throws Exception {
		Crawler_kafei cs = new Crawler_kafei("crawl", true);
		cs.setThreads(10);
		cs.setTopN(10000);
		cs.start(20);
		
		Crawler_chaye cc = new Crawler_chaye("crawl", true);
		cc.setThreads(10);
		cc.setTopN(10000);
		cc.start(20);
		
		Crawler_lingshi cl = new Crawler_lingshi("crawl", true);
		cl.setThreads(10);
		cl.setTopN(1000);
		cl.start(20);
		
		Crawler_qiaokeli cq = new Crawler_qiaokeli("crawl", true);
		cq.setThreads(10);
		cq.setTopN(10000);
		cq.start(20);
		
		Crawler_shuiguo csg = new Crawler_shuiguo("crawl", true);
		csg.setThreads(10);
		csg.setTopN(10000);
		csg.start(20);
		
		Crawler_xiaoguancha cx = new Crawler_xiaoguancha("crawl", true);
		cx.setThreads(10);
		cx.setTopN(10000);
		cx.start(20);
	}

}
