/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.security.par.metadata;

import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class PARSearchMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> PRODUCT_ACCESS_ROLE_NAME = declare("Product Access Role Name", TextBox.class);
    public static final AssetDescriptor<TextBox> PRODUCT_ACCESS_ROLE_CODE = declare("Product Access Role Code", TextBox.class);
}
