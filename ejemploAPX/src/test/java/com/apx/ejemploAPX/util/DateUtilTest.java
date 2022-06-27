package com.apx.ejemploAPX.util;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateUtilTest {

//	@SuppressWarnings("static-access")
	@Test
	public void getDateTimeFormatTest() {
		
		DateUtil dateUtil = new DateUtil();
		
		assertNotNull(dateUtil.getDateTimeFormat());
		
	}
	
}
