/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.claim.gb_st;

import com.exigen.basetest.Util;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.istf.utils.datetime.DateTimeUtils;
import com.exigen.modules.claim.ClaimGroupBenefitsSTBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.DisabilityClaimSTContext;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static com.exigen.helpers.CommonGenericMethods.saveClaimNumberForStat;
import static com.exigen.helpers.CommonGenericMethods.statProductMasterPolicy;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestSTClaimCreationG9 extends ClaimGroupBenefitsSTBaseTest implements DisabilityClaimSTContext {

    @Test(priority = 30)
    public void testClaimCreationForRegularDBLValidateWeeksPriorEarningsData() throws IOException {
        commonSteps("TestData_NJ");
    }
    private void commonSteps(String dataPoint) throws IOException {
        LocalDateTime currentDate = DateTimeUtils.getCurrentDateTime();
        logger = extent.startTest(groupNo + " Stat claim");
        prop.load(fileInput);
        reportLog("Searching for customer : "+prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String statMp = statProductMasterPolicy("Statutory Disability Insurance");
        reportLog("Searching for Master Policy : "+statMp, 1);
        search(statMp);
        reportLog("Create Claim : "+statMp, 1);
        createDefaultStatutoryDisabilityInsuranceClaimForMasterPolicy(dataPoint);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Created Claim Number : "+claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        reportLog(claimNumber+" status: "+ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog(claimNumber+" Created for: "+ClaimSummaryPage.labelInsuredName.getValue(), 1);
        reportLog(" Submit Claim: "+claimNumber, 1);
        claim.claimSubmit().perform(new SimpleDataProvider());
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.NOTIFICATION);
        reportLog(claimNumber+" status after Claim submission: "+ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog(claimNumber+" Open: ", 1);
        claim.claimOpen().perform();
        saveClaimNumberForStat(claimNumber);
        reportLog("=================================== ", 1);
    }
}
