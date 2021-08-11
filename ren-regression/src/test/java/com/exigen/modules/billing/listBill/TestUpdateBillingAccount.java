package com.exigen.modules.billing.listBill;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.data.TestData;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.account.BillingAccountContext;
import com.exigen.modules.billing.account.actions.AddPaymentAction;
import com.exigen.ren.main.modules.billing.account.tabs.AddPaymentMethodTab;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestUpdateBillingAccount extends GroupBenefitsBillingBaseTest implements BillingAccountContext {
    @Test(priority = 26)
    public void testUpdateBillingAccount() throws IOException {
        logger = extent.startTest(groupNo+" Update Billing Account");
        prop.load(fileInput);
        reportLog("Navigating to Billing Tab", 0);
        for(Map.Entry<String, String> billingAccountAndProduct: CommonGenericMethods.getBillingAccount(groupNo).entrySet()) {
            search(billingAccountAndProduct.getValue());
            reportLog("Search for Billing Account #: "+ billingAccountAndProduct.getValue(), 1);
            billingAccount.updateBillingAccount().perform(billingAccount.getDefaultTestData("UpdateBillingAccount", "TestData"));

            reportLog("Updating Billing account for Email and Phone", 1);
            break;
        }
        reportLog("=================================",1);
    }
}
