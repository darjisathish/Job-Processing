package com.agility.focis.performActivities.mblf;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.performActivities.common.CommonSteps;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MBLFSteps extends CommonSteps {
    private WebDriver driver;
    MBLFPage MBLFPage;

    public MBLFSteps() throws IOException {
        this.driver = getDriver();
        MBLFPage = new MBLFPage(this.driver);

    }

    public void performMBLF() {
    }
}
