package com.agility.focis.base;



import com.agility.focis.utilities.testObject.SeleniumUtils;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import net.sourceforge.tess4j.TesseractException;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;


@RunWith(Cucumber.class)
public class BaseStepDefinitions {
    private BaseSteps baseSteps;

    public BaseStepDefinitions() throws IOException {

        baseSteps = new BaseSteps();

    }

    @Given("User is logged into FOCiS Application")
    public void user_is_logged_into_FOCiS_Application() throws IOException, InterruptedException {
        baseSteps.loginToApp();
    }

    @When("selects {string} from {string} Menu")
    public void selectsFromMenu(String childMenu, String mainMenu) throws InterruptedException {
        baseSteps.selectMenu(childMenu, mainMenu);
    }

    @When("selects {string} from {string} from {string} Menu")
    public void selects_from_from_Menu(String childSubMenu, String childMenu, String mainMenu) throws InterruptedException {
        baseSteps.selectMenu(childSubMenu, childMenu, mainMenu);
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) throws InterruptedException {
        baseSteps.clickOnaButton(button);
    }

    @When("Clicks {string} Tab")
    public void clicksTab(String tabName) throws InterruptedException {
        baseSteps.clickOnTab(tabName);
    }

    // Method to Take a screenshot...
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverInstantiation.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        System.out.println(scenario.getStatus().toString());
    }

    @AfterStep
    public void performAfterEveryStep(Scenario scenario) {
        if (!SeleniumUtils.getMessageToPrint().equalsIgnoreCase("")) {
            scenario.write(SeleniumUtils.getMessageToPrint());
            SeleniumUtils.reInitializeLog();
        }
        if (SeleniumUtils.isCaptureSnap()) {
            final byte[] screenshot = ((TakesScreenshot) DriverInstantiation.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
            SeleniumUtils.reInitializeCaptureSnapFlag();
        }

    }

    @And("navigates to {string} Screen")
    public void navigatesToScreen(String stepDefScreenName) throws InterruptedException {
        if (stepDefScreenName.equalsIgnoreCase("Tasks") || stepDefScreenName.equalsIgnoreCase("Task")) {
            baseSteps.navigateToTasksScreen();
        } else if (stepDefScreenName.equalsIgnoreCase("Financial") || stepDefScreenName.equalsIgnoreCase("Estimates")) {
            baseSteps.navigateToFinancialScreen();
        } else if (stepDefScreenName.equalsIgnoreCase("Dashboard")) {
            baseSteps.navigateToDashboard();
        } else {
            SeleniumUtils.logInfo("Invalid Option");
        }
    }

    @And("navigates to {string} Screen for Job Number {string}")
    public void navigatesToScreenForJobNumber(String stepDefScreenName, String stepDefJobNumber) throws InterruptedException {
        if (stepDefScreenName.equalsIgnoreCase("Tasks") || stepDefScreenName.equalsIgnoreCase("Task")) {
            baseSteps.navigateToTasksScreen();
        } else if (stepDefScreenName.equalsIgnoreCase("Financial") || stepDefScreenName.equalsIgnoreCase("Estimates")) {
            baseSteps.navigateToFinancialScreen(stepDefJobNumber);
        } else if (stepDefScreenName.equalsIgnoreCase("Dashboard")) {
            baseSteps.navigateToDashboard();
        } else {
            SeleniumUtils.logInfo("Invalid Option");
        }
    }

    @Then("user should be able to read Captcha")
    public void userShouldBeAbleToReadCaptcha() throws TesseractException, IOException {
        baseSteps.readCaptcha();
    }

    @And("clicks on {string} button")
    public void clicksOnButton(String button) throws InterruptedException {
        baseSteps.clickOnButtonWithID(button);
    }

    @Then("application should throw {string} Error Message")
    public void applicationShouldThrowErrorMessage(String errorMessage) {
        baseSteps.verifyErrorMessage(errorMessage);
    }

    @Then("{string} button should be displayed")
    public void buttonShouldBeDisplayed(String button) {
        baseSteps.verifyButtonIsDisplayed(button);
    }
}
