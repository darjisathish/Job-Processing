package com.agility.focis.jp.initiateJob;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.Click;
import com.agility.focis.utility.JS;
import com.agility.focis.utility.NavigateTo;
import com.agility.focis.utility.PropertiesFile;
import com.agility.focis.utility.WaitFor;

public class InitiateJobPage2 extends BaseTest  {

	//static WebDriver driver;
	static WebDriverWait wait=new WebDriverWait(driver, 30);
	private static WebElement Incoterm ;
	private static WebElement IncotermLocation ;
	private static WebElement HAWBAirportofDeparture;
	private static WebElement HAWBAirportofArrival;
	private static WebElement OriginOffice;
	private static WebElement originOfficetext;
	private static WebElement DestinationOffice;
	private static WebElement code;
	private static WebElement country;
	private static WebElement siteName;
	private static WebElement department;
	private static WebElement isLive;
	private static WebElement type;
	
	
	

	public static WebElement  incotermDropdown(WebDriver driver){

		Incoterm = driver.findElement(By.cssSelector(PropertiesFile.read("Incoterm")));

		return Incoterm;

	}


	public static WebElement  setIncotermLocation(WebDriver driver){

		IncotermLocation = driver.findElement(By.cssSelector(PropertiesFile.read("incotermlocation")));

		return IncotermLocation;

	}

	public static WebElement HAWBDeparture(WebDriver driver){

		HAWBAirportofDeparture = driver.findElement(By.cssSelector(PropertiesFile.read("HAWBAirportofDeparture")));

		return HAWBAirportofDeparture;

	}
	
	public static WebElement setCode(WebDriver driver){

		code = driver.findElement(By.cssSelector(PropertiesFile.read("ccode")));

		return code;

	}
	

	public static WebElement HAWBArrival(WebDriver driver){

		HAWBAirportofArrival = driver.findElement(By.cssSelector(PropertiesFile.read("HAWBAirportofArrival")));

		return HAWBAirportofArrival;

	}
	
	
	


	public static WebElement selectoriginOffice(WebDriver driver){

		OriginOffice = driver.findElement(By.cssSelector(PropertiesFile.read("OriginOffice")));

		return OriginOffice;

	}
	public static WebElement selectDestinationOffice(WebDriver driver){

		DestinationOffice = driver.findElement(By.cssSelector(PropertiesFile.read("DestinationOffice")));

		return DestinationOffice;

	}
	
	public static WebElement getOriginOffice(WebDriver driver){

		originOfficetext = driver.findElement(By.cssSelector(PropertiesFile.read("coriginofficetext")));

		return originOfficetext;

	}
	
	public static WebElement setCountry(WebDriver driver){

		country = driver.findElement(By.cssSelector(PropertiesFile.read("country")));

		return country;

	}
	public static WebElement setsiteName(WebDriver driver){

		siteName = driver.findElement(By.cssSelector(PropertiesFile.read("siteName")));

		return siteName;

	}
	
	public static WebElement setType(WebDriver driver){

		type = driver.findElement(By.cssSelector(PropertiesFile.read("Type")));

		return type;

	}
	
	public static WebElement setDepartment(WebDriver driver){

		department = driver.findElement(By.cssSelector(PropertiesFile.read("department")));

		return department;

	}
	
	public static WebElement selectisLivet(WebDriver driver){

		isLive = driver.findElement(By.cssSelector(PropertiesFile.read("isLive")));

		return isLive;

	}
	
