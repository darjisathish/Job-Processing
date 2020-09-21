package com.agility.focis.performActivities.dc;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.performActivities.common.CommonSteps;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class DepartureConfirmationSteps extends CommonSteps {
    private WebDriver driver;
    DepartureConfirmationPage DepartureConfirmationPage;

    public DepartureConfirmationSteps() throws IOException {
        this.driver = getDriver();
        DepartureConfirmationPage = new DepartureConfirmationPage(this.driver);

    }

    public void performDC() {
    }
}
