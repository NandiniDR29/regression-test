/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.general.scheduler.pages;

import com.exigen.ipb.eisa.base.application.Application;
import com.exigen.ipb.eisa.base.application.ApplicationFactory;
import com.exigen.ipb.eisa.controls.ActivitiesAndUserNotes;
import com.exigen.ipb.eisa.utils.batchjob.Job;
import com.exigen.ipb.eisa.utils.batchjob.JobGroup;
import com.exigen.istf.config.PropertyProvider;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.table.NamedTable;
import com.exigen.ren.BaseJobListener;
import com.exigen.ren.UIJobActions;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.AdminConstants;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.exigen.ren.admin.modules.general.scheduler.JobContext.createJobTab;
import static com.exigen.ren.admin.modules.general.scheduler.metadata.CreateJobMetaData.JOB_PARAMETERS;
import static com.exigen.ren.main.enums.AdminConstants.AdminJobTable.JOB;

public class GeneralSchedulerPage extends AdminPage {
    private static final int MAX_JOB_RUN_RETRIES = 500;
    private static final long JOB_CREATION_WAIT_TIME = TimeUnit.MINUTES.toMillis(5);
    private static final int MAX_JOB_RUN_TIMEOUT = Integer.parseInt(PropertyProvider.getProperty("test.batchjob.timeout", "1200000"));
    private static final int JOB_RUN_RETRIES_SLEEP = 5;
    private static final String TABLE_SCHEDULED_JOBS_LOCATOR = "//table[contains(@class, 'scheduler-table')]";

    public static final NamedTable<AdminConstants.AdminJobTable> tableScheduledJobs = new NamedTable<>("Scheduled jobs", By.xpath(TABLE_SCHEDULED_JOBS_LOCATOR));
    public static final ActivitiesAndUserNotes activitiesAndUserNotes = new ActivitiesAndUserNotes();
    public static final Button buttonAddJob = new Button(By.id("jobs:new"));
    public static final Button buttonViewFullLog = new Button(By.id("job-logs:log-file"));
    public static final Link linkLoadMoreActivities = new Link(By.id("activityCommandsForm:loadMoreActivities"));

