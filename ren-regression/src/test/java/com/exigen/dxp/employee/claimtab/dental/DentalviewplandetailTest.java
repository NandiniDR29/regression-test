package com.exigen.dxp.employee.claimtab.dental;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.DentalPage;
import org.testng.annotations.Test;

public class DentalviewplandetailTest extends DXPBaseTest
{
    @Test(priority = 19)
    public void viewDetailDental() throws InterruptedException {
        logger = extent.startTest("View dental detail");
        reportLog("Open dental view plan", 0);
        DentalPage Dental = new DentalPage(driver, wait, robot, builder, prop);
        reportLog("Open dental view", 1);
        Dental.clickLogo();
        Dental.clickDental();
        reportLog("click on dental view plan icon", 0);
        Dental.clickOnViewPlanDetail();
        Dental.gettingPolicyNumber_Viewplan();
        Dental.clickExpand();
        Dental.claimsDetail_MoreInformation();
        Dental.clickLogo();
        reportLog("_____", 0);
    }
}
