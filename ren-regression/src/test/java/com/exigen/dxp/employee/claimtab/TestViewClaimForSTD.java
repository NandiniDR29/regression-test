package com.exigen.dxp.employee.claimtab;

import com.exigen.dxp.DXPBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;

public class TestViewClaimForSTD extends DXPBaseTest {
    @Test(priority = 14)
    public void testViewClaimForSTD() throws Exception {
        logger = extent.startTest("TestViewClaimForSTD");
        prop.load(fileInput);
        reportLog("Open DXP app", 0);
        ViewClaimPage viewClaimPage = new ViewClaimPage(driver);
        reportLog("Click on claim ", 1);
        viewClaimPage.navigateToClaim();
        reportLog("Sort Claim Status ", 1);
        viewClaimPage.sortStatus();
        reportLog("Click On STD ViewIcon", 1);
        viewClaimPage.clickOnSTDViewIcon();
        reportLog("Verify Page Section Title", 1);
        Assert.assertEquals(viewClaimPage.returnSectionTitle().getText(), "Claim Details");
        assertSoftly(softly -> {
            softly.assertThat(viewClaimPage.getClaimOddFieldList().get(0).getText().equalsIgnoreCase("Claim Number"));
            softly.assertThat(viewClaimPage.getClaimOddFieldList().get(1).getText().equalsIgnoreCase("Received Date"));
            softly.assertThat(viewClaimPage.getClaimOddFieldList().get(2).getText().equalsIgnoreCase("Insured Name"));
            softly.assertThat(viewClaimPage.getClaimOddFieldList().get(3).getText().equalsIgnoreCase("Type Of Claim"));
            softly.assertThat(viewClaimPage.getClaimOddFieldList().get(4).getText().equalsIgnoreCase("Date Of Loss"));
            softly.assertThat(viewClaimPage.getClaimOddFieldList().get(5).getText().equalsIgnoreCase("Claim Status"));
            softly.assertThat(viewClaimPage.getClaimOddFieldList().get(6).getText().equalsIgnoreCase("Policy Product"));
            softly.assertThat(viewClaimPage.getClaimOddFieldList().get(7).getText().equalsIgnoreCase("Insured Patient"));
            softly.assertThat(viewClaimPage.getClaimOddFieldList().get(8).getText().equalsIgnoreCase("Total Incurred"));
            softly.assertThat(viewClaimPage.getClaimOddFieldList().get(9).getText().equalsIgnoreCase("Payee Type"));
            softly.assertThat(viewClaimPage.getCoverageEvaluationHeader().get(0).getText().equalsIgnoreCase("Benefit Type"));
            softly.assertThat(viewClaimPage.getCoverageEvaluationHeader().get(1).getText().equalsIgnoreCase("Coverage Type"));
            softly.assertThat(viewClaimPage.getCoverageEvaluationHeader().get(2).getText().equalsIgnoreCase("Eligibility Verified"));
            softly.assertThat(viewClaimPage.getCoverageEvaluationHeader().get(3).getText().equalsIgnoreCase("Date Of Verification"));
            softly.assertThat(viewClaimPage.getCoverageEvaluationHeader().get(4).getText().equalsIgnoreCase("Approved Through Date"));
            softly.assertThat(viewClaimPage.getCoverageEvaluationHeader().get(5).getText().equalsIgnoreCase("Liability Decision"));
            softly.assertThat(viewClaimPage.getCoverageEvaluationHeader().get(6).getText().equalsIgnoreCase("Supporting Documentation Received Date"));
            softly.assertThat(viewClaimPage.getDisabilityDateColumn().get(0).getText().equalsIgnoreCase("Last Worked Date"));
            softly.assertThat(viewClaimPage.getDisabilityDateColumn().get(1).getText().equalsIgnoreCase("Return To Work Date"));

//            softly.assertThat(viewClaimPage.getBenefitPeriodHeader().get(0).getText().equalsIgnoreCase("Benefit Period Start Date"));
//            softly.assertThat(viewClaimPage.getBenefitPeriodHeader().get(1).getText().equalsIgnoreCase("Benefit Period"));
//            softly.assertThat(viewClaimPage.getBenefitPeriodHeader().get(2).getText().equalsIgnoreCase("Benefit Period End Date"));
//            softly.assertThat(viewClaimPage.getBenefitPeriodHeader().get(3).getText().equalsIgnoreCase("Benefit Period Completed"));
//            softly.assertThat(viewClaimPage.getBenefitPeriodHeader().get(4).getText().equalsIgnoreCase("Benefit Period Remaining"));
//            softly.assertThat(viewClaimPage.getEliminationPeriodHeader().get(0).getText().equalsIgnoreCase("Elimination Period Start Date"));
//            softly.assertThat(viewClaimPage.getEliminationPeriodHeader().get(1).getText().equalsIgnoreCase("Elimination Period"));
//            softly.assertThat(viewClaimPage.getEliminationPeriodHeader().get(2).getText().equalsIgnoreCase("Elimination Period End Date"));
        });
        reportLog("validate Data Present In Each Section", 1);
        viewClaimPage.validateDataPresentInEachSection();
        reportLog("Check Claim available for next validation ", 1);
        boolean result = viewClaimPage.checkClaimAvailableForNextValidation();
        if(result==true){
            reportLog("Click on claim ", 1);
            viewClaimPage.validateRemainingClaim(viewClaimPage.getStdViewIconList());
        }
        reportLog("===================================", 1);
    }
}
