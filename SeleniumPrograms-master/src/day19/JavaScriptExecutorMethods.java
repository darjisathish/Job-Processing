package day19;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorMethods {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.get("http://google.com");
		driver.manage().window().maximize();
	}
	@Test
	public void javascriptTest() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('hello world');");
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(3000);
	//	driver.executeScript("history.go(0)");
		js.executeScript("history.go(0)");
		
		
		driver.get("http://yssofindia.org");
		WebElement event=driver.findElement(By.xpath("//*[@id='topmenu']/div/ul/li[5]/ul/li[9]/ul/li[3]/a"));
		js.executeScript("arguments[0].click();", event);
	}

}

