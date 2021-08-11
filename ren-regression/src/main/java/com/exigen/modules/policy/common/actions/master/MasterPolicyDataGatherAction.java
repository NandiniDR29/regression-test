/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.modules.policy.common.actions.master;

import com.exigen.modules.policy.common.actions.common.DataGatherAction;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Tab;

public class MasterPolicyDataGatherAction extends DataGatherAction {

    @Override
    public Action submit() {
        if (Tab.buttonSaveAndExit.isPresent()) {
            Tab.buttonSaveAndExit.click();
        }
        return this;
    }
}
