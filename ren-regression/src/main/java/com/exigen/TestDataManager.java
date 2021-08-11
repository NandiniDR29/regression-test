/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen;

import com.exigen.istf.data.DataProviderFactory;
import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.common.GroupBenefitsMasterPolicyType;
import com.exigen.ren.common.module.efolder.EfolderType;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;

//TODO move test data initialization to appropriate services after all will be refactored
public final class TestDataManager {

    protected DataProviderFactory dataProvider = TestDataProvider.getDefaultTestDataProvider();
    public Map<GroupBenefitsMasterPolicyType, TestData> groupBenefitsMaster = new HashMap<>();
    public EnumMap<EfolderType, TestData> efolder = new EnumMap<>(EfolderType.class);


    public TestDataManager() {
        //new approach with common test data storage ends
        groupBenefitsMaster.put(GroupBenefitsMasterPolicyType.GB_DN, dataProvider.get("modules/policy/gb_dn/master"));
        efolder.put(EfolderType.EFOLDER, dataProvider.get("modules/efolder"));
    }

    public TestData getDefault(Class<?> klass) {
        List<String> path = Arrays.asList(klass.getName().split("\\."));
        return dataProvider.get(StringUtils.join(path.subList(0, path.size() - 1), File.separator).replace(FilenameUtils.separatorsToSystem("com\\exigen\\ren"), ""),
                path.get(path.size() - 1));
    }

    public TestData getCompatibilityTestData() {
        return dataProvider.get("", "TestData");
    }
}
