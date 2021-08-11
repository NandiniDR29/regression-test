package com.exigen.dxp.employer.group.viewGroupDetail;

import com.exigen.dxp.DXPBaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;

public class ViewGroupDetailPage {
    WebDriver driver;
    WebDriverWait elementWait;

    @FindBy(css = "a[title='View Group Details']")
    List<WebElement> viewGroupDetail;

    @FindBy(xpath = "//h2[text()='Group Details']")
    WebElement groupDetailScreen;

    @FindBy(xpath = "//h3[contains(@class,'title')]/span[2]")
    WebElement groupName;

    @FindBy(xpath = "//h3[contains(@class,'title')]/span[3]")
    WebElement groupNumber;

    @FindBy(xpath = "//td[text()='FICA Report']/following-sibling::td/div[text()='Download']")
    WebElement ficaReportDownload;

    @FindBy(xpath = "//h2[text()='Forms']")
    WebElement formsScreen;

    @FindBy(xpath = "//a[contains(@class,'logo')]")
    WebElement goToLandingPage;

    @FindBy(xpath = "//div[text()='Customer Number']/parent::td")
    WebElement getCustomerNumber;

    @FindBy(xpath = "//div[text()='First Name']/parent::td")
    WebElement getFirstName;

    @FindBy(xpath = "//div[text()='Last Name']/parent::td")
    WebElement getLastName;

    @FindBy(xpath = "//a[@title='View Contact Person']")
    WebElement viewContactPersonDetails;

    @FindBy(xpath = "//h2[text()='Contact Person Details']")
    WebElement contactPersonDetailsScreen;

    @FindBy(xpath = "//div[text()='Personal Information']/following-sibling::div//table/tbody/tr[1]/td[2]")
    WebElement contactPersonFirstName;

    @FindBy(xpath = "//div[text()='Personal Information']/following-sibling::div//table/tbody/tr[3]/td[2]")
    WebElement contactPersonLastName;

    @FindBy(xpath = "//div[text()='Personal Information']/following-sibling::div//table/tbody/tr/td[1]")
    List<WebElement> contactPersonInformationHeader;

    @FindBy(xpath = "//div[text()='Personal Information']/following-sibling::div//table/tbody/tr/td[2]")
    List<WebElement> contactPersonInformationValue;

    @FindBy(xpath = "//div[text()='Address']/following-sibling::div//table/tbody/tr/td[1]")
    List<WebElement> contactPersonAddressHeader;

    @FindBy(xpath = "//div[text()='Address']/following-sibling::div//table/tbody/tr/td[2]")
    List<WebElement> contactPersonAddressValue;

    @FindBy(xpath = "//div[text()='Email']/../../following-sibling::div//table/tbody/tr/td[1]")
    List<WebElement> contactPersonEmailHeader;

    @FindBy(xpath = "//div[text()='Email']/../../following-sibling::div//table/tbody/tr/td[2]")
    List<WebElement> contactPersonEmailValue;

    @FindBy(xpath = "//div[text()='Phone']/../../following-sibling::div//table/tbody/tr/td[1]")
    List<WebElement> contactPersonPhoneHeader;

    @FindBy(xpath = "//div[text()='Phone']/../../following-sibling::div//table/tbody/tr/td[2]")
    List<WebElement> contactPersonPhoneValue;

    @FindBy(xpath = "//div[text()='Email']/following-sibling::div")
    WebElement editContactPersonEmail;

    @FindBy(xpath = "//div[@role='dialog']")
    WebElement editModal;

    @FindBy(xpath = "//input[@data-test='email']")
    WebElement emailTextBox;

    @FindBy(xpath = "//button[@data-test='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//div[text()='Phone']/following-sibling::div")
    WebElement editContactPersonPhone;

    @FindBy(xpath = "//input[@data-test='phone']")
    WebElement phoneTextBox;

    @FindBy(css = "div.Select")
    WebElement editContactPhoneType;

    @FindBy(xpath = "//div[text()='Business Work']")
    WebElement phoneTypeBusinessWork;

    @FindBy(xpath = "//a[text()='Group Details']")
    WebElement groupDetailLink;

    @FindBy(xpath = "//td[text()='Billing']/following-sibling::td//div[contains(@class,'checkedCircle')]/../following-sibling::div")
    private WebElement billingCommunicatePreference;

    @FindBy(xpath = "//td[text()='Billing']/following-sibling::td")
    private WebElement communicatePreference;

