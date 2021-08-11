package com.exigen.modules.policy.gb_dn;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.modules.policy.common.pages.QuoteSummaryPage;
import com.exigen.modules.policy.common.tabs.master.PolicyInformationBindActionTab;
import com.exigen.modules.policy.gb_dn.masterpolicy.DentalMasterPolicyContext;
import com.exigen.modules.policy.gb_dn.masterpolicy.tabs.ClassificationManagementTab;
import com.exigen.modules.policy.gb_dn.masterpolicy.tabs.PolicyInformationTab;
import com.exigen.modules.policy.gb_dn.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ProductConstants;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.SaveMPNumberForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.saveBillingAccount;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestDentalTwoPlanQuoteCreation extends CommonBaseTest implements DentalMasterPolicyContext {
    @Test(priority = 3)

    public void testDentalQuoteCreation() throws IOException {
        logger = extent.startTest(groupNo + " TestDentalTwoPlanQuoteCreation");
        prop.load(fileInput);
        pName ="Other";
        String testDatapoint = CommonGenericMethods.testdataSelection(groupNo);
        reportLog("Searching for customer ", 0);
        MainPage.QuickSearch.buttonSearchPlus.click();
        search(prop.getProperty("CustomerNumber"));
            reportLog("Navigate to Quote creation tab", 1);
            NavigationPage.toMainTab(NavigationEnum.AppMainTabs.QUOTE);
            reportLog("Add Quote", 1);
            QuoteSummaryPage.buttonAddNewQuote.click();
            reportLog("Select the Product", 1);
            Page.dialogConfirmation.fillAssetList(dentalMasterPolicy.getDefaultTestData("DataGather", testDatapoint), "InitiniateDialog");
            reportLog("Navigate to PolicyInformation tab", 1);
            Page.dialogConfirmation.buttonNext.click();
            reportLog("Select ASO and ASO-ALA and Fill required filed", 1);
            dentalMasterPolicy.getDefaultWorkspace().fillFromTo(dentalMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PolicyInformationTab.class, ClassificationManagementTab.class);
            reportLog("Enter Tiers counts", 1);
            dentalMasterPolicy.getDefaultWorkspace().fillFromTo(dentalMasterPolicy.getDefaultTestData("DataGather", testDatapoint), ClassificationManagementTab.class, PremiumSummaryTab.class);
            reportLog("Generate Rate", 1);
            dentalMasterPolicy.getDefaultWorkspace().fillFromTo(dentalMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PremiumSummaryTab.class, PremiumSummaryTab.class);
            premiumSummaryTab.buttonRate.waitForAccessible(2000);
            premiumSummaryTab.buttonRate.click();
            reportLog("Generated Premium Amount :" + PremiumSummaryTab.labelTotalPremium.getValue(), 1);
            premiumSummaryTab.buttonNext.click();
            CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PREMIUM_CALCULATED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        SaveMPNumberForNextValidation(PolicySummaryPage.labelPolicyNumber.getValue(), groupNo);
        reportLog("Generate Proposal for " + PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        dentalMasterPolicy.propose().perform(getDNMasterPolicyissue("Propose", "TestData"));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PROPOSED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Perform Contract Acceptance" + PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        dentalMasterPolicy.acceptContract().start();
        new PolicyInformationBindActionTab().submitTab();
        dentalMasterPolicy.acceptContract().submit();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.CUSTOMER_ACCEPTED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Issue " + PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        dentalMasterPolicy.issue().perform(getDNMasterPolicyissue("Issue", testDatapoint));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.POLICY_ACTIVE);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " : Status is " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        saveBillingAccount("Dental", groupNo, bANo);
        reportLog("==========================================", 1);
    }
}