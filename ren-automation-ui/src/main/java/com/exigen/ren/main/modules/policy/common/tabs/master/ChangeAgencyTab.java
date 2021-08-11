package com.exigen.ren.main.modules.policy.common.tabs.master;

import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.composite.assets.RepeatAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.policy.common.metadata.master.ChangeAgencyTabMetaData;
import org.openqa.selenium.By;

public class ChangeAgencyTab extends ActionTab {
    public ChangeAgencyTab() {
        super(ChangeAgencyTabMetaData.class);
    }

    public static class TransferTarget extends RepeatAssetList {

        public TransferTarget(By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(ByT.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass);
        }

        public TransferTarget(BaseElement<?, ?> parent, By locatorTemplate, Class<? extends MetaData> metaDataClass) {
            super(ByT.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass);
        }

        @Override
        protected void addSection(int i, int i1) {

        }
    }

    @Override
    public Tab submitTab() {
        buttonOk.click(doubleWaiter);
        return this;
    }
}
