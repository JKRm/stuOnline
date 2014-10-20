package com.shanda.linglong.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateUtil {
	
	/**
	 * 将日期date转换成相应格式
	 * @param date 时间
	 * @return yyyy-MM-dd
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * 将日期-时间装换成相应格式
	 * @param date 时间
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String dateTimeToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * 将当前日期date转换成相应格式
	 * @return yyyy-MM-dd
	 */
	public static String currentDateToString() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * 将当前日期-时间装换成相应格式
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String currentDateTimeToString() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * 将指定日期装换成指定格式
	 * @param date 时间
	 * @param format 指定格式
	 * @return 
	 */
	public static String dateTimeToString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format); 
		String time = sdf.format(date);
		return time;
	}
	
	public static String fileNameFromDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS"); 
		String time = sdf.format(date);
		double random = new Random().nextDouble() * 1000;
		int temp = (int) random;
		return time + String.valueOf(temp);
	}
}
