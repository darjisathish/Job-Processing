package com.agility.focis.qm.rateSearch.Air;

import java.io.IOException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RateSearch_AirStepDefinitions {
	
	private RateSearch_AirSteps rateSearch_AirSteps;

	public RateSearch_AirStepDefinitions() throws IOException {
		rateSearch_AirSteps = new RateSearch_AirSteps();
	}
	
		
	@When("Select {string} from Airport of Departure-Origin Port list window")
	public void select_from_Airport_of_Departure_Origin_Port_list_window(String AOD_PortCode) throws InterruptedException {
		rateSearch_AirSteps.selectAirportofDeparture(AOD_PortCode);
	}

	@When("Select {string} from Airport of Arrival-Destination Port list window")
	public void select_from_Airport_of_Arrival_Destination_Port_list_window(String AOA_PortCode) throws InterruptedException {
		rateSearch_AirSteps.selectAirportofArrival(AOA_PortCode);
	}
	
	
	@When("Select {string} as Preferred Currency")
	public void select_as_Preferred_Currency(String Preferred_Currency) throws InterruptedException {
		rateSearch_AirSteps.selectCurrency(Preferred_Currency);
	}
	
	@When("Clicks on {string} button from Air Search Companion")
	public void clicks_on_button_from_Air_Search_Companion(String Search_Button) throws InterruptedException {
		rateSearch_AirSteps.clickonSearchButton(Search_Button);
	}
	
	@Then("Wait for Rate Search List or Please reach out to your local NPC for pricing message")
	public void wait_for_Rate_Search_List_or_Please_reach_out_to_your_local_NPC_for_pricing_message() {
		System.out.print("Display Rate Search List || Please reach out to your local NPC for pricing.");
		
	}
	
	
	
	
	
	

}
