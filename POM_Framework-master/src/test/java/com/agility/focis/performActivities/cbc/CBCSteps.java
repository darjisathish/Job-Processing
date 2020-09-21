package com.agility.focis.performActivities.cbc;

import com.agility.focis.addCarriagesAir.AddCarriagesAirPage;
import com.agility.focis.addCarriagesOcean.AddCarriagesOceanPage;
import com.agility.focis.performActivities.common.CommonSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CBCSteps extends CommonSteps {
    private WebDriver driver;
    CBCPage cbcPage;
    AddCarriagesAirPage addCarriagesAirPage;

    public CBCSteps() throws IOException {
        this.driver = getDriver();
        cbcPage = new CBCPage(this.driver);
        addCarriagesAirPage = new AddCarriagesAirPage(this.driver);

    }

    public void performCBC() throws InterruptedException {
        fillBookingReferenceIfRequired();
        clickOnTab("Tasks");
        SeleniumUtils.waitForPageLoad();
        clickOnPerformActivityIcon("Carrier Booking Confirmation");
        if (isDialogPopulated("Carrier Booking Confirmation")) {
            SeleniumUtils.waitForElementToBeClickable(cbcPage.confirmCBC);
            cbcPage.confirmCBC.click();
            cbcPage.completeCBCButton.click();
            SeleniumUtils.waitForPageLoad();
        }


    }

    private void fillBookingReferenceIfRequired() throws InterruptedException {
        clickOnTab("Movement");
        SeleniumUtils.waitForPageLoad();
        if (!addCarriagesAirPage.carrierBookingReference.isEnabled()) {
            clickOnTab("Tasks");
            SeleniumUtils.waitForPageLoad();
            clickOnPerformActivityIcon("Carrier Booking Confirmation");
            SeleniumUtils.waitForPageLoad();
            acceptWarningIfPopulated("Booking Reference is required to perform Carrier Booking Confirmation.");
            SeleniumUtils.waitForPageLoad();
            fillBookingReferenceIfRequired();
        } else {
            addCarriagesAirPage.carrierBookingReference.clear();
            addCarriagesAirPage.carrierBookingReference.sendKeys("12345678");
        }
    }
}
