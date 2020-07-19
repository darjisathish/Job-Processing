package day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmaiLogin {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		/*
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	     
		driver = new ChromeDriver();
		driver.get("http://gmail.com");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("Email")).sendKeys("dsatish20@gmail.com");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys("passw@123");
		driver.findElement(By.id("signIn")).click();*/
		
		
		 System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://www.gmail.com");
		 //Send email address
		 driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("dsatish20@gmail.com");
		 driver.findElement(By.xpath("//div[@id='identifierNext']")).click();
		 
		 //send password
		 WebElement passwordButton = driver.findElement(By.xpath("//input[@name='password']"));
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
		 passwordButton.sendKeys("********");
		 driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
		 
		 //Click on compose button
		 driver.findElement(By.xpath("//div[text()='Compose']")).click();
		 
		 //Enter the sender mail id
		 driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("Sender e-mail id");
		 //Enter subject to the mail
		 driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Selenium script");
		 driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']")).sendKeys("Selenium script to send mail");
		 
		/* //Attach the full path of file
		 driver.findElement(By.xpath("//input[@name='Filedata']")).sendKeys("D:\\maven.txt");
		 driver.findElement(By.xpath("//div[text()='Send']")).click();*/
		
		
		
		
		
		
		
		
		
		
		

	}

}
