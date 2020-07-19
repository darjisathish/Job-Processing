package day16;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CookiesTesting {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.get("http://mirror.co.uk");
		driver.manage().window().maximize();
	}
	@Test
	public void cookiesTest()
	{
		Set<Cookie> myCookies=driver.manage().getCookies();
		System.out.println(myCookies.size());
		Iterator<Cookie> it=myCookies.iterator();
		while(it.hasNext())
		{
			Cookie c=it.next();
			System.out.println(c.getName()+"--"+c.getValue()+"--"+c.getDomain());
		}
		driver.manage().deleteAllCookies();
		myCookies=driver.manage().getCookies();
		System.out.println(myCookies.size());
		driver.close();
	
	
	}

}
