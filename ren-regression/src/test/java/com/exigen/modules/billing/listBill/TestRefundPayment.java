package com.exigen.modules.billing.listBill;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.BillingConstants;
import com.exigen.ren.main.enums.MyWorkConstants;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.billing.account.BillingAccountContext;
import com.exigen.ren.main.modules.mywork.MyWorkContext;
import com.exigen.ren.main.modules.mywork.tabs.CreateTaskActionTab;
import com.exigen.ren.main.pages.summary.MyWorkSummaryPage;
import com.exigen.ren.main.pages.summary.billing.BillingAccountsListPage;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import com.google.common.collect.ImmutableMap;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.exigen.istf.verification.CustomSoftAssertions.assertSoftly;
import static com.exigen.ren.common.enums.ActivitiesAndUserNotesConstants.ActivitiesAndUserNotesTable.DESCRIPTION;
import static com.exigen.ren.common.enums.ActivitiesAndUserNotesConstants.ActivitiesAndUserNotesTable.STATUS;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ActionConstants.BillingAction.REFUND;
import static com.exigen.ren.main.enums.BamConstants.*;
import static com.exigen.ren.main.enums.BillingConstants.PaymentsAndAdjustmentsStatusGB.*;
import static com.exigen.ren.main.enums.BillingConstants.PaymentsAndAdjustmentsSubtypeGB.MANUAL_REFUND;
import static com.exigen.ren.main.enums.MyWorkConstants.MyWorkTaskName.REFUND_APPROVAL;

public class TestRefundPayment extends GroupBenefitsBillingBaseTest implements BillingAccountContext, MyWorkContext {
    private static String taskRefundID;
    private static String taskRefundApprovalID;

