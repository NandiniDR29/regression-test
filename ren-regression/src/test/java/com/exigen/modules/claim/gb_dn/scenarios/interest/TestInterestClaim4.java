package com.exigen.modules.claim.gb_dn.scenarios.interest;

import com.exigen.basetest.Util;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestInterestClaim4 extends ClaimGroupBenefitsDNBaseTest {
    @Test(priority = 136)
    public void test_Interest_Claim4() throws IOException {

        logger = extent.startTest(groupNo + " Interest Claim 4" + Util.CurentDateandTime());
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for Certificate Policy...", 1);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        reportLog("Submitting the Claim having CDT Code as D2790 ...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("Interest", "TestData_Claim4"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        reportLog("==============================================", 1);
    }
}
