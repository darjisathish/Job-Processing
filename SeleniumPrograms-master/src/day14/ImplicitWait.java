package day14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImplicitWait {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
	
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
	    
		driver.get("http://www.24hourfitness.com/not-yet-member.html");
		driver.manage().window().maximize();
	}
	@Test
	public void waitTest()
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div[1]/div[4]/a")).click();
	}


}
