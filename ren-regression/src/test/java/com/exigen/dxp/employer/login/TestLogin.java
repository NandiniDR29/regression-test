package com.exigen.dxp.employer.login;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class  TestLogin extends DXPBaseTest {
    @Test(priority = 2)
    public void testLogin1() throws IOException, InterruptedException {
        commonSteps(prop.getProperty("Login1FirstName").concat(prop.getProperty("Login1LastName")));
    }

    public void commonSteps(String login1FirstName) throws IOException {
        logger = extent.startTest("Login");
        prop.load(fileInput);
        reportLog("Open DXP app", 0);
        String password = prop.getProperty("Password");
        EmployerLoginPage employerLogin = new EmployerLoginPage(driver, wait, robot, builder, prop);
        SecurityQuestionsPage securityQuestion = new SecurityQuestionsPage(driver);
        reportLog("Select Recurring user", 1);
        employerLogin.selectReturningUser();
        reportLog("Enter UserName", 1);
        employerLogin.enterUserName(login1FirstName);
        reportLog("Enter Password", 1);
        employerLogin.enterPassword(password);
        reportLog("Clear Captcha Manually", 1);
        employerLogin.waitToClearCaptcha();
        reportLog("Click on Sign-in", 1);
        employerLogin.selectSignUp();
        reportLog("Fill Security Answers", 1);
        securityQuestion.enterAnswers();
        reportLog("Proceed", 1);
        securityQuestion.clickOnProceed();
        System.out.println("First Login output ::" + securityQuestion.firstLoginCheck);
        boolean firstLogin = securityQuestion.firstLoginCheck;
        if (firstLogin) {
            UserAgreementPage userAgreement = new UserAgreementPage(driver, builder);
            userAgreement.acceptUserAgreement();
        }
        //securityQuestion.clickOnLogout();
        reportLog("======================================", 1);
    }
}
