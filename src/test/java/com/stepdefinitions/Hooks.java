package com.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.genericmethods.GenericMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;



public class Hooks extends GenericMethods {
	Scenario scenario;

	@Before
	public void setup(Scenario scenario) {
		this.scenario = scenario;
		System.out.println("**************************************************************");
		System.out.println("Test Environment set up");
		System.out.println("___________________________________________");
		System.out.println("Executing Scenario : " + scenario.getName());

	}
	

	@After
	public void tearBrowser(Scenario scenario) {
		scenario.write("Finished scenario");
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
		System.out.println("Test Environment Destroyed ");
		System.out.println("*************************************************************************");
		
		}
	
}
