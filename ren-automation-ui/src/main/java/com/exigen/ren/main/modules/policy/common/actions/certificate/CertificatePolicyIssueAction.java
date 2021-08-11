/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.ren.main.modules.policy.common.actions.certificate;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.policy.common.actions.common.IssueAction;
import com.exigen.ren.main.modules.policy.common.tabs.common.IssueActionTab;

public class CertificatePolicyIssueAction extends IssueAction {

    @Override
    public Action submit() {
        IssueActionTab.buttonPurchase.click();
        Page.dialogConfirmation.confirm();
        return this;
    }

}

