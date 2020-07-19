package day12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputFields {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
	}

	
	@Test
	public void inputBoxTest()
	{
		String[] str={"one","two","three","four","five","six","seven","eight"};
		List<WebElement> myinput=driver.findElements(By.xpath("//input[@type='text' or @type='password']"));
		System.out.println(myinput.size());
		for(int i=0;i<myinput.size();i++)
		{
			myinput.get(i).sendKeys(str[i]);
		}
		
	}

}
