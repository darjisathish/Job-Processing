package com.agility.focis.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Sendkeys extends BaseTest{

	public static void enter(String locator) {
		
		BaseTest.getDriver().findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
	}
}
