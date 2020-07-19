package day19;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxes2 {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.get("http://echoecho.com/htmlforms09.htm");
		driver.manage().window().maximize();
	}
	@Test
	public void  checkBoxestest()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			if(!check.get(i).isSelected())
			{
			  check.get(i).click();
		    }
    	}
	}

}

