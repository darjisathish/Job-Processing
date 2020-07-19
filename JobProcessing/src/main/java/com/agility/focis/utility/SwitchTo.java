package com.agility.focis.utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SwitchTo extends BaseTest {








	public static void airframe() {

		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		System.out.println("wait keyword is loaded");
		new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).until(ExpectedConditions.visibilityOf(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cAiriframe")))));
		BaseTest.getDriver().switchTo().frame(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cAiriframe"))));
		System.out.println("switched to air frame  successfully");
		/*new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).until(ExpectedConditions.visibilityOf(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cJobType")))));
		new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).until(ExpectedConditions.elementToBeClickable(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cJobType")))));
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//div[text()='Loading grid...'][@style='display: block;'])[2]")));*/
	}

	public static void estimatesFrame() {

		WaitFor.checkPageIsReady();
		//WaitFor.checkPageIsjqueryReady();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//new WebDriverWait(BaseTest.getDriver(), Integer.valueOf(PropertiesFile.read("wait"))).until(ExpectedConditions.visibilityOf(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cEstimatesiframe")))));
		//BaseTest.getDriver().switchTo().frame(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("cAiriframe"))));
		BaseTest.getDriver().switchTo().frame(BaseTest.getDriver().findElement(By.cssSelector(PropertiesFile.read("xEstimatesiframe"))));
		System.err.println("Estimates iframe is switched");
		//WaitFor.checkPageIsReady();
		//WaitFor.checkPageIsjqueryReady();
		//new WebDriverWait(BaseTest.getDriver(), 30).until(ExpectedConditions.visibilityOf(BaseTest.getDriver().findElement(By.id(PropertiesFile.read("idSupplierSearchPicker")))));
		//new WebDriverWait(BaseTest.getDriver(),15).until(ExpectedConditions.elementToBeClickable(BaseTest.getDriver().findElement(By.id(PropertiesFile.read("idSupplierSearchPicker")))));
	}

	public  static void morelinksFrame() {


		WaitFor.checkPageIsReady();
		WaitFor.checkPageIsjqueryReady();
		WaitFor.clickOnElementUsingExplicitWait(driver.findElement(By.cssSelector(PropertiesFile.read("cMoreLinkstab"))));
		WaitFor.explicitWait(driver.findElement(By.cssSelector("a[title='Close']")));
		BaseTest.getDriver().switchTo().frame(driver.findElement(By.cssSelector(PropertiesFile.read("cmorelinksframe"))));
		System.err.println("Switched to morelinks frame");
		

	}
	public static void switchToNewWindow(String title) {
		Set < String > s = driver.getWindowHandles();   
		Iterator < String > ite = s.iterator();
		int i = 1;
		while (ite.hasNext()) {
			System.out.println("i value is "+i);
			String popupHandle = ite.next().toString();
			
			String windowTitle=driver.getTitle().trim();
			System.out.println("Window title is : "+windowTitle);
			if (!windowTitle.contains(title)) {
				
			driver.switchTo().window(popupHandle);
			   WaitFor.checkPageIsReady();
			   WaitFor.checkPageIsjqueryReady();
			   
				break;
		}
			i++;
	}

	}}