    public static final JobGroup AUTOMATED_PROCESSING_INITIATION_JOB = JobGroup.fromSingleJob("automatedProcessingInitiationJob");
    public static final JobGroup AUTOMATED_PROCESSING_ISSUING_OR_PROPOSING_JOB = JobGroup.fromSingleJob("automatedProcessingIssuingOrProposingJob");
    public static final JobGroup AUTOMATED_PROCESSING_RATING_JOB = JobGroup.fromSingleJob("automatedProcessingRatingJob");
    public static final JobGroup BENEFITS_BILLING_INVOICE_JOB = JobGroup.fromSingleJob("benefits.billingInvoiceJob");
    public static final JobGroup BILLING_INVOICE_GENERATION_JOB = JobGroup.fromSingleJob("billingInvoiceGenerationJob");
    public static final JobGroup BILLING_BENEFITS_UNEARNED_AMORTIZATION_JOB = JobGroup.fromSingleJob("billingBenefitsUnearnedPremiumAmortizationJob");
    public static final JobGroup BILLING_BENEFITS_PREMIUM_EARNED_NOT_BILLED_JOB = JobGroup.fromSingleJob("billingBenefitsPremiumEarnedNotBilledJob");
    public static final JobGroup BILLING_CONSOLIDATED_STATEMENT_GENERATION_JOB = JobGroup.fromSingleJob("benefits.billingConsolidatedStatementGenerationJob");
    public static final JobGroup CANCELLATION_CONFIRMATION_GENERATION_JOB = JobGroup.fromSingleJob("cancellationConfirmationGenerationJob");
    public static final JobGroup CANCELLATION_NOTICE_GENERATION_JOB = JobGroup.fromSingleJob("cancellationNoticeGenerationJob");
    public static final JobGroup CASCADING_TRANSACTION_CERTIFICATE_PROCESSING_DISPATCHING_JOB = JobGroup.fromSingleJob("cascadingTransactionCertificateProcessingDispatchingJob");
    public static final JobGroup CASCADING_TRANSACTION_COMPLETION_DETECTION_JOB = JobGroup.fromSingleJob("cascadingTransactionCompletionDetectionJob");
    public static final JobGroup CASCADING_TRANSACTION_PROCESSING_INITIATION_JOB = JobGroup.fromSingleJob("cascadingTransactionProcessingInitiationJob");
    public static final JobGroup EARNED_PREMIUM_WRITEOFF_PROCESSING_JOB = JobGroup.fromSingleJob("earnedPremiumWriteoffProcessingJob");
    public static final JobGroup POLICY_AUTOMATED_RENEWAL_ASYNC_TASK_GENERATION_JOB = JobGroup.fromSingleJob("policyAutomatedRenewalAsyncTaskGenerationJob");
    public static final JobGroup POLICY_BOR_TRANSFER_JOB = JobGroup.fromSingleJob("policyBORTransferJob");
    public static final JobGroup POLICY_STATUS_UPDATE_JOB = JobGroup.fromSingleJob("policyStatusUpdateJob");
    public static final JobGroup REFUND_GENERATION_JOB = JobGroup.fromSingleJob("refundGenerationJob");
    public static final JobGroup RENEWAL_PROPOSING_JOB = JobGroup.fromSingleJob("renewalProposingJob");
    public static final JobGroup RENEWAL_RATING_JOB = JobGroup.fromSingleJob("renewalRatingJob");
    public static final JobGroup PENDING_UPDATE_JOB = JobGroup.fromSingleJob("pendingUpdateJob");
    public static final JobGroup RECURRING_PAYMENTS_PROCESSING_JOB = JobGroup.fromSingleJob("recurringPaymentsProcessingJob");
    public static final JobGroup RECURRING_PAYMENT_NOTICES_PROCESSING_JOB = JobGroup.fromSingleJob("recurringPaymentNoticesProcessingJob");
    public static final JobGroup ACTIVITY_SUMMARIZATION_JOB = JobGroup.fromSingleJob("activitySummarizationJob");
    public static final JobGroup ACTIVITY_HISTORY_JOB = JobGroup.fromSingleJob("activityHistoryJob");
    public static final JobGroup QUOTE_EXPIRATION_JOB = JobGroup.fromSingleJob("quoteExpirationJob");
    public static final JobGroup VSP_ELIGIBILITY_JOB = JobGroup.fromSingleJob("vspEligibilityJob");
    public static final JobGroup VSP_CLAIMS_UPLOAD_JOB = JobGroup.fromSingleJob("vspClaimsUploadJob");
    public static final JobGroup CLAIMS_PAYMENT_REVERSAL_JOB = JobGroup.fromSingleJob("ClaimsPaymentReversalJob");
    public static final JobGroup CLAIMS_ORTHO_PROCESSING_JOB = JobGroup.fromSingleJob("claimsOrthoProcessingJob");
    public static final JobGroup LEDGER_TRANSFER_JOB = JobGroup.fromSingleJob("ledgerTransferJob");
    public static final JobGroup CLAIM_FRUAD_RED_FLAG_JOB = JobGroup.fromSingleJob("claimsFraudRedFlagJob");
    public static final JobGroup POLICY_YEAR_UPDATE_JOB = JobGroup.fromSingleJob("PolicyYearUpdateJob");
    public static final JobGroup ID_CARD_GENERATE_JOB = JobGroup.fromSingleJob("idCardGenerateJob");
    public static final JobGroup LOCKBOX_BILLING_PAYMENT_PROCESS_JOB = JobGroup.fromSingleJob("lockboxBillingPaymentProcessJob");
    public static final JobGroup REN_GROUP_ENROLLMENT_PROCESSING_JOB = JobGroup.fromSingleJob("renGroupEnrollmentProcessingJob");
    public static final JobGroup STALE_DATE_LETTER_GENERATION_JOB = JobGroup.fromSingleJob("staledateLetterGenerationJob");
    public static final JobGroup TPA_PAYMENT_PROCESSING = JobGroup.fromSingleJob("tpapaymentprocessing");
    public static final JobGroup BENEFITS_COMMISSION_ASYNC_DISBURSEMENT_JOB = JobGroup.fromSingleJob("benefitsCommissionAsyncDisbursementJob");
    public static final JobGroup BENEFITS_COMMISSION_ASYNC_DISBURSEMENT_JOB_WITH_DAILY_PARAMETER = new JobGroup("benefitsCommissionAsyncDisbursementJob_DailyParameter", new Job("benefitsCommissionAsyncDisbursementJob").setJobParameters(ImmutableMap.of("JOB_UI_PARAMS", "-t daily")));
    public static final JobGroup BLT_COMMISSION_PAYMENT_JOB = JobGroup.fromSingleJob("bltCommissionPaymentJob");
    public static final JobGroup DOC_GEN_APP_LETTER_JOB = JobGroup.fromSingleJob("docGenAppLetterJob");
    public static final JobGroup OVERPAYMENT_PRENOTIFICATION_LETTER_GENERATION_JOB = JobGroup.fromSingleJob("overpaymentPrenotificationLetterGenerationJob");
    public static final JobGroup OVERPAYMENT_POSTNOTIFICATION_LETTER_GENERATION_JOB = JobGroup.fromSingleJob("overpaymentPostnotificationLetterGenerationJob");
    public static final JobGroup OUTBOUND_DENTAL_ELIGIBILITY_JOB = JobGroup.fromSingleJob("outboundDentalEligibilityJob");
    public static final JobGroup INVOICE_UPLOAD_JOB = JobGroup.fromSingleJob("invoiceUploadJob");
    public static final JobGroup EDI_834_RETRIEVAL_JOB = JobGroup.fromSingleJob("EDI834RetrievalJob");
    public static final JobGroup ANNIVERSARY_AGING_PROCESSING_JOB = JobGroup.fromSingleJob("renAnniversaryAgingProcessingJob");
    public static final JobGroup FEE_SCHEDULE_UPLOAD_JOB = JobGroup.fromSingleJob("feeScheduleUploadJob");
    public static final JobGroup FEE_SCHEDULE_PROCESSED_JOB = JobGroup.fromSingleJob("feeScheduleProcessedJob");
    public static final JobGroup ATTAINED_AGING_PROCESSING_JOB = JobGroup.fromSingleJob("attainedAgingProcessingJob");
    public static final JobGroup CHANGE_CANCELLATION_PENDING_POLICIES_STATUS_JOB = JobGroup.fromSingleJob("changeCancellationPendingPoliciesStatusJob");
    public static final JobGroup CLAIM_REINSURANCE_REPORT_TL_PROCESSING_JOB = JobGroup.fromSingleJob("claimReinsuranceReportTLProcessingJob");
    public static final JobGroup CHECK_BOA_RECONCILIATION_FILE_JOB = JobGroup.fromSingleJob("checkBOAReconciliationFileJob");
    public static final JobGroup BLT_BILLING_REFUND_PAYMENT_TRANSFER_JOB = JobGroup.fromSingleJob("bltBillingRefundPaymentTransferjob");
    public static final JobGroup CLAIM_REINSURANCE_REPORT_LTD_PROCESSING_JOB = JobGroup.fromSingleJob("claimReinsuranceReportLTDProcessingJob");
    public static final JobGroup REINSURANCE_REPORT_LTD_PROCESSING_JOB = JobGroup.fromSingleJob("reinsuranceReportLTDProcessingJob");
    public static final JobGroup TRANSFER_DENTAL_CLAIMS_PAYMENTS_JOB = JobGroup.fromSingleJob("transferDentalClaimsPaymentsJob");
    public static final JobGroup BENEFITS_RECURRING_PAYMENTS_PROCESSING_JOB = JobGroup.fromSingleJob("benefits.billingRecurringPaymentsProcessingJob");
    public static final JobGroup PENDED_DENTAL_CLAIM_READJUDICATION_JOB = JobGroup.fromSingleJob("pendedDentalClaimReadjudicationJob");
    public static final JobGroup BLT_TRANSFER_NON_DENTAL_CLAIMS_PAYMENT_JOB  = JobGroup.fromSingleJob("bltTransferNonDentalClaimsPaymentJob");
    public static final JobGroup FICA_REPORT_CLAIM_GENERATION_JOB = JobGroup.fromSingleJob("FICAReportClaimGenerationJob");



