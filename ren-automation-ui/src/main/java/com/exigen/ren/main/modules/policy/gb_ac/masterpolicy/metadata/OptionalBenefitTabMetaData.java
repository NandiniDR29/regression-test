/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.ren.main.modules.policy.gb_ac.masterpolicy.metadata;

import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class OptionalBenefitTabMetaData extends MetaData {

    public static final AssetDescriptor<RadioGroup> INCLUDE_OPTIONAL_BENEFITS = declare("Include Optional Benefits?", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> NUMBER_OF_UNITS = declare("Number of Units", ComboBox.class);

    public static final AssetDescriptor<AssetList> ACCIDENTAL_DEATH_BENEFIT = declare("Accidental Death Benefit", AssetList.class, AccidentalDeathBenefitMetadata.class);
    public static final AssetDescriptor<AssetList> ENHANCED_EMERGENCY_ROOM_TREATMENT_BENEFIT = declare("Enhanced Emergency Room Treatment Benefit", AssetList.class, EnhancedEmergencyRoomTreatmentBenefitMetadata.class);
    public static final AssetDescriptor<AssetList> ENHANCED_PHYSICIAN_SOFFICE_URGENT_CARE_TREATMENT_BENEFIT = declare("Enhanced Physician's Office/Urgent Care Treatment Benefit", AssetList.class, EnhancedPhysicianSofficeUrgentCareTreatmentBenefitMetadata.class);
    public static final AssetDescriptor<AssetList> HOSPITAL_CONFINEMENT_BENEFIT = declare("Hospital Confinement Benefit", AssetList.class, HospitalConfinementBenefitMetadata.class);
    public static final AssetDescriptor<AssetList> HOSPITAL_ICU_CONFINEMENT_BENEFIT = declare("Hospital ICU Confinement Benefit", AssetList.class, HospitalIcuConfinementBenefitMetadata.class);
    public static final AssetDescriptor<AssetList> WAIVER_OF_PREMIUM_BENEFIT = declare("Waiver Of Premium Benefit", AssetList.class, WaiverOfPremiumBenefitMetadata.class);
    public static final AssetDescriptor<AssetList> HEALTH_SCREENING_BENEFIT = declare("Health Screening Benefit", AssetList.class, HealthScreeningBenefitMetadata.class);

    public static final class AccidentalDeathBenefitMetadata extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_ADB = declare("Apply Benefit Accidental Death Benefit", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_RENGroupAccAccDeathOPTBenefit_applied']"));
        public static final AssetDescriptor<TextBox> ACCIDENTAL_DEATH_BENEFIT_AMOUNT_EMPLOYEE = declare("Accidental Death Benefit Amount - Employee", TextBox.class);
        public static final AssetDescriptor<TextBox> ACCIDENTAL_DEATH_BENEFIT_AMOUNT_SPOUSE = declare("Accidental Death Benefit Amount - Spouse", TextBox.class);
        public static final AssetDescriptor<TextBox> ACCIDENTAL_DEATH_BENEFIT_AMOUNT_CHILD = declare("Accidental Death Benefit Amount - Child", TextBox.class);
    }

    public static final class EnhancedEmergencyRoomTreatmentBenefitMetadata extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_EERTB = declare("Apply Benefit Enhanced Emergency Room Treatment Benefit", CheckBox.class,
                By.xpath("//input[@id='policyDataGatherForm:sedit_RENGroupAccEmergencyCareOPTBenefit_applied']"));
        public static final AssetDescriptor<TextBox> ENHANCED_EMERGENCY_ROOM_TREATMENT_BENEFIT_AMOUNT = declare("Enhanced Emergency Room Treatment Benefit Amount", TextBox.class);
    }

    public static final class EnhancedPhysicianSofficeUrgentCareTreatmentBenefitMetadata extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_EPCTB = declare("Apply Benefit Enhanced Physician's Office/Urgent Care Treatment Benefit", CheckBox.class,
                By.xpath("//input[@id='policyDataGatherForm:sedit_RENGroupAccPhysicianOfficeCareOPTBenefit_applied']"));
        public static final AssetDescriptor<TextBox> ENHANCED_PHYSICIAN_OFFICE_URGENT_CARE_TREATMENT_BENEFIT_AMOUNT = declare("Enhanced Physician's Office/Urgent Care Treatment Benefit Amount", TextBox.class);
    }

    public static final class HospitalConfinementBenefitMetadata extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_HCB = declare("Apply Benefit Hospital Confinement Benefit", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_RENGroupAccHospitalConfinementOPTBenefit_applied']"));
        public static final AssetDescriptor<TextBox> HOSPITAL_CONFINEMENT_BENEFIT_AMOUNT = declare("Hospital Confinement Benefit Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> MAXIMUM_BENEFIT_PERIOD_DAYS_HCB = declare("Maximum Benefit Period Hospital Confinement Benefit", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_RENGroupAccHospitalConfinementOPTBenefit_incurralPeriodDays']"));
    }

    public static final class HospitalIcuConfinementBenefitMetadata extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_HICUCB = declare("Apply Benefit Hospital ICU Confinement Benefit", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_RENGroupAccHospitalICUConfinementOPTBenefit_applied']"));
        public static final AssetDescriptor<TextBox> HOSPITAL_ICU_CONFINEMENT_BENEFIT_AMOUNT = declare("Hospital ICU Confinement Benefit Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> MAXIMUM_BENEFIT_PERIOD_DAYS_HICUCB = declare("Maximum Benefit Period Hospital ICU Confinement Benefit Amount", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_RENGroupAccHospitalICUConfinementOPTBenefit_incurralPeriodDays']"));
    }

    public static final class WaiverOfPremiumBenefitMetadata extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_WPB = declare("Apply Benefit Waiver Of Premium Benefit", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_RENGroupAccWaiverOfPremiumBenefit_applied']"));
        public static final AssetDescriptor<ComboBox> ELIMINATION_BENEFIT_PERIOD = declare("Elimination/Benefit Period", ComboBox.class);
    }

    public static final class HealthScreeningBenefitMetadata extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_HSB = declare("Apply Benefit?", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_RenHealthScreeningBenefit_applied']"));
        public static final AssetDescriptor<ComboBox> TYPE_OF_INCURRAL_PERIOD_HSB = declare("Type of Incurral Period", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_RenHealthScreeningBenefit_typeOfIncurralPeriod']"));
        public static final AssetDescriptor<TextBox> INCURRAL_PERIOD = declare("Incurral Period", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_RenHealthScreeningBenefit_incurralPeriodDays']"));
        public static final AssetDescriptor<TextBox> HEALTH_SCREENING_BENEFIT_AMOUNT = declare("Health Screening Benefit Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> MAXIMUM_NUMBER_OF_TESTS_FOR_HSB = declare("Maximum number of tests for the Health Screening Benefit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TIME_PERIOD_HSB = declare("Time Period", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_RenHealthScreeningBenefit_timePeriod']"));
    }
}
