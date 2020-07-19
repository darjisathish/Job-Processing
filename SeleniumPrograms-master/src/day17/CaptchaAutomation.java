package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CaptchaAutomation {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.get("http://www.harvard.edu/feedback");
	}
	@Test
	public void captchaTest() throws InterruptedException
	{
		for(long i=1;i<999999999l;i++)
		{
		  driver.findElement(By.id("edit-submitted-name")).sendKeys("tester"+i);
		  driver.findElement(By.id("edit-submitted-email")).sendKeys("tester"+i+"@gmail.com");
		  driver.findElement(By.id("edit-submitted-comment")).sendKeys("sample msg");
		  String eqa=driver.findElement(By.xpath("//*[@id='webform-client-form-1884']/div/fieldset/div/div[2]/span")).getText();
		  String[] a=eqa.split(" ");
		  int x=Integer.parseInt(a[0]);
		  int y=Integer.parseInt(a[2]);
		  int z=x+y;
		  String str=Integer.toString(z);
		  driver.findElement(By.id("edit-captcha-response")).sendKeys(str);
		  Thread.sleep(4000);
		  driver.navigate().refresh();
		  //driver.findElement(By.xpath("//*[@id='webform-client-form-1884']/div/div[5]/input")).click();
		}	
		
	
	}

}
