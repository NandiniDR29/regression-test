package com.exigen.modules.policy.gb_vs;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.modules.policy.common.pages.QuoteSummaryPage;
import com.exigen.modules.policy.common.tabs.master.PolicyInformationBindActionTab;
import com.exigen.modules.policy.gb_vs.masterpolicy.GroupVisionMasterPolicyContext;
import com.exigen.modules.policy.gb_vs.masterpolicy.tabs.ClassificationManagementTab;
import com.exigen.modules.policy.gb_vs.masterpolicy.tabs.PolicyInformationTab;
import com.exigen.modules.policy.gb_vs.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ProductConstants;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.SaveMPNumberForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.saveBillingAccount;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestVisionPlanBFLQuoteCreationG10 extends CommonBaseTest implements GroupVisionMasterPolicyContext {
    @Test(priority = 11)
    public void testVisionPlanB() throws IOException {
        logger = extent.startTest(groupNo + " TestVisionPlanBTXQuoteCreation");
        prop.load(fileInput);
        pName ="Other";
        reportLog("Searching for customer...", 0);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        reportLog("Navigate to Quote creation tab", 1);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.QUOTE);
        reportLog("Add Quote", 1);
        QuoteSummaryPage.buttonAddNewQuote.click();
        reportLog("Select the Product", 1);
        Page.dialogConfirmation.fillAssetList(groupVisionMasterPolicy.getDefaultTestData("DataGather", testDatapoint), "InitiniateDialog");
        reportLog("Navigate to PolicyInformation tab", 1);
        Page.dialogConfirmation.buttonNext.click();
        reportLog("Select Plan and Fill required filed", 1);
        groupVisionMasterPolicy.getDefaultWorkspace().fillFromTo(groupVisionMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PolicyInformationTab.class, ClassificationManagementTab.class);
        reportLog(" Enter Tiers Count", 1);
        groupVisionMasterPolicy.getDefaultWorkspace().fillFromTo(groupVisionMasterPolicy.getDefaultTestData("DataGather", testDatapoint), ClassificationManagementTab.class, PremiumSummaryTab.class);
        reportLog("Generate Rate", 1);
        groupVisionMasterPolicy.getDefaultWorkspace().fillFromTo(groupVisionMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PremiumSummaryTab.class, PremiumSummaryTab.class);
        premiumSummaryTab.buttonRate.waitForAccessible(1000);
        premiumSummaryTab.buttonRate.click();
        String premium = PremiumSummaryTab.labelTotalPremium.getValue();
        reportLog("Generated Premium Amount :" + PremiumSummaryTab.labelTotalPremium.getValue(), 1);
        premiumSummaryTab.buttonNext.click();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PREMIUM_CALCULATED);
        SaveMPNumberForNextValidation(PolicySummaryPage.labelPolicyNumber.getValue(), groupNo);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Generate Proposal for " + PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        groupVisionMasterPolicy.propose().perform(getVSMasterPolicyissue("Propose", "TestData"));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PROPOSED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Perform Contract Acceptance : " + PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        groupVisionMasterPolicy.acceptContract().start();
        new PolicyInformationBindActionTab().submitTab();
        groupVisionMasterPolicy.acceptContract().submit();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.CUSTOMER_ACCEPTED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Issue " + PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        groupVisionMasterPolicy.issue().perform(getVSMasterPolicyissue("Issue", testDatapoint));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.POLICY_ACTIVE);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        saveBillingAccount("vision", groupNo, bANo);
        reportLog("==========================================", 1);
    }
}
