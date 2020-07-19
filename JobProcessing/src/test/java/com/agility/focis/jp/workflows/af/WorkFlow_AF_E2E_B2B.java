package com.agility.focis.jp.workflows.af;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.agility.focis.jp.air.tasks.Activities;
import com.agility.focis.jp.air.tasks.FlightEvents;
import com.agility.focis.jp.initiateJob.InitiateJobPage1;
import com.agility.focis.jp.initiateJob.InitiateJobPage2;
import com.agility.focis.jp.initiateJob.InitiateJobPage3;
import com.agility.focis.jp.initiateJob.InitiateJobPage4;
import com.agility.focis.jp.movement.air.EnterEstimates;
import com.agility.focis.jp.movement.air.PlanAirportToAirport;
import com.agility.focis.jp.movement.air.PlanDestination;
import com.agility.focis.jp.movement.air.PlanOrigin;
import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.DateSelection;
import com.agility.focis.utility.MoreLinks;
import com.agility.focis.utility.NavigateTo;
import com.agility.focis.utility.PropertiesFile;
import com.agility.focis.utility.SwitchTo;
import com.agility.focis.utility.Tasks;

import net.bytebuddy.implementation.bind.ParameterLengthResolver;

public class WorkFlow_AF_E2E_B2B extends BaseTest{

	
  
	@Test(invocationCount=1)
	public  void complete() throws Exception {

		
		BaseTest.login("chrome");
		driver.navigate().to("https://focisagile.agility.com/pages/focisjp/bookingdetails/bookingdetailsfrpg.aspx?q=cGFnZWlkfEJvb2tpbmdEZXRhaWxzRnJQZyZhY3Rpb25pZHxPcGVuQm9va2luZ0RldGFpbHMmYWN0aW9uY3JpdGVyaWF8JTViQm9va2luZ0RldGFpbHMlNWQuJTViSm9iTnVtYmVyJTVkKyUzZCslMjcxMjg5MTklMjcmbmV4dGFjdGlvbmNyaXRlcmlhfCZJc1BvcHVwUGFnZXxmYWxzZSZwZ2NoaWR8YzlmMWYwNTFhYjE2NDE1NGJkMjczN2E3OWRlYjVlZjdfdmFmc2Fwd3ptc2xwZHV5YWFtZG9rdXBnJlVzZXJMYW5ndWFnZXwm-2ZIT74ur47Q%3d");
		Tasks.clickTaskstab();
		/*initiateJobPremier();
		planMainCarriage();
		PlanOrigin.switchToFrame();
		PlanOrigin.selectHaulageArrangement("Agility");
		PlanOrigin.setHaulier("Garrison");
		PlanOrigin.selectOriginCargoCollectionDateAndTime(1, DateSelection.timeInHHMM());
		PlanOrigin.selectOriginCargoDeliveryDateAndTime(1, DateSelection.timeInHHMM());
		PlanOrigin.saveAndClose();
		PlanDestination.switchToFrame();
		PlanOrigin.selectHaulageArrangement("Agility");
		PlanOrigin.setHaulier("Garrison");
		PlanOrigin.selectOriginCargoCollectionDateAndTime(1, DateSelection.timeInHHMM());
		PlanOrigin.selectOriginCargoDeliveryDateAndTime(1, DateSelection.timeInHHMM());
		PlanOrigin.saveAndClose();
		//MoreLinks.addCustomerReferences("Packing List", "VERTIV ENERGY PRIVATE LIMITED");
	//	MoreLinks.addCustomerReferences("Packing List", "Presspart Manufacturing Limited");
		Tasks.clickTasks(driver);
		Activities.performActivityPageNewWindow(2);
		
		FlightEvents.actualization(4, -1,2);
		System.err.println("Departure confirmation is performed");
		Tasks.clickPerformActivityIcon(5);
		FlightEvents.actualization(5, -1,5);
		Activities.performActivityPageNewWindow(6);
		Activities.performActivityPageNewWindow(7);*/
		Activities.performActivityPageNewWindowWithUploadFile(3);
		
		
		
		
	}

	public static  void initiateJobPremier() {

		try {
			BaseTest.login("chrome");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
			InitiateJobPage1.selectDestinationstakeholder("SkyPatrol");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InitiateJobPage1.clickNextButton();

		InitiateJobPage2.selectIncoterm("DAP");
		InitiateJobPage2.setIncotermLocation(driver).sendKeys("Mumbai");
		InitiateJobPage2.selectHAWBAirportofDeparture("BOM");
		InitiateJobPage2.selectHAWBAirportofArrival("ORD");
		InitiateJobPage2.selectBranchfromPicklistO("IN", "Air Export", "Mumbai", "Yes");
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
	}

	public static void planMainCarriage() {

		int rowno=1;
		PlanAirportToAirport.clickMovementtab();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("movement  tab  is clicked");
		PlanAirportToAirport.clickaddmainCarriage();
		System.out.println("add main carriage is clicked");
		SwitchTo.airframe();

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cJobType")))));
		// new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cJobType")))));
		try {
			PlanAirportToAirport.jobType(driver).click();
		}
		catch(Exception e) {

			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(PropertiesFile.read("cJobType"))));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cJobType"))));
		}
		PlanAirportToAirport.selectJobtype("BackToBack");
		PlanAirportToAirport.acceptJobTypeChange();
		PlanAirportToAirport.selectCarrier("EK");
		PlanAirportToAirport.setFlightNumber(rowno, "678");
		PlanAirportToAirport.selectAPOD(rowno, "BOM");
		PlanAirportToAirport.selectAPOA(rowno, "ORD");
		PlanAirportToAirport.setETDDate(rowno, 2);
		PlanAirportToAirport.setETDTime(rowno, DateSelection.timeInHHMM());
		PlanAirportToAirport.setETADate(rowno, 5);
		PlanAirportToAirport.setETATime(rowno, DateSelection.timeInHHMM());
		PlanAirportToAirport.clickMAWB();
		PlanAirportToAirport.ClickSaveAndCloseButton();
		EnterEstimates.forConfirmInternationalFreight(1, "Garrisons Logistics Pvt Ltd", "11", "12");

	}
}
