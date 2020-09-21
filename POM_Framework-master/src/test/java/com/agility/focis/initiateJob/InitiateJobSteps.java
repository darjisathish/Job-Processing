package com.agility.focis.initiateJob;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.HashMap;

public class InitiateJobSteps extends BaseSteps {
    private WebDriver driver;
    InitiateJobPage initiateJobPage;

    public InitiateJobSteps() throws IOException {
        this.driver = getDriver();
        initiateJobPage = new InitiateJobPage(this.driver);

    }

    public void enterDataOnInitiatePageOne(String product, String productType, String jobScope, String originStakeholder, String destinationStakeholder) throws InterruptedException {

        initiateJobPage.OriginStakeholderInput.sendKeys(originStakeholder);
        Thread.sleep(1000);
        initiateJobPage.OriginStakeholderInput.sendKeys(Keys.ENTER);
        initiateJobPage.DestinationStakeholderInput.sendKeys(destinationStakeholder);
        Thread.sleep(1000);
        initiateJobPage.DestinationStakeholderInput.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        clickOnaButton("Next");
    }

    public void selectJobDistinguishers(String product, String productType, String jobScope) throws InterruptedException {
        Thread.sleep(1000);
        GlobalVariables.setProduct(product);
        GlobalVariables.setProductType(productType);
        GlobalVariables.setJobScope(jobScope);
        DropDownUtils.selectOptionByVisibleText(initiateJobPage.productDropDown, product);
        DropDownUtils.selectOptionByVisibleText(initiateJobPage.productTypeDropDown, productType);
        DropDownUtils.selectOptionByVisibleText(initiateJobPage.jobScopeDropDown, jobScope);
    }

    
    public void selectStakeholder(String stakeholderType, String stakeholderIdOrName) throws InterruptedException {
        initiateJobPage.searchIconUsingLable(stakeholderType).click();
        searchForSTK(stakeholderIdOrName);
        SeleniumUtils.waitForPageLoad();

    }
    

    public void selectIncoTerm(String incoTerm, String incoTermLocation) {
        DropDownUtils.selectOptionByVisibleText("Incoterm", incoTerm);
        TextBoxUtils.setText("Incoterm Location", incoTermLocation);
        GlobalVariables.setIncoterm(incoTerm);
        GlobalVariables.setIncoTermLocation(incoTermLocation);
    }

    public void selectMBL(String mblType, String mblTerms) {
        DropDownUtils.selectOptionByVisibleText("MBL Type", mblType);
        DropDownUtils.selectOptionByVisibleText("MBL Terms", mblTerms);
        HashMap<String, String> mblinfo = new HashMap<>();
        mblinfo.put("MBL Type", mblType);
        mblinfo.put("MBL Terms", mblTerms);
        GlobalVariables.setMblInformation(mblinfo);
    }

    public void selectSLBL(String sequestType) {
        DropDownUtils.selectOptionByVisibleText("Seaquest Type", sequestType);
    }

    public void selectOffice(String typeOfOffice, String country, String type, String networkComponent, String department, String isLive) throws InterruptedException {
        if (typeOfOffice.equalsIgnoreCase("Origin")) {
            GlobalVariables.setOriginOrgComponent(networkComponent, department);
            if (GlobalVariables.getProduct().equalsIgnoreCase("Air Freight")) {
                initiateJobPage.airportOfDeparture.clear();
                SeleniumUtils.waitForPageLoad();
            } else {
                initiateJobPage.portOfLoading.clear();
                SeleniumUtils.waitForPageLoad();
            }
        } else {
            GlobalVariables.setDestinationOrgComponent(networkComponent, department);
            if (GlobalVariables.getProduct().equalsIgnoreCase("Air Freight")) {
                initiateJobPage.airportOfArrival.clear();
                SeleniumUtils.waitForPageLoad();
            } else {
                initiateJobPage.portOfDischarge.clear();
                SeleniumUtils.waitForPageLoad();
            }
        }
        initiateJobPage.inlineSearchUsingLabel(typeOfOffice + " Office").clear();
        initiateJobPage.searchIconUsingLable(typeOfOffice + " Office").click();
        searchForOffice(country, type, networkComponent, department, isLive);
    }

