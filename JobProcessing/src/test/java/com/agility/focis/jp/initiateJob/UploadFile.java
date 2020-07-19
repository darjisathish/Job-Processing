package com.agility.focis.jp.initiateJob;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.DateSelection;
import com.agility.focis.utility.RobotClass;
import com.agility.focis.utility.SwitchTo;
import com.agility.focis.utility.Tasks;

public class UploadFile extends BaseTest{

	
	public static void main(String[] args) throws Exception {
		
	/*	BaseTest.login("chrome");
		BaseTest.getDriver().navigate().to("http://focissit.agility.com/pages/focisjp/bookingdetails/bookingdetailsfrpg.aspx?q=cGFnZWlkfEJvb2tpbmdEZXRhaWxzRnJQZyZhY3Rpb25pZHxPcGVuQm9va2luZ0RldGFpbHMmYWN0aW9uY3JpdGVyaWF8JTViQm9va2luZ0RldGFpbHMlNWQuJTViSm9iTnVtYmVyJTVkKyUzZCslMjc0Njg0MiUyNyZuZXh0YWN0aW9uY3JpdGVyaWF8JklzUG9wdXBQYWdlfGZhbHNlJnBnY2hpZHxhNTlhYWZmMjk4MTg0NzQyOGZlYzU4ZWQ1YzhlZWYxYV92cjFqZnR3aHFkZTRnb2Nldm9xdW1rYmImVXNlckxhbmd1YWdlfCY%3d-%2fpqE7izs90w%3d");
		//Tasks.tasks.click();
		Tasks.clickPerformActivityIcon(3);
		SwitchTo.switchToNewWindow(2);
		BaseTest.getDriver().findElement(By.cssSelector("#PWCMasterPage_PWCWebPartManager_gwpPerformOriginCustomsClearanceFr1_PerformOriginCustomsClearanceFr1_txtOthImpDocFile_btnPopup")).click();
       RobotClass.uploadFileWithRobot("C:\\Users\\rgurajala\\FOCiS_Automation_Script\\FOCiS_OF_AF_JA\\Drivers\\batchpiv.pdf");		
		*/
		
		System.out.println(DateSelection.addTimeInHHMM(25));

	}

}

