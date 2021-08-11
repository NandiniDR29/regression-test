package com.exigen.dxp.employee.claimtab.dental;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.DentalPage;
import org.testng.annotations.Test;

public class DentalViewClaimTest extends DXPBaseTest
{
    @Test(priority = 17)
    public void viewDental() throws InterruptedException {
        logger = extent.startTest("Dental View claim");
        reportLog("Open dental claim", 0);
        DentalPage Dental = new DentalPage(driver, wait, robot, builder, prop);
            Dental.claimTabOnTop();
            reportLog("view claim dropdown open", 1);
            Dental.sortStatus();
            Dental.viewclaimicon();
            reportLog("Click on view claim icon", 1);
            reportLog("Claim details", 1);
            Dental.claimsDetails();
            Dental.clickLogo();
        reportLog("__________", 1);



    }
}
