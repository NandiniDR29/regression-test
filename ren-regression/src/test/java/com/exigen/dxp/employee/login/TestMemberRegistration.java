package com.exigen.dxp.employee.login;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.dxpHelperForRegistration.OutlookEmailVerification;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.LineOverrideTab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.dxp.DXPBasePage.verifyTitle;
import static com.exigen.dxp.DxpCommonMethods.SaveVerificationCodeForNextValidation;
import static com.exigen.dxp.DxpCommonMethods.logoutSteps;
import static com.exigen.ren.main.enums.ActionConstants.LINE_OVERRIDE;
import static com.exigen.ren.main.enums.TableConstants.ClaimSummaryResultsOfAdjudicationTableExtended.ACTIONS;
import static com.exigen.ren.main.modules.claim.gb_dn.metadata.LineOverrideTabMetaData.REASON;
import static com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage.tableResultsOfAdjudication;

public class TestMemberRegistration extends DXPBaseTest {
    @Test(priority = 1)
    public void testMemberRegistration() throws IOException, InterruptedException {
        commonSteps(prop.getProperty("Login1FirstName"), prop.getProperty("Login1LastName"), prop.getProperty("Login1ID"), prop.getProperty("Login1Ssn"), prop.getProperty("Login1DOB"));

    }

//    @Test(priority = 2)
//    public void testMemberRegistration2() throws IOException, InterruptedException {
//        try {
//            logoutSteps();
//        } catch (Exception e) {
//        }

//        commonSteps(prop.getProperty("Login2FirstName"), prop.getProperty("Login2LastName"), prop.getProperty("Login2ID"), prop.getProperty("Login2Ssn"), prop.getProperty("Login2DOB"));
//
//    }

    public void commonSteps(String loginFirstName, String loginLastName, String loginID, String loginSsn, String loginDOB) throws IOException, InterruptedException {
        logger = extent.startTest("TestMemberRegistration");
        prop.load(fileInput);
        reportLog("Open DXP app", 0);
        String password = prop.getProperty("Password");
        MemberLoginPage memberLoginPage = new MemberLoginPage(driver, builder, prop);
        SecurityQuestionsPage securityQuestionsPage = new SecurityQuestionsPage(driver);
        UserAgreementPage userAgreementPage = new UserAgreementPage(driver);
        reportLog("Select Register As Enrollee", 1);
        memberLoginPage.selectRegisterAsEnrollee();
        reportLog("Enter UserName", 1);
        memberLoginPage.enterUserName(loginFirstName.concat(loginLastName));
        reportLog("Enter FirstName", 1);
        memberLoginPage.enterFirstName(loginFirstName);
        reportLog("Enter LastName", 1);
        memberLoginPage.enterLastName(loginLastName);
        reportLog("Enter Email", 1);
        memberLoginPage.enterEmail(prop.getProperty("Email"));
        reportLog("Enter CustomerID", 1);
        memberLoginPage.enterMemberId(loginID);
        reportLog("Enter SSN/TaxID", 1);
        memberLoginPage.enterSsn(loginSsn);
        reportLog("Enter DOB", 1);
        memberLoginPage.enterDOB(loginDOB);
        reportLog("Enter Password", 1);
        memberLoginPage.enterPassword(password);
        reportLog("Enter ConfirmPassword", 1);
        memberLoginPage.enterConfirmPassword(password);
        reportLog("Click on SignUp", 1);
        memberLoginPage.waitToClearCaptcha();
        memberLoginPage.selectSignUpForReg();
        securityQuestionsPage.clearSecurityQuestions();
        reportLog("Fill Security Answers", 1);
        securityQuestionsPage.clickOnContinue();
        Waiters.SLEEP(8000).go();
        WebElement outlook = driver.findElement(By.xpath("//div[@class='card_2R8Y7BMg container_1Y3bTmBg']//div[@class='title_3QTF1tEB']"));
        String str = outlook.getText();

        if (str.equalsIgnoreCase("Account Verification")) {
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
            ev.closeNewWindow();
            reportLog("Entering Verification code :: " + code, 1);
            SaveVerificationCodeForNextValidation(code);
            memberLoginPage.enterVerificationCode(prop.getProperty("VerificationCode"));
            memberLoginPage.clickOnSubmit();
            reportLog("Select Recurring user", 1);
            memberLoginPage.selectRecurringUser();
            reportLog("Enter UserName", 1);
            memberLoginPage.enterUserName(loginFirstName.concat(loginLastName));
            reportLog("Enter Password", 1);
            memberLoginPage.enterPassword(password);
            reportLog("Click on SignUp", 1);
            memberLoginPage.waitToClearCaptcha();
            memberLoginPage.selectSignUp();

            securityQuestionsPage.clearSecurityQuestionsAnswers();
            verifyTitle("Renaissance");
            reportLog("Title: " + driver.getTitle(), 1);
            reportLog("Accept agreement", 1);
            userAgreementPage.clickOnIAgreeBTN();
            verifyTitle("Renaissance");
            securityQuestionsPage.availableProducts();
            logoutSteps();

        } else {
            reportLog("Outlook did not launched ", 1);

        }

        reportLog("======================================", 1);
    }
}

