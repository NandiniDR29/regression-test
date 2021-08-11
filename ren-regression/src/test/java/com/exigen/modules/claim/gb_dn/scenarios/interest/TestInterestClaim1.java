package com.exigen.modules.claim.gb_dn.scenarios.interest;

import com.exigen.basetest.Util;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestInterestClaim1 extends ClaimGroupBenefitsDNBaseTest {
    @Test(priority = 133)
    public void test_Interest_Claim1() throws IOException {

        logger = extent.startTest(groupNo + " Interest Claim 1" + Util.CurentDateandTime());
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for Certificate Policy...", 1);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        reportLog("Submitting the Claim having CDT Code as D0210 ...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("Interest", "TestData_Claim1"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        reportLog("==============================================", 1);
    }
}
