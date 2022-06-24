package com.apx.ejemploAPX.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	  public static String getDateTimeFormat(){
		  
		String fechaActual;
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		fechaActual=simpleDate.format(new Date());
		
		return fechaActual;
	 }
	
}
