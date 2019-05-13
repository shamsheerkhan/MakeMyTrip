package com.stepdefinitions;



import org.junit.Assert;

import com.Applicaion.Pages.HomePage;
import com.genericmethods.GenericMethods;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class FlightResultTest extends GenericMethods {
	public static HomePage home;

	@Given("^user is on home page$")
	public void user_is_on_home_page() {
		lanunchBowser();
		home = new HomePage();
		//home.login_account();
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
		hoverAndClick(home.btn_search);
	}

}
