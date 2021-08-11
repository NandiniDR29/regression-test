package com.exigen.modules.policy.gb_di_std;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.modules.policy.common.pages.QuoteSummaryPage;
import com.exigen.modules.policy.common.tabs.master.PolicyInformationBindActionTab;
import com.exigen.modules.policy.gb_di_std.masterpolicy.ShortTermDisabilityMasterPolicyContext;
import com.exigen.modules.policy.gb_di_std.masterpolicy.tabs.PolicyInformationTab;
import com.exigen.modules.policy.gb_di_std.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ProductConstants;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.SaveMPNumberForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.saveBillingAccount;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestShortTermDisablityQuoteCreation extends CommonBaseTest implements ShortTermDisabilityMasterPolicyContext {
    @Test(priority = 7)
    public void ShortTermDisablityQuoteCreation() throws IOException {
        logger = extent.startTest(groupNo+" TestShortTermDisablityQuoteCreation");
        prop.load(fileInput);
        pName ="STD";
        reportLog("Searching for customer: "+ prop.getProperty("CustomerNumber"), 0);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        reportLog("Navigate to Quote creation tab", 1);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.QUOTE);
        reportLog("Add Quote", 1);
        QuoteSummaryPage.buttonAddNewQuote.click();
        reportLog("Select the Product", 1);
        Page.dialogConfirmation.fillAssetList(shortTermDisabilityMasterPolicy.getDefaultTestData("DataGather", testDatapoint), "InitiniateDialog");
        reportLog("Navigate to PolicyInformation tab", 1);
        Page.dialogConfirmation.buttonNext.click();
        reportLog("Select Plan and Fill required filed", 1);
        shortTermDisabilityMasterPolicy.getDefaultWorkspace().fillFromTo(shortTermDisabilityMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PolicyInformationTab.class, PremiumSummaryTab.class);
        reportLog("Generate Rate", 1);
        shortTermDisabilityMasterPolicy.getDefaultWorkspace().fillFromTo(shortTermDisabilityMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PremiumSummaryTab.class, PremiumSummaryTab.class);
        premiumSummaryTab.selectRatingCensusAndRate();
        String premium = premiumSummaryTab.labelTotalPremium.getValue();
        reportLog("Generated Premium Amount :" + premium, 1);
        premiumSummaryTab.buttonNext.click();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PREMIUM_CALCULATED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        SaveMPNumberForNextValidation(PolicySummaryPage.labelPolicyNumber.getValue(),groupNo);
        reportLog("Generate Proposal for "+PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        shortTermDisabilityMasterPolicy.propose().perform(getSTDMasterPolicyIssueData("Propose", "TestData"));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PROPOSED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Perform Contract Acceptance : "+PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        shortTermDisabilityMasterPolicy.acceptContract().start();
        new PolicyInformationBindActionTab().submitTab();
        shortTermDisabilityMasterPolicy.acceptContract().submit();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.CUSTOMER_ACCEPTED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Issue Policy", 1);
        shortTermDisabilityMasterPolicy.issue().perform(getSTDMasterPolicyIssueData("Issue", testDatapoint));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.POLICY_ACTIVE);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        saveBillingAccount("Std", groupNo, bANo);
        reportLog("==========================================", 1);

    }
}