    @FindBy(xpath = "//td[text()='Administrative']/following-sibling::td//div[contains(@class,'checkedCircle')]/../following-sibling::div")
    private WebElement administrativeCommunicatePreference;

    @FindBy(xpath = "//td[text()='Claims']/following-sibling::td//div[contains(@class,'checkedCircle')]/../following-sibling::div")
    private WebElement claimCommunicatePreference;

    @FindBy(xpath = "//td[text()='Administrative']/following-sibling::td//div[text()='Paper']/../div[contains(@class,'radio')]")
    private WebElement administrativePaperRadioBtn;

    @FindBy(xpath = "//td[text()='Administrative']/following-sibling::td//div[text()='Paperless']/../div[contains(@class,'radio')]")
    private WebElement administrativePaperLessRadioBtn;

    @FindBy(xpath = "//td[text()='Billing']/following-sibling::td//div[text()='Paper']/../div[contains(@class,'radio')]")
    private WebElement billingPaperRadioBtn;

    @FindBy(xpath = "//td[text()='Billing']/following-sibling::td//div[text()='Paperless']/../div[contains(@class,'radio')]")
    private WebElement billingPaperLessRadioBtn;

    @FindBy(xpath = "//td[text()='Claims']/following-sibling::td//div[text()='Paper']/../div[contains(@class,'radio')]")
    private WebElement claimPaperRadioBtn;

    @FindBy(xpath = "//td[text()='Claims']/following-sibling::td//div[text()='Paperless']/../div[contains(@class,'radio')]")
    private WebElement claimPaperLessRadioBtn;

    @FindBy(xpath = "//small[contains(@class,'spinnerPill')]")
    private WebElement ajaxLoading;

    public ViewGroupDetailPage(WebDriver driver) {
        this.driver = driver;
        elementWait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
    }

    public void clickOnViewGroupDetail() {
        highLighterMethod(viewGroupDetail.get(0));
        viewGroupDetail.get(0).click();
        reportLog("Click on View Group Details", 0);
        elementWait.until(ExpectedConditions.visibilityOf(groupDetailScreen));
    }

