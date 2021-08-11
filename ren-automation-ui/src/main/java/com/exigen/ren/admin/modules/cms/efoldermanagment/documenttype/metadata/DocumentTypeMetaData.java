/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cms.efoldermanagment.documenttype.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class DocumentTypeMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> DOCUMENT_TYPE_CODE = declare("Document Type Code", TextBox.class);
    public static final AssetDescriptor<TextBox> DOCUMENT_TYPE_NAME = declare("Document Type Name", TextBox.class);
    public static final AssetDescriptor<TextBox> DOCUMENT_TYPE_NAME_DISCRIPTION = declare("Document Type Name (i18n)", TextBox.class);
    public static final AssetDescriptor<AdvancedSelector> FOLDER_TYPE = declare("Folders that can contain document type", AdvancedSelector.class);
}
