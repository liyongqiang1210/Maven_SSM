package com.webcollector.util;

import com.webcollector.sina.society.Crawler_zqsk;

public class MainUtil {

	public static void main(String[] args) {
		System.out.println("main方法调用成功---43");
		Crawler_zqsk cs = new Crawler_zqsk("crawl", true);
		
		try {
			cs.setThreads(5);
			cs.setTopN(1000);
			cs.start(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
