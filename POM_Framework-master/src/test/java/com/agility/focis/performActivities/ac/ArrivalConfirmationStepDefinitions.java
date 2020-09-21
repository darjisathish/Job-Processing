package com.agility.focis.performActivities.ac;

import io.cucumber.java.en.And;

import java.io.IOException;

public class ArrivalConfirmationStepDefinitions {
    private ArrivalConfirmationSteps arrivalConfirmationSteps;

    public ArrivalConfirmationStepDefinitions() throws IOException {

        arrivalConfirmationSteps = new ArrivalConfirmationSteps();
    }

    @And("Performs Arrival Confirmation Activity")
    public void performsArrivalConfirmationActivity() {
    }
}
