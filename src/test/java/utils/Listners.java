package utils;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.genericmethods.GenericMethods;


public class Listners extends GenericMethods implements ITestListener{
	

    private ExtentTest ParentextentTest;
    private ExtentTest ChildExtentTest;


	@Override
	public void onTestStart(ITestResult result) {
		    System.out.println((result.getMethod().getMethodName() + " started!"));
	       
		    if(Arrays.asList(result.getParameters()).size()==0)
	        ChildExtentTest = ParentextentTest.createNode(result.getName());
		    else {
		    	ChildExtentTest = ParentextentTest.createNode(result.getName()+Arrays.asList(result.getParameters()).toString());
		    }
	        test.set(ChildExtentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
        try {
			test.get().addScreenCaptureFromPath(captureScreenShot());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String takeScreenShot = null;
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		try {
			takeScreenShot = captureScreenShot();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        test.get().fail(result.getThrowable());
        try {
			test.get().addScreenCaptureFromPath(takeScreenShot);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		
        
        if(result.getThrowable()==null) {
	            test.get().skip("Dependant tests failed");
	      }else {
	    	  test.get().skip(result.getThrowable());
	    }
}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Extent Reports Version 3 Test Suite started!");
        ParentextentTest = extent.createTest(context.getName());

		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
		
	}
	
	 
	
	
}
