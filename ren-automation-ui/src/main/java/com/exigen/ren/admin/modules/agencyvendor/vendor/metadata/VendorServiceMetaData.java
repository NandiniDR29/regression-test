/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.vendor.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class VendorServiceMetaData extends MetaData {
    public static final AssetDescriptor<Button> ADD_VENDOR_SERVICES = declare("Add Vendor Services", Button.class, Waiters.DEFAULT, false,
            By.id("vendorProfileForm:addVendorServices"));
    public static final AssetDescriptor<AdvancedSelector> LOB = declare("LOB", AdvancedSelector.class);
    public static final AssetDescriptor<AdvancedSelector> PRODUCT = declare("Product", AdvancedSelector.class);
    public static final AssetDescriptor<AdvancedSelector> SERVICE_TYPE = declare("Service Type", AdvancedSelector.class);
    public static final AssetDescriptor<AdvancedSelector> SERVICE_AREA = declare("Service Area", AdvancedSelector.class);
}
