package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.genericmethods.GenericMethods;


public class CucumberExtentReport extends GenericMethods{

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
		String Dest = null;
		try {
			String ScreenshotName = inDate.toString();
			TakesScreenshot ts = (TakesScreenshot) GenericMethods.driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			if (OS.toUpperCase().contains("WINDOWS")) {
				Dest = System.getProperty("user.dir") + "\\screenshots\\" + ScreenshotName + "\\" + intime + "\\"
						+ System.currentTimeMillis() + ".png";
			} else if (OS.toUpperCase().contains("MAC")) {
				Dest = System.getProperty("user.dir") + "/screenshots/" + ScreenshotName + "/" + intime + "/"
						+ System.currentTimeMillis() + ".png";
			}
			File destination = new File(Dest);
			FileUtils.copyFile(source, destination);

			return Dest;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	//***************************************************************************************************//
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
			Reporter.addStepLog("Pass "+Description);
			try {
				Reporter.addScreenCaptureFromPath(captureScreenShot());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			break;
		case "fail":
			Reporter.addStepLog("Fail "+Description);
			try {
				Reporter.addScreenCaptureFromPath(captureScreenShot());
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "Skip":
			Reporter.addStepLog("Skip "+Description);
			
			
			break;	
		case "warning":
			Reporter.addStepLog("Warning "+Description);
			
			break;
		}
	}
	//************************************************************************************************//
	public static String reportpath(){
		String reportpath=null;
		if(OS.toUpperCase().contains("WINDOWS")){
			reportpath=System.getProperty("user.dir")+"\\Results\\"+inDate+
				"\\myreports"+intime+".html";	
			
		}else if(OS.toUpperCase().contains("MAC")){
			reportpath=System.getProperty("user.dir")+"/Results/"+inDate+
					"/myreports"+intime+".html";		
		}
		return reportpath;
		
	}
	//*************************************************************************************************//
	
}
