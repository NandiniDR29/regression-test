package com.exigen.modules.claim.gb_dn.certificate;

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

public class TestCancelClaimUseCase extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 36)
    public void testCancelClaimUseCase() throws IOException {

        logger = extent.startTest(groupNo + " testCancelClaim");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer to submit the claim...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        reportLog("Submitting the Claim having CDT Code as D9930 ...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_8"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        reportLog("Claim Cancelled successfully...", 1);
        dentalClaim.claimCancel().perform(tdClaim.getTestData("ClaimCancel", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.CANCELED);
        reportLog("============================================", 1);


    }
}
