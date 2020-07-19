package day10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	
	
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("http://yssofindia.org");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='specialDiscount']/div/p[1]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,550)");
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void mouseHoverTest() throws InterruptedException
	{
		
		Actions a=new Actions(driver);
		
		a.moveToElement(driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[3]/a"))).build().perform();		
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[3]/ul/li/div/div/ul[3]/li[2]/a")).click();

	
		/*Actions action=new Actions(driver);
		WebElement event1=driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[3]/a"));
		WebElement event2=driver.findElement(By.xpath("//*[@id='navbar-collapse-1']/ul/li[3]/ul/li/div/div/ul[3]/li[2]/a"));
		action.moveToElement(event1).moveToElement(event2).build().perform();
		event2.click();*/
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	

}
