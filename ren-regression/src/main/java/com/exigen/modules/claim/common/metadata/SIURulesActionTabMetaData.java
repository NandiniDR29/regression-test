/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class SIURulesActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> CODE = declare("Code", TextBox.class);
    public static final AssetDescriptor<TextBox> CATEGORY = declare("Category", TextBox.class);
    public static final AssetDescriptor<TextBox> SCORE = declare("Score", TextBox.class);
    public static final AssetDescriptor<TextBox> RULE_DESCRIPTION = declare("Rule Description", TextBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_SCORE = declare("Total Score", TextBox.class);
    public static final AssetDescriptor<TextBox> POTENTIAL_THRESHOLD = declare("Potential Threshold", TextBox.class);
    public static final AssetDescriptor<TextBox> STATUS = declare("Status", TextBox.class);
}
