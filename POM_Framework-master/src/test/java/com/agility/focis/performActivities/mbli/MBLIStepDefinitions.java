package com.agility.focis.performActivities.mbli;

import io.cucumber.java.en.And;

import java.io.IOException;

public class MBLIStepDefinitions {
    MBLISteps mbliSteps;

    public MBLIStepDefinitions() throws IOException {

        mbliSteps = new MBLISteps();
    }

    @And("Performs Master Bill of Lading Instructions Activity")
    public void performsMasterBillOfLadingInstructionsActivity() {
    }

}
