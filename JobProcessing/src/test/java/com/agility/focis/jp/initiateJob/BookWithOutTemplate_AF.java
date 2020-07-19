package com.agility.focis.jp.initiateJob;


import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.MethodHelper;

import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.ExtentManager;
import com.agility.focis.utility.ExtentTestManager;
import com.agility.focis.utility.NavigateTo;
import com.agility.focis.utility.PropertiesFile;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BookWithOutTemplate_AF extends BaseTest {

	
	
	@BeforeSuite
	public static void loginFocisApplication() throws Exception {
		
		BaseTest.login("chrome");
		
	}
	
	@Test(invocationCount=1)
	public static void initiateJob(Method method)  {
		
		ExtentTestManager.startTest(method.getName(), "Air Freight");
		BaseTest.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		try {
			NavigateTo.menu("Job","Job Booking");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InitiateJobPage1.bookwithoutemplatebutton(driver).click();
		InitiateJobPage1.selectProduct("Air Freight");
		InitiateJobPage1.selectProducttype("Premier");
		try {
			InitiateJobPage1.selectOriginstakeholder("VERTIV ENERGY PRIVATE LIMITED");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			InitiateJobPage1.selectDestinationstakeholder("Presspart Manufacturing Limited");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InitiateJobPage1.clickNextButton();
		
		InitiateJobPage2.selectIncoterm("DAP");
		InitiateJobPage2.setIncotermLocation(driver).sendKeys("Mumbai");
		InitiateJobPage2.selectHAWBAirportofDeparture("BOM");
		InitiateJobPage2.selectHAWBAirportofArrival("ORD");
		//InitiateJobPage2.selectBranchfromPicklistO("IN", "Air Export", "Mumbai", "Yes");
		InitiateJobPage2.selectBranchfromPicklistD("US", "Air Import", "Chicago", "Yes");
		InitiateJobPage1.clickNextButton();
		
		InitiateJobPage3.setNoOfPackages(1, "11");
		InitiateJobPage3.selectType(1, "BAG");
		InitiateJobPage3.setPerPieceWeight(1, "12");
		InitiateJobPage3.setVolume(1, "230");
		InitiateJobPage3.setShippingMarks(1, "TEST");
		// description row number started from 2
		//InitiateJobPage3.setDescription(2, "test2");
		InitiateJobPage1.clickNextButton();
		
		/*InitiateJobPage4.setTotalPackages("11");
		//InitiateJobPage4.setMarksAndNumbers("DTDC||||789");
		//InitiateJobPage4.setDescription("Shipping");
*/		InitiateJobPage4.selectCommodityType("General Cargo");
		InitiateJobPage4.initiateJobWithOutSavingAsTemplate();
		
		ExtentTestManager.endTest();
	    ExtentManager.getReporter().flush();
		
	}
	@AfterSuite
	public void screenShot(ITestResult result){
		
		if(ITestResult.FAILURE==result.getStatus()){
			 try{
				 File src=(File)((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Copy files to specific location 
				 // result.getName() will return name of test case so that screenshot name will be same as test case name
				 String currentDir = System.getProperty("user.dir");
				 System.err.println();
				 FileUtils.copyFile(src, new File(currentDir+"\\FailedScreenshots"+result.getName()+".png"));
				 System.out.println("Successfully captured a screenshot");
				 }catch (Exception e){
				 System.out.println("Exception while taking screenshot "+e.getMessage());
				 } 
			 
			 
				 }
				BaseTest.getDriver().quit();
				 }
	
				}
    