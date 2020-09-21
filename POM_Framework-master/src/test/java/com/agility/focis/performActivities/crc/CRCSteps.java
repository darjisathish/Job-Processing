package com.agility.focis.performActivities.crc;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.performActivities.common.CommonSteps;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CRCSteps extends CommonSteps {
    private WebDriver driver;
    CRCPage CRCPage;

    public CRCSteps() throws IOException {
        this.driver = getDriver();
        CRCPage = new CRCPage(this.driver);

    }

    public void performCRC() {
    }
}
