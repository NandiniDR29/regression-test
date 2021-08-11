/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.claim.gb_ltd;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.modules.claim.ClaimGroupBenefitsLTDBaseTest;
import com.exigen.modules.claim.ClaimGroupBenefitsSTBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.DisabilityClaimLTDContext;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestLTDClaimCreation extends ClaimGroupBenefitsLTDBaseTest implements DisabilityClaimLTDContext {

    @Test(priority = 44)
    public void testClaimCreation() throws IOException {
        logger = extent.startTest(groupNo + " LTD claim");
        prop.load(fileInput);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnLTDCp();
        reportLog("Searching for Cp : "+cpNumber, 0);
        search(cpNumber);
        reportLog("Create Claim : "+cpNumber, 1);
        createDefaultLongTermDisabilityClaimForCertificatePolicy();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Created Claim Number : " + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog(claimNumber + " Created for: " + ClaimSummaryPage.labelInsuredName.getValue(), 1);
        reportLog(" Submit Claim: " + claimNumber, 1);
        claim.claimSubmit().perform(new SimpleDataProvider());
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.NOTIFICATION);
        reportLog(claimNumber + " status after Claim submission: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog(claimNumber + " Open: ", 1);
        claim.claimOpen().perform();
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.OPEN);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmount", "TestData_LTD"), 1);
        reportLog(claimNumber + " ================================== ", 1);

    }

}
