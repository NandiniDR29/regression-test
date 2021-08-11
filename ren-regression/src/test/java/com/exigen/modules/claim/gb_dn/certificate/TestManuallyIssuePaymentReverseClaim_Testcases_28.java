package com.exigen.modules.claim.gb_dn.certificate;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimTab.ADJUDICATION;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ClaimConstants.ClaimStatus.LOGGED_INTAKE;

public class TestManuallyIssuePaymentReverseclaim_Testcases_28 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 49)
    public void testManuallyIssuePaymentReverseclaim() throws IOException {

        logger = extent.startTest(groupNo + " testManuallyIssuePaymentReverseclaim");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        reportLog("Submitting the Claim having CDT Code as D5863 ...", 1);


        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_substitutewithD5110"));

        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(LOGGED_INTAKE);

        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.ADJUDICATED);
        reportLog("Claim Adjudicated...", 2);
        dentalClaim.issuePayment().perform(tdClaim.getTestData("DataGatherCertificate", "TestData_IssuePayment"), 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.PAID);
        NavigationPage.toSubTab(ADJUDICATION);
        reportLog("cancelling the Claim..." + claimNumber, 1);


        dentalClaim.claimAdjust().perform(tdClaim.getTestData("ClaimAdjust", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(LOGGED_INTAKE);


        dentalClaim.claimCancel().perform(tdClaim.getTestData("ClaimCancel", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.CANCELED);
        reportLog("Claim is Reversed/Cancelled " + claimNumber, 1);

        reportLog("============================================", 1);


    }
}
