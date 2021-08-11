package com.exigen.dxp.employee.login;

import com.exigen.dxp.DxpCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

import static com.exigen.dxp.DXPBaseTest.*;

public class MemberLoginPage {
    Actions builder;
    WebDriver driver;
    @FindBy(xpath = "//a[text()='Returning User']")
    private WebElement recurringUser;
    @FindBy(xpath = "//div[text()='Enrollee']/../div[1]")
    private WebElement enrollee;
    @FindBy(name = "username")
    private WebElement userName;
    @FindBy(name = "attributes.email")
    private WebElement email;
    @FindBy(name = "attributes.given_name")
    private  WebElement firstName;
    @FindBy(name = "attributes.family_name")
    private  WebElement lastName;
    @FindBy(name = "attributes.memberOrPolicyNumber")
    private  WebElement memberID;
    @FindBy(name = "attributes.policyNumber")
    private  WebElement policyNumber;
    @FindBy(name = "attributes.ssn")
    private  WebElement ssnNumber;
    @FindBy(name = "attributes.dateOfBirth")
    private  WebElement dob;
    @FindBy(name = "password")
    private WebElement passwordTB;
    @FindBy(name = "confirmNewPassword")
    private WebElement confirmPassword;
    @FindBy(xpath = "//span[@id='recaptcha-anchor']")
    private WebElement captchaCheckBox;
    @FindBy(xpath = "//button[contains(.,'Sign me in')]")
    private WebElement LoginBTN;
    @FindBy(xpath ="//button[contains(@data-test,'submit')]" )
    private WebElement signUp;
    @FindBy(xpath = "//div[@class='err_msg']")
    private WebElement errorMessage;
    @FindBy(xpath = "(//*[@id='root']/div/div[2]/div[1]/div[2]/div/div[2]/form/div[1]/label)|(//*[@id='root']/div/div[2]/div[1]/div[2]/div/div[2]/form/div/div[1]/input)")
    private WebElement verificationCode;
    @FindBy(xpath = "//*[@id='root']/div/div[2]/div[1]/div[2]/div/div[2]/form/div[1]/div[1]")
    private WebElement enterCode;
    @FindBy(xpath = "//button[@data-test='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//a[contains(text(),'Forgot Username?')]")
    private  WebElement forgotUserNameLink;
    @FindBy(xpath = "//a[contains(text(),'Forgot Password?')]")
    private  WebElement forgotPasswordLink;
    @FindBy(xpath = "//span[@role='checkbox']")
    private WebElement captchaCheck;
    @FindBy(xpath = "//div[contains(text(),'Reset Password')]")
    private WebElement resetPasswordPopUP;
    @FindBy(name = "email")
    private WebElement resetPageUserName;
    @FindBy(name = "verificationCode")
    private  WebElement resetVerificationTB;
    @FindBy(xpath = "//h1[contains(text(),'Alert')]")
    private WebElement alertPopUp;
    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    private WebElement alertConfirmationBTN;
    @FindBy(xpath = "//button[contains(text(),'Get Verification Code')]")
    private WebElement getVerificationCodeBTN;

    @FindBy(xpath = "//button[contains(text(),'Get Username')]")
    private WebElement getUserNameBTN;
    @FindBy(xpath = "//div[contains(text(),'Get Username')]")
    private WebElement getUserName;
    @FindBy(xpath = "//div[contains(text(),'User does not exist.')]")
    private WebElement wrongUserErrorMessage;
    @FindBy(xpath = "//div[contains(text(),'Incorrect username or password.')]")
    private WebElement wrongPasswordErrorMessage;
    @FindBy(xpath = "//h1[contains(text(),'Username Sent!')]")
    private WebElement userNameSentMessage;
    @FindBy(xpath = "//a//img[@src='/1724af7f915bc7750a974fb1ce4f823b.svg']")
    private WebElement closeIcon;
    @FindBy(xpath = "//iframe[@role='presentation']")
    private  WebElement captchaFrame;

    public MemberLoginPage(WebDriver driver, Actions builder, Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.driver=driver;
    }
    public void selectRecurringUser() {
        highLighterMethod(recurringUser);
        recurringUser.click();
    }

