/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.caseprofile.metadata;

import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class QuotesSelectionActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> PROPOSAL_NAME = declare("Proposal Name", TextBox.class);
    public static final AssetDescriptor<RadioGroup> PROPOSAL_TYPE = declare("Proposal Type", RadioGroup.class, By.id("proposalForm:proposalInfoEdit_type"));
}
