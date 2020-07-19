package com.agility.focis.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitFor extends BaseTest {
	
	static WaitFor WaitFor=new WaitFor();
	
	public static int counter = 0;
	//public static WebDriver driver;

	public static void checkPageIsReady() {

		  JavascriptExecutor js = (JavascriptExecutor)driver;


		  //Initially bellow given if condition will check ready state of page.
		  
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   System.out.println("Page Is loaded.");
		   return; 
		  } 

		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<25; i++){ 
		   try {
		    Thread.sleep(1000);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		    break; 
		   }   
		  }
		
		 }
	
	public static void checkPageIsjqueryReady() {
		
		System.out.println(" *** Wating *** for JQuery Ready State to be complete");

		try {

		new WebDriverWait(driver, 300, 100).until(new ExpectedCondition<Boolean>() {



					public Boolean apply(WebDriver d) {
						JavascriptExecutor js = (JavascriptExecutor)d;
						String readyState = js.executeScript("return !!window.jQuery && window.jQuery.active == 0").toString();
						System.err.println(" ***  Ready State ***  is: " + readyState); // Will print true or false
						return (Boolean)js.executeScript(
								"return !!window.jQuery && window.jQuery.active == 0");
					}
				});

		System.out.println(" *** Custom JQuery *** IS FULLY LOADED");
		
	} 
	catch (Exception e) {
		System.out.println(" *** Custom JQuery *** keyword failed");
		e.printStackTrace();
	}


	

		 /* JavascriptExecutor js = (JavascriptExecutor)driver;


		  //Initially bellow given if condition will check ready state of page.
		  
		  if (js.executeScript("return jQuery.active==0").toString().equals("0")){ 
		   System.out.println("Page Is loaded.");
		   return; 
		  } 

		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<25; i++){ 
		   try {
		    Thread.sleep(25);
		    System.out.println("jquery is not ready & iterating using for loop "+ i);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return jQuery.active==0").toString().equals("0")){ 
		    break; 
		   }   
		  }
		 }*/
} 

	public static void waitForWrapperToExpire() throws Exception{
		double startTime = System.currentTimeMillis();
		int secondsToWait = 1200;
		outerloop:
		while(counter<secondsToWait){
			if(
			(driver.findElements(By.xpath("//div[@id='fancybox-loading']")).size()>0)||
			(driver.findElements(By.xpath("//div[@class='loadmask-msg']")).size()>0)||
			(driver.findElements(By.xpath("//div[@class='fancybox-wrap fancybox-desktop fancybox-type-iframe fancybox-tmp']")).size()>0)||
			(driver.findElements(By.xpath("//div[@class = 'loading ui-state-default ui-state-active' and @style = 'display: block;']")).size()>0)

			)
			{
				Thread.sleep(1000);
				System.out.println(counter);
				counter++;
				waitForWrapperToExpire();
			}
			else{

				break outerloop;
			}
		}
		if(counter==(secondsToWait-1)){
			TakeScreenshot.captureScreen("screename");
		}
		double finishTime = System.currentTimeMillis();
		double measureTime = (finishTime - startTime) / 1000;
		System.err.println("Time Taken to executed waitForWrapperToExpire method is in HH:MM:SS format " + formatSeconds(measureTime));
	}

	public static String formatSeconds(double timeInSeconds){

		timeInSeconds=(int)timeInSeconds;

		int secondsLeft = (int) (timeInSeconds % 3600 % 60);
		int minutes = (int) Math.floor(timeInSeconds % 3600 / 60);
		int hours = (int) Math.floor(timeInSeconds / 3600);

		String HH = (String) (hours < 10 ? "0" + hours : hours);
		String MM = (String) (minutes < 10 ? "0" + minutes : minutes);
		String SS = (String) (secondsLeft < 10 ? "0" + secondsLeft : secondsLeft);

		return HH + ":" + MM + ":" + SS;
	}

	public static void explicitWait(WebElement ele) {
		
		new WebDriverWait(BaseTest.getDriver(), 100).until(ExpectedConditions.visibilityOf(ele));
		new WebDriverWait(BaseTest.getDriver(), 100).until(ExpectedConditions.elementToBeClickable(ele));
	}
	
public static void clickOnElementUsingExplicitWait(WebElement ele) {
		
	    checkPageIsReady();
	    //checkPageIsjqueryReady();
		new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(ele));
		try {
		new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(ele)).click();
		}
		catch(Exception e) {
			
			JS.click(ele);
		}
	}

public static void SetTextUsingExplicitWait(WebElement ele,String text) {
	
	new WebDriverWait(WaitFor.getDriver(), 100).until(ExpectedConditions.visibilityOf(ele));
	new WebDriverWait(WaitFor.getDriver(), 100).until(ExpectedConditions.elementToBeClickable(ele)).sendKeys(text);;;
}
}
