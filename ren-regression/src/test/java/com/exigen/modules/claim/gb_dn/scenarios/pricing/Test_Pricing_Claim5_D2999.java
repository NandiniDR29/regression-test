package com.exigen.modules.claim.gb_dn.scenarios.pricing;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class Test_Pricing_Claim5_D2999 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 141)
    public void testPricing_Claim5() throws IOException {


        logger = extent.startTest(groupNo + " testPricing_Claim5_D2999");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("Pricing", "TestData_PricingClaim5"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        reportLog("-----------------------", 1);
    }
}
