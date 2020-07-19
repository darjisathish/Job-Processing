package day6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LinksTesting8 {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();		
		
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
		{
			if(!links.get(i).getText().isEmpty())
			{
				String linkname=links.get(i).getText();
				String expurl=links.get(i).getAttribute("href");
				links.get(i).click();
				String acturl=driver.getCurrentUrl();
				
				if(acturl.contains(expurl))
				{
					System.out.println(linkname+" is working correctly");
				}
				else
				{
					System.out.println(linkname+" is not working correctly");
				}
				driver.navigate().back();
				links=driver.findElements(By.tagName("a"));
				
				
			}
		}
	}

}
