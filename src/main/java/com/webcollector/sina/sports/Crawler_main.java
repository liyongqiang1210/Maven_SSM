package com.webcollector.sina.sports;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webcollector.util.DateUtil;

public class Crawler_main {

	public static void main(String[] args) throws Exception {

		Log log = LogFactory.getLog(Crawler_main.class);
		log.debug("运行时间"+new DateUtil().getYMDHMS());
		Crawler_guojizuqiu cs = new Crawler_guojizuqiu("crawl", true);
		cs.setThreads(1);
		cs.setTopN(1000);
		cs.start(5);
		Crawler_guoneizuqiu cs1 = new Crawler_guoneizuqiu("crawl", true);
		cs1.setThreads(1);
		cs1.setTopN(1000);
		cs1.start(5);
		Crawler_zhongguozuqiu cs2 = new Crawler_zhongguozuqiu("crawl", true);
		cs2.setThreads(2);
		cs2.setTopN(1000);
		cs2.start(5);
		Crawler_cba cba = new Crawler_cba("crawl", true);
		cba.setThreads(1);
		cba.setTopN(200);
		cba.start(5);
		Crawler_nba nba = new Crawler_nba("crawl", true);
		nba.setThreads(1);
		nba.setTopN(200);
		nba.start(5);
	}
}
