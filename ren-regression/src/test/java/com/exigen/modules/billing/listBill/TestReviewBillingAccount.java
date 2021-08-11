package com.exigen.modules.billing.listBill;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.istf.verification.CustomAssertions;
import com.exigen.modules.billing.BillingAccountConstants;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.account.BillingAccountContext;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.pages.summary.billing.BillingSummaryPage.*;
import static com.exigen.ren.main.pages.summary.billing.BillingSummaryPage.elementInvoicingCalendarBillingCalendar;

public class TestReviewBillingAccount extends GroupBenefitsBillingBaseTest implements BillingAccountContext {

    @Test(priority = 14)
    public void testReviewBillingAccount() throws IOException {
        logger = extent.startTest(groupNo + "  Test Review Billing Account ");
        prop.load(fileInput);
        reportLog("Application started...", 0);

        for(Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()){
            reportLog("Searching for Billing Account: " + BillingAccountAndProduct.getValue(), 1);
            search(BillingAccountAndProduct.getValue());
            BillingSummaryPage.tableBillingGeneralInformation.getRow(1).getCell(TableConstants.BillingGeneralInformationGB.INVOICING_CALENDAR.getName()).controls.links.getFirst().click();
            invoicingCalendarPopup.waitForAccessible(5000);
            if(!(BillingAccountAndProduct.getKey().equalsIgnoreCase("Stat") || BillingAccountAndProduct.getKey().equalsIgnoreCase("PFL"))){
                reportLog("Review Billing Account for Product: " + BillingAccountAndProduct.getKey(), 1);
                if(groupNo.equalsIgnoreCase("Group1") || groupNo.equalsIgnoreCase("Group8")){
                    verifyMonthlyCalendarOnTime();
                }else if(groupNo.equalsIgnoreCase("Group2") || groupNo.equalsIgnoreCase("Group4") || groupNo.equalsIgnoreCase("Group6") || groupNo.equalsIgnoreCase("Group11") || groupNo.equalsIgnoreCase("Group12")){
                    verifyAnnualCalendar();
                }else if(groupNo.equalsIgnoreCase("Group3") || groupNo.equalsIgnoreCase("Group7")){
                    verifyQuarterlyCalendar();
                }else if(groupNo.equalsIgnoreCase("Group5")){
                    verifySemiAnnualCalendar();
                }else if(groupNo.equalsIgnoreCase("Group9")){
                    verifyMonthlyCalendarInArrears();
                }
            }else {
                reportLog("Review Billing Account for Product: " + BillingAccountAndProduct.getKey(), 1);
                verifyStaturoryQuarterlyCalendarInArrears();
            }
            Page.dialogConfirmation.buttonClose.click();
        }
        reportLog("==========================================", 1);
    }

    private static void verifyMonthlyCalendarOnTime() {
        reportLog("Billing Calendar Verified : " + elementInvoicingCalendarBillingCalendar.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarBillingCalendar).hasValue(BillingAccountConstants.BILLING_CALENDAR);

        reportLog("Invoicing Due Day Verified : " + elementInvoicingCalendarInvoiceDueDate.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoiceDueDate).hasValue(BillingAccountConstants.INVOICE_DUE_DAY);

        reportLog("Invoicing Generation Date Rule Verified : " + elementInvoicingCalendarGenerationDateRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarGenerationDateRule).hasValue(BillingAccountConstants.GENERATION_DATE_RULE);

        reportLog("Billing offset Period Verified : " + elementInvoicingCalendarInvoicingRuleOffset.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingRuleOffset).hasValue(BillingAccountConstants.BILLING_PERIOD_OFFSET);

        reportLog("Invoicing Rule Verified : " + elementInvoicingCalendarInvoicingRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingRule).hasValue(BillingAccountConstants.ON_TIME_INVOICING_RULE);

        reportLog("Invoicing Frequency Verified : " + elementInvoicingCalendarInvoicingFrequency.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingFrequency).hasValue(BillingAccountConstants.MONTHLY_INVOICING_FREQUENCY);
    }

    private static void verifyAnnualCalendar() {
        reportLog("Billing Calendar Verified : " + elementInvoicingCalendarBillingCalendar.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarBillingCalendar).hasValue(BillingAccountConstants.BILLING_CALENDAR);

        reportLog("Invoicing Due Day Verified : " + elementInvoicingCalendarInvoiceDueDate.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoiceDueDate).hasValue(BillingAccountConstants.INVOICE_DUE_DAY);

        reportLog("Invoicing Generation Date Rule Verified : " + elementInvoicingCalendarGenerationDateRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarGenerationDateRule).hasValue(BillingAccountConstants.ANNUAL_GENERATION_DATE_RULE);

        reportLog("Invoicing Rule Verified : " + elementInvoicingCalendarInvoicingRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingRule).hasValue(BillingAccountConstants.ON_TIME_INVOICING_RULE);

        reportLog("Invoicing Frequency Verified : " + elementInvoicingCalendarInvoicingFrequency.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingFrequency).hasValue(BillingAccountConstants.ANNUAL_INVOICING_FREQUENCY);
    }

