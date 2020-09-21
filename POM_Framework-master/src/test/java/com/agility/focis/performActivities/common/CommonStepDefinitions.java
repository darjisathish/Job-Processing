package com.agility.focis.performActivities.common;

import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.performActivities.ac.ArrivalConfirmationSteps;
import com.agility.focis.performActivities.awb.IssueAWBSteps;
import com.agility.focis.performActivities.bctc.BCTCSteps;
import com.agility.focis.performActivities.cbc.CBCSteps;
import com.agility.focis.performActivities.cbr.CBRSteps;
import com.agility.focis.performActivities.crc.CRCSteps;
import com.agility.focis.performActivities.dc.DepartureConfirmationSteps;
import com.agility.focis.performActivities.mblf.MBLFSteps;
import com.agility.focis.performActivities.mbli.MBLISteps;
import com.agility.focis.performActivities.slbol.SLBOLSteps;
import com.agility.focis.performActivities.sqsur.SQSURSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CommonStepDefinitions {
    private CommonSteps commonSteps;
    private ArrivalConfirmationSteps arrivalConfirmationSteps;
    private IssueAWBSteps issueAWBSteps;
    private BCTCSteps bctcSteps;
    private CBCSteps cbcSteps;
    private CBRSteps cbrSteps;
    private CRCSteps crcSteps;
    private DepartureConfirmationSteps departureConfirmationSteps;
    private MBLFSteps mblfSteps;
    private MBLISteps mbliSteps;
    private SLBOLSteps slbolSteps;
    private SQSURSteps sqsurSteps;


    public CommonStepDefinitions() throws IOException {

        commonSteps = new CommonSteps();

        arrivalConfirmationSteps = new ArrivalConfirmationSteps();
        issueAWBSteps = new IssueAWBSteps();
        bctcSteps = new BCTCSteps();
        cbcSteps = new CBCSteps();
        cbrSteps = new CBRSteps();
        crcSteps = new CRCSteps();
        departureConfirmationSteps = new DepartureConfirmationSteps();
        mblfSteps = new MBLFSteps();
        mbliSteps = new MBLISteps();
        slbolSteps = new SLBOLSteps();
        sqsurSteps = new SQSURSteps();

    }

    @When("Performs Activities as below")
    public void performs_Activities_as_below(List<Map<String, String>> activitiesList) throws InterruptedException {
        for (Map<String, String> activities : activitiesList) {
            String cbr = activities.get("Carrier Booking Request");
            String cbc = activities.get("Carrier Booking Confirmation");
            String bctc = activities.get("Booking Confirmation to Customer");
            String mbl = activities.get("Master Bill Of Lading Instructions");
            String mbla = activities.get("Master Bill of Lading Approval");
            String mblf = activities.get("Final Master Bill of Lading");
            String slbol = activities.get("Seaquest Line Bill of Lading");
            String sqsur = activities.get("Seaquest Surrender");
            String dc = activities.get("Departure Confirmation");
            String ac = activities.get("Arrival Confirmation");
            String crc = activities.get("Cargo Release to Customer");
//            Perform Activities based on Options
            if (cbr.equalsIgnoreCase("Yes")) {
                cbrSteps.enterContract("FAK");
                cbrSteps.performCBR();
            } else if (cbr.equalsIgnoreCase("No")) {
                SeleniumUtils.logInfo("Carrier Booking Request is not performed");
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Carrier Booking Request i.e " + cbr);
            }
            if (cbc.equalsIgnoreCase("Yes")) {
                cbcSteps.performCBC();
            } else if (cbc.equalsIgnoreCase("No")) {
                SeleniumUtils.logInfo("Carrier Booking Confirmation is not performed");
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Carrier Booking Confirmation i.e " + cbc);
            }
            if (bctc.equalsIgnoreCase("Yes")) {
                bctcSteps.performBCTC();
            } else if (cbc.equalsIgnoreCase("No")) {
                SeleniumUtils.logInfo("Booking Confirmation to Customer is not performed");
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Booking Confirmation to Customer i.e " + bctc);
            }
            if (mbl.equalsIgnoreCase("Yes")) {
                mbliSteps.performMBLI();
            } else if (mbl.equalsIgnoreCase("No")) {
                SeleniumUtils.logInfo("Master Bill Of Lading Instructions is not performed");
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Master Bill Of Lading Instructions i.e " + bctc);
            }
            if (mbla.equalsIgnoreCase("Yes")) {

            } else if (mbla.equalsIgnoreCase("No")) {
                SeleniumUtils.logInfo("Master Bill of Lading Approval is not performed");
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Master Bill of Lading Approval i.e " + bctc);
            }
            if (mblf.equalsIgnoreCase("Yes")) {
                mblfSteps.performMBLF();
            } else if (mblf.equalsIgnoreCase("No")) {
                SeleniumUtils.logInfo("Final Master Bill of Lading is not performed");
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Final Master Bill of Lading i.e " + bctc);
            }
            if (slbol.equalsIgnoreCase("Yes")) {
                slbolSteps.perfomSLBOL();
            } else if (slbol.equalsIgnoreCase("No")) {
                SeleniumUtils.logInfo("Seaquest Line Bill of Lading is not performed");
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Seaquest Line Bill of Lading i.e " + bctc);
            }
            if (sqsur.equalsIgnoreCase("Yes")) {
                slbolSteps.perfomSLBOL();
            } else if (sqsur.equalsIgnoreCase("No")) {
                SeleniumUtils.logInfo("Seaquest Surrender is not performed");
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Seaquest Surrender i.e " + bctc);
            }
            if (dc.equalsIgnoreCase("Yes")) {
                departureConfirmationSteps.performDC();
            } else if (dc.equalsIgnoreCase("No")) {
                SeleniumUtils.logInfo("Departure Confirmation is not performed");
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Departure Confirmation i.e " + bctc);
            }
            if (ac.equalsIgnoreCase("Yes")) {
                arrivalConfirmationSteps.performAC();
            } else if (ac.equalsIgnoreCase("No")) {
                SeleniumUtils.logInfo("Arrival Confirmation is not performed");
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Arrival Confirmation i.e " + bctc);
            }
            if (crc.equalsIgnoreCase("Yes")) {
                crcSteps.performCRC();
            } else if (crc.equalsIgnoreCase("No")) {
                SeleniumUtils.logInfo("Cargo Release to Customer is not performed");
            } else {
                SeleniumUtils.logInfo("You have provided invalid option for Cargo Release to Customer i.e " + bctc);
            }

        }
    }

    @Then("Status of Activities should be Completed")
    public void statusOfActivitiesShouldBeCompleted() {
        commonSteps.verifyStatusOfActivities();
        GlobalVariables.setJobStatus(commonSteps.commonPage.jobStatus.getText());
    }

    @And("EDI XML Data should be populated Correctly for {string}")
    public void ediXMLDataShouldBePopulatedCorrectlyFor(String activityName) throws InterruptedException, JsonProcessingException {
        switch (activityName) {
            case "CBR":
                cbrSteps.verifyCBRXML();
                break;
            case "MBL":

            default:
                SeleniumUtils.logInfo("Invalid Activity i.e " + activityName);
        }

    }

    @And("Performs {string} Activity")
    public void performsActivity(String activityName) throws JsonProcessingException, InterruptedException {
        switch (activityName) {
            case "Carrier Booking Request":
                cbrSteps.enterContract("FAK");
                cbrSteps.performCBR();
                break;
            case "Carrier Booking Confirmation":
                cbcSteps.performCBC();
                break;
            case "Booking Confirmation to Customer":
                bctcSteps.performBCTC();
                break;
            case "Master Bill of Lading Instructions":
                mbliSteps.performMBLI();
                break;
            case "Master Bill of Lading Approval":
                mblfSteps.performMBLF();
                break;
            case "Final Master Bill of Lading":
                break;
            case "Seaquest Line Bill of Lading":
                slbolSteps.perfomSLBOL();
                break;
            case "Departure Confirmation":
                departureConfirmationSteps.performDC();
                break;
            case "Arrival Confirmation":
                arrivalConfirmationSteps.performAC();
                break;
            case "Cargo Release to Customer":
                crcSteps.performCRC();
                break;
            case "Issue AWB":
                issueAWBSteps.performAWB();
                break;

            default:
                SeleniumUtils.logInfo("Invalid Activity i.e " + activityName);
        }
    }

}
