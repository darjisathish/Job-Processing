package day8;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotOnerror2 {

		
	public static void main(String[] args) throws IOException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.get("http://google.com");
		driver.manage().window().maximize();
		try
		{
		    driver.findElement(By.linkText("Qedge")).click();
		}
		catch(Exception e) 
		{
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile,new File("D:\\Selenium_Projects\\SeleniumPrograms-master\\screenshots\\"+timestamp()+".png"));
		}
	}
	
	private static String timestamp() {
		
		return new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss").format(new Date());
		
	}
	
	
}
