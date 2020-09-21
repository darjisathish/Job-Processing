package com.agility.focis.addPackagesAndUnits;

import com.agility.focis.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddPackagesAndUnitsPage extends BasePage {

    AddPackagesAndUnitsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "btnUnitPackages")
    public WebElement addOrEditPackages;

    @FindBy(id = "btnShipmentPackages")
    public WebElement addOrEditPackagesLCL;

    @FindBy(xpath = "//span[contains(@id,'ProdTypeName')]")
    public WebElement productTypeName;
    @FindBy(xpath = "//span[contains(@id,'ProdName')]")
    public WebElement productName;
    @FindBy(xpath = "//input[contains(@onclick,'EditCargoPackagesDetails') and @value = 'Edit']")
    public WebElement editPackages;
    @FindBy(xpath = "//input[contains(@onclick,'EditCargoPackagesDetails') and @value = 'View']")
    public WebElement viewPackages;
    @FindBy(xpath = "//input[@value = 'Add Rows']")
    public WebElement addRows;

    public WebElement noOfPackages(int i) {
        return driver.findElements(By.xpath("//table//input[@placeholder= 'Packages']")).get(i);
    }

    public WebElement type(int i) {
        return driver.findElements(By.xpath("//table//input[@placeholder= 'Type']")).get(i);
    }

    public WebElement perPieceWt(int i) {
        return driver.findElements(By.xpath("//table//input[@placeholder= 'Per Piece']")).get(i);
    }

    public WebElement grossWeight(int i) {
        return driver.findElements(By.xpath("//table//input[@placeholder= 'Gross Weight']")).get(i);
    }

    public WebElement length(int i) {
        return driver.findElements(By.xpath("//table//input[@placeholder= 'L']")).get(i);
    }

    public WebElement width(int i) {
        return driver.findElements(By.xpath("//table//input[@placeholder= 'W']")).get(i);
    }

    public WebElement height(int i) {
        return driver.findElements(By.xpath("//table//input[@placeholder= 'H']")).get(i);
    }

    public WebElement volume(int i) {
        return driver.findElements(By.xpath("//table//input[@placeholder= 'Volume']")).get(i);
    }

    public WebElement shippingMarks(int i) {
        return driver.findElements(By.xpath("//table//textarea[@placeholder= 'Shipping Marks']")).get(i);
    }

    public WebElement description(int i) {
        return driver.findElements(By.xpath("//table//textarea[@placeholder= 'Description']")).get(i);
    }

    public WebElement isHazrdous(int i) {
        return driver.findElements(By.xpath("//table//input[contains(@data-bind,'IsHazardous')]")).get(i);
    }

    public WebElement isReefer(int i) {
        return driver.findElements(By.xpath("//table//input[contains(@data-bind,'IsReefer')]")).get(i);
    }

    public WebElement isNonStackable(int i) {
        return driver.findElements(By.xpath("//table//input[contains(@data-bind,'IsNonStackable')]")).get(i);
    }

    public String getDialogueTitle() {
        if (driver.findElements(By.xpath("//div[contains(@class ,'ui-dialog-titlebar')]//span[contains(text() , 'Edit Packages')]")).size() > 0) {
            return "Edit Packages";
        } else {
            return "New Job";
        }
    }

    //    ****EditUnits****
    @FindBy(id = "btnCargoUnits")
    public WebElement addOrEditUnits;

    @FindBy(id = "btnCargoShipment")
    public WebElement addUnitsLCLOrShipmentAir;
    @FindBy(xpath = "//input[contains(@onclick,'UnitsDetails') and @value = 'Add']")
    public WebElement addUnits;
    @FindBy(xpath = "//input[contains(@onclick,'LoadShipment') and @value = 'Edit']")
    public WebElement editShipment;
    @FindBy(xpath = "//div[@aria-describedby='divCargoShipmentDetails']//textarea[@placeholder='Marks and Numbers']")
    public WebElement shipmentMarks;
    @FindBy(xpath = "//div[@aria-describedby='divCargoShipmentDetails']//textarea[@placeholder='Description']")
    public WebElement shipmentDescription;

    public WebElement noOfunits(int i) {
        return driver.findElements(By.xpath("//input[@placeholder='Units']")).get(i);
    }

    public WebElement unitType(int i) {
        return driver.findElements(By.xpath("//select[contains(@data-bind,'Unit Type')]")).get(i);
    }

    public WebElement isShipperOwned(int i) {
        return driver.findElements(By.xpath("//input[@name = 'IsShipperOwned']")).get(i);
    }

    public WebElement estimatedGrossWeightPerUnit(int i) {
        return driver.findElements(By.xpath("//input[@placeholder = 'Est Gr Wt / Unit']")).get(i);
    }

    public WebElement estimatedVolumePerUnit(int i) {
        return driver.findElements(By.xpath("//input[@placeholder = 'Est Volume / Unit']")).get(i);
    }

    public WebElement marksAndNumbers(int i) {
        return driver.findElements(By.xpath("//table[@id = 'tblCargoDetails']//textarea[@placeholder = 'Marks and Numbers']")).get(i);
    }

    @FindBy(xpath = "//input[@value = 'Add More']")
    public WebElement addMoreButton;

    public WebElement unallocatedPackages(int i) {
        return driver.findElements(By.xpath("//div[@id ='Package_div']//tr//span[contains(@data-bind , 'DisplayNoOfPkgs')]")).get(i);
    }

    public WebElement unallocatedUnits(int i) {
        return driver.findElements(By.xpath("//div[contains(@data-bind , 'AllocatedPackages') and contains(@id,'Unit')]")).get(i);
    }

    public WebElement acceptPackageAllocationWarning(int i) {
        return driver.findElements(By.xpath("//span[text() = 'Package Allocation Warning']/ancestor::div[@role = 'dialog']//button[text() = 'Yes']")).get(i);
    }

    @FindBy(xpath = "//input[contains(@id ,'BookingDetailsFr1_btnSave') and @value = 'Save']")
    public WebElement saveBookingDetailsButton;

    public List<WebElement> getUnits() {
        return driver.findElements(By.xpath("//*[@title = 'Edit Unit' and contains(@class,'icon-pencil blue')]"));
    }

    @FindBy(xpath = "//input[contains(@id,'UnitSealData')]")
    public WebElement sealNumber;

    @FindBy(xpath = "//*[@id='alertMsgBox']//*[@id='alrtMsg']")
    public WebElement alertMessage;
}
