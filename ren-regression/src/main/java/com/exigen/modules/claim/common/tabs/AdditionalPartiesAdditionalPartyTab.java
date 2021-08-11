/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.claim.common.metadata.AdditionalPartiesAdditionalPartyTabMetaData;
import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.ADDITIONAL_PARTIES;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.ADDITIONAL_PARTY;

public class AdditionalPartiesAdditionalPartyTab extends DefaultTab {

    public static final TableExtended<TableConstants.CoverageDefinition> tableListOfAdditionalParty = new TableExtended<>("List of Additional Party", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListPrecAdditionalParty']/div/table"));
    public static Button addAdditionalPartyAssociation = new Button(By.id("policyDataGatherForm:addAdditionalPartyAssociation"));
    public static Button addAdditionalParty = new Button(By.xpath("//input[@id='policyDataGatherForm:addPrecAdditionalParty']"));

    public AdditionalPartiesAdditionalPartyTab() {
        super(AdditionalPartiesAdditionalPartyTabMetaData.class);

        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {

            @Override
            protected void addSection(int index, int size) {
            }

            @Override
            protected void selectSection(int index) {
            }

            @Override
            public void fill(TestData td) {
                if (td.containsKey(getMetaKey())) {
                    for (TestData party : td.getTestDataList(getMetaKey())) {
                        if (addAdditionalPartyAssociation.isPresent() && !addAdditionalParty.isPresent() && !party.getKeys().isEmpty()) {
                            addAdditionalPartyAssociation.click();
                        }
                        setValue(ImmutableList.of(party));
                   }
                }
            }
        };

        assetList.setName(this.getClass().getSimpleName());
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.expand(ADDITIONAL_PARTIES.get(), this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return ADDITIONAL_PARTY.get();
    }
}
