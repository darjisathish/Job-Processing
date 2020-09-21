package com.agility.focis.financial;

import com.agility.focis.base.BaseSteps;
import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.*;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinancialSteps extends BaseSteps {
    private WebDriver driver;
    FinancialPage financialPage;

    public FinancialSteps() throws IOException {
        this.driver = getDriver();
        financialPage = new FinancialPage(this.driver);

    }

    public void addCharge(String chargeType, String chargeName) throws InterruptedException {
        financialPage.addNewChargeIcon.click();
        SeleniumUtils.waitForPageLoad();
        financialPage.chargeTypeInputBox(chargeType).sendKeys(chargeName + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        financialPage.addChargeButton(chargeType, chargeName).click();
        SeleniumUtils.waitForPageLoad();
        financialPage.addChargeDialogCloseButton.click();
        SeleniumUtils.waitForPageLoad();
    }

    public void updateSupplier(String chargeName, String supplierName) throws InterruptedException {
        financialPage.supplierSearchButton(chargeName).click();
        searchForSTK(supplierName);
        SeleniumUtils.waitForPageLoad();
    }

    public void updateCost(String chargeName, String cost) {
        financialPage.cost(chargeName).clear();
        financialPage.cost(chargeName).sendKeys(cost);
    }

    public void updateCostCurrency(String chargeName, String currency) throws InterruptedException {
        financialPage.costQuoationCurrencySearchButton(chargeName).click();
        SeleniumUtils.waitForPageLoad();
        selectCurrency(currency);
    }

    public void updateRevenue(String chargeName, String revnue) {
        financialPage.revenue(chargeName).clear();
        financialPage.revenue(chargeName).sendKeys(revnue);
    }

    public void saveFinancials() throws InterruptedException {
        financialPage.saveChargeButton.click();
        SeleniumUtils.waitForPageLoad();
    }

    public void updateRevenueCurrency(String chargeName, String currency) throws InterruptedException {
        financialPage.revenueQuoationCurrencySearchButton(chargeName).click();
        SeleniumUtils.waitForPageLoad();
        selectCurrency(currency);
    }

    public Map<String, String> getChargesOfASupplier(String stepSupplier) {
        List<Map<String, String>> charges = GlobalVariables.getCharges();
        Map<String, String> mapToReturn = new HashMap<>();
        for (Map<String, String> charge : charges) {
            String chargeName = charge.get("Charge Name");
            String supplier = charge.get("Supplier");
            String cost = charge.get("Cost");
            if (supplier.equalsIgnoreCase(stepSupplier)) {
                mapToReturn.put(chargeName, String.format("%.2f", Double.parseDouble(cost)));
            }

        }
        return mapToReturn;
    }


}
