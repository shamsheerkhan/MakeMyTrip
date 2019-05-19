package com.stepdefinitions;



import com.genericmethods.GenericMethods;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.MakeExtentReport;



public class Common_Annotations {
	
	

	
	
	@Before
	public void initialize_report() {
		
		MakeExtentReport.initialize_Report();
		MakeExtentReport.startReport("summary");
	}
	
	@After
	public void pulishReport() {
		
		MakeExtentReport.endReport();
	}

}
