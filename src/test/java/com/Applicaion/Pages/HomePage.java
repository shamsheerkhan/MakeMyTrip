package com.Applicaion.Pages;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.genericmethods.GenericMethods;

import utils.ExtentReportGenerator;

public class HomePage extends GenericMethods {

	@FindBy(how = How.XPATH, using = "//a[@id='webklipper-publisher-widget-container-notification-close-div']")
	public WebElement btn_close;

	@FindBy(how = How.XPATH, using = "//div[@id='root']/div/div/div/div/ul/li[6]")
	public WebElement window_login;

	@FindBy(how = How.XPATH, using = "//input[@type='text'and @id='username']")
	public WebElement txt_username;

	@FindBy(how = How.XPATH, using = "//input[@type='password'and @id='password']")
	public WebElement txt_password;

	@FindBy(how = How.XPATH, using = "//button[@id='allow']")
	public WebElement btn_alert;

	@FindBy(how = How.XPATH, using = "//button/span[text()='Login']")
	public WebElement btn_login;

	@FindBy(how = How.XPATH, using = "(//div[@id='root']//ul)[2]//li/a/span[2]")
	public List<WebElement> keys_Navigation;

	@FindBy(how = How.XPATH, using = "(//div[@id='root']/div/div[2]//ul)[1]/li")
	public List<WebElement> keys_TripType;

	@FindBy(how = How.XPATH, using = "//input[@id='fromCity']")
	public WebElement tbx_From_City;

	@FindBy(how = How.XPATH, using = "(//input[@type='text'])[3]")
	public WebElement tbx_To_City;

	@FindBy(how = How.XPATH, using = "//p[text()='SUGGESTIONS ']")
	public WebElement txt_suggestion;

	@FindBy(how = How.XPATH, using = "//p[normalize-space(text())='SUGGESTIONS']"
			+ "//parent::div//following-sibling::ul/li/div/div/p[1]")
	public List<WebElement> keys_Suggestions;

	@FindBy(how = How.XPATH, using = "//span[text()='DEPARTURE']")
	public WebElement Date_calender;
	String datePicker_xpath = "//div[@aria-label='%replacable%' and @aria-disabled='false']";
	@FindBy(how = How.XPATH, using = "//a[text()='Search']")
	public WebElement btn_search;

	// ***************************************INITIALIZE_ELEMENTS****************************************************//
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// *********************************************METHODS*****************************************************//
	// *******************************************************************************************//
	/*
	 * Method Name :=login_account() Input_Parameters := NA OutPut_Parameters:=
	 * NA Designer := SHAMSHEER KHAN Sprint := #
	 */
	// ***********************************************************************************************//
	public void login_account() {
		String userName = prop.getProperty("user_id");
		String password = prop.getProperty("password");
		hoverAndClick(window_login);
		hoverAnElement(txt_username);
		txt_username.sendKeys(userName);
		hoverAnElement(txt_password);
		txt_password.sendKeys(password);
		// hoverAndClick(btn_alert);
		hoverAndClick(btn_login);

	}
	// *******************************************************************************************//
	/*
	 * Method Name :=select_MMT_Menu() Input_Parameters := menu name
	 * OutPut_Parameters:= NA Designer := SHAMSHEER KHAN Sprint := #
	 */
	// ***********************************************************************************************//

	public void select_MMT_Menu() {
		String menu = prop.getProperty("Navigationn_Menu_name");
		for (WebElement e : keys_Navigation) {
			if (e.getText().equalsIgnoreCase(menu)) {
				hoverAndClick(e);
				ExtentReportGenerator.logStatus("pass", "clicked on Tab Menu " + menu);

				break;
			}
		}
	}
	// **************************************************************************************************//
	/*
	 * Method Name :=select_Trip() 
	 * Input_Parameters := NA
	 * OutPut_Parameters:= NA
	 * Designer := SHAMSHEER KHAN 
	 * Sprint := #
	 */
	// ***********************************************************************************************//

	public boolean select_Trip() {
		boolean status = false;
		String Trip_type = prop.getProperty("Trip_type");
		for (WebElement e : keys_TripType) {
			if (e.getText().toUpperCase().contains(Trip_type.toUpperCase())) {
				hoverAndClick(e);	
				ExtentReportGenerator.logStatus("pass", "clicked on " + Trip_type);
				 status = true;
				 break;
			}
}
		return status;
	}
	// **************************************************************************************************//
	/*
	 * Method Name :=enterFromCity Input_Parameters := NA OutPut_Parameters:= NA
	 * Designer := SHAMSHEER KHAN Sprint := #
	 */
	// ***********************************************************************************************//

