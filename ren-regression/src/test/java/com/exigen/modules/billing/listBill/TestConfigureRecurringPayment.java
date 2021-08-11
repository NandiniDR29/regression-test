package com.exigen.modules.billing.listBill;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.account.BillingAccountContext;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestConfigureRecurringPayment extends GroupBenefitsBillingBaseTest implements BillingAccountContext {
    @Test(priority = 25)
    public void testConfigureRecurringPayment() throws IOException {
        logger = extent.startTest(groupNo+" Configure Recurring Payment");
        prop.load(fileInput);
        reportLog("Navigating to Billing Tab", 0);
        for(Map.Entry<String, String> billingAccountAndProduct: CommonGenericMethods.getBillingAccount(groupNo).entrySet()){
            String billingAccNum = billingAccountAndProduct.getValue();
            search(billingAccountAndProduct.getValue());
            reportLog("Search for Billing Account #: "+ billingAccountAndProduct.getValue(), 1);
            billingAccount.updateBillingAccount().perform(billingAccount.getDefaultTestData("RecurringPayment", "AddPaymentMethod"));
            reportLog("Adding Payment option to configure Recurring Payment", 1);
            billingAccount.updateBillingAccount().perform(billingAccount.getDefaultTestData("RecurringPayment", "SetupRecurringPayment"));
            reportLog("Performing configuration for Recurring Payment", 1);
            CommonGenericMethods.saveEFTAddedBillingAccount(billingAccNum);
            break;
        }
        reportLog("================================", 1);
    }
}
