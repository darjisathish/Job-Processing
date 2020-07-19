package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderBar {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Projects\\SeleniumPrograms-master\\executables\\chromedriver.exe");
	    driver = new ChromeDriver();
	    
		driver.get("https://jqueryui.com/slider/#slider-vertical");
		driver.manage().window().maximize();
	}
	
	
	
	
	@Test
	public void slidertest()
	{
		driver.switchTo().frame(0);
		Actions action=new Actions(driver);
		WebElement slider=driver.findElement(By.xpath("//*[@id='slider-vertical']/span"));
	    int y=slider.getLocation().y;
	    action.dragAndDropBy(slider, 40,y).build().perform();
	}

}
