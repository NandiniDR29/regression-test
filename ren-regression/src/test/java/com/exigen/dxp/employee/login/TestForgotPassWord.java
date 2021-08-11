package com.exigen.dxp.employee.login;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.dxpHelperForRegistration.OutlookEmailVerification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.exigen.dxp.DXPBasePage.verifyTitle;
import static com.exigen.dxp.DxpCommonMethods.SaveVerificationCodeForNextValidation;

public class TestForgotPassWord extends DXPBaseTest {
    @Test(priority = 35)
    public void testForgotPassWord() throws IOException, InterruptedException {
        logger = extent.startTest("TestForgotPassWord");
        prop.load(fileInput);
        String password = prop.getProperty("Password");
        MemberLoginPage memberLoginPage = new MemberLoginPage(driver,builder, prop);
        SecurityQuestionsPage sp = new SecurityQuestionsPage(driver);
        reportLog("Select Recurring user", 0);
        memberLoginPage.selectRecurringUser();
        reportLog("Select Forgot password link", 1);
        memberLoginPage.clickOnForgotPassWord();
        Assert.assertEquals(memberLoginPage.getResetPasswordPopUP().getText(), "RESET PASSWORD");
        reportLog("Enter UserName", 1);
        memberLoginPage.enterUserNameOrEmail(prop.getProperty("Login2FirstName").concat(prop.getProperty("Login2LastName")));
        reportLog("Clear Captcha Manually", 1);
        memberLoginPage.waitToClearCaptcha();
        reportLog("Click On Get Verification Code", 1);
        memberLoginPage.clickOnGetVerificationCode();
        reportLog("Fill Security Answers", 1);
        sp.enterAnswers();
        reportLog("Continue", 1);
        sp.clickOnProceed();
        reportLog("Open New Tab", 1);
        OutlookEmailVerification ev = new OutlookEmailVerification(driver, wait, robot, builder, prop);
        ev.openNewWindow();
        reportLog("Enter Outlook Url", 1);
        ev.enterUrl();
        reportLog("login to Email", 1);
        ev.login("rendxpregression@outlook.com", "TestDemo5!");
        reportLog("Search for Verification Code", 1);
        ev.searchForMessage("Your verification code");
        reportLog("Return Verification code", 1);
        String code = ev.returnVerificationCode();
        SaveVerificationCodeForNextValidation(code);
        ev.closeNewWindow();
        memberLoginPage.enterResetVerificationCode(prop.getProperty("VerificationCode"));


        memberLoginPage.enterResetPassword(password);
        reportLog("Enter UserName", 1);
       // memberLoginPage.enterUserName(prop.getProperty("Login2FirstName").concat( prop.getProperty("Login2LastName")));
        reportLog("Enter Password", 1);

        memberLoginPage.enterPassword(prop.getProperty("NewPassWord"));
        memberLoginPage.enterConfirmPassword(prop.getProperty("NewPassWord"));

//
//        reportLog("Clear Captcha Manually", 1);
//        memberLoginPage.selectCaptchaCheckBox();
//        reportLog("Click on SignUp", 1);
        memberLoginPage.selectSignUp();
//        memberLoginPage.enterUserName(prop.getProperty("Login2FirstName").concat( prop.getProperty("Login2LastName")));
//        memberLoginPage.enterConfirmPassword(prop.getProperty("NewPassWord"));
//        memberLoginPage.selectSignUp();

//        reportLog("Fill Security Answers", 1);
//        sp.enterAnswers();
//        sp.clickOnContinue();
//        verifyTitle("Renaissance");
//        reportLog("Title: "+driver.getTitle(), 1);
//        sp.availableProducts();
////        reportLog("Logout", 1);
////        sp.clickOnLogout();
        reportLog("Password Changed successfully ", 1);

        reportLog("======================================", 1);
    }
}
