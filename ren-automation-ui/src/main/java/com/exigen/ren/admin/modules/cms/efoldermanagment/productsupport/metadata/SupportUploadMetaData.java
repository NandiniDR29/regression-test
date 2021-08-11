/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cms.efoldermanagment.productsupport.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.FileUpload;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class SupportUploadMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> PRODUCT = declare("Product", ComboBox.class);
    public static final AssetDescriptor<ComboBox> DOCUMENT_TYPE = declare("Document Type", ComboBox.class);
    public static final AssetDescriptor<FileUpload> FILE_TO_UPLOAD = declare("File to upload", FileUpload.class, Waiters.SLEEP(200000), By.id("fileupload"));
    public static final AssetDescriptor<TextBox> EXPIRES= declare("Expires", TextBox.class);
}
