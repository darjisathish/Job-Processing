package com.agility.focis.salesInvoiceAndCredit;

import com.agility.focis.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SalesPage extends BasePage {

    public SalesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@value='Billing Party' and @type= 'radio']")
    public WebElement billingPartyRadioButton;

    @FindBy(xpath = "//input[@value='Owner' and @type= 'radio']")
    public WebElement ownerRadioButton;

    @FindBy(xpath = "//td[@id='btnOpen']//span")
    public WebElement createNewInvoiceIcon;

//    public WebElement chargesGirdSupplierInvoce() {
//        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
//        return (WebElement) jsExec.executeScript("return (document.getElementById('ObjNewCharge').contentDocument).getElementById('grdChargeCodeDetailsLs')");
//    }
//
//    public WebElement generateInvoiceButton() {
//        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
//        return (WebElement) jsExec.executeScript("return (document.getElementById('ObjNewCharge').contentDocument).getElementById('PWCMasterPage_PWCWebPartManager_gwpSalesInvoiceInfoFrUc_SalesInvoiceInfoFrUc_btnSaveNGen')");
//    }
//
//    @FindBy(xpath = "//input[@title='Generate Invoice']")
//    public WebElement generateInvoiceButton;

    @FindBy(id = "grdChargeCodeDetailsLs")
    public WebElement chargesGrid;

    @FindBy(id = "ObjNewCharge")
    public WebElement salesInvoiceObject;

    @FindBy(xpath = "//input[contains(@id,'txtJobNumber')]")
    public WebElement jobNumberInputBox;

    @FindBy(xpath = "//button[contains(@id,'txtLegalEntity_btnPopup')]")
    public WebElement legalEntitySearchButton;

    @FindBy(xpath = "//input[contains(@id,'SalesInvoiceListLs_btnSearch')]")
    public WebElement searchButton;

    @FindBy(xpath = "//input[contains(@id,'CreditNoteInvoiceFr1_btnSave')]")
    public WebElement createCreditNoteButton;

    @FindBy(id = "gs_DataCode")
    public WebElement entityCodeSearchBox;

    @FindBy(xpath = "//span[@class='ui-icon ui-icon icon-trash red']")
    public WebElement deleteCharges;

    @FindBy(id = "drpReasonCode")
    public WebElement dropdownReasonCode;

    @FindBy(id = "btnReasonCreate")
    public WebElement addButtonReasonCode;

    @FindBy(xpath = "//input[contains(@id,'CreditNoteInvoiceFr1_btnSubmit')]")
    public WebElement sendForApprovalButton;

    @FindBy(xpath = "//textarea[contains(@id,'txtRequestComments')]")
    public WebElement comments;

    @FindBy(id = "btnSubComments")
    public WebElement submitComments;

    @FindBy(xpath = "//input[contains(@id,'CreditNoteInvoiceFr1_btnApprove')]")
    public WebElement approveCreditNoteButton;

    @FindBy(xpath = "//textarea[contains(@id,'txtApprovedComments')]")
    public WebElement approvalComments;

    @FindBy(id = "btnSubApprovedComments")
    public WebElement addButtonApprovedComments;

    @FindBy(xpath = "//input[contains(@id,'CreditNoteInvoiceFr1_btnGenerate')]")
    public WebElement generateCreditNoteButton;

    @FindBy(xpath = "//span[contains(text(),'Sales Credit')]/ancestor::div[@role='dialog']//button[@class='ui-dialog-titlebar-close']")
    public WebElement closeSalesCreditOverlay;

    @FindBy(xpath = "//span[contains(@id,'lblCreditNoteNumber')]")
    public WebElement creditNoteNumber;

    @FindBy(xpath = "//span[contains(@id,'lblOriginalInvNo')]")
    public WebElement originalInvoiceNumber;

    @FindBy(xpath = "//span[contains(@id,'lblStateVal')]")
    public WebElement creditNoteStatus;


}
