package com.demo.springmvc.exmaple;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

public class SimpleDateFormatTest {

	@Test
	public void getdateFormat() throws ParseException {
		Date d1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy",Locale.US);

		System.out.println(sdf.format(d1));
		
		String date = sdf.format(d1);
		
		Date currentdate = sdf.parse(date);

		System.out.println("currentdate " + currentdate.toString());
		SimpleDateFormat sdf2 = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
		System.out.println(sdf2.format(currentdate));

		//String parse = "Tue May 19 18:04:35 CST 2015";
		String parse = "Thu May 18 17:30:49 CST 2017";
		
		Date parseDate=sdf.parse(parse);
		
		System.out.println(parseDate.toString());

	}
}
