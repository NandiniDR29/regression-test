package com.exigen.modules.claim.gb_dn.scenarios.accumulators;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class Test_Accumlator_Claim3 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 63)
    public void testAccumlator_Claim3() throws IOException {


        logger = extent.startTest(groupNo + " testAccumlator_Claim3");
        prop.load(fileInput);
        reportLog("Searching for customer "+prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("DentalClaimChild"));
        reportLog("Claim submission started...", 1);
        reportLog("Submitting the Claim for dependent[Child] having CDT Code as D8090,D8670...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("Accumulators", "TestData_Claim3"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        reportLog("--------------------------------", 1);
    }
}
