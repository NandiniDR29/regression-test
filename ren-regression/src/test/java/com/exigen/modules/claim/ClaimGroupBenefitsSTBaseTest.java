package com.exigen.modules.claim;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.modules.policy.common.pages.PolicySummaryPage;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.GroupBenefitsClaimType;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.DisabilityClaimSTContext;
import com.exigen.ren.main.modules.policy.gb_st.masterpolicy.StatutoryDisabilityInsuranceMasterPolicyContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ClaimGroupBenefitsSTBaseTest extends ClaimGroupBenefitsBaseTest implements StatutoryDisabilityInsuranceMasterPolicyContext, DisabilityClaimSTContext {

    protected GroupBenefitsClaimType getClaimType() {
        return GroupBenefitsClaimType.CLAIM_DI_ST;
    }
    public String returnSTCp(){
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Statutory Disability Insurance')]/..//td[1]")).click();
        PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        WebElement cpList = CommonBaseTest.driver.findElements(By.xpath("(//span[.='Policy Active']/../..//td//a[contains(@id,'productConsolidatedViewForm:rootInstancesTable_certificate:')])")).get(0);
        return cpList.getText();
    }
    public static boolean checkApprovedStatus(){
        boolean value=false;
        List<WebElement>status  = CommonBaseTest.driver.findElements(By.xpath("//span[contains(@id,'paymentStatusAsString')]"));
        for (WebElement currentStatus:status) {
            if(currentStatus.getText().equalsIgnoreCase("Approved")){
               value  = true;
            }
        }
        return value;
    }

}
