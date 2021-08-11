package com.exigen.modules.claim.gb_std.certificate;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.data.TestData;
import com.exigen.modules.claim.ClaimGroupBenefitsSTDBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.tabs.BenefitCoverageEvaluationTab;
import com.exigen.ren.main.pages.summary.claim.ClaimAdjudicationBenefitPage;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.modules.claim.gb_ltd_st_std.metadata.BenefitCoverageEvaluationTabMetaData.INSURED_PERSON_COVERAGE_EFFECTIVE_DATE;

public class TestClaimAddSingleBenefitCalculationsCertificate extends ClaimGroupBenefitsSTDBaseTest {
@Test
    public void testClaimAddBenefit() throws IOException {
        logger = extent.startTest(groupNo+" TestClaimAddSingleBenefitCalculationsCertificate");
        prop.load(fileInput);
        reportLog("Searching for Customer", 0);
        search(prop.getProperty("CustomerNumber"));
        createDefaultShortTermDisabilityClaimForCertificatePolicy();
        reportLog("Creating Claim...", 1);
        claim.claimOpen().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        claim.addBenefit().perform(tdClaim.getTestData("NewBenefit", "TestData_STD_OtherValues")
                .mask(TestData.makeKeyPath(BenefitCoverageEvaluationTab.class.getSimpleName(), INSURED_PERSON_COVERAGE_EFFECTIVE_DATE.getLabel())));
        reportLog("Adding Benefit",1);
        reportLog("Add Single Benefit Calculations for Benefit to Claim #"+claimNumber,1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmount", "TestData_STD"), 2);
        assertThat(ClaimAdjudicationBenefitPage.tableAllSingleBenefitCalculations).hasRows(1);
        assertThat(ClaimAdjudicationBenefitPage.tableAllSingleBenefitCalculations.getRow(1).getCell(ClaimConstants.ClaimAllSingleBenefitCalculationsTable.SINGLE_BENEFIT_NUMBER)).hasValue("2-1");
        reportLog("==========================================",1);

    }
}
