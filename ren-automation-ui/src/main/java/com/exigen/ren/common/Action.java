/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.common;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;

public interface Action {
    /**
     * Get action label (for "Select Action" combobox)
     *
     * @return action label
     */
    String getName();

    /**
     * Get workspace associated with this action
     *
     * @return workspace (aka view)
     */
    Workspace getWorkspace();

    /**
     * Initiate action.
     * Override if action is initiated in non-standard manner.
     */
    default Action start() {
        NavigationPage.setActionAndGo(getName());
        return this;
    }

    /**
     * Fill tabs of associated workspace with provided data and submit if necessary.
     * Override if action is performed in non-standard manner.
     *
     * @param td TestData with data tables for each tab
     */
    default Action perform(TestData td) {
        start();
        getWorkspace().fill(td);
        return submit();
    }

    /**
     * Starts and submit action instantly without filling of tabs in associated workspace
     * Override if action is performed in non-standard manner.
     */
    default Action perform() {
        return start().submit();
    }

    /**
     * Finalize action (usually by clicking some button).
     * Override if action is finalized in non-standard manner (e.g. custom button is clicked).
     */
    default Action submit() {
        Tab.buttonOk.click();
        Page.dialogConfirmation.confirm();
        return this;
    }
}
