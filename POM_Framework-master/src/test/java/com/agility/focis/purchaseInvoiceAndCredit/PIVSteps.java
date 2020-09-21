package com.agility.focis.purchaseInvoiceAndCredit;

import com.agility.focis.financial.FinancialSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class PIVSteps extends FinancialSteps {
    private WebDriver driver;
    PIVPage pivPage;

    public PIVSteps() throws IOException {
        this.driver = getDriver();
        pivPage = new PIVPage(this.driver);

    }

    public void selectEntityCode(String entityCode) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(pivPage.legalEntitySearchButton);
        pivPage.legalEntitySearchButton.click();
        SeleniumUtils.waitForPageLoad();
        pivPage.entityCodeSearchBox.sendKeys(entityCode);
        Thread.sleep(1000);
        pivPage.entityCodeSearchBox.sendKeys(Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        HyperLinkUtils.clickOnLink(entityCode);
        GlobalVariables.setEntityName(pivPage.entityName.getAttribute("value"));
        GlobalVariables.setEntityCode(entityCode);
    }

    public void selectOrgComponent(String OrgComponent) throws InterruptedException {
        Select orgComponentDropDown = new Select(pivPage.orgComponent);
        orgComponentDropDown.selectByVisibleText(OrgComponent);


        if (GlobalVariables.getEntityCode().equalsIgnoreCase("5910")) {
            pivPage.placeOfSupplySearchButton.click();
            DynamicTableUtils.typeTextOnSearchPickerPopup("DataCode", "AP");
            Thread.sleep(1000);
            HyperLinkUtils.clickOnLink("AP");
        }
    }

    public void selectSupplier(String supplierName) throws InterruptedException {
        pivPage.supplierNameSearchButton.click();
        searchForSTK(supplierName);
    }

    public void enterInvoiceNumber(String invoiceNumber) throws InterruptedException {
        GlobalVariables.setSuppierinvoiceNum(invoiceNumber);
        SeleniumUtils.waitForElementToBeClickable(pivPage.invoiceNum);
        pivPage.invoiceNum.sendKeys(invoiceNumber);
    }

    public void selectInvoiceType(String invoiceType) {
        Select invoiceTypeDropDown = new Select(pivPage.invoiceType);
        invoiceTypeDropDown.selectByVisibleText(invoiceType);
    }

    public void selectInvoiceSubType(String invoiceSubType) {
        Select invoiceSubTypeDropDown = new Select(pivPage.invoiceSubType);
        invoiceSubTypeDropDown.selectByVisibleText(invoiceSubType);
        GlobalVariables.setInvoiceSubType(invoiceSubType);
    }

    public void selectInvoiceDate(String supplierInvoiceDate) throws InterruptedException {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int currentDay = calendar.get(Calendar.DATE);
        pivPage.invoiceDateButton.click();
        String pivDate = pivPage.pivDate.getText().split("-")[0];

        if (!(supplierInvoiceDate.equalsIgnoreCase("Today") || supplierInvoiceDate.equalsIgnoreCase("Current Date"))) {
            int intNoOfDays = Integer.parseInt(supplierInvoiceDate.split(" ")[2]);
            String sign = supplierInvoiceDate.split(" ")[1];
            if (sign.equalsIgnoreCase("-") && intNoOfDays > currentDay) {
                pivPage.prevMonth.click();
                SeleniumUtils.waitForPageLoad();
                int IntSupplierInvoiceDate = Integer.parseInt(supplierInvoiceDate.split("-")[1].replaceAll(" ", ""));
                String pivDateToSelect = String.valueOf(Integer.parseInt(pivDate) - IntSupplierInvoiceDate + 30);
                pivPage.supplierInvoiceDate(pivDateToSelect).click();
            } else if (sign.equalsIgnoreCase("+") && intNoOfDays > (30 - currentDay)) {
                pivPage.nextMonth.click();
                SeleniumUtils.waitForPageLoad();
                String pivDateToSelect = String.valueOf(Integer.parseInt(pivDate) + intNoOfDays - 30);
                pivPage.supplierInvoiceDate(pivDateToSelect).click();
            } else if (sign.equalsIgnoreCase("+")) {
                SeleniumUtils.waitForPageLoad();
                String pivDateToSelect = String.valueOf(Integer.parseInt(pivDate) + intNoOfDays);
                pivPage.supplierInvoiceDate(pivDateToSelect).click();
            } else if (sign.equalsIgnoreCase("-")) {
                SeleniumUtils.waitForPageLoad();
                String pivDateToSelect = String.valueOf(Integer.parseInt(pivDate) - intNoOfDays);
                pivPage.supplierInvoiceDate(pivDateToSelect).click();
            }

        } else {
            pivPage.currentDateAsInvoiceDate.click();
        }

    }


    public void enterPIVAmount(String pivAmount) {
        SeleniumUtils.clearText(pivPage.pivAmount);
        pivPage.pivAmount.sendKeys(pivAmount);
    }

    public void enterTaxAmount(String taxAmount) {
        if (!GlobalVariables.getInvoiceSubType().equalsIgnoreCase("Duties and Taxes")) {
            pivPage.taxAmount.click();
            SeleniumUtils.clearText(pivPage.taxAmount);
            pivPage.taxAmount.sendKeys(taxAmount);
            pivPage.taxAmount.sendKeys(Keys.TAB);
        }
    }

    public void createPIVHeader(Map<String, String> pivHeaderDetails) throws InterruptedException {
        String invoiceType = pivHeaderDetails.get("Invoice Type");
        GlobalVariables.setInvoiceType(invoiceType);
        String invoiceSubType = pivHeaderDetails.get("Invoice SubType");
        GlobalVariables.setInvoiceSubType(invoiceSubType);
        String entityCode = pivHeaderDetails.get("Entity Code");
        GlobalVariables.setEntityCode(entityCode);
        String OrgComponent;
        if (pivHeaderDetails.containsKey("Org Component")) {
            OrgComponent = pivHeaderDetails.get("Org Component");
        } else {
            if (GlobalVariables.getJobScope().contains("Destination")) {
                OrgComponent = GlobalVariables.getDestinationOrgComponent();

            } else {
                OrgComponent = GlobalVariables.getOriginOrgComponent();

            }
        }

        String supplierName = pivHeaderDetails.get("Supplier Name");
        GlobalVariables.setSupplierName(supplierName);
        String supplierInvoiceDate = pivHeaderDetails.get("Supplier Invoice Date");
        String pivAmount = pivHeaderDetails.get("PIV Amount");
        String taxAmount = pivHeaderDetails.get("Tax Amount");
        String currency = pivHeaderDetails.get("Currency");

        if (!driver.getCurrentUrl().contains("managepivfrpg")) {
            try {

                SeleniumUtils.waitForElementToBeClickable(pivPage.createNewPIVButton);
                pivPage.createNewPIVButton.click();

            } catch (Exception e) {

                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", pivPage.createNewPIVButton);

            }

        }

        selectEntityCode(entityCode);

        selectOrgComponent(OrgComponent);

        selectSupplier(supplierName);

        enterInvoiceNumber(SeleniumUtils.getCurrentTimeStampAsStrng());

        selectInvoiceType(invoiceType);

        selectInvoiceSubType(invoiceSubType);

        selectInvoiceDate(supplierInvoiceDate);

        enterPIVAmount(pivAmount);

        enterTaxAmount(taxAmount);

        selectInvoiceCurrency(currency);

        pivPage.createPIVButton.click();
        SeleniumUtils.waitForPageLoad();

    }

    public void selectInvoiceCurrency(String currency) throws InterruptedException {
        pivPage.currencyButton.click();
        selectCurrency(currency);
        SeleniumUtils.waitForPageLoad();
    }

    public void verifyPIVHeader(Map<String, String> pivHeaderDetails) {
        String invoiceType = pivHeaderDetails.get("Invoice Type");
        String invoiceSubType = pivHeaderDetails.get("Invoice SubType");
        String entityCode = pivHeaderDetails.get("Entity Code");
        String OrgComponent;
        if (pivHeaderDetails.containsKey("Org Component")) {
            OrgComponent = pivHeaderDetails.get("Org Component");
        } else {
            if (GlobalVariables.getJobScope().contains("Destination")) {
                OrgComponent = GlobalVariables.getDestinationOrgComponent();

            } else {
                OrgComponent = GlobalVariables.getOriginOrgComponent();

            }
        }
        String supplierName = pivHeaderDetails.get("Supplier Name");
        String supplierInvoiceDate = pivHeaderDetails.get("Supplier Invoice Date");
        String invoiceDate = SeleniumUtils.getEffectiveDateAfterDays(0);
        if (!(supplierInvoiceDate.equalsIgnoreCase("Today") || supplierInvoiceDate.equalsIgnoreCase("Current Date"))) {
            int intNoOfDays = Integer.parseInt(supplierInvoiceDate.split(" ")[2]);
            String sign = supplierInvoiceDate.split(" ")[1];
            if (sign.equalsIgnoreCase("+")) {
                invoiceDate = SeleniumUtils.getEffectiveDateAfterDays(intNoOfDays);
            } else {
                invoiceDate = SeleniumUtils.getEffectiveDateBeforeDays(intNoOfDays);
            }
        }

        String pivAmount = pivHeaderDetails.get("PIV Amount");
        String taxAmount = pivHeaderDetails.get("Tax Amount");
        String currency = pivHeaderDetails.get("Currency");
        Select orgComp = new Select(pivPage.orgComponent);
        if (!pivPage.entityName.getAttribute("value").equalsIgnoreCase(GlobalVariables.getEntityName())) {
            SeleniumUtils.logInfo("\nEntity Name:\nExpected :" + GlobalVariables.getEntityName() + "\nActual :" + pivPage.entityName.getAttribute("value"));
        }
        if (!orgComp.getFirstSelectedOption().getText().equalsIgnoreCase(OrgComponent)) {
            SeleniumUtils.logInfo("\nOrg Components :\nExpected :" + OrgComponent + "\nActual :" + orgComp.getFirstSelectedOption().getText());
        }
        if (!supplierName.equalsIgnoreCase(pivPage.supplier.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nSupplier Name :\nExpected :" + supplierName + "\nActual :" + pivPage.supplier.getAttribute("value"));
        }
        if (!GlobalVariables.getSuppierinvoiceNum().equalsIgnoreCase(pivPage.invoiceNum.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nSupplier Invoice Number :\nExpected :" + GlobalVariables.getSuppierinvoiceNum() + "\nActual :" + pivPage.invoiceNum.getAttribute("value"));
        }
        if (!invoiceDate.equalsIgnoreCase(pivPage.invoiceDate.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nSupplier Invoice Date :\nExpected :" + invoiceDate + "\nActual :" + pivPage.invoiceDate.getAttribute("value"));
        }
        if (!pivPage.pivDate.getText().equalsIgnoreCase(SeleniumUtils.getEffectiveDateAfterDays(0))) {
            SeleniumUtils.logInfo("\nPIV Date :\nExpected :" + SeleniumUtils.getEffectiveDateAfterDays(0) + "\nActual :" + pivPage.pivDate.getText());
        }
        Select pivDropDown = new Select(pivPage.invoiceType);
        if (!invoiceType.equalsIgnoreCase(pivDropDown.getFirstSelectedOption().getText())) {
            SeleniumUtils.logInfo("\nPIV Type :\nExpected :" + invoiceType + "\nActual :" + pivDropDown.getFirstSelectedOption().getText());
        }
        Select pivSubTypeDropDown = new Select(pivPage.invoiceSubType);
        if (!invoiceSubType.equalsIgnoreCase(pivSubTypeDropDown.getFirstSelectedOption().getText())) {
            SeleniumUtils.logInfo("\nInvoice Sub Type :\nExpected :" + invoiceSubType + "\nActual :" + pivSubTypeDropDown.getFirstSelectedOption().getText());
        }
        if (!String.format("%.2f", Double.parseDouble(pivAmount)).equalsIgnoreCase(pivPage.pivAmount.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nPIV Amount :\nExpected :" + String.format("%.2f", Double.parseDouble(pivAmount)) + "\nActual :" + pivPage.pivAmount.getAttribute("value"));
        }
        if (!String.format("%.2f", Double.parseDouble(taxAmount)).equalsIgnoreCase(pivPage.taxAmount.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nTax Amount :\nExpected :" + String.format("%.2f", Double.parseDouble(taxAmount)) + "\nActual :" + pivPage.taxAmount.getAttribute("value"));
        }
        if (!currency.equalsIgnoreCase(pivPage.pivCurrencyTetBox.getAttribute("value"))) {
            SeleniumUtils.logInfo("\nCurrency Code :\nExpected :" + currency + "\nActual :" + pivPage.pivCurrencyTetBox.getAttribute("value"));
        }
        String totalAmount = String.format("%.2f", Double.parseDouble(pivAmount) + Double.parseDouble(taxAmount));

        if (!totalAmount.equalsIgnoreCase(pivPage.totalAmount.getText())) {
            SeleniumUtils.logInfo("\nTotal Amount:\nExpected :" + totalAmount + "\nActual :" + pivPage.totalAmount.getText());
        }

    }

    public void verifySupplierInvoiceNumber() throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        if (!pivPage.supplierInvoiceNumAllocatePage.getText().equalsIgnoreCase(GlobalVariables.getSuppierinvoiceNum())) {

            SeleniumUtils.logInfo("\nSupplier Invoice Number\nExpected :" + GlobalVariables.getSuppierinvoiceNum() + "\n Actual :" + pivPage.supplierInvoiceNumAllocatePage.getText());
        }


    }

    public void verifySupplierName() {
        if (!SpanUtils.getText("Supplier Name").equalsIgnoreCase(GlobalVariables.getSupplierName())) {

            SeleniumUtils.logInfo("Supplier Name is not matched Expected is :" + GlobalVariables.getSupplierName() + "\n Actual is :" + SpanUtils.getText("Supplier Name"));
        }
    }

    public void processPIV(String jobNumber, String pivType) throws InterruptedException {
        pivPage.allocateToJobsORConsolButton.click();
        SeleniumUtils.waitForPageLoad();
        pivPage.jobNumberOrConsolNumberInput.sendKeys(jobNumber + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();

        updatedPIVAmountAndTaxAmount();

        pivPage.allocateToJobsORConsolButton.click();
        SeleniumUtils.waitForPageLoad();
        pivPage.jobNumberOrConsolNumberInput.sendKeys(jobNumber + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        selectCharges();
        pivPage.allocateButton.click();
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(pivPage.completeInvoiceButton);
        pivPage.completeInvoiceButton.click();
        SeleniumUtils.waitForPageLoad();
        searchForPurchaseInvoice(GlobalVariables.getSupplierName(), GlobalVariables.getInvoiceType(), GlobalVariables.getInvoiceSubType(), GlobalVariables.getSuppierinvoiceNum(), GlobalVariables.getEntityCode());
        String pivNumber = pivPage.generatedPIVNumber(GlobalVariables.getSuppierinvoiceNum()).getText();
        String supplierName = pivPage.generatedPIVSupplierName(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivTotalAmount = pivPage.generatedPIVTotalAmount(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivDate = pivPage.generatedPIVDate(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivDueDate = pivPage.generatedPIVDueDate(GlobalVariables.getSuppierinvoiceNum()).getText();
        String pivStatus = pivPage.generatedPIVStatus(GlobalVariables.getSuppierinvoiceNum()).getText();
        SeleniumUtils.logInfo("PIV Number is: " + pivNumber + "\nSupplier Invoice Number: " + GlobalVariables.getSuppierinvoiceNum() + "\nPIV Total Amount: " + pivTotalAmount
                + "\nPIV Date: " + pivDate + "\nPIV Due Date: " + pivDueDate + "\nSupplier Name: " + supplierName + "\nStatus: " + pivStatus);
    }

    public void updatedPIVAmountAndTaxAmount() throws InterruptedException {
        String PIVAmount = "0.00";
        String taxAmount = "0.00";
        if (GlobalVariables.getInvoiceType().equalsIgnoreCase("Purchase Invoice")) {
            PIVAmount = getAmountsFromChargesToBeAllocated("Positive").get("Net PIV Amount");
            taxAmount = getAmountsFromChargesToBeAllocated("Positive").get("Tax Amount");
        } else {
            PIVAmount = getAmountsFromChargesToBeAllocated("Negative").get("Net PIV Amount");
            taxAmount = getAmountsFromChargesToBeAllocated("Negative").get("Tax Amount");
        }
        pivPage.closeDialogButton("Allocate Jobs for Supplier Invoice number : ").click();
        SeleniumUtils.clearText(pivPage.pivAmount);
        pivPage.pivAmount.sendKeys(PIVAmount);
        SeleniumUtils.clearText(pivPage.taxAmount);
        pivPage.taxAmount.sendKeys(taxAmount);
        pivPage.savePIVButton.click();
        SeleniumUtils.waitForPageLoad();

    }

    public Map<String, Map<String, String>> getAmountInfoTable() {
        Map<String, String> amountInfoRows = new HashMap<>();
        Map<String, Map<String, String>> amountInfo = new HashMap<>();
        List<WebElement> rows = pivPage.amountInfoTable.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
        for (WebElement row : rows) {
            String rowLabel = row.findElement(By.xpath(".//td[contains(@aria-describedby,'Label')]")).getText();
            amountInfoRows.put("PIV Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'PIVAmount')]")).getText());
            amountInfoRows.put("Tax Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'TaxAmount')]")).getText());
            amountInfoRows.put("Total Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'TotalAmount')]")).getText());
            amountInfoRows.put("Currency", row.findElement(By.xpath(".//td[contains(@aria-describedby,'Currency')]")).getText());
            amountInfo.put(rowLabel, amountInfoRows);
        }

        return amountInfo;
    }

    public Map<String, Map<String, String>> getAmountInfoAllocateTable() throws InterruptedException {
        Map<String, Map<String, String>> amountInfo = new HashMap<>();
        List<WebElement> rows;
        if (isDialogPopulated("Allocate Jobs for Supplier Invoice number : ")) {
            rows = pivPage.amountInfoTableAllocateJobs.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
        } else {
            rows = pivPage.amountInfoTable.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
        }
        for (WebElement row : rows) {
            Map<String, String> amountInfoRows = new HashMap<>();
            String rowLabel = row.findElement(By.xpath(".//td[contains(@aria-describedby,'Label')]")).getAttribute("title");
            amountInfoRows.put("PIV Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'PIVAmount')]")).getText());
            amountInfoRows.put("Tax Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'TaxAmount')]")).getText());
            amountInfoRows.put("Total Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'TotalAmount')]")).getText());
            amountInfoRows.put("Currency", row.findElement(By.xpath(".//td[contains(@aria-describedby,'Currency')]")).getText());
            amountInfo.put(rowLabel, amountInfoRows);
        }

        return amountInfo;
    }

    public Map<String, String> getAmountsFromChargesToBeAllocated(String typeOfCharges) {
        Map<String, String> amounts = new HashMap<>();
        double cost = 0.00;
        double pivAmount = 0.00;
        double taxAmount = 0.00;
        double supplierTaxAmount = 0.00;
        double totalAmount = 0.00;
        List<WebElement> charges = getPositiveOrNegativeCharges(typeOfCharges);
        for (WebElement charge : charges) {
            cost = cost + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_AmountB')]")).getText().replaceAll(",", ""));
            pivAmount = pivAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_NetAmountB')]")).getText().replaceAll(",", ""));
            taxAmount = taxAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_VatAmountB')]")).getText().replaceAll(",", ""));
            supplierTaxAmount = supplierTaxAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value").replaceAll(",", ""));
            totalAmount = totalAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'_FinalNetAmountB')]")).getText().replaceAll(",", "")
            );
        }
