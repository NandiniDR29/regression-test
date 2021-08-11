package com.exigen.dxp.employer.formTab;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestUploadForm extends DXPBaseTest {

    @Test(priority = 24)
    public void TestUploadFormTab() throws Exception {
        logger = extent.startTest("Verifying Upload Form-Tab ");
        navigateToMainPage();
       UploadFormTabPage uploadFormTabPage = new UploadFormTabPage(driver, wait, robot, builder, prop);

        reportLog("Open DXP app", 0);
        uploadFormTabPage.clickFormsTab();  /// DOne
        reportLog("Clicked on Upload Form tab", 1);
        uploadFormTabPage.clickUploadFormTab();  /// DOne
        uploadFormTabPage.clickFuntionalAreadropdown(); /// DOne
        reportLog("Select Functional Area", 1);

        uploadFormTabPage.selectFunctionalAreasGroup(); /// DOne
        uploadFormTabPage.selecttheFolderasEnrollment();
        reportLog("Select Folder", 1);

        uploadFormTabPage.selectDocumentTypeasEnrollment();
        reportLog("Select DocumentType", 1);

        uploadFormTabPage.selectDocumentTypedropdown();
        uploadFormTabPage.selectEnrollmentForm();
        uploadFormTabPage.fileUpload();
     reportLog("Document Uploaded Successfully", 1);

     reportLog("Upload file", 1);

        uploadFormTabPage.clickComments();
        reportLog("Select Comments", 1);

        uploadFormTabPage.clickSubmitButton();
        reportLog("Select Submit", 1);
        uploadFormTabPage.verifyErrorMessagePresence();


        reportLog("===================================", 1);

    }
}
