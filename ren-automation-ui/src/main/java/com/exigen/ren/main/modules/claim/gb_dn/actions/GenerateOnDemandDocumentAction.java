package com.exigen.ren.main.modules.claim.gb_dn.actions;

import com.exigen.istf.data.TestData;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.DocGenConstants;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.GenerateOnDemandDocumentTab;

import static com.exigen.ren.main.modules.claim.gb_dn.tabs.GenerateOnDemandDocumentTab.buttonGenerate;

public class GenerateOnDemandDocumentAction implements Action {
    private static String folderName;
    private Workspace workspace = new Workspace.Builder()
            .registerTab(GenerateOnDemandDocumentTab.class)
            .build();

    @Override
    public String getName() {
        return "Generate On Demand Document";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    public Action perform(TestData testData, int row) {
        start(row);
        getWorkspace().fill(testData);
        return submit();
    }

    public Action start(int row) {
        Action.super.start();
        folderName = GenerateOnDemandDocumentTab.tableDocumentTemplates.getRow(row).getCell(6).getValue();
        GenerateOnDemandDocumentTab.tableDocumentTemplates.getRow(row).getCell(DocGenConstants.DocGendDcumentTemplatesTable.TEMPLATE_ID).controls.links.getFirst().click();
        return this;
    }

    @Override
    public Action submit() {
        buttonGenerate.click();
        Page.dialogConfirmation.confirm();
        return this;
    }

    public String getFolderName() {
        return folderName;
    }
}
