package com.agility.focis.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Tasks extends BaseTest{
	
	//@FindBy(how = How.CSS, using = "#ServicesTab")
    private   static WebElement tasks;
	
	
	
	@FindBy(how = How.XPATH, using = "//span[text()='Complete']")
    private  static WebElement activityStatus;
	
	public static WebElement  clickTasks(WebDriver driver){

		tasks = driver.findElement(By.cssSelector("#ServicesTab"));

		return tasks;

	}
	
	public static void clickTaskstab() {
		
		clickTasks(driver).click();
	}

	public static  void clickPerformActivityIcon(int rowNo) {
		
		/*WebElement tasks=clickTasks(driver);
		try {
		tasks.click();
		}
		catch(Exception e) {
			
			JS.click(tasks);
		}*/
		
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		WebElement activity=BaseTest.getDriver().findElement(By.xpath(PropertiesFile.read("xEditActivity")+rowNo+"]"));
		try {
			activity.click();
			}
			catch(Exception e) {
				
				JS.click(activity);
			}
		
		   /* if(driver.findElements(By.xpath("(//button[text()='OK'])[2]")).size()>1){
		    	
		    	WebElement ok=driver.findElement(By.xpath("(//button[text()='OK'])[2]"));
		    	JS.click(ok);
		    }*/
		
		
		//SwitchTo.switchToNewWindow(2);
		
	}
	
	
	public static void clickComplete() {
		
		WebElement complete=driver.findElement(By.cssSelector("input[title='Complete']"));
		ScrollAndHighlight.scrolltoElement(complete);
		Click.usingExecutor(complete);
	  }
	  
	 
	  
	  public static void closeWindow() {
		  
		  try {
			  
			  WaitFor.checkPageIsReady();
			  WaitFor.checkPageIsjqueryReady();
			  new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).
			  until(ExpectedConditions.visibilityOf(activityStatus));
			  new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).
			  until(ExpectedConditions.elementToBeClickable(activityStatus));
			  WebElement activityStatus=driver.findElement(By.cssSelector("//span[text()='Complete']"));
			  String status=activityStatus.getText();
			  Assert.assertEquals(status, "Complete");
		  }
		  catch(Exception e) {
			  
			  System.err.println("Status is not changed to Complete");
		  }
		  BaseTest.getDriver().close();
	  }
}
