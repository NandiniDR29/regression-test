package com.exigen.modules.claim.gb_dn.scenarios.fillings;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ClaimConstants.ClaimStatus.LOGGED_INTAKE;

public class Test_5_CombinetoD0210_Spouse extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 132)
    public void testombinetoD0210_Spouse() throws IOException {


        logger = extent.startTest(groupNo + " Combine to D0210_Spouse");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        //To TestDXP
        CommonGenericMethods.searchSpecificParticipant("JAIN","9120");
        String cpNumber = returnDentalCPForSpecifiedParticipant();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        dentalClaim.create(dentalClaim.getDefaultTestData("Filling", "TestData_Claim5"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for Panoramic radiographic image " + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);
        reportLog("Claim is Adjudicated ", 1);

        dentalClaim.claimAdjust().perform(tdClaim.getTestData("ClaimAdjust", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(LOGGED_INTAKE);
        reportLog("Claim adjustment completed", 1);

        dentalClaim.claimCancel().perform(tdClaim.getTestData("ClaimCancel", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.CANCELED);
        reportLog("Claim cancelled for Panoramic radiographic image ", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("Filling", "TestData_Claim5_1"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber1 = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for Intraoral - Complete series of radiographic images " +  claimNumber1, 1);
        reportLog("---------------------------------", 1);

    }
}
