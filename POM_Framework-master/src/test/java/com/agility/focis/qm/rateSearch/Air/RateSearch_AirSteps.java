package com.agility.focis.qm.rateSearch.Air;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.agility.focis.base.BasePage;
import com.agility.focis.base.BaseSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;


public class RateSearch_AirSteps extends BaseSteps{
	
	private WebDriver driver;
	RateSearch_Air rateSearch_Air;
	
	BasePage basePage;
	
	public RateSearch_AirSteps() throws IOException {
		this.driver = getDriver();
		rateSearch_Air  = new RateSearch_Air();

	}
	
		
	public void selectAirportofDeparture(String AOD_PortCode) throws InterruptedException {
		SeleniumUtils.waitForJQueryLoading();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//button[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchAirShUc_QMRateSearchAirShUc_txtOriginPort_btnPopup']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='gs_Code']")).click();
		driver.findElement(By.xpath("//input[@id='gs_Code']")).sendKeys(AOD_PortCode);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='gs_Code']")).sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+AOD_PortCode+"']")));
		driver.findElement(By.xpath("//*[text()='"+AOD_PortCode+"']")).click();
	
	}
	
	public void selectAirportofArrival(String AOA_PortCode) throws InterruptedException {
		
		SeleniumUtils.waitForJQueryLoading();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//button[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchAirShUc_QMRateSearchAirShUc_txtDestinationPort_btnPopup']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='gs_Code']")).click();
		driver.findElement(By.xpath("//input[@id='gs_Code']")).sendKeys(AOA_PortCode);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='gs_Code']")).sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+AOA_PortCode+"']")));
		driver.findElement(By.xpath("//*[text()='"+AOA_PortCode+"']")).click();
		
	}
	
	public void selectCurrency(String Preferred_Currency) throws InterruptedException {
		SeleniumUtils.waitForJQueryLoading();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//button[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchAirShUc_QMRateSearchAirShUc_txtCurrency_btnPopup']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='gs_DataCode']")).click();
		driver.findElement(By.xpath("//input[@id='gs_DataCode']")).sendKeys(Preferred_Currency);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='gs_DataCode']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@aria-describedby='pnlPopupGrid_DataCode'])[1]/a")));
		driver.findElement(By.xpath("(//td[@aria-describedby='pnlPopupGrid_DataCode'])[1]/a")).click();
	
	}
	
	public void clickonSearchButton(String Search_Button) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchAirShUc_QMRateSearchAirShUc_btnSearch']")).click();
	
		/*String resultsTitle = "Search | Vancouver Public Library | BiblioCommons";
		String resultsMessage = "Please reach out to your local NPC for pricing.";
		if (!Wait.until(resultContains(resultsTitle)) || !Wait.until(msgContains(resultsMessage)))
			throw new RuntimeException("results page is not displayed");	*/	
	
		/*String url = driver.getCurrentUrl();
		System.out.print(url);
		Boolean assertalertMessageValue = url.contains((CharSequence)By.xpath("//*[contains(.,'Error')]"));
		println(!(assertalertMessageValue) == true);
		assert !(assertalertMessageValue) == true;*/
	
	}


	/*private void println(boolean b) {
		System.out.print("Please reach out to your local NPC for pricing.");
		
	}*/
	
}
