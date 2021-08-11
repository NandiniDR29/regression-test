package com.exigen.dxp.employer.formTab;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestUploadDocumentsEOIfile extends DXPBaseTest {

    @Test(priority = 31)
    public void TestUploadFormTab() throws Exception {
        logger = extent.startTest("Uploading documents like EOI,Census ");
        navigateToMainPage();
        UploadFileEOIPage EOI = new UploadFileEOIPage(driver, wait, robot, builder, prop);
        reportLog("Open DXP app", 0);
        EOI.clickonViewEnrollee();
        reportLog("View Enrollee", 1);
        EOI.subscriberID();
        reportLog("Selected the Subscriber ID", 1);
        EOI.clickonSubmitButton();
        reportLog("Clicked on Submit Button ", 1);
        EOI.checkCondition();
        EOI.selecttheFolderasEOI();
        reportLog("Selected the Folder as EOI", 1);
        EOI.selectfolderDocumentTypeasEOI();
        reportLog("Selected the Document Type ", 1);

        EOI.selectDocumentTypedropdown();
        EOI.selectEOILetter();
        reportLog("Selected the EOI Letter ", 1);


        EOI.fileUpload();
        reportLog("File Uploaded Successfully ", 1);

        EOI.clickComments();
        reportLog("Entered the Comments", 1);

        EOI.clickSubmitButton();
        reportLog("Clicked on Submit button ", 1);
        EOI.verifyErrorMessagePresence();
        reportLog("Verified the Error Message ", 1);
        reportLog("===================================", 1);

    }
}
