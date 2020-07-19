package com.agility.focis.jp.movement.air;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.DateSelection;
import com.agility.focis.utility.JS;
import com.agility.focis.utility.PropertiesFile;
import com.agility.focis.utility.Sendkeys;
import com.agility.focis.utility.WaitFor;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class PlanOrigin extends BaseTest{



	private static WebElement purpleIcon ;
	private static WebElement frame ;
	private static WebElement haulageArrangement;
	private static WebElement haulier;



	public static WebElement  puprplePlusIcon(WebDriver driver){

		purpleIcon = driver.findElement(By.xpath(PropertiesFile.read("xoriginpurpleplusicon")));

		return purpleIcon;

	}

	public static WebElement  originframe(WebDriver driver){

		frame = driver.findElement(By.xpath(PropertiesFile.read("coriginframe")));

		return frame;

	}

	/*public static WebElement  haulageArrangementSelect(WebDriver driver){

		haulageArrangement = driver.findElement(By.xpath("//select[@id='drpHaulageArrangement']"));

		return haulageArrangement;

	}*/

	public static WebElement  haulierSelect(WebDriver driver){

		haulier = driver.findElement(By.cssSelector(PropertiesFile.read("cHaulier")));

		return haulier;

	}





	public static void switchToFrame()  {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement originplusicon=puprplePlusIcon(driver);
		new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOf(originplusicon));
		new WebDriverWait(driver, 180).until(ExpectedConditions.elementToBeClickable(originplusicon));
		try {
		originplusicon.click();
		}
		catch(Exception e) {
			
			JS.click(originplusicon);
		}
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		System.out.println("wait keyword is loaded");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseTest.getDriver().switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='routesearchafpreonfrpg.aspx?']")));
		System.err.println("origin frame is switched");
		WaitFor.checkPageIsReady();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//new WebDriverWait(BaseTest.getDriver(), 30).until(ExpectedConditions.visibilityOf(originplusicon));
		//new WebDriverWait(BaseTest.getDriver(), 30).until(ExpectedConditions.elementToBeClickable(originplusicon));
	}

	public static void selectHaulageArrangement(String haulageArranagement) {

		WebElement haulage = driver.findElement(By.xpath("//select[@id='drpHaulageArrangement']"));
		haulage.click();
		//Get all options in a list
		java.util.List<WebElement> options = haulage.findElements(By.tagName("option"));
		//Iterate thorough options
		for (WebElement option : options) {
			if(haulageArranagement.equals(option.getText())) {
			option.click();
			break;
			}
		}
		
	}
	public static void setHaulier(String haulier) {

		haulierSelect(driver).sendKeys(haulier);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath( "//a[contains(text(),'"+haulier+"')]"))));
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath( "//a[contains(text(),'"+haulier+"')]"))));
		haulierSelect(driver).sendKeys(Keys.TAB);
																															
	}
	
	

	public  static void selectOriginCargoCollectionDateAndTime(int days,String time) {

		driver.findElement(By.cssSelector(PropertiesFile.read("cOriginCargoCollectionDate"))).sendKeys(DateSelection.usingCalendar(days));
		driver.findElement(By.cssSelector(PropertiesFile.read("cFromTime"))).sendKeys(time);
		driver.findElement(By.cssSelector(PropertiesFile.read("cToTime"))).sendKeys(time);
	}

	public  static void selectOriginCargoDeliveryDateAndTime(int days,String time) {

		driver.findElement(By.cssSelector(PropertiesFile.read("cOriginCargoDeliveryDate"))).sendKeys(DateSelection.usingCalendar(days));
		driver.findElement(By.cssSelector(PropertiesFile.read("cDFromTime"))).sendKeys(time);
		driver.findElement(By.cssSelector(PropertiesFile.read("cDToTime"))).sendKeys(time);
	}
	
	public static void saveAndClose() {
		
		WebElement savethedata=driver.findElement(By.cssSelector(PropertiesFile.read("cOSaveAndClose")));
		JS.click(savethedata);
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		driver.switchTo().defaultContent();
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		
	}

}
