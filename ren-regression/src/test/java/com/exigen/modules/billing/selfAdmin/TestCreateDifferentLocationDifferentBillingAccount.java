package com.exigen.modules.billing.selfAdmin;
import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.webdriver.controls.composite.table.Cell;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.account.BillingAccountContext;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.BillingConstants;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;
import static com.exigen.helpers.CommonGenericMethods.saveBillingAccount;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.enums.NavigationEnum.AppMainTabs.BILLING;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.pages.summary.billing.BillingAccountsListPage.tableBenefitAccounts;
public class TestCreateDifferentLocationDifferentBillingAccount extends GroupBenefitsBillingBaseTest implements BillingAccountContext {
    @Test(priority = 13)
    public void testCreateBillingAccountForDifferentLocation() throws IOException {
        logger = extent.startTest(groupNo + " Payment For Different Location Different Billing Account");
        for (Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()) {
            LOGGER.info("Product :::"+ BillingAccountAndProduct.getKey());
            if(groupNo.equalsIgnoreCase("Group7") || groupNo.equalsIgnoreCase("Group11")){
                if(BillingAccountAndProduct.getKey().equalsIgnoreCase("Stat") || BillingAccountAndProduct.getKey().equalsIgnoreCase("Dental")) {
                    search(BillingAccountAndProduct.getValue());
                    reportLog("Search Billing Account Number # " + BillingAccountAndProduct.getValue(), 0);
                    if(groupNo.equalsIgnoreCase("Group7")){
                        billingAccount.setupBillingGroups().perform(billingAccount.getDefaultTestData("DifferentLocationDifferentBilling", "SetupBillingGroups_ForTwoLocs_TestData"));
                    }else {
                        billingAccount.setupBillingGroups().perform(billingAccount.getDefaultTestData("DifferentLocationDifferentBilling", "SetupBillingGroups_ForTwoLocs_TestDataG11"));
                    }
                    NavigationPage.toMainTab(BILLING);
                    Cell secondBillingAccountCell = tableBenefitAccounts.getRow(1).getCell(BillingConstants.BillingBenefitAccountsTable.BILLING_ACCOUNT);
                    String secondBillingAccountNumber = secondBillingAccountCell.getValue();
                    if (groupNo.equalsIgnoreCase("Group7") || groupNo.equalsIgnoreCase("Group9")) {
                        LOGGER.info("Created Billing Group for billing location 2 is " + secondBillingAccountNumber);
                        reportLog("Created new billing account for billing location 2 is " + secondBillingAccountNumber, 1);
                        saveBillingAccount("Stat2", groupNo, secondBillingAccountNumber);
                    } else if (groupNo.equalsIgnoreCase("Group11")) {
                        LOGGER.info("Created Billing account for billing location 2 is " + secondBillingAccountNumber + " Group 11");
                        reportLog("Created new billing account for billing location 2 is " + secondBillingAccountNumber, 1);
                        saveBillingAccount("Dental2", groupNo, secondBillingAccountNumber);
                    }
                }
            }
        }
    }
}