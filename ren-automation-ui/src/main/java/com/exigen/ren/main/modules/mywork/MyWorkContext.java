/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.mywork;

import com.exigen.istf.utils.datetime.DateTimeUtils;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.helpers.DateTimeUtilsHelper;
import com.exigen.ren.main.modules.mywork.tabs.CompleteTaskActionTab;
import com.exigen.ren.main.modules.mywork.tabs.MyWorkTab;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public interface MyWorkContext {
    MyWork myWork = AutomationContext.getService(MyWork.class);
    MyWorkTab myWorkTab = myWork.getDefaultWorkspace().getTab(MyWorkTab.class);
    CompleteTaskActionTab completeTaskActionTab = myWork.completeTask().getWorkspace().getTab(CompleteTaskActionTab.class);

    default LocalDateTime calculateDueDateTime(LocalDateTime warningDateTime, int businessDays) {
        LocalDateTime dueDateTime;
        //Today is counted as first day unless working hours are over
        if (warningDateTime.getDayOfWeek().getValue() < 6 && warningDateTime.getHour() >= 19) {
            warningDateTime = warningDateTime.plusDays(1);
        } else if (warningDateTime.getDayOfWeek().equals(DayOfWeek.SATURDAY) && warningDateTime.getHour() >= 17) {
            warningDateTime = warningDateTime.plusDays(1);
        }

        dueDateTime = warningDateTime.with(DateTimeUtils.closestFutureWorkingDay(DateTimeUtilsHelper.isWorkingDayForAgency));

        dueDateTime = dueDateTime.with(DateTimeUtils.plusWorkingDays(businessDays-1, DateTimeUtilsHelper.isWorkingDayForAgency));

        if (dueDateTime.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            dueDateTime = dueDateTime.withHour(17).withMinute(0).withSecond(0);
        } else {
            dueDateTime = dueDateTime.withHour(19).withMinute(0).withSecond(0);
        }
        return dueDateTime;
    }
}
