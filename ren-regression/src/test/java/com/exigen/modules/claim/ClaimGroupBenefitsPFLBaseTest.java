/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.claim;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.GroupBenefitsClaimType;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.DisabilityClaimPFLContext;
import com.exigen.ren.main.modules.policy.gb_pfl.masterpolicy.PaidFamilyLeaveMasterPolicyContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClaimGroupBenefitsPFLBaseTest extends ClaimGroupBenefitsBaseTest implements PaidFamilyLeaveMasterPolicyContext, DisabilityClaimPFLContext {

    protected GroupBenefitsClaimType getClaimType() {
        return GroupBenefitsClaimType.CLAIM_DI_PFL;
    }
    public String returnPFLCp(){
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("(//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Paid Family Leave')]/..//td//a)[1]")).click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        WebElement cpList = CommonBaseTest.driver.findElements(By.xpath("(//span[.='Policy Active']/../..//td//a[contains(@id,'productConsolidatedViewForm:rootInstancesTable_certificate:')])")).get(0);
        return cpList.getText();
    }

}
