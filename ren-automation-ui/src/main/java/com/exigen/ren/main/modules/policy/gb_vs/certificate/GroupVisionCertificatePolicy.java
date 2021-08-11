/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.policy.gb_vs.certificate;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsCertificatePolicy;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsCertificatePolicyType;
import com.exigen.ren.main.modules.policy.gb_vs.certificate.actions.GroupVisionCertificateInquiryAction;
import com.exigen.ren.main.modules.policy.gb_vs.certificate.actions.GroupVisionCertificatePolicyDataGatherAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupVisionCertificatePolicy implements GroupBenefitsCertificatePolicy {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/policy/gb_vs/certificate");
    protected static final Logger LOGGER = LoggerFactory.getLogger(GroupVisionCertificatePolicy.class);

    @Override
    public GroupBenefitsCertificatePolicyType getType() {
        return GroupBenefitsCertificatePolicyType.GB_VS;
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return dataGather().getWorkspace();
    }

    @Override
    public GroupVisionCertificatePolicyDataGatherAction dataGather() {
        return AutomationContext.getAction(GroupVisionCertificatePolicyDataGatherAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    @Override
    public GroupVisionCertificateInquiryAction quoteInquiry() {
        return policyInquiry();
    }

    @Override
    public GroupVisionCertificateInquiryAction policyInquiry() {
        return AutomationContext.getAction(GroupVisionCertificateInquiryAction.class);
    }
}