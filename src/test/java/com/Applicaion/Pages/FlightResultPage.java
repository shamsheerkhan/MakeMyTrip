package com.Applicaion.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.SkipException;


import com.genericmethods.GenericMethods;


import utils.ExtentReportGenerator;


public class FlightResultPage extends GenericMethods{

	@FindBy(how = How.XPATH, using = "//div[@id='ow_domrt-jrny']//label[starts-with(@for,'splitowJourney')]")
	public  List<WebElement> departures_flights_list;

	@FindBy(how = How.XPATH, using = "//div[@id='rt-domrt-jrny']//label[starts-with(@for,'splitrtJourney')]")
	public  List<WebElement> Return_flights_list;
	@FindBy(how = How.XPATH, using = "//div[@id='fli_filter__stops']//span[text()='Non Stop']")
	public  WebElement btn_nonStop;
	@FindBy(how = How.XPATH, using = "//div[@id='fli_filter__stops']//span[text()='1 Stop']")
	public  WebElement btn_1Stop;
	@FindBy(how = How.XPATH, using = "//a[text()=' Clear All Filters']")
	public  WebElement btn_clearFilters;
	@FindBy(how=How.XPATH,using="//div[@id='fli_filter__stops']//a[text()='Reset']")
	public  WebElement btn_Reset;
	@FindBy(how=How.XPATH,using="//div[@id='rt-domrt-jrny']"
			+ "/following-sibling::div//p[text()='Departure | ']/parent::div")
	public  WebElement bottom_Departure_Flight;
	@FindBy(how=How.XPATH,using="//div[@id='rt-domrt-jrny']"
			+ "/following-sibling::div//p[text()='Return | ']/parent::div")
	public  WebElement bottom_Return_Flight;
	
	@FindBy(how=How.XPATH,using="//p[contains(text(),'discount')]")
	public  WebElement txt_discount;
	
	@FindBy(how=How.XPATH,using="//span[@class='splitVw-total-fare']/span")
	public  WebElement txt_totalfare;
	public String departureFlight_Name;

	public String departureFlight_Price;
	public String returnFlight_Name;

	public String returnFlight_Price;
	
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
		toBottomOfPage();
		toUP();
		System.out.println("The no. of departures flights are " + departure_Flight_count());
		
