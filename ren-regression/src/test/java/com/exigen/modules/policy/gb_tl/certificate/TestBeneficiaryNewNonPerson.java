package com.exigen.modules.policy.gb_tl.certificate;

import com.exigen.basetest.CommonBaseTest;
import com.exigen.helpers.SequenceCharcterAndExcelUpdateUtils;
import com.exigen.istf.data.TestData;
import com.exigen.modules.policy.gb_dn.certificatepolicy.CertificatePolicyHelpers;
import com.exigen.ren.TestDataKey;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.TermLifeInsuranceCertificatePolicyContext;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.metadata.InsuredTabMetaData;
import com.exigen.ren.main.pages.summary.CustomerSummaryPage;
import com.exigen.ren.main.pages.summary.PolicySummaryPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.exigen.basetest.Util.currentTime;
import static com.exigen.helpers.CommonGenericMethods.*;
import static com.exigen.istf.verification.CustomAssertions.assertThat;
import static com.exigen.ren.common.pages.MainPage.QuickSearch.search;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.POLICY_ACTIVE;
import static com.exigen.ren.main.enums.ProductConstants.PolicyStatus.PREMIUM_CALCULATED;

public class TestBeneficiaryNewNonPerson extends CommonBaseTest implements TermLifeInsuranceCertificatePolicyContext{

    private static final String ADDRESS_LINE_2_VALUE = "Address Line 2";
    private static final String ADDRESS_LINE_3_VALUE = "Address Line 3";
    @Test(priority = 29)
    public void testBeneficiaryNewNonPersonRulesVerification() throws IOException {
        logger = extent.startTest(groupNo+" TestBeneficiaryNewPerson");
        prop.load(fileInput);
        search(prop.getProperty("CustomerNumber"));
        reportLog("Navigate to termlife Policy section",0);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.POLICY);
        CommonBaseTest.driver.findElement(By.xpath("(//tr[contains(@id,'policyForm:body_policy_list_table_holder:')]//td[contains(text(),'Term Life Insurance')]/..//td//a)[1]")).click();
        com.exigen.modules.policy.common.pages.PolicySummaryPage.labelPolicyStatus.waitForPageUpdate();
        reportLog("Initiate term life certificate policy creation ",1);
        termLifeInsuranceCertificatePolicy.initiate(termLifeInsuranceCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, "TestData2"));
        reportLog("Create term life certificate policy  ",1);
        termLifeInsuranceCertificatePolicy.getDefaultWorkspace().fill(termLifeInsuranceCertificatePolicy.getDefaultTestData(TestDataKey.DATA_GATHER, "TestData2")
                .adjust(TestData.makeKeyPath(insuredTab.getMetaKey(), InsuredTabMetaData.ADDRESS_LINE_2.getLabel()), ADDRESS_LINE_2_VALUE)
                .adjust(TestData.makeKeyPath(insuredTab.getMetaKey(), InsuredTabMetaData.ADDRESS_LINE_3.getLabel()), ADDRESS_LINE_3_VALUE)
                .adjust(TestData.makeKeyPath(insuredTab.getMetaKey(), InsuredTabMetaData.FIRST_NAME.getLabel()), CertificatePolicyHelpers.selfInsuredFirstName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                .adjust(TestData.makeKeyPath(insuredTab.getMetaKey(), InsuredTabMetaData.LAST_NAME.getLabel()), CertificatePolicyHelpers.selfInsuredLastName.concat( SequenceCharcterAndExcelUpdateUtils.getString(Integer.parseInt(currentTime()))))
                .adjust(TestData.makeKeyPath(insuredTab.getMetaKey(), InsuredTabMetaData.TAX_IDENTIFICATION.getLabel()), createTaxId()).resolveLinks());
        assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(PREMIUM_CALCULATED);
        reportLog("Issue certificate policy",1);
        termLifeInsuranceCertificatePolicy.issue().perform(termLifeInsuranceCertificatePolicy.getDefaultTestData(TestDataKey.ISSUE, TestDataKey.DEFAULT_TEST_DATA_KEY));
        assertThat(PolicySummaryPage.labelPolicyStatus).hasValue(POLICY_ACTIVE);
        reportLog(PolicySummaryPage.labelPolicyNumber.getValue() + " created for " + PolicySummaryPage.labelCustomerName.getValue() + " With " + PolicySummaryPage.labelPolicyStatus.getValue(), 1);
        NavigationPage.toMainTab(NavigationEnum.AppMainTabs.CUSTOMER);
        SaveSubscriberForNewNonPerson(CustomerSummaryPage.labelCustomerNumber.getValue());
        reportLog("Subscriber ID"+CustomerSummaryPage.labelCustomerNumber.getValue(),1);
        reportLog("====================================",1);
    }
}