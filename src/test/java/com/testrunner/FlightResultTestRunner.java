package com.testrunner;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = { "D:\\sw testing\\MakeMyTrip\\Features\\flightResult.feature" },
		glue = { "com.stepdefinitions" }, 
		monochrome = true)
public class FlightResultTestRunner extends AbstractTestNGCucumberTests {

}
