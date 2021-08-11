package com.exigen.modules.claim.gb_ac.certificate;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.modules.claim.ClaimGroupBenefitsACBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestClaimACAdjudication2 extends ClaimGroupBenefitsACBaseTest {
    @Test(priority = 50)
    public void testClaimACAdjudication1() throws IOException {
        logger = extent.startTest(groupNo + " Group Accident claim Adjudication2");
        prop.load(fileInput);
        reportLog("Searching for Cp", 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnACCCp();
        search(cpNumber);
        reportLog("Create Claim : " + cpNumber, 1);
        accHealthClaim.create(accHealthClaim.getGbACTestData().getTestData("DataGatherCertificate_Adjudication2", "TestData"));
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.INITIAL);
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog("Open claim", 1);
        claim.claimOpen().perform();
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimConstants.ClaimStatus.OPEN);
        reportLog(claimNumber + " status: " + ClaimSummaryPage.labelClaimStatus.getValue(), 1);
        reportLog(" Add Benefit Amount", 1);
        claim.addBenefit().perform(tdClaim.getTestData("NewBenefit_Adjudication2", "TestData_AccidentalDeath"));
        reportLog("Calculate Single Benefit amount", 1);
        claim.calculateSingleBenefitAmount().perform(tdClaim.getTestData("CalculateASingleBenefitAmount_Adjudication2", "TestData_AccidentalDeath"), 1);
        reportLog("==========================================", 1);

    }

    public String returnACCCp() {
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Accident')]/..//td[1]")).click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        WebElement cpList = CommonBaseTest.driver.findElements(By.xpath("(//span[.='Policy Active']/../..//td//a[contains(@id,'productConsolidatedViewForm:rootInstancesTable_certificate:')])")).get(0);
        return cpList.getText();
    }
}
