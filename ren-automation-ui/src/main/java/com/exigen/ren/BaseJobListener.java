/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren;

import com.exigen.ren.admin.modules.general.asynctasks.pages.GeneralAsyncTasksPage;
import com.exigen.ipb.eisa.base.application.Application;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ipb.eisa.utils.TimeSetterUtil;
import com.exigen.ipb.eisa.utils.batchjob.JobGroup;
import com.exigen.ipb.eisa.utils.batchjob.listener.JobListener;
import com.exigen.istf.webdriver.controls.waiters.Waiters;

import java.time.LocalDateTime;

public abstract class BaseJobListener implements JobListener {
    private static final Object LOCK = new Object();
    private static boolean isAsyncManagerRestarted = false;
    private static LocalDateTime currentPhase;

    private static void setAsyncRestartValue() {
        if (TimeSetterUtil.getInstance().isPEF()) {
            LocalDateTime phaseTime = TimeSetterUtil.getInstance().getPhaseStartTime();
            if (!phaseTime.equals(currentPhase)) {
                isAsyncManagerRestarted = false;
                currentPhase = phaseTime;
            }
        } else {
            isAsyncManagerRestarted = false;
        }
    }

    private static void restartAsyncManager() {
        restartAsyncManager(false);
    }

    public static void restartAsyncManager(boolean forceRestart) {
        synchronized (LOCK) {
            if(forceRestart){
                isAsyncManagerRestarted = false;
            }
            if (!isAsyncManagerRestarted) {
                NavigationPage.toLeftMenuTab(NavigationEnum.GeneralTabLeftMenu.ASYNC_TASKS);
                if (!GeneralAsyncTasksPage.linkStopManager.isPresent()) {
                    GeneralAsyncTasksPage.linkStartManager.click();
                }
                stopManager(30);
                GeneralAsyncTasksPage.linkStartManager.click();
                isAsyncManagerRestarted = true;
                Waiters.SLEEP(5000).go();
            }
        }
    }

    private static void stopManager(int count) {
        int counter = 0;
        while (!GeneralAsyncTasksPage.linkStartManager.isPresent() && counter < count) {
            GeneralAsyncTasksPage.linkStopManager.click();
            Application.wait(10000);
            counter++;
        }
    }

    @Override
    public void afterJobExecution(JobGroup jobGroup) {

    }

    @Override
    public void beforeJobExecution(JobGroup jobGroup) {
        setAsyncRestartValue();
        restartAsyncManager();
    }
}
