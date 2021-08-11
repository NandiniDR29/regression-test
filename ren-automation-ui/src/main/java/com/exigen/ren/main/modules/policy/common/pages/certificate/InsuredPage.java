package com.exigen.ren.main.modules.policy.common.pages.certificate;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.common.pages.MainPage;
import org.openqa.selenium.By;

public class InsuredPage extends MainPage {

    public static StaticElement labelFirstName = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantPersonInfoProxy_person_nameInfo_firstName"));
    public static StaticElement labelLastName = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantPersonInfoProxy_person_nameInfo_lastName"));
    public static StaticElement labelMiddleName = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantPersonInfoProxy_person_nameInfo_middleName"));
    public static StaticElement labelSuffix = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantPersonInfoProxy_person_nameInfo_suffix"));
    public static StaticElement labelGender = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantPersonInfoProxy_person_gender"));
    public static StaticElement labelDateOfBirth = new StaticElement(By.xpath("//span[@id='policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantPersonInfoProxy_person_dateOfBirthPopup']/input[1]"));
    public static Button buttonViewTaxIdentification = new Button(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantPersonInfoProxy_person_legalIdentificationUnmaskBtn"));
    public static StaticElement labelTaxIdentification = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantPersonInfoProxy_person_legalIdentification"));
    public static StaticElement labelEmail = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantEmailProxy_emailEntity_email"));
    public static StaticElement labelZipPostCode = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantContactInfoProxy_addressEntity_address_postalCode"));
    public static StaticElement labelStateProvince = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantContactInfoProxy_addressEntity_address_stateProvCd"));
    public static StaticElement labelAddressLine1 = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantContactInfoProxy_addressEntity_address_addressLine1"));
    public static StaticElement labelAddressLine2 = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantContactInfoProxy_addressEntity_address_addressLine2"));
    public static StaticElement labelAddressLine3 = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePrimaryParticipantContactInfoProxy_addressEntity_address_addressLine3"));
    public static StaticElement labelOriginalHireDate = new StaticElement(By.xpath("//input[@id='policyDataGatherForm:sedit_GroupCertificatePolicyRelationshipEmpInfo_startDateInputDate']"));
    public static StaticElement labelClassificationGroup = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateEligibilityInformation_classificationGroup"));
    public static StaticElement labelPayType = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePolicyRelationshipEmpInfo_payType"));
    public static StaticElement labelSalaryAmount = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePolicyRelationshipEmpInfo_salaryAmount"));
}