    @Test(priority = 21)
    public void testRefundPayment() throws IOException {
        logger = extent.startTest(groupNo+" Test Refund Payment ");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        for(Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()) {
            search(BillingAccountAndProduct.getValue());
            Currency suspenseAmount =  new Currency(2202);
            reportLog("Adding Suspense Amount to perform refund", 1);
            billingAccount.acceptPayment().perform(billingAccount.getDefaultTestData("SuspendePayment", "TestData_Check_Suspense"), suspenseAmount.toString());
            assertSoftly(softly -> {
                LOGGER.info("Performing refund  for $100");
                reportLog("Performing refund for $100", 1);
                Currency refundAmount = new Currency(100);
                billingAccount.refund().perform(billingAccount.getDefaultTestData(REFUND, "TestData_Check"), refundAmount.toString());
                softly.assertThat(BillingSummaryPage.tablePaymentsAndAdjustmentsGB).with(TableConstants.BillingPaymentsAndAdjustmentsGB.TYPE, REFUND)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.STATUS, APPROVED).isPresent();
                softly.assertThat(BillingSummaryPage.tablePaymentsOtherTransactions)
                        .with(TableConstants.BillingPaymentsAndTransactionsGB.TYPE, BillingConstants.PaymentsAndOtherTransactionTypeGB.REFUND_APPROVED)
                        .with(TableConstants.BillingPaymentsAndTransactionsGB.AMOUNT, refundAmount.toString()).hasMatchingRows(1);
                BillingAccountsListPage.verifyBamActivities(String.format(REFUND_INITIATED, refundAmount.toString()), FINISHED);
                BillingAccountsListPage.verifyBamActivities(String.format(REFUND_APPROVED_AUTOMATICALLY, refundAmount.toString()), FINISHED);
                CreateTaskActionTab.buttonTasks.click();
                String taskID = MyWorkSummaryPage.tableTasks.getRow(1).getCell(MyWorkConstants.MyWorkTasksTable.TASK_ID.getName()).getValue();
                search(BillingAccountAndProduct.getValue());
                softly.assertThat(BillingSummaryPage.activitiesAndUserNotes.getRows().stream().filter(row -> row.getCell(DESCRIPTION).getValue()
                        .equals(String.format(REFUND_CREATED_TASK, taskID))).findFirst().orElseThrow(() -> new IstfException("Message in BAM not found")).getCell(STATUS)).hasValue(FINISHED);

                LOGGER.info("Verify Suspence amount BAM message");
                reportLog("Verify Suspence amount BAM message", 1);
                softly.assertThat(BillingSummaryPage.tableBillingGeneralInformation)
                        .with(TableConstants.BillingGeneralInformationGB.SUSPENSE_AMOUNT, suspenseAmount.subtract(refundAmount))
                        .containsMatchingRow(1);

                LOGGER.info("Issue Refund Payment");
                reportLog("Issue Refund Payment", 1);
                BillingSummaryPage.tablePaymentsAndAdjustmentsGB.getRow(1).getCell(TableConstants.BillingPaymentsAndAdjustmentsGB.ACTION.getName())
                        .controls.links.get(ActionConstants.BillingPendingTransactionAction.ISSUE).click();
                Page.dialogConfirmation.confirm();

                softly.assertThat(BillingSummaryPage.tablePaymentsAndAdjustmentsGB)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.STATUS, BillingConstants.PaymentsAndAdjustmentsTypeGB.ISSUED).isPresent();
                CreateTaskActionTab.buttonTasks.click();
                taskRefundID = MyWorkSummaryPage.tableTasks.getRow(1).getCell(MyWorkConstants.MyWorkTasksTable.TASK_ID.getName()).getValue();
                search(BillingAccountAndProduct.getValue());

                LOGGER.info("Verify BAM messages for Refund Payment $100");
                reportLog("Verify BAM messages for Refund Payment $100", 1);
                softly.assertThat(BillingSummaryPage.activitiesAndUserNotes.getRows().stream().filter(row -> row.getCell(DESCRIPTION).getValue()
                        .equals(String.format(REFUND_TASK_CREATED, taskRefundID))).findFirst().orElseThrow(() -> new IstfException("Message in BAM not found")).getCell(STATUS)).hasValue(FINISHED);
                softly.assertThat(BillingSummaryPage.activitiesAndUserNotes.getRows().stream().filter(row -> row.getCell(DESCRIPTION).getValue()
                        .equals(String.format(REFUND_TASK_COMPLETE_ISSUE, taskID))).findFirst().orElseThrow(() -> new IstfException("Message in BAM not found")).getCell(STATUS)).hasValue(FINISHED);
                BillingAccountsListPage.verifyBamActivities(String.format(REFUND_ISSUED, refundAmount.toString()), FINISHED);

                LOGGER.info("Performing refund  for $1000");
                reportLog("Performing refund for $1000", 1);
                Currency refundAmount2 = new Currency(1000);
                billingAccount.refund().perform(billingAccount.getDefaultTestData(REFUND, "TestData_Check"), refundAmount2.toString());
                softly.assertThat(BillingSummaryPage.tablePaymentsAndAdjustmentsGB)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.SUBTYPE, MANUAL_REFUND)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.STATUS, PENDING)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.AMOUNT, refundAmount2.toString()).hasMatchingRows(1);

                LOGGER.info("Verify Refund approval task creation for $1000");
                reportLog("Verify Refund approval task creation for $1000", 1);
                CreateTaskActionTab.buttonTasks.click();
                taskRefundApprovalID = MyWorkSummaryPage.tableTasks.getRow(ImmutableMap.of(
                        MyWorkConstants.MyWorkTasksTable.TASK_NAME.getName(), REFUND_APPROVAL,
                        MyWorkConstants.MyWorkTasksTable.QUEUE.getName(), "RefundApprovalLevel1")).getCell(MyWorkConstants.MyWorkTasksTable.TASK_ID.getName()).getValue();
                search(BillingAccountAndProduct.getValue());
                BillingAccountsListPage.verifyBamActivities(String.format(REFUND_INITIATED, refundAmount2.toString()), FINISHED);
                softly.assertThat(BillingSummaryPage.activitiesAndUserNotes.getRows().stream().filter(row -> row.getCell(DESCRIPTION).getValue()
                        .equals(String.format(REFUND_TASK_APPROVAL, taskRefundApprovalID))).findFirst().orElseThrow(() -> new IstfException("Message in BAM not found")).getCell(STATUS)).hasValue(FINISHED);

                LOGGER.info("---=={Step 4}==---");
                CreateTaskActionTab.buttonTasks.click();
                myWork.completeTask().perform(ImmutableMap.of(
                        MyWorkConstants.MyWorkTasksTable.TASK_NAME.getName(), REFUND_APPROVAL, MyWorkConstants.MyWorkTasksTable.QUEUE.getName(),"RefundApprovalLevel1"), TestDataProvider.getDefaultTestDataProvider().get("/modules/billing", "CompleteTaskAction").getTestData("TestData_Reject"));
                search(BillingAccountAndProduct.getValue());

                LOGGER.info("Disapprove refund payment for $1000");
                reportLog("Disapprove refund payment for $1000", 1);
                softly.assertThat(BillingSummaryPage.tablePaymentsAndAdjustmentsGB)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.SUBTYPE, MANUAL_REFUND)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.STATUS, DISAPPROVED)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.AMOUNT, refundAmount2.toString()).hasMatchingRows(1);

                BillingAccountsListPage.verifyBamActivities(String.format(REFUND_DISAPPROVED, refundAmount2.toString()), FINISHED);
                softly.assertThat(BillingSummaryPage.activitiesAndUserNotes.getRows().stream().filter(row -> row.getCell(DESCRIPTION).getValue()
                        .equals(String.format(REFUND_TASK_COMPLETE_APPROVAL, taskRefundApprovalID))).findFirst().orElseThrow(() -> new IstfException("Message in BAM not found")).getCell(STATUS)).hasValue(FINISHED);
            });
            break;
        }
    }
}
