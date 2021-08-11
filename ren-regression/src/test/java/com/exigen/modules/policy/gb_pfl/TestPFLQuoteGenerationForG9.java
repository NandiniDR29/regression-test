/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.policy.gb_pfl;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.modules.policy.common.pages.QuoteSummaryPage;
import com.exigen.modules.policy.common.tabs.master.PolicyInformationBindActionTab;
import com.exigen.modules.policy.gb_pfl.masterpolicy.PaidFamilyLeaveMasterPolicyContext;
import com.exigen.modules.policy.gb_pfl.masterpolicy.tabs.ClassificationManagementTab;
import com.exigen.modules.policy.gb_pfl.masterpolicy.tabs.PlanDefinitionTab;
import com.exigen.modules.policy.gb_pfl.masterpolicy.tabs.PolicyInformationTab;
import com.exigen.modules.policy.gb_pfl.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ProductConstants;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.SaveMPNumberForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.saveBillingAccount;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestPFLQuoteGenerationForG9 extends CommonBaseTest implements PaidFamilyLeaveMasterPolicyContext  {


    @Test(priority = 10)
    public void PlanDFAC() throws IOException {
        logger = extent.startTest(groupNo + " PFL plan");
        prop.load(fileInput);
        pName ="Other";
        reportLog("Searching for customer", 0);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        reportLog("Navigate to Quote creation tab", 1);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.QUOTE);
        reportLog("Add Quote", 1);
        QuoteSummaryPage.buttonAddNewQuote.click();
        reportLog("Select the Product", 1);
        Page.dialogConfirmation.fillAssetList(paidFamilyLeaveMasterPolicy.getDefaultTestData("DataGather", testDatapoint), "InitiniateDialog");
        reportLog("Navigate to PolicyInformation tab", 1);
        Page.dialogConfirmation.buttonNext.click();
        reportLog("Select Plan and Fill required filed", 1);
        paidFamilyLeaveMasterPolicy.getDefaultWorkspace().fillFromTo(paidFamilyLeaveMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PolicyInformationTab.class, ClassificationManagementTab.class);
        reportLog(" Enter Tiers Count", 1);
        Waiters.SLEEP(5000).go();
        PaidFamilyLeaveMasterPolicyContext.classificationManagementTab.add_classification_button.click();
        PaidFamilyLeaveMasterPolicyContext.classificationManagementTab.Classification_group_name.setValueByIndex(1);
        Waiters.SLEEP(5000).go();
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id='policyDataGatherForm:sedit_GroupClassDefaultClassRatingInfoDecimalView_estimatedVolume_label']")));
        PaidFamilyLeaveMasterPolicyContext.classificationManagementTab.Number_Of_Participants.setValue("100");
        Waiters.SLEEP(5000).go();
        PaidFamilyLeaveMasterPolicyContext.classificationManagementTab.Total_volume.setValue("1000");
        PlanDefinitionTab.buttonNext.click();
        reportLog("Generate Rate", 1);
        paidFamilyLeaveMasterPolicy.getDefaultWorkspace().fillFromTo(paidFamilyLeaveMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PremiumSummaryTab.class, PremiumSummaryTab.class);
        premiumSummaryTab.buttonRate.waitForAccessible(1000);
        premiumSummaryTab.buttonRate.click();
        String premium = PremiumSummaryTab.labelTotalPremium.getValue();
        reportLog("Generated Premium Amount :" + com.exigen.modules.policy.gb_dn.masterpolicy.tabs.PremiumSummaryTab.labelTotalPremium.getValue(), 1);
        premiumSummaryTab.buttonNext.click();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PREMIUM_CALCULATED);
        SaveMPNumberForNextValidation(PolicySummaryPage.labelPolicyNumber.getValue(),groupNo);
        reportLog("Generate Proposal for "+PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        paidFamilyLeaveMasterPolicy.propose().perform(getPFLMasterPolicyissue("Propose", "TestData"));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PROPOSED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Perform Contract Acceptance : "+PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        paidFamilyLeaveMasterPolicy.acceptContract().start();
        new PolicyInformationBindActionTab().submitTab();
        paidFamilyLeaveMasterPolicy.acceptContract().submit();
        paidFamilyLeaveMasterPolicy.issue().perform(getPFLMasterPolicyissue("Issue", testDatapoint));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.POLICY_ACTIVE);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        saveBillingAccount("PFL", groupNo, bANo);
    }
}












