/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.security.profile.metadata;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class AuthorityLevelsMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> TYPE = declare("Type", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PRODUCT = declare("Product", ComboBox.class);
    public static final AssetDescriptor<ComboBox> LEVEL = declare("Level", ComboBox.class);

    public static final AssetDescriptor<Button> SAVE_NEW_AUTHORITY = declare("Save New Authority", Button.class,
            By.id("userProfileForm:saveAuthority"));
    public static final AssetDescriptor<Button> UPDATE_AUTHORITY = declare("Update Authority", Button.class,
            By.id("userProfileForm:updateAuthority"));
    public static final AssetDescriptor<Button> CANCEL_AUTHORITY = declare("Cancel Authority", Button.class,
            By.id("userProfileForm:cancelAuthority"));
}
