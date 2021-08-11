/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.modules.claim.common.metadata.BenefitsAccidentalDismembermentInjuryPartyInformationTabMetaData;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;

import static com.exigen.ren.main.modules.claim.common.tabs.BenefitsAccidentalDismembermentInjuryPartyInformationTab.ListOfItemizedInjuryIllness.DESCRIPTION;

public class BenefitsAccidentalDismembermentInjuryPartyInformationTab extends DefaultTab {

    public static Button buttonAddItem = new Button(By.id("policyDataGatherForm:addPrecClaimsADLossItems"));
    public static TableExtended<ListOfItemizedInjuryIllness> tableListOfItemizedInjuryIllness = new TableExtended<>("List of Itemized Injury/Illness",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListPrecClaimsADLossItems']/div/table"));

    public BenefitsAccidentalDismembermentInjuryPartyInformationTab() {
        super(BenefitsAccidentalDismembermentInjuryPartyInformationTabMetaData.class);
    }

    public static class ItemizedInjuryIllnessAssetList extends MultiAssetList {

        public ItemizedInjuryIllnessAssetList(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
            super(parent, locator, metaDataClass);
        }

        public ItemizedInjuryIllnessAssetList(By locator, Class<? extends MetaData> metaDataClass) {
            super(locator, metaDataClass);
        }

        @Override
        protected void addSection(int index, int size) {
            if (index > 0) {
                buttonAddItem.click();
            }
        }

        @Override
        protected void selectSection(int i) {
        }
    }


    public enum ListOfItemizedInjuryIllness implements Named {
        ITEMIZED_ID("Itemized ID"),
        DESCRIPTION("Description"),
        ESTIMATED_COST_VALUE("Estimated Cost/Value");

        private String name;

        ListOfItemizedInjuryIllness(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public static void removeBenefitFromListOfItemizedInjuryIllnessTable (String benefit) {
        LOGGER.info(String.format("Remove benefit: '%s'", benefit));
        tableListOfItemizedInjuryIllness.getRow(ImmutableMap.of(DESCRIPTION.getName(), benefit)).getCell(5).controls.links.get(ActionConstants.REMOVE).click();
        Page.dialogConfirmation.confirm();
    }
}
