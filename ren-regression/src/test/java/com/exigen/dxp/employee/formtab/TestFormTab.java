package com.exigen.dxp.employee.formtab;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.helptab.resource.ResourcePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;

public class TestFormTab extends DXPBaseTest {
    @Test(priority = 7)
    public void testFormTab() throws Exception {
        logger = extent.startTest("TestFormTab");
        prop.load(fileInput);
        FormPage formPage = new FormPage(driver);
        ResourcePage resourcePage = new ResourcePage(driver);
        reportLog("Navigate  to Documents tab ", 0);
        formPage.homePage();
        formPage.clickOnFormTab();

//        assertSoftly(softly -> {
//            softly.assertThat(resourcePage.getPageTitle().getText()).isEqualToIgnoringCase("Forms");
//            softly.assertThat(resourcePage.getTableHeader().getText()).isEqualToIgnoringCase("Resources");
//            softly.assertThat(resourcePage.getClaimFormsLink().getText()).isEqualToIgnoringCase("Claim forms");
//            softly.assertThat(formPage.getDownloadForm().getText()).isEqualToIgnoringCase("Download form");
//            softly.assertThat(formPage.getUploadForm().getText()).isEqualToIgnoringCase("Upload form");
//        });
        reportLog("Select Upload", 1);
        formPage.clickOnUploadTab();
        reportLog("Select FunctionalArea", 1);
        formPage.selectFunctionalArea();
        formPage.selectOptionFunctionalAreaDropDown("Customer");
        reportLog("Select Folder", 1);
        formPage.selectFolder();
        formPage.selectOptionFolderDropDown("EOI");
        reportLog("Select DocumentType", 1);
        formPage.selectDocumentType();
        formPage.selectOptionDocumentTypeDropDown("EOI Letter");
        reportLog("Upload file", 1);
        formPage.fileUpload();
        Assert.assertEquals(formPage.getFile().getAttribute("title"),"EOIMinnesota.pdf");
        reportLog("Select Comments", 1);
        formPage.enterComments();
        reportLog("Select Submit", 1);
        formPage.clickOnSubmit();
        formPage.verifyErrorMessagePresence();



        formPage.homePage();
        reportLog("Navigate  to FormTab", 1);
        formPage.clickOnFormTab();
        reportLog("Select Functional areas", 1);
        formPage.Documentlibrary();
        formPage.selectFunctionalArea();
        formPage.selectOptionFunctionalAreaDropDownInFormTab("Customer");

        reportLog("Select customer as an option", 1);
        formPage.selectDocumentType();
        reportLog("Select Document Type", 1);
        formPage.selectOptionDropDown("EOI");
        reportLog("Verify Document upload result", 1);
        Assert.assertEquals(formPage.getViewDocumentIcon(), "View Document");
        formPage.downLoadFile();
        reportLog("===================================", 1);


    }
}

