package com.agility.focis.qm.rateSearch.Ocean;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.agility.focis.base.BasePage;


public class RateSearch_FCLSteps {
	
	private WebDriver driver;
	RateSearch_FCL rateSearch_FCL;

	BasePage basePage;

	public RateSearch_FCLSteps() throws IOException {
		this.driver = getDriver();
		rateSearch_FCL  = new RateSearch_FCL(this.driver);

	}
	
	private WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectProductTypeValue(String ProductType) throws InterruptedException {
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='modal-body']//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]")).click();
		Thread.sleep(6000);
		System.out.println("//span[contains(text(),'"+ProductType+" (NVOCC)')]");
		driver.findElement(By.xpath("//span[contains(text(),'"+ProductType+" (NVOCC)')]")).click();
		driver.findElement(By.xpath("//div[@class='modal-body']//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]")).click();
		
		
	}
	
	public void selectPOL(String POL) throws InterruptedException {
		driver.findElement(By.name("PWCMasterPage$PWCWebPartManager$gwpQMRateSearchOceanShUc$QMRateSearchOceanShUc$txtOriginPort")).sendKeys(POL);
		Thread.sleep(6000);
		driver.findElement(By.name("PWCMasterPage$PWCWebPartManager$gwpQMRateSearchOceanShUc$QMRateSearchOceanShUc$txtOriginPort")).sendKeys(Keys.ENTER);
		
		//System.out.println("//a[contains(text(),'"+POL+"')]");
		//driver.findElement(By.xpath("//a[contains(text(),'"+POL+"')]")).click();
		
	}
	public void selectPOD(String POD) throws InterruptedException {
	driver.findElement(By.id("PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtDestinationPort")).sendKeys(POD);
	Thread.sleep(6000);
	driver.findElement(By.id("PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtDestinationPort")).sendKeys(Keys.ENTER);
	//System.out.println("//a[contains(text(),'"+POD+"')]");
	//driver.findElement(By.xpath("//a[contains(text(),'"+POD+"')]")).click();
	}
	
	
	public void selectCurrency(String Preferred_Currency) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtCurrency']")).sendKeys(Preferred_Currency);
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtCurrency']")).sendKeys(Keys.ENTER);
		//System.out.println("//a[contains(text(),'"+Preferred_Currency+"')]");
		//driver.findElement(By.xpath("//a[contains(text(),'"+Preferred_Currency+"')]")).click();
	}
	
	/*public void clickonSearch() {
		driver.findElement(By.name("PWCMasterPage$PWCWebPartManager$gwpQMRateSearchOceanShUc$QMRateSearchOceanShUc$btnSearch")).click();
		
	}*/
		
	
	
	
		/*//basePage = new BasePage(driver);
		//Select ProductType = new Select(driver.findElement(By.xpath("//button[@data-id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_ddl_ProductType']")));
		
		Select ProductType = new Select(basePage.SelectProductType());
		ProductType.selectByValue("FCL (NVOCC)");
	}
	*/
	
	
	
	public void selctPortOfLoading(String POL) throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtOriginPort']")).sendKeys(POL);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtOriginPort']")).sendKeys(Keys.ENTER);
		
	}

	public void selctPortofDischarge(String POD) throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtDestinationPort']")).sendKeys(POD);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtDestinationPort']")).sendKeys(Keys.ENTER);
		
	}
	
	public void selctCurrency(String Preferred_Currency) throws InterruptedException {

		driver.findElement(By.xpath("//input[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtCurrency']")).sendKeys(Preferred_Currency);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtCurrency']")).sendKeys(Keys.ENTER);
		
	}
	
	public void clickonUnitType(String unitType) {
		driver.findElement(By.xpath("//button[@data-id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_ddl_UnitType']")).click();
	}

	public void clickonUnitTypeValue(String unitTypeValue) {
		driver.findElement(By.xpath("//*[@id=\"grdNPCRateSearchLsSearch\"]/div[1]/div[2]/div/div/div[1]/div/button/span[1]")).click();
	}

	/*public void cliconSearchButton(String unitTypeValue) {
		driver.findElement(By.xpath("//*[@id=\"grdNPCRateSearchLsSearch\"]/div[1]/div[2]/div/div/div[1]/div/button/span[1]")).click();
	}*/
	
	/*public void selectProductTypeValue(String Product_Type_Value) throws InterruptedException {
		WebElement productType = driver.findElement(By.xpath("//button[@data-id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_ddl_ProductType']"));
		Select ProductTypeValue = new Select(productType);
		ProductTypeValue.selectByVisibleText("FCL (NVOCC)");
	}
	*/
	
	
	/*public void clickProductTypeDropDown1(String productType, String productTypeValue) throws InterruptedException {
		driver.findElement(By.xpath("//button[@data-id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_ddl_ProductType']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[text()='${xpath}']")).click();
		
    }
	
	public void selectProductTypeValue(String Product_Type_Value) throws InterruptedException {
		WebElement productType = driver.findElement(By.xpath("//button[@data-id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_ddl_ProductType']"));
		Select ProductTypeValue = new Select(productType);
		ProductTypeValue.selectByVisibleText("FCL (NVOCC)");
	}
	
	
	
	public void selectTemplateName(String selectTempName) {
		Select TemplateName = new Select(driver.findElement(By.xpath("//*[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_ddlTemplate']")));
		TemplateName.selectByVisibleText("AF-P2P Charges");
	}
	public void clickProductTypeDropDown(String Product_Type_Value) throws InterruptedException {
		 driver.findElement(By.xpath("//button[@data-id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_ddl_ProductType']")).click();
		//Select ProductTypeValue = new Select(productType);
		//ProductTypeValue.selectByValue("FCL (NVOCC)");
	}
	
	
	public void clickProductTypeDropDown2(String Product_Type_Value) {
		Select productType = new Select(driver.findElement(By.xpath("//button[@data-id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_ddl_ProductType']")));
		productType.selectByVisibleText("FCL (NVOCC)");
		
	}
	*/
}
