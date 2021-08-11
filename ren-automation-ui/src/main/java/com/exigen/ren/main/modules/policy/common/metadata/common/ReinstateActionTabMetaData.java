/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.common.metadata.common;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class ReinstateActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> CANCELLATION_EFFECTIVE_DATE = declare("Cancellation Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> REINSTATEMENT_DATE = declare("Reinstatement Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> REINSTATEMENT_REASON = declare("Reinstatement Reason", ComboBox.class);
    public static final AssetDescriptor<ComboBox> REASON = declare("Reason", ComboBox.class);
    public static final AssetDescriptor<TextBox> OTHER = declare("Other", TextBox.class);
}
