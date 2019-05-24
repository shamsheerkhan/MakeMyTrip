package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



import com.genericmethods.GenericMethods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReleventMakeExtentReport extends GenericMethods{
public static ExtentReports reports;
public static ExtentTest test;
static String temppath="";

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
			String ScreenshotName = inDate.toString();
			TakesScreenshot ts = (TakesScreenshot) GenericMethods.driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			if (OS.toUpperCase().contains("WINDOWS")) {
			Dest= System.getProperty("user.dir") + "\\screenshots\\" + ScreenshotName + "\\"
					+intime+"\\"+ System.currentTimeMillis()+".png";
			}else if (OS.toUpperCase().contains("MAC")) {
				Dest= System.getProperty("user.dir") + "//screenshots//" + ScreenshotName + "//"
					+intime+"\\"+ System.currentTimeMillis()+".png";	
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
			load_properties();
			if (OS.toUpperCase().contains("WINDOWS")) {
			reports=new ExtentReports(setup()+"\\myreport"+intime+".html");
			}
			else if (OS.toUpperCase().contains("MAC")) {
				reports=new ExtentReports(setup()+"//myreport"+intime+".html");	
			}
			reports.addSystemInfo("Host Name", System.getProperty("user.name"));
			reports.addSystemInfo("Time Zone", System.getProperty("user.timezone"));
			reports.addSystemInfo("Testing Application URL", prop.getProperty("URL"));
			reports.addSystemInfo("Browser Name", prop.getProperty("browsername"));
			reports.addSystemInfo("Selenium", "3.141.59");
			reports.addSystemInfo("Maven", "3.5.2");
			reports.addSystemInfo("Java Version", System.getProperty("java.version"));
			
		}
		//************************************************************************************
		public static String setup() {
			String resultpath = null;
			
			if (OS.toUpperCase().contains("WINDOWS")) {
				resultpath=System.getProperty("user.dir")+"\\Results\\";
			}else if (OS.toUpperCase().contains("MAC")) {
				resultpath=System.getProperty("user.dir")+"//Results//";
			}
		    File f=new File(resultpath, inDate);
		    if(f.exists()==false) {
		    	f.mkdir();}
		    temppath=resultpath+inDate;
		   return temppath;
		}
		//************************************************************************************************
		public static void endReport() {
			reports.endTest(test);
			reports.flush();
		}
}
