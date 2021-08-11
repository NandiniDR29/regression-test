package com.exigen.dxp.employer.myProfile;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Testbottomlinks extends DXPBaseTest {

    @Test(priority = 21)
    public void TestBottomLiks() throws InterruptedException {

        logger = extent.startTest("Verifying Bottom links  ");
        navigateToMainPage();
        BottomlinksPage links = new BottomlinksPage(driver, wait, robot, builder, prop);
        reportLog("Clicked on Online Privacyl ink", 0);
        links.onlinePrivacylink();
        reportLog("Clicked on Hippa Policy link", 1);
        links.hippaPolicylink();
        links.termsOfServices();
        reportLog("Clicked on Terms Of Services", 1);
        links.gLBPrivacyNotice();
        reportLog("Clicked on GLB Privacy Notice", 1);
        links.fraudAndAbuse();
        reportLog("Clicked on Fraud and Abuse", 1);
        links.nondiscrimminationNoticelink();
        reportLog("Clicked on Non Discrimmination Notice link", 1);
        reportLog("__________________", 1);



    }
}
