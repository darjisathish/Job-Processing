package com.agility.focis.performActivities.cbc;

import com.agility.focis.base.BasePage;
import com.agility.focis.performActivities.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CBCPage extends CommonPage {

    public CBCPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//b[text() = 'Booking Confirmation Matches Job Data']/preceding-sibling::input[@type = 'radio']")
    public WebElement confirmCBC;
    @FindBy(xpath = "(//b[text() = 'Amended Carrier Booking Request Required']/preceding-sibling::input[@type = 'radio'])[1]")
    public WebElement amendCBC;
    @FindBy(id = "btnCarrierBkingConfmComplete")
    public WebElement completeCBCButton;

}
