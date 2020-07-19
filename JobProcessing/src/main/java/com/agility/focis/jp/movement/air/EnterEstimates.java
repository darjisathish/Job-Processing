package com.agility.focis.jp.movement.air;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.JS;
import com.agility.focis.utility.PropertiesFile;
import com.agility.focis.utility.SwitchTo;
import com.agility.focis.utility.WaitFor;

public class EnterEstimates extends BaseTest {

	public  static WebElement generalSupplier ;
	private static WebElement cost ;
	private static WebElement Revenue;
	
	

	public static WebElement  SupplierSearchPicker(WebDriver driver,int rowNo){
		generalSupplier = driver.findElement(By.xpath(PropertiesFile.read("idSupplierSearchPicker")+rowNo+"]"));
		return generalSupplier;

	}
	
	public static WebElement  setCost(WebDriver driver,int rowNo){
		cost = driver.findElement(By.xpath(PropertiesFile.read("idCost")+rowNo+"]"));
		return cost;

	}
	public static WebElement  setRevenue(WebDriver driver,int rowNo){
		Revenue = driver.findElement(By.xpath(PropertiesFile.read("idRevenue")+rowNo+"]"));
		return Revenue;

	}
	
	public static void forConfirmInternationalFreight(int rowNo,String suppliername,String cost,String revenue) {
		
		
		SwitchTo.estimatesFrame();
		WebElement generalSupplier1=SupplierSearchPicker(driver, rowNo);
		
		try {
			generalSupplier1.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JS.click(generalSupplier1);
		}
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		
		WebElement stakeholder=BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("nameAndaddress"))); 
		
		stakeholder.sendKeys(suppliername);
		stakeholder.sendKeys(Keys.ENTER);
		System.out.println("stakeholdername is entered");
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+suppliername+"')]")));
		BaseTest.driver.findElement(By.xpath("//a[contains(text(),'"+suppliername+"')]")).click();
		
		/*WebElement costn=driver.findElement(By.xpath(PropertiesFile.read("idCost")+rowNo+"]"));
		
		// To handle element click intercepted exception
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+ cost +"';", costn);*/
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(PropertiesFile.read("idCost")+rowNo+"]")));
		setCost(driver, rowNo).sendKeys(cost);
		setRevenue(driver, rowNo).sendKeys(revenue);
		
		WebElement SaveAndClose=BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cSaveAndCloseButton")));
		JS.click(SaveAndClose);
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		Reporter.log("Main Carriage is planned with general supplier"+suppliername);
		BaseTest.driver.switchTo().defaultContent();
		System.err.println("Switched to main carriage");
	}
	

}
