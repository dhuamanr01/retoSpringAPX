package com.apx.ejemploAPX.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateUtil {

	
	  public static LocalDateTime getDateTimeFormat(){
		  
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"); 
		String fechaISO = df.format(new Date());
		LocalDateTime fechaActual = LocalDateTime.parse(fechaISO);
		  
		    return fechaActual;
	 }
	
}