    public static void runJob(JobGroup jobGroup) {
        GeneralSchedulerPage.open();
        LOGGER.info("[JOBS] Job " + jobGroup.getGroupName() + " will be executed");

        long startTime = System.currentTimeMillis();
        int counterBefore = getJobCounter(jobGroup);

        executeJob(jobGroup);
        NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.DB_LOOKUPS);
        NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.SCHEDULER);

        for (int i = 0; i <= MAX_JOB_RUN_RETRIES; i++) {
            verifyJobInformationPresence(jobGroup);
            waitForJob();

            int counterAfter = getJobCounter(jobGroup);
            String currentJobState = getJobStatus(jobGroup);
            if (currentJobState.equals("Idle")) {
                if (counterAfter > counterBefore) {
                    if (getJobResult(jobGroup).equals("Passed")) {
                        LOGGER.info(String.format("[JOBS] Job %s running time: %s seconds", jobGroup, (System.currentTimeMillis() - startTime) / 1000));
                        return;
                    }
                    throw new IstfException(String.format("[JOBS] Job %s was completed with result %s after rerun. Job running time: %s seconds",
                            jobGroup.getGroupName(), getJobResult(jobGroup), (System.currentTimeMillis() - startTime) / 1000));
                } else {
                    LOGGER.info("[JOBS] Job {} state is Idle but count hasn't been changed. Seems job is not started", jobGroup);
                    BaseJobListener.restartAsyncManager(true);
                    GeneralSchedulerPage.open();
                    executeJob(jobGroup);
                }
            }

            if ((System.currentTimeMillis() - startTime) > MAX_JOB_RUN_TIMEOUT) {
                stopJob(jobGroup);
                throw new IstfException(String.format("[JOBS] Job %s was timed out. Job running time is more than %s seconds",
                        jobGroup.getGroupName(), MAX_JOB_RUN_TIMEOUT / 1000));
            }
            LOGGER.info("Job {} has state {} after waiting {} s", jobGroup.getGroupName(), currentJobState, String.valueOf((System.currentTimeMillis() - startTime) / 1000));
            reopenGeneralScheduler();
        }

        throw new IstfException(String.format("[JOBS] Job %s was not completed. Job running time: %s seconds",
                jobGroup.getGroupName(), (System.currentTimeMillis() - startTime) / 1000));
    }

    public static void setJobParameter(String parameter, JobGroup jobGroup) {
        UIJobActions uiJobActions = new UIJobActions();
        if (!uiJobActions.isJobExist(jobGroup)) {
            uiJobActions.createJob(jobGroup);
        }
        tableScheduledJobs.getRow(JOB.getName(), jobGroup.getGroupName()).getCell(JOB.getName()).controls.links.getFirst().click();
        createJobTab.getAssetList().getAsset(JOB_PARAMETERS).setValue(parameter);
        Tab.buttonSave.click();
    }

    public static boolean isJobExist(JobGroup jobGroup) {
        NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.SCHEDULER);
        return new JobControls(jobGroup).isPresent();
    }

    public static String getJobStatus(JobGroup jobName) {
        return new JobControls(jobName).getStatus();
    }

    public static int getJobCounter(JobGroup jobName) {
        return new JobControls(jobName).getCounter();
    }

    public static String getJobResult(JobGroup jobName) {
        return new JobControls(jobName).getResult();
    }

    private static void executeJob(JobGroup jobName) {
        new JobControls(jobName).execute();
    }

    private static void stopJob(JobGroup jobName) {
        new JobControls(jobName).stop();
        Page.dialogConfirmation.confirm();
    }

    public static void eliminateJob(JobGroup jobName) {
        new JobControls(jobName).eliminate();
        Page.dialogConfirmation.confirm();
    }

    public static void waitForJob() {
        Application.wait(JOB_RUN_RETRIES_SLEEP * 1000);
        try {
            NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.SCHEDULER);
        } catch (Exception e) {
            LOGGER.error("Cannot click Scheduler link: " + e.getMessage() + ". Retrying ...", e);
        }
    }

    public static void verifyScheduledJobsPresence() {
        if (!tableScheduledJobs.isPresent()) {
            LOGGER.error("Scheduled Jobs table is not visible. Retrying...");
            reopenGeneralScheduler();
        }
    }

    public static void verifyJobInformationPresence(JobGroup jobName) {
        if (!new JobControls(jobName).isPresent()) {
            LOGGER.error("General Scheduler table is not visible. Retrying...");
            reopenGeneralScheduler();
        }
    }

    public static void waitForJobIsCreated(JobGroup jobGroup) {
        NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.SCHEDULER);
        long startTime = System.currentTimeMillis();
        while (!isJobExist(jobGroup) && System.currentTimeMillis() - startTime < JOB_CREATION_WAIT_TIME) {
            NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.DB_LOOKUPS);
            NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.SCHEDULER);
        }
    }

    public static void reopenGeneralScheduler() {
        ApplicationFactory.getInstance().getAdminApplication().reopen();
        Application.wait(1000);
        NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.SCHEDULER);
    }

    public static void open() {
        NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.SCHEDULER);
    }


    private static class JobControls {
        private final String BASE_LOCATOR;
        private static final String STATISTICS = "/td[2]";
        private static final String STATUS = "/td[1]/div[1]/span";
        private static final String JOB_ACTIONS = "//a[contains(@id, '%s')]";

        public JobControls(JobGroup jobGroup) {
            BASE_LOCATOR = TABLE_SCHEDULED_JOBS_LOCATOR + String.format("/tbody/tr[.//a[@title='%s']]", jobGroup.getGroupName());
        }

        public boolean isPresent() {
            return new StaticElement(By.xpath(BASE_LOCATOR)).isPresent();
        }

        public String getStatus() {
            StaticElement status = new StaticElement(By.xpath(BASE_LOCATOR + STATUS));
            return status.isPresent() ? status.getValue() : "Idle";
        }

        public int getCounter() {
            Pattern p = Pattern.compile("(?s)(\\d+)(?=\\s*(Passed|Interrupted|Failed))");
            Matcher m = p.matcher(new StaticElement(By.xpath(BASE_LOCATOR + STATISTICS)).getValue());

            int count = 0;
            while (m.find()) {
                count += Integer.parseInt(m.group(1));
            }
            return count;
        }

        public String getResult() {
            StaticElement jobResult = new StaticElement(By.xpath(BASE_LOCATOR + STATISTICS + "/div[3]/span"));
            return jobResult.isPresent() ? jobResult.getValue().replaceFirst("\\W*(\\w+).*", "$1") : "N/A";
        }

        public void execute() {
            new Link(By.xpath(BASE_LOCATOR + String.format(JOB_ACTIONS, "start-job"))).click();
        }

        public void stop() {
            new Link(By.xpath(BASE_LOCATOR + String.format(JOB_ACTIONS, "stop-job"))).click();
        }

        public void eliminate() {
            new Link(By.xpath(BASE_LOCATOR + String.format(JOB_ACTIONS, "eliminate"))).click();
        }
    }
}
