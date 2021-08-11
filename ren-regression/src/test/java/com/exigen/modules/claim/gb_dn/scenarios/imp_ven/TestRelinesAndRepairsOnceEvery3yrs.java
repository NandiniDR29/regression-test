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

public class TestRelinesAndRepairsOnceEvery3yrs extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 122)
    public void testRelinesAndRepairsOnceEvery3yrs() throws IOException {


        logger = extent.startTest(groupNo + " testRelinesAndRepairsOnceEvery3yrs");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submmision started for Relines And Repairs Once Every 3yrs ", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_RelinesAndRepairsOnceEvery3yrs"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim submmision started for Relines And Repairs Once Every 3yrs deny scenario " + claimNumber, 1);


        dentalClaim.create(dentalClaim.getDefaultTestData("ImpVen", "TestData_RelinesAndRepairsOnceEvery3yrsdeny"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber1 = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber1, 1);
        reportLog("===========...", 1);


    }
}
