package com.exigen.modules.claim.gb_tl.certificate;

import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.ClaimGroupBenefitsTLBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestTLClaimCreationIntake2 extends ClaimGroupBenefitsTLBaseTest {
    @Test(priority = 28)
    public void testClaimCreationLife_Intake2() throws IOException {
        logger = extent.startTest(groupNo + " TermLife claim");
        prop.load(fileInput);
        pName = "other";
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnTLCp();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);

        reportLog("Navigate to claim module", 1);
        termLifeClaim.create(termLifeClaim.getDefaultTestData("DataGatherCertificate_Intake2", "TestData"));

        reportLog("Creating the claim", 1);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Number" + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        reportLog("==========================================", 1);
    }
}