package com.agility.focis.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MoreLinks extends SwitchTo{

	
	
	
	
	
	@FindBy(how = How.CSS, using = "#PWCMasterPage_PWCWebPartManager_gwpBookingDeatilsLinksFr1_BookingDeatilsLinksFr1_txtAgilityRefType_btnPopup")
    private  static WebElement type1;
	
	@FindBy(how = How.CSS, using = "#gs_Name")
    private  static WebElement name;
	
	@FindBy(how = How.CSS, using = "#gs_ReferenceType")
    private  static WebElement type2;
	
	@FindBy(how = How.CSS, using = "#PWCMasterPage_PWCWebPartManager_gwpBookingDeatilsLinksFr1_BookingDeatilsLinksFr1_txtAgilityRefValue")
    private  static WebElement value;
	
	@FindBy(how = How.CSS, using = "#PWCMasterPage_PWCWebPartManager_gwpBookingDeatilsLinksFr1_BookingDeatilsLinksFr1_btnAddAgilityReferences")
    private  static WebElement add;
	
	@FindBy(how = How.CSS, using = "a[title='Close']")
    public   static WebElement close;
	
	public static  void addCustomerReferences(String packageType,String stakeholdername) {
		
		SwitchTo.morelinksFrame();
		WaitFor.clickOnElementUsingExplicitWait(driver.findElement(By.cssSelector("a[title='References']")));
		
		WebElement references=driver.findElement(By.cssSelector("#PWCMasterPage_PWCWebPartManager_gwpBookingDeatilsLinksFr1_BookingDeatilsLinksFr1_txtAgilityRefType_btnPopup"));
		WaitFor.clickOnElementUsingExplicitWait(references);
		WaitFor.SetTextUsingExplicitWait(driver.findElement(By.cssSelector("#gs_Name")), packageType);
		driver.findElement(By.cssSelector("#gs_Name")).sendKeys(Keys.ENTER);
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
	    WaitFor.SetTextUsingExplicitWait(driver.findElement(By.cssSelector("#gs_ReferenceType")), stakeholdername);
		WebElement searchResults=BaseTest.getDriver().findElement(By.xpath(PropertiesFile.read("xcodeResults")));
		Click.usingExecutor(searchResults);
		WaitFor.SetTextUsingExplicitWait(driver.findElement(By.cssSelector("#PWCMasterPage_PWCWebPartManager_gwpBookingDeatilsLinksFr1_BookingDeatilsLinksFr1_txtAgilityRefValue")), stakeholdername);
		WaitFor.clickOnElementUsingExplicitWait(driver.findElement(By.cssSelector("#PWCMasterPage_PWCWebPartManager_gwpBookingDeatilsLinksFr1_BookingDeatilsLinksFr1_btnAddAgilityReferences")));
		driver.switchTo().defaultContent();
		WaitFor.clickOnElementUsingExplicitWait(driver.findElement(By.cssSelector("a[title='Close']")));
		
	}
}
