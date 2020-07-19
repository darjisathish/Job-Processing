package com.agility.focis.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigateTo extends BaseTest{
	
	
	public static  void menu(String Menuname,String subMenuname) throws Exception 
	{
		     
		System.out.println("Entered unto menu screen");
		BaseTest.driver.findElement(By.xpath("//span[text()='"+Menuname+"']")).click();
		System.out.println(Menuname +" is clicked");
		new WebDriverWait(driver, 30);
		ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='"+Menuname+"']"));
		Thread.sleep(1000);
		BaseTest.driver.findElement(By.xpath("//span[text()='"+subMenuname+"']")).click();
		System.out.println(subMenuname +" is clicked");
		WaitFor.checkPageIsReady();
		
		WaitFor.checkPageIsjqueryReady();
		
			}
}
