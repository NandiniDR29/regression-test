/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.brand;

import com.exigen.ren.admin.modules.agencyvendor.brand.tabs.BrandTab;
import com.exigen.ren.common.AutomationContext;

public interface BrandContext {
    Brand brand = AutomationContext.getService(Brand.class);
    BrandType brandType = AutomationContext.getService(BrandType.class);
    BrandTab brandTab =  brand.getDefaultWorkspace().getTab(BrandTab.class);
}
