package com.exigen.dxp.employee.login;

import com.exigen.dxp.DXPBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestLoginNegativeScenario extends DXPBaseTest {
    @Test(priority = 36)
    public void testLoginNegativeScenario() throws IOException, InterruptedException {
        logger = extent.startTest("TestLoginNegativeScenario");
        prop.load(fileInput);
        String password = prop.getProperty("Password");
        MemberLoginPage MemberLoginPage = new MemberLoginPage(driver,builder, prop);
        reportLog("Select Recurring user", 0);
        MemberLoginPage.selectRecurringUser();
        reportLog("Enter Wrong UserName", 1);
        MemberLoginPage.enterUserName(prop.getProperty("Login1FirstName").concat("12345678"));
        reportLog("Enter correct Password", 1);
        MemberLoginPage.enterPassword(password);
        reportLog("Clear Captcha Manually", 1);

        MemberLoginPage.waitToClearCaptcha();
        reportLog("Click on SignUp", 1);
        MemberLoginPage.selectSignUp();
        Assert.assertEquals(MemberLoginPage.getWrongUserErrorMessage().getText(), "User does not exist.");
        reportLog("Login Negative Scenario is pass ", 1);

//        reportLog("Enter Correct UserName", 1);
//        MemberLoginPage.setUserName();
//        MemberLoginPage.enterUserName(prop.getProperty("Login1FirstName").concat(prop.getProperty("Login1LastName")));
//        reportLog("Enter Wrong Password", 1);
//        MemberLoginPage.setPassword();
//        MemberLoginPage.enterPassword(password.concat("5434"));
//        reportLog("Clear Captcha Manually", 1);
//        MemberLoginPage.waitToClearCaptcha();
//        reportLog("Click on SignUp", 1);
//        MemberLoginPage.selectSignUp();
//        Assert.assertEquals(MemberLoginPage.getWrongPasswordErrorMessage().getText(), "Incorrect username or password.");

        reportLog("======================================", 1);
    }
}
