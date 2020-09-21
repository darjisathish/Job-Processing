package com.agility.focis.qm.rateSearch.Ocean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewRC {

	
	 WebDriver driver;

	
	public  void intmethod() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir")
						+ "/drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("http://focissit.agility.com/login.aspx");
		driver.manage().window().maximize();
		driver.findElement(By.name("Login1$UserName")).sendKeys("sdarji");
		driver.findElement(By.name("Login1$Password")).sendKeys("q");
		driver.findElement(By.name("Login1$LoginButton")).click();
		driver.get("http://focissit.agility.com/pages/qm/rmg/rmgratesearch/qm/qmratesearchoceanlspg.aspx?q=cGFnZWlkfFFNUmF0ZVNlYXJjaE9jZWFuTHNQZyZhY3Rpb25pZHxMaXN0RW1wdHlSTUdPY2VhblJhdGVTZWFyY2hOZXcmYWN0aW9uY3JpdGVyaWF8Jm5leHRhY3Rpb25jcml0ZXJpYXwmSXNQb3B1cFBhZ2V8ZmFsc2UmVXNlckxhbmd1YWdlfCY%3d-WWavcvuQh6Y%3d");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='modal-body']//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]")).click();
		//div[@class='modal-body']//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'FCL (NVOCC)')]")).click();
		driver.findElement(By.xpath("//div[@class='modal-body']//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]")).click();
		driver.findElement(By.name("PWCMasterPage$PWCWebPartManager$gwpQMRateSearchOceanShUc$QMRateSearchOceanShUc$txtOriginPort")).sendKeys("INMAA");
		Thread.sleep(3000);
		//driver.findElement(By.name("PWCMasterPage$PWCWebPartManager$gwpQMRateSearchOceanShUc$QMRateSearchOceanShUc$txtOriginPort")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//div[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtOriginPort_divPopup']//ul//li//a")).click();
		driver.findElement(By.xpath("//a[contains(text(),'INMAA')]")).click();
		
		
		driver.findElement(By.id("PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtDestinationPort")).sendKeys("DEHAM");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'DEHAM')]")).click();
		driver.findElement(By.name("PWCMasterPage$PWCWebPartManager$gwpQMRateSearchOceanShUc$QMRateSearchOceanShUc$btnSearch")).click();
}

	
	public void NewRateSearch(/*String POL,String POD,String PT*/) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://focissit.agility.com/login.aspx");
			driver.manage().window().maximize();
			driver.findElement(By.name("Login1$UserName")).sendKeys("sdarji");
			driver.findElement(By.name("Login1$Password")).sendKeys("q");
			driver.findElement(By.name("Login1$LoginButton")).click();
			
			driver.get("http://focissit.agility.com/pages/qm/rmg/rmgratesearch/qm/qmratesearchoceanlspg.aspx?q=cGFnZWlkfFFNUmF0ZVNlYXJjaE9jZWFuTHNQZyZhY3Rpb25pZHxMaXN0RW1wdHlSTUdPY2VhblJhdGVTZWFyY2hOZXcmYWN0aW9uY3JpdGVyaWF8Jm5leHRhY3Rpb25jcml0ZXJpYXwmSXNQb3B1cFBhZ2V8ZmFsc2UmVXNlckxhbmd1YWdlfCY%3d-WWavcvuQh6Y%3d");
			Thread.sleep(3000);
			/*driver.findElement(By.xpath("//div[@class='modal-body']//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]")).click();
			
			Thread.sleep(2000);
			System.out.println("//span[contains(text(),'"+PT+" (NVOCC)')]");
			driver.findElement(By.xpath("//span[contains(text(),'"+PT+" (NVOCC)')]")).click();
			
			driver.findElement(By.xpath("//div[@class='modal-body']//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]")).click();
			driver.findElement(By.name("PWCMasterPage$PWCWebPartManager$gwpQMRateSearchOceanShUc$QMRateSearchOceanShUc$txtOriginPort")).sendKeys(POL);
			Thread.sleep(6000);
			//driver.findElement(By.name("PWCMasterPage$PWCWebPartManager$gwpQMRateSearchOceanShUc$QMRateSearchOceanShUc$txtOriginPort")).sendKeys(Keys.ENTER);
			//driver.findElement(By.xpath("//div[@id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtOriginPort_divPopup']//ul//li//a")).click();
			System.out.println("//a[contains(text(),'"+POL+"')]");
			driver.findElement(By.xpath("//a[contains(text(),'"+POL+"')]")).click();
			
			driver.findElement(By.id("PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtDestinationPort")).sendKeys(POD);
			Thread.sleep(6000);
			System.out.println("//a[contains(text(),'"+POD+"')]");
			driver.findElement(By.xpath("//a[contains(text(),'"+POD+"')]")).click();
			
			driver.findElement(By.name("PWCMasterPage$PWCWebPartManager$gwpQMRateSearchOceanShUc$QMRateSearchOceanShUc$btnSearch")).click();*/
	}
	public void DynamicRateSearch(String POL,String POD,String PT) throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='modal-body']//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]")).click();
		Thread.sleep(2000);
		System.out.println("//span[contains(text(),'"+PT+" (NVOCC)')]");
		driver.findElement(By.xpath("//span[contains(text(),'"+PT+" (NVOCC)')]")).click();
		driver.findElement(By.xpath("//div[@class='modal-body']//div[1]//div[1]//div[1]//div[1]//div[1]//button[1]")).click();
		
		driver.findElement(By.name("PWCMasterPage$PWCWebPartManager$gwpQMRateSearchOceanShUc$QMRateSearchOceanShUc$txtOriginPort")).sendKeys(POL);
		Thread.sleep(6000);
		System.out.println("//a[contains(text(),'"+POL+"')]");
		driver.findElement(By.xpath("//a[contains(text(),'"+POL+"')]")).click();
		
		driver.findElement(By.id("PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_txtDestinationPort")).sendKeys(POD);
		Thread.sleep(6000);
		System.out.println("//a[contains(text(),'"+POD+"')]");
		driver.findElement(By.xpath("//a[contains(text(),'"+POD+"')]")).click();
		
		driver.findElement(By.name("PWCMasterPage$PWCWebPartManager$gwpQMRateSearchOceanShUc$QMRateSearchOceanShUc$btnSearch")).click();
		
	}
		
	
	public static void main(String...agrs) throws InterruptedException {
		NewRC rc = new NewRC();
		rc.NewRateSearch();
		rc.DynamicRateSearch("INMAA", "DEHAM", "FCL");
	}
}
