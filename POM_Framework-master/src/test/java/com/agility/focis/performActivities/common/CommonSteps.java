package com.agility.focis.performActivities.common;

import com.agility.focis.CBR.CBREDI;
import com.agility.focis.CBR.JOBDETAILS;
import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonSteps extends BaseSteps {
    private WebDriver driver;
    CommonPage commonPage;

    public CommonSteps() throws IOException {
        this.driver = getDriver();
        commonPage = new CommonPage(this.driver);

    }

    public void clickOnPerformActivityIcon(String activity) throws InterruptedException {
        clickOnTab("Tasks");
        SeleniumUtils.waitForPageLoad();
        commonPage.performActivity(activity).click();
    }

    public void clickOnPerformActivityAndSwithToWindow(String activity) throws InterruptedException {
        clickOnPerformActivityIcon(activity);
        if (driver.findElements(By.xpath("//div[@aria-describedby ='alrtActivityPerform']//button[text() = 'OK']")).size() > 0) {
            commonPage.acceptAlrtActivityPerform.click();
        }
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.switchToNewWindow();
    }



    public void enterContract(String typeOfContract) throws InterruptedException {
        clickOnTab("Movement");
        SeleniumUtils.waitForPageLoad();
        commonPage.contractInput.sendKeys("AutoContract");
        Select contractType = new Select(commonPage.carrierContractType);
        contractType.selectByVisibleText(typeOfContract);
    }

    public void verifyStatusOfActivities() {
    }

    public List<String> getNonCompletedActivitiesTasks(List<String> activties) {
        List<String> noncompletedActivties = new ArrayList<>();
        return noncompletedActivties;
    }

    public List<String> getNonCompletedActivitiesDashboard(List<String> activties) {
        List<String> noncompletedActivties = new ArrayList<>();
        return noncompletedActivties;
    }
}
