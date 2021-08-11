package com.exigen.dxp.employer.formTab;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestUploadDocumentsCensus extends DXPBaseTest {

    @Test(priority = 32)
    public void TestUploadFormTab() throws Exception {
        logger = extent.startTest("Uploading documents like Census ");
        navigateToMainPage();
        UploadFileCensusPage Census = new UploadFileCensusPage(driver, wait, robot, builder, prop);
        reportLog("Open DXP app", 0);
        Census.clickFormsTab();
        Census.clickUploadFormTab();
        reportLog("Clicked on Upload Form tab", 1);
        Census.clickFuntionalAreadropdown();
        Census.selectFunctionalAreasGroup();
        reportLog("Select FunctionalArea as Groups ", 1);
        Census.selecttheFolderasEnrollment();
        Census.selectDocumentTypeasEnrollment();
        Census.selectDocumentTypedropdown();
        reportLog("Selected Folder", 1);
        Census.selectEnrollmentForm();
        reportLog("Select DocumentType", 1);
        Census.fileUpload();
        reportLog("Upload file", 1);
        Census.clickComments();
        reportLog("Select Comments", 1);
        Census.clickSubmitButton();
        reportLog("Select Submit", 1);
        Census.verifyErrorMessagePresence();
        reportLog("===================================", 1);

    }
}
