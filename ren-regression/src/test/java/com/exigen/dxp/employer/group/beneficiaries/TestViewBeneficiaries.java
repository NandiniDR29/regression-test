package com.exigen.dxp.employer.group.beneficiaries;

import com.exigen.dxp.DXPBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestViewBeneficiaries  extends DXPBaseTest {
    @Test(priority = 16)
    public void testViewBeneficiaries() throws IOException {
        logger = extent.startTest("TestViewBeneficiaries");
        navigateToMainPage();
        BeneficiariesPage bp = new BeneficiariesPage(driver);
        bp.navigateToMainPage();
        reportLog("Verify Page Title",0);
        commonSteps(prop.getProperty("NewPersonBeneficiariesID"),bp);
        bp.navigateToMainPage();
        reportLog("Verify Page Title",1);
        commonSteps(prop.getProperty("NewNonPersonBeneficiariesID"),bp);
        reportLog("=============",1);
    }
    public void commonSteps(String subscriberID,  BeneficiariesPage bp) throws IOException {
        Assert.assertEquals(bp.getSectionTitle().getText(), "Groups");
        reportLog("ClickOn View Enrollee",1);
        bp.clickOnViewEnrollees();
        reportLog("Verify Page Title",1);
        Assert.assertEquals(bp.getSectionTitle().getText(), "Enrollees");
        reportLog("Navigate to Products page",1);
        bp.clickOnViewProduct(subscriberID);
        reportLog("Select Term Life",1);
        bp.clickOnTermLife();
        reportLog("Verify Coverage Page Title",1);
        Assert.assertEquals(bp.getSectionTitle().getText(), "Coverages");
        reportLog("Collect And Print Coverage Table Information",1);
        bp.collectCoverageTableInformation();
        reportLog("Navigate to Coverage Details page",1);
        bp.clickOnViewCoverage();
        Assert.assertEquals(bp.getSectionTitle().getText(), "Coverage Details");
        reportLog("Select Beneficiaries",1);
        bp.clickOnBeneficiaries();
        reportLog("Verify to Beneficiaries page Title",1);
        Assert.assertEquals(bp.getBeneficiaries().getText(), "BENEFICIARIES");
        reportLog("Verify Page Number",1);
        Assert.assertEquals(bp.getPageNum().getText(), "5 of 6");
        reportLog("Collect Beneficiaries Section info",1);
        bp.collectBeneficiariesTableInformation();
        reportLog("Navigate to Beneficiaries Details Section",1);
        for (int i = 0; i <bp.rowsSize-1 ; i++) {
            bp.clickOnViewDetails(i);
            reportLog("Verify Beneficiaries Details page Title",1);
            Assert.assertEquals(bp.getPopUpHeader().getText(), "Beneficiaries Details:");
            reportLog("Collect and Print Beneficiaries Data",1);
            bp.collectBeneficiariesPopUpTablesInformation();
            bp.closePopUp();}
    }
}