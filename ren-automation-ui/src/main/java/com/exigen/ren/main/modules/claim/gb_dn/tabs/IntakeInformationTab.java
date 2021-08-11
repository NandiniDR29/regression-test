/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.gb_dn.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.ipb.eisa.utils.Currency;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.claim.gb_dn.metadata.IntakeInformationTabMetaData;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static com.exigen.ren.common.pages.Page.dialogConfirmation;
import static com.exigen.ren.main.enums.ActionConstants.REMOVE;
import static com.exigen.ren.main.modules.claim.gb_dn.metadata.IntakeInformationTabMetaData.SubmittedServicesSection.*;

public class IntakeInformationTab extends DefaultTab {

    public static final Button buttonAddDigitalImage = new Button(By.xpath("//input[contains(@id, 'policyDataGatherForm:addRenClaimsDigitalImage')]"));
    public static final Button buttonAddService = new Button(By.xpath("//input[contains(@id, 'policyDataGatherForm:addClaimsDamage')]"));
    public static final Button buttonSubmitClaim = new Button(By.id("policyDataGatherForm:claimSubmitBtn_ClaimsSubmitAction"));
    public static final Button buttonRemoveProvider = new Button(By.id("policyDataGatherForm:eliminateClaimsDentalVendorView"));
    public static final Button buttonRemoveService = new Button(By.id("policyDataGatherForm:eliminateClaimsDamage"));

    public static TableExtended<TableConstants.ClaimSummaryDigitalImageTableExtended> tableDigitalImage = new TableExtended<>("Digital Image",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListRenClaimsDigitalImage']/div/table"));
    public static TableExtended<SubmittedServicesColumns> tableSubmittedServices = new TableExtended<>("Submitted Services",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListClaimsDamage']/div/table"));

    public IntakeInformationTab() {
        super(IntakeInformationTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonSaveAndExit.click();
        return this;
    }

    public static void removeImage(int rowNumber) {
        tableDigitalImage.getRow(rowNumber).getCell(2).controls.links.get(ActionConstants.REMOVE).click();
        dialogConfirmation.confirm();
    }

    public static void changeService(String cdtCode, Currency charge) {
        tableSubmittedServices.getRow(ImmutableMap.of(
                CDT_CODE.getLabel(), cdtCode,
                CHARGE.getLabel(), charge.toString()))
                .getCell(9).controls.links.get(ActionConstants.CHANGE).click();
    }

    public static void changeService(String cdtCode) {
        tableSubmittedServices.getRow(CDT_CODE.getLabel(), cdtCode).getCell(9)
                .controls.links.get(ActionConstants.CHANGE).click();
    }

    public static void changeService(int number) {
        tableSubmittedServices.getRow(number).getCell(9).controls.links.get(ActionConstants.CHANGE).click();
    }

    public static void changeService(String cdtCode, Currency charge, String dos) {
        if (dos != null) {
            tableSubmittedServices.getRow(ImmutableMap.of(
                    DOS.getLabel(), dos,
                    CDT_CODE.getLabel(), cdtCode,
                    CHARGE.getLabel(), charge.toString()))
                    .getCell(9).controls.links.get(ActionConstants.CHANGE).click();
        } else {
            tableSubmittedServices.getRow(ImmutableMap.of(
                    DOS.getLabel(), StringUtils.EMPTY,
                    CDT_CODE.getLabel(), cdtCode,
                    CHARGE.getLabel(), charge.toString()))
                    .getCell(9).controls.links.get(ActionConstants.CHANGE).click();
        }
    }

    public static void removeService(String cdtCode) {
        tableSubmittedServices.getRow(CDT_CODE.getLabel(), cdtCode).getCell(9).controls.links.get(ActionConstants.REMOVE).click();
        dialogConfirmation.confirm();
    }

    public static void removeService(String cdtCode, Currency charge) {
        tableSubmittedServices.getRow(ImmutableMap.of(
                CDT_CODE.getLabel(), cdtCode,
                CHARGE.getLabel(), charge.toString()))
                .getCell(9).controls.links.get(ActionConstants.REMOVE).click();
        dialogConfirmation.confirm();
    }

    public static void removeService(int number) {
        tableSubmittedServices.getRow(number).getCell(9).controls.links.get(REMOVE).click();
        dialogConfirmation.confirm();
    }

    public static void removeProvider() {
        buttonRemoveProvider.click();
        dialogConfirmation.confirm();
    }

    public static class SubmittedServicesAssetList extends MultiAssetList {

        public SubmittedServicesAssetList(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
            super(parent, locator, metaDataClass);
        }

        public SubmittedServicesAssetList(By locator, Class<? extends MetaData> metaDataClass) {
            super(locator, metaDataClass);
        }

        @Override
        protected void addSection(int index, int size) {
            if (index > 0) {
                buttonAddService.click();
            }
        }

        @Override
        protected void selectSection(int i) {
        }
    }

    public enum SubmittedServicesColumns implements Named {
        LINE("Line #"),
        LINE_ID("Line ID"),
        DOS("DOS"),
        CDT_CODE("CDT Code"),
        TOOTH("Tooth"),
        ORAL_CAVITY("Oral Cavity"),
        SURFACE("Surface"),
        QUANTITY("Quantity"),
        CHARGE("Charge");


        private String name;

        SubmittedServicesColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum InternationalProviderColumns implements Named {
        PROVIDER_NAME("Provider Name"),
        PRACTICE_NAME("Practice Name"),
        ADDRESS("Address");

        private String name;

        InternationalProviderColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public enum ProviderColumns implements Named {
        TIN("TIN"),
        NPI("License NPI"),
        LICENSE("License #"),
        PROVIDER_NAME("Provider Name"),
        PRACTICE_NAME("Practice Name"),
        PHONE("Phone #"),
        ADDRESS("Address"),
        ALTERNATIVE_PAYEE("Alternative Payee"),
        SPECIALTY("Specialty");

        private String name;

        ProviderColumns(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
