/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.claim.gb_pfl;

import com.exigen.istf.data.TestData;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.istf.utils.datetime.DateTimeUtils;
import com.exigen.modules.claim.ClaimGroupBenefitsPFLBaseTest;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentPaymentPaymentAllocationTabMetaData;
import com.exigen.ren.main.modules.claim.common.tabs.OtherIncomeBenefitActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentPaymentPaymentAllocationTab;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.DisabilityClaimPFLContext;
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
import static com.exigen.ren.main.modules.claim.common.metadata.OtherIncomeBenefitActionTabMetaData.THROUGH_DATE;

public class TestPFLClaimCreation extends ClaimGroupBenefitsPFLBaseTest implements DisabilityClaimPFLContext {

    @Test(priority = 29)
    public void testClaimCreation() throws IOException {
        if(groupNo.equalsIgnoreCase("Group10")){
        commonSteps("TestData_G10");}
       else if(groupNo.equalsIgnoreCase("Group9")){
            commonSteps("TestData_With_PFL_Benefit_G9");}

   }
   private void commonSteps(String testData) throws IOException {
       logger = extent.startTest(groupNo + " PFL claim");
       prop.load(fileInput);
       reportLog("Searching for customer : "+prop.getProperty("CustomerNumber"), 0);
       search(prop.getProperty("CustomerNumber"));
       String pflMp = statProductMasterPolicy("Paid Family Leave");
       reportLog("Searching for Master Policy : "+pflMp, 1);
       search(pflMp);
       reportLog("Create Claim : "+pflMp, 1);
       createDefaultPaidFamilyLeaveClaimForMasterPolicy(testData);
       String claimNumber =ClaimSummaryPage.getClaimNumber();
       reportLog("Created Claim Number : " + claimNumber, 1);
       assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
       reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
       reportLog(claimNumber + " Created for: " + ClaimSummaryPage.labelInsuredName.getValue(), 1);
       reportLog(" Submit Claim: " + claimNumber, 1);
       claim.claimSubmit().perform(new SimpleDataProvider());
       assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.NOTIFICATION);
       reportLog(claimNumber+" status after Claim submission: "+ClaimSummaryPage.labelClaimStatus.getValue(), 1);
       reportLog(claimNumber+" Open Claim ", 1);
       claim.claimOpen().perform();


       assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.OPEN);
       reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
       reportLog("========================================", 1);
   }
}
