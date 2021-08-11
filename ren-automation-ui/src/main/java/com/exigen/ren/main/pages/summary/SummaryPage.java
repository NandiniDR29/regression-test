/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.pages.summary;

import com.exigen.ipb.eisa.controls.ActivitiesAndUserNotes;
import com.exigen.ipb.eisa.utils.RetryService;
import com.exigen.ipb.eisa.utils.TimeSetterUtil;
import com.exigen.istf.exceptions.IstfException;
import com.exigen.istf.webdriver.BrowserController;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.admin.modules.general.scheduler.pages.GeneralSchedulerPage;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.pages.summary.billing.BillingSummaryPage;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.exigen.ren.common.enums.ActivitiesAndUserNotesConstants.ActivitiesAndUserNotesTable.DESCRIPTION;
import static com.exigen.ren.main.enums.BillingConstants.BillingSuspensePaymentsTable.STATUS;

public class SummaryPage extends MainPage {


    public static ActivitiesAndUserNotes activitiesAndUserNotes = new ActivitiesAndUserNotes();
    public static Button buttonNotesAlerts = new Button(By.id("addUserNote"));

    public static void openActivitiesAndUserNotes() {
        activitiesAndUserNotes.expand();
    }

    public static void verifyBamActivities(int rowIndex, String value, String statusBamActivities) {
        LOGGER.info("Message: " + value);
        LOGGER.info("Expected Status: " + statusBamActivities);
        Waiters.SLEEP(10000).go();
        if (!BillingSummaryPage.activitiesAndUserNotes.getRow(rowIndex).getCell(DESCRIPTION).getValue().equals(value) &&
                BillingSummaryPage.activitiesAndUserNotes.getRow(rowIndex).getCell(STATUS).getValue().equals(statusBamActivities)) {
            try {
                RetryService.run(predicate ->
                                (BillingSummaryPage.activitiesAndUserNotes.getRow(rowIndex).getCell(DESCRIPTION).getValue().equals(value) &&
                                        BillingSummaryPage.activitiesAndUserNotes.getRow(rowIndex).getCell(STATUS).getValue().equals(statusBamActivities)),
                        () -> {
                            BrowserController.get().driver().navigate().refresh();
                            return null;
                        }, StopStrategies.stopAfterAttempt(30), WaitStrategies.fixedWait(15, TimeUnit.SECONDS));
            } catch (RuntimeException e) {
                throw new IstfException(String.format("BAM message not found: %s", value), e);
            }
            LOGGER.info("Finish verify Bam Activities" + TimeSetterUtil.getInstance().getCurrentTime());
        }
    }

    public static void verifyBamActivities(String value, String statusBamActivities) {
        LOGGER.info("Message: " + value);
        LOGGER.info("Expected Status: " + statusBamActivities);
        if (!BillingSummaryPage.activitiesAndUserNotes.getRow(ImmutableMap.of(
                TableConstants.ActivitiesAndUserNotesTable.DESCRIPTION.getName(), value,
                TableConstants.ActivitiesAndUserNotesTable.STATUS.getName(), statusBamActivities)).isPresent()) {
            try {
                RetryService.run(predicate ->
                                (BillingSummaryPage.activitiesAndUserNotes.getRow(ImmutableMap.of(
                                        TableConstants.ActivitiesAndUserNotesTable.DESCRIPTION.getName(), value,
                                        TableConstants.ActivitiesAndUserNotesTable.STATUS.getName(), statusBamActivities)).isPresent()),
                        () -> {
                            BrowserController.get().driver().navigate().refresh();
                            BillingSummaryPage.activitiesAndUserNotes.expand();
                            if (GeneralSchedulerPage.linkLoadMoreActivities.isPresent()) {
                                GeneralSchedulerPage.linkLoadMoreActivities.click();
                            }
                            return null;
                        }, StopStrategies.stopAfterAttempt(25), WaitStrategies.fixedWait(15, TimeUnit.SECONDS));
            } catch (RuntimeException e) {
                throw new IstfException(String.format("BAM message not found: %s", value), e);
            }
        }
    }

