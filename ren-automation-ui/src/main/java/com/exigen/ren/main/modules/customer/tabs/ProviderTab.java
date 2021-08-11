/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.tabs;

import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.RepeatAssetList;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.customer.metadata.ProviderTabMetaData;
import org.openqa.selenium.By;

public class ProviderTab extends DefaultTab {

    private static final Button buttonAddProvider = new Button(By.id("crmForm:addProvider"));
    private static final ByT SEARCH_PROVIDER = ByT.id("crmForm:showProviderSearchPopup_%s");
    public static final ByT SECTION_LOCATOR_TEMPLATE = ByT.id("crmForm:providerTogglePanel_%s");

    public ProviderTab() {
        super(ProviderTabMetaData.class);

        assetList = new RepeatAssetList(SECTION_LOCATOR_TEMPLATE, metaDataClass) {
            @Override
            protected boolean sectionExists(int i) {
                return new StaticElement(SECTION_LOCATOR_TEMPLATE.format(i)).isPresent();
            }

            @Override
            protected void addSection(int i, int size) {
                if (!sectionExists(i)) {
                    buttonAddProvider.click();
                    new Button(SEARCH_PROVIDER.format(i)).click();
                }
            }
        };
        this.assetList.setName(ProviderTab.class.getSimpleName());
    }

    @Override
    public Tab submitTab() {
        buttonSaveAndExit.click();
        return this;
    }
}
