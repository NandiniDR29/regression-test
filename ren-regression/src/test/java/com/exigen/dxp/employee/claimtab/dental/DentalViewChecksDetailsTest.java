package com.exigen.dxp.employee.claimtab.dental;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.DentalPage;
import org.testng.annotations.Test;

public class DentalViewChecksDetailsTest extends DXPBaseTest {

    @Test(priority = 18)
    public void ViewDental() throws InterruptedException {
        logger = extent.startTest("Dental Check Details ");
        DentalPage Dental1 = new DentalPage(driver, wait, robot, builder, prop);
        Dental1.clickLogo();
        Dental1.claimTabOnTop();
        reportLog("Viewing Claims for Dental ", 1);
        Dental1.sortStatus();
        Dental1.clickViewChecksIcon();
        reportLog("Viewing Check Information for Dental ", 1);
        Dental1.viewCheckForDental();
        reportLog("-------------------- ", 1);

    }
}
