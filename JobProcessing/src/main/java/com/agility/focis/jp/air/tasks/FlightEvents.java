package com.agility.focis.jp.air.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.agility.focis.utility.DateSelection;
import com.agility.focis.utility.Tasks;
import com.agility.focis.utility.WaitFor;

public class FlightEvents extends Tasks{

	
	
	
	
	public  static WebElement status=driver.findElement(By.cssSelector("select#PWCMasterPage_PWCWebPartManager_gwpBookingDetailsFr1_BookingDetailsFr1_MovementTabFr1_ConsolidatedEventsLsUc1_drpStatus"));
	public  static WebElement time=driver.findElement(By.cssSelector("input#PWCMasterPage_PWCWebPartManager_gwpBookingDetailsFr1_BookingDetailsFr1_MovementTabFr1_ConsolidatedEventsLsUc1_txtUpdateEventTime"));
	public  static WebElement date=driver.findElement(By.cssSelector("input#PWCMasterPage_PWCWebPartManager_gwpBookingDetailsFr1_BookingDetailsFr1_MovementTabFr1_ConsolidatedEventsLsUc1_txtUpdateEventDate"));
    public  static WebElement remarks=driver.findElement(By.cssSelector("#PWCMasterPage_PWCWebPartManager_gwpBookingDetailsFr1_BookingDetailsFr1_MovementTabFr1_ConsolidatedEventsLsUc1_txtUpdateEventRemarks"));
	public  static WebElement saveAndClose=driver.findElement(By.cssSelector("#PWCMasterPage_PWCWebPartManager_gwpBookingDetailsFr1_BookingDetailsFr1_MovementTabFr1_ConsolidatedEventsLsUc1_btnEventsUpdate"));
	
	public static void actualization(int rowNo,int days,int Departuredays) {
		
		Tasks.clickPerformActivityIcon(rowNo);
		//WaitFor.explicitWait(status);
		Select select=new Select(status);
		select.selectByVisibleText("Actual");
		String datefrommaincarriage=date.getAttribute("value");
		System.err.println(datefrommaincarriage);
		Assert.assertEquals(datefrommaincarriage, DateSelection.usingCalendar(Departuredays));
		date.clear();
		System.out.println(DateSelection.usingCalendar(days));
		date.sendKeys(DateSelection.usingCalendar(days));
		time.sendKeys(DateSelection.timeInHHMM());
		remarks.sendKeys("Deparure is delayed");
		saveAndClose.click();
		//WaitFor.explicitWait(clickTasks(driver));
		
	}
	
}
