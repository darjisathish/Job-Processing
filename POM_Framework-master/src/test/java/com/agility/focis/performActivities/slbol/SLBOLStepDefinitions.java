package com.agility.focis.performActivities.slbol;

import io.cucumber.java.en.And;

import java.io.IOException;

public class SLBOLStepDefinitions {
    private SLBOLSteps slbolSteps;

    public SLBOLStepDefinitions() throws IOException {

        slbolSteps = new SLBOLSteps();
    }


    @And("Performs Seaquest Line Bill of Lading Activity")
    public void performsSeaquestLineBillOfLadingActivity() {
    }
}
