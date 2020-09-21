package com.agility.focis.base;

import com.agility.focis.globalVariables.GlobalVariables;
import com.agility.focis.utilities.testObject.DynamicTableUtils;
import com.agility.focis.utilities.testObject.HyperLinkUtils;
import com.agility.focis.utilities.testObject.SeleniumUtils;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;


public class BaseSteps extends DriverInstantiation {
    private WebDriver driver;
    BasePage basePage;


    public BaseSteps() throws IOException {
        if (getDriver() == null) {
            setDriver();
        }
        this.driver = getDriver();
        basePage = new BasePage(this.driver);
    }

    public void loginToApp() throws IOException, InterruptedException {
        driver = getDriver();
        driver.get(loginURL());
        driver.manage().window().maximize();
        if (driver.findElements(By.id("Login1_UserName")).size() > 0) {
            basePage.userName.sendKeys(getUserName());
            basePage.password.sendKeys(getPassword());
            basePage.signInButton.click();
            SeleniumUtils.waitForPageLoad();
            if (!basePage.homeButton.isDisplayed()) {
                loginToApp();
            }
        } else {
            loginToApp();
        }
    }
    

    public void loginToApp(String userName, String password) throws IOException, InterruptedException {
        driver = getDriver();
        driver.get(loginURL());
        driver.manage().window().maximize();
        basePage.userName.sendKeys(userName);
        basePage.password.sendKeys(password);
        basePage.signInButton.click();
        SeleniumUtils.waitForPageLoad();
    }

