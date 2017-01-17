package com.taoyp.prac.tool;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static void main(String[] args){
		System.out.println(getDate());
		System.out.println(getStringFromNowDate("yyyymmdd"));
		System.out.println(getStringFromNowDate("yyyymmdd hhmmss"));
		System.out.println(getStringFromNowDate("yyyymmdd HHmmss"));
		testTimeStamp();
	}
	
	public static Date getDate(){
		Date date = new Date();
		return date;
	}
	
	public static String getStringFromNowDate(String format){
		SimpleDateFormat sfd = new SimpleDateFormat(format);
		Date date = new Date();
		String dateStr = sfd.format(date);
		return dateStr;
	}
	
	public static String getStringFromDate(String format, Date date){
		SimpleDateFormat sfd = new SimpleDateFormat(format);
		String dateStr = sfd.format(date);
		return dateStr;
	}
	
	public static String getDateFromString(String format, String dateStr) throws Exception{
		SimpleDateFormat sfd = new SimpleDateFormat(format);
		Date date = sfd.parse(dateStr);
		return dateStr;
	}
	
	public static String testTimeStamp(){
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(ts);
		
		ts = Timestamp.valueOf("2017-01-17 10:32:30");
		System.out.println(ts);

		Date date = new Date();
		date = ts;
		System.out.println(ts);
		
		date = new Date();
		ts = new Timestamp(date.getTime());
		System.out.println(ts);
		
		return "";
	}
}
