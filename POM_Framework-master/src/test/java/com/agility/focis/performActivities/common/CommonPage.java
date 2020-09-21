package com.agility.focis.performActivities.common;

import com.agility.focis.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPage extends BasePage {

    public CommonPage(WebDriver driver) {
        super(driver);
    }

    //    ---------------------------------------------Common Locators for Activities---------------------------------------------
    public WebElement performActivity(String activityName) {
        return driver.findElement(By.xpath("//td[text()='" + activityName + "']/preceding-sibling::td//div[@title ='Perform Activity']/span[contains(@class,'pencil')]"));
    }

    @FindBy(xpath = "//div[@aria-describedby ='alrtActivityPerform']//button[text() = 'OK']")
    public WebElement acceptAlrtActivityPerform;

    @FindBy(id = "txtCarrFilingRef")
    public WebElement contractInput;

    @FindBy(xpath = "//select[contains(@id,'CarrierContract') and @selected = 'selected']")
    public WebElement carrierContractType;

//-------------------------------------------------  More Links Locators ----------------------------------------

    @FindBy(id = "btnJobMoreLinks")
    public WebElement moreLinksButton;
    @FindBy(xpath = "//iframe[contains(@src,'bookingdeatilslinksfrpg')]")
    public WebElement moreLinksIframe;

    public WebElement moreLinks_linkToBeClicked(String text) {
        return driver.findElement(By.xpath("//ul[@id = 'ulSideMenuBar']//a[text() = '" + text + "']"));
    }

    public WebElement fobSearchButton(String jobNumber, String transactionType) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'TransactionType') and text() = '" + transactionType + "']/following-sibling::td[contains(@aria-describedby,'Criteria') and text() = 'Original']/preceding-sibling::td[contains(@aria-describedby,'FobId')]//span"));
    }

    public WebElement xmlDataLink(String transactionType) {
        return driver.findElement(By.xpath("//span[text() ='" + transactionType + "']/following-sibling::span/a[text() = 'XML Data']"));
    }

    @FindBy(id = "xmlRawDataOutput")
    public WebElement xmlRawData;

}
