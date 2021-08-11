package com.exigen.dxp.employee.login;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.dxpHelperForRegistration.OutlookEmailVerification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.dxp.DXPBasePage.verifyTitle;
import static com.exigen.dxp.DxpCommonMethods.SaveUserNameForNextValidation;

public class TestForgotUserName extends DXPBaseTest {
    @Test(priority = 34)
    public void testForgotUserName() throws IOException, InterruptedException {
        logger = extent.startTest("TestForgotUserName");
        prop.load(fileInput);
        String password = "TestDemo5!";
        MemberLoginPage memberLoginPage = new MemberLoginPage(driver, builder, prop);
        SecurityQuestionsPage sp = new SecurityQuestionsPage(driver);
        reportLog("Select Recurring user", 0);
        memberLoginPage.selectRecurringUser();
        reportLog("Click on forgot UserName link", 1);
        memberLoginPage.clickOnForgotUserName();
        Assert.assertEquals(memberLoginPage.getGetUserNamePopUp().getText(), "GET USERNAME");
        reportLog("Enter Email", 1);
        memberLoginPage.enterUserNameOrEmail("rendxpusername@outlook.com");
        reportLog("Select Get user Name link",1);
        memberLoginPage.clickOnGetUserName();
        Assert.assertEquals(memberLoginPage.getUserNameSentMessage().getText(), "Username Sent!");
        memberLoginPage.clickOnCloseIcon();
        reportLog("Open New Tab", 1);
        OutlookEmailVerification ev = new OutlookEmailVerification(driver, wait, robot, builder, prop);
        ev.openNewWindow();
        reportLog("Enter Outlook Url", 1);
        ev.enterUrl();
        reportLog("login to Email", 1);
        ev.login("rendxpusername@outlook.com", "TestDemo5!");
        reportLog("Search for Verification Code", 1);
        ev.searchForMessage("Your Username");
        reportLog("Return UserName", 1);
        String userName = ev.returnUserName();
        SaveUserNameForNextValidation(userName);
        ev.closeNewWindow();
        reportLog("Select Recurring user", 1);
        memberLoginPage.selectRecurringUser();
        reportLog("Enter UserName", 1);
        memberLoginPage.enterUserName(prop.getProperty("UserName"));
        reportLog("Enter Password", 1);
        memberLoginPage.enterPassword(password);
        reportLog("Clear Captcha Manually", 1);
        memberLoginPage.waitToClearCaptcha();
        reportLog("Click on SignUp", 1);
        memberLoginPage.selectSignUp();
        reportLog("Fill Security Answers", 1);
        sp.enterAnswers();
        sp.clickOnProceed();
        verifyTitle("Renaissance");
        reportLog("Title: "+driver.getTitle(), 1);
        sp.availableProducts();
        reportLog("======================================", 1);
    }
}