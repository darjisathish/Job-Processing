package com.agility.focis.performActivities.mbli;

import com.agility.focis.addPackagesAndUnits.AddPackagesAndUnitsSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.performActivities.cbr.CBRPage;
import com.agility.focis.performActivities.common.CommonSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MBLISteps extends CommonSteps {
    private WebDriver driver;
    MBLIPage mbliPage;
    CBRPage cbrPage;
    AddPackagesAndUnitsSteps addPackagesAndUnitsSteps;

    public MBLISteps() throws IOException {
        this.driver = getDriver();
        mbliPage = new MBLIPage(this.driver);
        cbrPage = new CBRPage(this.driver);
        addPackagesAndUnitsSteps = new AddPackagesAndUnitsSteps();

    }

    public void performMBLI() throws InterruptedException {
        clickOnPerformActivityAndSwithToWindow("Master Bill of Lading Instructions");
        if (isDialogPopulated("Warning", "Seal Number is required to perform Master Bill of Lading Instructions.")) {
            mbliPage.okButtonWarning("Seal Number is required to perform Master Bill of Lading Instructions.").click();
            addPackagesAndUnitsSteps.updateSealNumber();
            performMBLI();
        }
        if (isDialogPopulated("Warning", "A valid Unit number is mandatory to complete the activity")) {
            mbliPage.okButtonWarning("A valid Unit number is mandatory to complete the activity").click();
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.switchToNewWindow();
        }
        clickOnaButton("Complete");
        SeleniumUtils.waitForPageLoad();
        if (isDialogPopulated("Warning", "Special Characters are converted")) {
            mbliPage.alertButtonToComplete.click();
            SeleniumUtils.waitForPageLoad();
        }
        acceptWarningIfPopulated("To view the document, please click on Print button.");
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.switchToParentWindow();
    }
}
