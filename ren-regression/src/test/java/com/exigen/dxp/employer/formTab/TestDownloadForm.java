package com.exigen.dxp.employer.formTab;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestDownloadForm extends DXPBaseTest {

    @Test(priority = 23)
    public void TestDownloadFormTab() throws InterruptedException {

        logger = extent.startTest("Verifying Download Form-Tab ");
        navigateToMainPage();
        DownloadFormTabPage downloadFormTabPage = new DownloadFormTabPage(driver, wait, robot, builder, prop);
        downloadFormTabPage.clickFormsTab();
        reportLog("Clicked on Download Form tab", 0);
        downloadFormTabPage.clickOnDocumentLibrary();
        reportLog("Selected the Functional Area ", 1);
        downloadFormTabPage.clickFuntionalAreadropdown();
        reportLog("Selected the Functional Area Group ", 1);
        downloadFormTabPage.selectFunctionalAreasGroup();
        reportLog("Selected the Document ", 1);
        downloadFormTabPage.selectDocumentdropdown();
        downloadFormTabPage.documentType();
        reportLog("Selected the Document type as Enrollment Upload ", 1);
        downloadFormTabPage.clickDownloadbutton();
        reportLog("Downloaded the Enrollment form Successfully ", 1);
        reportLog("__________________", 1);

    }
}
