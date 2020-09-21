package com.agility.focis.rc.carrierContract.air;

import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.agility.focis.base.BasePage;

public class CarrierContractAir extends BasePage{
	
	public CarrierContractAir(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//*[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierContractLsUc_AFCarrierContractLsUc_btnOpenUploadPage']")
	public WebElement Upload;
	//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	
	@FindBy(xpath = "//*[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_txtCountry']")
    public WebElement Country;
	
	/*@FindBy(xpath = "//span[text() = 'Country']/../following-sibling::div//input")
    public WebElement Country;*/
	
	@FindBy(xpath = "//input[@name= 'DataCode']")
    public WebElement CountryCode;

	@FindBy(xpath = "//input[@name= 'DataName']")
    public WebElement CountryName;
	
	@FindBy(xpath = "//span[text() = 'Template Name']/../following-sibling::div//select")
    public WebElement TemplateNameDropDown;

	/*@FindBy(xpath = "//a[contains(text(),'"+ selectCountryName+"')]")
    public WebElement selectCountryName;*/

	/*@FindBy(xpath = "//td[@aria-describedby='pnlPopupGrid_DataName']//a")
    public WebElement selectCountryName;*/
	
	//td[3]//a[1]
	@FindBy(partialLinkText = "i")
    public WebElement selectCountryName;

	/*public WebElement selectCountryName(String selectCountryName) {
		//a[contains(text(),'India')]
		return driver.findElement(By.xpath("//a[contains(text(),'"+selectCountryName+"')]"));
		//return driver.findElement(By.xpath("//td[@aria-describedby='pnlPopupGrid_DataName']//a]"));
	}*/
	
	public void scrollDown()
    {

       JavascriptExecutor js = (JavascriptExecutor) driver;
      // js.executeScript("window.scrollBy(0,1000)");
       js.executeScript("window.scrollBy(0,350)", "");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	
	public void waitForPageLoad(WebDriver driver){
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() 
		{
		    public Boolean apply(WebDriver driver)
		    {
		        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("COMPLETED");          
		    }
		};
		Wait<WebDriver> wait = new WebDriverWait(driver,30);
		try
		{
		    wait.until(expectation);
		}
		catch(Throwable error)
		{
		    assertFalse("Timeout waiting for Page Load",true);
		}}
	

}
