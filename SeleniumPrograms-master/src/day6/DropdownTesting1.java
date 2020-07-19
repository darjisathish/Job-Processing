package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DropdownTesting1 {

	
	public static void main(String[] args) {
		
		//WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://amazon.in");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		driver.findElement(By.className("nav-input")).click();
		
		
	}

}
