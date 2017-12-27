package com.webcollector.sina.society;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webcollector.sina.domestic.domestic_main;
import com.webcollector.util.DateUtil;

public class society_main {

	public static void main(String[] args) throws Exception {
		
		Log log = LogFactory.getLog(domestic_main.class);
		log.debug("开始运行时间"+new DateUtil().getToday());
		Crawler_qwys cs = new Crawler_qwys("crawl_qwys", true);
		cs.setThreads(2);
		cs.setTopN(100);
		cs.start(5);
		Crawler_shwx cs1 = new Crawler_shwx("crawl_shwx", true);
		cs1.setThreads(2);
		cs1.setTopN(100);
		cs1.start(5);
		Crawler_shyf cs11 = new Crawler_shyf("crawl_shyf", true);
		cs11.setThreads(2);
		cs11.setTopN(100);
		cs11.start(5);
		Crawler_zqsk cs111 = new Crawler_zqsk("crawl_zqsk", true);
		cs111.setThreads(2);
		cs111.setTopN(100);
		cs111.start(5);
	}
}
