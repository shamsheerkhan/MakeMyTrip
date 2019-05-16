package com.stepdefinitions;



import org.junit.Assert;

import com.Applicaion.Pages.FlightResultPage;
import com.Applicaion.Pages.HomePage;
import com.genericmethods.GenericMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FlightResultTest extends GenericMethods {
	public static HomePage home;
	public static FlightResultPage flight;
	boolean flag;
	boolean status;

	@Given("^user is on home page$")
	public void user_is_on_home_page() {
		lanunchBowser();
		home = new HomePage();
		// home.login_account();
	}

	@Then("^user has to click on flights menu$")
	public void user_has_to_click_on_flights_menu() {
		home.select_MMT_Menu();
	}

	@And("^user able to select round Trip$")
	public void user_able_to_select_round_Trip() {
		home.select_Trip();
	}

	@Then("^user able to enter the From Departure City$")
	public void user_able_to_enter_the_From_Departure_City() {
		Assert.assertTrue(home.enterFromCity());
	}

	@And("^user able to enter the To Arrival City$")
	public void user_able_to_enter_the_To_Arrival_City() {
		Assert.assertTrue(home.EnterToCity());
	}

	@Then("^user has to select Departure and Return Journey Dates$")
	public void user_has_to_select_Departure_and_Return_Journey_Dates() {
		Assert.assertTrue(home.DatePicker());
	}

	@And("^user able click Search$")
	public void user_able_click_Search() {
		flight = home.clickSearch();
	}

	@Then("^user able see all Departure and Return flight Records$")
	public void user_able_see_all_Departure_and_Return_flight_Records() {
		flight.print_flight_Records();
		
		
	}

	@Then("^user select the Non Stop service and able see all Departure and Return flight Records$")
	public void user_select_the_Non_Stop_service_and_able_see_all_Departure_and_Return_flight_Records() {
		flight.print_NonStop_flight_Records();
	}

	@Then("^user select the One Stop service and able see all Departure and Return flight Records$")
	public void user_select_the_One_Stop_service_and_able_see_all_Departure_and_Return_flight_Records() {
		flight.print_1Stop_flight_Records();
	}

	@Given("^user is selecting Departure and Return Flights with out any filter$")
	public void user_is_selecting_Departure_and_Return_Flights_with_out_any_filter() {
		toBottomOfPage();
		toUP();
		hoverAndClick(flight.btn_Reset);
	
	}

	@Then("^user able to select the Departure Flight having (\\d+) index$") 
	public void user_able_to_select_the_Departure_Flight_having(int arg1) {
		try{
			flag=flight.select_DepartureFlight(arg1);
			
		}catch(Exception e){
		e.printStackTrace();	
		}
	}

	@Then("^user able to select the Return Flight having (\\d+) index$")
	public void user_able_to_select_the_Return_Flight_having(int arg1) {
		
		try{
			status=flight.select_ReturnFlight(arg1);
			
		}catch(Exception e){
			e.printStackTrace();	
			}
	}

	@Then("^user able to validate selected Departure Flight Name and Price which is shown Footer of the web page$")
	public void user_able_to_validate_selected_Departure_Flight_Name_and_Price_which_is_shown_Footer_of_the_web_page() {
		if(flag){
			flight.validate_SelectedDepartureDetails();
		}
	}

	@Then("^user able to validate selected Return Flight Name and Price which is shown Footer of the web page$")
	public void user_able_to_validate_selected_Return_Flight_Name_and_Price_which_is_shown_Footer_of_the_web_page() {
		if(status){
			flight.validate_SelectedReturnDetails();
		}
	}
	
	@Then("^user able to validate the total price excluding Discount  price if available$")
	public void user_able_to_validate_the_total_price_excluding_Discount_price_if_available(){
		Assert.assertTrue(flight.validateTotalprice());
	}
}
