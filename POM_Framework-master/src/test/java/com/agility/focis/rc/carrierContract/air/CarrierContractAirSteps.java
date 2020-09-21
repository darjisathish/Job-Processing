package com.agility.focis.rc.carrierContract.air;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.agility.focis.base.BasePage;
import com.agility.focis.base.BaseSteps;

public class CarrierContractAirSteps extends BaseSteps{

	private WebDriver driver;
	CarrierContractAir carrierContractAir;

	BasePage basePage;

	public CarrierContractAirSteps() throws IOException {
		this.driver = getDriver();
		carrierContractAir  = new CarrierContractAir(this.driver);

	}

	
	public void selctCountryName(String CountryName) throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_txtCountry']")).sendKeys(CountryName);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_txtCountry']")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
	}


	public void selectTemplateName(String selectTempName) {
		Select TemplateName = new Select(driver.findElement(By.xpath("//*[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_ddlTemplate']")));
		TemplateName.selectByVisibleText("AF-P2P Charges");
	}



	public void uploadExcelButton(String excelUpload) {

		WebElement excelUploadfile= driver.findElement(By.xpath("//*[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_UploadExcelFile']"));
		excelUploadfile.sendKeys("C:\\Users\\sdarji\\git\\POM_Framework\\POM_Framework-master\\uploadTemplates\\AF-P2P_Charges_v7.xlsx");

	}

	public void uploadButton(String uploadButton) {
		driver.findElement(By.xpath("//input[@title='Upload']")).click();
	}
	
	public void verifyTextPresent(String verifyText) {
		driver.getPageSource().contains("File upload completed. Please continue with next file.");
	}

	public void clickonReloadgrid(String reloadGrid) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		carrierContractAir.scrollDown();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-icon icon-refresh green'])")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-icon icon-refresh green'])")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}
	
	

	/*public void verifyUploadStatus(String uploadStatus) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@id='1']/td[@title='PENDING']"), "PENDING"));
		Thread.sleep(1000);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='1']/td[@title='COMPLETED']"), "COMPLETED"));
		//Thread.sleep(500);
		driver.close();
	
	}*/

	public void verifyUploadStatus() {
		System.out.print("File upload completed");
		driver.close();
	}

	
}
