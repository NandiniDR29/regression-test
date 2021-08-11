package com.exigen.modules.policy.gb_dn;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.modules.policy.common.pages.QuoteSummaryPage;
import com.exigen.modules.policy.common.tabs.master.PolicyInformationBindActionTab;
import com.exigen.modules.policy.gb_dn.masterpolicy.DentalMasterPolicyContext;
import com.exigen.modules.policy.gb_dn.masterpolicy.tabs.ClassificationManagementTab;
import com.exigen.modules.policy.gb_dn.masterpolicy.tabs.PlanDefinitionTab;
import com.exigen.modules.policy.gb_dn.masterpolicy.tabs.PolicyInformationTab;
import com.exigen.modules.policy.gb_dn.masterpolicy.tabs.PremiumSummaryTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ProductConstants;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.SaveMPNumberForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.saveBillingAccount;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestDentalOnePlanQuoteCreationForStateValidation extends CommonBaseTest implements DentalMasterPolicyContext {

    private static final String ERROR_MESSAGE_Major = "State Requirement: Major - Out of Network must be equal to Major - In Network.";
    private static final String ERROR_MESSAGE_Prosthodontics = "State Requirement: Prosthodontics - Out of Network must be equal to Prosthodontics - In Network";


    @Test(priority = 3)

    public void testDentalQuoteCreation() throws IOException {

        logger = extent.startTest(groupNo+" TestDentOnePlanQuoteCreationForStateValidation");
        prop.load(fileInput);
        pName ="Other";
        String testDatapoint = "TestData_Group2_TX";
        reportLog("Searching for customer or Create New customer...", 0);
        search(prop.getProperty("CustomerNumber"));
        preconditions(testDatapoint);
        Tab.buttonNext.click();
        planDefinitionTab.errorMessages(driver, ERROR_MESSAGE_Major, ERROR_MESSAGE_Prosthodontics);
        reportLog("Creating New Dental Policy", 1);
        testDatapoint= CommonGenericMethods.testdataSelection(groupNo);
        preconditions(testDatapoint);
        Tab.buttonNext.click();
        reportLog(" Enter Tiers Count", 1);
        dentalMasterPolicy.getDefaultWorkspace().fillFromTo(dentalMasterPolicy.getDefaultTestData("DataGather", testDatapoint), ClassificationManagementTab.class, ClassificationManagementTab.class, true);
        reportLog("Generate Rate", 1);
        Tab.buttonNext.click();
        dentalMasterPolicy.getDefaultWorkspace().fillFromTo(dentalMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PremiumSummaryTab.class, PremiumSummaryTab.class,true);
        premiumSummaryTab. buttonRate.waitForAccessible(1000);
        premiumSummaryTab.buttonRate.click();
        reportLog("Generated Premium Amount :"+PremiumSummaryTab.labelTotalPremium.getValue(), 1);
        premiumSummaryTab. buttonNext.click();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PREMIUM_CALCULATED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        SaveMPNumberForNextValidation(PolicySummaryPage.labelPolicyNumber.getValue(),groupNo);
        reportLog("Generate Proposal for "+PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        dentalMasterPolicy.propose().perform(getDNMasterPolicyissue("Propose", "TestData"));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.PROPOSED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Perform Contract Acceptance : "+PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        dentalMasterPolicy.acceptContract().start();
        new PolicyInformationBindActionTab().submitTab();
        dentalMasterPolicy.acceptContract().submit();
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.CUSTOMER_ACCEPTED);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        reportLog("Issue "+PolicySummaryPage.labelPolicyNumber.getValue(), 1);
        dentalMasterPolicy.issue().perform(getDNMasterPolicyissue("Issue", testDatapoint));
        CustomAssertions.assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(ProductConstants.PolicyStatus.POLICY_ACTIVE);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" : Status is "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        saveBillingAccount("Dental", groupNo, bANo);
        reportLog("==========================================", 1);
    }
private static void  preconditions(String testDatapoint)
{
    reportLog("Navigate to Quote creation tab", 1);
    NavigationPage.toMainTab(NavigationEnum.AppMainTabs.QUOTE);
    reportLog("Add Quote", 1);
    QuoteSummaryPage.buttonAddNewQuote.click();
    reportLog("Select the Product", 1);
    Page.dialogConfirmation.fillAssetList(dentalMasterPolicy.getDefaultTestData("DataGather", testDatapoint), "InitiniateDialog");
    reportLog("Navigate to PolicyInformation tab", 1);
    Page.dialogConfirmation.buttonNext.click();
    reportLog("Select Plan and Fill required filed", 1);
    dentalMasterPolicy.getDefaultWorkspace().fillFromTo(dentalMasterPolicy.getDefaultTestData("DataGather", testDatapoint), PolicyInformationTab.class, PlanDefinitionTab.class,true);
}
}
