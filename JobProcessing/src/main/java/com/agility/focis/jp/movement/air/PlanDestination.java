package com.agility.focis.jp.movement.air;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.DateSelection;
import com.agility.focis.utility.JS;
import com.agility.focis.utility.PropertiesFile;
import com.agility.focis.utility.WaitFor;

public class PlanDestination extends BaseTest {

	private static WebElement purpleIcon ;
	private static WebElement frame ;
	private static WebElement haulageArrangement;
	private static WebElement haulier;



	public static WebElement  puprplePlusIcon(WebDriver driver){

		purpleIcon = driver.findElement(By.xpath(PropertiesFile.read("xDestinationpurpleplusicon")));

		return purpleIcon;

	}

	


	public static void switchToFrame()  {

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement destinationplusicon=puprplePlusIcon(driver);
		new WebDriverWait(driver, 180).until(ExpectedConditions.visibilityOf(destinationplusicon));
		new WebDriverWait(driver, 180).until(ExpectedConditions.elementToBeClickable(destinationplusicon));
		try {
			destinationplusicon.click();
		}
		catch(Exception e) {
			
			JS.click(destinationplusicon);
		}
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		System.out.println("wait keyword is loaded");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseTest.getDriver().switchTo().frame(driver.findElement(By.cssSelector("iframe[src*='routesearchafpreonfrpg.aspx?']")));
		System.err.println("Destination frame is switched");
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		WaitFor.checkPageIsReady();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}