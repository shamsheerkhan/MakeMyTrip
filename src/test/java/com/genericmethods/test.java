package com.genericmethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.ExtentReportGenerator;



public class test {
public static void main(String[] args){
	test t=new test();
	int x=5,y=5;
	System.out.println("with out using method "+(x+y));
	System.out.println("using method " +t.add());
	}
public int add(){
	int x,y;
	x=5;y=5;
	int z=x+y;
	 
	return mul(z);
	}
public int mul(int z){
	
	int x=z,y=2;
	int k;
	return (k=x*y); 
	}
}
