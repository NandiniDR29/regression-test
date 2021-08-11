package com.exigen.ren.main.modules.policy.common.pages.certificate;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.common.pages.MainPage;
import com.exigen.ren.main.enums.TableConstants.CertificateCoverages;
import com.exigen.ren.main.enums.TableConstants.CertificateParticipants;
import org.openqa.selenium.By;

import static com.exigen.ren.main.enums.ActionConstants.CHANGE;
import static com.exigen.ren.main.enums.TableConstants.CertificateCoverages.COVERAGE_NAME;
import static com.exigen.ren.main.enums.TableConstants.CertificateParticipants.CUSTOMER_NAME;

public class CoveragesPage extends MainPage {

    public static StaticElement labelFirstName = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantPersonInfoProxy_person_nameInfo_firstName"));
    public static StaticElement labelLastName = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantPersonInfoProxy_person_nameInfo_lastName"));
    public static StaticElement labelMiddleName = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantPersonInfoProxy_person_nameInfo_middleName"));
    public static StaticElement labelGender = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantPersonInfoProxy_person_gender"));
    public static StaticElement labelDateOfBirth = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantPersonInfoProxy_person_dateOfBirthInputDate"));
    public static StaticElement labelAttainedAge = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantPersonInfoProxy_person_generalPartyInfoExt_attainedAge"));
    public static Button buttonViewTaxIdentification = new Button(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantPersonInfoProxy_person_legalIdentificationUnmaskBtn"));
    public static StaticElement labelTaxIdentification = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantPersonInfoProxy_person_legalIdentification"));
    public static StaticElement labelSuffix = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantPersonInfoProxy_person_nameInfo_suffix"));
    public static StaticElement labelEnrollmentDate = new StaticElement(By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupCertificateCoverageDetail_enrollmentDateInputDate' or @id='policyDataGatherForm:sedit_GroupCertificateCoverageDetail_enrollmentDateInputDate']"));

    public static StaticElement labelAddressType = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantContactInfoProxy_addressEntity_addressType"));
    public static StaticElement labelCountry = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantContactInfoProxy_addressEntity_address_countryCd"));
    public static StaticElement labelZipPostCode = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantContactInfoProxy_addressEntity_address_postalCode"));
    public static StaticElement labelCity = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantContactInfoProxy_addressEntity_address_city"));
    public static StaticElement labelStateProvince = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantContactInfoProxy_addressEntity_address_stateProvCd"));
    public static StaticElement labelAddressLine1 = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantContactInfoProxy_addressEntity_address_addressLine1"));
    public static StaticElement labelAddressLine2 = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantContactInfoProxy_addressEntity_address_addressLine2"));
    public static StaticElement labelAddressLine3 = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantContactInfoProxy_addressEntity_address_addressLine3"));
    public static StaticElement labelRelationshipToInsured = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateParticipantPersonInfoProxy_person_generalPartyInfoExt_relationshipToInsuredPrincipal"));
    public static StaticElement labelCoverageTier = new StaticElement(By.id("policyDataGatherForm:sedit_PreconfigGroupCertificateCoverageDetail_coverageTier"));
    public static StaticElement labelPlanName = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificatePlan_policyPlan"));
    public static StaticElement labelAnnualEarnings = new StaticElement(By.id("policyDataGatherForm:sedit_PreconfigGroupCertCovSalaryPctBenefitSelection_salary_label"));
    public static StaticElement labelClassName = new StaticElement(By.id("policyDataGatherForm:sedit_GroupCertificateCoverageDetail_classificationGroupName"));

    public static final TableExtended<CertificateParticipants> tableParticipantsList = new TableExtended<>("Participants", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant']/div/table"));
    public static final TableExtended<CertificateCoverages> tableCoveragesList = new TableExtended<>("Coverages", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupCertificateParticipantGroup']/div/table"));

    public static void changeCoverageTo(String coverageName) {
        LOGGER.info(String.format("Change coverage to: '%s'", coverageName));
        tableCoveragesList.getRow(COVERAGE_NAME.getName(), coverageName).getCell(6).controls.links.get(CHANGE).click();
    }

    public static void changeParticipantTo(String participantName) {
        LOGGER.info(String.format("Change participant to: '%s'", participantName));
        tableParticipantsList.getRow(CUSTOMER_NAME.getName(), participantName).getCell(6).controls.links.get(CHANGE).click();
    }
}