package day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class LinksTesting2 {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
	    
		driver.get("http://bing.com");
		driver.manage().window().maximize();
		
		//Adding wait 
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		 
		Actions actions = new Actions(driver);
		WebElement menuOption = driver.findElement(By.xpath("//*[@id='dots_overflow_menu_container']"));
		actions.moveToElement(menuOption).perform();
		
		//driver.findElement(By.xpath("//*[@id='dots_overflow_menu_container']")).click();
		
		
		String expurl=driver.findElement(By.xpath("//*[@id='video']/a")).getAttribute("href");
	    driver.findElement(By.xpath("//*[@id='video']/a")).click();
	    String acturl=driver.getCurrentUrl();
	    
	    if(acturl.contains(expurl))
	    {
		    System.out.println("Videos links working correctly");
	    }
	    else
	    {
		   System.out.println("Videos links not working correctly");
	    }

	   
	   //driver.close();
	   
	   
	}

}
