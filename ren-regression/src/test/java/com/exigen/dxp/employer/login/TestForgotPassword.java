package com.exigen.dxp.employer.login;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.DxpCommonMethods;
import com.exigen.dxp.dxpHelperForRegistration.OutlookEmailVerification;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestForgotPassword extends DXPBaseTest {
    @Test(priority = 8)
    public void testForgotPassWord() throws IOException, InterruptedException {
        logger = extent.startTest("TestForgotPassword");
        prop.load(fileInput);
        String password = prop.getProperty("Password");
        EmployerLoginPage employerLogin = new EmployerLoginPage(driver, wait, robot, builder, prop);
        SecurityQuestionsPage securityQuestion = new SecurityQuestionsPage(driver);
        reportLog("Select Recurring user", 0);
        employerLogin.selectReturningUser();
        employerLogin.clickOnForgotPassWord();
        reportLog("Enter UserName", 1);
        employerLogin.enterResetPasswordUsername(prop.getProperty("Login1FirstName").concat(prop.getProperty("Login1LastName")));
        reportLog("Cleared Captcha Manually", 1);
        employerLogin.waitToClearCaptcha();
        reportLog("Click On Get Verification Code", 1);
        String time = employerLogin.clickOnGetVerificationCode();
        reportLog("Fill Security Answers", 1);
        securityQuestion.enterAnswers();
        reportLog("Continue", 1);
        securityQuestion.clickOnProceed();
        reportLog("Open New Tab", 1);
        OutlookEmailVerification outlookEmail = new OutlookEmailVerification(driver, wait, robot, builder, prop);
        outlookEmail.openNewWindow();
        reportLog("Enter Outlook Url", 1);
        outlookEmail.enterUrl();
        reportLog("login to Email", 1);
        outlookEmail.login("rendxpregression@outlook.com", "TestDemo5!");
        reportLog("Search for Verification Code", 1);
        outlookEmail.searchForMessage("Your verification code");
        reportLog("Return Verification code", 1);
        String code = outlookEmail.returnVerificationCode();
        DxpCommonMethods.SaveVerificationCodeForNextValidation(code);
        outlookEmail.closeNewWindow();
        reportLog("Verification code Entered", 1);
        employerLogin.enterVerificationCode(prop.getProperty("VerificationCode"));
        reportLog("Setup New Password", 1);
        employerLogin.enterPassword(prop.getProperty("ResetPassword"));
        reportLog("Confirm New Password", 1);
        employerLogin.enterConfirmPassword(prop.getProperty("ResetPassword"));
        employerLogin.resetPasswordClickSubmit();
        reportLog("Select Returning user", 1);
        reportLog("Enter UserName", 1);
        employerLogin.enterUserName(prop.getProperty("Login1FirstName").concat( prop.getProperty("Login1LastName")));
        reportLog("Enter Password", 1);
        employerLogin.enterPassword(prop.getProperty("ResetPassword"));
        reportLog("Clear Captcha Manually", 1);
        employerLogin.waitToClearCaptcha();
        reportLog("Click on SignUp", 1);
        employerLogin.selectSignUp();
        securityQuestion.enterAnswers();
        reportLog("Fill Security Answers", 1);
        securityQuestion.clickOnProceed();
//        reportLog("Logout", 1);
//        securityQuestion.clickOnLogout();
        reportLog("======================================", 1);
    }
}
