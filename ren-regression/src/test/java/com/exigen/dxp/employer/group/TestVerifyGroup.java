package com.exigen.dxp.employer.group;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

public class TestVerifyGroup extends DXPBaseTest {
    @Test(priority = 7)
    public void testVerifyGroupDetail(){
        logger = extent.startTest("Verify Group Detail");
        navigateToMainPage();
        EmployerGroupPage groupPage = new EmployerGroupPage(driver);
        reportLog("Verify Group Customer ID ", 0);
        groupPage.verifyUniqueGroupNumber();
        reportLog("Billing Account Associated with Group", 1);
        groupPage.getBillingAccount();
        reportLog("Verify all the Billing account for the Group is Active", 1);
        groupPage.verifyAllBillingAccountIsActive();
        reportLog("Verify Group is having unique Tax ID", 1);
        groupPage.verifyUniqueTaxId();
        reportLog("Verify Group Name Search", 1);
        groupPage.verifyGroupNameSearch();
        reportLog("Verify Group Number filter", 1);
        groupPage.verifyGroupNumberFilter();
        reportLog("Verify Billing Account Number filter", 1);
        groupPage.verifyBillingAccountFilter();
        reportLog("Verify Tax Id filter", 1);
        groupPage.verifyTaxIdFilter();
        reportLog("Verify Policy Number filter", 1);
        //groupPage.verifyPolicyNumberFilter("MP0000165864");
        reportLog("==================================", 1);
    }
}
