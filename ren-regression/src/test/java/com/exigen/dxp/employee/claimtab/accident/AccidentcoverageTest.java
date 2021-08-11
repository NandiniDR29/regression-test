package com.exigen.dxp.employee.claimtab.accident;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.AccidentPage;
import org.testng.annotations.Test;

public class AccidentcoverageTest extends DXPBaseTest
{
    @Test(priority = 21)
    public void viewAccident() throws InterruptedException {
        logger = extent.startTest("Group Accident Coverage Details ");
        reportLog("Open pName claim", 0);
        AccidentPage Accident = new AccidentPage(driver, wait, robot, builder, prop);
        Accident.clickLogo();
        Accident.clickAccident();
        Accident.viewCoverage();
        Accident.coverageTab();
        Accident.gettingCPNumber();
        Accident.viewDetailIcon();
        reportLog("complete pName claim", 1);
        Accident.coveragDetails();
        Accident.coverageCrossButton();
        Accident.homePage();
        reportLog("________", 1);
    }
}
