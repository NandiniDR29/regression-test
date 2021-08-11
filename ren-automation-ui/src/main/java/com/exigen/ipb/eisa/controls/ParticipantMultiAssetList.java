package com.exigen.ipb.eisa.controls;

import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.main.modules.policy.gb_ac.certificate.tabs.CoveragesTab;
import com.exigen.ren.main.modules.policy.gb_vs.certificate.tabs.PlansTab;
import org.openqa.selenium.By;

public class ParticipantMultiAssetList extends MultiAssetList {

    public ParticipantMultiAssetList(By locator, Class<? extends MetaData> metaDataClass) {
        super(locator, metaDataClass);
    }

    public ParticipantMultiAssetList(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
        super(parent, locator, metaDataClass);
    }

    @Override
    protected boolean sectionExists(int index) {
        return CoveragesTab.tableParticipantsList.getRow(index + 1).isPresent();
    }

    @Override
    protected void addSection(int i, int i1) {
        PlansTab.buttonAddParticipant.click();
    }

    @Override
    protected void selectSection(int i) {

    }
}
