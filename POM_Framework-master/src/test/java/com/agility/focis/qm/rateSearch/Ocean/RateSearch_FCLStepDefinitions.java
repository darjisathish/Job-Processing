package com.agility.focis.qm.rateSearch.Ocean;

import java.io.IOException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RateSearch_FCLStepDefinitions {
	

	private RateSearch_FCLSteps rateSearch_FCLSteps;

	public RateSearch_FCLStepDefinitions() throws IOException {

		rateSearch_FCLSteps = new RateSearch_FCLSteps();
	}
	
	@When("Click on Product Type and select ProductTypeValue from Rate Search tab")
	public void click_on_Product_Type_and_select_ProductTypeValue_from_Rate_Search_tab() throws InterruptedException {
		Thread.sleep(10000);
		rateSearch_FCLSteps.selectProductTypeValue("FCL");
	}

	@When("Select {string} port as Port of Loading")
	public void select_port_as_Port_of_Loading(String POL) throws InterruptedException {
		Thread.sleep(6000);
		rateSearch_FCLSteps.selectPOL(POL);
	}

	@When("Select {string} port as Port of Discharge")
	public void select_port_as_Port_of_Discharge(String POD) throws InterruptedException {
		Thread.sleep(6000);
		rateSearch_FCLSteps.selectPOD(POD);
	}

	/*@When("Select {string} as Preferred Currency")
	public void select_as_Preferred_Currency(String Preferred_Currency) throws InterruptedException {
		rateSearch_FCLSteps.selectCurrency(Preferred_Currency);
	}*/

	/*@When("Click on {string} drop down")
	public void click_on_drop_down(String string) {
	    
	}

	@When("Select {string} as Unit Type Values")
	public void select_as_Unit_Type_Values(String string) {
	    
	}*/

	/*@Then("Wait for Rate Search List or Please reach out to your local NPC for pricing message")
	public void wait_for_Rate_Search_List_or_Please_reach_out_to_your_local_NPC_for_pricing_message() {
		rateSearch_FCLSteps.clickonSearch();
	}*/
}
	
	
	
	
	
	
	/*
	
private RateSearch_FCLSteps rateSearch_FCLSteps;
	
	public RateSearch_FCLStepDefinitions() throws IOException {
	rateSearch_FCLSteps = new RateSearch_FCLSteps();
		
    }
	
	
	@When("Click on Product Type and select ProductTypeValue from Rate Search tab")
	public void click_on_Product_Type_and_select_ProductTypeValue_from_Rate_Search_tab(List<Map<String, String>> dataTable) throws InterruptedException {
		
		String selectProductType;
		for (int i = 0; i < dataTable.size(); i++) {
			selectProductType = dataTable.get(i).get("SelectProductType");
			rateSearch_FCLSteps.selectProductTypeValue(selectProductType);
		}
			
	}*/

	