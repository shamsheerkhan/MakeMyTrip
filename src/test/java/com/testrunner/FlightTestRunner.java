package com.testrunner;





import cucumber.api.CucumberOptions;


import cucumber.api.testng.AbstractTestNGCucumberTests;



//@RunWith(Cucumber.class)
@CucumberOptions(
		features={"D:/sw testing/MakeMyTrip/src/test/resources/Features/flightResult.feature"},
		glue= {"com.stepdefinitions"},
		monochrome=true	)
public class FlightTestRunner extends AbstractTestNGCucumberTests{
	


	
}
