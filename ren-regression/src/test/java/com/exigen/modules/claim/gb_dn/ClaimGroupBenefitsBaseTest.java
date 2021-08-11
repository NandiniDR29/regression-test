/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.claim.gb_dn;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.istf.data.TestData;
import com.exigen.ren.main.modules.caseprofile.CaseProfileContext;
import com.exigen.ren.main.modules.claim.GroupBenefitsClaimType;
import com.exigen.ren.main.modules.claim.IClaim;
import com.exigen.ren.main.modules.claim.common.metadata.AdditionalPartiesAdditionalPartyActionTabMetaData;
import com.exigen.ren.main.modules.claim.common.metadata.EventInformationLossEventActionTabMetaData;
import com.exigen.ren.main.modules.claim.common.tabs.AdditionalPartiesAdditionalPartyActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.EventInformationLossEventActionTab;
import com.exigen.ren.main.modules.customer.CustomerContext;

import java.util.HashMap;
import java.util.Map;

public abstract class ClaimGroupBenefitsBaseTest extends CommonBaseTest implements CustomerContext, CaseProfileContext {

    protected static final String approvalUsername = "TestUserForClaimApproval";
    protected static final String approvalPassword = "qa";
    protected IClaim claim;
    protected TestData tdClaim;

    public ClaimGroupBenefitsBaseTest() {
        claim = getClaimType().get();
        tdClaim = testDataManager.groupBenefitsClaims.get(getClaimType());
    }

    protected abstract GroupBenefitsClaimType getClaimType();

    protected Map<String, String> storeDataForVerification(String testDataFile) {
        Map<String, String> mapValues = new HashMap<>();

        TestData tdLossEvent = tdClaim.getTestData(testDataFile, "TestData").getTestData(
                EventInformationLossEventActionTab.class.getSimpleName());
        TestData tdAddParty = tdClaim.getTestData(testDataFile, "TestData").getTestData(
                AdditionalPartiesAdditionalPartyActionTab.class.getSimpleName());

        mapValues.put("Description of Loss", tdLossEvent.getValue(
                EventInformationLossEventActionTabMetaData.DESCRIPTION_OF_LOSS.getLabel()));

        mapValues.put("Party Name", String.format("%s %s",
                tdAddParty.getValue(AdditionalPartiesAdditionalPartyActionTabMetaData.FIRST_NAME.getLabel()),
                tdAddParty.getValue(AdditionalPartiesAdditionalPartyActionTabMetaData.LAST_NAME.getLabel())));
        mapValues.put("Address", String.format("%s, %s, %s", tdAddParty.getValue(AdditionalPartiesAdditionalPartyActionTabMetaData.CITY.getLabel()),
                tdAddParty.getValue(AdditionalPartiesAdditionalPartyActionTabMetaData.STATE_PROVINCE.getLabel()), tdAddParty.
                        getValue(AdditionalPartiesAdditionalPartyActionTabMetaData.ZIP_POSTAL_CODE.getLabel())));

        return mapValues;
    }

}
