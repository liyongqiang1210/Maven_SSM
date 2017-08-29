package com.webcollector.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author liyongqiang
 *
 */
public class DateUtil {

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

	/**
	 * 获取今天的年月日
	 * 
	 * @return
	 */
	public String getToday() {
		
		return sdf.format(date);
	}
	
	/**
	 * 获取年月
	 * @param args
	 */
	public String getYearAndMonth(){
		
		return sdf.format(date).substring(0, 7);
		
	}

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		System.out.println(sdf.format(date).substring(0, 7));
	}
}
