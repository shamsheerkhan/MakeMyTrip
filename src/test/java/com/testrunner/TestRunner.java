package com.testrunner;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features",
		glue= {"com.stepdefinitions"},
		//plugin= {"com.cucumber.listener.ExtentCucumberFormatter:"},
		monochrome=true
		,dryRun=false
		
		
		)
public class TestRunner {
/*	@BeforeClass
	public static void setup() {
		SimpleDateFormat d = new SimpleDateFormat("HH:mm:ss");
		String timestamp = d.format(Calendar.getInstance().getTime());
		timestamp=timestamp.replace(":", "_");
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    String resultpath=System.getProperty("user.dir")+"\\output\\";
	    File f=new File(resultpath, timestamp);
	    if(f.exists()==false) {
	    	f.mkdir();}
	    String temppath=resultpath+timestamp;
	    extentProperties.setReportPath(temppath+"\\myreport.html");
	}

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(System.getProperty("user.dir")+"\\config.xml");
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10"+" "+"64 Bit");
		Reporter.setSystemInfo("Selenium", "2.53.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_191");
	}
	*/
}
