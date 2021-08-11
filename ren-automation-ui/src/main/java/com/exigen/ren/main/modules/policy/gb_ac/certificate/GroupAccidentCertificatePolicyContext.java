/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.ren.main.modules.policy.gb_ac.certificate;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.main.modules.policy.gb_ac.certificate.tabs.CertificatePolicyTab;
import com.exigen.ren.main.modules.policy.gb_ac.certificate.tabs.CoveragesTab;
import com.exigen.ren.main.modules.policy.gb_ac.certificate.tabs.InsuredTab;
import com.exigen.ren.main.modules.policy.gb_ac.certificate.tabs.PremiumSummaryTab;

public interface GroupAccidentCertificatePolicyContext {

    GroupAccidentCertificatePolicy groupAccidentCertificatePolicy = AutomationContext.getService(GroupAccidentCertificatePolicy.class);
    CertificatePolicyTab certificatePolicyTab = groupAccidentCertificatePolicy.getDefaultWorkspace().getTab(CertificatePolicyTab.class);
    CoveragesTab coveragesTab = groupAccidentCertificatePolicy.getDefaultWorkspace().getTab(CoveragesTab.class);
    InsuredTab insuredTab = groupAccidentCertificatePolicy.getDefaultWorkspace().getTab(InsuredTab.class);
    PremiumSummaryTab premiumSummaryTab = groupAccidentCertificatePolicy.getDefaultWorkspace().getTab(PremiumSummaryTab.class);

    default void createDefaultGroupAccidentCertificatePolicy() {
        groupAccidentCertificatePolicy.createPolicyViaUI(getDefaultACCertificatePolicyDataGatherData()
                .adjust(groupAccidentCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY)));
    }

    default TestData getDefaultACCertificatePolicyDataGatherData(){
        return groupAccidentCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY);
    }
}
