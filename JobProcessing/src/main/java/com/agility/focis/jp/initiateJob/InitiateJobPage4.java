package com.agility.focis.jp.initiateJob;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.LogsTest;
import com.agility.focis.utility.PropertiesFile;
import com.agility.focis.utility.WaitFor;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class InitiateJobPage4 extends BaseTest {
	
	static ExtentReports report;
static ExtentTest test;

	//static  Logger log = Logger.getLogger("devpinoyLogger");
	static WebDriverWait wait;
	
	public static void selectCommodityType(String commoditType) {
		
		Select commodiType=new Select(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cCommodityType"))));
		commodiType.selectByVisibleText(commoditType);
	}

	public static void setTotalPackages(String totalpackages) {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.read("ctotalPackages"))));
		BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("ctotalPackages"))).sendKeys(totalpackages);
	}
	
	public static void setMarksAndNumbers(String MarksAndNumbers) {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.read("cmarksandNumbers"))));
		BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cmarksandNumbers"))).sendKeys(MarksAndNumbers);
	}
	
	public static void setDescription(String Description) {

		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.read("xdescription"))));
		BaseTest.getDriver().findElement(By.xpath(PropertiesFile.read("xdescription"))).sendKeys(Description);
	}
	
	public static void initiateJobWithOutSavingAsTemplate() {
		
		BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cinitiateJob"))).click();
		BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cnoThanks"))).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesFile.read("cMovementTab"))));
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.cssSelector(PropertiesFile.read("cMovementTab"))));
		String jobNo=BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cJobNumber"))).getText();
		//System.err.println(" jobNo is "+jobNo);
		
	     LogsTest.logsGeneration("jobNo is "+jobNo);
	    // test.log(LogStatus.INFO, "jobNo2 is "+jobNo);
	     Reporter.log("jobNo is "+jobNo);
	     Reporter.getCurrentTestResult();
	     Reporter.getOutput();
	   

	}
}
