package day12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementPresence {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("http://en.wikipedia.org/wiki/Rajinikanth");
		driver.manage().window().maximize();
	}

	
	@Test
	public void elementTest()
	{
		String str=driver.getPageSource();
		if(str.contains("Rajinikanth"))
		{
			System.out.println("Element exists");
		}
		else
		{
			System.out.println("Element not present");
		}
	}

}

