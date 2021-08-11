/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.ren.main.modules.policy.gb_ac.masterpolicy.metadata;

import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.pages.Page.DEFAULT_ASSETLIST_CONTAINER;

public class EnhancedBenefitsHtoLTabMetaData extends MetaData {
    public static final AssetDescriptor<AssetList> LACERATION_BENEFIT_INFO = declare("Laceration Benefit", AssetList.class, LacerationBenefitMetaData.class,
            By.xpath(DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> LODGING_BENEFIT = declare("Lodging Benefit", AssetList.class, LodgingBenefitMetaData.class, By.xpath(DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> LOSS_OF_FINGER_TOE_HAND_FOOT_OR_SIGHT_OF_AN_EYE_BENEFIT = declare("Loss of Finger, Toe, Hand, Foot or Sight of an Eye Benefit", AssetList.class, LossOfFingerToeHandFootOrSightOfAnEyeBenefitMetaData.class, By.xpath(DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> INTERNAL_ORGAN_LOSS_BENEFIT = declare("Internal Organ Loss Benefit", AssetList.class, InternalOrganLossBenefitMetaData.class, By.xpath(DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> HOSPITAL_ADMISSION_BENEFIT = declare("Hospital Admission Benefit", AssetList.class, HospitalAdmissionBenefitMetaData.class, By.xpath(DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> HOSPITAL_ICU_CONFINEMENT_BENEFIT = declare("Hospital ICU Confinement Benefit", AssetList.class, HospitalICUConfinementBenefitMetaData.class, By.xpath(DEFAULT_ASSETLIST_CONTAINER));

    public static final class LacerationBenefitMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_LACERATION = declare("Apply Benefit?", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccLacerationBenefit_applied']"));
        public static final AssetDescriptor<TextBox> TREATMENT_PERIOD_DAYS_LACERATION = declare("Treatment Period (days)", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccLacerationBenefit_incurralPeriodDays']"));
        public static final AssetDescriptor<TextBox> REPAIRED_WITHOUT_STITCHES_BENEFIT_AMOUNT = declare("Repaired Without Stitches, Sutures or Staples Benefit Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> BENEFIT_AMOUNT_FOR_LACERATION_LESS_THAN = declare("Benefit Amount for Lacerations less than 7.5 cm long", TextBox.class);
        public static final AssetDescriptor<TextBox> BENEFIT_AMOUNT_FOR_LACERATION = declare("Benefit Amount for Lacerations 7.5 cm to 12.5 cm long", TextBox.class);
        public static final AssetDescriptor<TextBox> BENEFIT_AMOUNT_FOR_LACERATION_OVER = declare("Benefit Amount for Lacerations over 12.5 cm long", TextBox.class);
    }

    public static final class LossOfFingerToeHandFootOrSightOfAnEyeBenefitMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT = declare("Apply Benefit?", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccBasicDismembermentLossBenefit_applied']"));
        public static final AssetDescriptor<TextBox> INCURRAL_PERIOD_DAYS = declare("Incurral Period (days)", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccBasicDismembermentLossBenefit_incurralPeriodDays']"));
        public static final AssetDescriptor<TextBox> LOSS_OF_ONE_FINGER_OR_ONE_TOE_EMPLOYEE = declare("Loss of one finger or one toe - Employee", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_OF_ONE_FINGER_OR_ONE_TOE_SPOUSE = declare("Loss of one finger or one toe - Spouse", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_OF_ONE_FINGER_OR_ONE_TOE_CHILD = declare("Loss of one finger or one toe - Child", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_OF_ONE_HAND_OR_ONE_FOOT_OR_SIGHT_OF_ONE_EYE_EMPLOYEE = declare("Loss of one hand or one foot or sight of one eye - Employee", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_OF_ONE_HAND_OR_ONE_FOOT_OR_SIGHT_OF_ONE_EYE_SPOUSE = declare("Loss of one hand or one foot or sight of one eye - Spouse", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_OF_ONE_HAND_OR_ONE_FOOT_OR_SIGHT_OF_ONE_EYE_CHILD = declare("Loss of one hand or one foot or sight of one eye - Child", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_OF_TWO_OR_MORE_FINGERS_TWO_OR_MORE_TOES_OR_ANY_COMBINATION_OF_TWO_OR_MORE_FINGERS_TO_TOES_EMPLOYEE = declare("Loss of two or more fingers/two or more toes or any combination of two or more fingers to toes - Employee", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_OF_TWO_OR_MORE_FINGERS_TWO_OR_MORE_TOES_OR_ANY_COMBINATION_OF_TWO_OR_MORE_FINGERS_TO_TOES_SPOUSE = declare("Loss of two or more fingers/two or more toes or any combination of two or more fingers to toes - Spouse", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_OF_TWO_OR_MORE_FINGERS_TWO_OR_MORE_TOES_OR_ANY_COMBINATION_OF_TWO_OR_MORE_FINGERS_TO_TOES_CHILD = declare("Loss of two or more fingers/two or more toes or any combination of two or more fingers to toes - Child", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_OF_BOTH_HANDS_OR_BOTH_FEET_OR_SIGHT_IN_BOTH_EYES_OR_ANY_COMBINATION_OF_TWO_EMPLOYEE = declare("Loss of both hands or both feet or sight in both eyes or any combination of two - Employee", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_OF_BOTH_HANDS_OR_BOTH_FEET_OR_SIGHT_IN_BOTH_EYES_OR_ANY_COMBINATION_OF_TWO_SPOUSE = declare("Loss of both hands or both feet or sight in both eyes or any combination of two - Spouse", TextBox.class);
        public static final AssetDescriptor<TextBox> LOSS_OF_BOTH_HANDS_OR_BOTH_FEET_OR_SIGHT_IN_BOTH_EYES_OR_ANY_COMBINATION_OF_TWO_CHILD = declare("Loss of both hands or both feet or sight in both eyes or any combination of two - Child", TextBox.class);
    }

    public static final class LodgingBenefitMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> CONFINEMENT_LODGING_BENEFIT_AMOUNT = declare("Confinement Lodging Benefit Amount", TextBox.class);
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_LODGING = declare("Apply Benefit?", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccConfinementLodgingBenefit_applied']"));
        public static final AssetDescriptor<ComboBox> MAXIMUM_NUMBER_OF_DAYS_FOR_THE_CONFINEMENT_LODGING_BENEFIT = declare("Maximum number of days for the Confinement Lodging Benefit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TIME_PERIOD_LODGING = declare("Time Period", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_PreconfigGroupAccConfinementLodgingBenefit_timePeriod']"));
    }

    public static final class InternalOrganLossBenefitMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_INTERNAL_ORGAN = declare("Apply Benefit?", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_RenInternalOrganLossBenefit_applied']"));
        public static final AssetDescriptor<TextBox> INTERNAL_ORGAN_LOSS_BENEFIT_AMOUNT = declare("Internal Organ Loss Benefit Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> TREATMENT_PERIOD_DAYS_INTERNAL_ORGAN = declare("Treatment Period (days)", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_RenInternalOrganLossBenefit_incurralPeriodDays']"));
    }

    public static final class HospitalAdmissionBenefitMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_HOSPITAL_ADMISSION = declare("Apply Benefit?", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupHospitalAdmissionBenefitEnhanced_applied']"));
        public static final AssetDescriptor<TextBox> INCURRAL_PERIOD_HOSPITAL_ADMISSION = declare("Incurral Period (days)", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupHospitalAdmissionBenefitEnhanced_incurralPeriodDays']"));
        public static final AssetDescriptor<TextBox> HOSPITAL_ADMISSION_BENEFIT_AMOUNT = declare("Hospital Admission Benefit Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> INTENSIVE_CARE_UNIT_ADMISSION_BENEFIT_AMOUNT = declare("Intensive Care Unit Admission Benefit Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> TIME_PERIOD = declare("Time Period", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_PreconfigGroupHospitalAdmissionBenefitViewOnlyEnhanced_timePeriod']"));
    }

    public static final class HospitalICUConfinementBenefitMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_HOSPITAL_ICU = declare("Apply Benefit?", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccHospitalConfinementBenefit_applied']"));
        public static final AssetDescriptor<TextBox> INCURRAL_PERIOD_HOSPITAL_ICU = declare("Incurral Period (days)", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccHospitalConfinementBenefit_incurralPeriodDays']"));
        public static final AssetDescriptor<TextBox> INTENSIVE_CARE_UNIT_CONFINEMENT_BENEFIT_AMOUNT_PER_DAY = declare("Intensive Care Unit Confinement Benefit Amount per day", TextBox.class);
        public static final AssetDescriptor<TextBox> MAXIMUM_ICU_CONFINEMENT_PERIOD = declare("Maximum ICU Confinement Period (days)", TextBox.class);
        public static final AssetDescriptor<ComboBox> TIME_PERIOD = declare("Time Period", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_PreconfigGroupAccHospitalConfineBenefitViewOnly_timePeriod']"));
    }
}
