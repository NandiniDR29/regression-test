package com.exigen.dxp.employee.formtab;

import com.exigen.dxp.DXPBaseTest;
import org.apache.pdfbox.pdmodel.graphics.predictor.Up;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestUploadForm extends DXPBaseTest {

    @Test(priority = 33)
    public void TestUploadFormTab() throws Exception {
        logger = extent.startTest("Verifying Upload Form-Tab ");
       UploadFormEOIPage Uploadformtab = new UploadFormEOIPage(driver, wait, robot, builder, prop);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
        reportLog("Open DXP app", 0);
        Thread.sleep(100);
        Uploadformtab.homePage();
        Uploadformtab.clickFormstab();  /// DOne
        reportLog("Clicked on Upload Form tab", 1);
        Uploadformtab.ClickUploadFormTab();  /// DOne


        Uploadformtab.ClickFuntionalAreadropdown(); /// DOne
        reportLog("Select FunctionalArea", 1);

        Uploadformtab.SelectFunctionalAreasGroup(); /// DOne
        Uploadformtab.SelecttheFolderasEnrollment();
        reportLog("Select Folder", 1);

        Uploadformtab.SelectDocumentTypeasEnrollment();
        reportLog("Select DocumentType", 1);

        Uploadformtab.SelectDocumentTypedropdown();
        Uploadformtab.SelectEnrollmentForm();
        Uploadformtab.fileUpload();
        reportLog("Upload file", 1);

        Uploadformtab.ClickComments();
        reportLog("Select Comments", 1);

        Uploadformtab.ClickSubmitButton();
        reportLog("Select Submit", 1);
        Uploadformtab.verifyErrorMessagePresence();
       // Uploadformtab.CrossButton();
        Uploadformtab.homePage();


//       reportLog("Navigate  to FormTab", 1);
//       Uploadformtab.clickFormstab();
//       reportLog("Select Document Library option ", 1);
//       Uploadformtab.DocumentLibrary();
//       Uploadformtab.selectFunctionalAreaasGroupDocumentLibrary();
//       Uploadformtab.selectFunctionalAreaasCustoemrDocumentLibraryas();
//       Uploadformtab.selectFunctionalAreaasGroupDocumentLibrary();








     reportLog("===================================", 1);

    }
}
