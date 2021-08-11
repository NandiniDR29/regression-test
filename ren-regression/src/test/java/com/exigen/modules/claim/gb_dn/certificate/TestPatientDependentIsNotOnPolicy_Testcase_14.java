package com.exigen.modules.claim.gb_dn.certificate;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class Testpatientdependentisnotonpolicy_Testcases_14 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 53)
    public void testpatientdependentisnotonpolicy() throws IOException {


        logger = extent.startTest(groupNo + " testpatientdependentisnotonpolicy");
        prop.load(fileInput);
        reportLog("Searching for customer "+prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        reportLog("Submitting the Claim having CDT Code as D0120 ...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_dependentnotoncoverage"));

        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);

        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);
        reportLog("Claim Adjudicated...", 1);
        reportLog("============================================", 1);

    }
}
