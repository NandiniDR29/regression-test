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

public class TestSatisfyOverpaymentonClaim_Testcases_29 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 60)
    public void testSatisfyOverpaymentonClaim() throws IOException {


        logger = extent.startTest(groupNo + " testSatisfyOverpaymentonClaim");
        prop.load(fileInput);
        reportLog("Searching for customer "+prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        reportLog("Submitting the Claim having CDT Code as D0120 and D0220 ...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_satisfyoverpayment"));

        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);

        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        try {
            dentalClaim.claimAdjust().perform();
            dentalClaim.pendClaim().perform("Consultant Review");
            reportLog("Claim Pended to Consultant work queue " + claimNumber, 1);
            reportLog("Claim Adjudicated...", 1);
        }
        catch (Exception e){
            reportLog("Claim Status is: "+ ClaimSummaryPage.labelClaimStatus,1);
        }
        reportLog("============================================", 1);


    }
}
