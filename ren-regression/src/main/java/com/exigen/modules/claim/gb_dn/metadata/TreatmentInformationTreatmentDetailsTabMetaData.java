/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_dn.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class TreatmentInformationTreatmentDetailsTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> TYPE_OF_TRANSACTION = declare("Type of Transaction", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PLACE_OF_TREATMENT = declare("Place of Treatment", ComboBox.class);
}
