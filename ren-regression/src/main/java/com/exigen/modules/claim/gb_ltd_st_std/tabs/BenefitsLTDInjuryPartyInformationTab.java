/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_ltd_st_std.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.claim.gb_ltd_st_std.metadata.BenefitsLTDInjuryPartyInformationTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.main.modules.claim.gb_ltd_st_std.tabs.BenefitsLTDInjuryPartyInformationTab.ListOfParticipantIndexedPreDisabilityEarnings.YEAR_NO;

public class BenefitsLTDInjuryPartyInformationTab extends DefaultTab {
    public static TableExtended<ListOfParticipantIndexedPreDisabilityEarnings> listOfParticipantIndexedPreDisabilityEarnings = new TableExtended<>("List of Participant Indexed Pre-Disability Earnings",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListRenClaimsLTDIndexedPreDisabilityEarnings']/div/table"));
    public static final ByT btnRemoveParticipant = ByT.id("policyDataGatherForm:dataGatherView_ListRenClaimsLTDIndexedPreDisabilityEarnings:%s:dataGatherView_List_Eliminate");
    public static final Button addYTDTaxableWage = new Button(By.id("policyDataGatherForm:addLTDPartyYTDTaxableWage"));
    public static final Button buttonAddAssociatedScheduledItem = new Button(By.id("policyDataGatherForm:addPrecClaimsLTDLossItems"));

    public BenefitsLTDInjuryPartyInformationTab() {
        super(BenefitsLTDInjuryPartyInformationTabMetaData.class);
    }

    public static class ParticipantIndexedPreDisabilityEarnings extends MultiAssetList {
        public static final Button addParticipantIndexedPreDisabilityEarnings = new Button(By.id("policyDataGatherForm:addRenClaimsLTDIndexedPreDisabilityEarnings"));

        public ParticipantIndexedPreDisabilityEarnings(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
            super(parent, locator, metaDataClass);
        }

        public ParticipantIndexedPreDisabilityEarnings(By locator, Class<? extends MetaData> metaDataClass) {
            super(locator, metaDataClass);
        }

        @Override
        protected void addSection(int index, int size) {
            addParticipantIndexedPreDisabilityEarnings.click();
        }

        @Override
        protected void selectSection(int i) {
        }
    }

    public enum ListOfParticipantIndexedPreDisabilityEarnings implements Named {
        YEAR_NO("Year No."),
        YEAR_START_DATE("Year Start Date (MM/DD/YYYY)"),
        YEAR_END_DATE("Year End Date (MM/DD/YYYY)"),
        INDEXED_PRE_DISABILITY_EARNINGS("Indexed Pre-Disability Earnings");

        private String name;

        ListOfParticipantIndexedPreDisabilityEarnings(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public static void removeParticipantByName(String name) {
        listOfParticipantIndexedPreDisabilityEarnings.getRow(YEAR_NO.getName(), name).getCell(6).controls.links.get("Remove").click();
        Page.dialogConfirmation.buttonYes.click();
    }

    public static class YTDTaxableWageMultiAssetList extends MultiAssetList {

        public YTDTaxableWageMultiAssetList(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
            super(parent, locator, metaDataClass);
        }

        public YTDTaxableWageMultiAssetList(By locator, Class<? extends MetaData> metaDataClass) {
            super(locator, metaDataClass);
        }

        @Override
        protected void addSection(int index, int size) {
            addYTDTaxableWage.click();
        }

        @Override
        protected void selectSection(int i) {
        }
    }
}
