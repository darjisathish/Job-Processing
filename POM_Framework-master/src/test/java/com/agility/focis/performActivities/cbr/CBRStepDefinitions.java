package com.agility.focis.performActivities.cbr;

import io.cucumber.java.en.And;

import java.io.IOException;

public class CBRStepDefinitions {
    private CBRSteps cbrSteps;

    public CBRStepDefinitions() throws IOException {

        cbrSteps = new CBRSteps();
    }

    @And("Performs Carrier Booking Request Activity")
    public void performsCarrierBookingRequestActivity() throws InterruptedException {
        cbrSteps.enterContract("FAK");
        cbrSteps.performCBR();
    }

}
