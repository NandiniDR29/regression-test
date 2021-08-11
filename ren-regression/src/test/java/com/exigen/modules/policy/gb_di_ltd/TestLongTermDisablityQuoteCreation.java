package com.exigen.modules.policy.gb_di_ltd;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.modules.policy.common.pages.QuoteSummaryPage;
import com.exigen.modules.policy.common.tabs.master.PolicyInformationBindActionTab;
import com.exigen.modules.policy.gb_di_ltd.masterpolicy.LongTermDisabilityMasterPolicyContext;
import com.exigen.modules.policy.gb_di_ltd.masterpolicy.tabs.PolicyInformationTab;
import com.exigen.modules.policy.gb_di_ltd.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ProductConstants;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.SaveMPNumberForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.saveBillingAccount;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestLongTermDisablityQuoteCreation extends CommonBaseTest implements LongTermDisabilityMasterPolicyContext {
    @Test(priority = 6)
    public void LongTermDisablityQuoteCreation() throws IOException {
        logger = extent.startTest(groupNo+" TestLongTermDisablityQuoteCreation");
        prop.load(fileInput);
        pName ="Other";
        reportLog("Searching for customer ", 0);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        reportLog("Navigate to Quote creation tab", 1);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.QUOTE);
        reportLog("Add Quote", 1);
        QuoteSummaryPage.buttonAddNewQuote.click();
        reportLog("Select the Product", 1);
        Page.dialogConfirmation.fillAssetList(longTermDisabilityMasterPolicy.getDefaultTestData("DataGather", testDatapoint), "InitiniateDialog");
        reportLog("Navigate to PolicyInformation tab", 1);
        Page.dialogConfirmation.buttonNext.click();
        reportLog("Select Plan and Fill required filed", 1);
        longTermDisabilityMasterPolicy.getDefaultWorkspace().fillFromTo(longTermDisabilityMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PolicyInformationTab.class, PremiumSummaryTab.class);
        reportLog("Generate Rate", 1);
        longTermDisabilityMasterPolicy.getDefaultWorkspace().fillFromTo(longTermDisabilityMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PremiumSummaryTab.class, PremiumSummaryTab.class);
        premiumSummaryTab.selectRatingCensusAndRate();
        String premium = premiumSummaryTab.labelTotalPremium.getValue();
        reportLog("Generated Premium Amount :" + premium, 1);
        premiumSummaryTab.buttonNext.click();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PREMIUM_CALCULATED);
        SaveMPNumberForNextValidation(PolicySummaryPage.labelPolicyNumber.getValue(),groupNo);
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PREMIUM_CALCULATED);
        reportLog("Generate Proposal for "+PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        longTermDisabilityMasterPolicy.propose().perform(getLTDMasterPolicyIssueData("Propose", "TestData"));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PROPOSED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Perform Contract Acceptance : "+PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        longTermDisabilityMasterPolicy.acceptContract().start();
        new PolicyInformationBindActionTab().submitTab();
        longTermDisabilityMasterPolicy.acceptContract().submit();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.CUSTOMER_ACCEPTED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Issue Policy", 1);
        longTermDisabilityMasterPolicy.issue().perform(getLTDMasterPolicyIssueData("Issue", testDatapoint));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.POLICY_ACTIVE);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        saveBillingAccount("ltd", groupNo, bANo);
        reportLog("==========================================", 1);
}
}

