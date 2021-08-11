package com.exigen.modules.policy.gb_ac;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.modules.policy.common.pages.QuoteSummaryPage;
import com.exigen.modules.policy.common.tabs.master.PolicyInformationBindActionTab;
import com.exigen.modules.policy.gb_ac.masterpolicy.AccidentMasterPolicyContext;
import com.exigen.modules.policy.gb_ac.masterpolicy.tabs.ClassificationManagementTab;
import com.exigen.modules.policy.gb_ac.masterpolicy.tabs.PolicyInformationTab;
import com.exigen.modules.policy.gb_ac.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ProductConstants;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.SaveMPNumberForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.saveBillingAccount;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestAccidentQuoteGenerationForG3 extends CommonBaseTest implements AccidentMasterPolicyContext {
    @Test(priority = 5)
    public void PlanDFAC_PlanB() throws IOException {
        logger = extent.startTest(groupNo + " Accident plan");
        prop.load(fileInput);
        pName ="Accident";
        reportLog("Searching for customer ", 0);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        reportLog("Navigate to Quote creation tab", 1);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.QUOTE);
        reportLog("Add Quote", 1);
        QuoteSummaryPage.buttonAddNewQuote.click();
        reportLog("Select the Product", 1);
        Page.dialogConfirmation.fillAssetList(groupACMasterPolicy.getDefaultTestData("DataGather", testDatapoint), "InitiniateDialog");
        reportLog("Navigate to PolicyInformation tab", 1);
        Page.dialogConfirmation.buttonNext.click();
        reportLog("Select Plan and Fill required filed", 1);
        groupACMasterPolicy.getDefaultWorkspace().fillFromTo(groupACMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PolicyInformationTab.class, ClassificationManagementTab.class);
        reportLog(" Enter Tiers Count", 1);
        groupACMasterPolicy.getDefaultWorkspace().fillFromTo(groupACMasterPolicy.getDefaultTestData("DataGather", testDatapoint), ClassificationManagementTab.class, PremiumSummaryTab.class);
        reportLog("Generate Rate", 1);
        groupACMasterPolicy.getDefaultWorkspace().fillFromTo(groupACMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PremiumSummaryTab.class, PremiumSummaryTab.class);
        premiumSummaryTab.buttonRate.waitForAccessible(1000);
        premiumSummaryTab.buttonRate.click();
        String premium = PremiumSummaryTab.labelTotalPremium.getValue();
        reportLog("Generated Premium Amount :" + PremiumSummaryTab.labelTotalPremium.getValue(), 1);
        premiumSummaryTab.buttonNext.click();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PREMIUM_CALCULATED);
        SaveMPNumberForNextValidation(PolicySummaryPage.labelPolicyNumber.getValue(), groupNo);
        reportLog("Generated Proposal For :" + prop.getProperty("MPNumber"), 1);
        groupACMasterPolicy.propose().perform(getDefaultACMasterPolicyissue("Propose", "TestData"));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PROPOSED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Perform Contract Acceptance : " + PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        groupACMasterPolicy.acceptContract().start();
        new PolicyInformationBindActionTab().submitTab();
        groupACMasterPolicy.acceptContract().submit();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.CUSTOMER_ACCEPTED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Issue " + PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        groupACMasterPolicy.issue().perform(getDefaultACMasterPolicyissue("Issue", testDatapoint));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.POLICY_ACTIVE);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        saveBillingAccount("accident", groupNo, bANo);
        reportLog("==========================================", 1);

    }
}
