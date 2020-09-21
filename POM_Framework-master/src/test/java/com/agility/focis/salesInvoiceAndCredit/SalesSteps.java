package com.agility.focis.salesInvoiceAndCredit;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.purchaseInvoiceAndCredit.PIVSteps;
import com.agility.focis.utilities.testObject.*;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class SalesSteps extends BaseSteps {
    private WebDriver driver;
    private SalesPage salesPage;

    public SalesSteps() throws IOException {
        this.driver = getDriver();
        salesPage = new SalesPage(this.driver);

    }

    public void processSalesInvoice(Map<String, String> invoiceInfo) throws InterruptedException {
        String billToParty = invoiceInfo.get("Bill To Party ");
        String numberOfCharges = invoiceInfo.get("Charges");
        if (salesPage.billingPartyRadioButton.isDisplayed()) {
            salesPage.billingPartyRadioButton.click();
        }

        salesPage.createNewInvoiceIcon.click();
        SeleniumUtils.waitForPageLoad();
        Thread.sleep(25000);
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToVisible(salesPage.salesInvoiceObject);
//        salesPage.generateInvoiceButton().click();
//        driver.findElement(By.xpath("//input[@title='Generate Invoice']")).click();
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("(document.getElementById('ObjNewCharge').contentDocument).getElementById('PWCMasterPage_PWCWebPartManager_gwpSalesInvoiceInfoFrUc_SalesInvoiceInfoFrUc_btnSaveNGen').click()");
        SeleniumUtils.waitForPageLoad();
        Thread.sleep(20000);
        SeleniumUtils.switchToParentWindow();
    }

    public void generateCreditNote(String jobNumber, String legalEntity, String numberOfCharges) throws InterruptedException {
        searchForSalesInvoices(jobNumber, legalEntity);
        String invoiceNumber = DynamicTableUtils.getText("JobNumber", jobNumber, "InvNo");
        DynamicTableUtils.clickOnLinkUsingReferenceData("InvNo", invoiceNumber);
        List<WebElement> charges = salesPage.chargesGrid.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
        if (numberOfCharges.equalsIgnoreCase("All") || charges.size() == 1) {
            updateCreditAmount(charges);
        } else {
            int numberofChargesToDelete = ThreadLocalRandom.current().nextInt(1, charges.size());
            System.out.println(numberOfCharges + "Number of Charges To Delete");
            List<Integer> values = SeleniumUtils.getDistinctRandomValuesInARage(1, charges.size(), numberofChargesToDelete);
            for (int value : values) {
                System.out.println(value + "Value");
                charges.get(value).findElement(By.xpath(".//input[@role='checkbox']")).click();
            }
            salesPage.deleteCharges.click();
            SeleniumUtils.waitForPageLoad();
            charges = salesPage.chargesGrid.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
            updateCreditAmount(charges);
        }
        salesPage.createCreditNoteButton.click();
        SeleniumUtils.waitForPageLoad();
        Select dropdown = new Select(salesPage.dropdownReasonCode);
        dropdown.selectByVisibleText("Operational Error");
        salesPage.addButtonReasonCode.click();
        SeleniumUtils.waitForPageLoad();
        salesPage.sendForApprovalButton.click();
        SeleniumUtils.waitForPageLoad();
        salesPage.comments.sendKeys("Auto");
        salesPage.submitComments.click();
        SeleniumUtils.waitForPageLoad();
        System.out.println(SpanUtils.getText("Credit Note Number"));

    }

    public static void updateCreditAmount(List<WebElement> charges) {

        for (WebElement charge : charges) {
            double invoicedAmount = Double.parseDouble(charge.findElement(By.xpath(".//td[@aria-describedby='grdChargeCodeDetailsLs_AmountInvoicedB']")).getText().replaceAll(",",""));
            double creditAmount = ThreadLocalRandom.current().nextDouble(1.00, invoicedAmount - 0.5);
            System.out.println(String.format("%.2f", creditAmount) + " is Credit amount");
            charge.findElement(By.xpath(".//input[@name='CreditAmount']")).sendKeys(String.format("%.2f", creditAmount));
        }

    }

    public void searchForSalesInvoices(String jobNumber, String legalEntity) throws InterruptedException {
        salesPage.jobNumberInputBox.sendKeys(jobNumber);
        SeleniumUtils.waitForElementToBeClickable(salesPage.legalEntitySearchButton);
        salesPage.legalEntitySearchButton.click();
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToVisible(salesPage.entityCodeSearchBox);
        salesPage.entityCodeSearchBox.sendKeys(legalEntity);
        Thread.sleep(1000);
        salesPage.entityCodeSearchBox.sendKeys(Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        HyperLinkUtils.clickOnLink(legalEntity);
        salesPage.searchButton.click();
        SeleniumUtils.waitForPageLoad();
    }

    public void approveCreditNote(String jobNumber, String legalEntity) throws InterruptedException {
        searchForSalesInvoices(jobNumber, legalEntity);
        DynamicTableUtils.clickOnIconUsingReferenceData("JobNumber", jobNumber, "blue");
        SeleniumUtils.waitForPageLoad();
        salesPage.approveCreditNoteButton.click();
        SeleniumUtils.waitForPageLoad();
        salesPage.approvalComments.sendKeys("Automation");
        salesPage.addButtonApprovedComments.click();
        SeleniumUtils.waitForPageLoad();
    }

    public void generateApprovedCreditNote(String jobNumber, String legalEntity) throws InterruptedException {
        searchForSalesInvoices(jobNumber, legalEntity);
        DynamicTableUtils.clickOnIconUsingReferenceData("JobNumber", jobNumber, "blue");
        SeleniumUtils.waitForPageLoad();
        salesPage.generateCreditNoteButton.click();
        SeleniumUtils.waitForPageLoad();
        salesPage.closeSalesCreditOverlay.click();
        SeleniumUtils.waitForPageLoad();
        String creditNoteNumber = salesPage.creditNoteNumber.getText();
        String originalInvoiceNumber = salesPage.originalInvoiceNumber.getText();
        String status = salesPage.creditNoteStatus.getText();
        SeleniumUtils.logInfo("Credit Note Number: " + creditNoteNumber + "\nOriginal Invoice Number: " + originalInvoiceNumber + "\nCredit Note Status: " + status);

    }
}
