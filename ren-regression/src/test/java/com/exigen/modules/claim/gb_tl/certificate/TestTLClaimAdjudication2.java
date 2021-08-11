package com.exigen.modules.claim.gb_tl.certificate;

import com.exigen.modules.claim.ClaimGroupBenefitsTLBaseTest;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimAdjudicationBenefitPage;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestTLClaimAdjudication2 extends ClaimGroupBenefitsTLBaseTest {
    @Test(priority = 28)
    public void testClaimAddBenefit2() throws IOException {
        logger = extent.startTest(groupNo + " TermLife claim Adjudication");
        prop.load(fileInput);
        pName = "other";
        reportLog("Searching for Customer", 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnTLCp();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Create Claim", 1);
        termLifeClaim.create(termLifeClaim.getDefaultTestData("DataGatherCertificate_Adjudication1", TestDataKey.DEFAULT_TEST_DATA_KEY));
        reportLog("Open Claim", 1);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        claim.claimOpen().perform();
        reportLog("Adding Benefit", 1);
        claim.addBenefit().perform(tdClaim.getTestData("NewBenefitAdjudication1", "TestData_Death"));
        reportLog("Add Single Benefit Calculations for Benefit to Claim #" + claimNumber, 1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmountAdjudication1", "TestData"), 1);
        assertThat(ClaimAdjudicationBenefitPage.tableAllSingleBenefitCalculations).hasRows(1);
        assertThat(ClaimAdjudicationBenefitPage.tableAllSingleBenefitCalculations.getRow(1).getCell(ClaimConstants.ClaimAllSingleBenefitCalculationsTable.SINGLE_BENEFIT_NUMBER)).hasValue("1-1");
        reportLog("==========================================", 1);

    }
}
