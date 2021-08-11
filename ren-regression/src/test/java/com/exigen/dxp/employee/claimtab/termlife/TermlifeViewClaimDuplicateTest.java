package com.exigen.dxp.employee.claimtab.termlife;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employee.claimtab.TermlifePage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;

public class TermlifeViewClaimDuplicateTest extends DXPBaseTest {

    @Test(priority = 26)
    public void viewTermLife() throws InterruptedException, IOException {
        logger = extent.startTest("Term Life View Claims ");
        TermlifePage TLP = new TermlifePage(driver, wait, robot, builder, prop);
        reportLog("Searching for View Claim ", 0);
        TLP.homePage();
        TLP.claimTabOnTop();
        reportLog("Selected Term Life Product ", 1);
        assertSoftly(softly -> {
            softly.assertThat(TLP.getPageTitle().getText()).isEqualToIgnoringCase("Claims");
            softly.assertThat(TLP.getColumnHeader().get(0).getText().equalsIgnoreCase("Claim Number"));
            softly.assertThat(TLP.getColumnHeader().get(1).getText().equalsIgnoreCase("First Name"));
            softly.assertThat(TLP.getColumnHeader().get(2).getText().equalsIgnoreCase("Last Name"));
            softly.assertThat(TLP.getSortableColumnHeader().get(0).getText().equalsIgnoreCase("Loss Date"));
            softly.assertThat(TLP.getSortableColumnHeader().get(1).getText().equalsIgnoreCase("Status"));
            softly.assertThat(TLP.getColumnHeader().get(5).getText().equalsIgnoreCase("Policy Product"));
            softly.assertThat(TLP.getColumnHeader().get(6).getText().equalsIgnoreCase("Amount Paid"));
            softly.assertThat(TLP.getColumnHeader().get(0).getText().equalsIgnoreCase("Action"));
        });
        TLP.sortStatus();
        TLP.viewClaimIcon();
        assertSoftly(softly -> {
            softly.assertThat(TLP.getClaimOddFieldList().get(0).getText().equalsIgnoreCase("Claim Number"));
            softly.assertThat(TLP.getClaimOddFieldList().get(1).getText().equalsIgnoreCase("Received Date"));
            softly.assertThat(TLP.getClaimOddFieldList().get(2).getText().equalsIgnoreCase("Insured Name"));
            softly.assertThat(TLP.getClaimOddFieldList().get(3).getText().equalsIgnoreCase("Type Of Claim"));
            softly.assertThat(TLP.getClaimOddFieldList().get(4).getText().equalsIgnoreCase("Date Of Loss"));
            softly.assertThat(TLP.getClaimOddFieldList().get(5).getText().equalsIgnoreCase("Claim Status"));
            softly.assertThat(TLP.getClaimOddFieldList().get(6).getText().equalsIgnoreCase("Policy Product"));
            softly.assertThat(TLP.getClaimOddFieldList().get(7).getText().equalsIgnoreCase("Insured Patient"));
            softly.assertThat(TLP.getClaimOddFieldList().get(8).getText().equalsIgnoreCase("Total Incurred"));
            softly.assertThat(TLP.getClaimOddFieldList().get(9).getText().equalsIgnoreCase("Payee Type"));
            softly.assertThat(TLP.getCoverageEvaluationHeader().get(0).getText().equalsIgnoreCase("Benefit Type"));
            softly.assertThat(TLP.getCoverageEvaluationHeader().get(1).getText().equalsIgnoreCase("Coverage Type"));
            softly.assertThat(TLP.getCoverageEvaluationHeader().get(2).getText().equalsIgnoreCase("Eligibility Verified"));
            softly.assertThat(TLP.getCoverageEvaluationHeader().get(3).getText().equalsIgnoreCase("Date Of Verification"));
            //softly.assertThat(TLP.getCoverageEvaluationHeader().get(4).getText().equalsIgnoreCase("Approved Through Date"));
            softly.assertThat(TLP.getCoverageEvaluationHeader().get(4).getText().equalsIgnoreCase("Liability Decision"));
            softly.assertThat(TLP.getCoverageEvaluationHeader().get(5).getText().equalsIgnoreCase("Supporting Documentation Received Date"));

        });
        reportLog("validate Data Present In Each Section", 1);
        TLP.validateDataPresentInEachSection();
        reportLog("Check Claim available for next validation ", 1);

        boolean result = TLP.checkClaimAvailableForNextValidation();
        if(result==true){
            reportLog("Click on claim ", 1);
            TLP.validateRemainingClaim(TLP.gettlViewIconList());
        }
//        TLP.claimsdetails();
//        reportLog("View Claim got selected ", 1);
//        //TLP.claimscoverageEvaluation();
//        reportLog("View Claim details printed ", 1);
//        TLP.homepage();
        reportLog("----------------------------- ", 1);
    }
}
