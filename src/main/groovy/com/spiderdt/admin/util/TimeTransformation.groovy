package com.spiderdt.admin.util

import java.text.ParseException
import java.text.SimpleDateFormat

public class TimeTransformation {
	public static String utcToGMT8(String time) {
		if (time.contains(".")) {
			time = time.substring(0, time.indexOf("."));
		}
		time = time.replace("T", " ");

		SimpleDateFormat utcFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date date = null;
		try {
			date = utcFormater.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// utcFormater.parse("time");
		SimpleDateFormat localFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		localFormater.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));

		String localTime = localFormater.format(date.getTime());
		return localTime;
	}
}
