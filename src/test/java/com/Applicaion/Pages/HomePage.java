package com.Applicaion.Pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genericmethods.GenericMethods;


public class HomePage extends GenericMethods{
	
	@FindBy(how=How.XPATH,using="//a[@id='webklipper-publisher-widget-container-notification-close-div']")
	public static  WebElement btn_close;
	
	@FindBy(how=How.XPATH,using="//div[@id='root']/div/div/div/div/ul/li[6]")
	public static WebElement window_login;
	
	@FindBy(how=How.XPATH,using="//input[@type='text'and @id='username']")
	public static WebElement txt_username;
	
	@FindBy(how=How.XPATH,using="//input[@type='password'and @id='password']")
	public static WebElement txt_password;
	
	@FindBy(how=How.XPATH,using="//button[@id='allow']")
	public static WebElement btn_alert;
	
	@FindBy(how=How.XPATH,using="//button/span[text()='Login']")
	public static WebElement btn_login;
	
	@FindBy(how = How.XPATH, using = "(//div[@id='root']//ul)[2]//li/a/span[2]")
	public static List<WebElement> keys_Navigation;
	
	@FindBy(how = How.XPATH, using = "//li[text()='Round Trip']")
	public static WebElement btn_rounnd_Trip;
	
	@FindBy(how=How.XPATH,using="//li[text()='Oneway']")
	public static WebElement btn_OneWayTrip;
	
	@FindBy(how=How.XPATH,using="//li[text()='Multi City']")
	public static WebElement btn_MultiCity;
	
	@FindBy(how = How.XPATH, using = "//input[@id='fromCity']")
	public static WebElement tbx_From_City;

	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[3]")
	public static WebElement tbx_To_City;

	@FindBy(how=How.XPATH,using="//p[text()='SUGGESTIONS ']")
	public static WebElement txt_suggestion;
	
	@FindBy(how = How.XPATH, using = "//p[normalize-space(text())='SUGGESTIONS']"
			+ "//parent::div//following-sibling::ul/li/div/div/p[1]")
	public static List<WebElement> keys_Suggestions;

	@FindBy(how = How.XPATH, using = "//span[text()='DEPARTURE']")
	public static WebElement Date_calender;

	@FindBy(how = How.XPATH, using = "//a[text()='Search']")
	public static WebElement btn_search;

	// ***************************************INITIALIZE_ELEMENTS****************************************************//
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	// *********************************************METHODS*****************************************************//
	// *******************************************************************************************//
	/*
	 * Method Name :=login_account() 
	 * Input_Parameters := NA
	 * OutPut_Parameters:= NA 
	 * Designer := SHAMSHEER KHAN 
	 * Sprint := #
	 */
	// ***********************************************************************************************//
		public void login_account(){
			String userName=prop.getProperty("user_id");
			String password=prop.getProperty("password");
			hoverAndClick(window_login);
			hoverAnElement(txt_username);
			txt_username.sendKeys(userName);
			hoverAnElement(txt_password);
			txt_password.sendKeys(password);
			//hoverAndClick(btn_alert);
			hoverAndClick(btn_login);
			
		}
	// *******************************************************************************************//
	/*
	 * Method Name :=select_MMT_Menu() 
	 * Input_Parameters := menu name
	 * OutPut_Parameters:= NA 
	 * Designer := SHAMSHEER KHAN 
	 * Sprint := #
	 */
	// ***********************************************************************************************//

	public void select_MMT_Menu() {
		String menu=prop.getProperty("Navigationn_Menu_name");
		for (WebElement e : keys_Navigation) {
			if (e.getText().equalsIgnoreCase(menu)) {
				hoverAndClick(e);
				break;
			}
		}
	}
	// **************************************************************************************************//
	/*
	 * Method Name :=select_Trip() 
	 * Input_Parameters := 
	 * OutPut_Parameters:= NA 
	 * Designer := SHAMSHEER KHAN 
	 * Sprint := #
	 */
	// ***********************************************************************************************//

	public void select_Trip() {
		String Trip_type=prop.getProperty("Trip_type");
		if (Trip_type.equalsIgnoreCase("RoundTrip")) {
			btn_rounnd_Trip.click();
			
		} else if (Trip_type.equalsIgnoreCase("OneWay")) {
			btn_OneWayTrip.click();
		
		} else {
			btn_MultiCity.click();
			
		}
	}
	// **************************************************************************************************//
	/*
	 * Method Name :=enterFromCity 
	 * Input_Parameters := NA
	 * OutPut_Parameters:= NA 
	 * Designer := SHAMSHEER KHAN 
	 * Sprint := #
	 */
	// ***********************************************************************************************//

