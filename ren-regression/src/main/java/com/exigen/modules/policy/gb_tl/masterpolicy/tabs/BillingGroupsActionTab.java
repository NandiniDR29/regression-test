/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.policy.gb_tl.masterpolicy.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.metadata.BillingGroupsActionTabMetaData;
import org.openqa.selenium.By;

public class BillingGroupsActionTab extends ActionTab {

    public static Button buttonAddBillingGroup = new Button(By.id("policyDataGatherForm:addGroupBillingGroup"));

    public BillingGroupsActionTab() {
        super(BillingGroupsActionTabMetaData.class);

        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {
            @Override
            protected void addSection(int index, int size) {
                if (index > 0) {
                    buttonAddBillingGroup.click();
                }
            }

            @Override
            protected void selectSection(int index) {}
        };
        assetList.setName(this.getClass().getSimpleName());
    }

    @Override
    public Tab submitTab() {
        buttonNext.click();
        return this;
    }
}
