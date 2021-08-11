package com.exigen.modules.claim;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.GroupBenefitsClaimType;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.DisabilityClaimLTDContext;
import com.exigen.ren.main.modules.policy.gb_di_ltd.certificate.LongTermDisabilityCertificatePolicyContext;
import com.exigen.ren.main.modules.policy.gb_di_ltd.masterpolicy.LongTermDisabilityMasterPolicyContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClaimGroupBenefitsLTDBaseTest extends ClaimGroupBenefitsBaseTest implements LongTermDisabilityMasterPolicyContext, LongTermDisabilityCertificatePolicyContext, DisabilityClaimLTDContext {

    protected GroupBenefitsClaimType getClaimType() {
        return GroupBenefitsClaimType.CLAIM_DI_LTD;
    }
    public String returnLTDCp(){
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Long Term Disability')]/..//td[1]")).click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        WebElement cpList = CommonBaseTest.driver.findElements(By.xpath("(//span[.='Policy Active']/../..//td//a[contains(@id,'productConsolidatedViewForm:rootInstancesTable_certificate:')])")).get(0);
        return cpList.getText();
    }
    public static String returnLTDCPForSpecifiedParticipant(){
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        WebElement E= CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Long Term Disability')]/..//td//a"));
        E.click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        return PolicySummaryPage.labelPolicyNumber.getValue();
    }

}