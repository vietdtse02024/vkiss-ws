package com.fyvi.ws.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {
	
	public static String PATERN_YYYYMMDDhhmmss = "YYYYMMDDhhmmss";
	public static String PATERN_YYYY_MM_DDhhmmss = "YYYY/MM/DD hh:mm:ss";
	public static String formatDateToString(Date inputDate, String pattern){
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(inputDate);
	}
}
