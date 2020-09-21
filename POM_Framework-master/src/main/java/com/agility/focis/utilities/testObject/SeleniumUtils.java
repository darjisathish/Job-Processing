package com.agility.focis.utilities.testObject;

import com.agility.focis.base.DriverInstantiation;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class SeleniumUtils extends DriverInstantiation {
    private static String messageToPrint = "";
    private static boolean takeScreenShotFlag;
    private static String parentWindow;

    public static void waitForElementToVisible(WebElement element) {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .withTimeout(60, TimeUnit.SECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            fluentWait.until(ExpectedConditions.visibilityOf(element));

        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToVisible(WebElement element, int timeout) {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .withTimeout(timeout, TimeUnit.SECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            fluentWait.until(ExpectedConditions.visibilityOf(element));

        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void waitForElementToBeClickable(WebElement element) throws InterruptedException {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .withTimeout(60, TimeUnit.SECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            fluentWait.until(ExpectedConditions.elementToBeClickable(element));

        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToPresent(By locator) throws InterruptedException {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .withTimeout(60, TimeUnit.SECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));

        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForPageLoad() throws InterruptedException {
        ajaxComplete();
        waitUntilJSReady();
        waitUntilJQueryReady();
        waitForJQueryLoad();
    }


    private static void waitForJQueryLoad() {
        WebDriverWait jsWait = new WebDriverWait(driver, 60);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        try {
            ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) driver)
                    .executeScript("return jQuery.active") == 0);

            boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

            if (!jqueryReady) {
                jsWait.until(jQueryLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    private static void ajaxComplete() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("var callback = arguments[arguments.length - 1];"
                + "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
                + "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
                + "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
    }

    private static void waitUntilJQueryReady() {
        WebDriverWait jsWait = new WebDriverWait(driver, 60);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined) {
            poll(20);

            waitForJQueryLoad();

            poll(20);
        }
    }

    private static void poll(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitUntilJSReady() {
        WebDriverWait jsWait = new WebDriverWait(driver, 60);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        try {
            ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState").toString().equals("complete");

            boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");

            if (!jsReady) {
                jsWait.until(jsLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

    public static void waitForInvisibilityOfElement(WebElement element) throws InterruptedException {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .withTimeout(60, TimeUnit.SECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            fluentWait.until(ExpectedConditions.invisibilityOf(element));

        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForInvisibilityOfElement(WebElement element, int timeout) throws InterruptedException {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .withTimeout(timeout, TimeUnit.SECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            fluentWait.until(ExpectedConditions.invisibilityOf(element));

        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForTextToBePresentInElement(WebElement element, String text) throws InterruptedException {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .withTimeout(60, TimeUnit.SECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            fluentWait.until(ExpectedConditions.textToBePresentInElement(element, text));
            fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForFrameTobeAvailableAndSwitchToIt(WebElement element) {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .withTimeout(60, TimeUnit.SECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void checkForAlertAndAccept() {

        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .withTimeout(60, TimeUnit.SECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            fluentWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void waitForNumberOfElementsToBeMoreThan(By locator, int number) {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .withTimeout(60, TimeUnit.SECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            fluentWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeSelected(WebElement element) {
        try {
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .pollingEvery(1, TimeUnit.SECONDS)
                    .withTimeout(60, TimeUnit.SECONDS)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            fluentWait.until(ExpectedConditions.elementToBeSelected(element));
        } catch (TimeoutException toe) {
            toe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getEffectiveDateAfterDays(int numberOfDaysToAdd) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, numberOfDaysToAdd);
        Date updatedDate = c.getTime();
        return dateFormat.format(updatedDate);
    }

    public static String getEffectiveDateBeforeDays(int numberOfDaysToSubTract) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, numberOfDaysToSubTract);
        Date updatedDate = c.getTime();
        return dateFormat.format(updatedDate);
    }

    public static void selectDate(WebElement element, String date) {
        element.sendKeys(date + Keys.TAB);
    }

    public static void selectDate(WebElement element, int numberOfDaysToAdd) {

        element.sendKeys(getEffectiveDateAfterDays(numberOfDaysToAdd) + Keys.TAB);

    }

    public static void logInfo(String messagetoPrint) {
        messageToPrint = messageToPrint + messagetoPrint;
    }

    public static void reInitializeLog() {
        messageToPrint = "";
    }

    public static String getMessageToPrint() {
        return messageToPrint;
    }

    public static void takeScreenshot() {
        takeScreenShotFlag = true;
    }

    public static boolean isCaptureSnap() {
        return takeScreenShotFlag;
    }

    public static void reInitializeCaptureSnapFlag() {
        takeScreenShotFlag = false;
    }

    public static void setParentWindow(String windowHandle) {
        parentWindow = windowHandle;
    }

    public static void switchToNewWindow() throws InterruptedException {
        SeleniumUtils.setParentWindow(driver.getWindowHandle());
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        SeleniumUtils.waitForPageLoad();
    }

    public static void switchToParentWindow() throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        driver.close();
        driver.switchTo().window(parentWindow);
        driver.switchTo().defaultContent();
        SeleniumUtils.waitForPageLoad();
    }

    public static void compareMapsAndLogNotMatchingValues(Map<String, Map<String, String>> maptoCompareOne, Map<String, Map<String, String>> maptoCompareTwo) {
        Set<String> set = maptoCompareOne.keySet();
        for (String key : set) {
            if (!maptoCompareOne.get(key).equals(maptoCompareTwo.get(key))) {
                SeleniumUtils.logInfo(key + " details are not matched\nExpected :\n" + maptoCompareOne.get(key) + "\nActual :\n" + maptoCompareTwo.get(key));
            }

        }
    }

    public static String getCurrentTimeStampAsStrng() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static List<Integer> getDistinctRandomValuesInARage(int min, int max, int numberOfDistinctValues) {

        ArrayList<Integer> distinctValues = new ArrayList<Integer>();
        for (int i = min; i < max; i++) {
            distinctValues.add(i);
        }
        Collections.shuffle(distinctValues);
        return distinctValues.subList(0, numberOfDistinctValues);
    }

    public static void clearText(WebElement element) {
        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            String text = element.getAttribute("value");
            element.click();
            for (int i = 0; i < text.length(); i++) {

            }
        } else {
            element.sendKeys(Keys.CONTROL + Keys.chord("a"));
            element.sendKeys(Keys.DELETE);
        }
    }
    
    
    
    
    public static void waitForJQueryLoading() {
        WebDriverWait jsWait = new WebDriverWait(driver, 60);
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        try {
            ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) driver)
                    .executeScript("return jQuery.active") == 0);

            boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

            if (!jqueryReady) {
                jsWait.until(jQueryLoad);
            }
        } catch (WebDriverException ignored) {
        }
    }

}