    public void selectRegisterAsEnrollee(){
        highLighterMethod(enrollee);
        stimulateClick(enrollee);
    }
    public void enterUserName(String user) {
        highLighterMethod(userName);
        userName.sendKeys(user);
    }
    public void enterFirstName(String firstname) {
        highLighterMethod(firstName);
        firstName.sendKeys(firstname);
    }
    public void enterLastName(String lastname) {
        highLighterMethod(lastName);
        lastName.sendKeys(lastname);
    }
    public void enterEmail(String emailID) {
        highLighterMethod(email);
        email.sendKeys(emailID);
    }
    public void enterMemberId(String customerID) {
        sendText(memberID,customerID);
    }
    public void enterSsn(String ssn) {
        sendText( ssnNumber,ssn);
    }
    public void enterPolicyNumber(String policy) {
        sendText(policyNumber,policy);
    }
    public void enterDOB(String birthDate) {
        sendText(dob,birthDate);
    }
    public void enterPassword(String password) {
        sendText(passwordTB,password);
    }
    public void enterConfirmPassword(String password) {
        sendText(confirmPassword,password);
    }


    public void waitToClearCaptcha() {
        driver.switchTo().frame(captchaFrame);
        WebDriverWait elementWait = new WebDriverWait(driver, 300);
        System.out.println("Waiting for Captcha to clear manually");
        elementWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String captchaCleared = captchaCheck.getAttribute("aria-checked");
                if (captchaCleared.equals("true"))
                    return true;
                else
                    return false;
            }
        });
        System.out.println("Success captcha cleared with in 5 minutes");
        driver.switchTo().parentFrame();
    }

    public void selectSignUpForReg() {
        stimulateClick(signUp);
    }
    public void selectSignUp() {
        stimulateClick(signUp);
    }
    public void enterVerificationCode(String code) {
        highLighterMethod(verificationCode);
        builder.moveToElement(verificationCode).click(verificationCode).pause(2000).sendKeys(enterCode, code).sendKeys(code).perform();
    }
    public void clickOnSubmit() {
        stimulateClick( submitButton);
    }
    public void clickOnForgotUserName() {
        stimulateClick(  forgotUserNameLink);
    }
    public void clickOnForgotPassWord() {
        stimulateClick(  forgotPasswordLink);
    }
    public void enterUserNameOrEmail(String userName) {
        sendText(resetPageUserName,userName);
    }
    public void enterResetVerificationCode(String code) {
        sendText( resetVerificationTB,code);
    }

    public WebElement getResetPasswordPopUP() {
        return resetPasswordPopUP;
    }

    public void enterResetPassword(String password)
    {
        try {
            String value = password.substring(8, password.lastIndexOf("."));
            int number = Integer.parseInt(value);
            password=password.substring(0, 7).concat(String.valueOf(number)).concat("!");
            enterPassword(password);
            enterConfirmPassword(password);
            DxpCommonMethods.SavePasswordForNextValidation(password);
            clickOnSubmit();
            if (alertPopUp.isDisplayed()){
                highLighterMethod(alertConfirmationBTN);
                alertConfirmationBTN.click();
                enterResetPassword(password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void clickOnGetVerificationCode() {
        stimulateClick(getVerificationCodeBTN);
    }

    public WebElement getGetUserNamePopUp() {
        return getUserName;
    }
    public void clickOnGetUserName() {
        stimulateClick(getUserNameBTN);
    }
    public WebElement getWrongPasswordErrorMessage() {
        highLighterMethod(wrongPasswordErrorMessage);
        return wrongPasswordErrorMessage;
    }

    public WebElement getWrongUserErrorMessage() {
        highLighterMethod(wrongUserErrorMessage);
        return wrongUserErrorMessage;
    }

    public void setUserName() {
        userName.clear();
    }

    public void setPassword() {
        passwordTB.clear();
    }

    public WebElement getUserNameSentMessage() {
        return userNameSentMessage;
    }
    public void clickOnCloseIcon() {
        stimulateClick( closeIcon);
    }

}
