/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.mywork.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.mywork.tabs.CompleteTaskActionTab;
import com.exigen.ren.main.pages.summary.MyWorkSummaryPage;
import com.google.common.collect.ImmutableMap;

public class CompleteTaskAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(CompleteTaskActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Complete Task";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        throw new UnsupportedOperationException("start() method without parameters is not supported for this action. Use start(int rowNumber) instead.");
    }

    public Action start(int rowNumber) {
        MyWorkSummaryPage.selectTask(rowNumber);
        MyWorkSummaryPage.buttonComplete.click();
        return this;
    }

    public Action start(ImmutableMap<String, String> query) {
        MyWorkSummaryPage.selectTask(query);
        MyWorkSummaryPage.buttonComplete.click();
        return this;
    }
    @Override
    public Action submit() {
        CompleteTaskActionTab.buttonComplete.click();
        return this;
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method without rowNumber is not supported for this action. Use perform(int rowNumber, TestData td) instead.");
    }

    public Action perform(int rowNumber, TestData td) {
        start(rowNumber);
        getWorkspace().fill(td);
        return submit();
    }

    public Action perform(ImmutableMap<String, String> query, TestData td) {
        start(query);
        getWorkspace().fill(td);
        return submit();
    }
}
