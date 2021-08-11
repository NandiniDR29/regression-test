package com.exigen.modules.billing.selfAdmin;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.PremiumAdjustmentPage;
import com.exigen.modules.billing.account.BillingAccountContext;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.billing.account.pages.AdjustPremiumPage;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import com.google.common.collect.ImmutableMap;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;

public class TestAdjustPremium extends GroupBenefitsBillingBaseTest implements BillingAccountContext {
    @Test(priority = 17)
    public void testAdjustPremium() throws IOException {
        logger = extent.startTest(groupNo + " Adjust Premium for Self Admin Billing Account");
        prop.load(fileInput);
        for(Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()) {
           if(BillingAccountAndProduct.getKey().equalsIgnoreCase("Stat") || BillingAccountAndProduct.getKey().equalsIgnoreCase("Stat2")){
               reportLog("Searching for Billing Account: " + BillingAccountAndProduct.getValue(), 0);
               search(BillingAccountAndProduct.getValue());
               String invoiceNum1 = BillingSummaryPage.tableBillsAndStatements.getRow(1).getCell(TableConstants.BillingBillsAndStatementsGB.INVOICE.getName()).getValue();
               BillingSummaryPage.openBillsStatementsPeriodView();
               BillingSummaryPage.tableBillsAndStatementsByPeriod.getRow(ImmutableMap.of(TableConstants.BillingBillsAndStatementsGBByPeriod.INVOICE.getName(), invoiceNum1))
                       .getCell(TableConstants.BillingBillsAndStatementsGBByPeriod.ACTION.getName()).controls.links.getFirst().click();
               reportLog("Switching to By Period and click on edit for generated invoice "+ invoiceNum1, 1);
               PremiumAdjustmentPage premiumAdjustment = new PremiumAdjustmentPage(driver);
               Currency volume = new Currency(premiumAdjustment.getDefaultVolume());
               reportLog("Volume value : "+ premiumAdjustment.getDefaultVolume(), 1);
               Currency addVolume = new Currency(100);
               Currency updateVolume = volume.add(addVolume);
               reportLog("Updating Volume to value of "+ updateVolume.toString(), 1);
               premiumAdjustment.updateVolume(updateVolume.toString());
               AdjustPremiumPage.submitAdjustments();
               reportLog("Submitting Adjustment "+ updateVolume.toString(), 1);
               assertSoftly(softly->{
                   softly.assertThat(BillingSummaryPage.tableBillsAndStatements).with(TableConstants.BillingBillsAndStatementsGB.INVOICE, invoiceNum1).with(TableConstants.BillingBillsAndStatementsGB.STATUS, "Discarded (Estimated)").isPresent();
               });
               reportLog("Verify already generated Invoice Declined ", 1);
               break;
           }
        }
        reportLog("================================", 1);
    }
}
