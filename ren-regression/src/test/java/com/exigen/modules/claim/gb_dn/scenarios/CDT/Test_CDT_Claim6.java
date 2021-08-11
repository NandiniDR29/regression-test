package com.exigen.modules.claim.gb_dn.scenarios.CDT;

import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.gb_dn.ClaimGroupBenefitsDNBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class Test_CDT_Claim6 extends ClaimGroupBenefitsDNBaseTest {

    @Test(priority = 88)
    public void testCDTClaim6() throws IOException {


        logger = extent.startTest(groupNo + " TestCDTClaim");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        reportLog("Searching for customer or Create New customer...", 1);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnDentalCP();
        reportLog("Searching for Cp : "+cpNumber, 1);
        search(cpNumber);
        reportLog("Claim submission started...", 1);
        reportLog("Submitting the Claim having CDT Code as D1110 ...", 1);

        dentalClaim.create(dentalClaim.getDefaultTestData("CDT", "TestData_Claim6"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.LOGGED_INTAKE);
        dentalClaim.claimSubmit().perform();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Submitted successfully..."+claimNumber, 1);
        reportLog("============================================",1);
 }
}
