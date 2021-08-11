package com.exigen.modules.claim.gb_dn.scenarios.imp_ven;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestLimitedOcclusalAdjustmentonceevery3yrs extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 117)
    public void testLimitedOcclusalAdjustmentonceevery3yrs() throws IOException {


        logger = extent.startTest(groupNo + " testLimitedOcclusalAdjustmentonceevery3yrs");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submmision started...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_LimitedOcclusalAdjustmentonceevery3yrs"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for Limited Occlusal Adjustment once every 3yrs " + claimNumber, 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_LimitedOcclusalAdjustmentonceevery3yrsDeny"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber1 = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for Limited Occlusal Adjustment once every 3yrs deny scenario " + claimNumber1, 1);
        reportLog("=======...", 1);
    }
}
