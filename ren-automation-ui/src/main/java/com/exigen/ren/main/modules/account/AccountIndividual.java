package com.exigen.ren.main.modules.account;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;

public class AccountIndividual extends Account {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/cem/account/individual");

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
