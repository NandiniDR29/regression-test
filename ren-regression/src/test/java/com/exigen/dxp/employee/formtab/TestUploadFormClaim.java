package com.exigen.dxp.employee.formtab;

import com.exigen.dxp.DXPBaseTest;
import org.apache.pdfbox.pdmodel.graphics.predictor.Up;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestUploadFormClaim extends DXPBaseTest {
    @Test(priority = 33)
    public void TestUploadFormClaim() throws Exception {
        logger = extent.startTest("Verifying Upload Form-Tab ");
        UploadFormClaimPage UploadformClaimtab = new UploadFormClaimPage(driver, wait, robot, builder, prop);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        reportLog("Open DXP app", 0);
        Thread.sleep(100);

        UploadformClaimtab.clickFormstab();  /// DOne
        reportLog("Clicked on Upload Form tab", 1);
        UploadformClaimtab.ClickUploadFormTab();  /// DOne
        UploadformClaimtab.ClickFuntionalAreadropdown(); /// DOne
        UploadformClaimtab.SelectFunctionalAreasClaim();
        reportLog("Select FunctionalArea", 1);
        UploadformClaimtab.SelectClaimDropDown();
        UploadformClaimtab.SelectClaimFromDropDown();
        UploadformClaimtab.SelectFolderDropDpwn();
        UploadformClaimtab.SelectUnfiledDocument();
        UploadformClaimtab.SelectDocumentTypeDropDown();
        UploadformClaimtab.selectMiscallenous();
        reportLog("Upload file", 1);
        UploadformClaimtab.fileUpload();
        UploadformClaimtab.ClickComments();
        reportLog("Select Comments", 1);

        UploadformClaimtab.ClickSubmitButton();
        reportLog("Select Submit", 1);
        UploadformClaimtab.verifyErrorMessagePresence();





//        UploadformClaimtab.SelecttheFolderasEnrollment();
//        reportLog("Select Folder", 1);
//
//        UploadformClaimtab.SelectDocumentTypeasEnrollment();
//        reportLog("Select DocumentType", 1);
//
//        UploadformClaimtab.SelectDocumentTypedropdown();
//        UploadformClaimtab.SelectEnrollmentForm();



      //  UploadformClaimtab.fileDropDown();




        reportLog("===================================", 1);

    }

}
