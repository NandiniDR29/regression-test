package com.exigen.dxp.employer.billingTab;

import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;

public class TestViewListOfFinalBill extends DXPBaseTest {
    @Test(priority = 15)
    public void testViewListOfFinalBill(){
        logger = extent.startTest("Test View List of Final Bill");
        navigateToMainPage();
        ViewListOfFinalBillPage billing = new ViewListOfFinalBillPage(driver);
        reportLog("Verify Search With Billing Account Number",0);
        billing.verifySearchWithBillingAccountNumber();
        reportLog("Verify View Billing History",1);
        billing.verifyViewBillingHistory();
        reportLog("Verify Invoice and DueDate Filter",1);
        billing.verifyInvoiceAndDueDateFilter();
        reportLog("Verify View Statements",1);
        billing.verifyViewStatements();
        reportLog("====================",1);
    }
}
