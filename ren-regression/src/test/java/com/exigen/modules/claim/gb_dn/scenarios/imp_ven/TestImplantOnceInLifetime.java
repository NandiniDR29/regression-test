package com.exigen.modules.claim.gb_dn.scenarios.imp_ven;

import com.exigen.basetest.Util;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestImplantOnceInLifetime extends ClaimGroupBenefitsDNBaseTest {
    @Test(priority = 114)
    public void testImplantOnceInLifetime() throws IOException {

        logger = extent.startTest(groupNo + " ImplantOnceInLifetime " + Util.CurentDateandTime());
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for Certificate Policy...", 1);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_ImplantOnceInLifetime"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        reportLog("Claim Submitted successfully for Implant Once In Life time "+ ClaimSummaryPage.getClaimNumber(), 1);

        reportLog("Claim submission started...", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_ImplantOnceInLifetime_Decline"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        reportLog("Claim Submitted successfully for Implant Once In Life time deny scenario "+ ClaimSummaryPage.getClaimNumber(), 1);

        reportLog("==============================================", 1);
    }
}
