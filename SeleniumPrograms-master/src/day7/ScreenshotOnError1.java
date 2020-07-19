package day7;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScreenshotOnError1 {


	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
				
		driver.get("http://google.com");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.linkText("Qedge"));
		if(links.size()==0)
		{
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile,new File("D:\\Selenium_Projects\\SeleniumPrograms-master\\screenshots\\Google.png"));
		}
		else
		{
			driver.findElement(By.linkText("Qedge")).click();
		}
		
		System.out.println("Screenshot is taken");
		driver.close();

	}
	

}