    public static void verifyBamActivities(String billingAccountNumber, String value, String statusBamActivities) {
        LOGGER.info("Message: " + value);
        LOGGER.info("Expected Status: " + statusBamActivities);
        BillingSummaryPage.activitiesAndUserNotes.expand();
        if (!BillingSummaryPage.activitiesAndUserNotes.getRow(ImmutableMap.of(
                TableConstants.ActivitiesAndUserNotesTable.DESCRIPTION.getName(), value,
                TableConstants.ActivitiesAndUserNotesTable.STATUS.getName(), statusBamActivities)).isPresent()) {


            try {
                RetryService.run(predicate ->
                                BillingSummaryPage.activitiesAndUserNotes.getRow(ImmutableMap.of(
                                        TableConstants.ActivitiesAndUserNotesTable.DESCRIPTION.getName(), value,
                                        TableConstants.ActivitiesAndUserNotesTable.STATUS.getName(), statusBamActivities)).isPresent(),
                        () -> {
                            QuickSearch.search(billingAccountNumber);
                            BillingSummaryPage.activitiesAndUserNotes.expand();
                            if (GeneralSchedulerPage.linkLoadMoreActivities.isPresent()) {
                                GeneralSchedulerPage.linkLoadMoreActivities.click();
                            }
                            return null;
                        }, StopStrategies.stopAfterAttempt(25), WaitStrategies.fixedWait(15, TimeUnit.SECONDS));
            } catch (RuntimeException e) {
                throw new IstfException(String.format("BAM message not found: %s", value), e);
            }
        }

    }

    public static void verifyBamActivities(String value, String statusBamActivities, int countOfBAMs) {
        LOGGER.info("Message: " + value);
        LOGGER.info("Expected Status: " + statusBamActivities);
        try {
            RetryService.run(predicate ->
                            (BillingSummaryPage.activitiesAndUserNotes.getRows(ImmutableMap.of(
                                    TableConstants.ActivitiesAndUserNotesTable.DESCRIPTION.getName(), value,
                                    TableConstants.ActivitiesAndUserNotesTable.STATUS.getName(), statusBamActivities)).size() == countOfBAMs),
                    () -> {
                        BrowserController.get().driver().navigate().refresh();
                        BillingSummaryPage.activitiesAndUserNotes.expand();
                        if (GeneralSchedulerPage.linkLoadMoreActivities.isPresent()) {
                            GeneralSchedulerPage.linkLoadMoreActivities.click();
                        }
                        return null;
                    }, StopStrategies.stopAfterAttempt(25), WaitStrategies.fixedWait(15, TimeUnit.SECONDS));
        } catch (RuntimeException e) {
            throw new IstfException(String.format("BAM message not found: %s", value), e);
        }
    }

    public static void verifyBamActivitiesContains(String value, String statusBamActivities) {

        try {
            RetryService.run(predicate ->
                            (BillingSummaryPage.activitiesAndUserNotes.getRowContains(ImmutableMap.of(
                                    TableConstants.ActivitiesAndUserNotesTable.DESCRIPTION.getName(), value,
                                    TableConstants.ActivitiesAndUserNotesTable.STATUS.getName(), statusBamActivities)).isPresent()),
                    () -> {
                        BrowserController.get().driver().navigate().refresh();
                        BillingSummaryPage.activitiesAndUserNotes.expand();
                        if (GeneralSchedulerPage.linkLoadMoreActivities.isPresent()) {
                            GeneralSchedulerPage.linkLoadMoreActivities.click();
                        }
                        return null;
                    }, StopStrategies.stopAfterAttempt(50), WaitStrategies.fixedWait(25, TimeUnit.SECONDS));
        } catch (RuntimeException e) {
            try {
                RetryService.run(predicate ->
                                (BillingSummaryPage.activitiesAndUserNotes.getRowContains(ImmutableMap.of(
                                        TableConstants.ActivitiesAndUserNotesTable.DESCRIPTION.getName(), value,
                                        TableConstants.ActivitiesAndUserNotesTable.STATUS.getName(), "Add Participant Association Employment to Customer")).isPresent()),
                        () -> {
                            BrowserController.get().driver().navigate().refresh();
                            BillingSummaryPage.activitiesAndUserNotes.expand();
                            if (GeneralSchedulerPage.linkLoadMoreActivities.isPresent()) {
                                GeneralSchedulerPage.linkLoadMoreActivities.click();
                            }
                            return null;
                        }, StopStrategies.stopAfterAttempt(50), WaitStrategies.fixedWait(25, TimeUnit.SECONDS));
            }
            catch (RuntimeException excep) {
            throw new IstfException(String.format("BAM message not found: %s", value), excep);

            }
        }
    }

    public static void closeActivitiesAndUserNotes() {
        activitiesAndUserNotes.collapse();
    }

}