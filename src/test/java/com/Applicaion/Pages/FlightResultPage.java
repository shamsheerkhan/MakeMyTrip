package com.Applicaion.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.genericmethods.GenericMethods;

public class FlightResultPage extends GenericMethods{

	@FindBy(how=How.XPATH,using="//div[@id='ow_domrt-jrny']//label[starts-with(@for,'splitowJourney')]")
	public static List<WebElement> departures_flights_list;
	
	@FindBy(how=How.XPATH,using="//div[@id='rt-domrt-jrny']//label[starts-with(@for,'splitrtJourney')]")
	public static List<WebElement> Return_flights_list; 
	

}
