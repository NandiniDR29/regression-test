/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.gb_tl.certificate;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsCertificatePolicy;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsCertificatePolicyType;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.actions.TermLifeInsuranceCertificateInquiryAction;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.actions.TermLifeInsuranceCertificatePolicyDataGatherAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TermLifeInsuranceCertificatePolicy implements GroupBenefitsCertificatePolicy {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/policy/gb_tl/certificate");
    protected static final Logger LOGGER = LoggerFactory.getLogger(TermLifeInsuranceCertificatePolicy.class);

    @Override
    public GroupBenefitsCertificatePolicyType getType() {
        return GroupBenefitsCertificatePolicyType.GB_TL;
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return dataGather().getWorkspace();
    }

    @Override
    public TermLifeInsuranceCertificatePolicyDataGatherAction dataGather() {
        return AutomationContext.getAction(TermLifeInsuranceCertificatePolicyDataGatherAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    @Override
    public TermLifeInsuranceCertificateInquiryAction policyInquiry() {
        return AutomationContext.getAction(TermLifeInsuranceCertificateInquiryAction.class);
    }

    @Override
    public TermLifeInsuranceCertificateInquiryAction quoteInquiry() {
        return policyInquiry();
    }
}
