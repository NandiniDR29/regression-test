/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.tabs;

import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.metadata.MasterPolicyIssueActionTabMetaData;

public class MasterPolicyIssueActionTab extends ActionTab {
    public MasterPolicyIssueActionTab() {
        super(MasterPolicyIssueActionTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonNext.click();
        return this;
    }
}
