package com.agility.focis.utilities.testObject;

import com.agility.focis.base.DriverInstantiation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownUtils extends DriverInstantiation {

    public static void selectOptionByVisibleText(WebElement webElement, String option) {
        Select dropdown = new Select(webElement);
        dropdown.selectByVisibleText(option);
    }

    public static void selectOptionByVisibleText(String lable, String option) {
        List<WebElement> element = driver.findElements(By.xpath("//span[text()='" + lable + "']/../following-sibling::div//select"));
        Select dropdown = new Select(element.get(element.size()-1));
        dropdown.selectByVisibleText(option);
    }
}
