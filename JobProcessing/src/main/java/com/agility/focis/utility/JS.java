package com.agility.focis.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JS extends BaseTest {

	public static void click(WebElement element) {
		
		//new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(element));
		//new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);

	}

}
