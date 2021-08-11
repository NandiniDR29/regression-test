/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.actions;

import com.exigen.istf.exceptions.IstfException;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;

public class CreateAction implements Action {

    @Override
    public String getName() {
        return "Data Gather";
    }

    @Override
    public Workspace getWorkspace() {
        throw new IstfException("Default Create action for claim was called. Implement this action for specific claim type.");
    }

}
