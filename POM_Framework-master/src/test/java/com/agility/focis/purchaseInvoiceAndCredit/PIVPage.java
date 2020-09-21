package com.agility.focis.purchaseInvoiceAndCredit;

import com.agility.focis.base.BasePage;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class PIVPage extends BasePage {

    public PIVPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@data-original-title='Create New PIV']//span[@class='ui-icon icon-plus-sign purple']")
    public WebElement createNewPIVButton;
    @FindBy(id = "spnHeaderStateId")
    public WebElement invoiceStatus;
    @FindBy(xpath = "//button[contains(@id,'txtLegalEntity_btnPopup')]")
    public WebElement legalEntitySearchButton;
    @FindBy(id = "gs_OrganizationCode")
    public WebElement entityCodeSearchBox;
    @FindBy(xpath = "//input[contains(@id,'txtLegalEntity')]")
    public WebElement entityName;
    @FindBy(id = "ddlBranch")
    public WebElement orgComponent;
    @FindBy(xpath = "//span[contains(@id,'lblPivNo')]")
    public WebElement pivNo;
    //    public List<WebElement> pivNums;
    @FindBy(xpath = "//button[contains(@id,'txtPlaceOfSupply_btnPopup')]")
    public WebElement placeOfSupplySearchButton;
    @FindBy(xpath = "//button[contains(@id,'txtSupplier_btnPopup')]")
    public WebElement supplierNameSearchButton;
    @FindBy(xpath = "//input[contains(@id,'txtSupplier')]")
    public WebElement supplier;
    @FindBy(xpath = "//span[contains(@id,'lblInvoiceFromadd')]")
    public WebElement supplierAddress;
    @FindBy(xpath = "//input[contains(@id,'SupplierInvNo')]")
    public WebElement invoiceNum;
    @FindBy(xpath = "//button[contains(@id,'txtSupplierInvoiceDate_btnPopup')]")
    public WebElement invoiceDateButton;
    @FindBy(xpath = "//input[contains(@id,'txtSupplierInvoiceDate')]")
    public WebElement invoiceDate;
    @FindBy(xpath = "//div[contains(@class,'dropdown-menu datepicker') and contains(@style , 'display: block;')]//td[@class = 'day active']")
    public WebElement currentDateAsInvoiceDate;
    @FindBy(xpath = "//div[contains(@class,'dropdown-menu datepicker') and contains(@style , 'display: block;')]//div[@class='datepicker-days']//th[@class='prev']")
    public WebElement prevMonth;
    @FindBy(xpath = "//div[contains(@class,'dropdown-menu datepicker') and contains(@style , 'display: block;')]//div[@class='datepicker-days']//th[@class='next']")
    public WebElement nextMonth;

    public WebElement supplierInvoiceDate(String invoiceDate) {
        WebElement element = null;
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int currentDay = calendar.get(Calendar.DATE);
        if (currentDay - Integer.parseInt(invoiceDate) <= 31) {
            if (driver.findElements(By.xpath("//div[contains(@class,'dropdown-menu datepicker') and contains(@style , 'display: block;')]//td[not(@class='old day') and text()='" + invoiceDate + "']")).size() > 0) {
                element = driver.findElement(By.xpath("//div[contains(@class,'dropdown-menu datepicker') and contains(@style , 'display: block;')]//td[not(@class='old day') and text()='" + invoiceDate + "']"));
            }
        } else {

            element = driver.findElement(By.xpath("//div[contains(@class,'dropdown-menu datepicker') and contains(@style , 'display: block;')]//td[@class='old day' and text()='" + invoiceDate + "']"));
        }

        return element;
    }

    public WebElement futureSupplierInvoiceDate(String invoiceDate) {

        return driver.findElement(By.xpath("//div[contains(@class,'dropdown-menu datepicker') and contains(@style , 'display: block;')]//td[@class='day new' and text()='" + invoiceDate + "']"));

    }


    @FindBy(xpath = "//span[contains(@id,'lblPivDateTime')]")
    public WebElement pivDate;
    @FindBy(xpath = "//span[contains(@id,'lblPivDueDate')]")
    public WebElement pivDueDate;
    @FindBy(xpath = "//input[contains(@id,'txtBankersRef')]")
    public WebElement bankReference;
    @FindBy(xpath = "//select[contains(@id,'ManagePurchaseInvoiceFrUC_ddlPivType')]")
    public WebElement invoiceType;
    @FindBy(xpath = "//select[contains(@id,'ddlPivSubType')]")
    public WebElement invoiceSubType;
    @FindBy(xpath = "//input[contains(@id,'ChkTaxAtHeader')]")
    public WebElement taxAtHeader;
    @FindBy(xpath = "//input[contains(@id,'txtPivAmount')]")
    public WebElement pivAmount;
    @FindBy(xpath = "//input[contains(@id,'txtTaxAmount')]")
    public WebElement taxAmount;
    @FindBy(xpath = "//span[contains(@id,'lblFinNetAmt')]")
    public WebElement totalAmount;
    @FindBy(xpath = "//button[contains(@id,'PivCny_btnPopup')]")
    public WebElement currencyButton;
    @FindBy(id = "gs_CurrencyCode")
    public WebElement currencyCode;
    @FindBy(xpath = "//input[contains(@id,'txtPivCny')]")
    public WebElement pivCurrencyTetBox;
    @FindBy(id = "grdAmountInfo")
    public WebElement amountInfoTable;
    @FindBy(xpath = "//input[@title = 'Create']")
    public WebElement createPIVButton;
    @FindBy(xpath = "//input[@title = 'Cancel PIV']")
    public WebElement cancelPIVButton;
    @FindBy(xpath = "//input[@title = 'Allocate to Jobs/ Consol']")
    public WebElement allocateToJobsORConsolButton;
    @FindBy(xpath = "//input[contains(@id,'ManagePurchaseInvoiceFrUC_btnSave')]")
    public WebElement savePIVButton;
    @FindBy(id = "idSuppNum")
    public WebElement supplierInvoiceNumAllocatePage;

    @FindBy(id = "grdTagJobsLs")
    public WebElement jobsListAllocateJobs;

    @FindBy(id = "grdAmountInfoPopup")
    public WebElement amountInfoTableAllocateJobs;

    @FindBy(xpath = "//input[contains(@id,'PIVTagJobsFrUC_btnSavePIVDetails')]")
    public WebElement allocateButton;

    @FindBy(xpath = "//input[contains(@id,'PIVTagJobsFrUC_txtJobNumber')]")
    public WebElement jobNumberOrConsolNumberInput;

    @FindBy(xpath = "//input[contains(@id,'ManagePurchaseInvoiceFrUC_btnComplete')]")
    public WebElement completeInvoiceButton;

    public WebElement generatedPIVNumber(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'PIVNo')]"));
    }

    public WebElement generatedPIVTotalAmount(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'PIVAmount')]"));
    }

    public WebElement generatedPIVSupplierName(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'StakeHolderName')]"));
    }

    public WebElement generatedPIVDate(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'PIVDateTime')]"));
    }

    public WebElement generatedPIVDueDate(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'PIVDueDate')]"));
    }

    public WebElement generatedPIVStatus(String invoiceNumber) {
        return driver.findElement(By.xpath("//td[contains(@aria-describedby,'SupplierInvNo')]/span[text()='" + invoiceNumber + "']/ancestor::tr[1]/td[contains(@aria-describedby,'StateName')]"));
    }


