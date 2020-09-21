package com.agility.focis.performActivities.dc;

import io.cucumber.java.en.And;

import java.io.IOException;

public class DepartureConfirmationStepDefinitions {
    private DepartureConfirmationSteps departureConfirmationSteps;

    public DepartureConfirmationStepDefinitions() throws IOException {

        departureConfirmationSteps = new DepartureConfirmationSteps();
    }

    @And("Performs Departure Confirmation Activity")
    public void performsDepartureConfirmationActivity() {
    }
}