    public void selectMenu(String childMenu, String mainMenu) throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        basePage.mainMenuOption(mainMenu).click();
        if (basePage.childMenuOption(mainMenu, childMenu).isDisplayed()) {
            basePage.childMenuOption(mainMenu, childMenu).click();
            SeleniumUtils.waitForPageLoad();
        } else {
            selectMenu(childMenu, mainMenu);
        }

    }

    public void selectMenu(String childSubMenu, String childMenu, String mainMenu) throws InterruptedException {
        Actions actions = new Actions(driver);
        SeleniumUtils.waitForPageLoad();
        basePage.mainMenuOption(mainMenu).click();
        if (basePage.childMenuOption(mainMenu, childMenu).isDisplayed()) {
            actions.moveToElement(basePage.childMenuOption(mainMenu, childMenu)).build().perform();
        } else {
            selectMenu(childSubMenu, childMenu, mainMenu);
        }

        if (basePage.childSubMenuOption(mainMenu, childMenu, childSubMenu).isDisplayed()) {
            basePage.childSubMenuOption(mainMenu, childMenu, childSubMenu).click();
            SeleniumUtils.waitForPageLoad();
        } else {
            selectMenu(childSubMenu, childMenu, mainMenu);
        }


    }

    public void clickOnaButton(String button) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.buttonTobeClicked(button));
        basePage.buttonTobeClicked(button).click();
        SeleniumUtils.waitForPageLoad();

    }


    public void clickOnTab(String tabName) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.tab(tabName));
        basePage.tab(tabName).click();
        SeleniumUtils.waitForPageLoad();
    }

    public void closePopupWindow(String popUPName) {
        basePage.closePopUpButton(popUPName).click();
    }

    public void clickOnAButtonOnDialoOrPopup(String popuName, String buttonName) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.buttonOnPopupOrDialog(popuName, buttonName));
        basePage.buttonOnPopupOrDialog(popuName, buttonName).click();
    }

   
    public void searchForSTK(String stkName) throws InterruptedException {
        boolean IsSTKSelected = false;
        for (int i = 0; i < 10; i++) {
            basePage.stakeHolderNameOrID.sendKeys(stkName + Keys.ENTER);
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.waitForElementToBeClickable(basePage.refreshIcon);
            if (Integer.parseInt(basePage.pagesCount.getText()) > 5) {
                basePage.stakeHolderNameOrID.sendKeys(Keys.ENTER);
                SeleniumUtils.waitForPageLoad();
            }
            if (driver.findElements(By.xpath("//b[text() = 'No records to view']")).size() > 0) {
                basePage.refreshIcon.click();
                SeleniumUtils.waitForElementToBeClickable(basePage.refreshIcon);
                searchForSTK(stkName);
            } else {
                SeleniumUtils.waitForPageLoad();
                GlobalVariables.setSupplierAddress(basePage.stkBestMatch(stkName).getText());
                basePage.stkBestMatch(stkName).click();
                SeleniumUtils.waitForPageLoad();
                IsSTKSelected = true;
                break;
            }
        }
        if (!IsSTKSelected) {
            SeleniumUtils.waitForElementToBeClickable(basePage.closePopUpButton("Stakeholders"));
            basePage.closePopUpButton("Stakeholders").click();
            SeleniumUtils.waitForPageLoad();
        }
    }
    

    public void acceptWarningIfPopulated(String warningMessage) throws InterruptedException {
        if (driver.findElements(By.xpath("//p[text() = '" + warningMessage + "']/ancestor::div[@role = 'dialog' and contains(@style,'display: block;')]")).size() > 0) {
            SeleniumUtils.waitForElementToBeClickable(basePage.okButtonWarning(warningMessage));
            basePage.okButtonWarning(warningMessage).click();
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();", basePage.okButtonWarning(warningMessage));
        }

    }

    public boolean isDialogPopulated(String dialog) throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        boolean flag = false;
        if (driver.findElements(By.xpath("//span[text() ='" + dialog + "']/ancestor::div[@role='dialog' and contains(@style,'display: block;')]")).size() != 0) {
            flag = true;
        }

        return flag;
    }

    public boolean isDialogPopulated(String dialog, String warningMesage) throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        boolean flag = false;
        if (driver.findElements(By.xpath("//span[text() ='" + dialog + "']/ancestor::div[@role='dialog' and contains(@style,'display: block;')]//p[contains(text(),'" + warningMesage + "')]")).size() != 0) {
            flag = true;
        }

        return flag;
    }

    public void navigateToTasksScreen() throws InterruptedException {
        String currentURL = driver.getCurrentUrl();
        if (currentURL.contains("bookingdetailsfrpg")) {

            clickOnTab("Tasks");
        } else if (currentURL.contains("advancedsearchfrpg")) {

        } else if (currentURL.contains("estimatesfrpg")) {

        } else if (currentURL.contains("stakeholderfrpg")) {

        } else if (currentURL.contains("dashboard")) {

            DynamicTableUtils.setText("JobNumber", "@Job Number:" + GlobalVariables.getJobNumber());
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.waitForElementToBeClickable(basePage.paginationCount);
            if (driver.findElements(By.xpath("//a[text() = '" + GlobalVariables.getJobNumber() + "']")).size() > 0) {

                driver.findElements(By.xpath("//a[text() = '" + GlobalVariables.getJobNumber() + "']")).get(0).click();
            } else {

//                fromMenu(GlobalVariable.JobNumber)
//                clickOnJobDetailsIcon(GlobalVariable.JobNumber)
//                navigateToTasksScreen()
            }
        } else {

            SeleniumUtils.switchToParentWindow();
            navigateToTasksScreen();
        }
        SeleniumUtils.waitForPageLoad();

        clickOnTab("Tasks");
    }

    public void navigateToDashboard() throws InterruptedException {
        String currentURL = driver.getCurrentUrl();
        if (currentURL.contains("dashboard")) {

            DynamicTableUtils.typeTextOnSearchPickerPopup("OpJobNumber", GlobalVariables.getJobNumber());
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.waitForElementToBeClickable(basePage.paginationCount);
            Select pagenationDropwDown = new Select(basePage.paginationCount);
            pagenationDropwDown.selectByVisibleText("50");
            SeleniumUtils.waitForPageLoad();
            DynamicTableUtils.typeTextOnSearchPickerPopup("OpJobNumber", GlobalVariables.getJobNumber());
            SeleniumUtils.waitForPageLoad();
        } else if (currentURL.contains("bookingdetailsfrpg") || currentURL.contains("advancedsearchfrpg") || currentURL.contains("stakeholderfrpg") || currentURL.contains("default")) {

            selectMenu("Dashboard", "Job");
            SeleniumUtils.waitForPageLoad();
            DynamicTableUtils.typeTextOnSearchPickerPopup("OpJobNumber", GlobalVariables.getJobNumber());
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.waitForElementToBeClickable(basePage.paginationCount);
            Select pagenationDropwDown = new Select(basePage.paginationCount);
            pagenationDropwDown.selectByVisibleText("50");
            SeleniumUtils.waitForPageLoad();
            DynamicTableUtils.typeTextOnSearchPickerPopup("OpJobNumber", GlobalVariables.getJobNumber());
            SeleniumUtils.waitForPageLoad();
        } else {

            SeleniumUtils.switchToParentWindow();
            navigateToDashboard();
        }
    }

    /*public void validateCompletedTasksOrEvents() {
        List<String> nonCompletedActivitiesDashboard = new ArrayList<>();
        List<String> nonCompletedActivitiesTasks = new ArrayList<>();
        if (driver.getCurrentUrl().contains("dashboard")) {
//            nonCompletedActivitiesDashboard = dashboard.EventsAndActivitiesValidations.getNonCompletedEventsOrActivities(GlobalVariables.getList());
//            nonCompletedActivitiesTasks = tasks.Activity.getNonCompletedEventsOrActivities(GlobalVariables.getList());
        }
//        else {
//            nonCompletedActivitiesTasks = tasks.Activity.getNonCompletedEventsOrActivities(GlobalVariables.getList())
//            nonCompletedActivitiesDashboard = dashboard.EventsAndActivitiesValidations.getNonCompletedEventsOrActivities(GlobalVariables.getList());
//        }
//
//        if (nonCompletedActivitiesTasks.size() > 0 || nonCompletedActivitiesDashboard.size() > 0) {
//            KeywordUtil.logInfo("Below Activities are not Completed\n")
//            KeywordUtil.logInfo("Dashboard: \n")
//            for (int i = 0; i < nonCompletedActivitiesDashboard.size(); i++) {
//
//                KeywordUtil.logInfo(GlobalVariables.getList().get(i))
//            }
//            KeywordUtil.logInfo("Tasks Screen: \n")
//            for (int j = 0; j < nonCompletedActivitiesTasks.size(); j++) {
//
//                KeywordUtil.logInfo(GlobalVariables.getList().get(j))
//            }
//            KeywordUtil.markFailed("")
//        } else {
//            KeywordUtil.logInfo("Below Activities are Completed at both End Points")
//            for (int i = 0; i < GlobalVariables.getList().size(); i++) {
//                KeywordUtil.logInfo(GlobalVariables.getList().get(i))
//            }
//        }
//    }
    }*/

    public void navigateToFinancialScreen() throws InterruptedException {
        if (driver.getCurrentUrl().contains("bookingdetailsfrpg")) {
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.waitForElementToBeClickable(basePage.financialIcon);
            basePage.financialIcon.click();
            SeleniumUtils.waitForPageLoad();
            SeleniumUtils.switchToNewWindow();
        } else if (driver.getCurrentUrl().contains("estimatesfrpg")) {
            System.out.println("Already in Estimates Screen");
        } else {
            navigateToFinancialScreen(GlobalVariables.getJobNumber());
        }
    }

    public void navigateToFinancialScreen(String JobNumber) throws InterruptedException {
        selectMenu("Advanced Search", "Job");
        basePage.advancedSearchInputBox.sendKeys(JobNumber + Keys.ENTER);
        DynamicTableUtils.clickOnIconUsingReferenceData("OperationalJobNumber", JobNumber, "coins");
        SeleniumUtils.switchToNewWindow();
    }

    public void selectCurrency(String currency) throws InterruptedException {
        basePage.currencyCodeInputBox.sendKeys(currency + Keys.ENTER);
        SeleniumUtils.waitForPageLoad();
        if (Integer.parseInt(basePage.pagesCount.getText()) > 1) {
            basePage.currencyCodeInputBox.sendKeys(Keys.ENTER);
            SeleniumUtils.waitForPageLoad();
        }
        HyperLinkUtils.clickOnLink(currency);
        SeleniumUtils.waitForPageLoad();
    }

    public void navigateHomePage() throws InterruptedException {
        if (driver.getCurrentUrl().contains("estimatesfrpg")) {
            SeleniumUtils.switchToParentWindow();
            basePage.homeButton.click();
            SeleniumUtils.waitForPageLoad();
        } else {
            basePage.homeButton.click();
            SeleniumUtils.waitForPageLoad();
        }
    }

    public void expandPanel(String panelName) throws InterruptedException {
        if (basePage.expandOrCollapsePanelBody(panelName).getAttribute("style").contains("none")) {
            basePage.expandOrCollapsePanelIcon(panelName).click();
            SeleniumUtils.waitForPageLoad();

        }
    }

    public void collapsePanel(String panelName) throws InterruptedException {
        if (basePage.expandOrCollapsePanelBody(panelName).getAttribute("style").contains("display: table-row;")) {
            basePage.expandOrCollapsePanelIcon(panelName).click();
            SeleniumUtils.waitForPageLoad();

        }
    }

    public void readCaptcha() throws TesseractException, IOException {
//        String src =  basePage.captchaImage.getAttribute("src");
//        BufferedImage bufferedImage = ImageIO.read(new URL(src));
        File outputfile = new File("src/test/resources/drivers/BotDetectCaptcha.jpeg");
//        ImageIO.write(bufferedImage, "png", outputfile);

        // get the Tesseract direct interace
        Tesseract instance = new Tesseract();

        // the doOCR method of Tesseract will retrive the text
        // from image captured by Selenium
        String result = instance.doOCR(outputfile);
        System.out.println(result);


    }

    public void clickOnButtonWithID(String id) throws InterruptedException {
        basePage.buttonWithID(id).click();
        SeleniumUtils.waitForPageLoad();
    }

    public void navigateToManagePIVPage() throws InterruptedException {
        if (driver.getCurrentUrl().contains("managepivlspg")) {
            System.out.println("Already On Manage PIV Page");
        } else {
            navigateHomePage();
            selectMenu("Purchase Invoice/Credit", "Purchase Invoice/Credit/Fast Check", "Job");
        }
    }

    public void verifyErrorMessage(String errorMessage) {
        Assert.assertTrue("Expected :" + errorMessage + "\nActual :" + basePage.errorMessage.getText(), errorMessage.equalsIgnoreCase(basePage.errorMessage.getText()));
        SeleniumUtils.takeScreenshot();
    }

    public void verifyButtonIsDisplayed(String button) {
        Assert.assertTrue(basePage.buttonTobeClicked(button).isDisplayed());
    }
    
    
  //********************************Air Carrier Contract*******************  
    
    public void clickOnaUploadButton(String upload) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.uploadbuttonTobeClicked(upload));
        basePage.uploadbuttonTobeClicked(upload).click();
        SeleniumUtils.waitForPageLoad();
        
    }
    
    public void verifyButtonIsDisplayedorNot(String button) {
        Assert.assertTrue(basePage.uploadbuttonTobeClicked(button).isDisplayed());
    }
    
    
    public void clickOnExcelButton(String upload) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.uploadExcelbuttonTobeClicked(upload));
        basePage.uploadExcelbuttonTobeClicked(upload).click();
        SeleniumUtils.waitForPageLoad();
    }
    
   /* 
    public void clickOnCountrySearchiocn(String countrysearch) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.countrysearchIconTobeClicked(countrysearch));
        basePage.countrysearchIconTobeClicked(countrysearch).click();
        SeleniumUtils.waitForPageLoad();
    }*/
    
    /*public void selctCountryName(String selectCountryName) throws InterruptedException {
        SeleniumUtils.waitForElementToBeClickable(basePage.selectCountryName(selectCountryName));
        basePage.countrysearchIconTobeClicked(selectCountryName).click();
        SeleniumUtils.waitForPageLoad();
    }*/
    
    
}
