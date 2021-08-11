package com.exigen.ren.main.modules.policy.common.tabs.master;

import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.policy.common.metadata.master.GeneratePolicyDocumentsTabMetaData;

public class GeneratePolicyDocumentsTab extends ActionTab {
    public GeneratePolicyDocumentsTab() {
        super(GeneratePolicyDocumentsTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonOk.click();
        return this;
    }
}
