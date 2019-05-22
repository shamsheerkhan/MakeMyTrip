package com.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.MakeExtentReport;

public class Hooks {
	@Before
	public void initialize_report() {
		
		MakeExtentReport.initialize_Report();
		MakeExtentReport.startReport("summary");
	}
	
	@After
	public void publishReport() {
		
		MakeExtentReport.endReport();
		
	}
	

	
	
	}
