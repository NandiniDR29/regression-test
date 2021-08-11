package com.exigen.dxp.employee.claimtab.dental;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.DentalPage;
import org.testng.annotations.Test;

public class DentalcoverageTest extends DXPBaseTest
{
    @Test(priority = 17)
    public void viewDental() throws InterruptedException {
        logger = extent.startTest("Dental Coverage");
        reportLog("Open dental claim", 0);
        DentalPage Dental = new DentalPage(driver, wait, robot, builder, prop);
        Dental.homePage();
        Dental.clickLogo();
        Dental.clickDental();
//        Dental.sortStatus();
        Dental.viewCoverages();
        Dental.clickOnCoverageTab();
        Dental.gettingPolicyNumber();
        reportLog("complete dental claim", 1);
        Dental.viewCoverageDetails();
        Dental.getCoverageName();
        Dental.getCompleteCoverageDetails();
        Dental.coverageInfoCrossButton();
        Dental.clickLogo();
        reportLog("_____________", 1);
    }
}