    public void searchForPort(String country, String networkComponent) {


    }

    public void searchForOffice(String country, String type, String networkComponent, String department, String isLive) throws InterruptedException {
        boolean isOfficeSelected = false;
        for (int i = 0; i < 10; i++) {
            SeleniumUtils.waitForElementToVisible(initiateJobPage.isLive);
            DropDownUtils.selectOptionByVisibleText(initiateJobPage.isLive, isLive);
            initiateJobPage.countryCode.sendKeys(country);
            initiateJobPage.networkComponent.sendKeys(networkComponent);
            initiateJobPage.type.sendKeys(type);
            initiateJobPage.departmentName.sendKeys(department + Keys.ENTER);
            SeleniumUtils.waitForPageLoad();
            if (Integer.parseInt(initiateJobPage.networkComponentPageCount.getText()) > 5) {
                initiateJobPage.departmentName.sendKeys(Keys.ENTER);
                SeleniumUtils.waitForPageLoad();
            }
            if (driver.findElements(By.xpath("//b[text() = 'No records to view']")).size() > 0) {
                initiateJobPage.refreshIcon.click();
                Thread.sleep(1000);
                searchForOffice(country, type, networkComponent, department, isLive);
            } else {
                Thread.sleep(2000);
                initiateJobPage.officebestMatch(country).click();
                SeleniumUtils.waitForPageLoad();
                isOfficeSelected = true;
                break;
            }

        }

        if (!isOfficeSelected) {
            initiateJobPage.closePopUpButton("Network Components").click();
        }

    }

    public void verifyJobInformation(String product, String productType, String jobScope) throws InterruptedException {
        SeleniumUtils.waitForElementToVisible(initiateJobPage.verifyjobscope);
        Assert.assertTrue(initiateJobPage.verifyproduct.getText().equalsIgnoreCase(product));
        Assert.assertTrue(initiateJobPage.verifyProductType.getText().equalsIgnoreCase(productType));
        Select jobscopedropdown = new Select(initiateJobPage.verifyjobscope);
        Assert.assertTrue(jobscopedropdown.getFirstSelectedOption().getText().equalsIgnoreCase(jobScope));
        SeleniumUtils.takeScreenshot();
        SeleniumUtils.logInfo("Job Number is: " + initiateJobPage.jobNumber.getText());
        GlobalVariables.setJobNumber(initiateJobPage.jobNumber.getText());
        GlobalVariables.setProduct(initiateJobPage.verifyproduct.getText());
        GlobalVariables.setProductType(initiateJobPage.verifyProductType.getText());
        GlobalVariables.setJobScope(jobscopedropdown.getFirstSelectedOption().getText());
        GlobalVariables.setJobStatus(initiateJobPage.jobStatus.getText());
    }

    public void slecteReferences() throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(initiateJobPage.shipperReferenceTypeButton);
        initiateJobPage.shipperReferenceTypeButton.click();
        SeleniumUtils.waitForPageLoad();
        initiateJobPage.referenceInputBox.sendKeys("Packing List" + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        HyperLinkUtils.clickOnLink("Packing List");
        SeleniumUtils.waitForPageLoad();
        initiateJobPage.shipperReference.sendKeys("AutoShipper");
        SeleniumUtils.waitForElementToBeClickable(initiateJobPage.consigneeReferenceTypeButton);
        initiateJobPage.consigneeReferenceTypeButton.click();
        SeleniumUtils.waitForPageLoad();
        initiateJobPage.referenceInputBox.sendKeys("Destination Collection" + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        HyperLinkUtils.clickOnLink("Destination Collection");
        SeleniumUtils.waitForPageLoad();
        initiateJobPage.consigneeReference.sendKeys("AutoConsignee");
    }
}
