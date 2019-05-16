package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.cucumber.listener.Reporter;
import com.genericmethods.GenericMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MakeExtentReport {
public static ExtentReports reports;
public static ExtentTest test;
static String temppath="";
public static String OS = System.getProperty("os.name");
	// *******************************************************************************//
	/*
	 * Method Name := captureScreenShot()
	 * 
	 * Input Parameter := NA
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer #:= shamsheer
	 * 
	 * Sprint #:=
	 */
	// ********************************************************************************//
	public static String captureScreenShot() {
		// Take screenshot and store as a file format
		String Dest=null;
		try {
			String ScreenshotName;
			DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
			String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
			DateTimeStamp = DateTimeStamp.replace(",", "");
			DateTimeStamp = DateTimeStamp.replace(" ", "_");
			DateTimeStamp = DateTimeStamp.replace(":", "_");
			ScreenshotName = DateTimeStamp.toString();
			TakesScreenshot ts = (TakesScreenshot) GenericMethods.driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			if (OS.toUpperCase().contains("WINDOWS")) {
			Dest= System.getProperty("user.dir") + "\\screenshots\\" + ScreenshotName + "\\"
					+ System.currentTimeMillis()+".png";
			}else if (OS.toUpperCase().contains("MAC")) {
				Dest= System.getProperty("user.dir") + "//screenshots//" + ScreenshotName + "//"
						+ System.currentTimeMillis()+".png";	
			}
			File destination = new File(Dest);
			FileUtils.copyFile(source, destination);

			return Dest;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	// ***********************************************************************************//
	// *******************************************************************************//
	/*
	 * Method Name := logStatus()
	 * 
	 * Input Parameter := Status Description
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer #:= shamsheer
	 * 
	 * Sprint #:=
	 */
	// ********************************************************************************//
	public static void logStatus(String status, String Description) {
		switch (status.toLowerCase()) {
		case "pass":
			test.log(LogStatus.PASS, Description+test.addScreenCapture(captureScreenShot()));
			break;
		case "fail":
			test.log(LogStatus.FAIL, Description+test.addScreenCapture(captureScreenShot()));
			break;
		case "warning":
			test.log(LogStatus.WARNING, Description+test.addScreenCapture(captureScreenShot()));
			break;
		}
	}
	// *********************************************************************************************

	// *******************************************************************************//
	/*
	 * Method Name := startReport()
	 * 
	 * Input Parameter := Testanme
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer #:= shamsheer
	 * 
	 * Sprint #:=
	 */
	// ********************************************************************************//
	public static void startReport(String testname) {
		test=reports.startTest(testname);
	}
	//************************************************************************************
	// *******************************************************************************//
		/*
		 * Method Name := initialize_Report()
		 * 
		 * Input Parameter := Testanme
		 * 
		 * OutPut Parameter := NA
		 * 
		 * Designer #:= shamsheer
		 * 
		 * Sprint #:=
		 */
		// ********************************************************************************//
		public static void initialize_Report() {
			if (OS.toUpperCase().contains("WINDOWS")) {
			reports=new ExtentReports(setup()+"\\myreport.html");
			}
			else if (OS.toUpperCase().contains("MAC")) {
				reports=new ExtentReports(setup()+"//myreport.html");	
			}
			reports.addSystemInfo("User Name", System.getProperty("user.name"));
			reports.addSystemInfo("Time Zone", System.getProperty("user.timezone"));
			reports.addSystemInfo("Machine", "Windows 10"+" "+"64 Bit");
			reports.addSystemInfo("Selenium", "3.141.59");
			reports.addSystemInfo("Maven", "3.5.2");
			reports.addSystemInfo("Java Version", "1.8.0_191");
		
		}
		//************************************************************************************
		public static String setup() {
			String resultpath = null;
			SimpleDateFormat d = new SimpleDateFormat("HH:mm:ss");
			String timestamp = d.format(Calendar.getInstance().getTime());
			timestamp=timestamp.replace(":", "_");
			if (OS.toUpperCase().contains("WINDOWS")) {
				resultpath=System.getProperty("user.dir")+"\\Results\\";
			}else if (OS.toUpperCase().contains("MAC")) {
				resultpath=System.getProperty("user.dir")+"//Results//";
			}
		    File f=new File(resultpath, timestamp);
		    if(f.exists()==false) {
		    	f.mkdir();}
		    temppath=resultpath+timestamp;
		   return temppath;
		}
		//************************************************************************************************
		public static void endReport() {
			reports.endTest(test);
			reports.flush();
		}
}
