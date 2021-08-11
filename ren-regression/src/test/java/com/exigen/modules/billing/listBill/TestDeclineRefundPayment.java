package com.exigen.modules.billing.listBill;

import com.exigen.basetest.Util;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.modules.billing.GroupBenefitsBillingBaseTest;
import com.exigen.modules.billing.account.BillingAccountContext;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.MyWorkConstants;
import com.exigen.ren.main.enums.TableConstants;
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
import static com.exigen.ren.main.enums.MyWorkConstants.MyWorkTaskName.REFUND_ISSUE;

public class TestDeclineRefundPayment extends GroupBenefitsBillingBaseTest implements BillingAccountContext, MyWorkContext {
    private static String taskRefundApprovalID2;
    private static String taskRefundApprovalID3;
    private static String taskRefundApprovalID4;

    @Test(priority = 22)
    public void testDeclineRefundPayment() throws IOException {
        logger = extent.startTest(groupNo+" Test Decline Refund Payment ");
        prop.load(fileInput);
        reportLog("Application started...", 0);
        for(Map.Entry<String, String> BillingAccountAndProduct : CommonGenericMethods.getBillingAccount(groupNo).entrySet()){
            search(BillingAccountAndProduct.getValue());
            Currency suspenseAmount =  new Currency(2000);
            reportLog("Adding Suspence Amount to perform refund", 1);
            billingAccount.acceptPayment().perform(billingAccount.getDefaultTestData("SuspendePayment", "TestData_Check_Suspense"), suspenseAmount.toString());
            assertSoftly(softly -> {
                LOGGER.info("Performing refund");
                reportLog("Performing refund", 1);
                Currency refundAmount3 = new Currency(1000);
                billingAccount.refund().perform(billingAccount.getDefaultTestData(REFUND, "TestData_Check"), refundAmount3.toString());
                softly.assertThat(BillingSummaryPage.tablePaymentsAndAdjustmentsGB)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.SUBTYPE, MANUAL_REFUND)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.STATUS, PENDING)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.AMOUNT, refundAmount3.toString()).hasMatchingRows(1);

                LOGGER.info("Performing Refund Approval");
                reportLog("Performing Refund Approval", 1);
                CreateTaskActionTab.buttonTasks.click();
                taskRefundApprovalID2 = MyWorkSummaryPage.tableTasks.getRow(ImmutableMap.of(
                        MyWorkConstants.MyWorkTasksTable.TASK_NAME.getName(), REFUND_APPROVAL,
                        MyWorkConstants.MyWorkTasksTable.QUEUE.getName(), "RefundApprovalLevel1")).getCell(MyWorkConstants.MyWorkTasksTable.TASK_ID.getName()).getValue();
                search(BillingAccountAndProduct.getValue());
                BillingAccountsListPage.verifyBamActivities(String.format(REFUND_INITIATED, refundAmount3.toString()), FINISHED);
                softly.assertThat(BillingSummaryPage.activitiesAndUserNotes.getRows().stream().filter(row -> row.getCell(DESCRIPTION).getValue()
                        .equals(String.format(REFUND_TASK_APPROVAL, taskRefundApprovalID2))).findFirst().orElseThrow(() -> new IstfException("Message in BAM not found")).getCell(STATUS)).hasValue(FINISHED);

                LOGGER.info("Completed Refund Approval task for Refund amount $1000");
                reportLog("Completed Refund Approval task for Refund amount $1000", 1);
                CreateTaskActionTab.buttonTasks.click();
                myWork.completeTask().perform(ImmutableMap.of(
                        MyWorkConstants.MyWorkTasksTable.TASK_NAME.getName(), REFUND_APPROVAL, MyWorkConstants.MyWorkTasksTable.QUEUE.getName(),"RefundApprovalLevel1"),
                        TestDataProvider.getDefaultTestDataProvider().get("/modules/billing", "CompleteTaskAction").getTestData("TestData_Approve"));

                taskRefundApprovalID3 = MyWorkSummaryPage.tableTasks.getRow(ImmutableMap.of(
                        MyWorkConstants.MyWorkTasksTable.TASK_NAME.getName(), REFUND_ISSUE)).getCell(MyWorkConstants.MyWorkTasksTable.TASK_ID.getName()).getValue();
                search(BillingAccountAndProduct.getValue());

                softly.assertThat(BillingSummaryPage.tablePaymentsAndAdjustmentsGB)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.SUBTYPE, MANUAL_REFUND)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.STATUS, APPROVED)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.AMOUNT, refundAmount3.toString()).hasMatchingRows(1);

                LOGGER.info("Issue Refund");
                reportLog("Issue Refund", 1);
                BillingSummaryPage.tablePaymentsAndAdjustmentsGB.getRow(TableConstants.BillingPaymentsAndAdjustmentsGB.AMOUNT.getName(), refundAmount3.toString())
                        .getCell(TableConstants.BillingPaymentsAndAdjustmentsGB.ACTION.getName())
                        .controls.links.get(ActionConstants.BillingPendingTransactionAction.ISSUE).click();
                Page.dialogConfirmation.confirm();

                CreateTaskActionTab.buttonTasks.click();
                taskRefundApprovalID4 = MyWorkSummaryPage.tableTasks.getRow(2).getCell(MyWorkConstants.MyWorkTasksTable.TASK_ID.getName()).getValue();
                search(BillingAccountAndProduct.getValue());

                softly.assertThat(BillingSummaryPage.tablePaymentsAndAdjustmentsGB)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.SUBTYPE, MANUAL_REFUND)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.STATUS, ISSUED)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.AMOUNT, refundAmount3.toString()).hasMatchingRows(1);

                LOGGER.info("Decline Refund Payment");
                reportLog("Decline Refund Payment", 1);
                BillingSummaryPage.tablePaymentsAndAdjustmentsGB.getRow(TableConstants.BillingPaymentsAndAdjustmentsGB.AMOUNT.getName(), refundAmount3.toString())
                        .getCell(TableConstants.BillingPaymentsAndAdjustmentsGB.ACTION.getName())
                        .controls.links.get(ActionConstants.BillingPendingTransactionAction.DECLINE).click();
                Page.dialogConfirmation.confirm();

                softly.assertThat(BillingSummaryPage.tablePaymentsAndAdjustmentsGB)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.SUBTYPE, MANUAL_REFUND)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.STATUS, DECLINED)
                        .with(TableConstants.BillingPaymentsAndAdjustmentsGB.AMOUNT, refundAmount3.toString()).hasMatchingRows(1);

                LOGGER.info("Verify BAM message for Created task");
                reportLog("Verify BAM message for Created task", 1);
                BillingAccountsListPage.verifyBamActivities(String.format(REFUND_APPROVED, refundAmount3.toString()), FINISHED);
                BillingAccountsListPage.verifyBamActivities(String.format(REFUND_ISSUED, refundAmount3.toString()), FINISHED);

            });
            break;
        }
    }
}
