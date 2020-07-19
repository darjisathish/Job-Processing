package day8;

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



public class MultipleScreenshots {

	public static void main(String[] args) throws IOException {
		
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
				links.get(i).click();
				
				File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File DestFile =  new File("D:\\Selenium_Projects\\SeleniumPrograms-master\\screenshots\\"+linkname+".png");
				FileUtils.copyFile(srcFile, DestFile);
			    driver.navigate().back();			    			    
			    links=driver.findElements(By.tagName("a"));
			}
			
			
		}
		System.out.println("Screenshot is taken");
		driver.close();
	}

}
