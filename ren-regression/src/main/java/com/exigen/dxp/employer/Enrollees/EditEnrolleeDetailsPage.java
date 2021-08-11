package com.exigen.dxp.employer.Enrollees;

import com.exigen.dxp.DXPBaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;

public class EditEnrolleeDetailsPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    //HomePage
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/div/a/img")
    private WebElement homePage;

    @FindBy(xpath = "//a[contains(@class,'logo')]")
    private WebElement renLogo;

    @FindBy(xpath = "//td[text()='Active']/following-sibling::td//a[@title='View Details']")
    private WebElement enroleeViewDetailBtn;

    @FindBy(xpath = "//h2[text()='Enrollee Details']")
    private WebElement enrolleeDetailsScreen;

    @FindBy(xpath = "//div[text()='Personal Information']")
    private WebElement personalInformationSection;

    @FindBy(xpath = "//div[text()='Personal Information']/../../following-sibling::div/table/tbody/tr/td[1]")
    private List<WebElement> personalInformationHeader;

    @FindBy(xpath = "//div[text()='Personal Information']/../../following-sibling::div/table/tbody/tr/td[2]")
    private List<WebElement> personalInformationValue;

    @FindBy(xpath = "//div[text()='Salary Information']")
    private WebElement salaryInformationSection;

    @FindBy(xpath = "//div[text()='Salary Information']/following-sibling::div/table/tbody/tr/td[1]")
    private List<WebElement> salaryInformationHeader;

    @FindBy(xpath = "//div[text()='Salary Information']/following-sibling::div/table/tbody/tr/td[2]")
    private List<WebElement> salaryInformationValue;

    @FindBy(xpath = "//div[text()='Email']")
    private WebElement emailSection;

    @FindBy(xpath = "//div[text()='Email']/../../following-sibling::div/table/tbody/tr/td[1]")
    private List<WebElement> emailHeader;

    @FindBy(xpath = "//div[text()='Email']/../../following-sibling::div/table/tbody/tr/td[2]")
    private List<WebElement> emailValue;

    @FindBy(xpath = "//div[text()='Phone']")
    private WebElement phoneSection;

    @FindBy(xpath = "//div[text()='Phone']/../../following-sibling::div/table/tbody/tr/td[1]")
    private List<WebElement> phoneHeader;

    @FindBy(xpath = "//div[text()='Phone']/../../following-sibling::div/table/tbody/tr/td[2]")
    private List<WebElement> phoneValue;

    @FindBy(xpath = "//div[text()='Address']")
    private WebElement addressSection;

    @FindBy(xpath = "//div[text()='Address']/../../following-sibling::div/table/tbody/tr/td[1]")
    private List<WebElement> addressHeader;

    @FindBy(xpath = "//div[text()='Address']/../../following-sibling::div/table/tbody/tr/td[2]")
    private List<WebElement> addressValue;

    @FindBy(xpath = "//div[text()='Communication Preferences']")
    private WebElement communicationPreferenceSection;

    @FindBy(xpath = "//div[text()='Personal Information']/following-sibling::div")
    private WebElement personalInformationEdit;

    @FindBy(xpath = "//div[@role='dialog']//input[@name='middleName']")
    private WebElement personalInformationMiddleName;

    @FindBy(xpath = "//button[@data-test='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//button[@data-test='submitInfo']")
    WebElement submitPersonalInformationBtn;

    @FindBy(xpath = "//div[@role='dialog']")
    WebElement editModal;

    @FindBy(xpath = "//div[text()='Email']/following-sibling::div")
    private WebElement emailEdit;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//div[text()='Phone']/following-sibling::div")
    private WebElement phoneEdit;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//div[text()='Address']/following-sibling::div")
    private WebElement addressEdit;

    @FindBy(xpath = "//input[@name='addressLine2']")
    private WebElement addressLine2Input;

    @FindBy(xpath = "//a[@title='View Enrollees']")
    private WebElement viewEnrolleesIcon;

    public EditEnrolleeDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 60);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        this.js = (JavascriptExecutor)driver;
    }

    public void clickOnViewDetails(){
        stimulateClick(renLogo);
        highLighterMethod(viewEnrolleesIcon);
        viewEnrolleesIcon.click();
        DXPBaseTest.highLighterMethod(enroleeViewDetailBtn);
        DXPBaseTest.reportLog("Clicked on View Enrollee Details Icon",  1);
        enroleeViewDetailBtn.click();
        wait.until(ExpectedConditions.visibilityOf(enrolleeDetailsScreen));
        DXPBaseTest.reportLog("Navigated to Enrollee Details Screen", 1);
    }

    public void verifyEmployeePersonalInformation(){
        if(personalInformationSection.isDisplayed())
            DXPBaseTest.reportLog("Personal Information is Displayed", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Personal Information is not Displayed");
        for(int i = 0; i < personalInformationHeader.size(); i++){
            DXPBaseTest.highLighterMethod(personalInformationValue.get(i));
            DXPBaseTest.logger.log(LogStatus.INFO, personalInformationHeader.get(i).getText() + " : " + personalInformationValue.get(i).getText());
            DXPBaseTest.removeHighLighterMethod(personalInformationValue.get(i));
        }
    }

    public void verifyEmployeeSalaryInformation(){
        if(salaryInformationSection.isDisplayed())
            DXPBaseTest.reportLog("Salary Information is Displayed", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Salary Information is not Displayed");
        for(int i = 0; i < salaryInformationHeader.size(); i++){
            DXPBaseTest.highLighterMethod(salaryInformationValue.get(i));
            DXPBaseTest.logger.log(LogStatus.INFO, salaryInformationHeader.get(i).getText() + " : " + salaryInformationValue.get(i).getText());
            DXPBaseTest.removeHighLighterMethod(salaryInformationValue.get(i));
        }
    }

    public void verifyEmployeeEmail(){
        if(emailSection.isDisplayed())
            DXPBaseTest.reportLog("Email is Displayed", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Email is not Displayed");
        for(int i = 0; i < emailHeader.size(); i++){
            js.executeScript("arguments[0].scrollIntoView();", emailValue.get(i));
            DXPBaseTest.highLighterMethod(emailValue.get(i));
            DXPBaseTest.logger.log(LogStatus.INFO, emailHeader.get(i).getText() + " : " + emailValue.get(i).getText());
            DXPBaseTest.removeHighLighterMethod(emailValue.get(i));
        }
    }

    public void verifyEmployeePhone(){
        if(phoneSection.isDisplayed())
            DXPBaseTest.reportLog("Phone is Displayed", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Phone is not Displayed");
        for(int i = 0; i < phoneHeader.size(); i++){
            js.executeScript("arguments[0].scrollIntoView();", phoneValue.get(i));
            DXPBaseTest.highLighterMethod(phoneValue.get(i));
            DXPBaseTest.logger.log(LogStatus.INFO, phoneHeader.get(i).getText() + " : " + phoneValue.get(i).getText());
            DXPBaseTest.removeHighLighterMethod(phoneValue.get(i));
        }
    }

    public void verifyEmployeeAddress(){
        if(addressSection.isDisplayed())
            DXPBaseTest.reportLog("Address is Displayed", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Address is not Displayed");
        for(int i = 0; i < addressHeader.size(); i++){
            js.executeScript("arguments[0].scrollIntoView();", addressValue.get(i));
            DXPBaseTest.highLighterMethod(addressValue.get(i));
            DXPBaseTest.logger.log(LogStatus.INFO, addressHeader.get(i).getText() + " : " + addressValue.get(i).getText());
            DXPBaseTest.removeHighLighterMethod(addressValue.get(i));
        }
    }

    public void verifyEmployeeCommunicationPreference(){
        if(communicationPreferenceSection.isDisplayed())
            DXPBaseTest.reportLog("Communication Preference is Displayed", 1);
        else
            DXPBaseTest.logger.log(LogStatus.FAIL, "Communication Preference is not Displayed");
    }

    public void editPersonalInformation(){
        js.executeScript("arguments[0].scrollIntoView();", personalInformationEdit);
        DXPBaseTest.stimulateClick(personalInformationEdit);
        wait.until(ExpectedConditions.visibilityOf(personalInformationMiddleName));
        String middleName = "Jr";
        personalInformationMiddleName.clear();
        DXPBaseTest.sendText(personalInformationMiddleName, middleName);
        DXPBaseTest.highLighterMethod(submitPersonalInformationBtn);
        submitPersonalInformationBtn.click();
        waitForElementToInvisible(editModal, 60);
        if(middleName.equals(personalInformationValue.get(1).getText()))
            reportLog("Edit Personal Information Verified", 1);
        else
            logger.log(LogStatus.FAIL, "Edit Personal Information is not working as Expected. Expected Middle Name is " + middleName + "Actual Email is " + personalInformationValue.get(1).getText());
    }

    public void editEmailAddress(){
        js.executeScript("arguments[0].scrollIntoView();", emailEdit);
        DXPBaseTest.stimulateClick(emailEdit);
        wait.until(ExpectedConditions.visibilityOf(editModal));
        String email = generateRandomString().concat("@test.com");
        emailInput.clear();
        DXPBaseTest.sendText(emailInput, email);
        DXPBaseTest.highLighterMethod(submitBtn);
        submitBtn.click();
        waitForElementToInvisible(editModal, 60);
        if(email.equals(emailValue.get(0).getText()))
            reportLog("Edit Email Verified", 1);
        else
            logger.log(LogStatus.FAIL, "Edit Email is not working as Expected. Expected Email is " + email + "Actual Email is " + emailValue.get(0).getText());
    }

    public void editPhoneNumber(){
        reportLog("Edit Phone", 1);
        js.executeScript("arguments[0].scrollIntoView();", phoneEdit);
        DXPBaseTest.stimulateClick(phoneEdit);
        wait.until(ExpectedConditions.visibilityOf(editModal));
        phoneInput.clear();
//        DXPBaseTest.sendText(phoneInput, String.valueOf(generateNumber()));
        DXPBaseTest.sendText(phoneInput, "3659753653");
        DXPBaseTest.highLighterMethod(submitBtn);
        String phone = phoneInput.getAttribute("value");
        submitBtn.click();
        waitForElementToInvisible(editModal, 60);
        if(phone.equals(phoneValue.get(0).getText()))
            reportLog("Edit Phone Verified", 1);
        else
            logger.log(LogStatus.FAIL, "Edit Phone Number is not working as Expected. Expected Phone is " + phone + "Actual Phone is " + phoneValue.get(0).getText());
    }

    public void editAddress(){
        reportLog("Edit Address Detail", 1);
        js.executeScript("arguments[0].scrollIntoView();", addressEdit);
        DXPBaseTest.stimulateClick(addressEdit);
        wait.until(ExpectedConditions.visibilityOf(editModal));
        addressLine2Input.clear();
        String address2 = generateRandomString();
        DXPBaseTest.sendText(addressLine2Input, address2);
        DXPBaseTest.highLighterMethod(submitBtn);
        submitBtn.click();
        waitForElementToInvisible(editModal, 60);
        reportLog("Address Edited", 1);
    }

    //    ============================================================================
    private void waitForElementToInvisible(WebElement element, int timeoutInSeconds){
        int second = 0;
        while(isElementVisible(element)){
            builder.pause(1000).build().perform();
            System.out.println("Waiting to element iniVisible");
            second = second + 1;
            if(second == timeoutInSeconds){
                break;
            }
        }
    }

    private boolean isElementVisible(WebElement element){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try{
            element.isDisplayed();
            return true;
        }catch (Exception e){
            return false;
        }finally {
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        }
    }

    private String generateRandomString(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 5;

        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        System.out.println("Random String is: " + sb.toString());
        return sb.toString();
    }

    private long generateNumber() {
        Random rnd = new Random();
        char [] digits = new char[10];
        digits[0] = (char) (rnd.nextInt(9) + '1');
        for(int i=1; i<digits.length; i++) {
            digits[i] = (char) (rnd.nextInt(10) + '0');
        }
        return Long.parseLong(new String(digits));
    }
    public void homePage() {
        highLighterMethod(homePage);
        homePage.click();
    }
}
