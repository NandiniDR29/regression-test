package com.exigen.ren.main.modules.policy.common.tabs.master;

import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.policy.common.metadata.master.CaseInstallationEndorseNPDINfoActionTabMetaData;

public class CaseInstallationEndorseNPDINfoActionTab extends ActionTab {
    public CaseInstallationEndorseNPDINfoActionTab() {
        super(CaseInstallationEndorseNPDINfoActionTabMetaData.class);

    }

    @Override
    public Tab submitTab() {
        Waiters.AJAX.then(Waiters.SLEEP(500)).go();
        buttonNext.click(doubleWaiter);
        return this;
    }
}
