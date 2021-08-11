/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.common.metadata.master;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class CopyPolicyActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> POLICY_EFFECTIVE_DATE = declare("Policy Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> COVERAGE_EFFECTIVE_DATE = declare("Coverage Effective Date", TextBox.class);
}
