package com.shanda.linglong.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateUtil {
	
	/**
	 * ������dateת������Ӧ��ʽ
	 * @param date ʱ��
	 * @return yyyy-MM-dd
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * ������-ʱ��װ������Ӧ��ʽ
	 * @param date ʱ��
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String dateTimeToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * ����ǰ����dateת������Ӧ��ʽ
	 * @return yyyy-MM-dd
	 */
	public static String currentDateToString() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * ����ǰ����-ʱ��װ������Ӧ��ʽ
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String currentDateTimeToString() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * ��ָ������װ����ָ����ʽ
	 * @param date ʱ��
	 * @param format ָ����ʽ
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
