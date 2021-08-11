package com.exigen.modules.policy.common.tabs.master;

import com.exigen.modules.policy.common.metadata.master.GeneratePolicyDocumentsTabMetaData;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;

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
