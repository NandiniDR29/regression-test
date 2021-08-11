package com.exigen.modules.policy.gb_st;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.modules.policy.common.pages.QuoteSummaryPage;
import com.exigen.modules.policy.common.tabs.master.PolicyInformationBindActionTab;
import com.exigen.modules.policy.gb_st.masterpolicy.StatutoryDisabilityInsuranceMasterPolicyContext;
import com.exigen.modules.policy.gb_st.masterpolicy.tabs.PolicyInformationTab;
import com.exigen.modules.policy.gb_st.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ProductConstants;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.SaveMPNumberForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.saveBillingAccount;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestStatutoryDisabilityInsuranceQuoteCreation extends CommonBaseTest implements StatutoryDisabilityInsuranceMasterPolicyContext {
    @Test(priority = 9)
    public void StatutoryDisabilityInsuranceQuoteCreation() throws IOException {
        logger = extent.startTest(groupNo+" TestStatutory Disability Insurance Quote Creation");
        prop.load(fileInput);
        pName ="Stat";
        reportLog("Searching for customer or Create New customer...", 0);
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        System.out.println("testData"+testDatapoint);
        search(prop.getProperty("CustomerNumber"));
        reportLog("Navigate to Quote creation tab", 1);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.QUOTE);
        reportLog("Add Quote", 1);
        QuoteSummaryPage.buttonAddNewQuote.click();
        reportLog("Select the Product", 1);
        Page.dialogConfirmation.fillAssetList(statutoryDisabilityInsuranceMasterPolicy.getDefaultTestData("DataGather", testDatapoint), "InitiniateDialog");
        reportLog("Navigate to PolicyInformation tab", 1);
        Page.dialogConfirmation.buttonNext.click();
        reportLog("Select Plan and Fill required filed", 1);
        statutoryDisabilityInsuranceMasterPolicy.getDefaultWorkspace().fillFromTo(statutoryDisabilityInsuranceMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PolicyInformationTab.class, PremiumSummaryTab.class);
        reportLog("Generate Rate", 1);
        statutoryDisabilityInsuranceMasterPolicy.getDefaultWorkspace().fillFromTo(statutoryDisabilityInsuranceMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PremiumSummaryTab.class, PremiumSummaryTab.class);
        premiumSummaryTab.selectRatingCensusAndRate();
        String premium = premiumSummaryTab.labelTotalPremium.getValue();
        reportLog("Generated Premium Amount :" + premium, 1);
        premiumSummaryTab.buttonNext.click();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PREMIUM_CALCULATED);
        SaveMPNumberForNextValidation(PolicySummaryPage.labelPolicyNumber.getValue(),groupNo);
        reportLog("Generated Proposal For :" + prop.getProperty("MPNumber"), 1);
        statutoryDisabilityInsuranceMasterPolicy.propose().perform(getSTMasterPolicyIssueData("Propose", "TestData"));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PROPOSED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Perform Contract Acceptance : "+PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        statutoryDisabilityInsuranceMasterPolicy.acceptContract().start();
        new PolicyInformationBindActionTab().submitTab();
        statutoryDisabilityInsuranceMasterPolicy.acceptContract().submit();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.CUSTOMER_ACCEPTED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Issue "+PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        statutoryDisabilityInsuranceMasterPolicy .issue().perform(getSTMasterPolicyIssueData("Issue", testDatapoint));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.POLICY_ACTIVE);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        saveBillingAccount("Stat", groupNo, bANo);
        System.out.println("ba"+bANo);
        reportLog("==========================================", 1);
    }
}
