package com.agility.focis.performActivities.cbc;

import io.cucumber.java.en.And;

import java.io.IOException;

public class CBCStepDefinitions {
    private CBCSteps cbcSteps;

    public CBCStepDefinitions() throws IOException {

        cbcSteps = new CBCSteps();
    }

    @And("Performs Carrier Booking Confirmation Activity")
    public void performsCarrierBookingConfirmationActivity() throws InterruptedException {
        cbcSteps.performCBC();
    }

}
