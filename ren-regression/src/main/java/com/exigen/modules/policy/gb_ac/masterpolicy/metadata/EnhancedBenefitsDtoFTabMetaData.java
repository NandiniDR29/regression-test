/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.modules.policy.gb_ac.masterpolicy.metadata;

import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.DoubleTextBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.pages.Page.DEFAULT_ASSETLIST_CONTAINER;

public class EnhancedBenefitsDtoFTabMetaData extends MetaData {
    public static final AssetDescriptor<AssetList> DISLOCATION_BENEFIT = declare("Dislocation Benefit", AssetList.class, DislocationBenefitMetaData.class, By.xpath(DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> EYE_INJURY_BENEFIT = declare("Eye Injury Benefit", AssetList.class, EyeInjuryBenefitMetaData.class, By.xpath("//div[@id='policyDataGatherForm:componentView_PreconfigGroupAccEyeInjuryBenefit']"));
    public static final AssetDescriptor<AssetList> FRACTURE_BENEFIT = declare("Fracture Benefit", AssetList.class, FractureBenefitMetaData.class, false, By.xpath(DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> EMERGENCY_ROOM_TREATMENT_BENEFIT = declare("Emergency Room Treatment Benefit", AssetList.class, EmergencyRoomTreatmentBenefitMetaData.class, By.xpath("//div[@id='policyDataGatherForm:componentView_PreconfigGroupAccEmergencyCareBenefitEnhanced']"));
    public static final AssetDescriptor<AssetList> EMERGENCY_DENTAL_BENEFIT = declare("Emergency Dental Benefit", AssetList.class, EmergencyDentalBenefitMetaData.class, By.xpath(DEFAULT_ASSETLIST_CONTAINER));

    public static final class DislocationBenefitMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> DIAGNOSIS_PERIOD_DAYS_DISLOCATION = declare("Diagnosis Period (days)", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccDislocationBenefit_diagnosisPeriodDays']"));
        public static final AssetDescriptor<TextBox> TREATMENT_PERIOD_HOURS_DISLOCATION = declare("Treatment Period (hours)", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccDislocationBenefit_incurralPeriodDays']"));
        public static final AssetDescriptor<DoubleTextBox> LOWER_JAW = declare("Lower Jaw", DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupLowerJawCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> COLLARBONE_STERNOCLAVICULAR = declare("Collarbone (Sternoclavicular)", DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupCollarSternoCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> COLLARBONE_ACROMIOCLAVICULAR_AND_SEPARATION = declare("Collarbone (Acromioclavicular and separation)", DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupCollarAcromioCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> SHOULDER = declare("Shoulder", DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupShoulderCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> ELBOW = declare("Elbow", DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupElbowCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> WRIST = declare("Wrist", DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupWristCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> BONE_BONES_OF_THE_HAND = declare("Bone / Bones of the Hand", DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupHandBoneCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> HIP = declare("Hip", DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupHipCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> KNEE = declare("Knee", DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupKneeCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> ANKLE_BONE_OR_BONES_OF_THE_FOOT = declare("Ankle / Bone or Bones of the Foot", DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupAnkleCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> ONE_OR_MORE_FINGERS_OR_TOES = declare("One or more Fingers or Toes", DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupFingersToesCoveredOption']"));
        public static final AssetDescriptor<ComboBox> INCOMPLETE_DISLOCATION_OR_WITHOUT_ANESTHESIA = declare("Incomplete Dislocation or Without Anesthesia", ComboBox.class);
        public static final AssetDescriptor<TextBox> MAXIMUM_DISLOCATION_BENEFIT_AMOUNT = declare("Maximum Dislocation Benefit Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> TIME_PERIOD = declare("Time Period", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_PreconfigGroupAccDislocationBftViewOnlyCpt_timePeriod']"));
        public static final AssetDescriptor<TextBox> INCURRAL_TIME_PERIOD_DISLOCATION = declare("Incurral Period (days)", TextBox.class);

    }

    public static final class EyeInjuryBenefitMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_EYE_INJURY = declare("Apply Benefit?", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccEyeInjuryBenefit_applied']"));
        public static final AssetDescriptor<TextBox> TREATMENT__PERIOD_DAYS_EYE_INJURY = declare("Treatment Period (days)", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccEyeInjuryBenefit_incurralPeriodDays']"));
        public static final AssetDescriptor<TextBox> INCURRAL_TIME_PERIOD_EYE_INJURY = declare("Incurral Period (days)", TextBox.class);
        public static final AssetDescriptor<TextBox> EYE_INJURY_BENEFIT_AMOUNT = declare("Eye Injury Benefit Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> MAXIMUM_NUMBER_OF_EYE_INJURIES_COVERED_ON_THE_POLICY_PER_TIME_PERIOD = declare("Maximum number of eye injuries covered on the policy per time period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TIME_PERIOD = declare("Time Period", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_PreconfigGroupAccEyeInjuryBenefit_timePeriod']"));
    }

    public static final class FractureBenefitMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> DIAGNOSIS_PERIOD_DAYS_FRACTURE = declare("Diagnosis Period (days)", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccFractureBenefit_diagnosisPeriodDays']"));
        public static final AssetDescriptor<TextBox> TREATMENT_PERIOD_HOURS_FRACTURE = declare("Treatment Period (hours)", TextBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccFractureBenefit_incurralPeriodDays']"));
        public static final AssetDescriptor<DoubleTextBox> FACE_OR_NOSE_EXCEPT_MANDIBLE_OR_MAXILLA = declare("Face or Nose (except mandible or maxilla)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupFaceOrNoseCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> SKULL_FRACTURE_DEPRESSED_EXCEPT_BONES_OF_FACE_AND_NOSE = declare("Skull Fracture - Depressed (except bones of face and nose)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupFractureDepressCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> SKULL_FRACTURE_NON_DEPRESSED_EXCEPT_BONES_OF_FACE_AND_NOSE = declare("Skull Fracture - Non-Depressed (except bones of face and nose)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupFractureNonDepressCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> LOWER_JAW_MANDIBLE_EXCEPT_ALVEOLAR_PROCESS = declare("Lower Jaw / Mandible (except alveolar process)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupFractureLowerJawCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> UPPER_JAW_MAXILLA_EXCEPT_ALVEOLAR_PROCESS = declare("Upper Jaw / Maxilla (except alveolar process)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupUpperJawCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> UPPER_ARM_BETWEEN_ELBOW_AND_SHOULDER = declare("Upper Arm between Elbow and Shoulder (humerus)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupUpperArmCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> SHOULDER_BLADE_SCAPULA_COLLARBONE_CLAVICLE_STERNUM = declare("Shoulder Blade (scapula), Collarbone (clavicle, sternum)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupShoulderBladeCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> FOREARM_RADIUS_AND_OR_ULNA_HAND_WRIST_EXCEPT_FINGERS = declare("Forearm (radius and/or ulna), Hand, Wrist (except fingers)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupForearmHandWristCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> RIB = declare("Rib",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupFractureRibCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> FINGER_TOE = declare("Finger, Toe",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupFingerToeCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> VERTEBRAE_BODY_OF_EXCLUDING_VERTEBRAL_PROCESSES = declare("Vertebrae / Body of (excluding vertebral processes)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupVertebraeCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> VERTEBRAL_PROCESSES = declare("Vertebral Processes",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupVertebralProcessCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> PELVIS_INCLUDES_ILIUM_ISCHIUM_PUBIS_ACETABULUM_EXCEPT_COCCYX = declare("Pelvis (includes ilium, ischium, pubis, acetabulum except coccyx)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupPelvisCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> HIP_THIGH_FEMUR = declare("Hip / Thigh (femur)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupHipThighCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> COCCYX = declare("Coccyx",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupCoccyxCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> LEG_TIBIA_AND_OR_FIBULA = declare("Leg (tibia and/or fibula)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupLegCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> KNEECAP_PATELLA = declare("Kneecap (patella)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupKneecapCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> ANKLE = declare("Ankle",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupFractureAnkleCoveredOption']"));
        public static final AssetDescriptor<DoubleTextBox> FOOT_EXCEPT_TOES = declare("Foot (except toes)",
                DoubleTextBox.class, By.xpath("//div[@id='policyDataGatherForm:componentRow_PreconfigGroupFootCoveredOption']"));
        public static final AssetDescriptor<ComboBox> CHIP_FRACTURE_BENEFIT_AMOUNT = declare("Chip Fracture Benefit Amount", ComboBox.class);
        public static final AssetDescriptor<TextBox> MAXIMUM_FRACTURE_BENEFIT_AMOUNT = declare("Maximum Fracture Benefit Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> TIME_PERIOD_FRACTURE = declare("Time Period", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_PreconfigGroupAccFractureBenefitViewOnly_timePeriod']"));
        public static final AssetDescriptor<TextBox> INCURRAL_TIME_PERIOD_FRACTURE = declare("Incurral Period (days)", TextBox.class);
    }

    public static final class EmergencyRoomTreatmentBenefitMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_EMERGENCY = declare("Apply Benefit?", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccEmergencyCareBenefitEnhanced_applied']"));
        public static final AssetDescriptor<TextBox> INCURRAL_TIME_PERIOD_EMERGENCY = declare("Incurral Period (hours)", TextBox.class);
        public static final AssetDescriptor<TextBox> EMERGENCY_ROOM_BENEFIT_AMOUNT = declare("Emergency Room Benefit Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> TIME_PERIOD_EMERGENCY = declare("Time Period", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_PreconfigGroupAccEmergencyCareBenefitEnhanced_timePeriod']"));
    }

    public static final class EmergencyDentalBenefitMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> APPLY_BENEFIT_EMERGENCY_DENTAL = declare("Apply Benefit?", CheckBox.class, By.xpath("//input[@id='policyDataGatherForm:sedit_PreconfigGroupAccDentalBenefit_applied']"));
        public static final AssetDescriptor<TextBox> DENTAL_SERVICES = declare("Dental Services must be completed within (days)", TextBox.class);
        public static final AssetDescriptor<TextBox> CROWN_BENEFIT_AMOUNT = declare("Crown Benefit Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> EXTRACTION_BENEFIT_AMOUNT = declare("Extraction Benefit Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> NUMBER_OF_TIMES_EMERGENCY_DENTAL_PAYABLE = declare("Number of times the Emergency Dental Benefit is payable per time period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TIME_PERIOD = declare("Time Period", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_PreconfigGroupAccDentalBenefitViewOnly_timePeriod']"));
    }
}
