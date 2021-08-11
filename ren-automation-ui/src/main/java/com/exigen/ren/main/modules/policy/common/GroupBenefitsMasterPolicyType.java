/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.common;

import com.exigen.ren.main.modules.policy.gb_ac.masterpolicy.GroupAccidentMasterPolicy;
import com.exigen.ren.main.modules.policy.gb_di_ltd.masterpolicy.LongTermDisabilityMasterPolicy;
import com.exigen.ren.main.modules.policy.gb_di_std.masterpolicy.ShortTermDisabilityMasterPolicy;
import com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.GroupDentalMasterPolicy;
import com.exigen.ren.main.modules.policy.gb_eap.masterpolicy.EmployeeAssistanceProgramMasterPolicy;
import com.exigen.ren.main.modules.policy.gb_pfl.masterpolicy.PaidFamilyLeaveMasterPolicy;
import com.exigen.ren.main.modules.policy.gb_st.masterpolicy.StatutoryDisabilityInsuranceMasterPolicy;
import com.exigen.ren.main.modules.policy.gb_tl.masterpolicy.TermLifeInsuranceMasterPolicy;
import com.exigen.ren.main.modules.policy.gb_vs.masterpolicy.GroupVisionMasterPolicy;
import com.google.common.collect.ImmutableList;

import java.security.SecureRandom;

public class GroupBenefitsMasterPolicyType extends PolicyType {
    public static final GroupBenefitsMasterPolicyType GB_AC = new GroupBenefitsMasterPolicyType("GB_AC", "Group Accident", new GroupAccidentMasterPolicy());
    public static final GroupBenefitsMasterPolicyType GB_TL = new GroupBenefitsMasterPolicyType("GB_TL", "Term Life Insurance", new TermLifeInsuranceMasterPolicy());
    public static final GroupBenefitsMasterPolicyType GB_DI_STD = new GroupBenefitsMasterPolicyType("GB_DI_STD", "Short Term Disability", new ShortTermDisabilityMasterPolicy());
    public static final GroupBenefitsMasterPolicyType GB_DI_LTD = new GroupBenefitsMasterPolicyType("GB_DI_LTD", "Long Term Disability", new LongTermDisabilityMasterPolicy());
    public static final GroupBenefitsMasterPolicyType GB_ST = new GroupBenefitsMasterPolicyType("GB_ST", "Statutory Disability Insurance", new StatutoryDisabilityInsuranceMasterPolicy());
    public static final GroupBenefitsMasterPolicyType GB_DN = new GroupBenefitsMasterPolicyType("GB_DN", "Group Dental", new GroupDentalMasterPolicy());
    public static final GroupBenefitsMasterPolicyType GB_VS = new GroupBenefitsMasterPolicyType("GB_VS", "Group Vision", new GroupVisionMasterPolicy());
    public static final GroupBenefitsMasterPolicyType GB_PFL = new GroupBenefitsMasterPolicyType("GB_PFL", "Paid Family Leave", new PaidFamilyLeaveMasterPolicy());
    public static final GroupBenefitsMasterPolicyType GB_EAP = new GroupBenefitsMasterPolicyType("GB_EAP", "Employee Assistance Program", new EmployeeAssistanceProgramMasterPolicy());

    public static final ImmutableList<GroupBenefitsMasterPolicyType> policyTypes =
            ImmutableList.of(GB_AC, GB_TL, GB_DI_STD, GB_DI_LTD, GB_ST, GB_DN, GB_VS, GB_PFL);

    private GroupBenefitsMasterPolicyType(String shortName, String fullName, GroupBenefitsMasterPolicy policy) {
        super(shortName, fullName, policy);
    }

    @Override
    public GroupBenefitsMasterPolicy get() {
        return (GroupBenefitsMasterPolicy) policy;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object anObject) {
        return super.equals(anObject);
    }

    public static GroupBenefitsMasterPolicyType getRandomMasterPolicyType() {
        return policyTypes.get(new SecureRandom().nextInt(policyTypes.size()));
    }
}
