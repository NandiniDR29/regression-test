package com.exigen.modules.billing.listBill;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.account.BillingAccountContext;
import com.exigen.ren.main.enums.TableConstants;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.pages.summary.billing.BillingSummaryPage.tableBillsAndStatements;

public class TestFutureStatement extends GroupBenefitsBillingBaseTest implements BillingAccountContext {
    @Test(priority = 16)
    public void testGenerateInvoice() throws IOException, ParseException {
        logger = extent.startTest(groupNo+" TestGenerateInvoice");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        String invoiceperiod;
        for(Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()){
            reportLog("Searching for Billing Account: " + BillingAccountAndProduct.getValue(), 1);
            search(BillingAccountAndProduct.getValue());
            reportLog("Posting Payment for the Product ::: " + BillingAccountAndProduct.getKey() + " :::", 1);
            try{
                invoiceperiod = tableBillsAndStatements.getRow(1).getCell(TableConstants.BillingBillsAndStatementsGB.BILLING_PERIOD.getName()).getValue();
            }catch(IstfException e){
                try{
                    billingAccount.generateFutureStatement().perform();
                }catch (Exception f){
                    driver.navigate().refresh();
                    billingAccount.generateFutureStatement().perform();
                }
                invoiceperiod = tableBillsAndStatements.getRow(1).getCell(TableConstants.BillingBillsAndStatementsGB.BILLING_PERIOD.getName()).getValue();
            }
            String invoicePeriodEndDate = invoiceperiod.split("-")[1].trim();
            while(!(checkInvoiceDateIsFuture(invoicePeriodEndDate))){
                billingAccount.generateFutureStatement().perform();
                invoiceperiod = tableBillsAndStatements.getRow(1).getCell(TableConstants.BillingBillsAndStatementsGB.BILLING_PERIOD.getName()).getValue();
                reportLog("Invoice Genrerated for the period of : "+ invoiceperiod, 1);
                invoicePeriodEndDate = invoiceperiod.split("-")[1].trim();
            }
            reportLog("Invoice Genrerated for the period of current month : "+ invoiceperiod, 1);
        }
        reportLog("==========================================", 1);
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
