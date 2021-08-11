package com.exigen.modules.claim.gb_std.certificate;

import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.ClaimGroupBenefitsSTDBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestSTDClaimCreationIntake2 extends ClaimGroupBenefitsSTDBaseTest {
    @Test(priority = 38)
    public void testClaimCreationSTD() throws IOException {
        logger = extent.startTest(groupNo + " TestSTDClaimCreationIntake2");
        prop.load(fileInput);
        pName = "other";
        reportLog("Searching for customer ", 0);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnSTDCp();
        reportLog("Searching for Cp : " + cpNumber, 1);
        search(cpNumber);
        reportLog("Navigate to claim module", 1);
        disabilityClaim.create(disabilityClaim.getSTDTestData().getTestData("DataGatherCertificateIntake1", "TestData"));
        reportLog("Creating the claim", 1);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Number" + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        reportLog("==========================================", 1);
    }
}
