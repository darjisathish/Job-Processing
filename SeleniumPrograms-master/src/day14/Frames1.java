package day14;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Frames1 {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.get("http://www.angelfire.com/super/badwebs/");
		driver.manage().window().maximize();
	}
	

	@Test
	public void framesTest()
	{
		
		List<WebElement> myframes=driver.findElements(By.tagName("frame"));
		System.out.println(myframes.size());
		for(int i=0;i<myframes.size();i++)
		{
		   driver.switchTo().frame(i);
		   try
		   {
			   driver.findElement(By.xpath("html/body/p[5]/b/a/font")).click();
			   break;
		   }
		   catch(Exception e)
		   {
			   driver.switchTo().defaultContent();
		   }
		}
	}

}
