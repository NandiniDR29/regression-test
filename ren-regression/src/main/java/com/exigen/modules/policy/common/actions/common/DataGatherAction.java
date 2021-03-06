/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.common.actions.common;

import com.exigen.istf.exceptions.IstfException;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;

public class DataGatherAction implements Action {

    @Override
    public String getName() {
        return "Data Gather";
    }

    @Override
    public Workspace getWorkspace() {
        throw new IstfException(String.format("Please register workspace view for current action [%1$s]", this.getClass().getSimpleName()));
    }

    @Override
    public Action submit() {
        Tab.buttonSaveAndExit.click();
        return this;
    }
}
