package com.genericmethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class test extends GenericMethods{
	
public static void main(String[] args) {
	
	
	Calendar c = Calendar.getInstance();
	Date date1 = c.getTime();
	c.add(Calendar.DATE, 7); // Adding User defined Days in current
									// date. this is arrival date.

	Date date2 = c.getTime();
System.out.println(date1);
System.out.println(date2);
String[] jr_day=date1.toString().split(" ");
String jr_date=jr_day[0]+" "+jr_day[1]+" "+jr_day[2]+" "+jr_day[5];
String[] rn_day=date2.toString().split(" ");
String rn_date=rn_day[0]+" "+rn_day[1]+" "+rn_day[2]+" "+rn_day[5];
System.out.println(jr_date);
System.out.println(rn_date);
	}

}
