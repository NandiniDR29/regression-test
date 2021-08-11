/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.tabs;

import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.main.modules.claim.common.metadata.BenefitAccidentalDeathDecedentTabMetaData;
import org.openqa.selenium.By;

public class BenefitAccidentalDeathDecedentTab extends DefaultTab {
    public static final StaticElement lableFirstName= new StaticElement(By.id("policyDataGatherForm:sedit_AccidentalDeathParty_party_partyName_firstName"));

    public BenefitAccidentalDeathDecedentTab() {
        super(BenefitAccidentalDeathDecedentTabMetaData.class);
    }
}
