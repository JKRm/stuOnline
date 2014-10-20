package com.shanda.linglong.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import com.shanda.linglong.model.Train_detail;
import com.shanda.linglong.service.CourseService;

public class GetPeriod {
	
	public static long getTwoDay(String sj1, String sj2) {
		
		  SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		  
		  long day = 0;
		  
		  try {
			  
		   java.util.Date date = myFormatter.parse(sj1);
		   
		   java.util.Date mydate = myFormatter.parse(sj2);
		   
		   day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
		   
		  } catch (Exception e) {
			  
		   return 0;
		  }
		  return day;
		 }
	
	
	public long getPeriod(String old){
		
		String oldDate = old.substring(0,old.lastIndexOf(" "));
		
		System.out.println(oldDate);
		
		Date now = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  
		String nowDate = dateFormat.format(now);
		
		long period = GetPeriod.getTwoDay(nowDate, oldDate);
		
		return period;
	}


}
