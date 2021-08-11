package com.exigen.modules.billing.listBill;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.data.impl.SimpleDataProvider;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.account.BillingAccountContext;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.billing.account.tabs.GenerateDraftBillActionTab;
import com.exigen.ren.main.pages.summary.billing.BillingAccountsListPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.BamConstants.*;

public class TestGenerateDraftBill extends GroupBenefitsBillingBaseTest implements BillingAccountContext {
    @Test(priority = 15)
    public void testGenerateDraftBill() throws IOException, ParseException {
        logger = extent.startTest(groupNo+" TestDraftBill");
        prop.load(fileInput);
        for(Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()){
            reportLog("Application started...", 0);
            search(BillingAccountAndProduct.getValue());
            LOGGER.info("---=={Step 1}==---");
            billingAccount.generateDraftBill().start();
            String[] parsedTextArray = GenerateDraftBillActionTab.draftBillPopupPanel.getValue().split(" ");
            String dueDate = parsedTextArray[3];
            String periodStart = parsedTextArray[6];
            String periodEnd = parsedTextArray[8];
            Page.dialogConfirmation.buttonCancel.click();
            BillingAccountsListPage.verifyBamActivities(BillingAccountAndProduct.getValue(), String.format(BILLING_DRAFT_BILL_INITIATE, dueDate, periodStart, periodEnd), CANCELLED);

            LOGGER.info("---=={Step 2}==---");
            billingAccount.generateDraftBill().perform(new SimpleDataProvider());
            BillingAccountsListPage.verifyBamActivities(BillingAccountAndProduct.getValue(), String.format(BILLING_DRAFT_BILL_GENERATE, dueDate, periodStart, periodEnd), FINISHED);
            break;
        }
       // reportLog("Genrerated draft bill for the period of current month : "+ draftBillPerod, 1);
    }

    public static boolean checkInvoiceDateIsFuture(String invoiceToDate) throws ParseException {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        Date lastDayOfMonth = calendar.getTime();

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        String formattedCurrentDate = dateFormatter.format(lastDayOfMonth);

        Date invoiceTillDate = dateFormatter.parse(invoiceToDate);
        Date ofCurrentDate = dateFormatter.parse(formattedCurrentDate);

        if((invoiceTillDate.compareTo(ofCurrentDate)>0) || invoiceTillDate.compareTo(ofCurrentDate)==0){
            System.out.println("=====<<< Invoice Generation for Current period is Generated >>>=====");
            return true;
        }else{
            System.out.println("=====<<< Invoice is not generated for current month >>>=====");
            return false;
        }
    }
}
