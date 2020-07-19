package com.agility.focis.jp.initiateJob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.ExpectedExceptions;

import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.PropertiesFile;
import com.agility.focis.utility.WaitFor;

public class InitiateJobPage3 extends BaseTest {

	private static WebElement packages;
	private static WebElement Type;
	private static WebElement perpiece;
	private static WebElement volume;
	private static WebElement ShippingMarks;
	private static WebElement description;
	
	public static WebElement  noOfPackages(WebDriver driver){

		packages = driver.findElement(By.xpath(PropertiesFile.read("xnoOfpackages")));

		return packages;

	}
	public static void setNoOfPackages(int rowNumber,String noOfpackages) {
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.read("xnoOfpackages")+"["+rowNumber+"]")));
		BaseTest.getDriver().findElement(By.xpath(PropertiesFile.read("xnoOfpackages")+"["+rowNumber+"]")).sendKeys(noOfpackages);
	}
	
	public static void selectType(int rowNumber,String type) {
		
		BaseTest.getDriver().findElement(By.xpath(PropertiesFile.read("xtypePicklist")+"["+rowNumber+"]")).click();
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.read("xcode")+"["+rowNumber+"]")));
		BaseTest.getDriver().findElement(By.xpath(PropertiesFile.read("xcode")+"["+rowNumber+"]")).sendKeys(type);
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.read("xcodeResults")))).click();;
	}
	
	public static void setPerPieceWeight(int rowNumber,String perPieceWeight) {
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.read("xperpiece")+"["+rowNumber+"]")));
		BaseTest.getDriver().findElement(By.xpath(PropertiesFile.read("xperpiece")+"["+rowNumber+"]")).sendKeys(perPieceWeight);
	}
   public static void setVolume(int rowNumber,String volume) {
 		
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.read("xvolume")+"["+rowNumber+"]")));
		BaseTest.getDriver().findElement(By.xpath(PropertiesFile.read("xvolume")+"["+rowNumber+"]")).sendKeys(volume);
	}
	
   public static void setShippingMarks(int rowNumber,String shippingMarks) {
	   new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.read("xshippingMarks")+"["+rowNumber+"]")));
		BaseTest.getDriver().findElement(By.xpath(PropertiesFile.read("xshippingMarks")+"["+rowNumber+"]")).sendKeys(shippingMarks);
}
   public static void setDescription(int rowNumber,String description) {
	   //new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.read("xdescription")+"["+rowNumber+"]")));
		BaseTest.getDriver().findElement(By.xpath(PropertiesFile.read("xdescription")+"["+rowNumber+"]")).sendKeys(description);
}
}