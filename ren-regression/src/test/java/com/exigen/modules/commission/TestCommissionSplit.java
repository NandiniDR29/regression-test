package com.exigen.modules.commission;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.modules.policy.common.pages.QuoteSummaryPage;
import com.exigen.modules.policy.common.tabs.master.PolicyInformationBindActionTab;
import com.exigen.modules.policy.gb_di_ltd.masterpolicy.LongTermDisabilityMasterPolicyContext;
import com.exigen.modules.policy.gb_di_ltd.masterpolicy.tabs.EnrollmentTab;
import com.exigen.modules.policy.gb_di_ltd.masterpolicy.tabs.PolicyInformationTab;
import com.exigen.modules.policy.gb_di_ltd.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ProductConstants;
import com.exigen.ren.main.modules.caseprofile.CaseProfileContext;
import com.exigen.ren.main.modules.customer.CustomerContext;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.SaveMPNumberForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.saveBillingAccount;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestCommissionSplit extends CommonBaseTest implements CustomerContext, CaseProfileContext, LongTermDisabilityMasterPolicyContext {
    @Test(priority = 132)
    public void testCommissionSlipt() throws IOException {
        logger = extent.startTest(groupNo + " Commission Split");
        prop.load(fileInput);
        reportLog("Navigate Main Section",0);
        pName = "Other";
        search(prop.getProperty("CustomerNumber"));
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        search(prop.getProperty("CustomerNumber"));
        reportLog("Navigate to Quote creation tab", 1);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.QUOTE);
        reportLog("Add Quote", 1);
        QuoteSummaryPage.buttonAddNewQuote.click();
        reportLog("Select the Product", 1);
        Page.dialogConfirmation.fillAssetList(longTermDisabilityMasterPolicy.getDefaultTestData("DataGather1", testDatapoint), "InitiniateDialog");
        reportLog("Navigate to PolicyInformation tab", 1);
        Page.dialogConfirmation.buttonNext.click();
        reportLog("Select Plan and Fill required filed", 1);
        longTermDisabilityMasterPolicy.getDefaultWorkspace().fillFromTo(longTermDisabilityMasterPolicy.getDefaultTestData("DataGather1", testDatapoint), PolicyInformationTab.class, PolicyInformationTab.class, true);
        PolicyInformationTab.assignAgencies();
        Waiters.SLEEP(8000).go();
        Tab.buttonNext.click();
        longTermDisabilityMasterPolicy.getDefaultWorkspace().fillFromTo(longTermDisabilityMasterPolicy.getDefaultTestData("DataGather1", testDatapoint), EnrollmentTab.class, PremiumSummaryTab.class);
        reportLog("Generate Rate", 1);
        premiumSummaryTab.selectRatingCensusAndRate();
        String premium = premiumSummaryTab.labelTotalPremium.getValue();
        reportLog("Generated Premium Amount :" + premium, 1);
        premiumSummaryTab.buttonNext.click();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PREMIUM_CALCULATED);
        SaveMPNumberForNextValidation(PolicySummaryPage.labelPolicyNumber.getValue(), groupNo);
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PREMIUM_CALCULATED);
        reportLog("Generate Proposal for " + PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        longTermDisabilityMasterPolicy.propose().perform(getLTDMasterPolicyIssueData("Propose", "TestData"));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PROPOSED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Perform Contract Acceptance : " + PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        longTermDisabilityMasterPolicy.acceptContract().start();
        new PolicyInformationBindActionTab().submitTab();
        longTermDisabilityMasterPolicy.acceptContract().submit();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.CUSTOMER_ACCEPTED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("DataGatherCertificate_IssuePayment1.yaml Policy", 1);
        longTermDisabilityMasterPolicy.issue().perform(getLTDMasterPolicyIssueData("Issue", testDatapoint));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.POLICY_ACTIVE);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        saveBillingAccount("ltd", groupNo, bANo);
        reportLog("==========================================", 1);
    }
}
