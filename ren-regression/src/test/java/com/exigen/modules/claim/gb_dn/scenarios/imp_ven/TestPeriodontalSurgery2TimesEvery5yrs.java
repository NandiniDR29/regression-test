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

public class TestPeriodontalSurgery2timesevery5yrs extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 120)
    public void testPeriodontalSurgery2timesevery5yrs() throws IOException {


        logger = extent.startTest(groupNo + " testPeriodontalSurgery2timesevery5yrs");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submmision started...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_PeriodontalSurgery2timesevery5yrs"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for Periodontal Surgery2 time severy 5yrs " + claimNumber, 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_PeriodontalSurgery2timesevery5yrs1"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber1 = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for Periodontal Surgery2 time severy 5yrs deny scenario " + claimNumber1, 1);
        reportLog("=======...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_PeriodontalSurgery2timesevery5yrsDeny"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber2 = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for Periodontal Surgery2 time severy 5yrs deny scenario " + claimNumber2, 1);
        reportLog("=======...", 1);

    }
}
