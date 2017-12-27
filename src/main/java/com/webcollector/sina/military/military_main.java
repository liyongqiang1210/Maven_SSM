package com.webcollector.sina.military;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webcollector.sina.domestic.domestic_main;
import com.webcollector.util.DateUtil;

public class military_main {

	public static void main(String[] args) throws Exception {
		
		Log log = LogFactory.getLog(domestic_main.class);
		log.debug("开始运行时间"+new DateUtil().getToday());
		Crawler_gjjq cg = new Crawler_gjjq("crawl_gjjq", true);
		cg.setThreads(2);
		cg.setTopN(100);
		cg.start(5);
		Crawler_jssd cj = new Crawler_jssd("crawl_jssd", true);
		cj.setThreads(2);
		cj.setTopN(100);
		cj.start(5);
		Crawler_zgjq nc = new Crawler_zgjq("crawl_zgjq", true);
		nc.setThreads(2);
		nc.setTopN(100);
		nc.start(7);
	}
}
