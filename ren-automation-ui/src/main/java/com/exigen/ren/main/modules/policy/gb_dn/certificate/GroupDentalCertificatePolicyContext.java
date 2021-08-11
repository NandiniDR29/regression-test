/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.policy.gb_dn.certificate;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.tabs.CertificatePolicyTab;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.tabs.InsuredTab;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.tabs.PlansTab;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.tabs.PremiumSummaryTab;

public interface GroupDentalCertificatePolicyContext {

    GroupDentalCertificatePolicy groupDentalCertificatePolicy = AutomationContext.getService(GroupDentalCertificatePolicy.class);
    CertificatePolicyTab certificatePolicyTab = groupDentalCertificatePolicy.getDefaultWorkspace().getTab(CertificatePolicyTab.class);
    PlansTab coveragesTab = groupDentalCertificatePolicy.getDefaultWorkspace().getTab(PlansTab.class);
    InsuredTab insuredTab = groupDentalCertificatePolicy.getDefaultWorkspace().getTab(InsuredTab.class);
    PremiumSummaryTab premiumSummaryTab = groupDentalCertificatePolicy.getDefaultWorkspace().getTab(PremiumSummaryTab.class);

    default void createDefaultGroupDentalCertificatePolicy() {
        groupDentalCertificatePolicy.createPolicyViaUI(getDefaultGroupDentalCertificatePolicyData());
    }

    default TestData getDefaultGroupDentalCertificatePolicyData() {
        return groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }
}
