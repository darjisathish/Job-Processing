package com.agility.focis.rc.carrierContract.ocean;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.agility.focis.base.BasePage;
import com.agility.focis.base.BaseSteps;


public class CarrierContractOceanSteps extends BaseSteps{
	
	private WebDriver driver;
	CarrierContractOcean carrierContractOcean;

	BasePage basePage;

	public CarrierContractOceanSteps() throws IOException {
		this.driver = getDriver();
		carrierContractOcean  = new CarrierContractOcean(this.driver);

	}
	
	
	
	
	public void selctCountryName(String CountryName) throws InterruptedException {

		//driver.findElement(By.xpath("//input[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_txtCountry']")).click();
		driver.findElement(By.xpath("//input[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_txtCountry']")).sendKeys(CountryName);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_txtCountry']")).sendKeys(Keys.ENTER);
		//Thread.sleep(500);
	}

}
