package com.exigen.dxp.employer.billingTab;
import com.exigen.dxp.DXPBaseTest;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestBillingTab extends DXPBaseTest {
    @Test(priority = 6)
    public void testVerifyBilling() throws IOException, InterruptedException {
        logger = extent.startTest("Verify Billing Tab");
        prop.load(fileInput);
        navigateToMainPage();
        VerifyBillingTabPage vbp=new VerifyBillingTabPage(driver, builder);

        vbp.clickOnRenLogo();

        reportLog("Click on Billing tab",0);
        vbp.clickBilling();

        reportLog("Generate bill details are below ",1);
        vbp.generateBill();

        reportLog("View Billing History details are below ",1);
        vbp.viewBillingHistory();

        reportLog("View statements in pdf format",1);
        vbp.viewStatements();

        reportLog("=============================================",1);
    }
}
