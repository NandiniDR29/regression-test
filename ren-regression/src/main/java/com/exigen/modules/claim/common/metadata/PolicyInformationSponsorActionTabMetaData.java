/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.metadata;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class PolicyInformationSponsorActionTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> COMPANY_NAME = declare("Company Name", TextBox.class);
    public static final AssetDescriptor<TextBox> MASTER_POLICY_NUMBER = declare("Master Policy Number", TextBox.class);
    public static final AssetDescriptor<TextBox> SPONSOR_PHONE = declare("Sponsor Phone", TextBox.class);
    public static final AssetDescriptor<TextBox> SPONSOR_EMAIL = declare("Sponsor Email", TextBox.class);
    public static final AssetDescriptor<TextBox> SPONSOR_ADDRESS = declare("Sponsor Address", TextBox.class);
}
