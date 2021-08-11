package com.exigen.dxp.employer.billingTab;

import com.exigen.dxp.DXPBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static com.exigen.dxp.DxpCommonMethods.informationPrint;
import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;

public class TestPostPayment extends DXPBaseTest {
    @Test(priority = 19)
    public void testPostPayment() throws IOException {
        logger = extent.startTest("TestPostPayment");
        prop.load(fileInput);
        navigateToMainPage();
        VerifyBillingTabPage verifyBillingTabPage = new VerifyBillingTabPage(driver, builder);
        reportLog("Click on Billing tab", 0);
        verifyBillingTabPage.clickBilling();
        Assert.assertEquals(verifyBillingTabPage.getPageTitle().getText(), "Billing");
        reportLog("Search Billing account: "+prop.getProperty("EFTBillingAcc"), 1);
        verifyBillingTabPage.searchBillingAccountNumber(prop.getProperty("EFTBillingAcc"));
        reportLog("Verify searched table rows", 1);
        assertSoftly(softly -> {
            softly.assertThat(verifyBillingTabPage.getTableSize().size()).isEqualTo(2);
            softly.assertThat(verifyBillingTabPage.getColumns().size()).isEqualTo(4);
            softly.assertThat(verifyBillingTabPage.getFirstColumnHeader().getText()).isEqualToIgnoringCase("Group Number");
            softly.assertThat(verifyBillingTabPage.getSecondColumnHeader().getText()).isEqualToIgnoringCase("Billing Account Number");
            softly.assertThat(verifyBillingTabPage.getThirdColumnHeader().getText()).isEqualToIgnoringCase("Billing Account Name");
            softly.assertThat(verifyBillingTabPage.getFourthColumnHeader().getText()).isEqualToIgnoringCase("Action");
        });
        verifyBillingTabPage.printSearchedBillingAccountInformation();
        verifyBillingTabPage.selectViewStatement();
        reportLog("Verify View Statement page title ", 1);
        Assert.assertEquals(verifyBillingTabPage.getPageTitle().getText(), "Statements");
        assertSoftly(softly -> {
            softly.assertThat(verifyBillingTabPage.getColumns().size()).isEqualTo(5);
            softly.assertThat(verifyBillingTabPage.getColumnHeaderName().get(0).getText()).isEqualToIgnoringCase("Invoice Number");
            softly.assertThat(verifyBillingTabPage.getColumnHeaderName().get(1).getText()).isEqualToIgnoringCase("Due Date");
            softly.assertThat(verifyBillingTabPage.getColumnHeaderName().get(2).getText()).isEqualToIgnoringCase("Amount");
            softly.assertThat(verifyBillingTabPage.getColumnHeaderName().get(3).getText()).isEqualToIgnoringCase("Status");
            softly.assertThat(verifyBillingTabPage.getColumnHeaderName().get(4).getText()).isEqualToIgnoringCase("Action");
        });
        int size = verifyBillingTabPage.getRowData().size();
        if(size>0){
            boolean result=false;
            verifyBillingTabPage.printStatementPageTableInfo();
            List<WebElement> invoiceStatus = verifyBillingTabPage.getStatusList();
            for (WebElement status:invoiceStatus) {
                if(status.getText().equalsIgnoreCase("Issued")){
                    result=true;
                }
            }
            if (result==true){
                verifyBillingTabPage.performPostPayment();

            }
            else {
                ArrayList invoiceNumbers = verifyBillingTabPage.getInvoiceNumber();
                informationPrint(invoiceNumbers.toString()+" are not in Issued Status");
            }


        }







    }
}
