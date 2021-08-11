package com.exigen.modules.claim.gb_ac.certificate;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.claim.ClaimGroupBenefitsACBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import com.exigen.ren.main.pages.summary.claim.ClaimAdjudicationBenefitPage;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.helpers.CommonGenericMethods.saveLogin1InfoForEnrolee;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestClaimACAdjudication1 extends ClaimGroupBenefitsACBaseTest {
    @Test(priority = 49)
    public void testClaimACAdjudication1() throws IOException {
        logger = extent.startTest(groupNo + " Group Accident claim Adjudication");
        prop.load(fileInput);
        reportLog("Searching for Cp ", 0);
        //To Test DXP
        CommonGenericMethods.searchSpecificParticipant("JAIN","9120");
        String cpNumber = returnACCPForSpecifiedParticipant();
        search(cpNumber);
        reportLog("Create Claim : "+cpNumber, 1);
        accHealthClaim.create(accHealthClaim.getGbACTestData().getTestData("DataGatherCertificate_Adjudication1", TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        reportLog("Open claim", 1);
        claim.claimOpen().perform();
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.OPEN);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog(" Add Benefit Amount", 1);
        claim.addBenefit().perform(tdClaim.getTestData("NewBenefit_Adjudication1", "TestData_AccidentalDismemberment"));
        reportLog("Calculate Single Benefit amount", 1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmount_Adjudication1", "TestData_AccidentalDeath"), 2);
        assertThat(ClaimAdjudicationBenefitPage.tableAllSingleBenefitCalculations).hasRows(1);
        assertThat(ClaimAdjudicationBenefitPage.tableAllSingleBenefitCalculations.getRow(1).getCell(ClaimConstants.ClaimAllSingleBenefitCalculationsTable.SINGLE_BENEFIT_NUMBER)).hasValue("2-1");
        reportLog("==========================================", 1);

    }
    public static String returnACCPForSpecifiedParticipant(){
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        WebElement E= CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Accident')]/..//td//a"));
        E.click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        return PolicySummaryPage.labelPolicyNumber.getValue();

    }
}
