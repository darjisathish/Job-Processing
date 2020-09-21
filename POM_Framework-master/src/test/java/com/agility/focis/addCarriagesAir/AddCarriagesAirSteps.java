package com.agility.focis.addCarriagesAir;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.initiateJob.InitiateJobPage;
import com.agility.focis.utilities.testObject.DynamicTableUtils;
import com.agility.focis.utilities.testObject.HyperLinkUtils;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Sleeper;

import java.io.IOException;

public class AddCarriagesAirSteps extends BaseSteps {
    private WebDriver driver;
    AddCarriagesAirPage addCarriagesAirPage;
    InitiateJobPage initiateJobPage;

    AddCarriagesAirSteps() throws IOException {
        this.driver = getDriver();
        addCarriagesAirPage = new AddCarriagesAirPage(this.driver);
        initiateJobPage = new InitiateJobPage(this.driver);
    }

    private void clickOnAddAirportToAirport() throws InterruptedException {
        clickOnTab("Movement");
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.addAirportToAirportButton);
        addCarriagesAirPage.addAirportToAirportButton.click();
        SeleniumUtils.waitForPageLoad();
    }

    public void addAirportToAirport(String Carrier, String FlightNumber, String AirportOfDeparture, String AirportOfArrival, String ETD, String ETDTime, String ETA, String ETATime, String Supplier, String Cost, String Revenue) throws InterruptedException {
        checkAgilityAirPortOfDeparture(AirportOfDeparture);
        checkAgilityAirPortOfArrival(AirportOfArrival);
        clickOnAddAirportToAirport();
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(addCarriagesAirPage.addAirportToAirportFrame);
        SeleniumUtils.waitForPageLoad();

        if (GlobalVariables.getJobScope().equalsIgnoreCase("E2E")) {
            SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.jobTypeDropdown);
            Thread.sleep(1000);
            addCarriagesAirPage.jobTypeDropdown.click();
            addCarriagesAirPage.jobTypeBackToBack.click();
            addCarriagesAirPage.jobTypeChangeAlert.click();
        }

        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.Carrier);
        Thread.sleep(1000);

        addCarriagesAirPage.Carrier.sendKeys(Carrier);
        addCarriagesAirPage.Carrier.sendKeys(Keys.TAB);
        addCarriagesAirPage.FlightNumber.sendKeys(FlightNumber);
        addCarriagesAirPage.Aod.sendKeys(AirportOfDeparture);
        addCarriagesAirPage.Aod.sendKeys(Keys.TAB);
        addCarriagesAirPage.Aoa.sendKeys(AirportOfArrival);
        addCarriagesAirPage.Aoa.sendKeys(Keys.TAB);
        addCarriagesAirPage.EtdDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(ETD)) + Keys.TAB);
        addCarriagesAirPage.EtdTime.sendKeys(ETDTime);
        addCarriagesAirPage.EtaDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(ETA)) + Keys.TAB);
        addCarriagesAirPage.EtaTime.sendKeys(ETATime);
        if (GlobalVariables.getJobScope().equalsIgnoreCase("E2E")) {
            addCarriagesAirPage.pullMawbNumberIcon.click();
        }

        addCarriagesAirPage.saveAndCompleteActivityButton.click();
        SeleniumUtils.waitForPageLoad();
        Thread.sleep(1000);
//        driver.switchTo().defaultContent();

    }


    public void updateEstimatesMainCarriage(String Supplier, String Cost, String Revenue) throws InterruptedException {
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(addCarriagesAirPage.iFrameEstimationscreen);
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.Supplier);
        addCarriagesAirPage.Supplier.click();
        searchForSTK(Supplier);
        addCarriagesAirPage.enterCost.sendKeys(Cost);
        addCarriagesAirPage.enterRevenue.sendKeys(Revenue);
        addCarriagesAirPage.saveAndCloseButton.click();
        SeleniumUtils.waitForPageLoad();
        Thread.sleep(1200);
    }

    private void checkAgilityAirPortOfDeparture(String airportOfDeparture) throws InterruptedException {
        clickOnTab("Movement");
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(initiateJobPage.airportOfDeparture);
        if (initiateJobPage.airportOfDeparture.getAttribute("value").contains("INNSA") || initiateJobPage.airportOfDeparture.getAttribute("value").equalsIgnoreCase("")) {
            initiateJobPage.airportOfDepartureSearchButton.click();
            SeleniumUtils.waitForPageLoad();
            initiateJobPage.airPortCodeInput.sendKeys(airportOfDeparture + Keys.ENTER);
            SeleniumUtils.waitForPageLoad();
            HyperLinkUtils.clickOnLink(airportOfDeparture);
            SeleniumUtils.waitForPageLoad();

        }
    }

    public void checkAgilityAirPortOfArrival(String airportOfArrival) throws InterruptedException {
        clickOnTab("Movement");
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(initiateJobPage.airportOfArrival);
        if (initiateJobPage.airportOfArrival.getAttribute("value").equalsIgnoreCase("")) {
            initiateJobPage.airportOfArrivalSearchButton.click();
            SeleniumUtils.waitForPageLoad();
            initiateJobPage.airPortCodeInput.sendKeys(airportOfArrival + Keys.ENTER);
            SeleniumUtils.waitForPageLoad();
            HyperLinkUtils.clickOnLink(airportOfArrival);
            SeleniumUtils.waitForPageLoad();

        }
    }

    public void addOrigin(String haulierType, String haulierName, String originCargoCollectionDate, String originCargoDeliveryDate) throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.tab("Movement"));
        addCarriagesAirPage.addOriginButton.click();
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(addCarriagesAirPage.addOriginOrDestinationFrame);
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.haulageArrangementDropdown);
        addCarriagesAirPage.haulierType(haulierType).click();
        addCarriagesAirPage.haulierSearchPicker.click();
        searchForSTK(haulierName);
        addCarriagesAirPage.cargoCollectionDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(originCargoCollectionDate)) + Keys.TAB);
        addCarriagesAirPage.cargoCollectionTime.sendKeys("12");
        addCarriagesAirPage.cargoDeliveryDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(originCargoDeliveryDate)) + Keys.TAB);
        addCarriagesAirPage.cargoDeliveryTime.sendKeys("12");
        addCarriagesAirPage.saveAndCloseOriginCarriage.click();
        SeleniumUtils.waitForPageLoad();
        Thread.sleep(1000);
    }

    public void addDestination(String haulierType, String haulierName, String destinationCargoCollectionDate, String destinationCargoDeliveryDate) throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.tab("Movement"));
        addCarriagesAirPage.addDestinationButton.click();
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(addCarriagesAirPage.addOriginOrDestinationFrame);
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(addCarriagesAirPage.haulageArrangementDropdown);
        addCarriagesAirPage.haulierType(haulierType).click();
        addCarriagesAirPage.haulierSearchPicker.click();
        searchForSTK(haulierName);
        addCarriagesAirPage.cargoCollectionDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(destinationCargoCollectionDate)) + Keys.TAB);
        addCarriagesAirPage.cargoCollectionTime.sendKeys("12");
        addCarriagesAirPage.cargoDeliveryDate.sendKeys(SeleniumUtils.getEffectiveDateAfterDays(Integer.parseInt(destinationCargoDeliveryDate)) + Keys.TAB);
        addCarriagesAirPage.cargoDeliveryTime.sendKeys("12");
        addCarriagesAirPage.saveAndCloseDestinationCarriage.click();
        SeleniumUtils.waitForPageLoad();
        Thread.sleep(1000);
    }
}
