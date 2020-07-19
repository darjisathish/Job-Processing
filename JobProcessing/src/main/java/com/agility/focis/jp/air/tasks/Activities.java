package com.agility.focis.jp.air.tasks;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.JS;
import com.agility.focis.utility.RobotClass;
import com.agility.focis.utility.ScrollAndHighlight;
import com.agility.focis.utility.SwitchTo;
import com.agility.focis.utility.Tasks;
import com.agility.focis.utility.WaitFor;

public class Activities extends BaseTest{

	public static void performActivityPageNewWindow(int Rowno) throws Exception {

		String parent=driver.getWindowHandle();
		
		Tasks.clickPerformActivityIcon(Rowno);
		
		//System.err.println(new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='OK'])[2]")))).isDisplayed());
		
		waitForNewWindow(driver, 60);
		//Thread.sleep(5000);
		Set<String> windows=driver.getWindowHandles();
		
		System.err.println(windows);
		System.err.println(windows.size());
		for(String s:windows) {
			
			if(!parent.equals(s)) {
				
				driver.switchTo().window(s);
				Tasks.clickComplete();
				Tasks.getDriver().close();
				driver.switchTo().window(parent);
				WaitFor.checkPageIsjqueryReady();
				WaitFor.checkPageIsjqueryReady();
				
				try {
				SoftAssert complete=new SoftAssert();
				WebElement status=driver.findElement(By.xpath("(//span[text()='Complete'])["+Rowno+"]"));
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(status));
				new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(status));
				String activitystatus=status.getAttribute("innerText").trim();
				System.err.println(activitystatus);
				System.err.println("**************************");
				complete.assertEquals(activitystatus, "Complete");
				complete.assertAll();
				}
				catch(Exception e) {
				
			}}
		}
		
			//SwitchTo.switchToNewWindow("Booking Confirmation to Customer");
		
		
		/*SoftAssert complete=new SoftAssert();
		complete.assertTrue(condition);*/
		

	}
	
	public static void performActivityPageNewWindowWithUploadFile(int Rowno) throws Exception {

		String parent=driver.getWindowHandle();
		
		Tasks.clickPerformActivityIcon(Rowno);
		
		//System.err.println(new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[text()='OK'])[2]")))).isDisplayed());
		
		waitForNewWindow(driver, 60);
		//Thread.sleep(5000);
		Set<String> windows=driver.getWindowHandles();
		
		System.err.println(windows);
		System.err.println(windows.size());
		for(String s:windows) {
			
			if(!parent.equals(s)) {
				
				driver.switchTo().window(s);
				WebElement ChooseFile=driver.findElement(By.id("PWCMasterPage_PWCWebPartManager_gwpPerformOriginCustomsClearanceFr1_PerformOriginCustomsClearanceFr1_txtOthImpDocFile_btnPopup"));
				ChooseFile.click();
				
				RobotClass.uploadFileWithRobot("C:\\Users\\rgurajala\\FOCiS_Automation_Script\\FOCiS_OF_AF_JA\\Drivers\\batchpiv.pdf");
				JS.click(driver.findElement(By.id("btnDocUpload")));
				Tasks.clickComplete();
				Tasks.getDriver().close();
				driver.switchTo().window(parent);
				WaitFor.checkPageIsjqueryReady();
				WaitFor.checkPageIsjqueryReady();
				
				try {
				SoftAssert complete=new SoftAssert();
				WebElement status=driver.findElement(By.xpath("(//span[text()='Complete'])["+Rowno+"]"));
				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(status));
				new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(status));
				String activitystatus=status.getAttribute("innerText").trim();
				System.err.println(activitystatus);
				System.err.println("**************************");
				complete.assertEquals(activitystatus, "Complete");
				complete.assertAll();
				}
				catch(Exception e) {
				
			}}
		}
		
			//SwitchTo.switchToNewWindow("Booking Confirmation to Customer");
		
		
		/*SoftAssert complete=new SoftAssert();
		complete.assertTrue(condition);*/
		

	}
	
	public static boolean waitForNewWindow(WebDriver driver, int timeout){


        boolean flag = false;

        int counter = 0;

        long startTime = System.currentTimeMillis();
        while(!flag){

            try {

                Set<String> winId = driver.getWindowHandles();

                if(winId.size() > 1){

                    flag = true;

                    long endtime = System.currentTimeMillis();
                    long diff=endtime-startTime;
                    Reporter.log("Time difference is" +(diff/1000)+"in seconds to open the activity page");
                    return flag;

                }
                else {
                	
                	JS.click(driver.findElement(By.xpath("(//button[text()='OK'])[2]")));
                }

                Thread.sleep(1000);

                counter++;

                if(counter > timeout){

                    return flag;

                }

            } catch (Exception e) {

                System.out.println(e.getMessage());

                return false;

            }

        }

        
        return flag;
	
 }

	public static void performArrivalNotice(int Rowno) {

		Tasks.clickPerformActivityIcon(Rowno);
		Tasks.clickComplete();
		Tasks.getDriver().close();

	}

	public static void performCRC(int Rowno) {

		Tasks.clickPerformActivityIcon(Rowno);
		Tasks.clickComplete();
		Tasks.getDriver().close();

	}


}
