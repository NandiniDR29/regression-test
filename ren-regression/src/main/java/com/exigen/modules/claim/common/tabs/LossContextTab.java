/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.claim.common.metadata.LossContextTabMetaData;
import org.openqa.selenium.By;

public class LossContextTab extends DefaultTab {

    public static final StaticElement labelCustomerNumber = new StaticElement(By.id("policyDataGatherForm:customerNumberSelection"));
    public static final StaticElement labelPolicyNumber = new StaticElement(By.id("policyDataGatherForm:policyNumber"));
    public static final StaticElement labelPolicyStatus = new StaticElement(By.id("policyDataGatherForm:policyStatus"));
    public static final StaticElement labelPolicyBLOB = new StaticElement(By.id("policyDataGatherForm:broadLineOfBusinessCd"));
    public static final StaticElement labelPolicyLOB = new StaticElement(By.xpath("//select[@id='policyDataGatherForm:sedit_ClaimsLossContext_lineOfBusinessCd']/option[@selected='selected']"));
    public static final StaticElement labelPolicyProduct = new StaticElement(By.xpath("//select[@id='policyDataGatherForm:sedit_ClaimsLossContext_claim_policyProductCd']/option[@selected='selected']"));

    public static final Button buttonStartClaims = new Button(By.xpath("//input[@value='Start Claims' and not(contains(@style,'none'))]"));
    public static final Button buttonAddClaimsLossContext = new Button(By.id("policyDataGatherForm:addClaimsLossContext"));

    public static final Table policySearchResults = new Table(By.xpath("//div[@id='policySearchForm:policySearchResults']//table"));
    public static final Table listOfLostContext = new Table(By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListClaimsLossContext']//table"));

    public LossContextTab() {
        super(LossContextTabMetaData.class);

        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {

            @Override
            protected void addSection(int index, int size) {
                if (index > 0) {
                    buttonAddClaimsLossContext.click();
                }
            }

            @Override
            protected void selectSection(int i) {}
        };
        assetList.setName(this.getClass().getSimpleName());
    }

    @Override
    public Tab submitTab() {
        buttonStartClaims.click();
        return this;
    }
}
