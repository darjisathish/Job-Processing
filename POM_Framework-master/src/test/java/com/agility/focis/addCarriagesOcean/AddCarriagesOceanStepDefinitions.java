package com.agility.focis.addCarriagesOcean;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddCarriagesOceanStepDefinitions {
    private AddCarriagesOceanSteps addCarriagesOceanSteps;

    public AddCarriagesOceanStepDefinitions() throws IOException {

        addCarriagesOceanSteps = new AddCarriagesOceanSteps();
    }

    @When("Adds Main Carriage with Carrier - {string}, Job Type - {string} along with below details")
    public void adds_Main_Carriage_with_Carrier_Job_Type_along_with_below_details(String carrier, String jobType, List<Map<String, String>> mainCarriageInfo) throws InterruptedException {
        int noOfLegs = 0;

        for (int i = 0; i < mainCarriageInfo.size(); i++) {
            if (!mainCarriageInfo.get(0).get("Port of Loading").equalsIgnoreCase("")) {

                noOfLegs++;
            }
        }
        switch (noOfLegs) {
            case 1:
                addCarriagesOceanSteps.addSingleLeg(carrier, jobType, mainCarriageInfo);
                break;
            case 2:
                addCarriagesOceanSteps.addTwoLegs(carrier, jobType, mainCarriageInfo);
                break;
            case 3:
                addCarriagesOceanSteps.addmultipleLeg(carrier, jobType, mainCarriageInfo);
                break;
            default:
                SeleniumUtils.logInfo("You have not Provided any Port of Loading information to Plan Main Carriage");
        }
        GlobalVariables.setJobStatus(addCarriagesOceanSteps.addCarriagesOceanPage.jobStatus.getText());
        SeleniumUtils.takeScreenshot();
    }

    @When("Adds Pre Carriage with Haulage Arrangement as {string}")
    public void adds_Pre_Carriage_with_Haulage_Arrangement_as(String haulierType, List<Map<String, String>> preCarriageInfo) throws InterruptedException {
        for (int i = 0; i < preCarriageInfo.size(); i++) {
            String haulierName = preCarriageInfo.get(0).get("Haulier Name");
            String originCargoCollectionDate = preCarriageInfo.get(0).get("Cargo Collection Date");
            String originCargoDeliveryDate = preCarriageInfo.get(0).get("Cargo Delivery Date");
            addCarriagesOceanSteps.addPreCarriage(haulierType, haulierName, originCargoCollectionDate, originCargoDeliveryDate);
        }
    }

    @When("Adds On Carriage with Haulage Arrangement as {string}")
    public void adds_On_Carriage_with_Haulage_Arrangement_as(String haulierType, List<Map<String, String>> onCarriageInfo) throws InterruptedException {
        for (int i = 0; i < onCarriageInfo.size(); i++) {
            String haulierName = onCarriageInfo.get(0).get("Haulier Name");
            String originCargoCollectionDate = onCarriageInfo.get(0).get("Cargo Collection Date");
            String originCargoDeliveryDate = onCarriageInfo.get(0).get("Cargo Delivery Date");
            addCarriagesOceanSteps.addOnCarriage(haulierType, haulierName, originCargoCollectionDate, originCargoDeliveryDate);
        }
    }


}