    private static void verifyQuarterlyCalendar() {
        reportLog("Billing Calendar Verified : " + elementInvoicingCalendarBillingCalendar.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarBillingCalendar).hasValue(BillingAccountConstants.BILLING_CALENDAR);

        reportLog("Invoicing Due Day Verified : " + elementInvoicingCalendarInvoiceDueDate.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoiceDueDate).hasValue(BillingAccountConstants.INVOICE_DUE_DAY);

        reportLog("Invoicing Generation Date Rule Verified : " + elementInvoicingCalendarGenerationDateRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarGenerationDateRule).hasValue(BillingAccountConstants.GENERATION_DATE_RULE);

        reportLog("Billing offset Period Verified : " + elementInvoicingCalendarInvoicingRuleOffset.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingRuleOffset).hasValue(BillingAccountConstants.BILLING_PERIOD_OFFSET_3);

        reportLog("Invoicing Rule Verified : " + elementInvoicingCalendarInvoicingRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingRule).hasValue(BillingAccountConstants.IN_ARREAR_INVOICING_RULE);

        reportLog("Invoicing Frequency Verified : " + elementInvoicingCalendarInvoicingFrequency.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingFrequency).hasValue(BillingAccountConstants.QUARTERLY_INVOICING_FREQUENCY);
    }

    private static void verifySemiAnnualCalendar() {
        reportLog("Billing Calendar Verified : " + elementInvoicingCalendarBillingCalendar.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarBillingCalendar).hasValue(BillingAccountConstants.BILLING_CALENDAR);

        reportLog("Invoicing Due Day Verified : " + elementInvoicingCalendarInvoiceDueDate.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoiceDueDate).hasValue(BillingAccountConstants.INVOICE_DUE_DAY);

        reportLog("Invoicing Generation Date Rule Verified : " + elementInvoicingCalendarGenerationDateRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarGenerationDateRule).hasValue(BillingAccountConstants.GENERATION_DATE_RULE);

        reportLog("Invoicing Rule Verified : " + elementInvoicingCalendarInvoicingRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingRule).hasValue(BillingAccountConstants.ON_TIME_INVOICING_RULE);

        reportLog("Invoicing Frequency Verified : " + elementInvoicingCalendarInvoicingFrequency.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingFrequency).hasValue(BillingAccountConstants.SEMI_ANNUAL_INVOICING_FREQUENCY);
    }

    private static void verifyMonthlyCalendarInArrears() {
        reportLog("Billing Calendar Verified : " + elementInvoicingCalendarBillingCalendar.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarBillingCalendar).hasValue(BillingAccountConstants.BILLING_CALENDAR);

        reportLog("Invoicing Due Day Verified : " + elementInvoicingCalendarInvoiceDueDate.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoiceDueDate).hasValue(BillingAccountConstants.MONTHLY_ARREAR_INVOICE_DUE_DAY);

        reportLog("Invoicing Generation Date Rule Verified : " + elementInvoicingCalendarGenerationDateRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarGenerationDateRule).hasValue(BillingAccountConstants.MONTHLY_ARREAR_GENERATION_DATE_RULE);

        reportLog("Billing offset Period Verified : " + elementInvoicingCalendarInvoicingRuleOffset.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingRuleOffset).hasValue(BillingAccountConstants.MONTHLY_ARREAR_INVOICING_PERIOD_OFFSET);

        reportLog("Invoicing Rule Verified : " + elementInvoicingCalendarInvoicingRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingRule).hasValue(BillingAccountConstants.IN_ARREAR_INVOICING_RULE);

        reportLog("Invoicing Frequency Verified : " + elementInvoicingCalendarInvoicingFrequency.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingFrequency).hasValue(BillingAccountConstants.MONTHLY_INVOICING_FREQUENCY);
    }

    private static void verifyStaturoryQuarterlyCalendarInArrears() {
        reportLog("Billing Calendar Verified : " + elementInvoicingCalendarBillingCalendar.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarBillingCalendar).hasValue(BillingAccountConstants.BILLING_CALENDAR);

        reportLog("Invoicing Due Day Verified : " + elementInvoicingCalendarInvoiceDueDate.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoiceDueDate).hasValue(BillingAccountConstants.INVOICE_DUE_DAY);

        reportLog("Invoicing Generation Date Rule Verified : " + elementInvoicingCalendarGenerationDateRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarGenerationDateRule).hasValue(BillingAccountConstants.GENERATION_DATE_RULE);

        reportLog("Billing offset Period Verified : " + elementInvoicingCalendarInvoicingRuleOffset.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingRuleOffset).hasValue(BillingAccountConstants.BILLING_PERIOD_OFFSET_3);

        reportLog("Invoicing Rule Verified : " + elementInvoicingCalendarInvoicingRule.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingRule).hasValue(BillingAccountConstants.IN_ARREAR_INVOICING_RULE);

        reportLog("Invoicing Frequency Verified : " + elementInvoicingCalendarInvoicingFrequency.getValue(), 1);
        CustomAssertions.assertThat(elementInvoicingCalendarInvoicingFrequency).hasValue(BillingAccountConstants.QUARTERLY_INVOICING_FREQUENCY);
    }

}
