package com.exigen.dxp.employee.claimtab.termlife;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.TermlifePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class TermlifeViewClaimTest extends DXPBaseTest {

    @Test(priority = 26)
    public void viewTermLife() throws InterruptedException, IOException {
        logger = extent.startTest("Term Life View Claims ");
        TermlifePage TLP = new TermlifePage(driver, wait, robot, builder, prop);
        reportLog("Searching for View Claim ", 0);
        TLP.homePage();
        TLP.claimTabOnTop();
        reportLog("Selected Term Life Product ", 1);
        TLP.sortStatus();
        TLP.viewClaimIcon();
        TLP.claimsDetails();
        reportLog("View Claim got selected ", 1);
        //TLP.claimscoverageEvaluation();
        reportLog("View Claim details printed ", 1);
        TLP.homePage();
        reportLog("----------------------------- ", 1);
    }
}
