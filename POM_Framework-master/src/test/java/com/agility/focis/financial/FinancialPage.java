package com.agility.focis.financial;

import com.agility.focis.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinancialPage extends BasePage {

    public FinancialPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[@id='add_CostGrid']//span[@class = 'ui-icon ui-icon icon-plus-sign purple']")
    public WebElement addNewChargeIcon;

    public WebElement chargeTypeInputBox(String chargeType) {
        return driver.findElement(By.xpath("//input[@id='gs_" + chargeType + "_ChargeName']"));
    }

    public WebElement addChargeButton(String chargeType, String chargeName) {
        if (chargeType.equalsIgnoreCase("International")) {
            chargeType = "Internantional";
        } else if (chargeType.equalsIgnoreCase("Destination")) {
            chargeType = "Dest";
        }
        

        return driver.findElements(By.xpath("//table[@id='" + chargeType + "ChrgJobGrid']//div[contains(text(),'" + chargeName + "')]/preceding-sibling::div[@title='Add Charge']")).get(0);
    }

    @FindBy(xpath = "//span[text()='Add Charges']/ancestor::div[@role='dialog']//button[@class='ui-dialog-titlebar-close']")
    public WebElement addChargeDialogCloseButton;

    public WebElement supplierSearchButton(String chargeName) {
        return driver.findElement(By.xpath("//td[@aria-describedby='CostGrid_LocalChargeName' and @title='" + chargeName + "']/..//td[@aria-describedby='CostGrid_CostFromDesc']//button"));
    }

    public WebElement cost(String chargeName) {
        return driver.findElement(By.xpath("//td[@aria-describedby='CostGrid_LocalChargeName' and @title='" + chargeName + "']/..//td[@aria-describedby='CostGrid_CostQ']//input"));
    }

    public WebElement revenue(String chargeName) {
        return driver.findElement(By.xpath("//td[@aria-describedby='CostGrid_LocalChargeName' and @title='" + chargeName + "']/..//td[@aria-describedby='CostGrid_RevQ']//input"));
    }

    public WebElement costQuoationCurrencySearchButton(String chargeName) {
        return driver.findElement(By.xpath("//td[@aria-describedby='CostGrid_LocalChargeName' and @title='" + chargeName + "']/..//td[@aria-describedby='CostGrid_CostQCny']//button"));
    }

    public WebElement revenueQuoationCurrencySearchButton(String chargeName) {
        return driver.findElement(By.xpath("//td[@aria-describedby='CostGrid_LocalChargeName' and @title='" + chargeName + "']/..//td[@aria-describedby='CostGrid_RevQCny']//button"));
    }

    @FindBy(xpath = "//input[contains(@id,'btnSavecharge')]")
    public WebElement saveChargeButton;

}
