package com.agility.focis.purchaseInvoiceAndCredit;

import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PIVStepDefinitions {
    private PIVSteps pivSteps;

    public PIVStepDefinitions() throws IOException {

        pivSteps = new PIVSteps();
    }

    @When("Creates PIV Header with below details")
    public void creates_PIV_Header_with_below_details(List<Map<String, String>> pivHeaderInfo) throws InterruptedException {
        pivSteps.navigateToManagePIVPage();
//        GlobalVariables.setJobNumber("100151429");
        for (Map<String, String> pivHeaderDetails : pivHeaderInfo) {
            pivSteps.createPIVHeader(pivHeaderDetails);
        }
    }

    @Then("Supplier Name and Supplier Invoice Number should be populated correctly")
    public void supplierNameAndSupplierInvoiceNumberShouldBePopulatedCorrectly() throws InterruptedException {
        pivSteps.verifySupplierInvoiceNumber();
        pivSteps.verifySupplierName();
        if (!SeleniumUtils.getMessageToPrint().equalsIgnoreCase("")) {
            Assert.fail();
        }
    }

    @And("PIV Amount Table should be populated correctly")
    public void pivAmountTableShouldBePopulatedCorrectly() {
    }

    @And("Processes {string} with below details")
    public void processesWithBelowDetails(String pivType, List<Map<String, String>> pivHeaderInfo) throws InterruptedException {
        pivSteps.navigateHomePage();
        pivSteps.selectMenu("Purchase Invoice/Credit", "Purchase Invoice/Credit/Fast Check", "Job");

        for (Map<String, String> pivHeaderDetails : pivHeaderInfo) {
            Map<String, String> mapToPass = new HashMap<>(pivHeaderDetails);
            if (pivType.equalsIgnoreCase("Purchase Invoice")) {
                mapToPass.put("PIV Amount", "100.00");
            } else {
                mapToPass.put("PIV Amount", "-100.00");
            }
            mapToPass.put("Tax Amount", "0.00");
            if (pivHeaderDetails.get("Entity Code").equalsIgnoreCase("1200")) {
                mapToPass.put("Currency", "USD");
            } else {
                mapToPass.put("Currency", "INR");
            }

            pivSteps.createPIVHeader(mapToPass);
            String jobNumber;
            if (pivHeaderDetails.get("Job Number").equalsIgnoreCase("Current Job")) {
                jobNumber = GlobalVariables.getJobNumber();
            } else {
                jobNumber = pivHeaderDetails.get("Job Number");
            }
            pivSteps.processPIV(jobNumber, pivType);
        }

    }

    @And("clicks on {string} Icon")
    public void clicksOnIcon(String Icon) throws InterruptedException {
        pivSteps.clickOnCreateNewPIVIcon();
    }

    @Then("PIV Header details should be populated as below")
    public void pivHeaderDetailsShouldBePopulatedAsBelow(List<Map<String, String>> pivHeaderInfo) {
        for (Map<String, String> pivHeaderDetails : pivHeaderInfo) {
            pivSteps.verifyPIVHeader(pivHeaderDetails);
            if (SeleniumUtils.getMessageToPrint().length() > 0) {
                Assert.fail("PIV Header Detials didn't match");
            }
        }
    }

    @And("Invoice Status should be {string}")
    public void invoiceStatusShouldBe(String invoiceStatus) {
        pivSteps.verifyInvoiceStatus(invoiceStatus);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail();
        }
        SeleniumUtils.takeScreenshot();
    }

    @When("enters Supplier Invoice Date as {string}")
    public void entersSupplierInvoiceDateAs(String stepDefInvoiceDate) throws InterruptedException {
        pivSteps.selectInvoiceDate(stepDefInvoiceDate);

    }

    @When("selects Entity Code as {string}")
    public void selectsEntityCodeAs(String stepDefEntityCode) throws InterruptedException {
        pivSteps.selectEntityCode(stepDefEntityCode);

    }

    @And("selects Org Component as {string}")
    public void selectsOrgComponentAs(String stepdefOrgComponent) throws InterruptedException {
        pivSteps.selectOrgComponent(stepdefOrgComponent);

    }

    @And("selects Supplier as {string}")
    public void selectsSupplierAs(String stepDefSupplier) throws InterruptedException {
        pivSteps.selectSupplier(stepDefSupplier);
    }

    @Then("Org Component State and Place Of Supply should be populated")
    public void orgComponentStateAndPlaceOfSupplyShouldBePopulated() {
        pivSteps.verifyStateAndPlaceOfSupplyArePopulated();
    }

    @Then("Bank Reference textbox will be enabled")
    public void bankReferenceTextboxWillBeEnabled() {
        pivSteps.verifyBankReferenceStatus("Enabled");
    }

    @Then("PIV Due Date should be populated as {string}")
    public void pivDueDateShouldBePopulatedAs(String stepDefPiVDueDate) {
        pivSteps.verifypivDueDate(stepDefPiVDueDate);
    }

    @And("selects Invoice Type as {string}")
    public void selectsInvoiceTypeAs(String stepDefPIVType) {
        pivSteps.selectInvoiceType(stepDefPIVType);
    }

    @And("selects Invoice Sub Type as {string}")
    public void selectsInvoiceSubTypeAs(String stepDefInvoiceSubType) {
        pivSteps.selectInvoiceSubType(stepDefInvoiceSubType);
    }

    @Then("Tax Amount field should be disabled")
    public void taxAmountFieldShouldBeDisabled() {
        pivSteps.verifyTaxAmountStatus("Disabled");
    }

    @And("enters PIV Amount as {string}")
    public void entersPIVAmountAs(String stepDefPIVAmount) {
        pivSteps.enterPIVAmount(stepDefPIVAmount);
    }

    @And("enters Tax Amount as {string}")
    public void entersTaxAmountAs(String stepDefTaxAmount) {
        pivSteps.enterTaxAmount(stepDefTaxAmount);
    }

    @Then("Total Amount should be populated as {string}")
    public void totalAmountShouldBePopulatedAs(String stepDefTotalAmount) {
        pivSteps.verifyTotalAmount(stepDefTotalAmount);
    }

    @Then("Supplier Address should be populated as Primary Address")
    public void supplierAddressShouldBePopulatedAsPrimaryAddress() {
        pivSteps.verifySupplierAddress();
    }

    @And("selects Tax At Header CheckBox")
    public void selectsTaxAtHeaderCheckBox() {
        pivSteps.selectTaxAtHeader();
    }

    @Then("PIV Amount field should be disabled")
    public void pivAmountFieldShouldBeDisabled() {
        pivSteps.verifyPIVAmountStatus("Disabled");
    }

    @And("selects Currency as {string}")
    public void selectsCurrencyAs(String stepDefCurrency) throws InterruptedException {
        pivSteps.selectInvoiceCurrency(stepDefCurrency);

    }

    @Then("Currency should populated as {string}")
    public void currencyShouldPopulatedAs(String stepDefCurrency) {
        pivSteps.verifyCurrencyInAmountInfoTable(stepDefCurrency);
    }


    @Then("PIV Amount and Tax Amount should be displayed as Zero in {string} Row")
    public void pivAmountAndTaxAmountShouldBeDisplayedAsZeroInRow(String row) {
        pivSteps.verifyRowDataAmountInfoTable(row, "0.00", "0.00", "0.00", "");
    }

    @Then("{string} Dialog should be populated")
    public void dialogShouldBePopulated(String stepDefDiogLogName) throws InterruptedException {
        Assert.assertTrue(pivSteps.isDialogPopulated(stepDefDiogLogName));
    }

    @Then("PIV Amount, Tax Amount and Currency should be displayed as {string} , {string} ,{string} in {string} Row on Allocate Jobs dialog")
    public void pivAmountTaxAmountAndCurrencyShouldBeDisplayedAsInRowOnAllocateJobsDialog(String pivAmount, String taxAmount, String currency, String row) throws InterruptedException {

        pivSteps.verifyRowDataAmountInfoTableAllocatePage(row, pivAmount, taxAmount, currency);

    }

    @Then("Charges belong to Supplier {string} only listed")
    public void chargesBelongToSupplierOnlyListed(String supplier) {
        pivSteps.verifyListedChargesforSupplier(supplier);
    }

    @And("Enters Current Number in to allocate Charges")
    public void entersCurrentNumberInToAllocateCharges() throws InterruptedException {
        pivSteps.enterJobNumber(GlobalVariables.getJobNumber());
    }

    @Then("Tagged jobs details should be populated correctly")
    public void taggedJobsDetailsShouldBePopulatedCorrectly() {
        pivSteps.verifyTaggedJobDetails(GlobalVariables.getJobNumber(), GlobalVariables.getOriginSTKName(), GlobalVariables.getDestinationSTKName(), "Partially Accrued");
    }

    @And("selects charges")
    public void selectsCharges() {
        pivSteps.selectCharges();
    }

    @And("modifies Tax Code for a Charge")
    public void modifiesTaxCodeForACharge() throws InterruptedException {
        pivSteps.modifyTaxCodeForACharge();
    }

    @Then("Tax Amount and Total Amount should be populated correctly for modified Charge")
    public void taxAmountAndTotalAmountShouldBePopulatedCorrectlyForModifiedCharge() throws InterruptedException {
        pivSteps.verifyAmountsOfTaxModifiedCharge();
    }

    @Then("User is able to modify Supplier Tax Amount")
    public void userIsAbleToModifySupplierTaxAmount() throws InterruptedException {
        pivSteps.modifySupplierTaxAmountForACharge();

    }

    @Then("Total Amount should be populated correctly after modifying Supplier Tax Amount")
    public void totalAmountShouldBePopulatedCorrectlyAfterModifyingSupplierTaxAmount() {
        pivSteps.verifyTotalAmountAfterModifyinSupplierTaxAmount();
    }

    @Then("difference between Tax Amount and Supplier Tax Amount should be populated correctly")
    public void differenceBetweenTaxAmountAndSupplierTaxAmountShouldBePopulatedCorrectly() {
        pivSteps.verifytaxAmtDiffAfterSuppTaxModification();
    }

    @And("applies Write Off for a Charge")
    public void appliesWriteOffForACharge() throws InterruptedException {
        pivSteps.applyWriteOffForACharge();
    }

    @Then("Total Amount should be populated correctly after Write Off for Wrote Off Charge")
    public void totalAmountShouldBePopulatedCorrectlyAfterWriteOffForWroteOffCharge() throws InterruptedException {
        pivSteps.verifyTotalAmountAfterWriteOff();
    }

    @And("Allocates Charges")
    public void allocatesCharges() throws InterruptedException {
        pivSteps.allocateCharges();
        SeleniumUtils.takeScreenshot();

    }

    @And("PIV Amount, Tax Amount and Currency should be displayed as {string} , {string} ,{string} in {string} Row")
    public void pivAmountTaxAmountAndCurrencyShouldBeDisplayedAsInRow(String pivAmount, String taxAmount, String currency, String row) throws InterruptedException {
        pivSteps.verifyRowDataAmountInfoTableAllocatePage(row, pivAmount, taxAmount, currency);
    }

    @And("Updates PIV Amount and Tax Amount as per Tax Code modification")
    public void updatesPIVAmountAndTaxAmountAsPerTaxCodeModification() {
    }

    @And("Partially Allocates Charges")
    public void partiallyAllocatesCharges() throws InterruptedException {
        pivSteps.partiallyAllocateCharges();

    }

    @Then("user should be able to delete random charges")
    public void userShouldBeAbleToDeleteRandomCharges() throws InterruptedException {
        pivSteps.deleteRandomAllocatedCharges();
    }

    @Then("user should be able to delete all Allocated Charges")
    public void userShouldBeAbleToDeleteAllAllocatedCharges() throws InterruptedException {
        pivSteps.deleteAllAllocatedCharges();
    }

    @Then("user should be able to add charges")
    public void userShouldBeAbleToAddCharges() throws InterruptedException {
        pivSteps.enterJobNumber(GlobalVariables.getJobNumber());
        selectsCharges();
        pivSteps.clickOnaButton("Allocate");
    }

    @Then("Total PIV Amount of PIV Summary Table should be populated as {string}")
    public void totalPIVAmountOfPIVSummaryTableShouldBePopulatedAs(String pivAmount) throws InterruptedException {
        pivSteps.verifyPIVAmountPIVSummaryTable(pivAmount);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Total PIV Amount Populated Incorrectly");
        }
    }

    @And("Discount Value of PIV Summary Table should be populated as {string}")
    public void discountValueOfPIVSummaryTableShouldBePopulatedAs(String discountValue) throws InterruptedException {
        pivSteps.verifyDiscountValuePIVSummaryTable(discountValue);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Discount Value Populated Incorrectly");
        }
    }

    @And("Write of Amount of PIV Summary Table should be populated as {string}")
    public void writeOfAmountOfPIVSummaryTableShouldBePopulatedAs(String writeOffAmount) throws InterruptedException {
        pivSteps.verifyWriteOffAmountPIVSummaryTable(writeOffAmount);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Write Off Amount Populated Incorrectly");
        }
    }

    @And("Total Net Amount of PIV Summary Table should be populated as {string}")
    public void totalNetAmountOfPIVSummaryTableShouldBePopulatedAs(String totalNetAmount) throws InterruptedException {
        pivSteps.verifyTotalNetAmountPIVSummaryTable(totalNetAmount);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Total Net Amount Populated Incorrectly");
        }
    }

    @And("Currency of PIV Summary Table should populated as {string}")
    public void currencyOfPIVSummaryTableShouldPopulatedAs(String currency) throws InterruptedException {
        pivSteps.verifyCurrencyPIVSummaryTable(currency);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Currency Populated Incorrectly");
        }
    }

    @Then("Total Charge Amount of Tax Summary Table for a Tax Code should be populated as {string}")
    public void totalChargeAmountOfTaxSummaryTableForATaxCodeShouldBePopulatedAs(String totalChargeAmount) throws InterruptedException {
        pivSteps.verifyTotalChargeAmountOfTaxSummaryTable(totalChargeAmount);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Tax Summary Details Populated Incorrectly");
        }
    }

    @And("Tax Rate of Tax Summary Table should be populated correctly")
    public void taxRateOfTaxSummaryTableShouldBePopulatedCorrectly() throws InterruptedException {
        pivSteps.verifyTaxRateTaxSummaryTable();
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Tax Summary Details Populated Incorrectly");
        }
    }

    @And("Total Tax Amount of Tax Summary Table should be populated as {string}")
    public void totalTaxAmountOfTaxSummaryTableShouldBePopulatedAs(String totalTaxAmount) throws InterruptedException {
        pivSteps.verifyTotalTaxAmountOfTaxSummaryTable(totalTaxAmount);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Tax Summary Details Populated Incorrectly");
        }
    }

    @And("Supplier Total Tax Amount of Tax Summary Table should be populated as {string}")
    public void supplierTotalTaxAmountOfTaxSummaryTableShouldBePopulatedAs(String supplierTaxAmount) throws InterruptedException {
        pivSteps.verifySupplierTotalTaxAmountOfTaxSummaryTable(supplierTaxAmount);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Tax Summary Details Populated Incorrectly");
        }
    }

    @And("Edits PIV with Supplier Invoice Number {string}")
    public void editsPIVWithSupplierInvoiceNumber(String invoiceNum) throws InterruptedException {
        pivSteps.editPIV("", "", "", invoiceNum, "");
    }

    @And("Currency of Total Summary Table should populated as {string}")
    public void currencyOfTotalSummaryTableShouldPopulatedAs(String stepDefCurrency) throws InterruptedException {
        pivSteps.verifyCurrencyTotalSummaryTable(stepDefCurrency);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Total Summary Details Populated Incorrectly");
        }
        SeleniumUtils.takeScreenshot();
    }

    @Then("Net Amount of Total Summary Table should be populated as {string}")
    public void netAmountOfTotalSummaryTableShouldBePopulatedAs(String stepDefNetAmount) throws InterruptedException {
        pivSteps.verifyNetAmountTotalSummaryTable(stepDefNetAmount);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Total Summary Details Populated Incorrectly");
        }
    }

    @And("Currency of Tax Summary Table should populated as {string}")
    public void currencyOfTaxSummaryTableShouldPopulatedAs(String stepDefCurrency) throws InterruptedException {
        pivSteps.verifyCurrencyOfTaxSummaryTable(stepDefCurrency);
        if (SeleniumUtils.getMessageToPrint().length() > 0) {
            Assert.fail("Tax Summary Details Populated Incorrectly");
        }
        SeleniumUtils.takeScreenshot();

    }

    @And("Updates PIV Amount and Tax Amount")
    public void updatesPIVAmountAndTaxAmount() throws InterruptedException {
        pivSteps.clickOnaButton("Allocate to Jobs/ Consol");
        pivSteps.enterJobNumber(GlobalVariables.getJobNumber());
        pivSteps.updatedPIVAmountAndTaxAmount();
    }

    @And("modifies Supplier Tax Amount for a Charge")
    public void modifiesSupplierTaxAmountForACharge() throws InterruptedException {
        pivSteps.modifySupplierTaxAmountForACharge();
    }
}
