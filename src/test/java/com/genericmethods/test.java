package com.genericmethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		Date date1 = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date1);

		c.add(Calendar.DATE, 25); // Adding 7 Days in current date. this is arrival date.

		Date date2 = c.getTime();
		System.out.println(date1+" "+date2);
		SimpleDateFormat formatNowDay = new SimpleDateFormat("dd");
		SimpleDateFormat formatNowMonth = new SimpleDateFormat("MMMM");
		SimpleDateFormat formatNowYear = new SimpleDateFormat("YYYY");
		String Day1 = formatNowDay.format(date1);
		String Month1 = formatNowMonth.format(date1);
		String Year1 = formatNowYear.format(date1);
		if (Day1.startsWith("0")) {
			Day1 = Day1.substring(1);
		}
		System.out.println(Day1+" "+Month1+" "+Year1);
		
		System.out.println("*************************************");
		String Day2 = formatNowDay.format(date2);
		String Month2 = formatNowMonth.format(date2);
		String Year2 = formatNowYear.format(date2);
		if (Day2.startsWith("0")) {
			Day2 = Day2.substring(1);
		}
		System.out.println(Day2+" "+Month2+" "+Year2);
	}

}
