/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_ltd_st_std.tabs;

import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.metadata.BenefitsLTDIncidentTabMetaData;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimBenefitLeftMenu.INCIDENT;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.BENEFITS;

public class BenefitsLTDIncidentTab extends DefaultTab {
    public BenefitsLTDIncidentTab() {
        super(BenefitsLTDIncidentTabMetaData.class);
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.expand(BENEFITS.get(), this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return INCIDENT.get();
    }
}
