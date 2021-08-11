/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.claim.gb_st;

import com.exigen.istf.data.TestData;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.istf.utils.datetime.DateTimeUtils;
import com.exigen.modules.claim.ClaimGroupBenefitsSTBaseTest;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.tabs.OtherIncomeBenefitActionTab;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.DisabilityClaimSTContext;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import static com.exigen.helpers.CommonGenericMethods.statProductMasterPolicy;
import static com.exigen.istf.utils.datetime.DateTimeUtils.MM_DD_YYYY;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.modules.claim.common.metadata.OtherIncomeBenefitActionTabMetaData.*;

public class TestSTClaimCreationG10 extends ClaimGroupBenefitsSTBaseTest implements DisabilityClaimSTContext {

    @Test(priority = 29)
    public void testClaimCreationForRegularDBLValidateWeeksPriorEarningsData() throws IOException {
        commonSteps("TestData_Group10");
    }

    private void commonSteps(String dataPoint) throws IOException {
        LocalDateTime currentDate = DateTimeUtils.getCurrentDateTime();
        LocalDateTime dateOfLoss = currentDate.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)); // need for step 1.5: Set Effective Date = BP start date(Friday)
        LocalDateTime BPStartDate = dateOfLoss.plusDays(7);
        logger = extent.startTest(groupNo + " Stat claim");
        prop.load(fileInput);
        reportLog("Searching for customer : " + prop.getProperty("CustomerNumber"), 0);
        search(prop.getProperty("CustomerNumber"));
        String statMp = statProductMasterPolicy("Statutory Disability Insurance");
        reportLog("Searching for Master Policy : "+statMp, 1);
        search(statMp);
        reportLog("Create Claim : "+statMp, 1);
        createDefaultStatutoryDisabilityInsuranceClaimForMasterPolicy(dataPoint);
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
        reportLog(claimNumber + "SingleBenefitAmount Cal with  prorated period benefit  : ", 1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmount", "TestData")
                .adjust(TestData.makeKeyPath(OtherIncomeBenefitActionTab.class.getSimpleName(), TYPE_OF_OFFSET.getLabel()), "index=1")
                .adjust(TestData.makeKeyPath(OtherIncomeBenefitActionTab.class.getSimpleName(), PAYMENT_AMOUNT.getLabel()), "20")
                .adjust(TestData.makeKeyPath(OtherIncomeBenefitActionTab.class.getSimpleName(), PRORATING_RATE.getLabel()), "1/7")
                .adjust(TestData.makeKeyPath(OtherIncomeBenefitActionTab.class.getSimpleName(), BEGINNING_DATE.getLabel()), BPStartDate.plusWeeks(1).format((MM_DD_YYYY)))
                .adjust(TestData.makeKeyPath(OtherIncomeBenefitActionTab.class.getSimpleName(), THROUGH_DATE.getLabel()), BPStartDate.plusDays(15).format((MM_DD_YYYY))).resolveLinks(), 1);
        reportLog("=================================== ", 1);
    }
}
