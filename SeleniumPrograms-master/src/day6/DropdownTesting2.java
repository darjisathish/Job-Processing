package day6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DropdownTesting2 {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.get("http://amazon.in");
		driver.manage().window().maximize();
				
		WebElement drop=driver.findElement(By.id("searchDropdownBox"));
		List<WebElement> dropdown=drop.findElements(By.tagName("option"));
		System.out.println(dropdown.size());
		System.out.println("------------");
		
		for(int i=0;i<dropdown.size();i++)
		{
			System.out.println(dropdown.get(i).getText());
		}
	
	}

}
