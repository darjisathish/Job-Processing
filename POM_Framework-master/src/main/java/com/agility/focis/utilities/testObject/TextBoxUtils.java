package com.agility.focis.utilities.testObject;

import com.agility.focis.base.DriverInstantiation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TextBoxUtils extends DriverInstantiation {
    private static WebElement textBoxInDiv(String lable) {
        return driver.findElement(By.xpath("//*[normalize-space(text()) ='" + lable + "']//input[@type = 'text']"));
    }

    private static WebElement textBoxWithLegend(String legend, String lable) {
        return driver.findElement(By.xpath("//legend[normalize-space(text()) ='" + legend + "']/..//span[normalize-space(text()) ='" + lable + "']/ancestor::div[1]//input[@type = 'text']"));
    }

    private static WebElement textBoxWithSpan(String lable) {
        return driver.findElement(By.xpath("//span[normalize-space(text()) ='" + lable + "' and (contains(@class,'span') or contains(@class,'Label') or contains(@data-bind,'text: FieldName'))]/ancestor::div[1]//input[@type = 'text']"));
    }

    private static String getTagNameOfTextBox(String lable) {

        return driver.findElement(By.xpath("//*[normalize-space(text()) ='" + lable + "'and (contains(@class,'span') or contains(@class,'Label') or contains(@data-bind,'text: FieldName'))]")).getTagName();

    }

    /*
     *    Re-Usable TextBoxUtils
     */

    public static String getText(String lable) {
        String textToReturn = "";
        if (getTagNameOfTextBox(lable).equalsIgnoreCase("span")) {
            if (textBoxWithSpan(lable).getText().equalsIgnoreCase("")) {
                textToReturn = textBoxWithSpan(lable).getAttribute("value");
            } else {
                textToReturn = textBoxWithSpan(lable).getText();
            }

        } else if (getTagNameOfTextBox(lable).equalsIgnoreCase("div")) {

            if (textBoxInDiv(lable).getText().equalsIgnoreCase("")) {
                textToReturn = textBoxInDiv(lable).getAttribute("value");
            } else {
                textToReturn = textBoxInDiv(lable).getText();
            }
        } else {

            System.err.println("No Elements returned with given " + lable + ", Implement new method");
        }
        if (textToReturn.equalsIgnoreCase("")) {
            textToReturn = getTextfromInputUsingJS(lable);
        }
        return textToReturn;
    }


    private static String getTextfromInputUsingJS(String lable) {
        WebElement element = null;
        if (getTagNameOfTextBox(lable).equalsIgnoreCase("span")) {
            element = textBoxWithSpan(lable);

        } else if (getTagNameOfTextBox(lable).equalsIgnoreCase("div")) {
            element = textBoxInDiv(lable);
        } else {

            System.err.println("No Elements returned with given " + lable + ", Implement new method");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;

        return (String) js.executeScript("return arguments[0].value", element);
    }

    private static String getTextfromInputUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        return (String) js.executeScript("return arguments[0].value", element);
    }
    

    public static String getText(String legend, String lable) {
        String textToReturn;
        if (textBoxWithLegend(legend, lable).getText().equalsIgnoreCase("")) {
            textToReturn = getTextfromInputUsingJS(textBoxWithLegend(legend, lable));
        } else {
            textToReturn = getTextfromInputUsingJS(textBoxWithLegend(legend, lable));
        }
        return textToReturn;
    }

    public static void setText(String lable, String text) {

        if (getTagNameOfTextBox(lable).equalsIgnoreCase("span")) {
            textBoxWithSpan(lable).clear();
            textBoxWithSpan(lable).sendKeys(text);

        } else if (getTagNameOfTextBox(lable).equalsIgnoreCase("div")) {
            textBoxInDiv(lable).clear();
            textBoxInDiv(lable).sendKeys(text);
        } else {

            System.err.println("No Elements returned with given " + lable + ", Implement new method");
        }
    }

}
