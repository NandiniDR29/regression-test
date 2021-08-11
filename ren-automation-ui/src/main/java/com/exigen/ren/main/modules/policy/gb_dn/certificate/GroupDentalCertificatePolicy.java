/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.policy.gb_dn.certificate;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsCertificatePolicy;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsCertificatePolicyType;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.actions.GroupDentalCertificateInquiryAction;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.actions.GroupDentalCertificatePolicyDataGatherAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GroupDentalCertificatePolicy implements GroupBenefitsCertificatePolicy {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/policy/gb_dn/certificate");
    protected static final Logger LOGGER = LoggerFactory.getLogger(GroupDentalCertificatePolicy.class);
    @Override
    public GroupBenefitsCertificatePolicyType getType() {
        return GroupBenefitsCertificatePolicyType.GB_DN;
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return dataGather().getWorkspace();
    }

    @Override
    public GroupDentalCertificatePolicyDataGatherAction dataGather() {
        return AutomationContext.getAction(GroupDentalCertificatePolicyDataGatherAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }

    @Override
    public GroupDentalCertificateInquiryAction policyInquiry() {
        return AutomationContext.getAction(GroupDentalCertificateInquiryAction.class);
    }

    @Override
    public GroupDentalCertificateInquiryAction quoteInquiry() {
        return policyInquiry();
    }
}
