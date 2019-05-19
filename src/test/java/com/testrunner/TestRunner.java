package com.testrunner;

import org.junit.runner.RunWith;



import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features="Features",
		glue= {"com.stepdefinitions"},
		monochrome=true	)
public class TestRunner {
	


	
}
