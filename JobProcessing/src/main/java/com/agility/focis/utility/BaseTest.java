package com.agility.focis.utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.*;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.ExtentTest;


public class BaseTest {
	
	//public static ExtentTest test;
	public static WebDriver driver;
	   
	   public static WebDriver getDriver() {
	        return driver;
	   }

	public static  void login(String browserName) throws Exception {
		
		// To read the properties file
		 Properties prop=new  Properties();
			
			String filepath=System.getProperty("user.dir")+"\\config.properties";
			
			try {
				FileInputStream ip= new FileInputStream(filepath);
				
				prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		// To execute in different browsers based on chrome /IE/headless browser
			
		if(prop.getProperty("browserName").equals("chrome")) {
			
			
			System.out.println("Chrome browser is selected");
			
			System.setProperty("webdriver.chrome.driver", "E:\\Jar Files & Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(prop.getProperty("browserName").equals("ie")) 
		{
			
			System.out.println("IE browser is selected");
			System.setProperty("webdriver.ie.driver", "E:\\Jar Files & Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
			
		else if(prop.getProperty("browserName").equals("headless")) {
			
			System.out.println("headless browser is selected");
			//driver=new HtmlUnitDriver();
			
		}
		else {
			System.out.println("no browser is selected");
		}
		
		
		if(PropertiesFile.read("focisUrl").contains("demo")) {
			
			driver.navigate().to("https://RGurajala:Beer214@@focisdemo.agility.com");
			System.out.println("demo environment  is executed");
		}
		else 
		{
		 if(PropertiesFile.read("focisUrl").contains("sit")){
		
		driver.navigate().to("http://focissit.agility.com/login.aspx");
		System.out.println("SIT environment  is executed");
		}
		else if(PropertiesFile.read("focisUrl").toLowerCase().contains("agile")) {
			System.out.println("Agile environment  is executed");
			driver.navigate().to("https://focisagile.agility.com/login.aspx");
	}
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		// To check login success/failure along with some other conditions (Ex : Site under maintenance)
		String focistitle=driver.getTitle().trim().toLowerCase();
		
		if(focistitle.contains("login")) {
			
			System.out.println("SITE is up");
			
			Thread.sleep(5000);
			ScrollAndHighlight.highlightElement(driver.findElement(By.cssSelector(PropertiesFile.read("userNametxtbox"))));
			driver.findElement(By.cssSelector(PropertiesFile.read("userNametxtbox"))).sendKeys(PropertiesFile.read("username"));
			driver.findElement(By.cssSelector(PropertiesFile.read("passwordtxtbox"))).sendKeys("q");
			driver.findElement(By.cssSelector(PropertiesFile.read("Signin"))).click();
			Thread.sleep(1000);
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			WaitFor.checkPageIsReady();
			
			WaitFor.checkPageIsjqueryReady();
			
			String focistitle1=driver.getTitle().trim().toLowerCase();
			
			System.out.println(focistitle1);
			
			if(focistitle1.contains("focis")) {
				
				System.out.println("logged into application successfully");
				TakeScreenshot.captureScreen("loginsuccess");
			}
			else {
				
				System.out.println("logged into application not successfully");
				TakeScreenshot.captureScreen("loginfailure");
			}
		}
		else {
			
			TakeScreenshot.captureScreen(focistitle);
			Thread.sleep(2000);
			System.out.println("SITE is slow or server under maintenance or error");
			driver.close();
		}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BaseTest.login("chrome");
		NavigateTo.menu("Job","Job Booking");
	}
	
	
	
	
}
