package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.genericmethods.GenericMethods;

public class Reports_utils {
	
	
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

		try {
			String ScreenshotName;
			DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
			String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
			DateTimeStamp = DateTimeStamp.replace(",", "");
			DateTimeStamp = DateTimeStamp.replace(" ", "_");
			DateTimeStamp = DateTimeStamp.replace(":", "_");
			ScreenshotName = DateTimeStamp.toString();
			TakesScreenshot ts = (TakesScreenshot)GenericMethods.driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			String Dest = System.getProperty("user.dir") +"\\screenshots\\"+ ScreenshotName +"\\"
					+ System.currentTimeMillis() + ".png";
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
			try {
				Reporter.addScreenCaptureFromPath(captureScreenShot());
				Reporter.addStepLog(Description);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			break;
		case "fail":
			try {
				Reporter.addScreenCaptureFromPath(captureScreenShot());
				Reporter.addStepLog(Description);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			break;
		case "warning":
			try {
				Reporter.addScreenCaptureFromPath(captureScreenShot());
				Reporter.addStepLog(Description);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
			break;
			}
	}
	//*********************************************************************************************
	
}
