package com.agility.focis.performActivities.cbr;

import com.agility.focis.base.BasePage;
import com.agility.focis.performActivities.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CBRPage extends CommonPage {

    public CBRPage(WebDriver driver) {
        super(driver);
    }

//-------------------------------------------------  CBR Locators -----------------------------------------------

    public WebElement referenceSearchButton(String stakeholderType) {
        return driver.findElement(By.xpath("//legend[text()='" + stakeholderType + "']/ancestor::div[1]//span[text()='Reference']/ancestor::div[1]//button"));
    }

    public WebElement partyName(String partyType) {
        return driver.findElement(By.xpath("//legend[contains(text() , '" + partyType + "')]/ancestor::div[1]//span[text() = 'Name']/ancestor::div[1]//input[@holdername = 'CarierBookingFrHolder']"));

    }

    public WebElement partyAddress(String partyType) {
        return driver.findElement(By.xpath("//legend[contains(text() , '" + partyType + "')]/ancestor::div[1]//span[text() = 'Address']/ancestor::div[1]//textarea"));
    }

    @FindBy(xpath = "//div[text() = 'Reference Type']/ancestor::tr//input")
    public WebElement selectAllReferences;
    @FindBy(xpath = "//span[@class='ui-icon icon-save purple']")
    public WebElement saveReferences;

    @FindBy(xpath = "//input[@value='Complete']")
    public WebElement completeButton;
    @FindBy(xpath = "//p[text() = 'To view the document, please click on Print button.']/../../..//button[contains(text() , 'OK')]")
    public WebElement alertButtonToPrint;
    @FindBy(xpath = "//p[text() = 'To view the document, please click on View button.']/../../..//button[contains(text() , 'OK')]")
    public WebElement alertButtonToView;
    @FindBy(xpath = "//input[@id='btnEDI']")
    public WebElement ediButton;
    @FindBy(xpath = "//div[@role = 'dialog' and @aria-describedby='alrtdialog']//button[text()=' OK ']")
    public WebElement clickOnSuccessOkButton;

}
