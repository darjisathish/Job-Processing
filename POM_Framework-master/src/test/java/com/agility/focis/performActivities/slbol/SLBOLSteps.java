package com.agility.focis.performActivities.slbol;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.performActivities.common.CommonSteps;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SLBOLSteps extends CommonSteps {
    private WebDriver driver;
    SLBOLPage SLBOLPage;

    public SLBOLSteps() throws IOException {
        this.driver = getDriver();
        SLBOLPage = new SLBOLPage(this.driver);

    }

    public void perfomSLBOL() {
    }
}
