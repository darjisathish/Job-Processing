package com.agility.focis.performActivities.cbr;

import com.agility.focis.CBR.CBREDI;
import com.agility.focis.CBR.JOBDETAILS;
import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.performActivities.common.CommonSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CBRSteps extends CommonSteps {
    private WebDriver driver;
    CBRPage cbrPage;

    public CBRSteps() throws IOException {
        this.driver = getDriver();
        cbrPage = new CBRPage(this.driver);

    }


    public void performCBR() throws InterruptedException {
        clickOnTab("Tasks");
        SeleniumUtils.waitForPageLoad();
        GlobalVariables.setProductType(cbrPage.verifyProductType.getText());
        clickOnPerformActivityAndSwithToWindow("Carrier Booking Request");
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToBeClickable(cbrPage.referenceSearchButton("Agility Office (Owner of Activity)"));
        cbrPage.referenceSearchButton("Agility Office (Owner of Activity)").click();
        cbrPage.selectAllReferences.click();
        cbrPage.saveReferences.click();

        cbrPage.referenceSearchButton("Shipper").click();
        cbrPage.selectAllReferences.click();
        cbrPage.saveReferences.click();

        cbrPage.referenceSearchButton("Consignee").click();
        cbrPage.selectAllReferences.click();
        cbrPage.saveReferences.click();

        cbrPage.completeButton.click();
        SeleniumUtils.waitForPageLoad();
        cbrPage.alertButtonToComplete.click();
        SeleniumUtils.waitForPageLoad();
        cbrPage.alertButtonToView.click();
        SeleniumUtils.waitForPageLoad();
//        cbrPage.alertButtonToPrint.click();
//        SeleniumUtils.waitForPageLoad();
        cbrPage.ediButton.click();
        GlobalVariables.setParties(getPartyInformationCBR());
        SeleniumUtils.switchToParentWindow();
    }

    public void readCBRXML() throws InterruptedException {
        cbrPage.moreLinksButton.click();
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForFrameTobeAvailableAndSwitchToIt(cbrPage.moreLinksIframe);
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToPresent(By.xpath("//ul[@id = 'ulSideMenuBar']//a[text() = 'Intg.. Audit']"));
        SeleniumUtils.waitForElementToBeClickable(cbrPage.moreLinks_linkToBeClicked("Intg.. Audit"));
        cbrPage.moreLinks_linkToBeClicked("Intg.. Audit").click();
        SeleniumUtils.waitForPageLoad();
        cbrPage.fobSearchButton("", "Booking Request").click();
        SeleniumUtils.waitForElementToBeClickable(cbrPage.xmlDataLink("Booking Request"));
        cbrPage.xmlDataLink("Booking Request").click();
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForElementToVisible(cbrPage.xmlRawData);
        Thread.sleep(10000);
        String xmlRawData = cbrPage.xmlRawData.getAttribute("value");
//        System.out.println(xmlRawData);
        GlobalVariables.setCbrXMLData(xmlRawData);
        System.out.println(GlobalVariables.getCbrXMLData());
    }

    public void verifyCBRXML() throws InterruptedException, JsonProcessingException {
        this.readCBRXML();
        JOBDETAILS cbrXMLData = CBREDI.getEDIInfo(GlobalVariables.getCbrXMLData());
        compareStringsAndLogInfo("Job Number", GlobalVariables.getJobNumber(), cbrXMLData.getJobNumber());
        compareStringsAndLogInfo("Product", GlobalVariables.getProduct(), cbrXMLData.getProduct());
        compareStringsAndLogInfo("Product Type", GlobalVariables.getProductType(), cbrXMLData.getProductType());
        compareStringsAndLogInfo("Job Status", GlobalVariables.getJobStatus(), cbrXMLData.getJobStatus().getStatusDescription());
        compareStringsAndLogInfo("Incoterm", GlobalVariables.getIncoterm(), cbrXMLData.getIncotermlocation().getINCOTERMTYPE());
        compareStringsAndLogInfo("Incoterm Location", GlobalVariables.getIncoTermLocation(), cbrXMLData.getIncotermlocation().getLocation());

        SeleniumUtils.compareMapsAndLogNotMatchingValues(GlobalVariables.getParties(), cbrXMLData.getParties().getpartyInformation());

        if (!SeleniumUtils.getMessageToPrint().equalsIgnoreCase(""))
            Assert.fail("CBR EDI Data Populated Incorrectly");

    }

    public void compareStringsAndLogInfo(String fieldName, String expected, String actual) {
        if (!expected.equalsIgnoreCase(actual))
            SeleniumUtils.logInfo(fieldName + " populated incorrectly\nExpected: " + expected + "\n Actual : " + actual + "\n");

    }

    public Map<String, Map<String, String>> getPartyInformationCBR() {
        Map<String, Map<String, String>> parties = new HashMap<>();
        Map<String, String> agilityOffice = new HashMap<>();
        Map<String, String> branch = new HashMap<>();
        Map<String, String> shipper = new HashMap<>();
        Map<String, String> consignee = new HashMap<>();
        Map<String, String> notifyParty = new HashMap<>();

        agilityOffice.put("Name", WordUtils.capitalizeFully(cbrPage.partyName("Agility Office (Owner of Activity)").getAttribute("value"), new char[]{' '}));
        agilityOffice.put("Address", cbrPage.partyAddress("Agility Office (Owner of Activity)").getAttribute("value").trim());
        parties.put("Agility Office", agilityOffice);

        branch.put("Name", WordUtils.capitalizeFully(cbrPage.partyName("Booking Branch (Performer of Activity)").getAttribute("value"), new char[]{' '}));
        branch.put("Address", cbrPage.partyAddress("Booking Branch (Performer of Activity)").getAttribute("value").trim());
        parties.put("Branch", branch);

        shipper.put("Name", WordUtils.capitalizeFully(cbrPage.partyName("Shipper").getAttribute("value"), new char[]{' '}));
        shipper.put("Address", cbrPage.partyAddress("Shipper").getAttribute("value").trim());
        parties.put("Shipper", shipper);

        consignee.put("Name", WordUtils.capitalizeFully(cbrPage.partyName("Consignee").getAttribute("value"), new char[]{' '}));
        consignee.put("Address", cbrPage.partyAddress("Consignee").getAttribute("value").trim());
        parties.put("Consignee", consignee);

        notifyParty.put("Name", WordUtils.capitalizeFully(cbrPage.partyName("Notify Party").getAttribute("value"), new char[]{' '}));
        notifyParty.put("Address", cbrPage.partyAddress("Notify Party").getAttribute("value").trim());
        parties.put("Notify Party", notifyParty);
        return parties;
    }
}
