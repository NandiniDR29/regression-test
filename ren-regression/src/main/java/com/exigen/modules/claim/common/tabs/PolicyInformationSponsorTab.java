/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.tabs;

import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.common.metadata.PolicyInformationSponsorTabMetaData;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.POLICY_INFORMATION;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.SPONSOR;

public class PolicyInformationSponsorTab extends DefaultTab {
    public PolicyInformationSponsorTab() {
        super(PolicyInformationSponsorTabMetaData.class);
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.expand(POLICY_INFORMATION.get(), this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return SPONSOR.get();
    }
}
