/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.customer.tabs.AssociateExistingCustomerSearchActionTab;
import com.exigen.ren.main.modules.customer.tabs.EmployeeInfoTab;
import com.exigen.ren.main.modules.customer.tabs.SelectGroupRelationshipTypeActionTab;

public class AssociateExistingCustomerAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(SelectGroupRelationshipTypeActionTab.class)
            .registerTab(AssociateExistingCustomerSearchActionTab.class)
            .registerTab(EmployeeInfoTab.class)
            .build();

    @Override
    public String getName() {
        return "Associate Existing Customer";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action submit() {
        return this;
    }
}
