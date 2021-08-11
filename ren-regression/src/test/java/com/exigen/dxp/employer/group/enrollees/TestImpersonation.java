package com.exigen.dxp.employer.group.enrollees;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employer.group.impersonation.ViewAsPage;
import org.testng.annotations.Test;

public class TestImpersonation extends DXPBaseTest {
    @Test(priority = 12)
    public void testImpersonation(){
        logger = extent.startTest("Impersonation");
        navigateToMainPage();
        ViewAsPage viewAs = new ViewAsPage(driver);

        viewAs.clickOnViewAs();
        viewAs.searchWithSubscriberId();
        viewAs.verifyProductScreen();
        viewAs.verifyViewCourage();
//        viewAs.verifyFormTab();
//        viewAs.verifyClaimsTab();
        viewAs.verifyMyProfile();
        viewAs.stopViewAsEnrollee();
    }
}
