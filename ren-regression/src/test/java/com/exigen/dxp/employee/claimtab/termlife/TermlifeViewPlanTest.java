package com.exigen.dxp.employee.claimtab.termlife;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.TermlifePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class TermlifeViewPlanTest extends DXPBaseTest {

    @Test(priority = 29)
    public void viewTermLife() throws InterruptedException, IOException {
        logger = extent.startTest("Term Life Plan Details ");
        TermlifePage TLP = new TermlifePage(driver, wait, robot, builder, prop);
        TLP.homePage();
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

        TLP.coverageDetails();

        TLP.coverageInfoCrossButton();

        reportLog("Premium Summary displayed ", 1);
        TLP.clickPremiumSummaryTab();

        TLP.premiumSummaryHeadingValues();

        TLP.clickPremiumSummaryeyeIcon();

        TLP.premiumSummaryDetails();

        TLP.cickedonCheckInfoCrossbuton();

        TLP.homePage();
        reportLog("-------------------- ", 1);

    }
}
