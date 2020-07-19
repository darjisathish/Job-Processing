package com.agility.focis.jp.initiateJob;


import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.Click;
import com.agility.focis.utility.PropertiesFile;
import com.agility.focis.utility.WaitFor;


public class InitiateJobPage1 extends BaseTest {

	private static WebElement product ;
	private static WebElement productType ;
	private static WebElement jobScope;
	private static WebElement oiginStakeholder;
	private static WebElement destinationStakeholder;
	private static WebElement BookwithoutTemplate;
	private static WebElement NameandAddress;
	private static WebElement properties;
	public static WebElement next;


	public static WebElement  bookwithoutemplatebutton(WebDriver driver){

		BookwithoutTemplate = driver.findElement(By.cssSelector(PropertiesFile.read("bookWithoutTemplate")));

		return BookwithoutTemplate;

	}
	
	
	public static WebElement  ProductDropdown(WebDriver driver){

		product = driver.findElement(By.cssSelector(PropertiesFile.read("cproduct")));

		return product;

	}

	public static WebElement Producttype1(WebDriver driver){

		productType = driver.findElement(By.cssSelector(PropertiesFile.read("cproductType")));

		return productType;

	}
	
	public static WebElement Jobscope1(WebDriver driver){

		jobScope = driver.findElement(By.cssSelector(PropertiesFile.read("cjobScope")));

		return jobScope;

	}
	
	public static WebElement oiginStakeholder1(WebDriver driver){

		oiginStakeholder = driver.findElement(By.cssSelector(PropertiesFile.read("originStakeholder")));

		return oiginStakeholder;

	}
	public static WebElement destinationStakeholder1(WebDriver driver){

		destinationStakeholder = driver.findElement(By.cssSelector(PropertiesFile.read("destinationStakeholder")));

		return destinationStakeholder;

	}
	 public static WebElement setstakeholdername(WebDriver driver) {
	    	
	    	NameandAddress = driver.findElement(By.cssSelector(PropertiesFile.read("nameAndaddress")));

			return NameandAddress;

	    }
	 
	 public static WebElement setProperties(WebDriver driver) {
	    	
		 properties = driver.findElement(By.cssSelector(PropertiesFile.read("properties")));

			return properties;

	    }
	 public static WebElement clickNext(WebDriver driver) {
	    	
		 next = driver.findElement(By.cssSelector(PropertiesFile.read("Next")));

			return next;

	    }
	 
	
	 public static  void  selectProduct(String Product) {
		 
		 Select select=new Select(ProductDropdown(driver));
		 select.selectByVisibleText(Product);
	 }
    public static  void  selectProducttype(String Producttype) {
		 
		 Select select=new Select(Producttype1(driver));
		 select.selectByVisibleText(Producttype);
	 }
    public static  void  selectJobscope(String jobScope_) {
		 
		 Select select=new Select(Jobscope1(driver));
		 select.selectByVisibleText(jobScope_);
	 }
    public static void clickNextButton() {
    	
    	Click.usingExecutor(clickNext(driver));
    }
   
    
    public static   void selectOriginstakeholder(String stakeholderName) throws Exception {
    	
    	oiginStakeholder1(driver).click();
    	WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		Thread.sleep(2000);
		setstakeholdername(driver).sendKeys(stakeholderName);
		setstakeholdername(driver).sendKeys(Keys.ENTER);
		System.out.println("stakeholdername is entered");
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		setProperties(driver).sendKeys("Yes");
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+stakeholderName+"')]")));
		BaseTest.driver.findElement(By.xpath("//a[contains(text(),'"+stakeholderName+"')]")).click();
    }
    
      public static   void selectDestinationstakeholder(String stakeholderName) throws Exception {
    	
    	 try {
    	new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesFile.read("destinationStakeholder"))));
    	destinationStakeholder1(driver).click();
    	 }
    	 catch(Exception e) {
    		 
    		 JavascriptExecutor executor = (JavascriptExecutor)driver;
    		 executor.executeScript("arguments[0].click();", destinationStakeholder);
    	 }
    	  
    	
    	WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		Thread.sleep(2000);
		setstakeholdername(driver).sendKeys(stakeholderName);
		setstakeholdername(driver).sendKeys(Keys.ENTER);
		System.out.println("stakeholdername is entered");
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		setProperties(driver).sendKeys("Yes");
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+stakeholderName+"')]")));
		BaseTest.driver.findElement(By.xpath("//a[contains(text(),'"+stakeholderName+"')]")).click();
    }
}

