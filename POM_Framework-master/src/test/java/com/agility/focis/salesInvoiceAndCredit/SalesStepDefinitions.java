package com.agility.focis.salesInvoiceAndCredit;

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

public class SalesStepDefinitions {
    private SalesSteps salesSteps;

    public SalesStepDefinitions() throws IOException {

        salesSteps = new SalesSteps();
    }

    @And("Processes Sales Invoice with below details")
    public void processesSalesInvoiceWithBelowDetails(List<Map<String, String>> invoiceDetails) throws InterruptedException {
        for (Map<String, String> invoiceInfo : invoiceDetails) {
            String jobNumber = invoiceInfo.get("Job Number");
            if (jobNumber.equalsIgnoreCase("Current Job")) {
                jobNumber = GlobalVariables.getJobNumber();
            }
            GlobalVariables.setJobNumber(jobNumber);
            salesSteps.navigateToFinancialScreen(jobNumber);
            salesSteps.processSalesInvoice(invoiceInfo);
            SeleniumUtils.takeScreenshot();
        }

    }

    @And("Processes Credit Note against to below details")
    public void processesCreditNoteAgainstToBelowDetails(List<Map<String, String>> creditNoteInfo) throws InterruptedException, IOException {
        salesSteps.selectMenu("Manage Invoice", "Invoice/Credit", "Job");
        for (Map<String, String> creditNoteDetails : creditNoteInfo) {
            String jobNumber = creditNoteDetails.get("Job Number");
            if (jobNumber.equalsIgnoreCase("Current Job")) {
                jobNumber = GlobalVariables.getJobNumber();
            }
            GlobalVariables.setJobNumber(jobNumber);
            String numberOfCharges = creditNoteDetails.get("Charges");
            String legalEntity = creditNoteDetails.get("Legal Entity");
            salesSteps.selectMenu("Manage Invoice", "Invoice/Credit", "Job");
            salesSteps.generateCreditNote(jobNumber, legalEntity, numberOfCharges);
            salesSteps.loginToApp("approver1", "Test@123");
            salesSteps.selectMenu("Manage Credit Note", "Invoice/Credit", "Job");
            salesSteps.approveCreditNote(jobNumber, legalEntity);
            salesSteps.loginToApp();
            salesSteps.selectMenu("Manage Credit Note", "Invoice/Credit", "Job");
            salesSteps.generateApprovedCreditNote(jobNumber, legalEntity);

        }
    }

}
