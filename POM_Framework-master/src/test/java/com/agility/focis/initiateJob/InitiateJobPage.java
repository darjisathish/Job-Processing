package com.agility.focis.initiateJob;

import com.agility.focis.base.BasePage;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitiateJobPage extends BasePage {

    public InitiateJobPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text() = 'Product']/../following-sibling::div//select")
    public WebElement productDropDown;
    @FindBy(xpath = "//span[text() = 'Product Type']/../following-sibling::div//select")
    public WebElement productTypeDropDown;
    @FindBy(xpath = "//span[text() = 'Job Scope']/../following-sibling::div//select")
    public WebElement jobScopeDropDown;
    @FindBy(xpath = "//span[text() = 'Origin Stakeholder']/../following-sibling::div//input")
    public WebElement OriginStakeholderInput;
    @FindBy(xpath = "//span[text() = 'Destination Stakeholder']/../following-sibling::div//input")
    public WebElement DestinationStakeholderInput;
    @FindBy(xpath = "//input[@name= 'STKNAMEANDADDRESS']")
    public WebElement stakeHolderNameOrID;
    @FindBy(xpath = "//input[contains(@id,'ShipperReftype')]")
    public WebElement shipperReferenceType;
    @FindBy(xpath = "//button[contains(@id,'ShipperReftype_btnPopup')]")
    public WebElement shipperReferenceTypeButton;
    @FindBy(xpath = "//button[contains(@id,'ConsigneeReftype_btnPopup')]")
    public WebElement consigneeReferenceTypeButton;
    @FindBy(xpath = "//input[contains(@id,'ShipRefValue')]")
    public WebElement shipperReference;
    @FindBy(xpath = "//input[contains(@id,'txtConsigneeReftype')]")
    public WebElement consigneeReferenceType;
    @FindBy(xpath = "//input[contains(@id,'txtConsigneeRefValue')]")
    public WebElement consigneeReference;
    @FindBy(xpath = "//span[text()='References']/ancestor::div[@role='dialog']//input[@id='gs_Name']")
    public WebElement referenceInputBox;

    //    Origin and Destination Offices
    @FindBy(xpath = "//input[contains(@id,'txtHAWBAirportofDeparture') or contains(@id,'txtHAWBAirportOfDeparture')]")
    public WebElement airportOfDeparture;
    @FindBy(xpath = "//button[contains(@id,'txtHAWBAirportofDeparture_btnPopup') or contains(@id,'txtHAWBAirportOfDeparture_btnPopup')]")
    public WebElement airportOfDepartureSearchButton;
    @FindBy(id = "gs_Code")
    public WebElement airPortCodeInput;
    @FindBy(xpath = "//input[contains(@id,'txtHAWBAirporttoArrival') or contains(@id,'txtHAWBAirportOfArrival')]")
    public WebElement airportOfArrival;
    @FindBy(xpath = "//button[contains(@id,'txtHAWBAirporttoArrival_btnPopup') or contains(@id,'txtHAWBAirportOfArrival_btnPopup')]")
    public WebElement airportOfArrivalSearchButton;
    @FindBy(xpath = "//input[contains(@id,'txtAgilityPlaceOfReceipt')]")
    public WebElement portOfLoading;
    @FindBy(xpath = "//input[contains(@id,'txtAgilityPlaceOfDelivery')]")
    public WebElement portOfDischarge;

    //    Network Components
    @FindBy(id = "gs_CountryCode")
    public WebElement countryCode;
    @FindBy(id = "gs_LocationName")
    public WebElement networkComponent;
    @FindBy(xpath = "//div[@role='dialog' and contains(@style,'display: block;')]//span[contains(@id,'pnlPopupGridPager')]")
    public WebElement networkComponentPageCount;
    @FindBy(id = "gs_NetworkFunctionName")
    public WebElement type;
    @FindBy(id = "gs_DepartmentName")
    public WebElement departmentName;
    @FindBy(id = "gs_IsLive")
    public WebElement isLive;

    //    Ports
    @FindBy(xpath = "//span[text()='Ports' or text()='IATA Airports List']/ancestor::div[@role='dialog']//input[@name='Name']")
    public WebElement portName;
    @FindBy(xpath = "//span[text()='Ports' or text()='IATA Airports List']/ancestor::div[@role='dialog']//input[@name='CountryCode']")
    public WebElement portCountryCode;


    public WebElement officebestMatch(String countrycode) {
        SeleniumUtils.waitForNumberOfElementsToBeMoreThan(By.xpath("//a[text() = '" + countrycode + "']"), 0);
        return driver.findElements(By.xpath("//td[@aria-describedby= 'pnlPopupGrid_CountryCode']/a[text() = '" + countrycode + "']")).get(0);
    }
    
 
}
