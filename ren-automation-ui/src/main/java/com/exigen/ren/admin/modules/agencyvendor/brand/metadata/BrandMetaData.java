/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.brand.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class BrandMetaData extends MetaData {

    public static final AssetDescriptor<DialogAssetList> ADD_BRAND_TYPE = declare("Add Brand Type", DialogAssetList.class, AddBrandTypeDialog.class, false, By.id("brandTypeEditForm:brandTypeEditDialog"));
    public static final AssetDescriptor<DialogAssetList> ADD_BRAND = declare("Add Brand", DialogAssetList.class, AddBrandDialog.class, false, By.id("brandEditForm:brandEditDialog"));

    public static final class AddBrandTypeDialog extends MetaData {
        public static final AssetDescriptor<TextBox> BRAND_TYPE_CODE = declare("Brand Type Code", TextBox.class, By.id("brandTypeEditForm:brandType_code"));
        public static final AssetDescriptor<TextBox> BRAND_TYPE_NAME = declare("Brand Type Name", TextBox.class);
    }

    public static final class AddBrandDialog extends MetaData {
        public static final AssetDescriptor<TextBox> BRAND_CODE = declare("Brand Code", TextBox.class, By.id("brandEditForm:brand_code"));
        public static final AssetDescriptor<TextBox> BRAND_NAME = declare("Brand Name", TextBox.class, By.id("brandEditForm:brand_name"));
        public static final AssetDescriptor<ComboBox> BRAND_TYPE = declare("Brand Type", ComboBox.class, By.id("brandEditForm:brand_type"));
        public static final AssetDescriptor<TextBox> BRAND_EFFECTIVE_DATE = declare("Brand Effective Date", TextBox.class);
        public static final AssetDescriptor<TextBox> BRAND_EXPIRATION_DATE = declare("Brand Expiration Date", TextBox.class);
        public static final AssetDescriptor<AdvancedSelector> UNDERWRITING_COMPANIES = declare("Underwriting Companies", AdvancedSelector.class,
                By.xpath("//table[@class='pfForm pfSimpleForm' and .//button[@id='brandEditForm:selectCoveragesBtn']]"));
        public static final AssetDescriptor<Button> BUTTON_CANCEL = declare("Cancel", Button.class, By.id("brandEditForm:cancelBrand"));
        public static final AssetDescriptor<Button> BUTTON_UPDATE = declare("Update", Button.class, By.id("brandEditForm:updateBrand"));
    }
}

