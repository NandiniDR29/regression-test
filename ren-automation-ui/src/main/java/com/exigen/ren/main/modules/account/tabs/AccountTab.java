/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.account.tabs;

import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.account.metadata.AccountTabMetaData;

public class AccountTab extends DefaultTab {

    public AccountTab() {
        super(AccountTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }
}
