package com.genericmethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class test extends GenericMethods{
	
public static void main(String[] args) {
	
	String[] rawDate=Calendar.getInstance().getTime().toString().split(" ");
	String inDate=rawDate[0]+" "+rawDate[1]+" "+rawDate[2]+" "+rawDate[5];
	String intime=rawDate[3];
	System.out.println(inDate);
	System.out.println(intime);
	}

}
