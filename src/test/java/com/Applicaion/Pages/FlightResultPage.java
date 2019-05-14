package com.Applicaion.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;
import com.genericmethods.GenericMethods;

public class FlightResultPage extends GenericMethods{

	@FindBy(how = How.XPATH, using = "//div[@id='ow_domrt-jrny']//label[starts-with(@for,'splitowJourney')]")
	public static List<WebElement> departures_flights_list;

	@FindBy(how = How.XPATH, using = "//div[@id='rt-domrt-jrny']//label[starts-with(@for,'splitrtJourney')]")
	public static List<WebElement> Return_flights_list;
	@FindBy(how = How.XPATH, using = "//div[@id='fli_filter__stops']//span[text()='Non Stop']")
	public static WebElement btn_nonStop;
	@FindBy(how = How.XPATH, using = "//div[@id='fli_filter__stops']//span[text()='1 Stop']")
	public static WebElement btn_1Stop;
	@FindBy(how = How.XPATH, using = "//a[text()=' Clear All Filters']")
	public static WebElement btn_clearFilters;
	@FindBy(how=How.XPATH,using="//div[@id='fli_filter__stops']//a[text()='Reset']")
	public static WebElement btn_Reset;
//*****************************************INITIALIZE_ELEMENTS******************************************//	
public FlightResultPage(){
	PageFactory.initElements(driver, this);
}
//***********************************************METHODS************************************************//
	/*
	 * Method Name := print_flight_Records()
	 * 
	 * Input Parameter := NA
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer # := SHAMSHEER
	 * 
	 * Sprint # :=
	 */
	// **************************************************************************************************//

	public void print_flight_Records() {

		System.out.println("***************The No of flights after without any filters***************");
		System.out.println("The no. of departures flights are " + departure_Flight_count());
		System.out.println("The no. of Return flights are " + return_Flight_count());
	}

	// ********************************************************************************************************//
	public int departure_Flight_count() {
		toBottomOfPage();
		toUP();
		if (departures_flights_list.size() < 1) {
			logStatus("fail", "The flights are not found");
			try {
				throw new Exception("No Flight availabe");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return departures_flights_list.size();
	}
	//*********************************************************************************************************//
	public int return_Flight_count() {
		toBottomOfPage();
		toUP();
		if (Return_flights_list.size() < 1) {
			logStatus("fail", "The flights are not found");
			try {
				throw new Exception("No Flight availabe");
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return Return_flights_list.size();
	}	
	//**********************************************************************************************//
	/*
	 * Method Name := print_NonStop_flight_Records()
	 * 
	 * Input Parameter := NA
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer # := SHAMSHEER
	 * 
	 * Sprint # :=
	 */
	// *****************************************************************************************************//

	public void print_NonStop_flight_Records() {
	System.out.println("*************The no. of flights with Non Stop filter**********************");
	hoverAndClick(btn_Reset);
	hoverAndClick(btn_nonStop);
	System.out.println("The no. of departures flights with Non Stop filter are"+departure_Flight_count());
	System.out.println("The no. of Return flights with Non Stop filter are"+return_Flight_count());
	
	}
	//**************************************************************************************************//
	/*
	 * Method Name := print_1Stop_flight_Records()
	 * 
	 * Input Parameter := NA
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer # := SHAMSHEER
	 * 
	 * Sprint # :=
	 */
	// *****************************************************************************************************//

	public void print_1Stop_flight_Records() {
	System.out.println("**************The no. of flights with One Stop filter***************");
	hoverAndClick(btn_Reset);
	hoverAndClick(btn_1Stop);
	System.out.println("The no. of departures flights with One Stop filter are"+departure_Flight_count());
	System.out.println("The no. of Return flights with One Stop filter are"+return_Flight_count());
	
	}
	//**************************************************************************************************//

}
