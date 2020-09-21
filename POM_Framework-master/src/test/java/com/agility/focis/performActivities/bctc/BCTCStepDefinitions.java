package com.agility.focis.performActivities.bctc;

import io.cucumber.java.en.And;

import java.io.IOException;

public class BCTCStepDefinitions {
    private BCTCSteps bctcSteps;

    public BCTCStepDefinitions() throws IOException {

        bctcSteps = new BCTCSteps();
    }

    @And("Performs Booking Confirmation to Customer Activity")
    public void performsBookingConfirmationToCustomerActivity() throws InterruptedException {
        bctcSteps.performBCTC();
    }
}