		System.out.println("The no. of Return flights are " + return_Flight_count());
	}

	// ********************************************************************************************************//
	public int departure_Flight_count() {
		toBottomOfPage();
		toUP();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElements(departures_flights_list));
		if (departures_flights_list.size() < 1) {
			ExtentReportGenerator.logStatus("fail", "No Flight availabe at selected date and select another Departure Date");
			try {
				throw new Exception("No Flight availabe at selected date and select another Departure Date");
				
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
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElements(Return_flights_list));
		if (Return_flights_list.size() < 1) {
			ExtentReportGenerator.logStatus("fail", "No Flight availabe at selected date and select another Return Date");
			try {
				throw new Exception("No Flight availabe at selected date and select another Return Date");
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
	toBottomOfPage();
	toUP();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	System.out.println("The no. of departures flights with Non Stop filter are "+departure_Flight_count());
	test.get().info("The no. of departures flights with Non Stop filter are "+departure_Flight_count());
	System.out.println("The no. of Return flights with Non Stop filter are "+return_Flight_count());
	test.get().info("The no. of Return flights with Non Stop filter are "+return_Flight_count());
	
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
	toBottomOfPage();
	toUP();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	System.out.println("The no. of departures flights with One Stop filter are "+departure_Flight_count());
	test.get().info("The no. of departures flights with One Stop filter are "+departure_Flight_count());
	System.out.println("The no. of Return flights with One Stop filter are "+return_Flight_count());
	test.get().info("The no. of Return flights with One Stop filter are "+return_Flight_count());
	}
	//**************************************************************************************************//
	/*
	 * Method Name := Departureflight_Details()
	 * 
	 * Input Parameter := WebElement element
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer # := SHAMSHEER
	 * 
	 * Sprint # :=
	 */
	// *****************************************************************************************************//

	public void Departureflight_Details(WebElement element){
		String FlightDetails=element.getText();
		String[] FlightData=FlightDetails.split("\n");
		departureFlight_Name=FlightData[0];
		departureFlight_Price=FlightData[FlightData.length-1];
		
	}
	public String getDepartureFlight_Name(){
		return departureFlight_Name;
	}
	public String getDepartureFlight_Price(){
		return departureFlight_Price;
	}
	// **************************************************************************************************//
	/*
	 * Method Name := returnflight_Details()
	 * 
	 * Input Parameter := WebElement element
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer # := SHAMSHEER
	 * 
	 * Sprint # :=
	 */
	// *****************************************************************************************************//

	public void returnflight_Details(WebElement element) {
		String FlightDetails = element.getText();
		String[] FlightData = FlightDetails.split("\n");
		returnFlight_Name = FlightData[0];
		returnFlight_Price = FlightData[FlightData.length - 1];

	}

	public String getReturnFlight_Name() {
		return returnFlight_Name;
	}

	public String getReturnFlight_Price() {
		return returnFlight_Price;
	}

	// **************************************************************************************************//
	/*
	 * Method Name := select_DepartureFlight()
	 * 
	 * Input Parameter := int index
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer # := SHAMSHEER
	 * 
	 * Sprint # :=
	 */
	// *****************************************************************************************************//
	public boolean select_DepartureFlight(int index) {
		boolean flag=false;
		if(departures_flights_list.size()>=index&&index>0){
		WebElement element = departures_flights_list.get(index);
		toElement(element);
		Departureflight_Details(element);
		hoverAndClick(element);
		ExtentReportGenerator.logStatus("pass", "clicked on Departure flight having index "+index);
		System.out.println("The Departure Flight Name is "+getDepartureFlight_Name());
		test.get().info("The Departure Flight Name is "+getDepartureFlight_Name());
		System.out.println("The Departure Flight Price is "+getDepartureFlight_Price());
		test.get().info("The Departure Flight Price is "+getDepartureFlight_Price());
		flag=true;
		}else{
			ExtentReportGenerator.logStatus("skip", 
					"Given " + index + " Index number is more than number of Departure flight listed or Negative value");
			
			Reporter.log("select flight from another departure date");
			test.get().info("select flight from another departure date");
			throw new SkipException(
					"Given " + index + " Index number is more than number of Departure flight listed or Negative value");
			
		}
		return flag;
	}
	//********************************************************************************************************//
	/*
	 * Method Name := validate_SelectedDepartureDetails()
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
	public void validate_SelectedDepartureDetails(){
		String footerDeptFlightDetails=bottom_Departure_Flight.getText();
		if(footerDeptFlightDetails.replaceAll("\\s+", "").contains(getDepartureFlight_Name().replaceAll("\\s+", ""))&&
				footerDeptFlightDetails.replaceAll("\\s+", "").contains(getDepartureFlight_Name().replaceAll("\\s+", ""))){
			
			System.out.println("The flight name "+getDepartureFlight_Name()+" The Flight price "+getDepartureFlight_Price()+" matched");
	test.get().info("The flight name "+getDepartureFlight_Name()+" The Flight price  "+getDepartureFlight_Price()+" matched");
		}else{
			System.out.println("The Departure flight Details not matched with selected Flight "
		+getDepartureFlight_Name());
	test.get().info("The Departure flight Details not matched with selected Flight "
		+getDepartureFlight_Name());
		}
	}
	
	// ********************************************************************************************************//
	/*
	 * Method Name := select_ReturnFlight()
	 * 
	 * Input Parameter := int index
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer # := SHAMSHEER
	 * 
	 * Sprint # :=
	 */
	// *****************************************************************************************************//
	public boolean select_ReturnFlight(int index) {
		boolean flag=false;
		if(Return_flights_list.size()>=index&&index>0){
		WebElement element = Return_flights_list.get(index);
		toElement(element);
		returnflight_Details(element);
		hoverAndClick(element);
		ExtentReportGenerator.logStatus("pass", "clicked on Return flight having index "+index);
		System.out.println("The Return Flight Name is "+getReturnFlight_Name());
		test.get().info("The Return Flight Name is "+getReturnFlight_Name());
		System.out.println("The Return Flight Price is "+getReturnFlight_Price());
		test.get().info("The Return Flight Price is "+getReturnFlight_Price());
		flag=true;
		}else{
			ExtentReportGenerator.logStatus("skip", 
					"Given " + index + " Index number is more than number of Return flight listed or Negative value");
			ExtentReportGenerator.logStatus("log_pass", "select flight from another Return journey date");
			
			throw new SkipException(
					"Given " + index + " Index number is more than number of Return flight listed or Negative value");		
			}
		return flag;
	}	
	//******************************************************************************************************//
	/*
	 * Method Name := validate_SelectedReturnDetails()
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
	public void validate_SelectedReturnDetails(){
		String footerreturnFlightDetails=bottom_Return_Flight.getText();
		if(footerreturnFlightDetails.replaceAll("\\s+", "").contains(getReturnFlight_Name().replaceAll("\\s+", ""))&&
				footerreturnFlightDetails.replaceAll("\\s+", "").contains(getReturnFlight_Name().replaceAll("\\s+", ""))){
			System.out.println("The flight name "+getReturnFlight_Name()+" The Flight price "+getReturnFlight_Price()+" matched");
		
		test.get().info("The flight name "+getReturnFlight_Name()+" The Flight price "+getReturnFlight_Price()+" matched");
		}
		else{
			System.out.println("The Return flight Details not matched with selected Flight "
		+getReturnFlight_Name());
			test.get().info("The Return flight Details not matched with selected Flight "
					+getReturnFlight_Name());
		}
	}
	//*************************************************************************************************************//		
	/*
	 * Method Name := isDiscountApplied()
	 * 
	 * Input Parameter := NA
	 * 
	 * OutPut Parameter := discount
	 * 
	 * Designer # := SHAMSHEER
	 * 
	 * Sprint # :=
	 */
	// *****************************************************************************************************//
	public int isDiscountApplied(){
		int discount=0;
		try{
			if(txt_discount.isDisplayed()){
		
			String[] data=txt_discount.getText().split(" ");
			discount=ConvertToIntPrice(data[data.length-1]);
		}else
			System.out.println("There is no Discount price for selected flights");
			test.get().info("There is no Discount price for selected flights");
			}
		catch(Exception e){
			
		}
		System.out.println("Applied discount is: "+discount+". Amount will be adjust from final fare");
		test.get().info("Applied discount is: "+discount+". Amount will be adjust from final fare");
		return discount;
	}
	//*************************************************************************************************************//		
	/*
	 * Method Name := validateTotalprice()
	 * 
	 * Input Parameter := NA
	 * 
	 * OutPut Parameter := boolean
	 * 
	 * Designer # := SHAMSHEER
	 * 
	 * Sprint # :=
	 */
	// *****************************************************************************************************//
	public boolean validateTotalprice(){
		boolean flag=false;
		int totalFare=ConvertToIntPrice(departureFlight_Price)+
				ConvertToIntPrice(returnFlight_Price)-isDiscountApplied();
		test.get().info("the total fare is "+totalFare);
		if(totalFare==ConvertToIntPrice(txt_totalfare.getText())){
			flag=true;
			System.out.println("The total fare is matched of selected flight");
			test.get().info("The total fare is matched of selected flight");
		}
		return flag;
	}
	//*********************************************************************************************************//
}
