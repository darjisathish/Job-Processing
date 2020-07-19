package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dynamicxpaths {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
	    
		driver.get("https://yahoo.com");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void xpathTest()
	{
		driver.findElement(By.xpath("//*[starts-with(@id,'yui_3_12_0_1_14')]/div/ol/li[6]/a")).click();
	
	}

}

