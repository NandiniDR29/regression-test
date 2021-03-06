/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.claim.common.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.modules.claim.common.metadata.FeatureFeatureHandlingFeatureOwnerActionTabMetaData;
import org.openqa.selenium.By;

public class FeatureFeatureHandlingFeatureOwnerActionTab extends ActionTab {
    //TODO Check if we need this page and delete
    public static final Button buttonPopupOk = new Button(By.id("policyDataGatherForm:pendingFeaturePopup_ok"));

    public FeatureFeatureHandlingFeatureOwnerActionTab() {
        super(FeatureFeatureHandlingFeatureOwnerActionTabMetaData.class);
    }
}