//    Search Companion - PIV

    @FindBy(xpath = "//input[contains(@id,'txtSupplierInvNo')]")
    public WebElement supplierInvoiceNumberSearchCompanion;

    @FindBy(xpath = "//select[contains(@id,'ManagePIVLsUc_ddlPIVType')]")
    public WebElement pivTypeSearchCompanion;

    @FindBy(xpath = "//select[contains(@id,'ManagePIVLsUc_ddlPivSubType')]")
    public WebElement pivSubtypeSearchCompanion;

    @FindBy(xpath = "//input[contains(@id,'ManagePIVLsUc_btnSearch')]")
    public WebElement searchButtonManagePIV;

    @FindBy(id = "DIVOrgCompState")
    public WebElement orgStateComponent;

    @FindBy(id = "DIVPOS")
    public WebElement placeOfSupplyDiv;

    @FindBy(xpath = "//input[contains(@id,'txtRate')]")
    public WebElement costWriteOffDialog;

    @FindBy(xpath = "//input[contains(@id,'txtTobeAmount')]")
    public WebElement tobePIVedAmount;

    @FindBy(xpath = "//input[contains(@id,'PIVTagJobsFrUC_txtAmount')]")
    public WebElement writeOffAmount;

    @FindBy(xpath = "//select[contains(@id,'drpreason')]")
    public WebElement writeOffReasonCode;

    @FindBy(xpath = "//span[text() = 'Charge Code Details']/ancestor::div[@role = 'dialog']//input[@title = 'Save']")
    public WebElement saveButtonWriteOff;

    @FindBy(id = "grdSavedPIVDetails")
    public WebElement jobsList;

    @FindBy(xpath = "//*[@id='grdSavedPIVDetails']//span[contains(@class,'trash')]")
    public WebElement deleteCharges;

    @FindBy(xpath = "//table[@id='grdPIVSummaryLs']//td[contains(@aria-describedby,'TotalInvoiceAmount')]")
    public WebElement totalPIVAmountPIVSummaryTable;

    @FindBy(xpath = "//table[@id='grdPIVSummaryLs']//td[contains(@aria-describedby,'DiscountValue')]")
    public WebElement discountValuePIVSummaryTable;

    @FindBy(xpath = "//table[@id='grdPIVSummaryLs']//td[contains(@aria-describedby,'WOffAmount')]")
    public WebElement writeOffAmountPIVSummaryTable;

    @FindBy(xpath = "//table[@id='grdPIVSummaryLs']//td[contains(@aria-describedby,'NetAmount')]")
    public WebElement totalNetAmountPIVSummaryTable;

    @FindBy(xpath = "//table[@id='grdPIVSummaryLs']//td[contains(@aria-describedby,'Currency')]")
    public WebElement currencyPIVSummaryTable;

    @FindBy(id = "grdVATSummaryLs")
    public WebElement taxSummaryTable;

    public WebElement editPIVICon(String invoiceNumber) {
        return driver.findElement(By.xpath("//*[text()='" + invoiceNumber + "']/ancestor::tr[1]//*[@title='Edit PIV']"));
    }

    @FindBy(xpath = "//td[@aria-describedby='grdTotalSummaryLs_TotalAmount']")
    public WebElement totalNetAmountTotalSummaryTable;

    @FindBy(xpath = "//td[@aria-describedby='grdTotalSummaryLs_Currency']")
    public WebElement currencyTotalSummaryTable;
}
