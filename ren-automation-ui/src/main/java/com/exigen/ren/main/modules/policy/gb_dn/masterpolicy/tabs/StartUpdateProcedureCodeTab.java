package com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.tabs;

import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.metadata.StartUpdateProcedureCodeTabMetaData;

public class StartUpdateProcedureCodeTab extends ActionTab {
    public StartUpdateProcedureCodeTab() {
        super(StartUpdateProcedureCodeTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        Tab.buttonOk.click();
        return this;
    }
}
