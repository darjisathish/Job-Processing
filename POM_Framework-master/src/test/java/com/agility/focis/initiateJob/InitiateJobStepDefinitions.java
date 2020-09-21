package com.agility.focis.initiateJob;


import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class InitiateJobStepDefinitions {
    private InitiateJobSteps initiateJobSteps;

    public InitiateJobStepDefinitions() throws IOException {

        initiateJobSteps = new InitiateJobSteps();
    }

    @And("enters below info on Initiation Page One")
    public void entersBelowInfoOnInitiationPage(List<Map<String, String>> dataTable) throws InterruptedException {
        String product;
        String productType;
        String jobScope;
        String originStakeholder;
        String destinationStakeholder;

        for (int i = 0; i < dataTable.size(); i++) {
            product = dataTable.get(i).get("Product");
            productType = dataTable.get(i).get("ProductType");
            jobScope = dataTable.get(i).get("JobScope");
            originStakeholder = dataTable.get(i).get("OriginStakeholder");
            destinationStakeholder = dataTable.get(i).get("DestinationStakeholder");

        }
    }

    @And("creates  a new {string} - {string} - {string} Job with following details")
    public void createsANewJobFollowingDetails(String product, String productType, String jobScope) throws InterruptedException {
        initiateJobSteps.selectJobDistinguishers(product, productType, jobScope);
    }

    @And("selects {string} as Origin Stakeholder & {string} as Destination Stakeholder")
    public void selectsAsOriginStakeholderAsDestinationStakeholder(String originSTK, String destinationSTK) throws InterruptedException {
        initiateJobSteps.selectStakeholder("Origin Stakeholder", originSTK);
        GlobalVariables.setOriginSTKName(originSTK);
        initiateJobSteps.selectStakeholder("Destination Stakeholder", destinationSTK);
        GlobalVariables.setDestinationSTKName(destinationSTK);
        initiateJobSteps.slecteReferences();
        SeleniumUtils.takeScreenshot();
    }

    @And("selects Incoterm, Master Bill Of Lading & Sequest Line Of Billing details as below")
    public void selectsIncotermMasterBillOfLadingSequestLineOfBillingDetailsAsBelow(List<Map<String, String>> dataTable) {
        String incoTerm;
        String incoTermLocation = "AutoLocation";
        String mblType;
        String mblTerms;
        String sequestType;

        for (int i = 0; i < dataTable.size(); i++) {
            incoTerm = dataTable.get(i).get("IncoTerm");
            mblType = dataTable.get(i).get("MBLType");
            mblTerms = dataTable.get(i).get("MBLTerms");
            sequestType = dataTable.get(i).get("SequestType");
            initiateJobSteps.selectIncoTerm(incoTerm, incoTermLocation);
            initiateJobSteps.selectMBL(mblType, mblTerms);
            initiateJobSteps.selectSLBL(sequestType);
        }
    }

    @And("selects {string} as Incoterm")
    public void selectsAsIncoterm(String incoTerm) {
        String incoTermLocation = "AutoLocation";
        initiateJobSteps.selectIncoTerm(incoTerm, incoTermLocation);
    }

    @When("selects {string} Office as below")
    public void selects_Office_as_below(String typeOfOffice, List<Map<String, String>> officeInfo) throws InterruptedException {
        String country;
        String networkComponent;
        String department;
        String isLive;
        String type;

        for (int i = 0; i < officeInfo.size(); i++) {
            country = officeInfo.get(i).get("Country");
            networkComponent = officeInfo.get(i).get("NetworkComponent");
            department = officeInfo.get(i).get("Department");
            isLive = officeInfo.get(i).get("IsLive");
            type = officeInfo.get(i).get("Type");
            if (!country.equalsIgnoreCase("") || !networkComponent.equalsIgnoreCase("") || !department.equalsIgnoreCase("") ||
                    !isLive.equalsIgnoreCase("") || !type.equalsIgnoreCase("")) {
                initiateJobSteps.selectOffice(typeOfOffice, country, type, networkComponent, department, isLive);
            }
        }
    }

    @Then("new {string} - {string} - {string} Job is created successfully")
    public void newJobIsCreatedSuccessfully(String product, String productType, String jobScope) throws InterruptedException {
        initiateJobSteps.verifyJobInformation(product, productType, jobScope);
    }

    @And("Clicks on {string} button")
    public void clicksOnButton(String button) throws InterruptedException {
        initiateJobSteps.clickOnaButton(button);

    }

    @Given("{string} is on {string}")
    public void is_on(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
