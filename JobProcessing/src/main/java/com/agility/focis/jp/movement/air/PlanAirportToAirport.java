package com.agility.focis.jp.movement.air;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.DateSelection;
import com.agility.focis.utility.JS;
import com.agility.focis.utility.Click;
import com.agility.focis.utility.PropertiesFile;
import com.agility.focis.utility.ScrollAndHighlight;
import com.agility.focis.utility.WaitFor;

public class PlanAirportToAirport extends BaseTest {

    public static WebDriver driver=BaseTest.getDriver();
	private static WebElement movement ;
	private static WebElement addMainCarriage ;
	private static WebElement jobType ;
	private static WebElement jobChangeMessage;
	private static WebElement carrierCode;
	private static WebElement Ok;
	private static WebElement flightNumber;
	private static WebElement airportOfDeparturesearchpciker;
	private static WebElement airportOfArrivalsearchpicker;
	private static WebElement saveAndClose;
	
	
	
	

	public static void clickMAWB() {
		
		BaseTest.getDriver().findElement(By.cssSelector("#tdFetchMAWB")).click();
		
	}

	public static void clickMovementtab() {

		Click.usingExecutor(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("CMovement"))));
	}

	public static WebElement  addMainCarriagePurplePlusIcon(WebDriver driver){

		addMainCarriage = driver.findElement(By.cssSelector(PropertiesFile.read("cAddMainCarriage")));

		return addMainCarriage;

	}
	public static WebElement  jobType(WebDriver driver){

		jobType = driver.findElement(By.cssSelector(PropertiesFile.read("cJobType")));

		return jobType;

	}

	public static WebElement carrierCodepicklist(WebDriver drver) {
		carrierCode = driver.findElement(By.cssSelector(PropertiesFile.read("cCarrierCodeSearchPicker")));

		return carrierCode;

	}
	public static WebElement  okButton(WebDriver driver){

		Ok = driver.findElement(By.xpath(PropertiesFile.read("xOkButton")));

		return Ok;

	}

	public static WebElement flightNumber(WebDriver driver,int rowNo) {

		flightNumber = driver.findElement(By.cssSelector(PropertiesFile.read("cFlightNumber")+rowNo));

		return flightNumber;
	}
	public static WebElement clickAirportOfDeparturesearchpciker(int rowNo) {

		airportOfDeparturesearchpciker = driver.findElement(By.cssSelector(PropertiesFile.read("cAirportofDeparture")+rowNo+"_btnPopup"));

		return airportOfDeparturesearchpciker;
	}
	public static WebElement clickairportOfArrivalsearchpicker(int rowNo) {

		airportOfArrivalsearchpicker = driver.findElement(By.cssSelector(PropertiesFile.read("CaIRPORTOfArrival")+rowNo+"_btnPopup"));

		return airportOfArrivalsearchpicker;
	}

	public static WebElement  saveAndCloseButton(WebDriver driver){

		saveAndClose = driver.findElement(By.cssSelector(PropertiesFile.read("cSaveAndClosebutton")));

		return saveAndClose;

	}

	public static void clickaddmainCarriage() {

		JS.click(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cAddMainCarriage"))));
	}

	public static void  selectJobtype(String jobType){


		//new WebDriverWait(BaseTest.getDriver(), 30).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesFile.read("cJobTypeDropdown")+jobType)));

		try {
			BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cJobTypeDropdown")+jobType)).click();}
		catch(Exception e) {

			//new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(PropertiesFile.read("cJobTypeDropdown")+jobType)));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cJobTypeDropdown")+jobType)));
		}

	}

	public static void acceptJobTypeChange() {

		okButton(driver).click();;

	}

	public static void selectCarrier(String carrier) {

		carrierCodepicklist(driver).click();
		new WebDriverWait(BaseTest.getDriver(),30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertiesFile.read("xcode"))));
		new WebDriverWait(BaseTest.getDriver(), 30).until(ExpectedConditions.elementToBeClickable(By.xpath(PropertiesFile.read("xcode")))).sendKeys(carrier,Keys.ENTER);
		WebElement SearchCodeResults=BaseTest.getDriver().findElement(By.xpath("//table[@id='pnlPopupGrid']/tbody/tr[2]/td[2]/a[text()='"+carrier+"']"));
		new WebDriverWait(BaseTest.getDriver(),5).until(ExpectedConditions.visibilityOf(SearchCodeResults));
		new WebDriverWait(BaseTest.getDriver(), 5).until(ExpectedConditions.elementToBeClickable(SearchCodeResults));
		try {
			SearchCodeResults.click();
		}
		catch(Exception e) {

			JS.click(SearchCodeResults);
		}

	}
	
	public static void setFlightNumber(int rowno,String flighno) {
		
		flightNumber(driver, rowno).sendKeys(flighno);
	}

	public static void selectAPOD(int rowNo,String portName) {

		clickAirportOfDeparturesearchpciker(rowNo).click();
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesFile.read("ccode"))));
		new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).until(ExpectedConditions.elementToBeClickable(By.cssSelector(PropertiesFile.read("ccode")))).sendKeys(portName,Keys.ENTER);
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).until(ExpectedConditions.elementToBeClickable(By.xpath(PropertiesFile.read("xcodeResults")))).click();
	}

	public static void selectAPOA(int rowNo,String portName) {

		clickairportOfArrivalsearchpicker(rowNo).click();
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesFile.read("ccode"))));
		new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).until(ExpectedConditions.elementToBeClickable(By.cssSelector(PropertiesFile.read("ccode")))).sendKeys(portName,Keys.ENTER);
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).until(ExpectedConditions.elementToBeClickable(By.xpath(PropertiesFile.read("xcodeResults")))).click();
	}

	public static void setETDDate(int rowNumber,int days) {

		BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cETDDate")+rowNumber)).sendKeys(DateSelection.usingCalendar(days));;
	}
	public static void setETADate(int rowNumber,int days) {

		BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("CETADate")+rowNumber)).sendKeys(DateSelection.usingCalendar(days));;
	}

	public static void setETDTime(int rowNumber,String time) {

		BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cETDTime")+rowNumber)).sendKeys(time);;
	}

	public static void setETATime(int rowNumber,String time) {

		BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cETATime")+rowNumber)).sendKeys(time);;
	}
	
	
	public static void ClickSaveAndCloseButton() {

		saveAndClose=BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cSaveAndClosebutton")));
		JS.click(saveAndClose);
	}


}
