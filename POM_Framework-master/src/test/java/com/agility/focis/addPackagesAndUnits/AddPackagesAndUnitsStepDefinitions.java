package com.agility.focis.addPackagesAndUnits;

import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddPackagesAndUnitsStepDefinitions {
    private AddPackagesAndUnitsSteps addPackagesAndUnitsSteps;

    public AddPackagesAndUnitsStepDefinitions() throws IOException {

        addPackagesAndUnitsSteps = new AddPackagesAndUnitsSteps();
    }

    @When("Adds Packages as below")
    public void addsAsBelow(List<Map<String, String>> packagesinfo) throws InterruptedException {
        addPackagesAndUnitsSteps.addOrEditMultiplePackages(packagesinfo);
    }

    @When("Edits Packages as below")
    public void editsAsBelow(List<Map<String, String>> packagesinfo) throws InterruptedException {
        addPackagesAndUnitsSteps.clickOnEditPackages();
        addPackagesAndUnitsSteps.addOrEditMultiplePackages(packagesinfo);
        addPackagesAndUnitsSteps.clickOnaButton("Save and Close");
        addPackagesAndUnitsSteps.checkForWarningAndCorrect(packagesinfo);
    }

    @When("Edits Units as below")
    public void edits_Units_as_below(List<Map<String, String>> unitsinfo) throws InterruptedException {
        addPackagesAndUnitsSteps.clickOnEditUnits();
        addPackagesAndUnitsSteps.addUnits(unitsinfo);
        addPackagesAndUnitsSteps.clickOnAButtonOnDialoOrPopup("Add Units", "Save and Close");
    }

    @When("Allocates Packages")
    public void allocates_Packages() throws InterruptedException {
        addPackagesAndUnitsSteps.allocatePackages();
    }

    @When("Edits Description of Goods")
    public void edits_Description_of_Goods() throws InterruptedException {
        addPackagesAndUnitsSteps.editDescriptionOfGoods();
    }

}
