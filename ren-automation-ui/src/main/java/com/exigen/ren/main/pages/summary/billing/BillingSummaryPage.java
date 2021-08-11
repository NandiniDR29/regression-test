/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.pages.summary.billing;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.ipb.eisa.utils.RetryService;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.enums.NavigationEnum.AppMainTabs;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.BillingConstants;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.enums.TableConstants.CurrentPeriod;
import com.exigen.ren.main.pages.summary.SummaryPage;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class BillingSummaryPage extends SummaryPage {
    public static RadioButton radioButtonBillableCoveragesByLocation = new RadioButton(By.xpath("//td[label=' by location']/input"));
    public static RadioButton radioButtonBillableCoveragesByBillingGroup = new RadioButton(By.xpath("//td[label=' by billing group']/input"));

    public static Button buttonPaymentsBillingMaintenance = new Button(By.id("billingInfoForm:backOffice"));
    public static Button buttonTasks = new Button(By.xpath("//*[contains(@id,'tasksList') and text()='Tasks']"));
    public static ComboBox comboBoxTakeAction = new ComboBox(By.xpath("//select[@id='billingInfoForm:moveToDropdown']"));
    public static StaticElement elementAccountNo = new StaticElement(By.xpath("//label[contains(text(),'Account No:')]//ancestor::div[1]/span"));
    public static StaticElement elementAccountName = new StaticElement(By.xpath("//label[contains(text(),'Account Name:')]//ancestor::div[1]/span"));
    public static StaticElement elementCustomerNo = new StaticElement(By.xpath("//label[contains(text(),'Customer No.:')]//ancestor::div[1]/span"));
    public static StaticElement elementCustomerName = new StaticElement(By.xpath("//label[contains(text(),'Customer Name:')]//ancestor::div[1]/span"));
    private static String labelInvoicePattern = "//div[@id='coveragesByGroupPreviewPanel']//h4[text()='Invoice #%s']";
    public static StaticElement elementInvoicingCalendarInvoiceDueDate = new StaticElement(By.id("billingDetailedForm:invoiceDueDate"));
    public static StaticElement elementInvoicingCalendarGenerationDateRule = new StaticElement(By.id("billingDetailedForm:generationDateRule"));
    public static StaticElement elementInvoicingCalendarInvoicingRuleOffset = new StaticElement(By.id("billingDetailedForm:invoicingRuleOffset"));
    public static StaticElement elementInvoicingCalendarInvoicingRule = new StaticElement(By.id("billingDetailedForm:invoicingRule"));
    public static StaticElement elementInvoicingCalendarInvoicingFrequency = new StaticElement(By.id("billingDetailedForm:invoicingFrequency"));

    public static StaticElement elementInvoicingCalendarBillingCalendar = new StaticElement(By.id("billingDetailedForm:billingCycleCalendarName"));
    public static StaticElement invoicingCalendarPopup = new StaticElement(By.id("billingDetailedForm:invoicingCalendarPopup"));

    public static TableExtended<TableConstants.BillingGeneralInformationGB> tableBillingGeneralInformation =
            new TableExtended<>("Billing General Information", By.xpath("//div[@id='billingDetailedForm:general_info_table']//table"), Waiters.SLEEP(5000));
    public static TableExtended<TableConstants.BillingBillableCoveragesGB> tableBillableCoverages =
            new TableExtended<>("Billable Coverages", By.xpath("//div[@id='billingDetailedForm:billable_coverages_info_table']//table"));
    public static TableExtended<TableConstants.BillingBillsAndStatementsGB> tableBillsAndStatements =
            new TableExtended<>("Bills And Statements", By.xpath("//div[@id='billingDetailedForm:benefits_invoices_table']//table"));
    public static TableExtended<TableConstants.BillingBillsAndStatementsGBByPeriod> tableBillsAndStatementsByPeriod =
            new TableExtended<>("Bills And Statements by period", By.xpath("//div[@id='billingDetailedForm:benefits_byPeriod_table']//table"));
    public static TableExtended<TableConstants.BillingPremiumByCoverageSegmentClassifier> tablePremiumByCoverageSegmentClassifier =
            new TableExtended<>("Premium by Coverage Segment Classifier", By.xpath("//div[@id='drillDownByPeriodPreviewPanel']//table"));


    public static TableExtended<TableConstants.BillableCoveragesByBillingGroup> tableBillableCoveragesByBillingGroup = new TableExtended<>("Coverages By Billing Group", By.xpath("//div[contains (@id, ':coveragesByGroup_table')]/div/table"));
    public static Table tableBillableCoveragesByLocation = new Table(By.xpath("//tbody[contains (@id, 'billingByLocations_table_data')]//ancestor::table[1]"));
    public static TableExtended<TableConstants.BillableCoveragesBillingGroupsByLocation> tableBillableCoveragesBillingGroupsByLocation = new TableExtended<>("Billable Coverages Billing Groups By Location", By.xpath("//div[contains (@id, ':billingGroupsByLocation_table')]/div[1]/table"));
    public static TableExtended<TableConstants.BillableCoveragesBillingGroupsByInvoice> tableCurrentPeriodForBillCovBillGroupsByInvoice =
            new TableExtended<>("Billable Coverages Billing Groups By Invoice | Current Period", By.xpath("//div[contains (@id, 'coveragesByGroup_currentPeriod_table')]//table"), By.xpath("//div[contains (@id, 'coveragesByGroup_currentPeriod_table_paginator_bottom')]"));
    public static TableExtended<TableConstants.PriorPeriodCharges> tablePriorPeriodCharges = new TableExtended<>("Billable Coverages Billing Groups By Invoice | Prior Period Charges", By.xpath("//div[@id='billingDetailedForm:benefits_invoices_table:0:coveragesByGroup_priorPeriod_table']/div/table"));
    public static TableExtended<TableConstants.AllocatedPayments> tableAllocatedPayments = new TableExtended<>("Billable Coverages Billing Groups By Invoice | Allocated Payments", By.xpath("//div[@id='billingDetailedForm:benefits_invoices_table:0:allocatedPayments_table']/div/table"));
    public static TableExtended<TableConstants.BillableCoveragesByGroupByLocation> tableBillableCoveragesByGroupByLocation = new TableExtended<>("Coverages By Group By Location", By.xpath("//div[contains (@id, ':coveragesByGroup_table')]/div[1]/table"));
    public static TableExtended<TableConstants.BillableCoveragesParticipantsByCoverageByLocation> tableBillableCoveragesParticipantsByCoverageByLocation = new TableExtended<>("Billable Coverages Participants By Coverage By Location", By.xpath("//div[contains (@id, ':participantsByCoverage_table')]/div/table"));
    private static Button expandFilterByLocation = new Button(By.xpath("//div[contains (@id, 'billingByLocations_table:locationAccordionPanel')]//a"));
    public static TextBox textBoxFilterByLocation = new TextBox(By.xpath("//input[contains (@id, 'billingByLocations_table:globalFilter')]"));
    public static TableExtended<CurrentPeriod> tableCurrentPeriod = new TableExtended<>("Current Period", By.xpath("//div[@id='billingDetailedForm:benefits_invoices_table:0:currentPeriod_table_nonPremium']/div/table"));
    public static TableExtended<TableConstants.BillingPaymentsAndAdjustmentsGB> tablePaymentsAndAdjustmentsGB =
            new TableExtended<>("Payments & Adjustments", By.xpath("//div[@id='billingDetailedForm:paymentsAndAdjustmentsTable']//table"));
    public static TableExtended<TableConstants.BillingPaymentsAndTransactionsGB> tablePaymentsOtherTransactions =
            new TableExtended<>("Payments Other Transactions", By.xpath("//div[@id='billingDetailedForm:billing_transactions_active']//table"));


    public static void open() {
        NavigationPage.toMainTab(AppMainTabs.BILLING);
    }

    public static void openBillsStatementsPeriodView() {
        new RadioButton(By.xpath("//td[label=' by period']/input")).setValue(true);
    }

    public static void openBillsStatementsLocationView() {
        radioButtonBillableCoveragesByLocation.setValue(true);
    }

    public static void expandBillsStatementsPeriodViewByInvoice(String invoiceNum) {
        tableBillsAndStatementsByPeriod.getRow(ImmutableMap.of(TableConstants.BillingBillsAndStatementsGBByPeriod.INVOICE.getName(), invoiceNum))
                .getCell(TableConstants.BillingBillsAndStatementsGBByPeriod.BILLING_PERIOD.getName()).controls.links.getFirst().click();
    }

    public static void expandBillsStatementsInvoiceViewByInvoice(String invoiceNum) {
        tableBillsAndStatements.getRow(ImmutableMap.of(TableConstants.BillingBillsAndStatementsGB.INVOICE.getName(), invoiceNum))
                .getCell(TableConstants.BillingBillsAndStatementsGB.INVOICE.getName()).controls.links.getFirst().click();
    }

    public static String getInvoiceNumberByRowNum(int rowNum) {
        return BillingSummaryPage.tableBillsAndStatements.getRow(rowNum).getCell(BillingConstants.BillingBillsAndStatmentsTable.INVOICE).getValue();
    }

    public static void searchByLocationFilter(String text) {
        if (!textBoxFilterByLocation.isVisible()) {
            expandFilterByLocation.click();
        }
        textBoxFilterByLocation.getWebElement().clear();
        text.chars().mapToObj(i -> (char) i).forEach(character -> {
            textBoxFilterByLocation.getWebElement().sendKeys(character.toString());
            Waiters.AJAX.go();
        });
    }

    public static String getCurrentDue() {
        RetryService.run(predicate ->
                        !BillingSummaryPage.tableBillingGeneralInformation.getRow(1).getCell(TableConstants.BillingGeneralInformationGB.CURRENT_DUE.getName()).getValue().contains("Calculating"),
                () -> {
                    BrowserController.get().driver().navigate().refresh();
                    return null;
                },
                StopStrategies.stopAfterAttempt(15), WaitStrategies.fixedWait(2, TimeUnit.SECONDS));

        return BillingSummaryPage.tableBillingGeneralInformation.getRow(1).getCell(TableConstants.BillingGeneralInformationGB.CURRENT_DUE.getName()).getValue();
    }

    public static String getInvoiceRemainingDue(String invoiceNum) {
        return tableBillsAndStatements.getRow(ImmutableMap.of(TableConstants.BillingBillsAndStatementsGB.INVOICE.getName(), invoiceNum))
                .getCell(TableConstants.BillingBillsAndStatementsGB.REMAINING_DUE.getName()).getValue();
    }

    public static void waitBillsStatementsInvoiceExpanded(String invoiceNum) {
        RetryService.run(predicate -> new StaticElement(ByT.xpath(labelInvoicePattern).format(invoiceNum)).isPresent(),
                StopStrategies.stopAfterAttempt(10), WaitStrategies.fixedWait(5, TimeUnit.SECONDS));
    }

    public static void waitBillsStatementsInvoiceCollapsed(String invoiceNum) {
        RetryService.run(predicate -> !new StaticElement(ByT.xpath(labelInvoicePattern).format(invoiceNum)).isPresent(),
                StopStrategies.stopAfterAttempt(10), WaitStrategies.fixedWait(5, TimeUnit.SECONDS));
    }

    public static boolean isBillsStatementsInvoiceExpanded(String invoiceNum) {
        return new StaticElement(ByT.xpath(labelInvoicePattern).format(invoiceNum)).isPresent();
    }

    public static int getInvoiceDueDay(int lastDay) {
        BillingSummaryPage.tableBillingGeneralInformation.getRow(1).getCell(TableConstants.BillingGeneralInformationGB.INVOICING_CALENDAR.getName()).controls.links.getFirst().click();
        int invoiceDueDate = Integer.parseInt(elementInvoicingCalendarInvoiceDueDate.getValue());
        Page.dialogConfirmation.buttonClose.click();
        if (lastDay == 30 && invoiceDueDate == 31){
            invoiceDueDate = 30;
        }
        if (lastDay == 28 && invoiceDueDate > 28){
            invoiceDueDate = 28;
        }
        return invoiceDueDate;
    }

}