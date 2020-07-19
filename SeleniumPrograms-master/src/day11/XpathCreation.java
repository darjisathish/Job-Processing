package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	    driver.get("https://gmail.com");
	    driver.manage().window().maximize();
	}
	
	
	@Test
	public void xpathTest()
	{
		String x=driver.findElement(By.xpath("//p[@class='tagline']")).getText();
		System.out.println(x);
	}

}

