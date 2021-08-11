package com.exigen.dxp.employee.claimtab.termlife;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.TermlifePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class TermlifeViewCoverageTest extends DXPBaseTest {

    @Test(priority = 27)
    public void viewTermLife() throws InterruptedException, IOException {
        logger = extent.startTest("Term Life Coverage Details ");
        TermlifePage TLP = new TermlifePage(driver, wait, robot, builder, prop);

        reportLog("Searching for View Claim ", 0);

        TLP.selectTermLifeProduct();
        reportLog("Term Life Product got selected ", 1);

        TLP.viewCoverage();
        reportLog("View Coverage for term life got selected ", 1);

        TLP.coverageDetailsCoverageTab();
        reportLog("Coverages Tab got selected ", 1);
        TLP.gettingcpnumber();

        TLP.clickOnViewCoverageIcon();

        TLP.viewCoverageName();
        reportLog("Displays the Coverage name ", 1);

        TLP.coverageDetails();

        TLP.coverageInfoCrossButton();
        TLP.homePage();
        reportLog("-------------------- ", 1);

    }
}
