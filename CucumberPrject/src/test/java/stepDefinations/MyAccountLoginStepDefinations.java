package stepDefinations;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class MyAccountLoginStepDefinations {
	
	public WebDriver driver = null;
	
	@Given("^Open the browser$")
	public void open_the_browser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_workspace\\CucumberPrject\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	
	@When("^Enter the URL \"([^\"]*)\"$")
	public void enter_the_URL(String url) throws Throwable {
	driver.get(url);
	    
	}

	@And("^Click on My Account Menu$")
	public void click_on_My_Account_Menu() throws Throwable {
		
		driver.findElement(By.xpath("//*[contains(@id,'menu-item-50')]")).click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	    
	}
	
	
	//Test case-1
	/*@And("^Enter registered username and password$")
	public void enter_registered_username_and_password() throws Throwable {
		
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("darjisathish");
	    driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Aes!@#12");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	}*/
	
	
	//Test case-2	
	/*Single and multiple user credentials 
	@And("^Enter registered username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void enter_registered_username_and_password(String user, String pwd) throws Throwable {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys(user);
	    driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pwd);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
	}*/
	
	
	
	//Test case-3
/*	//login with data table method
	@When("^Enter registered username and password$")
	public void enter_registered_username_and_password(DataTable credentials) throws Throwable {
		List <List <String>> data = credentials.raw();
		driver.findElement(By.id("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
	    
	}
	*/
	
	
	//Test case-4
	//login with data table method using header - Map table
		@When("^Enter registered username and password$")
		public void enter_registered_username_and_password(DataTable credentials) throws Throwable {
			List<Map<String,String>> data= credentials.asMaps(String.class, String.class);
			driver.findElement(By.id("username")).sendKeys(data.get(0).get("user"));
			driver.findElement(By.id("password")).sendKeys(data.get(0).get("password"));
		    
		}
		
	
	
	
	
	@And("^Click on login button$")
	public void click_on_login_button() throws Throwable {
		driver.findElement(By.xpath("//*[@name='login']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	}

	@Then("^User must successfully login to the web page$")
	public void user_must_successfully_login_to_the_web_page() throws Throwable {
		String capText= driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/p[1]/strong")).getText();
		Assert.assertEquals(true, capText.contains("darjisathish"));
		//driver.close();
		}

	
	@Then("^Verify Login$")
	public void verify_Login() throws Throwable {
		
		String capText = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li/strong")).getText();
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if (capText.contains("ERROR")) //Test for invalid inputs
		{
			Assert.assertTrue("Invalid input - Error Page", true);
		}
		
		else 
		{
			Assert.assertTrue(false);
		}
		
	}
}
