/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.gb_ac.certificate;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsCertificatePolicy;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsCertificatePolicyType;
import com.exigen.ren.main.modules.policy.gb_ac.certificate.actions.GroupAccidentCertificateInquiryAction;
import com.exigen.ren.main.modules.policy.gb_ac.certificate.actions.GroupAccidentCertificatePolicyDataGatherAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Concrete implementation for a specific entity type.
 * @category Generated
 */
public class GroupAccidentCertificatePolicy implements GroupBenefitsCertificatePolicy {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/policy/gb_ac/certificate");
    protected static final Logger LOGGER = LoggerFactory.getLogger(GroupAccidentCertificatePolicy.class);

    @Override
    public GroupBenefitsCertificatePolicyType getType() {
        return GroupBenefitsCertificatePolicyType.GB_AC;
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return dataGather().getWorkspace();
    }

    @Override
    public GroupAccidentCertificatePolicyDataGatherAction dataGather() {
        return AutomationContext.getAction(GroupAccidentCertificatePolicyDataGatherAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    @Override
    public GroupAccidentCertificateInquiryAction policyInquiry() {
        return AutomationContext.getAction(GroupAccidentCertificateInquiryAction.class);
    }

    @Override
    public GroupAccidentCertificateInquiryAction quoteInquiry() {
        return policyInquiry();
    }
}
