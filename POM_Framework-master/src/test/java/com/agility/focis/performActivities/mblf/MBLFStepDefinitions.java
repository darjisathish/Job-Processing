package com.agility.focis.performActivities.mblf;

import io.cucumber.java.en.And;

import java.io.IOException;

public class MBLFStepDefinitions {
    private MBLFSteps mblfSteps;

    public MBLFStepDefinitions() throws IOException {

        mblfSteps = new MBLFSteps();
    }

    @And("Performs Final Master Bill of Lading Activity")
    public void performsFinalMasterBillOfLadingActivity() {
    }

}