	public boolean enterFromCity() {

		boolean flag = false;
		String FromCityName = prop.getProperty("From_City");
		hoverAnElement(tbx_From_City);
		// hoverAndSendkeys(tbx_From_City, FromCityName);
		// tbx_From_City.sendKeys(Keys.ENTER);
		tbx_From_City.sendKeys(FromCityName, Keys.ENTER);
		ExtentReportGenerator.logStatus("pass", "Successfully entered the " + FromCityName);

		Explicitwait(10, txt_suggestion);

		for (WebElement e : keys_Suggestions) {

			if (e.getText().toUpperCase().contains(FromCityName.toUpperCase())) {
				e.click();
				ExtentReportGenerator.logStatus("pass", "selected the city from suggestions");
				flag = true;
				break;
			}
		}

		return flag;

	}

	// **************************************************************************************************//
	/*
	 * Method Name :=enterToCity Input_Parameters := NA OutPut_Parameters:= NA
	 * Designer := SHAMSHEER KHAN Sprint := #
	 */
	// ***********************************************************************************************//
	public boolean EnterToCity() {

		boolean flag = false;
		String ToCityName = prop.getProperty("To_City");
		hoverAnElement(tbx_To_City);
		tbx_To_City.sendKeys(ToCityName, Keys.ENTER);
		ExtentReportGenerator.logStatus("pass", "Successfully entered the " + ToCityName);

		Explicitwait(10, txt_suggestion);

		for (WebElement e : keys_Suggestions) {

			if (e.getText().toUpperCase().contains(ToCityName.toUpperCase())) {
				e.click();
				ExtentReportGenerator.logStatus("pass", "selected the city from suggestions");
				flag = true;
				break;
			}
		}

		return flag;

	}

	// **************************************************************************************************//
	/*
	 * Method Name :=DatePicker Input_Parameters := NA OutPut_Parameters:= NA
	 * Designer := SHAMSHEER KHAN Sprint := #
	 */
	// ***********************************************************************************************//
	public boolean DatePicker() {
		int days_gap = Integer.parseInt(prop.getProperty("Days_Gap"));
		boolean StatusFlag = false;
		Calendar c = Calendar.getInstance();
		Date date1 = c.getTime();
		c.add(Calendar.DATE, days_gap); // Adding User defined Days in current
										// date. this is arrival date.

		Date date2 = c.getTime();

		String[] jr_day = date1.toString().split(" ");
		String jr_date = jr_day[0] + " " + jr_day[1] + " " + jr_day[2] + " " + jr_day[5];
		String[] rn_day = date2.toString().split(" ");
		String rn_date = rn_day[0] + " " + rn_day[1] + " " + rn_day[2] + " " + rn_day[5];

		try {
			Date_calender.click();
			ExtentReportGenerator.logStatus("pass", "clicked on calender");

			// picking Departure date from calendar
			WebElement deprt_date = driver.findElement(get_DynamicXpath(datePicker_xpath, jr_date));
			if (deprt_date.isDisplayed()) {
				hoverAndClick(deprt_date);
				ExtentReportGenerator.logStatus("pass", "Successfully clicked on Departure Journey Date " + jr_date);

			}

			// picking Return Journey date from calendar
			WebElement return_jr_date = driver.findElement(get_DynamicXpath(datePicker_xpath, rn_date));
			if (return_jr_date.isDisplayed()) {
				hoverAndClick(return_jr_date);
				ExtentReportGenerator.logStatus("pass", "Successfully clicked on Departure Journey Date " + rn_date);

			}

			StatusFlag = true;
		} catch (Exception e) {

		}

		return StatusFlag;

	}

	// ************************************************************************************************//
	/*
	 * Method Name :=clickSearch Input_Parameters := NA OutPut_Parameters:= NA
	 * Designer := SHAMSHEER KHAN Sprint := #
	 */
	// ***********************************************************************************************//
	public FlightResultPage clickSearch() {
		hoverAndClick(btn_search);
		ExtentReportGenerator.logStatus("pass", "Successfully clicked on search button");

		return new FlightResultPage();

	}
	// ****************************************************************************************************//
}
