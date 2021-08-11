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

public class Test_2_Converttoamalgam5surface extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 100)
    public void testConverttoamalgam5surface() throws IOException {


        logger = extent.startTest(groupNo + " Convert to amalgam 5surface");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        dentalClaim.create(dentalClaim.getDefaultTestData("Filling", "TestData_Claim2"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for Resin-based composite crown, anterior " + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);
        reportLog("Claim is Adjudicated for Resin-based composite crown, anterior", 1);


        dentalClaim.claimAdjust().perform(tdClaim.getTestData("ClaimAdjust", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(LOGGED_INTAKE);
        reportLog("Claim adjustment completed", 1);

        dentalClaim.claimCancel().perform(tdClaim.getTestData("ClaimCancel", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.CANCELED);
        reportLog("Claim cancelled for Resin-based composite crown, anterior ", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("Filling", "TestData_Claim2_1"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber1 = ClaimSummaryPage.getClaimNumber();

        reportLog("Claim Submitted successfully for Amalgam - four or more surfaces, primary or permanent " + claimNumber1, 1);
        reportLog("Claim is Adjudicated for Amalgam - four or more surfaces, primary or permanent ", 1);

        reportLog("------------------------------------", 1);

    }
}
