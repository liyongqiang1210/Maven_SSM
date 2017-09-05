package com.webcollector.sina.international;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webcollector.sina.domestic.domestic_main;
import com.webcollector.util.DateUtil;

public class international_main {

	public static void main(String[] args) throws Exception {
		
		Log log = LogFactory.getLog(domestic_main.class);
		log.debug("开始运行时间"+new DateUtil().getToday());
		Crawler_hqqw cs = new Crawler_hqqw("crawl", true);
		cs.setThreads(2);
		cs.setTopN(500);
		cs.start(5);
		
		Crawler_hqsy cs2 = new Crawler_hqsy("crawl", true);
		cs2.setThreads(2);
		cs2.setTopN(500);
		cs2.start(5);
		//有问题未处理
	/*	Crawler_gjgd cs3 = new Crawler_gjgd("crawl", true);
		cs3.setThreads(2);
		cs3.setTopN(100);
		cs3.start(5);*/
	}
}
