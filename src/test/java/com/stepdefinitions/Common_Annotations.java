package com.stepdefinitions;



import com.genericmethods.GenericMethods;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.MakeExtentReport;


public class Common_Annotations extends GenericMethods{
	
	public static MakeExtentReport mkreports;

	
	
	@Before
	public void initialize_report() {
		
	mkreports.initialize_Report();
		mkreports.startReport("summary");
	}
	
	@After
	public void pulishReport() {
		
		mkreports.endReport();
	}
	
}
