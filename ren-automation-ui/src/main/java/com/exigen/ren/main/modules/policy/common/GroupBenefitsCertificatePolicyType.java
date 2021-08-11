/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.common;

import com.exigen.ren.main.modules.policy.gb_ac.certificate.GroupAccidentCertificatePolicy;
import com.exigen.ren.main.modules.policy.gb_di_ltd.certificate.LongTermDisabilityCertificatePolicy;
import com.exigen.ren.main.modules.policy.gb_di_std.certificate.ShortTermDisabilityCertificatePolicy;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.GroupDentalCertificatePolicy;
import com.exigen.ren.main.modules.policy.gb_eap.certificate.EmployeeAssistanceProgramCertificatePolicy;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.TermLifeInsuranceCertificatePolicy;
import com.exigen.ren.main.modules.policy.gb_vs.certificate.GroupVisionCertificatePolicy;

public class GroupBenefitsCertificatePolicyType extends PolicyType {

    protected GroupBenefitsMasterPolicyType masterPolicyType;

    public static final GroupBenefitsCertificatePolicyType GB_AC = new GroupBenefitsCertificatePolicyType("GB_AC", "Group Accident", new GroupAccidentCertificatePolicy(), GroupBenefitsMasterPolicyType.GB_AC);
    public static final GroupBenefitsCertificatePolicyType GB_TL = new GroupBenefitsCertificatePolicyType("GB_TL", "Term Life Insurance", new TermLifeInsuranceCertificatePolicy(), GroupBenefitsMasterPolicyType.GB_TL);
    public static final GroupBenefitsCertificatePolicyType GB_DI_STD = new GroupBenefitsCertificatePolicyType("GB_DI_STD", "Short Term Disability", new ShortTermDisabilityCertificatePolicy(), GroupBenefitsMasterPolicyType.GB_DI_STD);
    public static final GroupBenefitsCertificatePolicyType GB_DI_LTD = new GroupBenefitsCertificatePolicyType("GB_DI_LTD", "Long Term Disability", new LongTermDisabilityCertificatePolicy(), GroupBenefitsMasterPolicyType.GB_DI_LTD);
    public static final GroupBenefitsCertificatePolicyType GB_DN = new GroupBenefitsCertificatePolicyType("GB_DN", "Group Dental", new GroupDentalCertificatePolicy(), GroupBenefitsMasterPolicyType.GB_DN);
    public static final GroupBenefitsCertificatePolicyType GB_VS = new GroupBenefitsCertificatePolicyType("GB_VS", "Group Vision", new GroupVisionCertificatePolicy(), GroupBenefitsMasterPolicyType.GB_VS);
    public static final GroupBenefitsCertificatePolicyType GB_EAP = new GroupBenefitsCertificatePolicyType("GB_EAP", "Employee Assistance Program", new EmployeeAssistanceProgramCertificatePolicy(), GroupBenefitsMasterPolicyType.GB_EAP);

    private GroupBenefitsCertificatePolicyType(String shortName, String fullName, GroupBenefitsCertificatePolicy policy, GroupBenefitsMasterPolicyType masterPolicyType) {
        super(shortName, fullName, policy);
        this.masterPolicyType = masterPolicyType;
    }

    @Override
    public GroupBenefitsCertificatePolicy get() {
        return (GroupBenefitsCertificatePolicy) policy;
    }

    public GroupBenefitsMasterPolicyType getMasterPolicyType() {
        return masterPolicyType;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object anObject) {
        return super.equals(anObject);
    }
}
