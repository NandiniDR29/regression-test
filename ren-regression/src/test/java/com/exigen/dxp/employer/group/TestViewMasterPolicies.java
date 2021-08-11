package com.exigen.dxp.employer.group;

import com.exigen.dxp.DXPBaseTest;
import com.exigen.dxp.employer.group.viewMasterPolicy.MasterPoliciesPage;
import org.testng.annotations.Test;

import java.util.List;

public class TestViewMasterPolicies extends DXPBaseTest {
    @Test(priority = 9)
    public void testViewMasterPolicies(){
        logger = extent.startTest("View Master Policies");
        navigateToMainPage();

        MasterPoliciesPage masterPolicyPage = new MasterPoliciesPage(driver);
        EmployerGroupPage employerGroup = new EmployerGroupPage(driver);

        String groupCustomerName = employerGroup.getGroupCustomerName();
        String groupCustomerId = employerGroup.getGroupCustomerId();

        masterPolicyPage.clickOnViewMasterPolicies();
        masterPolicyPage.verifyGroupName(groupCustomerName);
        masterPolicyPage.verifyGroupNumber(groupCustomerId);
        masterPolicyPage.masterPoliciesDetailsAssociatedWithGroup();

        List<String> policy = masterPolicyPage.getPolicy();
        List<String> product = masterPolicyPage.getProduct();

        for(int i = 0; i < policy.size(); i++){
            masterPolicyPage.viewPlanDetails(i);
            masterPolicyPage.verifyPlanDetailsScreen(groupCustomerName, policy.get(i));
            masterPolicyPage.verifyPlan(product.get(i));
            masterPolicyPage.verifyCoverage(product.get(i));
            masterPolicyPage.verifyViewDetail(product.get(i));
            masterPolicyPage.verifyViewBenefits(product.get(i));
            masterPolicyPage.verifyDB120FormDownload(product.get(i));
            masterPolicyPage.returnToMasterPolicyList();
        }
        masterPolicyPage.returnGroupScreen();
    }
}
