package com.agility.focis.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Click extends BaseTest {

	 public static void usingExecutor(WebElement ele) {
		 
		 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		 
		 try {
		 
			WaitFor.checkPageIsReady();
			WaitFor.checkPageIsjqueryReady();
			ele.click();
			//WaitFor.checkPageIsReady();
			//WaitFor.checkPageIsjqueryReady();
	 }
		
		 catch(Exception e) {
			 
			 System.err.println("JS executor script is snippet executed");
			 WaitFor.checkPageIsReady();
			WaitFor.checkPageIsjqueryReady(); 
			try {
				Thread.sleep(3000);
				 new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(ele));
				 new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ele));
			} catch (Exception e2) {
				ele.click();
			}}
			
			 
			 
}}

	 
