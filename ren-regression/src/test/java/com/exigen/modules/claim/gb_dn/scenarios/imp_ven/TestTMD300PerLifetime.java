package com.exigen.modules.claim.gb_dn.scenarios.imp_ven;

import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestTMD300PerLifetime extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 129)
    public void testTMD300PerLifetime() throws IOException {


        logger = extent.startTest(groupNo + " testTMD300PerLifetime");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submmision started...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_TMD300PerLifetime"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for TMD300 Per Life time " + claimNumber, 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_TMD300PerLifetimeDeny"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber1 = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully for TMD300 Per Life time deny scenario " + claimNumber1, 1);
        reportLog("=======...", 1);
    }
}
