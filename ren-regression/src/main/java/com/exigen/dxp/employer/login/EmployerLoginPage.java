package com.exigen.dxp.employer.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBaseTest.*;
import static com.exigen.dxp.DxpCommonMethods.SavePasswordForNextValidation;

public class EmployerLoginPage {
    Actions builder;
    Robot robot;
    WebDriver driver;
    @FindBy(xpath = "//form//a[@href='/login']")
    private WebElement recurringUser;

    @FindBy(xpath = "//div[text()='Employer']")
    private  WebElement signUpEmployer;

    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "attributes.email")
    private WebElement email;

    @FindBy(name = "attributes.given_name")
    private WebElement firstName;

    @FindBy(name = "attributes.family_name")
    private WebElement lastName;

    @FindBy(name = "attributes.customerNumber")
    private WebElement memberID;

    @FindBy(name = "attributes.policyNumber")
    private WebElement policyNumber;

    @FindBy(name = "attributes.ssn")
    private WebElement ssnNumber;

    @FindBy(name = "attributes.zipcode")
    private WebElement zipCode;

    @FindBy(name = "password")
    private WebElement passwordTB;

    @FindBy(name = "confirmNewPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id='recaptcha-anchor']")
    private WebElement captchaCheckBox;

    @FindBy(xpath = "//button[contains(.,'Sign me in')]")
    private WebElement LoginBTN;

    @FindBy(xpath = "//button[contains(@data-test,'submit')]")
    private WebElement signUp;

    @FindBy(xpath = "//div[@class='err_msg']")
    private WebElement errorMessage;

    @FindBy(xpath = "//iframe[@role='presentation']")
    private  WebElement captchaFrame;

    @FindBy(xpath = "//input[@name='verificationCode']")
    private WebElement verificationCode;

    @FindBy(xpath = "//button[@data-test='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//span[@role='checkbox']")
    private WebElement captchaCheck;

    @FindBy(xpath = "//div[text()='Account Verification successful. Please login.']")
    private WebElement signupSuccess;

    @FindBy(xpath = "//a[text()='Forgot Username?']")
    private WebElement forgotUserNameLink;

    @FindBy(xpath = "//a[text()='Forgot Password?']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[contains(text(),'Reset Password')]")
    private WebElement resetPasswordForm;

    @FindBy(xpath = "//input[@data-test='username']")
    private WebElement resetPasswordUsername;

    @FindBy(xpath = "//button[text()='Get Verification Code']")
    private WebElement getVerificationCodeBtn;

    @FindBy(xpath = "//div[text()='Your password has been reset successfully.']")
    private WebElement resetPasswordSuccess;

    @FindBy(xpath = "//h1[contains(text(),'Alert')]")
    private WebElement alertPopUp;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    private WebElement alertConfirmationBTN;

    public EmployerLoginPage(WebDriver driver, WebDriverWait wait, Robot robot, Actions builder,
                             Properties prop) {
        PageFactory.initElements(driver, this);
        this.builder = builder;
        this.robot = robot;
        this.driver = driver;
    }

    public void selectReturningUser() {
        highLighterMethod(recurringUser);
        recurringUser.click();
    }

    public void selectEmployerSignup() {
        highLighterMethod(signUpEmployer);
        signUpEmployer.click();
    }

    public void enterUserName(String user) {
        sendText(userName, user);
    }

    public void enterFirstName(String firstname) {
        sendText(firstName, firstname);
    }

    public void enterLastName(String lastname) {
        sendText(lastName, lastname);
    }

    public void enterEmail(String emailID) {
        sendText(email, emailID);
    }

    public void enterMemberId(String customerID) {
        sendText(memberID, customerID);
    }

    public void enterSsn(String ssn) {
        sendText(ssnNumber, ssn);
    }

    public void enterPolicyNumber(String policy) {
        sendText(policyNumber, policy);
    }

    public void enterZipCode(String zipcode) {
        sendText(zipCode, zipcode);
    }

    public void enterPassword(String password) {
        sendText(passwordTB, password);
    }

    public void enterConfirmPassword(String password) {
        sendText(confirmPassword, password);
    }

    public void selectCaptchaCheckBox() {
        driver.switchTo().frame(0);
        highLighterMethod(captchaCheckBox);
        captchaCheckBox.click();
    }

    public void waitToClearCaptcha() {
        driver.switchTo().frame(captchaFrame);
        WebDriverWait elementWait = new WebDriverWait(driver, 700);
        System.out.println("Waiting for Captcha to clear manually");
//        captchaCheckBox.click();
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

    public String selectSignUp() {
        Date time = Calendar.getInstance().getTime();
        stimulateClick(signUp);
        return String.valueOf(time.getHours()).concat(":").concat(String.valueOf(time.getMinutes()));
    }

    public void enterVerificationCode(String code) {
        builder.pause(2000).perform();
        sendText(verificationCode, code);
    }

    public void clickOnSubmit() {
        stimulateClick(submitButton);
        WebDriverWait elementWait = new WebDriverWait(driver, 300);
        System.out.println("Waiting to redirect to Login Screen");
        try {
            elementWait.until(ExpectedConditions.visibilityOf(signupSuccess));
        } catch (Exception e) {
            System.out.println("Sign-up got failed...");
            reportLog("Sign-up failed Entered OTP is not correct", 1);
        }
    }

    public void clickOnForgotUserName() {
        stimulateClick(forgotUserNameLink);
    }
    public void clickOnForgotPassWord() {
        highLighterMethod(forgotPasswordLink);
        forgotPasswordLink.click();
    }

    public void enterResetPasswordUsername(String username) {
        WebDriverWait elementWait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(resetPasswordForm));
        sendText(resetPasswordUsername, username);
        waitToClearCaptcha();
    }

    public String clickOnGetVerificationCode() {
        Date time = Calendar.getInstance().getTime();
        highLighterMethod(getVerificationCodeBtn);
        getVerificationCodeBtn.click();
        return String.valueOf(time.getHours()).concat(":").concat(String.valueOf(time.getMinutes()));

    }

    public void clearAlert(String password)
    {
        try {
            if (alertPopUp.isDisplayed()){
                highLighterMethod(alertConfirmationBTN);
                alertConfirmationBTN.click();
                String value = password.substring(8, password.lastIndexOf("!"));
                int number = Integer.parseInt(value);
                password=password.substring(0, 7).concat(String.valueOf(number)).concat("!");
                enterPassword(password);
                enterConfirmPassword(password);
                SavePasswordForNextValidation(password);
                resetPasswordClickSubmit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitResetPassword(){
        stimulateClick(submitButton);
    }

    public void resetPasswordClickSubmit(){
        stimulateClick(submitButton);
        WebDriverWait elementWait = new WebDriverWait(driver, 300);
        System.out.println("Waiting to redirect to Login Screen");
        try {
            elementWait.until(ExpectedConditions.visibilityOf(resetPasswordSuccess));
            reportLog(resetPasswordSuccess.getText(), 1);
        } catch (Exception e) {
            System.out.println("Reset password got failed...");
            reportLog("Reset password failed Entered OTP or password is  incorrect", 1);
        }
    }

}
