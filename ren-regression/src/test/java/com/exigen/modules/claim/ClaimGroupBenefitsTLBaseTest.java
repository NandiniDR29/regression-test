/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.claim;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.GroupBenefitsClaimType;
import com.exigen.ren.main.modules.claim.gb_tl.TermLifeClaimContext;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.TermLifeInsuranceCertificatePolicyContext;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.TermLifeInsuranceMasterPolicyContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClaimGroupBenefitsTLBaseTest extends ClaimGroupBenefitsBaseTest implements TermLifeInsuranceMasterPolicyContext, TermLifeInsuranceCertificatePolicyContext, TermLifeClaimContext {

    protected GroupBenefitsClaimType getClaimType() {
        return GroupBenefitsClaimType.CLAIM_TERM_LIFE;
    }
    public String returnTLCp(){
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("(//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Term Life Insurance')]/..//td//a)[1]")).click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        WebElement cpList = CommonBaseTest.driver.findElements(By.xpath("(//span[.='Policy Active']/../..//td//a[contains(@id,'productConsolidatedViewForm:rootInstancesTable_certificate:')])")).get(0);
        return cpList.getText();
    }
    public static String returnTLCPForSpecifiedParticipant(){
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        WebElement E= CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Term Life Insurance')]/..//td//a"));
        E.click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        return PolicySummaryPage.labelPolicyNumber.getValue();
    }
}
