package com.agility.focis.performActivities.sqsur;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.performActivities.common.CommonSteps;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SQSURSteps extends CommonSteps {
    private WebDriver driver;
    SQSURPage SQSURPage;

    public SQSURSteps() throws IOException {
        this.driver = getDriver();
        SQSURPage = new SQSURPage(this.driver);

    }
}
