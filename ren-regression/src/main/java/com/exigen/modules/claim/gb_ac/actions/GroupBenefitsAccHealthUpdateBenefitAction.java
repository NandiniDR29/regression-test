/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_ac.actions;

import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.ClaimConstants;
import com.exigen.ren.main.modules.claim.common.actions.UpdateBenefitAction;
import com.exigen.ren.main.modules.claim.gb_ac.actions.GroupBenefitsAccHealthAddBenefitAction;
import com.exigen.ren.main.pages.summary.claim.ClaimAdjudicationBenefitPage;

public class GroupBenefitsAccHealthUpdateBenefitAction extends UpdateBenefitAction {
    @Override
    public Workspace getWorkspace() {
        return AutomationContext.getAction(GroupBenefitsAccHealthAddBenefitAction.class).getWorkspace();
    }

    @Override
    public Action start(int rowNumber) {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.ADJUDICATION.get());
        ClaimAdjudicationBenefitPage.tableAllClaimBenefits.getRow(rowNumber).getCell(ClaimConstants.ClaimAllBenefitsTable.BENEFIT_NUMBER).controls.links.getFirst().click();
        ClaimAdjudicationBenefitPage.linkBenefitUpdate.click();
        return this;
    }

}
