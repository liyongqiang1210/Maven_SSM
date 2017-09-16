package com.webcollector.sina.domestic;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webcollector.util.DateUtil;

public class domestic_main {

	public static void main(String[] args) throws Exception {
		
		Log log = LogFactory.getLog(domestic_main.class);
		log.debug("开始运行时间"+new DateUtil().getToday());
		//港澳台新闻
		Crawler_gatxw cg = new Crawler_gatxw("crawl_gatxw", true);
		cg.setThreads(1);
		cg.setTopN(500);
		cg.start(5);
		
		Crawler_gdxw cg2 = new Crawler_gdxw("crawl_gdxw", true);
		cg2.setThreads(1);
		cg2.setTopN(500);
		cg2.start(5);
		
		Crawler_zsfx cz = new Crawler_zsfx("crawl_zsfx", true);
		cz.setThreads(1);
		cz.setTopN(500);
		cz.start(5);
	}
}
