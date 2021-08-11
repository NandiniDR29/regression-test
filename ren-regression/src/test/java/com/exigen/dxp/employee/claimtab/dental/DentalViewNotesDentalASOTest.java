package com.exigen.dxp.employee.claimtab.dental;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.DentalPage;
import org.testng.annotations.Test;

public class DentalViewNotesDentalASOTest extends DXPBaseTest {

    @Test(priority = 13)
    public void ViewDental()  {
        logger = extent.startTest("Dental Check Details ");
        DentalPage Dental1 = new DentalPage(driver, wait, robot, builder, prop);
        //Dental1.Claimtabontop();
        reportLog("Viewing CLaims for Dental ", 1);
        reportLog("-------------------- ", 1);

    }
}
