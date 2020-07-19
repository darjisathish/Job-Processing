package day12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XpathCreation {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
	    
		driver.get("http://news.google.co.in/");
		driver.manage().window().maximize();
	}

	
	@Test
	public void xpathTest()
	{
		List<WebElement> headerlinks=driver.findElements(By.xpath("//h2/a/span[@class='titletext']"));
		for(int i=0;i<headerlinks.size();i++)
		{
			System.out.println(headerlinks.get(i).getText());
			
		}

	}

}
