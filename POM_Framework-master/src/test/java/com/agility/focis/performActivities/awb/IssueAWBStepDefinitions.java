package com.agility.focis.performActivities.awb;

import io.cucumber.java.en.When;

import java.io.IOException;

public class IssueAWBStepDefinitions {
    private IssueAWBSteps issueAWBSteps;

    public IssueAWBStepDefinitions() throws IOException {

        issueAWBSteps = new IssueAWBSteps();
    }
    @When("Performs Issue AWB Activity")
    public void performs_Issue_AWB_Activity() throws InterruptedException {
        issueAWBSteps.performAWB();
    }
}
