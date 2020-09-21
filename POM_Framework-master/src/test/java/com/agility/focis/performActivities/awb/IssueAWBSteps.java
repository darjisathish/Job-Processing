package com.agility.focis.performActivities.awb;

import com.agility.focis.CBR.CBREDI;
import com.agility.focis.CBR.JOBDETAILS;
import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.performActivities.common.CommonSteps;
import com.agility.focis.utilities.testObject.DynamicTableUtils;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IssueAWBSteps extends CommonSteps {
    private WebDriver driver;
    IssueAWBPage issueAWBPage;

    public IssueAWBSteps() throws IOException {
        this.driver = getDriver();
        issueAWBPage = new IssueAWBPage(this.driver);

    }

    public void performAWB() throws InterruptedException {
        navigateToDashboard();
        if (driver.getCurrentUrl().contains("dashboard")) {
            DynamicTableUtils.typeTextOnSearchPickerPopup("EventName", "Issue AWB");
            Thread.sleep(1000);
            SeleniumUtils.waitForPageLoad();
            DynamicTableUtils.clickOnIconUsingReferenceData("EventName", "Issue AWB", "blue");
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.takeScreenshot();
        } else {
            DynamicTableUtils.clickOnIconUsingReferenceData("ActivityDescription", "Issue AWB", "red");
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.takeScreenshot();
        }
        SeleniumUtils.switchToNewWindow();
        SeleniumUtils.waitForPageLoad();
        completeCSD();
        completeHouseCSD();
        completeB2BHouse();
        completeB2BMaster();


    }

    private void completeCSD() throws InterruptedException {

        clickOnTab("CSD");
        issueAWBPage.issuingRegulatedEntityCSD.sendKeys("RC");
        Thread.sleep(1000);
        issueAWBPage.issuingRegulatedEntityCSD.sendKeys(Keys.ENTER);
        Select securityStatusCSD = new Select(issueAWBPage.securityStatusCSD);
        securityStatusCSD.selectByVisibleText("NSC");
        issueAWBPage.completeCSDButton.click();
        SeleniumUtils.waitForPageLoad();
    }

    private void completeHouseCSD() throws InterruptedException {

        clickOnTab("House CSD");
        issueAWBPage.issuingRegulatedEntityHouseCSD.sendKeys("RC");
        Thread.sleep(1000);
        issueAWBPage.issuingRegulatedEntityHouseCSD.sendKeys(Keys.ENTER);
        Select securityStatusCSD = new Select(issueAWBPage.securityStatusHouseCSD);
        securityStatusCSD.selectByVisibleText("NSC");
        issueAWBPage.completeHouseCSDButton.click();
        SeleniumUtils.waitForPageLoad();
    }

    private void completeB2BHouse() throws InterruptedException {
        clickOnTab("B2B House");
        issueAWBPage.rateClassB2BHouse.sendKeys("R");
        issueAWBPage.rateOrChargeB2BHouse.sendKeys("10");
        issueAWBPage.signOfAgentB2BHouse.sendKeys("Automation");
        issueAWBPage.signOfCarrierAgentB2BHouse.sendKeys("Automation");
        issueAWBPage.completeButtonB2BHouse.click();
        SeleniumUtils.waitForPageLoad();

    }

    private void completeB2BMaster() throws InterruptedException {
        clickOnTab("B2B Master");
        issueAWBPage.rateClassB2BMaster.sendKeys("B");
        issueAWBPage.rateOrChargeB2BMaster.sendKeys("10");
        issueAWBPage.signOfAgentB2BMaster.sendKeys("Automation");
        issueAWBPage.signOfCarrierAgentB2BMaster.sendKeys("Automation");
        issueAWBPage.completeButtonB2BMaster.click();
        SeleniumUtils.waitForPageLoad();

    }
}
