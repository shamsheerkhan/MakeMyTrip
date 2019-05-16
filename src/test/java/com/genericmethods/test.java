package com.genericmethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Applicaion.Pages.FlightResultPage;
import com.Applicaion.Pages.HomePage;

public class test extends GenericMethods{
	public static HomePage home;
	public static FlightResultPage flight;
public static void main(String[] args) {
	
	lanunchBowser();
	home = new HomePage();
	home.select_MMT_Menu();
	home.select_Trip();
	Assert.assertTrue(home.enterFromCity());
	Assert.assertTrue(home.EnterToCity());
	Assert.assertTrue(home.DatePicker());
	flight = home.clickSearch();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	toBottomOfPage();
	toUP();
	hoverAndClick(flight.departures_flights_list.get(3));
	hoverAndClick(flight.Return_flights_list.get(5));
	//span[contains(text(),'Rs')]
	WebElement e2=driver.findElement(By.xpath("//span[@class='splitVw-total-fare']/span"));
	if(e2.isDisplayed()){
		System.out.println(e2.getText());
		System.out.println(ConvertToIntPrice(e2.getText()));
	}
	}

}