	public boolean enterFromCity() {

		boolean flag = false;
		String FromCityName = prop.getProperty("From_City");
		tbx_From_City.sendKeys(FromCityName, Keys.ENTER);
		Explicitwait(10, txt_suggestion);

		for (WebElement e : keys_Suggestions) {

			if (e.getText().toUpperCase().contains(FromCityName.toUpperCase())) {
				e.click();

				flag = true;
				break;
			}
		}

		return flag;

	}
	// **************************************************************************************************//
	/*
	 * Method Name :=enterToCity 
	 * Input_Parameters := NA 
	 * OutPut_Parameters:= NA
	 * Designer := SHAMSHEER KHAN 
	 * Sprint := #
	 */
	// ***********************************************************************************************//
	public boolean EnterToCity() {

		boolean flag = false;
		String ToCityName=prop.getProperty("To_City");
		//tbx_To_City.sendKeys(Keys.TAB);
		tbx_To_City.sendKeys(ToCityName, Keys.ENTER);
		Explicitwait(10, txt_suggestion);
		
		for (WebElement e : keys_Suggestions) {

			if (e.getText().toUpperCase().contains(ToCityName.toUpperCase())) {
				e.click();
				
				flag = true;
				break;
			}
		}

		return flag;

	}
	//**************************************************************************************************//
	/*
	 * Method Name :=DatePicker 
	 * Input_Parameters := NA 
	 * OutPut_Parameters:= NA
	 * Designer := SHAMSHEER KHAN 
	 * Sprint := #
	 */
	// ***********************************************************************************************//
	public boolean DatePicker() {
		int days_gap = Integer.parseInt(prop.getProperty("Days_Gap"));
		boolean StatusFlag = false;
		Date date1 = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date1);

		c.add(Calendar.DATE, days_gap); // Adding User defined Days in current
										// date. this is arrival date.

		Date date2 = c.getTime();

		SimpleDateFormat formatNowDay = new SimpleDateFormat("dd");
		SimpleDateFormat formatNowMonth = new SimpleDateFormat("MMMM");
		SimpleDateFormat formatNowYear = new SimpleDateFormat("YYYY");
		String Day1 = formatNowDay.format(date1);
		String Month1 = formatNowMonth.format(date1);
		String Year1 = formatNowYear.format(date1);
		if (Day1.startsWith("0")) {
			Day1 = Day1.substring(1);
		}

		String Day2 = formatNowDay.format(date2);
		String Month2 = formatNowMonth.format(date2);
		String Year2 = formatNowYear.format(date2);
		if (Day2.startsWith("0")) {
			Day2 = Day2.substring(1);
		}
		try {
			Date_calender.click();
			String Departure_date_xpath = "//div[@role='heading']/div[text()='" + Month1 + "']" + "/span[text()='" + Year1
					+ "']//../../following-sibling::div[@role='rowgroup'][2]" + "/div//p[text()='" + Day1 + "']/../..";
			//picking Departure date from calendar
			WebElement deprt_date=driver.findElement(By.xpath(Departure_date_xpath));
			if(deprt_date.isDisplayed()){
				hoverAndClick(deprt_date);
			}
			
			String return_jr_date_xpath = "//div[@role='heading']/div[text()='" + Month2 + "']" + "/span[text()='"
					+ Year2 + "']//../../following-sibling::div[@role='rowgroup'][2]/div//p[text()='" + Day2
					+ "']/../..";
			//picking Return Journey date from calendar
			WebElement return_jr_date=driver.findElement(By.xpath(return_jr_date_xpath));
			if(return_jr_date.isDisplayed()){
				hoverAndClick(return_jr_date);	
				
			}
			
			StatusFlag = true;
		} catch (Exception e) {

		}

		return StatusFlag;

	}
	//************************************************************************************************//
	/*
	 * Method Name :=clickSearch 
	 * Input_Parameters := NA 
	 * OutPut_Parameters:= NA
	 * Designer := SHAMSHEER KHAN 
	 * Sprint := #
	 */
	// ***********************************************************************************************//
	public FlightResultPage clickSearch(){
		hoverAndClick(btn_search);
		return new FlightResultPage();
	}
	//****************************************************************************************************//	
}
