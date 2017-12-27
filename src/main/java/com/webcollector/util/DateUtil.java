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
	SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
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

	public String getYMDHMS(){
		
		return sdf2.format(date);
		
	}
	public static void main(String[] args) {
		
		DateUtil d = new DateUtil();
		System.out.println(d.getYMDHMS());
	}
}
