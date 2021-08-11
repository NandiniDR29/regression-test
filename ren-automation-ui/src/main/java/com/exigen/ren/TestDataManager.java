/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren;

import com.exigen.istf.data.DataProviderFactory;
import com.exigen.istf.data.TestData;
import com.exigen.ren.common.module.efolder.EfolderType;
import com.exigen.ren.main.modules.account.AccountType;
import com.exigen.ren.main.modules.caseprofile.CaseProfileType;
import com.exigen.ren.main.modules.claim.GroupBenefitsClaimType;
import com.exigen.ren.main.modules.customer.CustomerType;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsCertificatePolicyType;
import com.exigen.ren.main.modules.policy.common.GroupBenefitsMasterPolicyType;
import com.exigen.ren.rest.RESTServiceType;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;

//TODO move test data initialization to appropriate services after all will be refactored
public final class TestDataManager {

    protected DataProviderFactory dataProvider = TestDataProvider.getDefaultTestDataProvider();
    public Map<GroupBenefitsMasterPolicyType, TestData> groupBenefitsMaster = new HashMap<>();
    public Map<GroupBenefitsCertificatePolicyType, TestData> groupBenefitsCertificate = new HashMap<>();

    public Map<GroupBenefitsClaimType, TestData> groupBenefitsClaims = new HashMap<>();
    public EnumMap<CustomerType, TestData> customer = new EnumMap<>(CustomerType.class);
    public EnumMap<AccountType, TestData> account = new EnumMap<>(AccountType.class);
    public EnumMap<CaseProfileType, TestData> caseProfile = new EnumMap<>(CaseProfileType.class);

    public EnumMap<EfolderType, TestData> efolder = new EnumMap<>(EfolderType.class);

    public EnumMap<RESTServiceType, TestData> rest = new EnumMap<>(RESTServiceType.class);

    public TestDataManager() {
        //new approach with common test data storage ends
        groupBenefitsMaster.put(GroupBenefitsMasterPolicyType.GB_AC, dataProvider.get("modules/policy/gb_ac/master"));
        groupBenefitsMaster.put(GroupBenefitsMasterPolicyType.GB_DI_LTD, dataProvider.get("modules/policy/gb_di_ltd/master"));
        groupBenefitsMaster.put(GroupBenefitsMasterPolicyType.GB_DI_STD, dataProvider.get("modules/policy/gb_di_std/master"));
        groupBenefitsMaster.put(GroupBenefitsMasterPolicyType.GB_ST, dataProvider.get("modules/policy/gb_st/master"));
        groupBenefitsMaster.put(GroupBenefitsMasterPolicyType.GB_TL, dataProvider.get("modules/policy/gb_tl/master"));
      //  groupBenefitsMaster.put(GroupBenefitsMasterPolicyType.GB_DN, dataProvider.get("modules/policy/gb_dn/master"));
        groupBenefitsMaster.put(GroupBenefitsMasterPolicyType.GB_PFL, dataProvider.get("modules/policy/gb_pfl/master"));

        groupBenefitsCertificate.put(GroupBenefitsCertificatePolicyType.GB_AC, dataProvider.get("modules/policy/gb_ac/certificate"));
        groupBenefitsCertificate.put(GroupBenefitsCertificatePolicyType.GB_DI_STD, dataProvider.get("modules/policy/gb_di_std/certificate"));
        groupBenefitsCertificate.put(GroupBenefitsCertificatePolicyType.GB_DI_LTD, dataProvider.get("modules/policy/gb_di_ltd/certificate"));
        groupBenefitsCertificate.put(GroupBenefitsCertificatePolicyType.GB_TL, dataProvider.get("modules/policy/gb_tl/certificate"));
     //   groupBenefitsCertificate.put(GroupBenefitsCertificatePolicyType.GB_DN, dataProvider.get("modules/policy/gb_dn/certificate"));

        groupBenefitsClaims.put(GroupBenefitsClaimType.CLAIM_ACC_HEALTH_AC, dataProvider.get("modules/claim/gb_ac"));
        groupBenefitsClaims.put(GroupBenefitsClaimType.CLAIM_DI_LTD, dataProvider.get("modules/claim/gb_ltd"));
        groupBenefitsClaims.put(GroupBenefitsClaimType.CLAIM_DI_ST, dataProvider.get("modules/claim/gb_st"));
        groupBenefitsClaims.put(GroupBenefitsClaimType.CLAIM_DI_STD, dataProvider.get("modules/claim/gb_std"));
        groupBenefitsClaims.put(GroupBenefitsClaimType.CLAIM_TERM_LIFE, dataProvider.get("modules/claim/gb_tl"));
        groupBenefitsClaims.put(GroupBenefitsClaimType.CLAIM_DENTAL, dataProvider.get("modules/claim/gb_dn"));
        groupBenefitsClaims.put(GroupBenefitsClaimType.CLAIM_DI_PFL, dataProvider.get("modules/claim/gb_pfl"));

        customer.put(CustomerType.INDIVIDUAL, dataProvider.get("modules/cem/customer/individual"));
        customer.put(CustomerType.NON_INDIVIDUAL, dataProvider.get("modules/cem/customer/nonindividual"));

        account.put(AccountType.INDIVIDUAL, dataProvider.get("modules/cem/account/individual"));
        account.put(AccountType.NON_INDIVIDUAL, dataProvider.get("modules/cem/account/nonindividual"));

        caseProfile.put(CaseProfileType.CASE_PROFILE, dataProvider.get("modules/caseprofile"));

        rest.put(RESTServiceType.NOTES, dataProvider.get("modules/platform/notes"));
        rest.put(RESTServiceType.BPM, dataProvider.get("modules/platform/mywork"));
        rest.put(RESTServiceType.PARTY_SEARCH, dataProvider.get("modules/party/partysearch"));
        rest.put(RESTServiceType.CUSTOMERS, dataProvider.get("modules/cem/customer"));
        rest.put(RESTServiceType.BILLING, dataProvider.get("modules/billing"));
        rest.put(RESTServiceType.PROVIDER, dataProvider.get("modules/platform/providers"));
        rest.put(RESTServiceType.PRODUCT_DECISION_TABLE, dataProvider.get("modules/productfactory/rest"));

        efolder.put(EfolderType.EFOLDER, dataProvider.get("modules/efolder"));
    }

    public TestData getDefault(Class<?> klass) {
        List<String> path = Arrays.asList(klass.getName().split("\\."));
        return dataProvider.get(StringUtils.join(path.subList(0, path.size() - 1), File.separator).replace(FilenameUtils.separatorsToSystem("com\\exigen\\ren"), ""),
                path.get(path.size() - 1));
    }

    public TestData getCompatibilityTestData() {
        return dataProvider.get("", "TestData");
    }
}
