package com.exigen.modules.claim.gb_dn.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.LineOverrideTab;
import com.exigen.ren.main.pages.summary.claim.ClaimSummaryPage;

import static com.exigen.ren.main.enums.ActionConstants.LINE_OVERRIDE;

public class LineOverrideAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(LineOverrideTab.class)
            .build();

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    public Action start(int rowNumber) {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.ADJUDICATION.get());
        ClaimSummaryPage.tableResultsOfAdjudication.getRow(rowNumber).getCell(TableConstants.ClaimSummaryResultsOfAdjudicationTableExtended.ACTIONS.getName()).controls.links.get(LINE_OVERRIDE).click();
        return this;
    }

    public Action perform(TestData td, int rowNumber) {
        start(rowNumber);
        getWorkspace().fill(td);
        return submit();
    }

    @Override
    public Action submit() {
        return this;
    }

    @Override
    public Action start() {
        throw new UnsupportedOperationException("start() method without parameters is not supported for this action. Use start(int rowNumber) instead.");
    }

    @Override
    public Action perform(TestData td) {
        throw new UnsupportedOperationException("perform(TestData td) is not supported for this action. Use perform(TestData td, int rowNumber) instead.");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not implemented");
    }

}
