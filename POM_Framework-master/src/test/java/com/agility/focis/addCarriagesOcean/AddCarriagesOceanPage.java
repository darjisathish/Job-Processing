package com.agility.focis.addCarriagesOcean;

import com.agility.focis.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddCarriagesOceanPage extends BasePage {

    public AddCarriagesOceanPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@id='spnAddMainCarriage']")
    public WebElement addMainCarriageButton;

    @FindBy(xpath = "//iframe[contains(@src,'routesearchofmainfrpg')]")
    public WebElement mainCarriageiFrame;
    @FindBy(xpath = "//input[@title = 'Use Blank Schedule']")
    public WebElement useBlankSchedule;

    @FindBy(xpath = "//select[contains(@id,'JobTypes')]")
    public WebElement jobType;
    @FindBy(xpath = "//legend[text() = 'Schedule Details']/../..//span[text() = 'Carrier']/ancestor::div[1]//input[@type = 'text']")
    public WebElement carrierInput;

    @FindBy(id = "txtVsVessel_2")
    public WebElement vesselDefaultLeg;

    public WebElement vessel(int i) {
        return driver.findElement(By.xpath("//*[@id = 'txtVsVessel_" + i + "']"));
    }

    @FindBy(xpath = "//select[contains(@id,'RouteSearchFr1_ddlTransportMode')]")
    List<WebElement> mode;

    public WebElement voyage(int i) {
        return driver.findElement(By.xpath("//*[@id = 'txtVsVoyage_" + i + "']"));
    }

    public WebElement portOFLoading(int i) {
        return driver.findElement(By.xpath("//input[contains(@id,'PortOfLoading_" + i + "')]"));
    }

    @FindBy(xpath = "//button[contains(@id,'txtVsPortOfLoading')]")
    public List<WebElement> portOfLoadingSearchButton;

    public WebElement portOfDischarge(int i) {
        return driver.findElement(By.xpath("//input[contains(@id,'PortOfDischarge_" + i + "')]"));
    }

    @FindBy(xpath = "//button[contains(@id,'hdnVsPortOfDischargeId')]")
    List<WebElement> portOfDischargeSearchButton;

    public WebElement etd(int i) {
        return driver.findElement(By.xpath("//input[contains(@id,'ETDDate_" + i + "')]"));
    }

    public WebElement eta(int i) {
        return driver.findElement(By.xpath("//input[contains(@id,'ETADate_" + i + "')]"));
    }

    public WebElement etdTime(int i) {
        return driver.findElement(By.xpath("//input[contains(@id,'ETDTime_" + i + "')]"));
    }

    public WebElement etaTime(int i) {
        return driver.findElement(By.xpath("//input[contains(@id,'ETADate_" + i + "') and @placeholder='hh:mm']"));
    }

    public WebElement originMainCheckBox(int i) {
        return driver.findElement(By.xpath("//*[@id = 'originOrDestMain_" + i + "' and @class='OriginMain']"));
    }

    public WebElement destinationMainCheckBox(int i) {
        return driver.findElement(By.xpath("//*[@id = 'originOrDestMain_" + i + "' and @class='DestinationMain']"));
    }

    @FindBy(id = "btnSAndUManulMainCarriage")
    public WebElement saveAndCloseMainCarriageButton;

    @FindBy(id = "//a[contains(@id,'btnEditMainOFRoute')]")
    public WebElement editMainCarriage;

    @FindBy(id = "divProcessingIndicator")
    public WebElement progressIndicator;


//    --------------------------- Pre Carriage Locators------------------

    @FindBy(xpath = "//span[@id='spnAddPreCarriage']")
    public WebElement addPreCarriageButton;

    @FindBy(xpath = "//iframe[contains(@src,'routesearchofpreonfrpg')]")
    public WebElement preOrOnCarriageFrame;

    @FindBy(xpath = "//span[text() = 'Haulage Arrangement']/../..//select")
    public WebElement haulageArrangementDropDown;

    @FindBy(xpath = "//span[text()='Haulier Name']/ancestor::div[1]//button")
    public WebElement clicksOnHaulierSearchPicker;
    @FindBy(xpath = "//span[text() = 'Haulier Name']/../following-sibling::div//input[@type = 'text']")
    public WebElement haulierInput;
    @FindBy(xpath = "//input[contains(@id , 'CargoPickupDate')]")
    public WebElement originOrDestinationCollDate;
    @FindBy(xpath = "//input[contains(@id, 'CargoPickupFromTime')]")
    public WebElement originOrDestinationCollTime;
    @FindBy(xpath = "//div[contains(@class , 'datepicker')]//input[contains(@id , 'CargoDelivery')]")
    public WebElement originOrDestinationDelDate;
    @FindBy(xpath = "//input[contains(@id, 'CargoDeliveryFromTime')]")
    public WebElement originOrDestinationDelTime;

    @FindBy(xpath = "//select[@id='drpFilterStkType']")
    public WebElement clickOnStakeholderTypeDropdown;
    @FindBy(id = "btnSave")
    public WebElement savePreCarriage;

    //    --------------------------------- On Carriage -------------------------------
    @FindBy(id = "spnAddOnCarriage")
    public WebElement addOnCarriageButton;


}
