package day13;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindows1 {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.get("http://citibank.com");
		driver.manage().window().maximize();
	}

	
	@Test
	public void  mutipleWindowsTest()
	{
		driver.findElement(By.linkText("Get Started")).click();
		switchWindow("html/body/section[1]/article/ul[2]/li[1]/a");
		switchWindow("//*[@id='cmlink_TermsConditions']");
		
	}
	public void switchWindow(String xpath)
	{
		Set<String> windowids=driver.getWindowHandles();
		Iterator<String> it=windowids.iterator();
		while(it.hasNext())
		{
		   driver.switchTo().window(it.next());
		   try
		   {
		       driver.findElement(By.xpath(xpath)).click();
		       break;
		   }
		   catch(Exception e)
		   {
			   
		   }
		}
	}

}
