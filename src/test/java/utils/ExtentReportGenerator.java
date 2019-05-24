package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Platform;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.genericmethods.GenericMethods;

public class ExtentReportGenerator extends GenericMethods {

	private static ExtentReports extent;
	private static Platform platform;
	private static String reportFileName = "ExtentReports-Version3-Test-Automaton-Report" + intime + ".html";
	private static String macPath = System.getProperty("user.dir") + "/Results/" + inDate;
	private static String windowsPath = System.getProperty("user.dir") + "\\Results\\" + inDate;
	private static String macReportFileLoc = macPath + "/" + reportFileName;
	private static String winReportFileLoc = windowsPath + "\\" + reportFileName;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {
		load_properties();
		platform = getCurrentPlatform();
		String fileName = getReportFileLocation(platform);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.setAppendExisting(false);
		// htmlReporter.
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);

		extent = new ExtentReports();

		extent.setSystemInfo("Testing Application URL", prop.getProperty("URL"));
		extent.setSystemInfo("Browser Name", prop.getProperty("browsername"));

		extent.setSystemInfo("OS", OS);
		extent.setSystemInfo("Host Name", System.getProperty("user.name"));
		extent.setSystemInfo("Java Version", System.getProperty("java.version"));

		extent.attachReporter(htmlReporter);
		// extent.set

		return extent;
	}

	// Select the extent report file location based on platform
	private static String getReportFileLocation(Platform platform) {
		String reportFileLocation = null;
		switch (platform) {
		case MAC:
			reportFileLocation = macReportFileLoc;
			createReportPath(macPath);
			System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
			break;
		case WINDOWS:
			reportFileLocation = winReportFileLoc;
			createReportPath(windowsPath);
			System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
			break;
		default:
			System.out.println("ExtentReport path has not been set! There is a problem!\n");
			break;
		}
		return reportFileLocation;
	}

	// Create the report path if it does not exist
	private static void createReportPath(String path) {

		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!");
			} else {
				System.out.println("Failed to create directory: " + path);
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
	}

	// Get current platform
	private static Platform getCurrentPlatform() {
		if (platform == null) {
			String operSys = OS.toLowerCase();
			if (operSys.contains("win")) {
				platform = Platform.WINDOWS;
			} else if (operSys.contains("nix") || operSys.contains("nux") || operSys.contains("aix")) {
				platform = Platform.LINUX;
			} else if (operSys.contains("mac")) {
				platform = Platform.MAC;
			}
		}
		return platform;
	}

	// ***************************************************************************************************//
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
			Reporter.log(Description);
			test.get().log(Status.PASS, Description);

			try {
				test.get().addScreenCaptureFromPath(captureScreenShot());

			} catch (IOException e) {
				e.printStackTrace();
			}

			break;
		case "fail":
			Reporter.log(Description);
			test.get().log(Status.FAIL, Description);

			try {
				test.get().addScreenCaptureFromPath(captureScreenShot());

			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case "skip":
			Reporter.log(Description);
			test.get().log(Status.SKIP, Description);

			break;
		case "warning":
			Reporter.log(Description);
			test.get().log(Status.WARNING, Description);
			break;
		case "log_pass":
			Reporter.log(Description);
			test.get().log(Status.PASS, Description);
			break;
			
		case "log_fail":
			Reporter.log(Description);
			test.get().log(Status.FAIL, Description);
			break;	
		}
	}
	// ************************************************************************************************//

}