	public static void selectIncoterm(String incoterm) {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(incotermDropdown(BaseTest.getDriver())));
		Select select=new Select(incotermDropdown(driver));
		select.selectByVisibleText(incoterm);

	}

	public static void enterIncotermLocation(String location) {

		setIncotermLocation(driver).sendKeys(location);
	}
	public static void selectHAWBAirportofDeparture(String hawbairportD) {

		WebElement hawbapod=HAWBDeparture(driver);
		
		try {
			hawbapod.click();
		}
		catch(Exception e) {
			
			JS.click(hawbapod);
		}
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(setCode(driver)));
		setCode(driver).sendKeys(hawbairportD,Keys.ENTER);
		//setCode(driver).sendKeys(Keys.ENTER);
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		
		WebElement codeResults=driver.findElement(By.xpath("//*[text()='"+hawbairportD+"']"));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(codeResults));
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(codeResults));
		Click.usingExecutor(codeResults);
	}
	
     public static void selectHAWBAirportofArrival(String hawbairportA) {

    	 WebElement hawbapoA=HAWBArrival(driver);
 		
 		try {
 			hawbapoA.click();
 		}
 		catch(Exception e) {
 			
 			JS.click(hawbapoA);
 		}
    	 
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(setCode(driver)));
		setCode(driver).sendKeys(hawbairportA,Keys.ENTER);
		//setCode(driver).sendKeys(Keys.ENTER);
		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		
		WebElement codeResults=driver.findElement(By.xpath("//a[text()='"+hawbairportA+"']"));
		new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOf(codeResults));
		new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(codeResults));
		Click.usingExecutor(codeResults);
	}
     
     

     public static void selectBranchfromPicklistO(String country,String department,String siteName,String isLive) {

    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	 WebElement origin=selectoriginOffice(driver);
    	 try {
    		 origin.click();
    	 }
    	 catch(Exception e) {
    		
    		 JS.click(origin);
    		 
    	 }
    	 WaitFor.checkPageIsReady();
 		 WaitFor.checkPageIsjqueryReady();
 		 setCountry(driver).sendKeys(country);
 		 WaitFor.checkPageIsReady();
		 WaitFor.checkPageIsjqueryReady();
		 setDepartment(driver).sendKeys(department,Keys.ENTER);
		 WaitFor.checkPageIsReady();
		 WaitFor.checkPageIsjqueryReady();
		 setsiteName(driver).sendKeys(siteName);
		 WaitFor.checkPageIsReady();
		 WaitFor.checkPageIsjqueryReady();
		 setType(driver).sendKeys("Branch");
		 setType(driver).sendKeys(Keys.ENTER);
		 WaitFor.checkPageIsReady();
		 WaitFor.checkPageIsjqueryReady();
		 Select select=new Select(selectisLivet(driver));
		 select.selectByVisibleText(isLive);
		 WaitFor.checkPageIsReady();
		 WaitFor.checkPageIsjqueryReady();
		 WebElement searchResults=driver.findElement(By.xpath("//table[@id='pnlPopupGrid']/tbody/tr[2]/td[2]/a"));
		 try {
		 
		 new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(searchResults));
		 new WebDriverWait(driver, 100).until(ExpectedConditions.elementToBeClickable(searchResults));
		
			Thread.sleep(3000);
			}
		catch(StaleElementReferenceException e1) {
		
			System.out.println("Entered stale element reference exception");
		}
		catch (Exception e) {
				
			}

		finally {
			
			 Click.usingExecutor(searchResults);
			 
			  }
			  
			  }

		
		 
     
     
     public static void selectBranchfromPicklistD(String country,String department,String siteName,String isLive) {

    	 driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
    	 selectDestinationOffice(driver).click();
    	 WaitFor.checkPageIsReady();
 		 WaitFor.checkPageIsjqueryReady();
 		 setCountry(driver).sendKeys(country);
 		 WaitFor.checkPageIsReady();
		 WaitFor.checkPageIsjqueryReady();
		 setDepartment(driver).sendKeys(department);
		 WaitFor.checkPageIsReady();
		 WaitFor.checkPageIsjqueryReady();
		 setType(driver).sendKeys("Branch");
		 WaitFor.checkPageIsReady();
		 WaitFor.checkPageIsjqueryReady();
		 setsiteName(driver).sendKeys(siteName);
		 WaitFor.checkPageIsReady();
		 WaitFor.checkPageIsjqueryReady();
		 
		 Select select=new Select(selectisLivet(driver));
		 select.selectByVisibleText(isLive);
		 WaitFor.checkPageIsReady();
		 WaitFor.checkPageIsjqueryReady();
		 try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 WebElement searchResults=driver.findElement(By.xpath("(//*[text()='"+country+"'])[1]"));
		 Click.usingExecutor(searchResults);
		 
		 }
     public InitiateJobPage2(WebDriver driver)
     
     {
     
     this.driver = driver;
     
     }
}
