package com.exigen.modules.claim.gb_dn.certificate;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimTab.ADJUDICATION;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ClaimConstants.PaymentsAndRecoveriesTransactionStatus.ISSUED;
import static com.exigen.ren.main.enums.TableConstants.ClaimSummaryOfPaymentsAndRecoveriesTableExtended.PAYMENT_RECOVERY_NUMBER;
import static com.exigen.ren.main.enums.TableConstants.ClaimSummaryOfPaymentsAndRecoveriesTableExtended.STATUS;
import static com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage.tableSummaryOfClaimPaymentsAndRecoveries;

public class TestRecoveryPayment extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 59)
    public void tesRecoveryPayment() throws IOException {

        logger = extent.startTest(groupNo + " tesRecoveryPayment");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer to submit the claim...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        dentalClaim.create(dentalClaim.getDefaultTestData("DataGatherCertificate", "TestData_RecoveryPayment"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..." + claimNumber, 1);
        reportLog("Submitting the Claim having CDT Code as D1110 ...", 1);

        dentalClaim.claimSubmit().perform();
        dentalClaim.issuePayment().perform(tdClaim.getTestData("DataGatherCertificate", "TestData_IssuePayment"), 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.PAID);
        NavigationPage.toSubTab(ADJUDICATION);
        reportLog("Claim Adjudicated...", 1);

        reportLog("Performed Port_Recovery ...", 1);
        dentalClaim.postRecovery().perform(tdClaim.getTestData("ClaimPayment", "TestData_PostRecovery"));
        assertThat(tableSummaryOfClaimPaymentsAndRecoveries.getRow(1)).hasCellWithValue(STATUS.getName(), ISSUED);
        String recoveryId = tableSummaryOfClaimPaymentsAndRecoveries.getRow(1).getCell(PAYMENT_RECOVERY_NUMBER.getName()).getValue();
        reportLog("============================================", 1);

    }
}
