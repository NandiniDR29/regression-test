/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren;

import com.exigen.istf.data.DataFormat;
import com.exigen.istf.data.DataProviderFactory;

public final class TestDataProvider {

    public static DataProviderFactory getDefaultTestDataProvider(){
        return InstanceHolder.DATA_PROVIDER_FACTORY;
    }

    private static class InstanceHolder {
        private static final DataProviderFactory DATA_PROVIDER_FACTORY = new DataProviderFactory().applyConfiguration(DataFormat.YAML.name());
    }
}
