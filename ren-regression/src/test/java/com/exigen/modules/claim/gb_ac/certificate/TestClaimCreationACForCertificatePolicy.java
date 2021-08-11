/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.claim.gb_ac.certificate;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.modules.claim.ClaimGroupBenefitsACBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants.ClaimStatus;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestClaimCreationACForCertificatePolicy extends ClaimGroupBenefitsACBaseTest {
    @Test(priority = 28)
    public void testClaimCreationCertificate() throws IOException {
        logger = extent.startTest(groupNo + " Group Accident claim");
        prop.load(fileInput);
        reportLog("Searching for customer ", 0);
        search(prop.getProperty("CustomerNumber"));
        String cpNumber = returnACCCp();
        search(cpNumber);
        reportLog("Create Claim : "+cpNumber, 1);
        createDefaultGroupAccidentClaimForCertificatePolicy();
        String claimNumber = ClaimSummaryPage.getClaimNumber();
        reportLog("Claim Number" + claimNumber, 1);
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimStatus.INITIAL);
        LOGGER.info("TEST: Submit Claim #" + claimNumber);
        claim.claimSubmit().perform(new SimpleDataProvider());
        assertThat(ClaimSummaryPage.labelClaimStatus).hasValue(ClaimStatus.NOTIFICATION);
        reportLog("Claim submitted", 1);
    }
    public String returnACCCp(){
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Group Accident')]/..//td[1]")).click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        WebElement cpList = CommonBaseTest.driver.findElements(By.xpath("(//span[.='Policy Active']/../..//td//a[contains(@id,'productConsolidatedViewForm:rootInstancesTable_certificate:')])")).get(0);
        return cpList.getText();
    }

}
