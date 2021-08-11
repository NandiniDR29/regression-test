package com.exigen.dxp.employer.login;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.dxpHelperForRegistration.OutlookEmailVerification;
import com.exigen.helpers.SequenceCharcterAndExcelUpdateUtils;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.basetest.Util.currentTime;

public class TestEmployerRegistration extends DXPBaseTest {
    @Test(priority = 1)
    public void testMemberRegistration() throws IOException, InterruptedException {
        commonSteps(prop.getProperty("Login1FirstName"), prop.getProperty("Login1LastName"), prop.getProperty("Login1PolicyNumber"), prop.getProperty("ZipCode"), prop.getProperty("Login1CustomerID"));

    }

    public void commonSteps(String login1FirstName, String login1LastName, String login1PolicyNumber, String zip, String login1ID) throws IOException, InterruptedException {
        logger = extent.startTest("Employer registration");
        prop.load(fileInput);
        reportLog("Open DXP app", 0);
        String password = prop.getProperty("Password");
        EmployerLoginPage employerLogin = new EmployerLoginPage(driver, wait, robot, builder, prop);
        SecurityQuestionsPage securityQuestion = new SecurityQuestionsPage(driver);
        employerLogin.selectEmployerSignup();
//        employerLogin.selectReturningUser();
        reportLog("Enter UserName", 1);
        employerLogin.enterUserName(login1FirstName.concat(login1LastName));
        reportLog("Entered User Name ::: "+ login1FirstName.concat(login1LastName), 1);
        reportLog("Enter FirstName", 1);
        employerLogin.enterFirstName(login1FirstName);
        reportLog("Enter LastName", 1);
        employerLogin.enterLastName(login1LastName);
        reportLog("Enter Email", 1);
        employerLogin.enterEmail(prop.getProperty("Email"));
        reportLog("Enter CustomerID", 1);
        employerLogin.enterMemberId(login1ID);
        reportLog("Enter MasterPolicy", 1);
        employerLogin.enterPolicyNumber(login1PolicyNumber);
//        reportLog("Enter SSN/TaxID", 1);
//        employerLogin.enterSsn(login1Ssn);
        reportLog("Enter Zip", 1);
        employerLogin.enterZipCode(zip);
        reportLog("Enter Password", 1);
        employerLogin.enterPassword(password);
        reportLog("Enter ConfirmPassword", 1);
        employerLogin.enterConfirmPassword(password);
        Waiters.SLEEP(5000).go();
        reportLog("Clear Captcha Manually", 1);
        employerLogin.waitToClearCaptcha();
        reportLog("Click on SignUp", 1);
        String time =employerLogin.selectSignUp();
        reportLog("Fill Security Answers", 1);
        securityQuestion.firstLoginCheck=true;
        securityQuestion.enterAnswers();
        reportLog("Proceed", 1);
        securityQuestion.clickOnContinue();
        Waiters.SLEEP(10000).go();
        WebElement outlook = driver.findElement(By.xpath("//div[@class='card_2R8Y7BMg container_1Y3bTmBg']//div[@class='title_3QTF1tEB']"));
        String str = outlook.getText();
        if (str.equalsIgnoreCase("Account Verification")) {
            reportLog("Open New Tab", 1);
            OutlookEmailVerification ev = new OutlookEmailVerification(driver, wait, robot, builder, prop);
            ev.openNewWindow();
            reportLog("Enter Outlook Url", 1);
            ev.enterUrl();
            reportLog("login to Email", 1);
            ev.login("rendxpregression@outlook.com", "TestDemo5!");
            reportLog("Search for Verification Code", 1);
            ev.searchForMessage("Verification Code for MyRenBenefitsManager");
            reportLog("Return Verification code", 1);
            String code = ev.returnVerificationCode();
            ev.closeNewWindow();
            reportLog("Entering Verification code :: " + code, 1);
            employerLogin.enterVerificationCode(code);
            reportLog("Click on Submit", 1);
            employerLogin.clickOnSubmit();////
            System.out.println("First Login output ::" + securityQuestion.firstLoginCheck);
            boolean firstLogin = securityQuestion.firstLoginCheck;
            if (firstLogin) {
                UserAgreementPage userAgreement = new UserAgreementPage(driver, builder);
                userAgreement.acceptUserAgreement();
            }
        }

        reportLog("======================================", 1);
    }
}
