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

	/**
	 * 获取今天的年月日
	 * 
	 * @return
	 */
	public String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		return sdf.format(date);
	}

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		System.out.println(sdf.format(date));
	}
}
