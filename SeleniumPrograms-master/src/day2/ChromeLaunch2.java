package day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeLaunch2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		driver.findElement(By.xpath("//*[@id='navbar']/a[1]")).click();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/p[2]/a")).click();
		

	}

}
