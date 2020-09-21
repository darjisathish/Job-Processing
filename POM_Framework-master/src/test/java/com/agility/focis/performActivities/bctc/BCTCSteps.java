package com.agility.focis.performActivities.bctc;

import com.agility.focis.addCarriagesOcean.AddCarriagesOceanPage;
import com.agility.focis.performActivities.common.CommonSteps;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BCTCSteps extends CommonSteps {
    private WebDriver driver;
    BCTCPage bctcPage;
    AddCarriagesOceanPage addCarriagesOceanPage;

    public BCTCSteps() throws IOException {
        this.driver = getDriver();
        bctcPage = new BCTCPage(this.driver);
        addCarriagesOceanPage = new AddCarriagesOceanPage(this.driver);

    }

    public void performBCTC() throws InterruptedException {
        clickOnPerformActivityAndSwithToWindow("Booking Confirmation to Customer");
        if (isDialogPopulated("Customer/Cargo Mapping")) {
            bctcPage.buttonOnPopupOrDialog("Customer/Cargo Mapping", "Save and Continue").click();
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.switchToNewWindow();
        }
        clickOnaButton("Complete");
        if (isDialogPopulated("Warning","To view the document please click on Print button.")) {
            bctcPage.okButtonWarning("To view the document please click on Print button.");
        }
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.switchToParentWindow();
    }
}
