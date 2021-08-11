package com.exigen.dxp.employer.claims;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

public class ViewClaimTest extends DXPBaseTest {

    @Test(priority = 34)
    public void testViewClaim() throws Exception {
        logger = extent.startTest("View claims");
        prop.load(fileInput);
        navigateToMainPage();
        ViewClaimPage vcp=new ViewClaimPage(driver,wait,robot,builder,prop);

        vcp.clickOnRenLogo();

        reportLog("Search MP number", 1);
        vcp.sendMpNumber(prop.getProperty("ReferenceMasterPolicy"));

        reportLog("Select View Enrollees icon", 1);
        vcp.selectViewEnrollees();
        vcp.verifyIcons1();

        reportLog("Search for Customer",1);
        vcp.enterNames(prop.getProperty("ClaimFirstName"),prop.getProperty("ClaimLastName"));

        reportLog("Claim details are displayed below :",1);
        vcp.selectViewClaim();

        reportLog("Cheque details are displayed below :",1);
        vcp.selectViewChecks();

        reportLog("Download the claim",1);
        vcp.selectDownload();

        reportLog("Upload the claim",1);
        vcp.selectUploadClaim();
        vcp.fileUpload();
        vcp.clickComments();
        vcp.clickSubmitButton();
        vcp.verifyErrorMessagePresence();

        reportLog("Filter options are displayed below :",1);
        vcp.selectUploadFilter();

        reportLog("Status drop down list are displayed below :",1);
        vcp.selectStatus();

        reportLog("Select Reset button",1);
        vcp.selectReset();
    }
}
