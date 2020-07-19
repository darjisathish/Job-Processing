package day10;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RifhtClick {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();	
		
		driver.get("http://google.com");
		driver.manage().window().maximize();
	}
	
	
	
	@Test
	public void rightClickTest() throws InterruptedException
	{
		Actions action=new Actions(driver);
		WebElement event=driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a"));
		Thread.sleep(500);
	    action.contextClick(event).sendKeys("L").build().perform();
		//action.contextClick(event).sendKeys("R").build().perform();
	}

}
