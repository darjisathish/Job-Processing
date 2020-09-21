package com.agility.focis.performActivities.awb;

import com.agility.focis.base.BasePage;
import com.agility.focis.performActivities.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssueAWBPage extends CommonPage {

    public IssueAWBPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id  = 'tabs-MasterCSD']//input[contains(@id , 'IssuingRegulatoryControl')]")
    public WebElement issuingRegulatedEntityCSD;
    @FindBy(xpath = "//div[@id  = 'tabs-MasterCSD']//select[contains(@id , 'SecurityStatus')]")
    public WebElement securityStatusCSD;
    @FindBy(xpath = "//div[@id  = 'tabs-MasterCSD']//input[contains(@id , 'btnComplete')]")
    public WebElement completeCSDButton;

    //    House CSD
    @FindBy(xpath = "//div[@id  = 'tabs-HouseCSD']//input[contains(@id , 'IssuingRegulatoryControl')]")
    public WebElement issuingRegulatedEntityHouseCSD;
    @FindBy(xpath = "//div[@id  = 'tabs-HouseCSD']//select[contains(@id , 'SecurityStatus')]")
    public WebElement securityStatusHouseCSD;
    @FindBy(xpath = "//div[@id  = 'tabs-HouseCSD']//input[contains(@id , 'btnComplete')]")
    public WebElement completeHouseCSDButton;

    //B2B Master
    @FindBy(xpath = "//div[@id = 'tabs-B2BMaster']//input[@id='1_txtMRateClass']")
    public WebElement rateClassB2BMaster;
    @FindBy(xpath = "//div[@id = 'tabs-B2BMaster']//input[@id='1_txtMRateOrChange']")
    public WebElement rateOrChargeB2BMaster;
    @FindBy(xpath = "//div[@id = 'tabs-B2BMaster']//input[contains(@id,'SingofAgnt')]")
    public WebElement signOfAgentB2BMaster;
    @FindBy(xpath = "//div[@id = 'tabs-B2BMaster']//input[contains(@id,'IssueCarrierAgnt')]")
    public WebElement signOfCarrierAgentB2BMaster;
    @FindBy(xpath = "//div[@id = 'tabs-B2BMaster']//input[contains(@id,'btnMComplete')]")
    public WebElement completeButtonB2BMaster;

    //    B2B House
    @FindBy(xpath = "//div[@id = 'tabs-B2BHouse']//input[@id='1_txtRateClass']")
    public WebElement rateClassB2BHouse;
    @FindBy(xpath = "//div[@id = 'tabs-B2BHouse']//input[@id='1_txtRateOrChange']")
    public WebElement rateOrChargeB2BHouse;
    @FindBy(xpath = "//div[@id = 'tabs-B2BHouse']//input[contains(@id,'SingofAgnt')]")
    public WebElement signOfAgentB2BHouse;
    @FindBy(xpath = "//div[@id = 'tabs-B2BHouse']//input[contains(@id,'IssueCarrierAgnt')]")
    public WebElement signOfCarrierAgentB2BHouse;
    @FindBy(xpath = "//div[@id = 'tabs-B2BHouse']//input[contains(@id,'btnComplete')]")
    public WebElement completeButtonB2BHouse;
}
