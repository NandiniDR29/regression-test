/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/ /* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.actions;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.customer.tabs.RelationshipTab;
import org.openqa.selenium.By;

public class AssociateDivisionsAction implements Action {

    @Override
    public String getName() {
        return "Update";
    }

    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(DeleteCustomerAction.class).getWorkspace();
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) method with testData is not supported for this action. Use perform(boolean) instead.");
    }

    public Action perform(boolean value) {
        start();
        new CheckBox(By.id("crmForm:generalInfoLeft_associateDivisions")).setValue(value);

        if (Page.dialogConfirmation.isPresent()) {
            Page.dialogConfirmation.confirm();
        }
        return submit();
    }

    @Override
    public Action submit() {
        RelationshipTab.buttonSaveAndExit.click();
        return this;
    }
}
