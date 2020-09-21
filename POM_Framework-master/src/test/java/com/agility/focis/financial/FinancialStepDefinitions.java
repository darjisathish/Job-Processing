package com.agility.focis.financial;

import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FinancialStepDefinitions {
    private FinancialSteps financialSteps;

    public FinancialStepDefinitions() throws IOException {

        financialSteps = new FinancialSteps();
    }
    @Given("adds Charges as below")
    public void adds_Charges_as_below(List<Map<String, String>> charges) throws InterruptedException {
        financialSteps.navigateToFinancialScreen();
        for (Map<String, String> charge : charges) {
            String chargeType = charge.get("Charge Type");
            String chargeName = charge.get("Charge Name");
            String supplier = charge.get("Supplier");
            String cost = charge.get("Cost");
            String costCurrency = charge.get("Cost Currency");
            String revenue = charge.get("Revenue");
            String revenueCurrency = charge.get("Revenue Currency");
            financialSteps.addCharge(chargeType, chargeName);
            financialSteps.updateSupplier(chargeName, supplier);
            financialSteps.updateCost(chargeName, cost);
            financialSteps.updateCostCurrency(chargeName, costCurrency);
            financialSteps.updateRevenue(chargeName, revenue);
            financialSteps.updateRevenueCurrency(chargeName, revenueCurrency);
            financialSteps.saveFinancials();
        }
        GlobalVariables.setCharges(charges);
    }
}