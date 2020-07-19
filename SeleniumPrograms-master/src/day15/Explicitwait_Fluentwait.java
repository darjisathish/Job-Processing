package day15;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Explicitwait_Fluentwait {
	
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
			FluentWait<WebDriver> fwait=new FluentWait<WebDriver>(driver).withTimeout(30,TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			fwait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div[1]/div[2]/a")));
			fwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[3]/div[2]/div/div[1]/div[4]/a"))).click();
		}

}
