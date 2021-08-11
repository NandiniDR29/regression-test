/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.policy.gb_vs.certificate;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.main.modules.policy.gb_vs.certificate.tabs.CertificatePolicyTab;
import com.exigen.ren.main.modules.policy.gb_vs.certificate.tabs.InsuredTab;
import com.exigen.ren.main.modules.policy.gb_vs.certificate.tabs.PlansTab;
import com.exigen.ren.main.modules.policy.gb_vs.certificate.tabs.PremiumSummaryTab;

public interface GroupVisionCertificatePolicyContext {

    GroupVisionCertificatePolicy groupVisionCertificatePolicy = AutomationContext.getService(GroupVisionCertificatePolicy.class);
    CertificatePolicyTab certificatePolicyTab = groupVisionCertificatePolicy.getDefaultWorkspace().getTab(CertificatePolicyTab.class);
    PlansTab coveragesTab = groupVisionCertificatePolicy.getDefaultWorkspace().getTab(PlansTab.class);
    InsuredTab insuredTab = groupVisionCertificatePolicy.getDefaultWorkspace().getTab(InsuredTab.class);
    PremiumSummaryTab premiumSummaryTab = groupVisionCertificatePolicy.getDefaultWorkspace().getTab(PremiumSummaryTab.class);

    default void createDefaultGroupVisionCertificatePolicy() {
        groupVisionCertificatePolicy.createPolicyViaUI(getDefaultVSCertificatePolicyData());
    }

    default TestData getDefaultVSCertificatePolicyData(){
        return groupVisionCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, TestDataKey.DEFAULT_TEST_DATA_KEY)
                .adjust(groupVisionCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
    }
}
