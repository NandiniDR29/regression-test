package com.exigen.dxp.employee.claimtab;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

public class TestClaimSubmission extends DXPBaseTest {
    @Test(enabled = false)
    public void testClaimSubmission() throws Exception {
        logger = extent.startTest("TestClaimSubmission");
        prop.load(fileInput);
        reportLog("Open DXP app", 0);
        ClaimTabPage cp = new ClaimTabPage(driver, robot, js);
        reportLog("Click on claim DropDown ", 1);
        cp.selectDropDown();
        reportLog("Select submit ", 1);
        cp.selectSubmitClaim();
        reportLog("Select Product ", 1);
        cp.selectProduct();
        reportLog("Select Policy ", 1);
        cp.selectPolicy();
        reportLog("Select enter Data of Loss ", 1);
        cp.enterDateOfLoss();
        reportLog("Click on claim ", 1);
        cp.submitClaim();
        reportLog("Click on claim ", 1);
        cp.clickOnClaimTab();
        reportLog("Verify claim Submission ", 1);
        cp.verifyClaimSubmissionResult();
        reportLog("===================================", 1);
    }
}
