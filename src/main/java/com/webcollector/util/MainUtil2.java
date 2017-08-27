package com.webcollector.util;

import com.webcollector.sina.mil.roll.Crawler_gjjq;

public class MainUtil2 {

	public static void main(String[] args) {
		System.out.println("main2方法调用成功--45");
		Crawler_gjjq cs = new Crawler_gjjq("crawl", true);
		
		try {
			cs.setThreads(5);
			cs.setTopN(1000);
			cs.start(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