//        Put all amounts to map
        amounts.put("Cost", String.format("%.2f", cost));
        amounts.put("Net PIV Amount", String.format("%.2f", pivAmount));
        amounts.put("Tax Amount", String.format("%.2f", taxAmount));
        amounts.put("Supplier Tax Amount", String.format("%.2f", supplierTaxAmount));
        amounts.put("Total Amount", String.format("%.2f", totalAmount));

        return amounts;
    }


    public Map<String, String> getAmountsFromAllocatedChargesTable() throws InterruptedException {
        Map<String, String> amounts = new HashMap<>();
        double cost = 0.00;
        double pivAmount = 0.00;
        double taxAmount = 0.00;
        double supplierTaxAmount = 0.00;
        double totalAmount = 0.00;
        List<WebElement> charges = getCharges();
        for (WebElement charge : charges) {
            cost = cost + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_AmountB')]")).getText().replaceAll(",", ""));
            pivAmount = pivAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_NetAmountB')]")).getText().replaceAll(",", ""));
            taxAmount = taxAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_VatAmountB')]")).getText().replaceAll(",", ""));
            supplierTaxAmount = supplierTaxAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value").replaceAll(",", ""));
            totalAmount = totalAmount + Double.parseDouble(charge.findElement(By.xpath(".//td[contains(@aria-describedby,'_FinalNetAmountB')]")).getText().replaceAll(",", "")
            );
        }
//        Put all amounts to map
        amounts.put("Cost", String.format("%.2f", cost));
        amounts.put("Net PIV Amount", String.format("%.2f", pivAmount));
        amounts.put("Tax Amount", String.format("%.2f", taxAmount));
        amounts.put("Supplier Tax Amount", String.format("%.2f", supplierTaxAmount));
        amounts.put("Total Amount", String.format("%.2f", totalAmount));

        return amounts;
    }

    public List<WebElement> getPositiveOrNegativeCharges(String typeOfCharges) {
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        List<WebElement> positiveCharges = new ArrayList<>();
        List<WebElement> negativeCharges = new ArrayList<>();
        List<WebElement> listToReturn = new ArrayList<>();
        for (WebElement job : jobs) {
            List<WebElement> charges = job.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));

            for (WebElement charge : charges) {
                if (charge.findElement(By.xpath("./td[contains(@aria-describedby,'t_AmountB')]")).getText().contains("-")) {
                    negativeCharges.add(charge);
                } else {
                    positiveCharges.add(charge);
                }

            }

        }
        if (typeOfCharges.equalsIgnoreCase("Positive")) {
            listToReturn = positiveCharges;
        } else {
            listToReturn = negativeCharges;
        }
        return listToReturn;
    }

    public void searchForPurchaseInvoice(String supplierName, String pivType, String pivSubType, String supplierInvoiceNumber, String entityCode) throws InterruptedException {
        expandPanel("Search Companion");
//        pivPage.supplierNameSearchButton.click();
//        SeleniumUtils.waitForPageLoad();
//        searchForSTK(supplierName);
        SeleniumUtils.clearText(pivPage.supplierInvoiceNumberSearchCompanion);
        pivPage.supplierInvoiceNumberSearchCompanion.sendKeys(supplierInvoiceNumber);
        if (!pivType.equalsIgnoreCase("")) {
            Select pivTypeDropDown = new Select(pivPage.pivTypeSearchCompanion);
            pivTypeDropDown.selectByVisibleText(pivType);
        }
        if (!pivSubType.equalsIgnoreCase("")) {
            Select pivSubTypeDropDown = new Select(pivPage.pivSubtypeSearchCompanion);
            pivSubTypeDropDown.selectByVisibleText(pivSubType);
        }
        if (!entityCode.equalsIgnoreCase("")) {
            pivPage.legalEntitySearchButton.click();
            SeleniumUtils.waitForPageLoad();
            pivPage.entityCodeSearchBox.sendKeys(entityCode);
            Thread.sleep(1000);
            pivPage.entityCodeSearchBox.sendKeys(Keys.ENTER);
            SeleniumUtils.waitForPageLoad();
            HyperLinkUtils.clickOnLink(entityCode);
            SeleniumUtils.waitForPageLoad();
        }

        pivPage.searchButtonManagePIV.click();
        SeleniumUtils.waitForPageLoad();

    }

    public void clickOnCreateNewPIVIcon() throws InterruptedException {
        pivPage.createNewPIVButton.click();
        SeleniumUtils.waitForPageLoad();
    }

    public void verifyInvoiceStatus(String invoiceStatus) {
        if (!invoiceStatus.equalsIgnoreCase(pivPage.invoiceStatus.getText().trim())) {
            SeleniumUtils.logInfo("\nInvoice Status Populated Incorrectly\nExpected :" + invoiceStatus + "\nActual :" + pivPage.invoiceStatus.getText());
        }
    }

    public void verifyStateAndPlaceOfSupplyArePopulated() {
        Assert.assertFalse(pivPage.orgStateComponent.getAttribute("style").contains("none"));
        Assert.assertFalse(pivPage.placeOfSupplyDiv.getAttribute("style").contains("none"));
        SeleniumUtils.takeScreenshot();
    }

    public void verifyBankReferenceStatus(String enabledStatus) {
        if (enabledStatus.equalsIgnoreCase("Enabled")) {
            Assert.assertTrue(pivPage.bankReference.isEnabled());
        } else {
            Assert.assertFalse(pivPage.bankReference.isEnabled());
        }
        SeleniumUtils.takeScreenshot();
    }

    public void verifypivDueDate(String stepDefPiVDueDate) {
        int intNoOfDays = Integer.parseInt(stepDefPiVDueDate.split(" ")[2]);
        String pivDueDate = SeleniumUtils.getEffectiveDateAfterDays(intNoOfDays);
        Assert.assertTrue("Expected :" + pivDueDate + "\nActual :" + pivPage.pivDueDate.getText(), pivDueDate.equalsIgnoreCase(pivPage.pivDueDate.getText()));
        SeleniumUtils.takeScreenshot();
    }

    public void verifyTaxAmountStatus(String enabledStatus) {
        if (enabledStatus.equalsIgnoreCase("Enabled")) {
            Assert.assertTrue(pivPage.taxAmount.isEnabled());
        } else {
            Assert.assertFalse(pivPage.taxAmount.isEnabled());
        }
        SeleniumUtils.takeScreenshot();
    }

    public void verifyTotalAmount(String totalAmount) {
        Assert.assertTrue("Expected :" + String.format("%.2f", Double.parseDouble(totalAmount)) + "\nActual :" + pivPage.totalAmount.getText(), String.format("%.2f", Double.parseDouble(totalAmount)).equalsIgnoreCase(pivPage.totalAmount.getText()));
        SeleniumUtils.takeScreenshot();
    }

    public void verifySupplierAddress() {
        String expected = GlobalVariables.getSupplierAddress().replace(GlobalVariables.getSupplierAddress().split("\n")[0], "").replaceAll("\n", "").replaceAll(" ", "");
        String actual = pivPage.supplierAddress.getText().replaceAll("\n", "").replaceAll(" ", "");
        Assert.assertTrue(expected.equalsIgnoreCase(actual));
    }

    public void selectTaxAtHeader() {
        pivPage.taxAtHeader.click();
    }

    public void verifyPIVAmountStatus(String enabledStatus) {
        if (enabledStatus.equalsIgnoreCase("Enabled")) {
            Assert.assertTrue(pivPage.pivAmount.isEnabled());
        } else {
            Assert.assertFalse(pivPage.pivAmount.isEnabled());
        }
        SeleniumUtils.takeScreenshot();
    }

    public void verifyCurrencyInAmountInfoTable(String currency) {
        Assert.assertTrue(getAmountInfoTable().get("Header Amount").get("Currency").equalsIgnoreCase(currency));
        Assert.assertTrue(getAmountInfoTable().get("Allocated Amount").get("Currency").equalsIgnoreCase(currency));
        Assert.assertTrue(getAmountInfoTable().get("To be Allocated Amount").get("Currency").equalsIgnoreCase(currency));
        SeleniumUtils.takeScreenshot();
    }

    public void verifyRowDataAmountInfoTable(String row, String PIVAmount, String TaxAmount, String TotalAmount, String Currency) {
        Assert.assertTrue(getAmountInfoTable().get(row).get("PIV Amount").equalsIgnoreCase(PIVAmount));
        Assert.assertTrue(getAmountInfoTable().get(row).get("Tax Amount").equalsIgnoreCase(TaxAmount));
        Assert.assertTrue(getAmountInfoTable().get(row).get("Total Amount").equalsIgnoreCase(TotalAmount));
        Assert.assertTrue(getAmountInfoTable().get(row).get("Currency").equalsIgnoreCase(Currency));
        SeleniumUtils.takeScreenshot();
    }

    public void verifyRowDataAmountInfoTableAllocatePage(String row, String PIVAmount, String TaxAmount, String Currency) throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        if (PIVAmount.contains("Sum")) {
            PIVAmount = getSumOfPIVAmountsOfSelectedChargesAsString();
            TaxAmount = getSumOfTaxAmountsOfSelectedChargesAsString();
        } else if (PIVAmount.contains("-") || PIVAmount.contains("Difference")) {
            String headerPIVAmount = getAmountInfoAllocateTable().get("Header Amount").get("PIV Amount");
            String allocatedPIVAmount = getSumOfPIVAmountsOfSelectedChargesAsString();
            PIVAmount = String.format("%.2f", Double.parseDouble(headerPIVAmount) - Double.parseDouble(allocatedPIVAmount));
            String headerTaxAmount = getAmountInfoAllocateTable().get("Header Amount").get("Tax Amount");
            String allocatedTaxAmount = getSumOfTaxAmountsOfSelectedChargesAsString();
            TaxAmount = String.format("%.2f", Double.parseDouble(headerTaxAmount) - Double.parseDouble(allocatedTaxAmount));
        }

        String TotalAmount = String.format("%.2f", Double.parseDouble(PIVAmount) + Double.parseDouble(TaxAmount));

        Assert.assertTrue("PIV Amount Expected :" + Double.parseDouble(PIVAmount) + "\nActual ;" + getAmountInfoAllocateTable().get(row).get("PIV Amount"), getAmountInfoAllocateTable().get(row).get("PIV Amount").equalsIgnoreCase(String.format("%.2f", Double.parseDouble(PIVAmount))));
        Assert.assertTrue("Tax Amount Expected :" + Double.parseDouble(TaxAmount) + "\nActual :" + getAmountInfoAllocateTable().get(row).get("Tax Amount"), getAmountInfoAllocateTable().get(row).get("Tax Amount").equalsIgnoreCase(String.format("%.2f", Double.parseDouble(TaxAmount))));
        Assert.assertTrue("Total Amount Expected :" + Double.parseDouble(TotalAmount) + "\nActual :" + getAmountInfoAllocateTable().get(row).get("Total Amount"), getAmountInfoAllocateTable().get(row).get("Total Amount").equalsIgnoreCase(String.format("%.2f", Double.parseDouble(TotalAmount))));
        Assert.assertTrue("Currency Expected :" + Currency + "\nActual :" + getAmountInfoAllocateTable().get(row).get("Currency"), getAmountInfoAllocateTable().get(row).get("Currency").equalsIgnoreCase(Currency));
        SeleniumUtils.takeScreenshot();
    }

    private String getSumOfTaxAmountsOfSelectedChargesAsString() {
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        double sumofTaxAmounts = 0.00;
        for (WebElement job : jobs) {
            List<WebElement> selectedCharges = job.findElements(By.xpath(".//tr[not(@class='jqgfirstrow') and @aria-selected = 'true']"));

            for (WebElement charge : selectedCharges) {
                sumofTaxAmounts = sumofTaxAmounts + Double.parseDouble(charge.findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value"));
            }

        }
        return String.format("%.2f", sumofTaxAmounts);
    }

    private String getSumOfPIVAmountsOfSelectedChargesAsString() {
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        double sumofPIVAmounts = 0.00;
        for (WebElement job : jobs) {
            List<WebElement> selectedCharges = job.findElements(By.xpath(".//tr[not(@class='jqgfirstrow') and @aria-selected = 'true']"));

            for (WebElement charge : selectedCharges) {
                sumofPIVAmounts = sumofPIVAmounts + Double.parseDouble(charge.findElement(By.xpath("./td[contains(@aria-describedby,'t_NetAmountB')]")).getText());
            }

        }
        return String.format("%.2f", sumofPIVAmounts);
    }


    public void verifyListedChargesforSupplier(String supplier) {
        Map<String, String> expected = getChargesOfASupplier(supplier);
        Map<String, String> actual = getListOfCharges();
        Assert.assertEquals(expected, actual);


    }

    public Map<String, String> getListOfCharges() {
        Map<String, String> mapToReturn = new HashMap<>();
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        for (WebElement job : jobs) {
            List<WebElement> charges = job.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));

            for (WebElement charge : charges) {
                String chargeName = charge.findElement(By.xpath("./td[contains(@aria-describedby,'ChargeName')]")).getText();
                String cost = charge.findElement(By.xpath("./td[contains(@aria-describedby,'t_AmountQ')]")).getText();
                mapToReturn.put(chargeName, cost);
            }

        }
        return mapToReturn;
    }

    public void enterJobNumber(String jobNumber) throws InterruptedException {
        pivPage.jobNumberOrConsolNumberInput.sendKeys(jobNumber + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
    }

    public void verifyTaggedJobDetails(String jobNumber, String originSTKName, String destinationSTKName, String jobStatus) {
        String jobNumberActual = pivPage.jobsListAllocateJobs.findElement(By.xpath(".//td[contains(@aria-describedby,'grdTagJobsLs_OpJobNumber')]")).getText();
        String shipperActual = pivPage.jobsListAllocateJobs.findElement(By.xpath(".//td[contains(@aria-describedby,'grdTagJobsLs_Shipper')]")).getText();
        String consigneeActual = pivPage.jobsListAllocateJobs.findElement(By.xpath(".//td[contains(@aria-describedby,'grdTagJobsLs_Consignee')]")).getText();
        String finStatus = pivPage.jobsListAllocateJobs.findElement(By.xpath(".//td[contains(@aria-describedby,'grdTagJobsLs_JobFinStatus')]")).getText();
        Assert.assertTrue("Job Number Expected :" + jobNumber + "\nActual :" + jobNumberActual, jobNumber.equalsIgnoreCase(jobNumberActual));
        Assert.assertTrue("Shipper Expected :" + originSTKName + "\nActual :" + shipperActual, originSTKName.equalsIgnoreCase(shipperActual));
        Assert.assertTrue("Consignee Expected :" + destinationSTKName + "\nActual :" + consigneeActual, destinationSTKName.equalsIgnoreCase(consigneeActual));
        Assert.assertTrue("Financial Status Expected :" + jobStatus + "\nActual :" + finStatus, jobStatus.equalsIgnoreCase(finStatus));
    }

    public void selectCharges() {
        List<WebElement> chargesToSelect;
        if (GlobalVariables.getInvoiceType().equalsIgnoreCase("Purchase Invoice")) {
            chargesToSelect = getPositiveOrNegativeCharges("Positive");
        } else {
            chargesToSelect = getPositiveOrNegativeCharges("Negative");
        }
        for (WebElement charge : chargesToSelect) {
            if (charge.getAttribute("aria-selected").equalsIgnoreCase("false")) {
                charge.findElement(By.xpath(".//input[@role='checkbox']")).click();
            }
        }
    }

    public void modifyTaxCodeForACharge() throws InterruptedException {
        List<WebElement> charges = getCharges();
        int randomNum = ThreadLocalRandom.current().nextInt(0, charges.size() - 1);
        String pivAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_NetAmountB')]")).getText();
        String taxAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value");
        String taxRate = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatRatePer')]")).getText();
        String taxCode = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatCode')]//input")).getAttribute("value");
        String totalAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_FinalNetAmountB')]")).getText();
        String chargeName = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_ChargeName')]")).getText();
        charges.get(randomNum).findElement(By.xpath(".//input[@role='checkbox']")).click();
        charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatCode')]//button")).click();
        SeleniumUtils.waitForPageLoad();
        List<WebElement> taxCodes = driver.findElements(By.xpath("//td[@aria-describedby='grdTaxCodeData_VatRate' and not(@title='" + taxRate.replace("%", "") + "')]/..//a"));
        int randomTaxCodeIndex = ThreadLocalRandom.current().nextInt(0, taxCodes.size() - 1);
        taxCodes.get(randomTaxCodeIndex).click();
        SeleniumUtils.waitForPageLoad();
        String modifiedTaxCode = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatCode')]//input")).getAttribute("value");
        String modifiedTaxRate = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatRatePer')]")).getText();
        Map<String, String> chargeDetails = new HashMap<>();
        chargeDetails.put("index", String.valueOf(randomNum));
        chargeDetails.put("pivAmount", pivAmount);
        chargeDetails.put("taxAmount", taxAmount);
        chargeDetails.put("taxRate", taxRate);
        chargeDetails.put("taxCode", taxCode);
        chargeDetails.put("modifiedTaxCode", modifiedTaxCode);
        chargeDetails.put("modifiedTaxRate", modifiedTaxRate);
        chargeDetails.put("totalAmount", totalAmount);
        GlobalVariables.setRandomChargeDetails(chargeDetails);
        SeleniumUtils.logInfo("Charge Name :" + chargeName);
        SeleniumUtils.logInfo("\nTax Code is :" + taxCode);
        SeleniumUtils.logInfo("\nModified Tax Code is :" + modifiedTaxCode);
        SeleniumUtils.takeScreenshot();

    }

    public void verifyAmountsOfTaxModifiedCharge() throws InterruptedException {
        List<WebElement> charges = getCharges();
        Map<String, String> chargeDetails = GlobalVariables.getRandomChargeDetails();
        int chargeIndex = Integer.parseInt(chargeDetails.get("index"));
        double pivAmountOld = Double.parseDouble(chargeDetails.get("pivAmount"));
        int taxRateOld = Integer.parseInt(chargeDetails.get("modifiedTaxRate").replace("%", ""));
        String taxCodeOld = chargeDetails.get("modifiedTaxCode");
        double expTaxAmount = (pivAmountOld * taxRateOld) / 100;
        double expTotalAmount = pivAmountOld + expTaxAmount;
//        String strExpTotalAmount = String.format("%.2f", expTotalAmount);

        String pivAmount = charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_NetAmountB')]")).getText();
        String taxAmount = charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value");
        String taxRate = charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatRatePer')]")).getText();
        String taxCode = charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_VatCode')]//input")).getAttribute("value");
        String totalAmount = charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_FinalNetAmountB')]")).getText();

        Assert.assertTrue("PIV Amount Expected :" + String.format("%.2f", pivAmountOld) + "\nActual :" + pivAmount, pivAmount.equalsIgnoreCase(String.format("%.2f", pivAmountOld)));
        Assert.assertTrue("Tax Amount Expected :" + String.format("%.2f", expTaxAmount) + "\nActual :" + taxAmount, taxAmount.equalsIgnoreCase(String.format("%.2f", expTaxAmount)));
        Assert.assertTrue("Total Amount Expected :" + String.format("%.2f", expTotalAmount) + "\nActual :" + totalAmount, totalAmount.equalsIgnoreCase(String.format("%.2f", expTotalAmount)));
        Assert.assertTrue("Tax Rate Expected :" + String.valueOf(taxRateOld) + "\nActual :" + taxRate, taxRate.equalsIgnoreCase(String.valueOf(taxRateOld) + "%"));
        Assert.assertTrue("Total Code Expected :" + taxCodeOld + "\nActual :" + taxCode, taxCodeOld.equalsIgnoreCase(taxCode));
    }

    public void modifySupplierTaxAmountForACharge() throws InterruptedException {
        List<WebElement> jobs;
        if (isDialogPopulated("Allocate Jobs for Supplier Invoice number : ")) {
            jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        } else {
            jobs = pivPage.jobsList.findElements(By.xpath(".//table[contains(@id,'grdSavedPIVDetails')]"));
        }

        List<WebElement> NonZeroTaxRatedCharges = jobs.get(0).findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]//td[contains(@aria-describedby,'t_VatRatePer') and not(@title='0%')]/ancestor::tr[1]"));
        int randomNum = 0;
        if (NonZeroTaxRatedCharges.size() > 1) {
            randomNum = ThreadLocalRandom.current().nextInt(0, NonZeroTaxRatedCharges.size() - 1);
        }
        String pivAmount = NonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_NetAmountB')]")).getText();
        String chargeName = NonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_ChargeName')]")).getText();
        String supplierTaxAmount = NonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value");
        double randomSupplierTaxAmt;
        if (supplierTaxAmount.contains("-")) {
            randomSupplierTaxAmt = ThreadLocalRandom.current().nextDouble(Double.parseDouble(supplierTaxAmount), 0.00);
        } else {
            randomSupplierTaxAmt = ThreadLocalRandom.current().nextDouble(0.00, Double.parseDouble(supplierTaxAmount));
        }

        SeleniumUtils.clearText(NonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")));
        NonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).sendKeys(String.format("%.2f", randomSupplierTaxAmt) + Keys.TAB);

        Assert.assertTrue("User is not able to modify Supplier Tax Amounts", NonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value").equalsIgnoreCase(String.format("%.2f", randomSupplierTaxAmt)));

        Map<String, String> chargeDetails = new HashMap<>();
        chargeDetails.put("pivAmount", pivAmount);
        chargeDetails.put("index", String.valueOf(randomNum));
        chargeDetails.put("modifiedSupplierTaxAmt", String.format("%.2f", randomSupplierTaxAmt));
        GlobalVariables.setRandomChargeDetails(chargeDetails);
        SeleniumUtils.logInfo("Charge Name : " + chargeName);
        SeleniumUtils.logInfo("\nIndex of the Charge : " + randomNum);
        SeleniumUtils.logInfo("\nSupplier Tax Amount : " + supplierTaxAmount);
        SeleniumUtils.logInfo("\nModified Supplier Tax Amount : " + String.format("%.2f", randomSupplierTaxAmt));
        SeleniumUtils.takeScreenshot();
    }

    public void verifyTotalAmountAfterModifyinSupplierTaxAmount() {
        Map<String, String> chargeDetails = GlobalVariables.getRandomChargeDetails();
        double pivAmount = Double.parseDouble(chargeDetails.get("pivAmount"));
        int chargeIndex = Integer.parseInt(chargeDetails.get("index"));
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        List<WebElement> NonZeroTaxRatedCharges = jobs.get(0).findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]//td[contains(@aria-describedby,'t_VatRatePer') and not(@title='0%')]/ancestor::tr[1]"));
        double totalAmount = Double.parseDouble(NonZeroTaxRatedCharges.get(chargeIndex).findElement(By.xpath(".//td[contains(@aria-describedby,'t_FinalNetAmountB')]")).getText());
        double expTotalAmount = pivAmount + 6.00;
        Assert.assertEquals("Total Amount Expected :" + expTotalAmount + "\nActual :" + totalAmount, expTotalAmount, totalAmount, 0.0);
    }

    public void verifytaxAmtDiffAfterSuppTaxModification() {
        Map<String, String> chargeDetails = GlobalVariables.getRandomChargeDetails();
        int chargeIndex = Integer.parseInt(chargeDetails.get("index"));
        List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
        List<WebElement> NonZeroTaxRatedCharges = jobs.get(0).findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]//td[contains(@aria-describedby,'t_VatRatePer') and not(@title='0%')]/ancestor::tr[1]"));
        double taxAmt = Double.parseDouble(NonZeroTaxRatedCharges.get(chargeIndex).findElement(By.xpath(".//td[contains(@aria-describedby,'t_VatAmountB')]")).getText());
        double supplierTaxAmt = Double.parseDouble(NonZeroTaxRatedCharges.get(chargeIndex).findElement(By.xpath(".//td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value"));
        double taxAmtDiff = Double.parseDouble(NonZeroTaxRatedCharges.get(chargeIndex).findElement(By.xpath(".//td[contains(@aria-describedby,'t_VatAmountDiffB')]")).getText());
        double expectedDiff = supplierTaxAmt - taxAmt;
        Assert.assertEquals("Total Amount Expected :" + expectedDiff + "\nActual :" + taxAmtDiff, expectedDiff, taxAmtDiff, 0.0);

    }

    public void applyWriteOffForACharge() throws InterruptedException {
        List<WebElement> charges = getCharges();
        int randomNum = ThreadLocalRandom.current().nextInt(0, charges.size() - 1);
        String pivAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_NetAmountB')]")).getText();
        String chargeName = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_ChargeName')]")).getText();
        String taxAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value");
        String totalAmount = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_FinalNetAmountB')]")).getText();
        double tobePIVedAmount = performWriteOffForGivenCharge(charges.get(randomNum));
        String taxAmountAfterWriteOff = charges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value");
        Map<String, String> chargeDetails = new HashMap<>();
        chargeDetails.put("index", String.valueOf(randomNum));
        chargeDetails.put("pivAmount", pivAmount);
        chargeDetails.put("taxAmount", taxAmount);
        chargeDetails.put("taxAmountAfterWriteOff", String.format("%.2f", Double.parseDouble(taxAmountAfterWriteOff)));
        chargeDetails.put("totalAmount", totalAmount);
        chargeDetails.put("tobePIVedAmount", String.format("%.2f", tobePIVedAmount));
        GlobalVariables.setRandomChargeDetails(chargeDetails);
        SeleniumUtils.takeScreenshot();
        SeleniumUtils.logInfo("Charge Name : " + chargeName + "\nTo be PIVed Amount : " + String.format("%.2f", tobePIVedAmount) + "\nSupplier Tax Amount After Write off : " + taxAmountAfterWriteOff);
    }

    public double performWriteOffForGivenCharge(WebElement charge) throws InterruptedException {
        charge.findElement(By.xpath(".//div[@title='Variations']//span[@class='i-icon icon-external-link']")).click();
        SeleniumUtils.waitForPageLoad();
        double cost = Double.parseDouble(pivPage.costWriteOffDialog.getAttribute("value"));
        double random = 0.00;
        if (cost > 0.00) {
            random = ThreadLocalRandom.current().nextDouble(1.00, cost);
        } else {
            random = ThreadLocalRandom.current().nextDouble(cost, -1.00);
        }
        SeleniumUtils.clearText(pivPage.tobePIVedAmount);
        pivPage.tobePIVedAmount.sendKeys(String.format("%.2f", random) + Keys.TAB);

        GlobalVariables.setWriteOffAmount(pivPage.writeOffAmount.getAttribute("value"));

        Select writeOffReasonCode = new Select(pivPage.writeOffReasonCode);
        writeOffReasonCode.selectByVisibleText("Others");
        SeleniumUtils.waitForPageLoad();
        pivPage.saveButtonWriteOff.click();
        SeleniumUtils.checkForAlertAndAccept();
        return random;

    }

    public void verifyTotalAmountAfterWriteOff() throws InterruptedException {

        List<WebElement> charges = getCharges();
        int chargeIndex = Integer.parseInt(GlobalVariables.getRandomChargeDetails().get("index"));
        double tobePIVedAmount = Double.parseDouble(GlobalVariables.getRandomChargeDetails().get("tobePIVedAmount"));
        double totalAmount = Double.parseDouble(charges.get(chargeIndex).findElement(By.xpath("./td[contains(@aria-describedby,'t_FinalNetAmountB')]")).getText());
        double taxAmountAfterWriteOff = Double.parseDouble(GlobalVariables.getRandomChargeDetails().get("taxAmountAfterWriteOff"));
        Assert.assertEquals("Total Amount Expected :" + (tobePIVedAmount + taxAmountAfterWriteOff) + "\nActual :" + totalAmount, (tobePIVedAmount + taxAmountAfterWriteOff), totalAmount, 0.0);

    }

    public List<WebElement> getCharges() throws InterruptedException {
        List<WebElement> listToReturn;
        if (isDialogPopulated("Allocate Jobs for Supplier Invoice number : ")) {
            List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
            listToReturn = jobs.get(0).findElements(By.xpath(".//input[@role='checkbox']/ancestor::tr[1]"));
        } else {
            List<WebElement> jobs = pivPage.jobsList.findElements(By.xpath(".//table[contains(@id,'grdSavedPIVDetails')]"));
            listToReturn = jobs.get(0).findElements(By.xpath(".//input[@role='checkbox']/ancestor::tr[1]"));
        }
        return listToReturn;
    }

    public void selectChargesLessThanPIVAmount() {
        List<WebElement> chargesToSelect;
        if (GlobalVariables.getInvoiceType().equalsIgnoreCase("Purchase Invoice")) {
            chargesToSelect = getPositiveOrNegativeCharges("Positive");
        } else {
            chargesToSelect = getPositiveOrNegativeCharges("Negative");
        }
        int randomNum = ThreadLocalRandom.current().nextInt(1, chargesToSelect.size());
        List<Integer> indexesOfChargesToSelect = SeleniumUtils.getDistinctRandomValuesInARage(0, chargesToSelect.size(), randomNum);

        for (int num : indexesOfChargesToSelect) {

            chargesToSelect.get(num).findElement(By.xpath(".//input[@role='checkbox']")).click();
        }
    }

    public void deleteAllAllocatedCharges() throws InterruptedException {
        List<WebElement> charges = getCharges();
        for (WebElement charge : charges) {
            charge.findElement(By.xpath(".//input[@role='checkbox']")).click();
        }
        pivPage.deleteCharges.click();
        SeleniumUtils.waitForPageLoad();

    }

    public void deleteRandomAllocatedCharges() throws InterruptedException {
        List<WebElement> charges = getCharges();
        int randomNum = ThreadLocalRandom.current().nextInt(1, charges.size());
        System.out.println("Ranodm Num " + randomNum);
        List<Integer> indexesOfChargesToSelect = SeleniumUtils.getDistinctRandomValuesInARage(0, charges.size() - 1, randomNum);
        for (int num : indexesOfChargesToSelect) {
            System.out.println("Index " + num);
            charges.get(num).findElement(By.xpath(".//input[@role='checkbox']")).click();
        }
        pivPage.deleteCharges.click();
        SeleniumUtils.waitForPageLoad();
    }

    public Map<String, String> getAmountsFromPIVSummaryTable() throws InterruptedException {
        expandPanel("Summary Details");
        Map<String, String> amounts = new HashMap<>();
        amounts.put("Total PIV Amount", pivPage.totalPIVAmountPIVSummaryTable.getText().trim());
        amounts.put("Discount Value", pivPage.discountValuePIVSummaryTable.getText().trim());
        amounts.put("Write off Amount", pivPage.writeOffAmountPIVSummaryTable.getText().trim());
        amounts.put("Total Net Amount", pivPage.totalNetAmountPIVSummaryTable.getText().trim());
        amounts.put("Currency", pivPage.currencyPIVSummaryTable.getText().trim());

        return amounts;
    }

    public void verifyPIVAmountPIVSummaryTable(String pivAmount) throws InterruptedException {
        if (pivAmount.contains("Sum")) {
            double sumOfPIVAmounts = Double.parseDouble(getAmountsFromAllocatedChargesTable().get("Cost"));
            double totalPivAmount = Double.parseDouble(getAmountsFromPIVSummaryTable().get("Total PIV Amount"));
            if (sumOfPIVAmounts != totalPivAmount) {
                SeleniumUtils.logInfo("Total PIV Amount\nExpected :" + sumOfPIVAmounts + "\nActual :" + totalPivAmount);
            }
        } else {
            double totalPivAmount = Double.parseDouble(getAmountsFromPIVSummaryTable().get("Total PIV Amount"));
            if (Double.parseDouble(pivAmount) != totalPivAmount) {
                SeleniumUtils.logInfo("Total PIV Amount\nExpected :" + Double.parseDouble(pivAmount) + "\nActual :" + totalPivAmount);
            }
        }
    }

    public void verifyDiscountValuePIVSummaryTable(String discountValue) throws InterruptedException {
        double discountAmount = Double.parseDouble(getAmountsFromPIVSummaryTable().get("Discount Value"));
        if (Double.parseDouble(discountValue) != discountAmount) {
            SeleniumUtils.logInfo("Discount Value\nExpected :" + Double.parseDouble(discountValue) + "\nActual :" + discountAmount);
        }
    }

    public void verifyWriteOffAmountPIVSummaryTable(String writeOffAmount) throws InterruptedException {
        if (writeOffAmount.contains("Written off Amount")) {
            double writeOffAmountActual = Double.parseDouble(getAmountsFromPIVSummaryTable().get("Write off Amount"));
            if (Double.parseDouble(GlobalVariables.getWriteOffAmount()) != writeOffAmountActual) {
                SeleniumUtils.logInfo("Write off Amount\nExpected :" + GlobalVariables.getWriteOffAmount() + "\nActual :" + writeOffAmountActual);
            }
            SeleniumUtils.takeScreenshot();
        } else {
            double writeOffAmountActual = Double.parseDouble(getAmountsFromPIVSummaryTable().get("Write off Amount"));
            if (Double.parseDouble(writeOffAmount) != writeOffAmountActual) {
                SeleniumUtils.logInfo("Write off Amount\nExpected :" + Double.parseDouble(writeOffAmount) + "\nActual :" + writeOffAmountActual);
            }
        }
    }

    public void verifyTotalNetAmountPIVSummaryTable(String totalNetAmount) throws InterruptedException {
        if (totalNetAmount.contains("Sum")) {
            double sumOfPIVAmounts = Double.parseDouble(getAmountsFromAllocatedChargesTable().get("Net PIV Amount"));
            double totalNetAmountActual = Double.parseDouble(getAmountsFromPIVSummaryTable().get("Total Net Amount"));
            if (sumOfPIVAmounts != totalNetAmountActual) {
                SeleniumUtils.logInfo("Total Net Amount\nExpected :" + sumOfPIVAmounts + "\nActual :" + totalNetAmountActual);
            }
        } else {
            double totalNetAmountActual = Double.parseDouble(getAmountsFromPIVSummaryTable().get("Total Net Amount"));
            if (Double.parseDouble(totalNetAmount) != totalNetAmountActual) {
                SeleniumUtils.logInfo("Total Net Amount\nExpected :" + totalNetAmount + "\nActual :" + totalNetAmountActual);
            }
        }
        SeleniumUtils.takeScreenshot();
    }

    public void verifyCurrencyPIVSummaryTable(String currency) throws InterruptedException {
        String CurrencyActual = getAmountsFromPIVSummaryTable().get("Currency");
        if (!currency.equalsIgnoreCase(CurrencyActual)) {
            SeleniumUtils.logInfo("Total Net Amount\nExpected :" + currency + "\nActual :" + CurrencyActual);
        }

    }

    public Map<String, Map<String, String>> getTaxSummaryTable() throws InterruptedException {
        expandPanel("Summary Details");
        Map<String, Map<String, String>> taxInfo = new HashMap<>();
        List<WebElement> rows = pivPage.taxSummaryTable.findElements(By.xpath(".//tr[not(@class='jqgfirstrow')]"));
        for (WebElement row : rows) {
            Map<String, String> taxInfoRows = new HashMap<>();
            String taxCode = row.findElement(By.xpath(".//td[contains(@aria-describedby,'VatCode') and not(contains(@aria-describedby,'VatCodeId'))]")).getText();
            taxInfoRows.put("Total Charge Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'TotalChargeAmountB')]")).getText());
            taxInfoRows.put("Tax Rate", String.format("%.2f", Double.parseDouble(row.findElement(By.xpath(".//td[contains(@aria-describedby,'VatRatePer')]")).getText().replaceAll("%", ""))));
            taxInfoRows.put("Total Tax Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'TotalVatAmountB')]")).getText());
            taxInfoRows.put("Supplier Total Tax Amount", row.findElement(By.xpath(".//td[contains(@aria-describedby,'TotalSupVatAmountB')]")).getText());
            taxInfoRows.put("Currency", row.findElement(By.xpath(".//td[contains(@aria-describedby,'CurrencyB')]")).getText());
            taxInfo.put(taxCode, taxInfoRows);
        }

        return taxInfo;
    }

    public Map<String, Map<String, String>> getTaxInfoFromAllocatedChargesTable() throws InterruptedException {

        Map<String, Map<String, String>> taxInfo = new HashMap<>();
        List<WebElement> charges = getCharges();
        for (WebElement charge : charges) {
            if (charge.findElements(By.xpath(".//span[@class='ui-icon ui-icon icon-chevron-right']/parent::a[not(contains(@style,'display: none;'))]")).size() > 0 ||
                    charge.findElements(By.xpath(".//span[@class='ui-icon ui-icon icon-chevron-left']/parent::a[not(contains(@style,'display: none;'))]")).size() > 0) {
                try {
                    charge.findElement(By.xpath(".//span[@class='ui-icon ui-icon icon-chevron-right']")).isDisplayed();
                    charge.findElement(By.xpath(".//span[@class='ui-icon ui-icon icon-chevron-right']")).click();
                } catch (Exception ignored) {

                }

                SeleniumUtils.waitForPageLoad();
                List<WebElement> subTaxCodes = charge.findElements(By.xpath("./following-sibling::tr[1][@class='ui-subgrid']//tr[contains(@class,'jqgrow')]"));
                for (WebElement subTaxCode : subTaxCodes) {
                    Map<String, String> taxInfoRows = new HashMap<>();
                    String VATcode = subTaxCode.findElement(By.xpath(".//td[contains(@aria-describedby,'SubVat_SubVATCode') and not(contains(@aria-describedby,'Id'))]")).getText();
                    String chargeAmount = charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_NetAmountB')]")).getText();
                    String taxAmount = subTaxCode.findElement(By.xpath(".//td[contains(@aria-describedby,'SubVATTax') and not(contains(@aria-describedby,'Sup'))]")).getText();
                    String supplierTaxAmount = subTaxCode.findElement(By.xpath(".//td[contains(@aria-describedby,'SupSubVATTax')]/input")).getAttribute("value");
                    String taxRate = subTaxCode.findElement(By.xpath(".//td[contains(@aria-describedby,'SubVATRate')]")).getText().replaceAll("%", "");
                    taxInfoRows.put("Total Charge Amount", chargeAmount);
                    taxInfoRows.put("Tax Rate", String.format("%.2f", Double.parseDouble(taxRate)));
                    taxInfoRows.put("Total Tax Amount", taxAmount);
                    taxInfoRows.put("Supplier Total Tax Amount", String.format("%.2f", Double.parseDouble(supplierTaxAmount)));
                    taxInfo.put(VATcode, updateTaxInfo(taxInfo, VATcode, taxInfoRows));
                }
            } else {
                Map<String, String> taxInfoRows = new HashMap<>();
                String VATcode = charge.findElement(By.xpath(".//input[contains(@id,'t_VatCode')]")).getAttribute("value");
                String chargeAmount = charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_NetAmountB')]")).getText();
                String taxAmount = charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_VatAmountB')]")).getText();
                String supplierTaxAmount = charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value");
                String taxRate = charge.findElement(By.xpath(".//td[contains(@aria-describedby,'t_VatRatePer')]")).getText().replaceAll("%", "");
                taxInfoRows.put("Total Charge Amount", chargeAmount);
                taxInfoRows.put("Tax Rate", String.format("%.2f", Double.parseDouble(taxRate)));
                taxInfoRows.put("Total Tax Amount", taxAmount);
                taxInfoRows.put("Supplier Total Tax Amount", String.format("%.2f", Double.parseDouble(supplierTaxAmount)));
                taxInfo.put(VATcode, updateTaxInfo(taxInfo, VATcode, taxInfoRows));
            }
        }

        return taxInfo;
    }

    public static Map<String, String> updateTaxInfo(Map<String, Map<String, String>> sourceMap, String key, Map<String, String> mapToUpdate) {
        if (sourceMap.containsKey(key)) {
            Map<String, String> taxInfoMap = sourceMap.get(key);
            double chargeAmount = Double.parseDouble(taxInfoMap.get("Total Charge Amount")) + Double.parseDouble(mapToUpdate.get("Total Charge Amount"));
            double totalTaxAmount = Double.parseDouble(taxInfoMap.get("Total Tax Amount")) + Double.parseDouble(mapToUpdate.get("Total Tax Amount"));
            double supplierTaxAmount = Double.parseDouble(taxInfoMap.get("Supplier Total Tax Amount")) + Double.parseDouble(mapToUpdate.get("Supplier Total Tax Amount"));
            mapToUpdate.put("Total Charge Amount", String.format("%.2f", chargeAmount));
            mapToUpdate.put("Total Tax Amount", String.format("%.2f", totalTaxAmount));
            mapToUpdate.put("Supplier Total Tax Amount", String.format("%.2f", supplierTaxAmount));
        }

        return mapToUpdate;
    }

    public void verifyTotalChargeAmountOfTaxSummaryTable(String totalChargeAmount) throws InterruptedException {
        if (totalChargeAmount.contains("Sum")) {
            Map<String, Map<String, String>> taxInfoExpected = getTaxInfoFromAllocatedChargesTable();
            Map<String, Map<String, String>> taxInfoActual = getTaxSummaryTable();
            if (!taxInfoExpected.equals(taxInfoActual)) {
                Set<String> taxCodesExpected = taxInfoExpected.keySet();
                Set<String> taxCodesActual = taxInfoActual.keySet();
                if (taxCodesExpected.size() != taxCodesActual.size()) {
                    SeleniumUtils.logInfo("All Tax Codes are not Populated \nExpected :" + taxCodesExpected + "\nActual :" + taxCodesActual);
                } else {

                    for (String taxCode : taxCodesExpected) {
                        if (!taxInfoExpected.get(taxCode).equals(taxInfoActual.get(taxCode))) {
                            if (!taxInfoExpected.get(taxCode).get("Total Charge Amount").equalsIgnoreCase(taxInfoActual.get(taxCode).get("Total Charge Amount"))) {
                                SeleniumUtils.logInfo("Total Charge Amount for " + taxCode + "\nExpected :" + taxInfoExpected.get(taxCode).get("Total Charge Amount")
                                        + "\nActual :" + taxInfoActual.get(taxCode).get("Total Charge Amount"));
                            }
                        }
                    }
                }
            }
        }
    }

    public void verifyTaxRateTaxSummaryTable() throws InterruptedException {
        Map<String, Map<String, String>> taxInfoExpected = getTaxInfoFromAllocatedChargesTable();
        Map<String, Map<String, String>> taxInfoActual = getTaxSummaryTable();
        if (!taxInfoExpected.equals(taxInfoActual)) {
            Set<String> taxCodesExpected = taxInfoExpected.keySet();
            Set<String> taxCodesActual = taxInfoActual.keySet();
            if (taxCodesExpected.size() != taxCodesActual.size()) {
                SeleniumUtils.logInfo("All Tax Codes are not Populated \nExpected :" + taxCodesExpected + "\nActual :" + taxCodesActual);
            } else {
                for (String taxCode : taxCodesExpected) {
                    if (!taxInfoExpected.get(taxCode).equals(taxInfoActual.get(taxCode))) {
                        if (!taxInfoExpected.get(taxCode).get("Tax Rate").equalsIgnoreCase(taxInfoActual.get(taxCode).get("Tax Rate"))) {
                            SeleniumUtils.logInfo("Tax Rate for Tax Code " + taxCode + "\nExpected :" + taxInfoExpected.get(taxCode).get("Tax Rate")
                                    + "\nActual :" + taxInfoActual.get(taxCode).get("Tax Rate") + "\n");
                        }
                    }
                }
            }
        }
    }

    public void verifyTotalTaxAmountOfTaxSummaryTable(String totalTaxAmount) throws InterruptedException {
        if (totalTaxAmount.contains("Sum")) {
            Map<String, Map<String, String>> taxInfoExpected = getTaxInfoFromAllocatedChargesTable();
            Map<String, Map<String, String>> taxInfoActual = getTaxSummaryTable();
            if (!taxInfoExpected.equals(taxInfoActual)) {
                Set<String> taxCodesExpected = taxInfoExpected.keySet();
                Set<String> taxCodesActual = taxInfoActual.keySet();
                if (taxCodesExpected.size() != taxCodesActual.size()) {
                    SeleniumUtils.logInfo("All Tax Codes are not Populated \nExpected :" + taxCodesExpected + "\nActual :" + taxCodesActual);
                } else {
                    for (String taxCode : taxCodesExpected) {
                        if (!taxInfoExpected.get(taxCode).equals(taxInfoActual.get(taxCode))) {
                            if (!taxInfoExpected.get(taxCode).get("Total Tax Amount").equalsIgnoreCase(taxInfoActual.get(taxCode).get("Total Tax Amount"))) {
                                SeleniumUtils.logInfo("Total Tax Amount for " + taxCode + "\nExpected :" + taxInfoExpected.get(taxCode).get("Total Tax Amount")
                                        + "\nActual :" + taxInfoActual.get(taxCode).get("Total Tax Amount"));
                            }
                        }
                    }
                }
            }
        }
    }

    public void verifySupplierTotalTaxAmountOfTaxSummaryTable(String supplierTaxAmount) throws InterruptedException {
        if (supplierTaxAmount.contains("Sum")) {
            Map<String, Map<String, String>> taxInfoExpected = getTaxInfoFromAllocatedChargesTable();
            Map<String, Map<String, String>> taxInfoActual = getTaxSummaryTable();
            if (!taxInfoExpected.equals(taxInfoActual)) {
                Set<String> taxCodesExpected = taxInfoExpected.keySet();
                Set<String> taxCodesActual = taxInfoActual.keySet();
                if (taxCodesExpected.size() != taxCodesActual.size()) {
                    SeleniumUtils.logInfo("All Tax Codes are not Populated \nExpected :" + taxCodesExpected + "\nActual :" + taxCodesActual);
                } else {
                    for (String taxCode : taxCodesExpected) {
                        if (!taxInfoExpected.get(taxCode).equals(taxInfoActual.get(taxCode))) {
                            if (!taxInfoExpected.get(taxCode).get("Supplier Total Tax Amount").equalsIgnoreCase(taxInfoActual.get(taxCode).get("Supplier Total Tax Amount"))) {
                                SeleniumUtils.logInfo("Supplier Total Tax Amount for " + taxCode + "\nExpected :" + taxInfoExpected.get(taxCode).get("Supplier Total Tax Amount")
                                        + "\nActual :" + taxInfoActual.get(taxCode).get("Supplier Total Tax Amount"));
                            }
                        }
                    }
                }
            }
        }
    }

    public void editPIV(String supplierName, String pivType, String pivSubType, String supplierInvoiceNumber, String entityCode) throws InterruptedException {
        searchForPurchaseInvoice(supplierName, pivType, pivSubType, supplierInvoiceNumber, entityCode);
        pivPage.editPIVICon(supplierInvoiceNumber).click();
        SeleniumUtils.waitForPageLoad();
    }

    public Map<String, String> getTotalSummaryTableInfo() throws InterruptedException {
        expandPanel("Summary Details");
        Map<String, String> amounts = new HashMap<>();
        amounts.put("Net Amount", pivPage.totalNetAmountTotalSummaryTable.getText().trim());
        amounts.put("Currency", pivPage.currencyTotalSummaryTable.getText().trim());

        return amounts;
    }

    public void verifyCurrencyTotalSummaryTable(String currencyExpected) throws InterruptedException {
        String currencyActual = getTotalSummaryTableInfo().get("Currency");
        if (!currencyExpected.equalsIgnoreCase(currencyActual)) {
            SeleniumUtils.logInfo("Currency\nExpected :" + currencyExpected + "\nActual :" + currencyActual);
        }
    }

    public void verifyNetAmountTotalSummaryTable(String netAmountExpected) throws InterruptedException {
        if (netAmountExpected.contains("Sum")) {
            double netAmountFromAllocatedCharges = Double.parseDouble(getAmountsFromAllocatedChargesTable().get("Total Amount"));
            double netAmountActual = Double.parseDouble(getTotalSummaryTableInfo().get("Net Amount"));
            if (netAmountFromAllocatedCharges != netAmountActual) {
                SeleniumUtils.logInfo("Net Amount\nExpected :" + netAmountFromAllocatedCharges + "\nActual :" + netAmountActual);
            }
        } else {
            double netAmountActual = Double.parseDouble(getTotalSummaryTableInfo().get("Net Amount"));
            if (Double.parseDouble(netAmountExpected) != netAmountActual) {
                SeleniumUtils.logInfo("Net Amount\nExpected :" + netAmountExpected + "\nActual :" + netAmountActual);
            }

        }
    }

    public void verifyCurrencyOfTaxSummaryTable(String currency) throws InterruptedException {

        Map<String, Map<String, String>> taxInfoActual = getTaxSummaryTable();
        Set<String> taxCodesActual = taxInfoActual.keySet();
        for (String taxCode : taxCodesActual) {
            if (!taxInfoActual.get(taxCode).get("Currency").equalsIgnoreCase(currency)) {
                SeleniumUtils.logInfo("Supplier Total Tax Amount for " + taxCode + "\nExpected :" + currency
                        + "\nActual :" + taxInfoActual.get(taxCode).get("Currency"));
            }
        }
    }

    public void allocateCharges() throws InterruptedException {
        if (isDialogPopulated("Allocate Jobs for Supplier Invoice number : ")) {
            selectCharges();
        } else {
            clickOnaButton("Allocate to Jobs/ Consol");
            enterJobNumber(GlobalVariables.getJobNumber());
            updatedPIVAmountAndTaxAmount();
            clickOnaButton("Allocate to Jobs/ Consol");
            enterJobNumber(GlobalVariables.getJobNumber());
            selectCharges();
        }
        clickOnaButton("Allocate");
        verifyErrorAndUpdateTaxAmount();
    }

    private void verifyErrorAndUpdateTaxAmount() throws InterruptedException {
        if (isDialogPopulated("Error")) {
            if (pivPage.errorMessage.getText().equalsIgnoreCase("Total supplier tax amount should not be greater than header tax amount")) {
                pivPage.okButtonWarning("Total supplier tax amount should not be greater than header tax amount").click();
                double taxAmtDiff = Double.parseDouble(getAmountInfoAllocateTable().get("To be Allocated Amount").get("Tax Amount"));
                List<WebElement> jobs = pivPage.jobsListAllocateJobs.findElements(By.xpath(".//table[contains(@id,'grdTagJobsLs')]"));
                List<WebElement> nonZeroTaxRatedCharges = jobs.get(0).findElements(By.xpath(".//tr[not(@class='jqgfirstrow') and @aria-selected='true']//td[contains(@aria-describedby,'t_VatRatePer') and not(@title='0%')]/ancestor::tr[1]"));
                int randomNum = 0;
                if (nonZeroTaxRatedCharges.size() > 1) {
                    randomNum = ThreadLocalRandom.current().nextInt(0, nonZeroTaxRatedCharges.size() - 1);
                }
                double supplierTaxAmt = Double.parseDouble(nonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).getAttribute("value"));
                SeleniumUtils.clearText(nonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")));
                nonZeroTaxRatedCharges.get(randomNum).findElement(By.xpath("./td[contains(@aria-describedby,'t_SuppVatAmountB')]/input")).sendKeys(String.format("%.2f", (supplierTaxAmt + taxAmtDiff)));
                clickOnaButton("Allocate");
            }
        }
    }

    public void partiallyAllocateCharges() throws InterruptedException {
        if (isDialogPopulated("Allocate Jobs for Supplier Invoice number : ")) {
            selectCharges();
        } else {
            clickOnaButton("Allocate to Jobs/ Consol");
            enterJobNumber(GlobalVariables.getJobNumber());
            updatedPIVAmountAndTaxAmount();
            clickOnaButton("Allocate to Jobs/ Consol");
            enterJobNumber(GlobalVariables.getJobNumber());
            selectChargesLessThanPIVAmount();
        }
        clickOnaButton("Allocate");
    }
}
