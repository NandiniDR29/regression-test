/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.billing.account.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.billing.account.metadata.MovePoliciesActionTabMetaData;
import com.exigen.ren.main.modules.billing.account.tabs.MovePoliciesActionTab;

import java.util.List;

public class MovePoliciesAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(MovePoliciesActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Move Policies";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        MovePoliciesActionTab.buttonFinish.click();
        return this;
    }

    public Action perform(TestData td, List<String> policies) {
        start();
        getWorkspace().fill(td.adjust(TestData.makeKeyPath(MovePoliciesActionTab.class.getSimpleName(),
                MovePoliciesActionTabMetaData.POLICIES.getLabel()), policies));
        return submit();
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method with testData is not supported for this action. Use perform(TestData td, List<String> policies) instead.");
    }

}