    public void verifyGroupName(String gName) {
        highLighterMethod(groupName);
        if (gName.equalsIgnoreCase(groupName.getText()))
            DXPBaseTest.reportLog("Group Name verified and the Group Name is " + groupName.getText(), 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Group Name is not matching compare with " + gName + " and the Actual Group Name is" + groupName.getText());
    }

    public void verifyFicaReportDownload() {
        if (ficaReportDownload.isDisplayed()) {
            DXPBaseTest.reportLog("FICA report download is available", 1);
            highLighterMethod(ficaReportDownload);
            ficaReportDownload.click();
            elementWait.until(ExpectedConditions.visibilityOf(formsScreen));
            DXPBaseTest.reportLog("FICA report download Navigated to Forms Screen", 1);
            DXPBaseTest.stimulateClick(goToLandingPage);
        } else {
            DXPBaseTest.logger.log(LogStatus.FAIL, "FICA report download is not available");
        }
    }

    public void verifyContactCustomerNumber(String customerNumber) {
        highLighterMethod(getCustomerNumber);
        if (customerNumber.equals(getCustomerNumber.getText()))
            DXPBaseTest.reportLog("Relation Customer Number verified with EIS Relationship ID", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Relation Customer Number is not same as EIS Relationship ID");
    }

    public void verifyContactFirstName(String firstName) {
        highLighterMethod(getFirstName);
        if (firstName.equals(getFirstName.getText()))
            DXPBaseTest.reportLog("Relation First Name verified with EIS Relationship First Name", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Relation First Name is not same as EIS Relationship First Name");
    }

    public void verifyContactLastName(String lastName) {
        highLighterMethod(getLastName);
        if (lastName.equals(getLastName.getText()))
            DXPBaseTest.reportLog("Relation Last Name verified with EIS Relationship Last Name", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Relation Last Name is not same as EIS Relationship Last Name");
    }

    public void verifyGroupNumber(String gNumber) {
        highLighterMethod(groupNumber);
        if (gNumber.equalsIgnoreCase(groupNumber.getText().replace("|", "")))
            DXPBaseTest.reportLog("Group Number verified and the Group Number is " + groupNumber.getText().replace("|", ""), 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Group Number is not matching compare with " + gNumber + " and the Actual Group Number is" + groupNumber.getText());
    }

    public void viewContactPerson() {
        highLighterMethod(viewContactPersonDetails);
        viewContactPersonDetails.click();
        DXPBaseTest.reportLog("View Contact Person details", 1);
        elementWait.until(ExpectedConditions.visibilityOf(contactPersonDetailsScreen));
    }

    public void verifyContactPersonInformation(String firstName, String lastName) {
        if (firstName.equals(contactPersonFirstName.getText()))
            DXPBaseTest.reportLog("Contact Person First Name Verified", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Contact Person First Name validation failed");

        if (lastName.equals(contactPersonLastName.getText()))
            DXPBaseTest.reportLog("Contact Person First Name Verified", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Contact Person First Name validation failed");

        for (int i = 0; i < contactPersonInformationHeader.size(); i++) {
            highLighterMethod(contactPersonInformationValue.get(i));
            removeHighLighterMethod(contactPersonInformationValue.get(i));
            System.out.println(new Date().toString() + " | " + contactPersonInformationHeader.get(i).getText() + "\t: " + contactPersonInformationValue.get(i).getText());
            DXPBaseTest.logger.log(LogStatus.INFO, contactPersonInformationHeader.get(i).getText() + "\t: " + contactPersonInformationValue.get(i).getText());
        }
    }

    public void contactPersonAddressDetail() {
        for (int i = 0; i < contactPersonAddressValue.size(); i++) {
            highLighterMethod(contactPersonAddressValue.get(i));
            removeHighLighterMethod(contactPersonAddressValue.get(i));
            System.out.println(new Date().toString() + " | " + contactPersonAddressHeader.get(i).getText() + "\t: " + contactPersonAddressValue.get(i).getText());
            DXPBaseTest.logger.log(LogStatus.INFO, contactPersonAddressHeader.get(i).getText() + "\t: " + contactPersonAddressValue.get(i).getText());
        }
    }

    public void contactPersonEmailDetail() {
        js.executeScript("arguments[0].scrollIntoView();", contactPersonEmailValue.get(0));
        for (int i = 0; i < contactPersonEmailHeader.size(); i++) {
            highLighterMethod(contactPersonEmailValue.get(i));
            removeHighLighterMethod(contactPersonEmailValue.get(i));
            System.out.println(new Date().toString() + " | " + contactPersonEmailHeader.get(i).getText() + "\t: " + contactPersonEmailValue.get(i).getText());
            DXPBaseTest.logger.log(LogStatus.INFO, contactPersonEmailHeader.get(i).getText() + "\t: " + contactPersonEmailValue.get(i).getText());
        }
    }

    public void contactPersonPhoneDetail() {
        js.executeScript("arguments[0].scrollIntoView();", contactPersonPhoneValue.get(0));
        for (int i = 0; i < contactPersonPhoneHeader.size(); i++) {
            highLighterMethod(contactPersonPhoneValue.get(i));
            removeHighLighterMethod(contactPersonPhoneValue.get(i));
            System.out.println(new Date().toString() + " | " + contactPersonPhoneHeader.get(i).getText() + "\t: " + contactPersonPhoneValue.get(i).getText());
            DXPBaseTest.logger.log(LogStatus.INFO, contactPersonPhoneHeader.get(i).getText() + "\t: " + contactPersonPhoneValue.get(i).getText());
        }
    }

    public void editContactPersonEmail() {
        js.executeScript("arguments[0].scrollIntoView();", editContactPersonEmail);
        DXPBaseTest.stimulateClick(editContactPersonEmail);
        DXPBaseTest.reportLog("Contact Person Email Edit button clicked", 1);
        elementWait.until(ExpectedConditions.visibilityOf(editModal));
        emailTextBox.clear();
        DXPBaseTest.sendText(emailTextBox, "regression@test.com");
        highLighterMethod(submitBtn);
        submitBtn.click();
        waitForElementToInvisible(editModal, 60);
        Actions act = new Actions(driver);
        act.pause(3000).build().perform();
        if (contactPersonEmailValue.get(0).getText().equals("regression@test.com")) {
            DXPBaseTest.reportLog("Contact Person Email update Success", 1);
        } else {
            System.out.println(new Date().toString() + " | " + "Contact Person Email update Failed " + contactPersonEmailValue.get(0).getText());
            DXPBaseTest.logger.log(LogStatus.FAIL, "Contact Person Email update Failed");
        }
    }

    public void editContactPersonPhone() {
        js.executeScript("arguments[0].scrollIntoView();", editContactPersonPhone);
        DXPBaseTest.stimulateClick(editContactPersonPhone);
        DXPBaseTest.reportLog("Contact Person Phone Edit button clicked", 1);
        elementWait.until(ExpectedConditions.visibilityOf(editModal));
        phoneTextBox.clear();
        DXPBaseTest.sendText(phoneTextBox, "8888888888");
        builder.moveToElement(editContactPhoneType).pause(500).click(editContactPhoneType).pause(1000).build().perform();
        builder.moveToElement(phoneTypeBusinessWork).pause(500).click(phoneTypeBusinessWork).pause(1000).build().perform();
        highLighterMethod(submitBtn);
        submitBtn.click();
        waitForElementToInvisible(editModal, 60);
        Actions act = new Actions(driver);
        act.pause(3000).build().perform();
        if (contactPersonPhoneValue.get(0).getText().equals("(888) 888-8888")) {
            DXPBaseTest.reportLog("Contact Person Phone update Success", 1);
        } else {
            System.out.println(new Date().toString() + " | " + "Contact Person Phone update Failed " + contactPersonPhoneValue.get(0).getText());
            DXPBaseTest.logger.log(LogStatus.FAIL, "Contact Person Phone update Failed");
        }
    }

    public void communicationPreferencesDetails() {
        js.executeScript("arguments[0].scrollIntoView();", communicatePreference);
        if (isElementVisible(billingCommunicatePreference))
            reportLog("Billing Communication Preference selected " + billingCommunicatePreference.getText(), 1);
        else
            logger.log(LogStatus.INFO, "Billing Communication is not selected");
        if (isElementVisible(administrativeCommunicatePreference))
            reportLog("Administrative Communication Preference selected " + billingCommunicatePreference.getText(), 1);
        else
            logger.log(LogStatus.INFO, "Administrative Communication is not selected");
        if (isElementVisible(claimCommunicatePreference))
            reportLog("Claim Communication Preference selected " + billingCommunicatePreference.getText(), 1);
        else
            logger.log(LogStatus.INFO, "Claim Communication is not selected");
    }

    public void editCommunicationPreferences() {
        js.executeScript("arguments[0].scrollIntoView();", communicatePreference);
        reportLog("Edit Administrative Communication Preferences ", 1);
        if (isElementVisible(administrativeCommunicatePreference)) {
            if (administrativeCommunicatePreference.getText().equals("Paperless")) {
                stimulateClick(administrativePaperRadioBtn);
                reportLog("Selected Paper for Administrative", 1);
            } else {
                stimulateClick(administrativePaperLessRadioBtn);
                reportLog("Selected Paperless for Administrative", 1);
            }
        } else {
            stimulateClick(administrativePaperLessRadioBtn);
            reportLog("Selected Paperless for Administrative", 1);
        }
        waitForElementToInvisible(ajaxLoading, 70);

        reportLog("Edit Billing Communication Preferences ", 1);
        if (isElementVisible(billingCommunicatePreference)) {
            if (billingCommunicatePreference.getText().equals("Paperless")) {
                stimulateClick(billingPaperRadioBtn);
                reportLog("Selected Paper for Billing", 1);
            } else {
                stimulateClick(billingPaperLessRadioBtn);
                reportLog("Selected Paperless for Billing", 1);
            }
        } else {
            stimulateClick(billingPaperLessRadioBtn);
            reportLog("Selected Paperless for Billing", 1);
        }
        waitForElementToInvisible(ajaxLoading, 70);

        reportLog("Edit Claim Communication Preferences ", 1);
        if (isElementVisible(claimCommunicatePreference)) {
            if (claimCommunicatePreference.getText().equals("Paperless")) {
                stimulateClick(claimPaperRadioBtn);
                reportLog("Selected Paper for Claim", 1);
            } else {
                stimulateClick(claimPaperLessRadioBtn);
                reportLog("Selected Paperless for Claim", 1);
            }
        } else {
            stimulateClick(claimPaperLessRadioBtn);
            reportLog("Selected Paperless for Claim", 1);
        }
        waitForElementToInvisible(ajaxLoading, 70);
        builder.pause(3000).build().perform();
        highLighterMethod(groupDetailLink);
        groupDetailLink.click();
    }

    //=========================================================================================================

    public void waitForElementToInvisible(WebElement element, int timeoutInSeconds) {
        int second = 0;
        while (isElementVisible(element)) {
            builder.pause(1000).build().perform();
            System.out.println("Waiting to element iniVisible");
            second = second + 1;
            if (second == timeoutInSeconds) {
                break;
            }
        }
    }

    public boolean isElementVisible(WebElement element) {
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
