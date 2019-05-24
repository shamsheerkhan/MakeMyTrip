Feature: this feature is designed to test flight test results
Scenario: search Departure and Return Jouney Flights
	Given user is on home page 
	Then user has to click on flights menu 
	And user able to select round Trip 
	Then user able to enter the From Departure City 
	And user able to enter the To Arrival City 
	Then user has to select Departure and Return Journey Dates 
	And user able click Search 
	Then user able see all Departure and Return flight Records 
	Then user select the Non Stop service and able see all Departure and Return flight Records 
	Then user select the One Stop service and able see all Departure and Return flight Records 

Scenario Outline: verifying selected Departure and Return Flight Details
	Given user is selecting Departure and Return Flights with out any filter 
	Then user able to select the Departure Flight having <dept_index> index 
	And user able to select the Return Flight having <retn_index> index 
	Then user able to validate selected Departure Flight Name and Price which is shown Footer of the web page 
	Then user able to validate selected Return Flight Name and Price which is shown Footer of the web page 
	Then user able to validate the total price excluding Discount  price if available 
	Examples: 
		| dept_index| retn_index |
		|1|1|
		|23|45| 
		|12|16|
		|5|31|
		|4|3|
		|10|23|
		|8|3|