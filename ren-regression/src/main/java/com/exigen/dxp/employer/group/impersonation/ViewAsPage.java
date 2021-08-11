package com.exigen.dxp.employer.group.impersonation;

import com.exigen.dxp.DXPBasePage;
import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.DxpCommonMethods;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ViewAsPage {
    WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    public ViewAsPage(WebDriver driver){
        this.driver = driver;
        this.js = (JavascriptExecutor)driver;
        this.wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    }

    @FindBy(xpath = "//a[contains(@class, 'logo')]")
    private WebElement renLogo;

    @FindBy(xpath = "//a[@title='View Enrollees']")
    private WebElement viewEnrolleesIcon;

    @FindBy(xpath = "//a[text()='View as']")
    private WebElement viewAsLink;

    @FindBy(xpath = "//div[@role='dialog']")
    private WebElement popUp;

    @FindBy(xpath = "//span[text()='Subscriber ID']/ancestor::td")
    private List<WebElement> subscriberIds;

    @FindBy(xpath = "//label[text()='Search By']/following-sibling::div//div[contains(@class,'Select')]")
    private WebElement searchByDropDown;

    @FindBy(xpath = "//div[text()='Subscriber Id']")
    private WebElement subscriberOption;

    @FindBy(xpath = "//label[text()='Search a member to view as']/following-sibling::div//div[@class='Select-input']/input")
    private WebElement subscriberIdSearchInput;

    @FindBy(xpath = "//label[text()='Search a member to view as']/following-sibling::div//div[@role='option']")
    private WebElement subscriber;

    @FindBy(xpath = "//h2[text()='Products']")
    private WebElement checkViewAsEnrollee;

    @FindBy(xpath = "//div[contains(@class,'card')]//div[contains(@class,'itemBox')]//div[contains(@class,'title')]")
    private List<WebElement> productsAvailableForSubscriber;

    //@FindBy(xpath = "//a[@data-test='FORMS']")
    @FindBy(xpath = "//a[@data-test='DOCUMENTS']")
    private WebElement formsTab;

    @FindBy(xpath = "//a[@data-test='CLAIMS']")
    private WebElement claimsTab;

    @FindBy(xpath = "//h2[text()='Forms']")
    private WebElement formsPage;

    @FindBy(xpath = "//h2[text()='Claims']")
    private WebElement claimsPage;

    //@FindBy(xpath = "//label[text()='Functional Area']/following-sibling::div//div[contains(@class,'Select')]")
    @FindBy(xpath = "(//label[contains(text(),'Functional Area')]/following-sibling::div//div[contains(@class,'Select')])[1]")
    private WebElement functionalAreaDropDown;

    @FindBy(xpath = "//div[text()='Customer']")
    private WebElement customerOption;

    @FindBy(xpath = "//label[text()='Document Type']/following-sibling::div//div[contains(@class,'Select')]")
    private WebElement documentTypeDropDown;

    @FindBy(xpath = "//div[text()='EOI']")
    private WebElement eoiOption;

    @FindBy(xpath = "//label[text()='Document']/following-sibling::div//div[contains(@class,'Select')]//div[@aria-disabled='true']")
    private  WebElement documentDropdownDisabled;

    @FindBy(xpath = "//h2[text()='Coverages']")
    private WebElement coveragesPage;

    @FindBy(xpath = "//a[@title='View Coverage Details']")
    private WebElement viewCoverageDetailsIcon;

    @FindBy(xpath = "//h2[text()='Coverage Details']")
    private WebElement coverageDetailsPage;

    @FindBy(xpath = "//div[contains(@class,'tabsAside')]//a")
    private  List<WebElement> viewCoveragesTab;

    @FindBy(xpath = "//a[contains(@class,'sizeSmall')]")
    private WebElement backBtn;

    @FindBy(xpath = "//a[@title='View Plan Details']")
    private WebElement viewPlanDetailIcon;

    @FindBy(xpath = "//h2[text()='Plan Details']")
    private WebElement planDetailsPage;

    @FindBy(xpath = "//div[contains(@class,'tabsAside')]//a")
    private  List<WebElement> planDetailsTab;

    @FindBy(xpath = "//div[@class='dropdown ']")
    private WebElement myProfileDropdown;

    @FindBy(xpath = "//a[text()='My Profile']")
    private WebElement myProfileOption;

    @FindBy(xpath = "//h2[text()='My Profile']")
    private WebElement myProfilePage;

    @FindBy(xpath = "//a[text()='Upload form']")
    private WebElement uploadFormTab;

    @FindBy(xpath = "//div[contains(@class,'tabs')]/a")
    private List<WebElement> myProfileTabs;

    @FindBy(xpath = "//label")
    private List<WebElement> inputLabel;

    @FindBy(xpath = "//input")
    private List<WebElement> myProfileInput;

    @FindBy(xpath = "//a[text()='Stop Viewing']")
    private WebElement stopViewingAsEnrolleeBtn;

    @FindBy(xpath = "//h2[text()='Groups']")
    private WebElement groupsScreen;

    @FindBy(linkText = "Upload Document")
    private  WebElement uploadDocumentLink;

    @FindBy(xpath = "//button[.='Submit']")
    private  WebElement  submitButton;

    @FindBy(xpath = "//label[text()='Search a member']/following-sibling::div//div[@class='Select-input']/input")
    private WebElement SearchAMemberTextBox;
    @FindBy(xpath = "//label[text()='Search a member']/following-sibling::div//div[@role='option']")
    private WebElement subscriberAMember;


    private String subscriberId;

    public void clickOnViewAs(){
        DXPBaseTest.stimulateClick(renLogo);
        DXPBaseTest.highLighterMethod(viewEnrolleesIcon);
        viewEnrolleesIcon.click();
        DXPBaseTest.reportLog("Clicked On View as", 0);
        subscriberId = subscriberIds.get(subscriberIds.size() -1).getText();
        DXPBaseTest.stimulateClick(viewAsLink);
        wait.until(ExpectedConditions.visibilityOf(popUp));
    }

    public void searchWithSubscriberId(){
        DXPBaseTest.stimulateClick(searchByDropDown);
        DXPBaseTest.highLighterMethod(subscriberOption);
        subscriberOption.click();
        DXPBaseTest.reportLog("Selected 'Subscriber' as Search by dropdown", 1);
        subscriberIdSearchInput.sendKeys(subscriberId);
        DXPBaseTest.reportLog("Search for Subscriber ID " + subscriberId, 1);
        DXPBaseTest.highLighterMethod(subscriber);
        DXPBaseTest.reportLog("Selected Subscriber " + subscriber.getText() + " for Impersonation", 1);
        subscriber.click();
        wait.until(ExpectedConditions.visibilityOf(checkViewAsEnrollee));
    }

    public void verifyProductScreen(){
        DXPBaseTest.reportLog("View Products", 1);
        String products = "";
        for(WebElement prod : productsAvailableForSubscriber){
            products = products.concat( " ," + prod.getText());
        }
        DXPBaseTest.reportLog("Product Available for the Subscriber is " + products.replace(",", ""), 1);
    }

    public void verifyViewCourage(){
        DXPBaseTest.reportLog("View Coverage details", 1);
        DXPBaseTest.highLighterMethod(productsAvailableForSubscriber.get(0));
        productsAvailableForSubscriber.get(0).click();
        wait.until(ExpectedConditions.visibilityOf(coveragesPage));
        DXPBaseTest.reportLog("Coverage Screen navigated successfully", 1);
        DXPBaseTest.highLighterMethod(viewCoverageDetailsIcon);
        viewCoverageDetailsIcon.click();
        DXPBaseTest.reportLog("Verify View Coverage", 1);
        wait.until(ExpectedConditions.visibilityOf(coverageDetailsPage));
        DXPBaseTest.reportLog("Navigated to Coverage Details successfully", 1);
        for(WebElement tab : viewCoveragesTab){
            DXPBaseTest.logger.log(LogStatus.INFO, "View Coverage Details contains" + tab.getText() + "tab");
        }
        DXPBaseTest.highLighterMethod(backBtn);
        backBtn.click();
        wait.until(ExpectedConditions.visibilityOf(coveragesPage));
        DXPBaseTest.reportLog("Navigated back to Coverages Screen", 1);
        if(isElementVisible(viewPlanDetailIcon)){
            DXPBaseTest.highLighterMethod(viewPlanDetailIcon);
            viewPlanDetailIcon.click();
            wait.until(ExpectedConditions.visibilityOf(planDetailsPage));
            DXPBaseTest.reportLog("Navigated to Plan Details successfully", 1);
            for(WebElement tab : planDetailsTab){
                DXPBaseTest.logger.log(LogStatus.INFO, "View Plan Details contains " + tab.getText() + " tab");
            }
            DXPBaseTest.highLighterMethod(backBtn);
            backBtn.click();
            wait.until(ExpectedConditions.visibilityOf(coveragesPage));
            DXPBaseTest.reportLog("Navigated back to Coverages Screen", 1);
        }
    }

    public void verifyFormTab(){
        stopViewAsEnrollee();
        Waiters.SLEEP(5000).go();
        DXPBaseTest.stimulateClick(renLogo);
        Waiters.SLEEP(5000).go();
        DXPBaseTest.driver.navigate().refresh();
        Waiters.SLEEP(5000).go();
        DXPBaseTest.highLighterMethod(viewEnrolleesIcon);
        viewEnrolleesIcon.click();
        subscriberId = subscriberIds.get(subscriberIds.size() -1).getText();
        DXPBaseTest.reportLog("Clicked On UploadDocument", 0);
        DXPBaseTest.stimulateClick(uploadDocumentLink);
        Waiters.SLEEP(5000).go();
        DXPBaseTest.stimulateClick(searchByDropDown);
        DXPBaseTest.highLighterMethod(subscriberOption);
        Waiters.SLEEP(2000).go();
        subscriberOption.click();
        DXPBaseTest.reportLog("Selected 'Subscriber' as Search by dropdown", 1);
        SearchAMemberTextBox.sendKeys(subscriberId);
        DXPBaseTest.reportLog("Search for Subscriber ID " + subscriberId, 1);
        DXPBaseTest.highLighterMethod(subscriberAMember);
//        DXPBaseTest.reportLog("Selected Subscriber " + subscriberAMember.getText() + " for Impersonation", 1);
        Waiters.SLEEP(2000).go();
        subscriberAMember.click();
        DXPBaseTest.stimulateClick(submitButton);
        Waiters.SLEEP(5000).go();
        DXPBaseTest.stimulateClick(formsTab);
        DXPBaseTest.reportLog("Click on FORMS tab", 1);
        wait.until(ExpectedConditions.visibilityOf(formsPage));
        DXPBaseTest.reportLog("Verify Functional Area Dropdown is selectable", 1);
        DXPBaseTest.stimulateClick(functionalAreaDropDown);
        DXPBaseTest.highLighterMethod(customerOption);
        customerOption.click();
        DXPBaseTest.reportLog("Verify Document Type Dropdown is selectable", 1);
        DXPBaseTest.stimulateClick(documentTypeDropDown);
        DXPBaseTest.highLighterMethod(eoiOption);
        eoiOption.click();
        DXPBaseTest.reportLog("Verify Document Dropdown is disabled", 1);
        try {
            documentDropdownDisabled.isDisplayed();
            DXPBaseTest.reportLog("Document Dropdown is disabled", 1);
        }catch(Exception e){
            DXPBaseTest.logger.log(LogStatus.FAIL, "Document Dropdown is not displayed");
        }
        if(isElementVisible(uploadFormTab))
            DXPBaseTest.logger.log(LogStatus.FAIL, "Upload Form feature is available in Impersonation");
        else
            DXPBaseTest.reportLog("Upload Form feature is not displayed in Impersonation", 1);
    }

    public void verifyClaimsTab(){
        DXPBaseTest.stimulateClick(claimsTab);
        DXPBaseTest.reportLog("Click on CLAIMS tab", 1);
        wait.until(ExpectedConditions.visibilityOf(claimsPage));
    }

    public void verifyMyProfile(){
        DXPBaseTest.stimulateClick(myProfileDropdown);
        DXPBaseTest.highLighterMethod(myProfileOption);
        DXPBaseTest.reportLog("Click on My Profile option", 1);
        myProfileOption.click();
        wait.until(ExpectedConditions.visibilityOf(myProfilePage));
        DXPBaseTest.reportLog("Navigated to My Profile successfully", 1);
        myProfilePersonalInformation();
        myProfileSalaryInformation();
        myProfileContactInformation();
        myProfileIdCard();
    }

    public void stopViewAsEnrollee(){
        DXPBaseTest.reportLog("Stop View as Enrollee", 1);
        DXPBaseTest.highLighterMethod(stopViewingAsEnrolleeBtn);
        stopViewingAsEnrolleeBtn.click();
        wait.until(ExpectedConditions.visibilityOf(groupsScreen));
        DXPBaseTest.reportLog("Successfully stopped view as Enrollee", 1);
    }

    private void myProfilePersonalInformation(){
        DXPBaseTest.highLighterMethod(myProfileTabs.get(0));
        myProfileTabs.get(0).click();
        DXPBaseTest.reportLog("Selected Personal Information Tab", 1);
        for(int i = 0; i < inputLabel.size(); i++){
            DXPBaseTest.logger.log(LogStatus.INFO, inputLabel.get(i).getText() + " : " + myProfileInput.get(i).getAttribute("value"));
        }
    }

    private void myProfileSalaryInformation(){
        DXPBaseTest.highLighterMethod(myProfileTabs.get(1));
        myProfileTabs.get(1).click();
        DXPBaseTest.reportLog("Selected Salary Information Tab", 1);
        for(int i = 0; i < inputLabel.size(); i++){
            DXPBaseTest.logger.log(LogStatus.INFO, inputLabel.get(i).getText() + " : " + myProfileInput.get(i).getAttribute("value"));
        }
    }

    private void myProfileContactInformation(){
        DXPBaseTest.highLighterMethod(myProfileTabs.get(2));
        myProfileTabs.get(2).click();
        DXPBaseTest.reportLog("Selected Contact Information Tab", 1);
        for(int i = 0; i < inputLabel.size(); i++){
            DXPBaseTest.logger.log(LogStatus.INFO, inputLabel.get(i).getText() + " : " + myProfileInput.get(i).getAttribute("value"));
        }
    }

    private void myProfileIdCard(){
        DXPBaseTest.stimulateClick(myProfileDropdown);
        DXPBaseTest.highLighterMethod(myProfileOption);
        myProfileOption.click();
        DXPBaseTest.reportLog("Selected ID Card Tab", 1);
        File Path = null;
        try {
            Path = DXPBasePage.captureScreenshot(driver,"PrintIDCard" + DxpCommonMethods.currentDate());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String screenshotPath = Path.getPath();
        screenshotPath = screenshotPath.replace(System.getProperty("user.dir")+"/DXP/Execution Status/ScreenShots/"+DXPBaseTest.dxpPortal+"/", "");
        DXPBaseTest.logger.log(LogStatus.INFO, DXPBaseTest.logger.addScreenCapture(screenshotPath));
        wait.until(ExpectedConditions.visibilityOf(myProfileTabs.get(3)));
    }

/*    =====================================================================================  */

    private boolean isElementVisible(WebElement element) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        }
    }
}
