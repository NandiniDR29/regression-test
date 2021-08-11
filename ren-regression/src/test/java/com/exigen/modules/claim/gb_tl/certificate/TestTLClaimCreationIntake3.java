package com.exigen.modules.claim.gb_tl.certificate;

import com.exigen.modules.claim.ClaimGroupBenefitsTLBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestTLClaimCreationIntake3 extends ClaimGroupBenefitsTLBaseTest {
    @Test(priority = 28)
    public void testClaimCreationCertificate() throws IOException {
        logger = extent.startTest(groupNo + " TermLife claim");
        prop.load(fileInput);
        pName = "other";
        reportLog("Searching for Customer", 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnTLCp();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Navigate to claim module", 1);
        //createDefaultTermLifeInsuranceClaimForCertificatePolicy();
        termLifeClaim.create(termLifeClaim.getDefaultTestData("DataGatherCertificate_Intake3", "TestData"));

        reportLog("Creating the claim", 1);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Number" + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
     reportLog("==========================================", 1);
    }
}