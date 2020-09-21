package com.agility.focis.base;


import com.agility.focis.utilities.testObject.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "Login1_UserName")
    public WebElement userName;
    @FindBy(id = "Login1_Password")
    public WebElement password;
    @FindBy(id = "Login1_LoginButton")
    public WebElement signInButton;
    @FindBy(xpath = "//b[text() = 'No records to view']")
    public WebElement noRecordsToViewText;
    @FindBy(xpath = "//span[@class = 'ui-icon icon-refresh green']")
    public WebElement refreshIcon;


    public WebElement mainMenuOption(String mainMenuOption) {
        return driver.findElement(By.xpath("//a/span[text()='" + mainMenuOption + "']/.."));
    }

    public WebElement buttonTobeClicked(String button) {
        return driver.findElement(By.xpath("//*[text() = '" + button + "' or @title = '" + button + "']"));
    }

    public WebElement childMenuOption(String mainMenuOption, String childMenuOption) {
        return driver.findElement(By.xpath("//a/span[text()='" + mainMenuOption + "']/../following-sibling::ul//span[text()='" + childMenuOption + "']/.."));
    }

    public WebElement searchIconUsingLable(String lable) {
        return driver.findElement(By.xpath("//span[text()='" + lable + "']/../following-sibling::div//button"));
    }
    

    public WebElement inlineSearchUsingLabel(String label) {
        return driver.findElement(By.xpath("//span[text()='" + label + "']/../following-sibling::div//input[@profiledatamember='DESCRIPTION']"));

    }

    public WebElement closePopUpButton(String popUpTitle) {
        return driver.findElement(By.xpath("//span[text() ='" + popUpTitle + "']/../button[@class = 'ui-dialog-titlebar-close']"));

    }

    public WebElement tab(String tabname) {
        return driver.findElement(By.xpath("//a[normalize-space(text())='" + tabname + "' and @data-toggle = 'tab']"));
    }

    public WebElement buttonOnPopupOrDialog(String dialogName, String buttonName) {
        return driver.findElement(By.xpath("//span[text() = '" + dialogName + "']/ancestor::div[@role = 'dialog']//button[text() = '" + buttonName + "']"));
    }

    @FindBy(xpath = "//span[contains(@id,'ProdName')]")
    public WebElement verifyproduct;
    @FindBy(xpath = "//span[contains(@id,'ProdTypeName')]")
    public WebElement verifyProductType;
    @FindBy(xpath = "//select[contains(@id,'JobScope')]")
    public WebElement verifyjobscope;
    @FindBy(xpath = "//span[contains(@id,'JobNumber')]")
    public WebElement jobNumber;
    @FindBy(xpath = "//span[contains(@id,'BookingDetailsFr1_BookingDetailsFr1_lblStatusName')]")
    public WebElement jobStatus;

    @FindBy(id = "	")
    public WebElement advancedSearchInputBox;

    //    Auto Suggestion from Inline Search Popup
    public WebElement inlineSearchRecommendations(String text) {
        return driver.findElement(By.xpath("//ul/li/a[contains(text(),'" + text + "')]"));
    }

    //    iframe Locators
    @FindBy(xpath = "//div[contains(@class ,'iframe')]//a[@title = 'Close']")
    public WebElement closeIframeButton;

    //TextBox
    public WebElement searchPickerInputBox(String columnName) {
        columnName = columnName.replaceAll(" ", "");
        return driver.findElement(By.xpath("//input[contains(@id,'" + columnName + "')]"));
    }

    @FindBy(xpath = "//input[@name= 'STKNAMEANDADDRESS' or @name= 'STKNameAndAddress']")
    public WebElement stakeHolderNameOrID;
    
   

    public WebElement stkBestMatch(String stk) throws InterruptedException {
        SeleniumUtils.waitForPageLoad();
        SeleniumUtils.waitForNumberOfElementsToBeMoreThan(By.xpath("//a[contains(text(),'" + stk + "')]"), 0);
        WebElement element = null;
        if (driver.findElements(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Primary')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]")).size() > 0) {
            element = driver.findElement(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Primary')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]"));

        } else if (driver.findElements(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Collection')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]")).size() > 0) {
            element = driver.findElement(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Collection')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]"));
        } else if (driver.findElements(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Air WayBill')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]")).size() > 0) {
            element = driver.findElement(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'Air WayBill')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]"));
        } else if (driver.findElements(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'EDI')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]")).size() > 0) {
            element = driver.findElement(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'EDI')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]"));
        } else if (driver.findElements(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'General Supplier')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]")).size() > 0) {
            element = driver.findElements(By.xpath("//a[contains(text(), 'Financial details available - Yes') and contains(text(),'General Supplier')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]")).get(0);
        } else {
            element = driver.findElement(By.xpath("//a[contains(text(), 'Financial details available - No') and contains(text(),'Primary')]/../preceding-sibling::td/a[contains(text(),'" + stk + "')]"));
        }
        return element;

    }
    

    @FindBy(xpath = "//div[@role='dialog' and contains(@style,'display: block;')]//span[contains(@id,'pnlPopupGridPager')]")
    public WebElement pagesCount;
    @FindBy(xpath = "//div[@role = 'dialog' and not(@aria-describedby='AutomaticPrealert')]//button[text()= 'Ok']")
    public WebElement alertButtonToComplete;

    public WebElement okButtonWarning(String warningMessage) {
        return driver.findElement(By.xpath("//p[text() = '" + warningMessage + "']/ancestor::div[@role = 'dialog' and contains(@style,'display: block;')]//*[normalize-space(text())='OK'or normalize-space(text())='Ok']"));
    }

    //    Dialog
    public WebElement saveAndContinueOnDialog(String dialog) {
        return driver.findElement(By.xpath("//span[text() ='" + dialog + "']/ancestor::div[@role='dialog' and contains(@style,'display: block;')]//button[text() = 'Save and Continue']"));
    }

    public WebElement saveAndCloseOnDialog(String dialog) {
        return driver.findElement(By.xpath("//span[text() ='" + dialog + "']/ancestor::div[@role='dialog' and contains(@style,'display: block;')]//button[text() = 'Save and Close']"));
    }


    public WebElement closeDialogButton(String dialog) {
        return driver.findElement(By.xpath("//span[text() ='" + dialog + "']/ancestor::div[@role='dialog' and contains(@style,'display: block;')]//button[@class='ui-dialog-titlebar-close']"));
    }

    @FindBy(xpath = "//select[@class='ui-pg-selbox' and @role = 'listbox']")
    public WebElement paginationCount;

    public WebElement childSubMenuOption(String mainMenu, String childMenu, String childSubMenu) {
        return driver.findElement(By.xpath("//a/span[text()='" + mainMenu + "']/../following-sibling::ul//span[text()='" + childMenu + "']/../following-sibling::ul/li//span[text()='" + childSubMenu + "']/.."));
    }

    @FindBy(id = "gs_CurrencyCode")
    public WebElement currencyCodeInputBox;

    @FindBy(xpath = "//ul/li//span[text()='Home']/..")
    public WebElement homeButton;

    @FindBy(xpath = "//span[@class='ui-icon sp-JobIcon icon-coins_transparent']")
    public WebElement financialIcon;

    //Expand or Collapse Panel

    public WebElement expandOrCollapsePanelBody(String panelName) {
        return driver.findElement(By.xpath("//td[text()='" + panelName + "']/ancestor::table[1]//tr[@class='PWCTitledPanelBody']"));

    }

    public WebElement expandOrCollapsePanelIcon(String panelName) {
        return driver.findElement(By.xpath("//td[text()='" + panelName + "']/ancestor::table[1]//img"));
    }

    @FindBy(xpath = "//img[@class='BDC_CaptchaImage']")
    public WebElement captchaImage;

    public WebElement buttonWithID(String id) {
        return driver.findElement(By.xpath("//input[contains(@id,'" + id + "')]"));
    }

    @FindBy(xpath = "//span[text() ='Error']/ancestor::div[@role='dialog' and contains(@style,'block')]//p")
    public WebElement errorMessage;
    
    
    
    
    
    //**************************** Air - Carrier Contract
    
    @FindBy(xpath = "//*[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierContractLsUc_AFCarrierContractLsUc_btnOpenUploadPage']")
    public WebElement upload; 
    
    public WebElement uploadbuttonTobeClicked(String button) {
        return driver.findElement(By.xpath("//*[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierContractLsUc_AFCarrierContractLsUc_btnOpenUploadPage']"));
    }
    
    @FindBy(xpath = "//*[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_txtCountry_btnPopup']")
    public WebElement countrysearch;
    
    public WebElement countrysearchIconTobeClicked(String countrysearch) {
        return driver.findElement(By.xpath("//*[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_txtCountry_btnPopup']"));
    }

	
    @FindBy(xpath = "//*[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_UploadExcelFile']")
    public WebElement Excelupload; 
    
    public WebElement uploadExcelbuttonTobeClicked(String button) {
        return driver.findElement(By.xpath("//*[@id='PWCMasterPage_PWCWebPartManager_gwpAFCarrierUploadFrUc_AFCarrierUploadFrUc_UploadExcelFile']"));
    }
    public WebElement SelectProductType() {
    	//driver.findElement(By.xpath("//button[@data-id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_ddl_ProductType']"))
        return driver.findElement(By.xpath("//button[@data-id='PWCMasterPage_PWCWebPartManager_gwpQMRateSearchOceanShUc_QMRateSearchOceanShUc_ddl_ProductType']"));
    }
    
    
}
