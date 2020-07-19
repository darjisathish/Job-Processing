package com.agility.focis.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.agility.focis.testData.Constant;
import com.agility.focis.utility.BaseTest;
import com.agility.focis.utility.Excel;
import com.agility.focis.utility.PropertiesFile;
import com.agility.focis.utility.TakeScreenshot;

public class LoginSingleUser extends BaseTest{

	
	
	public static  void main(String[] args) throws Exception {
		
		Excel.setExcelFile(Constant.Path_TestData,Constant.File_TestData);
		 Properties prop=new  Properties();
		String filepath=System.getProperty("user.dir")+"\\config.properties";
		
		try {
			FileInputStream ip= new FileInputStream(filepath);
			System.err.println("Data Driven test is started");
			
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
		
	    String userName=Excel.getCellData(1, 1);
	    String 	password=Excel.getCellData(1, 2);
		driver.findElement(By.cssSelector(PropertiesFile.read("userNametxtbox"))).sendKeys(userName);
		driver.findElement(By.cssSelector(PropertiesFile.read("passwordtxtbox"))).sendKeys(password);
		driver.findElement(By.cssSelector(PropertiesFile.read("Signin"))).click();
		
		String focistitle=driver.getTitle().trim().toLowerCase();
		
		System.out.println(focistitle);
		if(focistitle.contains("focis")) {
			
			System.out.println("logged into application successfully");
			
			Excel.setCellData("Passed", 1, 3);
			System.err.println("Data is written to excel");
		}
		else {
			
			System.out.println("logged into application not successfully");
			TakeScreenshot.captureScreen("loginfailure");
			Excel.setCellData("Failed", 1, 3);
			TakeScreenshot.captureScreen("loginfailed");
		}

	}

}
	
}