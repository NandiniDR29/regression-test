package com.exigen.dxp.employee.claimtab.accident;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.AccidentPage;
import org.testng.annotations.Test;

public class AccidentViewClaimTest extends DXPBaseTest {
    @Test(priority = 20)
    public void viewAccident() throws InterruptedException {
        logger = extent.startTest("Group Accident View Claim ");
        reportLog("Open pName claim", 0);
        AccidentPage Accident = new AccidentPage(driver, wait, robot, builder, prop);
        Accident.clickLogo();
        Accident.clickViewClaimButton();
        Accident.sortStatus();
        reportLog("view claim dropdown open", 1);
        Accident.viewClaimIcon();
        reportLog("Click on view claim icon", 1);
        Accident.claimsDetails();
        reportLog("pName Claim details", 1);
        Accident.clickLogo();
        reportLog("_________", 1);
    }
}
