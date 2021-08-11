/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cms.efoldermanagment.efoldertree.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class SubfolderMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> NAME = declare("Name", TextBox.class);
    public static final AssetDescriptor<AdvancedSelector> ALLOWED_DOCUMENT_TYPES = declare("Allowed Document Types", AdvancedSelector.class);
    public static final AssetDescriptor<AdvancedSelector> VIEW_PRIVILEGE = declare("View Privilege", AdvancedSelector.class);
    public static final AssetDescriptor<AdvancedSelector> EDIT_PRIVILEGE = declare("Edit Privilege", AdvancedSelector.class);
}
