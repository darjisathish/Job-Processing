package stepDefinations;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HooksStepDefinations {
	
	@Before
	public void setup() 
	{
		System.out.println("launch chrome browser");
		System.out.println("Entered URL of Apppication");
	}
	
	@After
	public void tearDown() 
	{
		System.out.println("closed browser");
	}
	
		
	
	@Given("^user is on add customer page$")
	public void user_is_on_add_customer_page() throws Throwable {
	    System.out.println("user is on add customer page");
	}

	@When("^user fills the customer details$")
	public void user_fills_the_customer_details() throws Throwable {
		 System.out.println("user fills the customer details");
	    
	}

	@Then("^customer is added$")
	public void customer_is_added() throws Throwable {
		 System.out.println("customer is added");
	}

	@Given("^user is on edit customer page$")
	public void user_is_on_edit_customer_page() throws Throwable {
		System.out.println("user is on edit customer page");
	}

	@When("^user edits contact details$")
	public void user_edits_contact_details() throws Throwable {
		System.out.println("user edits contact details");
	}

	@Then("^contact details updated$")
	public void contact_details_updated() throws Throwable {
		System.out.println("contact details updated");
	}

	@Given("^user is on delete customer page$")
	public void user_is_on_delete_customer_page() throws Throwable {
		System.out.println("user is on delete customer page");
	}

	@When("^user delete customer$")
	public void user_delete_customer() throws Throwable {
		System.out.println("user delete customer");
	}

	@Then("^customer deleted$")
	public void customer_deleted() throws Throwable {
		System.out.println("customer deleted");
	}

}
