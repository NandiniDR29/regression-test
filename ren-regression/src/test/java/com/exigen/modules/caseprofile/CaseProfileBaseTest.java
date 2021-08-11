/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.modules.caseprofile;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.istf.data.TestData;
import com.exigen.ren.main.modules.caseprofile.CaseProfileContext;
import com.exigen.ren.main.modules.caseprofile.CaseProfileType;

public class CaseProfileBaseTest extends CommonBaseTest implements CaseProfileContext {

    protected TestData tdCaseProfile = testDataManager.caseProfile.get(CaseProfileType.CASE_PROFILE);
    protected String caseProfileNumber, caseProfileName;
}
