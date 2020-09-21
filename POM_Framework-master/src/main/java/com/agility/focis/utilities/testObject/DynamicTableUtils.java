package com.agility.focis.utilities.testObject;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class DynamicTableUtils extends TextBoxUtils {
	
    private static WebElement elementToGetTextFrom(String referenceColumnName, String referenceData, String columnToGetTextFrom) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'" + referenceColumnName + "') and text() = '" + referenceData + "']/../td[contains(@aria-describedby,'" + columnToGetTextFrom + "')]"));
    }

    public static String getText(String referenceColumnName, String referenceData, String columnToGetTextFrom) {
        return elementToGetTextFrom(referenceColumnName, referenceData, columnToGetTextFrom).getText();
    }

    public static void typeTextOnSearchPickerPopup(String columnName, String text) throws InterruptedException {
        columnName = columnName.replaceAll(" ", "");
        driver.findElement(By.xpath("//table//input[contains(@name , '" + columnName + "')]")).clear();
        driver.findElement(By.xpath("//table//input[contains(@name , '" + columnName + "')]")).sendKeys(text + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();

    }

    public static void clickOnIconUsingReferenceData(String referenceColumn, String referenceData, String colour) throws InterruptedException {
        referenceColumn = referenceColumn.replaceAll(" ", "");
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(driver.findElement(By.xpath("//td[contains(@aria-describedby,'" + referenceColumn + "') and text() = '" + referenceData + "']/..//*[contains(@class,'" + colour + "')]")));
        driver.findElement(By.xpath("//td[contains(@aria-describedby,'" + referenceColumn + "') and text() = '" + referenceData + "']/..//*[contains(@class,'" + colour + "')]")).click();
        SeleniumUtils.waitForPageLoad();
    }

    public static void clickOnLinkUsingReferenceData(String referenceColumn, String referenceData) throws InterruptedException {
        referenceColumn = referenceColumn.replaceAll(" ", "");
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(driver.findElement(By.xpath("//td[contains(@aria-describedby,'" + referenceColumn + "') and text() = '" + referenceData + "']/..//a")));
        driver.findElement(By.xpath("//td[contains(@aria-describedby,'" + referenceColumn + "') and text() = '" + referenceData + "']/..//a")).click();
        SeleniumUtils.waitForPageLoad();
    }
}
