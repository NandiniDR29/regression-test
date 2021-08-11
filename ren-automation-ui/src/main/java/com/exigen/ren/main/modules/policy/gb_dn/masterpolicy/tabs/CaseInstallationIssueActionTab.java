/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.tabs;

import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.metadata.CaseInstallationIssueActionTabMetaData;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.CASE_INSTALLATION;

public class CaseInstallationIssueActionTab extends DefaultTab {
    public CaseInstallationIssueActionTab() {
        super(CaseInstallationIssueActionTabMetaData.class);
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.expand(CASE_INSTALLATION.get(), this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return CASE_INSTALLATION.get();
    }
}
