package day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebtableTesting1 {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.get("http://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();
	}
	@Test
	public void webtableTest()
	{
		String part1="html/body/div[1]/div[7]/section[2]/div[1]/table/tbody/tr[";
		String part2="]/td[1]";
		for(int i=1;i<=37;i++)
		{
			String x=driver.findElement(By.xpath(part1+i+part2)).getText();
			System.out.println(x);
		}
		
	}

}
