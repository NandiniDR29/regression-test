/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.metadata;

import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class MergeCustomerActionTabMetaData extends MetaData {
    public static final AssetDescriptor<Link> ADD = declare("Add", Link.class);
    public static final AssetDescriptor<Link> DELETE = declare("Delete", Link.class);
}
