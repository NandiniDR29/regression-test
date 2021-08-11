package com.exigen.dxp.employer.formTab;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestBulkEnrollment extends DXPBaseTest {

    @Test(priority = 30)
    public void TestUploadFormTab() throws Exception {
        logger = extent.startTest("Verifying Bulk Enrollment ");
        navigateToMainPage();
        BulkEnrollmentPage bulk = new BulkEnrollmentPage(driver, wait, robot, builder, prop);
        reportLog("Open DXP app", 0);
        bulk.homePage();
        bulk.clickFormsTab();  /// DOne
        reportLog("Clicked on Upload Form tab", 1);
        bulk.clickUploadFormTab();  /// DOne
        bulk.clickFuntionalAreadropdown(); /// DOne
        reportLog("Select FunctionalArea", 1);

        bulk.selectFunctionalAreasGroup(); /// DOne
        bulk.selecttheFolderasEnrollment();
        reportLog("Select Folder", 1);
        bulk.selectDocumentTypeasEnrollment();
        reportLog("Select DocumentType", 1);
        bulk.selectDocumentTypedropdown();
        bulk.selectEnrollmentForm();
        bulk.fileUpload();
        reportLog("Upload file", 1);
        bulk.clickComments();
        reportLog("Select Comments", 1);
        bulk.clickSubmitButton();
        reportLog("Select Submit", 1);
        bulk.verifyErrorMessagePresence();
        reportLog("===================================", 1);

    }
}
