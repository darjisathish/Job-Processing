package com.agility.focis.jp.initiateJob;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.ExtentManager;
import com.agility.focis.utility.ExtentTestManager;
import com.agility.focis.utility.NavigateTo;
import com.agility.focis.utility.TakeScreenshot;

public class DefaultOriginOfficeBasedOnMDMConfig extends BaseTest{

	
	
	@BeforeMethod
	public static void loginFocisApplication() throws Exception {

		BaseTest.login("chrome");

	}

	@Test
	public  void basedOnOriginStakeholder(Method method) {

		ExtentTestManager.startTest(method.getName(), "default origin office based on MDM configuration");
		BaseTest.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			NavigateTo.menu("Job","Job Booking");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InitiateJobPage1.bookwithoutemplatebutton(driver).click();
		InitiateJobPage1.selectProduct("Air Freig");
		InitiateJobPage1.selectProducttype("Premier");
		try {
			InitiateJobPage1.selectOriginstakeholder("VERTIV ENERGY PRIVATE LIMITED");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InitiateJobPage1.clickNextButton();
		String originOffice=InitiateJobPage2.getOriginOffice(driver).getAttribute("value").trim();
		System.err.println(originOffice);
        Assert.assertEquals(originOffice, "Mumbai Air Export");
        TakeScreenshot.captureScreen("originOffice");

        ExtentTestManager.endTest();
	    ExtentManager.getReporter().flush();
	    
	   
	}
	
	
				}

