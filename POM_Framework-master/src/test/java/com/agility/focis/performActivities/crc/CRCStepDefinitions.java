package com.agility.focis.performActivities.crc;

import io.cucumber.java.en.And;

import java.io.IOException;

public class CRCStepDefinitions {
    private CRCSteps crcSteps;

    public CRCStepDefinitions() throws IOException {

        crcSteps = new CRCSteps();
    }

    @And("Performs Cargo Release to Customer Activity")
    public void performsCargoReleaseToCustomerActivity() {
    }
}
