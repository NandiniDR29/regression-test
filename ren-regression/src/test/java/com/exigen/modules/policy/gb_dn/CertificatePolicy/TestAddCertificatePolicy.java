/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.policy.gb_dn.CertificatePolicy;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.CommonGenericMethods;
import com.exigen.helpers.SequenceCharcterAndExcelUpdateUtils;
import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.gb_dn.certificatepolicy.CertificatePolicyHelpers;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.GroupDentalCertificatePolicyContext;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.metadata.InsuredTabMetaData;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.tabs.CertificatePolicyTab;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.tabs.InsuredTab;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.tabs.PlansTab;
import com.exigen.ren.main.pages.summary.PolicySummaryPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.basetest.Util.currentTime;
import static com.exigen.helpers.CommonGenericMethods.SaveChildCPNumberForNextValidation;
import static com.exigen.helpers.CommonGenericMethods.createTaxId;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.modules.policy.gb_dn.certificatepolicy.CertificatePolicyHelpers.ssnValidation;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_ACTIVE;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.PREMIUM_CALCULATED;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.metadata.InsuredTabMetaData.TAX_IDENTIFICATION;

public class TestAddCertificatePolicy extends CommonBaseTest implements GroupDentalCertificatePolicyContext{
    @Test(priority = 14)
    public void testAddCertificatePolicy() throws IOException {
        logger = extent.startTest(groupNo + " TestAddCertificatePolicy");
        prop.load(fileInput);
        pName ="other";

        reportLog("Searching for customer: " + prop.getProperty("MPNumber"), 0);
        for (int i = 0; i < 8; i++) {
            search(prop.getProperty("MPNumber"));
            reportLog("Create Certificate Policy with Tier: Employee Only", 1);
            reportLog("Initiate Cp creation", 1);
            groupDentalCertificatePolicy.initiate(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)));
            reportLog("Fill Data Upto Insured Tab", 1);
            groupDentalCertificatePolicy.getDefaultWorkspace().fillFromTo(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployee(groupNo))
                    .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.FIRST_NAME.getLabel()), CertificatePolicyHelpers.selfInsuredFirstName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                    .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.LAST_NAME.getLabel()),  CertificatePolicyHelpers.selfInsuredLastName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                    .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), TAX_IDENTIFICATION.getLabel()), createTaxId()).resolveLinks(), CertificatePolicyTab.class,PlansTab.class);
            ssnValidation(driver);
            reportLog("Fill Data from Coverage tab to Premium calculation tab", 1);
            groupDentalCertificatePolicy.getDefaultWorkspace().fillFrom(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)),PlansTab.class);
            assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(PREMIUM_CALCULATED);
            reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
            reportLog("Issue Certificate Policy", 1);
            groupDentalCertificatePolicy.issue().perform(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
            assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
            reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " created for " + PolicySummaryPage.labelCustomerName.getValue() + " With " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        }
        if(!(groupNo.equalsIgnoreCase("Group13")||groupNo.equalsIgnoreCase("Group17"))){
        for (int i = 0; i < 4; i++) {
            search(prop.getProperty("MPNumber"));
            reportLog("Create Certificate Policy with Tier: Employee+ Spouse", 1);
            reportLog("Initiate Cp creation", 1);
            groupDentalCertificatePolicy.initiate(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)));
            reportLog("Fill Data Upto Insured Tab", 1);
            groupDentalCertificatePolicy.getDefaultWorkspace().fillFromTo(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithSpouse(groupNo))
                    .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.FIRST_NAME.getLabel()), CertificatePolicyHelpers.spouseInsuredFirstName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                    .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.LAST_NAME.getLabel()),  CertificatePolicyHelpers.spouseInsuredLastName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                    .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), TAX_IDENTIFICATION.getLabel()), createTaxId()).resolveLinks(), CertificatePolicyTab.class,PlansTab.class);
            ssnValidation(driver);
            reportLog("Fill Data from Coverage tab to Premium calculation tab", 1);
            groupDentalCertificatePolicy.getDefaultWorkspace().fillFrom(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)),PlansTab.class);
            assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(PREMIUM_CALCULATED);
            reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
            reportLog("Issue Certificate Policy", 1);
            groupDentalCertificatePolicy.issue().perform(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
            assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
            reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " created for " + PolicySummaryPage.labelCustomerName.getValue() + " With " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        }
            for (int i = 0; i < 4; i++) {
                search(prop.getProperty("MPNumber"));
                reportLog("Create Certificate Policy with Tier: Employee Child", 1);
                reportLog("Initiate Cp creation", 1);
                groupDentalCertificatePolicy.initiate(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)));
                reportLog("Fill Data Upto Insured Tab", 1);
                groupDentalCertificatePolicy.getDefaultWorkspace().fillFromTo(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, CommonGenericMethods.testdataSelectionForEmployeeWithChild(groupNo) )
                        .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.FIRST_NAME.getLabel()), CertificatePolicyHelpers.childInsuredFirstName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                        .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.LAST_NAME.getLabel()),  CertificatePolicyHelpers.childInsuredLastName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                        .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), TAX_IDENTIFICATION.getLabel()), createTaxId()).resolveLinks(), CertificatePolicyTab.class,PlansTab.class);
                    ssnValidation(driver);
                reportLog("Fill Data from Coverage tab to Premium calculation tab", 1);
                groupDentalCertificatePolicy.getDefaultWorkspace().fillFrom(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)),PlansTab.class);
                assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(PREMIUM_CALCULATED);
                reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
                reportLog("Issue Certificate Policy", 1);
                groupDentalCertificatePolicy.issue().perform(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
                assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
                reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " created for " + PolicySummaryPage.labelCustomerName.getValue() + " With " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);

            }
            SaveChildCPNumberForNextValidation(PolicySummaryPage.labelPolicyNumber.getValue());
        }

        else{
            for (int i = 0; i < 4; i++) {
                search(prop.getProperty("MPNumber"));
                reportLog("Create Certificate Policy with Tier: Employee + 1", 1);
                reportLog("Initiate Cp creation", 1);
                groupDentalCertificatePolicy.initiate(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)));
                reportLog("Fill Data Upto Insured Tab", 1);
                groupDentalCertificatePolicy.getDefaultWorkspace().fillFromTo(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, CommonGenericMethods.testdataSelectionForEmployeeWithOneChild(groupNo))
                        .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.FIRST_NAME.getLabel()), CertificatePolicyHelpers.selfOneChildInsuredFirstName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                        .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.LAST_NAME.getLabel()),  CertificatePolicyHelpers.selfOneChildInsuredLastName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                        .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), TAX_IDENTIFICATION.getLabel()), createTaxId()).resolveLinks(), CertificatePolicyTab.class,PlansTab.class);
                    ssnValidation(driver);
                reportLog("Fill Data from Coverage tab to Premium calculation tab", 1);
                groupDentalCertificatePolicy.getDefaultWorkspace().fillFrom(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)),PlansTab.class);
                assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(PREMIUM_CALCULATED);
                reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
                reportLog("Issue Certificate Policy", 1);
                groupDentalCertificatePolicy.issue().perform(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
                assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
                reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " created for " + PolicySummaryPage.labelCustomerName.getValue() + " With " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
            }
            for (int i = 0; i < 4; i++) {
                search(prop.getProperty("MPNumber"));
                reportLog("Create Certificate Policy with Tier: Employee+ 1", 1);
                reportLog("Initiate Cp creation", 1);
                groupDentalCertificatePolicy.initiate(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)));
                reportLog("Fill Data Upto Insured Tab", 1);
                groupDentalCertificatePolicy.getDefaultWorkspace().fillFromTo(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo))
                        .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.FIRST_NAME.getLabel()), CertificatePolicyHelpers.selfOneSpouseInsuredFirstName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                        .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.LAST_NAME.getLabel()),  CertificatePolicyHelpers.selfOneSpouseInsuredLastName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                        .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), TAX_IDENTIFICATION.getLabel()), createTaxId()).resolveLinks(), CertificatePolicyTab.class,PlansTab.class);
                    ssnValidation(driver);
                reportLog("Fill Data from Coverage tab to Premium calculation tab", 1);
                groupDentalCertificatePolicy.getDefaultWorkspace().fillFrom(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)),PlansTab.class);
                assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(PREMIUM_CALCULATED);
                reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
                reportLog("Issue Certificate Policy", 1);
                groupDentalCertificatePolicy.issue().perform(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
                assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
                reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " created for " + PolicySummaryPage.labelCustomerName.getValue() + " With " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
            }
        }

        for (int i = 0; i < 4; i++) {
            search(prop.getProperty("MPNumber"));
            reportLog("Create Certificate Policy with Tier: Employee + Family", 1);
            reportLog("Initiate Cp creation", 1);
            groupDentalCertificatePolicy.initiate(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)));
            reportLog("Fill Data Upto Insured Tab", 1);
            groupDentalCertificatePolicy.getDefaultWorkspace().fillFromTo(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo))
                    .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.FIRST_NAME.getLabel()), CertificatePolicyHelpers.familyInsuredFirstName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                    .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), InsuredTabMetaData.LAST_NAME.getLabel()),  CertificatePolicyHelpers.familyInsuredLastName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                    .adjust(TestData.makeKeyPath(InsuredTab.class.getSimpleName(), TAX_IDENTIFICATION.getLabel()), createTaxId()).resolveLinks(), CertificatePolicyTab.class,PlansTab.class);
            ssnValidation(driver);
            reportLog("Fill Data from Coverage tab to Premium calculation tab", 1);
            groupDentalCertificatePolicy.getDefaultWorkspace().fillFrom(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER,  CommonGenericMethods.testdataSelectionForEmployeeWithFamily(groupNo)),PlansTab.class);
            assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(PREMIUM_CALCULATED);
            reportLog(PolicySummaryPage.labelPolicyNumber.getValue()+" Status is: "+PolicySummaryPage.labelPolicyStatus.getValue(), 1);
            reportLog("Issue Certificate Policy", 1);
            groupDentalCertificatePolicy.issue().perform(groupDentalCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
            assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
            reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " created for " + PolicySummaryPage.labelCustomerName.getValue() + " With " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        }
        LOGGER.info("------------------------------------------------------------------------");
        LOGGER.info("TEST: Group Dental Policy #" + PolicySummaryPage.labelPolicyNumber.getValue());
        reportLog("------------------------------------------------------------------------",1);
    }
}
