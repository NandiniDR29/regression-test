/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.common.metadata.BenefitsDiagnosisAndTreatmentInjuryPartyInformationTabMetaData;
import com.exigen.ren.main.modules.claim.common.tabs.PaymentCalculatorTab;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimBenefitLeftMenu.INJURY_PARTY_INFORMATION;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimFNOLLeftMenu.BENEFITS;

public class BenefitsDiagnosisAndTreatmentInjuryPartyInformationTab extends DefaultTab {

    public static Button buttonAddItem = new Button(By.id("policyDataGatherForm:addPrecClaimsAILossItems"));
    public static TableExtended<PaymentCalculatorTab.PaymentCalculatorPaymentAddition> listOfItemizedInjuryIllness = new TableExtended<>("List of Itemized Injury/Illness",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListPrecClaimsAILossItems']/div/table"));

    public BenefitsDiagnosisAndTreatmentInjuryPartyInformationTab() {
        super(BenefitsDiagnosisAndTreatmentInjuryPartyInformationTabMetaData.class);
    }

    public static class ItemizedInjuryIllnessMultiAssetList extends MultiAssetList {

        public ItemizedInjuryIllnessMultiAssetList(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
            super(parent, locator, metaDataClass);
        }

        public ItemizedInjuryIllnessMultiAssetList(By locator, Class<? extends MetaData> metaDataClass) {
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

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.expand(BENEFITS.get(), this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return INJURY_PARTY_INFORMATION.get();
    }
}
