package day8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SanityTesting {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com");
		driver.manage().window().maximize();
				
		driver.findElement(By.linkText("REGISTER")).click();
		WebElement drop=driver.findElement(By.name("country"));
		List<WebElement> dropdown=drop.findElements(By.tagName("option"));
		int a=myRandomNo(dropdown.size()-1);
		dropdown.get(a).click();
		
		if(dropdown.get(a).isSelected())
		{
			System.out.println(dropdown.get(a).getText()+" is active");
		}
		else
		{
			System.out.println(dropdown.get(a).getText()+" is inactive");
		}
		driver.close();
	}
	
	public static int myRandomNo(int x)
	{
		double d=Math.random()*x;
		int a=(int)d;
		return a;

	}

	
}
