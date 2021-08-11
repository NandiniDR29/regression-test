/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.ren.main.modules.policy.gb_di_ltd.certificate;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.main.modules.policy.gb_di_ltd.certificate.tabs.CertificatePolicyTab;
import com.exigen.ren.main.modules.policy.gb_di_ltd.certificate.tabs.CoveragesTab;
import com.exigen.ren.main.modules.policy.gb_di_ltd.certificate.tabs.InsuredTab;
import com.exigen.ren.main.modules.policy.gb_di_ltd.certificate.tabs.PremiumSummaryTab;

public interface LongTermDisabilityCertificatePolicyContext {
    LongTermDisabilityCertificatePolicy longTermDisabilityCertificatePolicy = AutomationContext.getService(LongTermDisabilityCertificatePolicy.class);
    CertificatePolicyTab certificatePolicyTab = longTermDisabilityCertificatePolicy.getDefaultWorkspace().getTab(CertificatePolicyTab.class);
    CoveragesTab coveragesTab = longTermDisabilityCertificatePolicy.getDefaultWorkspace().getTab(CoveragesTab.class);
    InsuredTab insuredTab = longTermDisabilityCertificatePolicy.getDefaultWorkspace().getTab(InsuredTab.class);
    PremiumSummaryTab premiumSummaryTab = longTermDisabilityCertificatePolicy.getDefaultWorkspace().getTab(PremiumSummaryTab.class);

    default void createDefaultLongTermDisabilityCertificatePolicy() {
        longTermDisabilityCertificatePolicy.createPolicyViaUI(getDefaultLTDCertificatePolicyDataGatherData()
                .adjust(longTermDisabilityCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY)));
    }

    default TestData getDefaultLTDCertificatePolicyDataGatherData() {
        return longTermDisabilityCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY);
    }

    default TestData getDefaultLTDCertificatePolicyData() {
        return longTermDisabilityCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(longTermDisabilityCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }
}
