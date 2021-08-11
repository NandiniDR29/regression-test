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

public class Test_1_Convertinlaytoresinfilling extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 99)
    public void testConvertinlaytoresinfilling() throws IOException {


        logger = extent.startTest(groupNo + " Convert in lay to resin filling");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));

        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);

        reportLog("Claim submission started for Inlay ", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("Filling", "TestData_Claim1"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for Inlay " + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);
        reportLog("Claim Adjudicated for Inlay ", 1);


        dentalClaim.claimAdjust().perform(tdClaim.getTestData("ClaimAdjust", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(LOGGED_INTAKE);


        dentalClaim.claimCancel().perform(tdClaim.getTestData("ClaimCancel", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.CANCELED);
        reportLog("Claim cancelled for Inlay ", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("Filling", "TestData_Claim1_1"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        reportLog("Claim submission started for Resin-based composite ", 1);
        reportLog("Claim Adjudicated for Resin-based composite ", 1);
        String claimNumber1 = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for Resin-based composite " + claimNumber1, 1);
        reportLog("---------------------------------------------------------------" + claimNumber1, 1);


    }
}
