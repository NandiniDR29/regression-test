/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class PlanDefinitionTabMetaData extends MetaData {
    public static final AssetDescriptor<RadioGroup> PPO_EPO_PLAN = declare("PPO/EPO Plan?", RadioGroup.class);
    public static final AssetDescriptor<AdvancedSelector> PLAN = declare("Plan", AdvancedSelector.class);
    public static final AssetDescriptor<TextBox> PLAN_NAME = declare("Plan Name", TextBox.class);
    public static final AssetDescriptor<AdvancedSelector> COVERAGE_TIERS = declare("Coverage Tiers", AdvancedSelector.class);
    public static final AssetDescriptor<ComboBox> DHMO_PARTNER = declare("DHMO Partner", ComboBox.class);
    public static final AssetDescriptor<Button> COVERAGE_TIERS_CHANGE_CONFIRMATION = declare("Coverage Tiers Change Confirmation", Button.class, By.id("tierChangeWarningPopupForm:okBtn"));
    public static final AssetDescriptor<RadioGroup> SELF_ADMINISTERED = declare("Self-administered?", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> CENSUS_TYPE = declare("Census Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> DENTAL_PLAN_DESIGN_CODE = declare("Dental Plan Design Code", TextBox.class);
    public static final AssetDescriptor<AssetList> RATING = declare("Rating", AssetList.class, RatingMetaData.class, By.id("policyDataGatherForm:componentRegion_PolicyRatingViewComponent"));
    public static final AssetDescriptor<AssetList> ELIGIBILITY = declare("Eligibility", AssetList.class, EligibilityMetaData.class, By.id("policyDataGatherForm:componentRegion_PreconfigGroupEligibility"));
    public static final AssetDescriptor<AssetList> BENEFIT_WAITING_PERIODS = declare("Benefit Waiting Periods", AssetList.class, BenefitWaitingPeriodsMetaData.class, By.id("policyDataGatherForm:componentRegion_RenDNBenefitWaitingPeriodsComponent"));
    public static final AssetDescriptor<AssetList> DENTAL_MAXIMUM = declare("Dental Maximum", AssetList.class, DentalMaximumMetaData.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> CO_INSURANCE = declare("Co-Insurance", AssetList.class, CoInsuranceMetaData.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> DENTAL_DEDUCTIBLE = declare("Dental Deductible", AssetList.class, DentalDeductibleMetaData.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> ORTHODONTIA = declare("Orthodontia", AssetList.class, OrthodontiaMetaData.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> LIMITATION_FREQUENCY = declare("Limitation/Frequency", AssetList.class, LimitationFrequencyMetaData.class, By.xpath("//span[@id='policyDataGatherForm:componentRegion_PreconfigGroupReplacementLimitation']"));
    public static final AssetDescriptor<AssetList> SERVICE_CATEGORIES = declare("Service Categories", AssetList.class, ServiceCategoriesMetaData.class, By.xpath("//div[@id='policyDataGatherForm:componentView_PreconfigGroupNonStandardBenefitLevels']"));
    public static final AssetDescriptor<AssetList> COVERAGE_INCLUDED_IN_PACKAGE = declare("Coverage Included in Package", AssetList.class, CoveragePackageMetaData.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> SPONSOR_PARTICIPANT_FUNDING_STRUCTURE = declare("Sponsor/Participant Funding Structure", AssetList.class, SponsorParticipantFundingStructureMetaData.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AdvancedSelector> MEMBER_PAYMENT_MODE = declare("Member Payment Mode", AdvancedSelector.class);
    public static final AssetDescriptor<RadioGroup> DIRECT_BILL = declare("Direct Bill", RadioGroup.class);
    public static final AssetDescriptor<CheckBox> MISSING_TOOTH = declare("Missing Tooth", CheckBox.class);

    public static final class ExclusionsMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> COSMETIC_SERVICES = declare("Cosmetic Services", CheckBox.class);
        public static final AssetDescriptor<CheckBox> MISSING_TOOTH = declare("Missing Tooth", CheckBox.class);
        public static final AssetDescriptor<CheckBox> COMPLETE_OCCLUSAL_ADJUSTMENT = declare("Complete Occlusal Adjustment", CheckBox.class);
        public static final AssetDescriptor<CheckBox> PULP_CAPS = declare("Pulp Caps", CheckBox.class);
        public static final AssetDescriptor<CheckBox> PULPAL_THERAPY = declare("Pulpal Therapy", CheckBox.class);
        public static final AssetDescriptor<CheckBox> EXCISION_OF_BONE_TISSUE = declare("Excision of Bone Tissue", CheckBox.class);
        public static final AssetDescriptor<CheckBox> BIOPSY_LESION_VESTIBULOPLASTY = declare("Biopsy/Lesion/Vestibuloplasty", CheckBox.class);
        public static final AssetDescriptor<CheckBox> ARESTIN = declare("Arestin", CheckBox.class);
    }

    public static final class DentalDeductibleMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_EXPENSE_PERIOD = declare("Deductible Expense Period", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> IS_IT_GRADED_DENTAL_DEDUCTIBLE = declare("Is it graded Dental Deductible", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> NUMBER_OF_GRADED_YEARS = declare("Number of Graded Years", ComboBox.class, By.id("policyDataGatherForm:sedit_PreconfigGroupDentalDeductibleComponent_numberOfGradedYears"));
        public static final AssetDescriptor<RadioGroup> LIFETIME_DEDUCTIBLE = declare("Lifetime Deductible", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_DEDUCTIBLE_IN_NETWORK = declare("Lifetime Deductible - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_DEDUCTIBLE_OUT_OF_NETWORK = declare("Lifetime Deductible - Out of Network", ComboBox.class);
        public static final AssetDescriptor<AdvancedSelector> APPLY_DEDUCTIBLE_IN_NETWORK = declare("Apply Deductible In Network", AdvancedSelector.class);
        public static final AssetDescriptor<AdvancedSelector> APPLY_DEDUCTIBLE_OUT_OF_NETWORK = declare("Apply Deductible Out of Network", AdvancedSelector.class);
        public static final AssetDescriptor<AdvancedSelector> APPLY_DEDUCTIBLE_EPO = declare("Apply Deductible EPO", AdvancedSelector.class);
        public static final AssetDescriptor<RadioGroup> DEDUCTIBLE_CARRYOVER = declare("Deductible Carryover", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_EPO = declare("Deductible - EPO", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_IN_NETWORK = declare("Deductible - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_OUT_OF_NETWORK = declare("Deductible - Out Of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_DEDUCTIBLE_EPO = declare("Family Deductible - EPO", ComboBox.class);

        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_FIRST_YEAR_IN_NETWORK = declare("Deductible First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_FIRST_YEAR_OUT_OF_NETWORK = declare("Deductible First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_SECOND_YEAR_IN_NETWORK = declare("Deductible Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_SECOND_YEAR_OUT_OF_NETWORK = declare("Deductible Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_THIRD_YEAR_IN_NETWORK = declare("Deductible Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_THIRD_YEAR_OUT_OF_NETWORK = declare("Deductible Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_FOURTH_YEAR_IN_NETWORK = declare("Deductible Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DEDUCTIBLE_FOURTH_YEAR_OUT_OF_NETWORK = declare("Deductible Fourth Year - Out of Network", ComboBox.class);

        public static final AssetDescriptor<ComboBox> FAMILY_DEDUCTIBLE_FIRST_YEAR_IN_NETWORK = declare("Family Deductible First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_DEDUCTIBLE_FIRST_YEAR_OUT_OF_NETWORK = declare("Family Deductible First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_DEDUCTIBLE_SECOND_YEAR_IN_NETWORK = declare("Family Deductible Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_DEDUCTIBLE_SECOND_YEAR_OUT_OF_NETWORK = declare("Family Deductible Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_DEDUCTIBLE_THIRD_YEAR_IN_NETWORK = declare("Family Deductible Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_DEDUCTIBLE_THIRD_YEAR_OUT_OF_NETWORK = declare("Family Deductible Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_DEDUCTIBLE_FOURTH_YEAR_IN_NETWORK = declare("Family Deductible Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_DEDUCTIBLE_FOURTH_YEAR_OUT_OF_NETWORK = declare("Family Deductible Fourth Year - Out of Network", ComboBox.class);

        public static final AssetDescriptor<ComboBox> FAMILY_DEDUCTIBLE_IN_NETWORK = declare("Family Deductible - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FAMILY_DEDUCTIBLE_OUT_OF_NETWORK = declare("Family Deductible - Out Of Network", ComboBox.class);
    }

    public static final class CoInsuranceMetaData extends MetaData {

        public static final AssetDescriptor<ComboBox> UC_PERCENTILE_LEVEL = declare("U&C Percentile Level", ComboBox.class);
        public static final AssetDescriptor<ComboBox> NETWORK_ARRANGEMENT = declare("Network Arrangement", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> IS_IT_GRADED_CO_INSURANCE = declare("Is it graded Co-Insurance", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> NUMBER_OF_GRADED_YEARS = declare("Number of Graded Years", ComboBox.class, By.id("policyDataGatherForm:sedit_PreconfigGroupCoinsuranceBenefitsComponent_numberOfGradedYears"));

        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_IN_NETWORK = declare("Prosthodontics - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_OUT_OF_NETWORK = declare("Prosthodontics - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_EPO = declare("Prosthodontics - EPO", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_FIRST_YEAR_IN_NETWORK = declare("Prosthodontics First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_FIRST_YEAR_OUT_OF_NETWORK = declare("Prosthodontics First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_SECOND_YEAR_IN_NETWORK = declare("Prosthodontics Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_SECOND_YEAR_OUT_OF_NETWORK = declare("Prosthodontics Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_THIRD_YEAR_IN_NETWORK = declare("Prosthodontics Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_THIRD_YEAR_OUT_OF_NETWORK = declare("Prosthodontics Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_FOURTH_YEAR_IN_NETWORK = declare("Prosthodontics Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_FOURTH_YEAR_OUT_OF_NETWORK = declare("Prosthodontics Fourth Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_IN_NETWORK = declare("Radiographs - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_EPO = declare("Radiographs - EPO", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_OUT_OF_NETWORK = declare("Radiographs - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_FIRST_YEAR_IN_NETWORK = declare("Radiographs First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_FIRST_YEAR_OUT_OF_NETWORK = declare("Radiographs First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_SECOND_YEAR_IN_NETWORK = declare("Radiographs Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_SECOND_YEAR_OUT_OF_NETWORK = declare("Radiographs Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_THIRD_YEAR_IN_NETWORK = declare("Radiographs Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_THIRD_YEAR_OUT_OF_NETWORK = declare("Radiographs Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_FOURTH_YEAR_IN_NETWORK = declare("Radiographs Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_FOURTH_YEAR_OUT_OF_NETWORK = declare("Radiographs Fourth Year - Out of Network", ComboBox.class);

        public static final AssetDescriptor<ComboBox> PREVENTIVE_FIRST_YEAR_IN_NETWORK = declare("Preventive First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PREVENTIVE_SECOND_YEAR_IN_NETWORK = declare("Preventive Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PREVENTIVE_THIRD_YEAR_IN_NETWORK = declare("Preventive Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PREVENTIVE_FOURTH_YEAR_IN_NETWORK = declare("Preventive Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PREVENTIVE_FIRST_YEAR_OUT_OF_NETWORK = declare("Preventive First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PREVENTIVE_SECOND_YEAR_OUT_OF_NETWORK = declare("Preventive Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PREVENTIVE_THIRD_YEAR_OUT_OF_NETWORK = declare("Preventive Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PREVENTIVE_FOURTH_YEAR_OUT_OF_NETWORK = declare("Preventive Fourth Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_IN_NETWORK = declare("Basic - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_IN_NETWORK_EPO = declare("Basic In Network - EPO", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_OUT_OF_NETWORK = declare("Basic - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_FIRST_YEAR_IN_NETWORK = declare("Basic First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_FIRST_YEAR_OUT_OF_NETWORK = declare("Basic First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_SECOND_YEAR_IN_NETWORK = declare("Basic Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_SECOND_YEAR_OUT_OF_NETWORK = declare("Basic Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_THIRD_YEAR_IN_NETWORK = declare("Basic Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_THIRD_YEAR_OUT_OF_NETWORK = declare("Basic Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_FOURTH_YEAR_IN_NETWORK = declare("Basic Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_FOURTH_YEAR_OUT_OF_NETWORK = declare("Basic Fourth Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_IN_NETWORK = declare("Major - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_IN_NETWORK_EPO = declare("Major In Network - EPO", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_OUT_OF_NETWORK = declare("Major - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_FIRST_YEAR_IN_NETWORK = declare("Major First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_FIRST_YEAR_OUT_OF_NETWORK = declare("Major First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_SECOND_YEAR_IN_NETWORK = declare("Major Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_SECOND_YEAR_OUT_OF_NETWORK = declare("Major Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_THIRD_YEAR_IN_NETWORK = declare("Major Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_THIRD_YEAR_OUT_OF_NETWORK = declare("Major Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_FOURTH_YEAR_IN_NETWORK = declare("Major Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_FOURTH_YEAR_OUT_OF_NETWORK = declare("Major Fourth Year - Out of Network", ComboBox.class);

        public static final AssetDescriptor<ComboBox> PREVENTIVE_IN_NETWORK = declare("Preventive - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PREVENTIVE_IN_NETWORK_EPO = declare("Preventive In Network - EPO", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PREVENTIVE_OUT_OF_NETWORK = declare("Preventive - Out of Network", ComboBox.class);
    }

    public static final class OrthodontiaMetaData extends MetaData {
        public static final AssetDescriptor<RadioGroup> ORTHO_COVERAGE = declare("Ortho Coverage", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> YEARLY_MAXIMUM = declare("Yearly Maximum", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> LIFETIME_MAXIMUM = declare("Lifetime Maximum", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> LIFETIME_DEDUCTIBLE = declare("Lifetime Deductible", RadioGroup.class, By.id("policyDataGatherForm:sedit_PreconfigGroupOrthodontiaLifetimeDeductibleViewOnly_proxiedComponents_PreconfigGroupOrthodontia_lifetimeDeductible"));
        public static final AssetDescriptor<ComboBox> YEARLY_MAXIMUM_IN_NETWORK = declare("Yearly Maximum - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> YEARLY_MAXIMUM_EPO = declare("Yearly Maximum - EPO", ComboBox.class);
        public static final AssetDescriptor<ComboBox> YEARLY_MAXIMUM_OUT_OF_NETWORK = declare("Yearly Maximum - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_MAXIMUM_IN_NETWORK = declare("Lifetime Maximum - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_MAXIMUM_EPO = declare("Lifetime Maximum - EPO", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_MAXIMUM_OUT_OF_NETWORK = declare("Lifetime Maximum - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_DEDUCTIBLE_IN_NETWORK = declare("Lifetime Deductible - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_DEDUCTIBLE_OUT_OF_NETWORK = declare("Lifetime Deductible - Out of Network", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> IS_IT_GRADED_ORTHODONTIA = declare("Is it Graded Orthodontia", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> YEARLY_MAXIMUM_FIRST_YEAR_IN_NETWORK = declare("Yearly Maximum First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> YEARLY_MAXIMUM_FIRST_YEAR_OUT_OF_NETWORK = declare("Yearly Maximum First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> YEARLY_MAXIMUM_SECOND_YEAR_IN_NETWORK = declare("Yearly Maximum Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> YEARLY_MAXIMUM_SECOND_YEAR_OUT_OF_NETWORK = declare("Yearly Maximum Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> YEARLY_MAXIMUM_THIRD_YEAR_IN_NETWORK = declare("Yearly Maximum Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> YEARLY_MAXIMUM_THIRD_YEAR_OUT_OF_NETWORK = declare("Yearly Maximum Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> YEARLY_MAXIMUM_FOURTH_YEAR_IN_NETWORK = declare("Yearly Maximum Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> YEARLY_MAXIMUM_FOURTH_YEAR_OUT_OF_NETWORK = declare("Yearly Maximum Fourth Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_MAXIMUM_FIRST_YEAR_IN_NETWORK = declare("Lifetime Maximum First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_MAXIMUM_FIRST_YEAR_OUT_OF_NETWORK = declare("Lifetime Maximum First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_MAXIMUM_SECOND_YEAR_IN_NETWORK = declare("Lifetime Maximum Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_MAXIMUM_SECOND_YEAR_OUT_OF_NETWORK = declare("Lifetime Maximum Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_MAXIMUM_THIRD_YEAR_IN_NETWORK = declare("Lifetime Maximum Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_MAXIMUM_THIRD_YEAR_OUT_OF_NETWORK = declare("Lifetime Maximum Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_MAXIMUM_FOURTH_YEAR_IN_NETWORK = declare("Lifetime Maximum Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIFETIME_MAXIMUM_FOURTH_YEAR_OUT_OF_NETWORK = declare("Lifetime Maximum Fourth Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> NUMBER_OF_GRADED_YEARS = declare("Number of Graded Years", ComboBox.class, By.id("policyDataGatherForm:sedit_PreconfigGroupOrthodontia_numberOfGradedYears"));
        public static final AssetDescriptor<ComboBox> COINSURANCE_IN_NETWORK = declare("Co-Insurance - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COINSURANCE_OUT_OF_NETWORK = declare("Co-Insurance - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COINSURANCE_EPO = declare("Co-Insurance - EPO", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COINSURANCE_FIRST_YEAR_IN_NETWORK = declare("Co-Insurance First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COINSURANCE_FIRST_YEAR_OUT_OF_NETWORK = declare("Co-Insurance First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COINSURANCE_SECOND_YEAR_IN_NETWORK = declare("Co-Insurance Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COINSURANCE_SECOND_YEAR_OUT_OF_NETWORK = declare("Co-Insurance Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COINSURANCE_THIRD_YEAR_IN_NETWORK = declare("Co-Insurance Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COINSURANCE_THIRD_YEAR_OUT_OF_NETWORK = declare("Co-Insurance Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COINSURANCE_FOURTH_YEAR_IN_NETWORK = declare("Co-Insurance Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COINSURANCE_FOURTH_YEAR_OUT_OF_NETWORK = declare("Co-Insurance Fourth Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> ORTHO_AVAILABILITY = declare("Ortho Availability", ComboBox.class);
        public static final AssetDescriptor<ComboBox> ORTHO_WAITING_PERIOD = declare("Ortho Waiting Period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> ORTHO_AGE_LIMIT = declare("Ortho Age Limit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> YEARLY_DEDUCTIBLE_IN_NETWORK = declare("Yearly Deductible - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> YEARLY_DEDUCTIBLE_OUT_OF_NETWORK = declare("Yearly Deductible - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_EPO = declare("Co-Insurance - EPO", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_IN_NETWORK = declare("Co-Insurance - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_OUT_OF_NETWORK = declare("Co-Insurance - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_FIRST_YEAR_IN_NETWORK = declare("Co-Insurance First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_FIRST_YEAR_OUT_OF_NETWORK = declare("Co-Insurance First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_SECOND_YEAR_IN_NETWORK = declare("Co-Insurance Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_SECOND_YEAR_OUT_OF_NETWORK = declare("Co-Insurance Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_THIRD_YEAR_IN_NETWORK = declare("Co-Insurance Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_THIRD_YEAR_OUT_OF_NETWORK = declare("Co-Insurance Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_FOURTH_YEAR_IN_NETWORK = declare("Co-Insurance Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_FOURTH_YEAR_OUT_OF_NETWORK = declare("Co-Insurance Fourth Year - Out of Network", ComboBox.class);
    }

    public static final class ServiceCategoriesMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> FIRST_A_ORAL_EXAMS = declare("1A - Oral Exams", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FIRST_B_EMERGENCY_PALLIATIVE_TREATMENT = declare("1B - Emergency Palliative Treatment", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FIRST_C_FLUORIDES = declare("1C - Fluorides", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FIRST_D_CLEANINGS = declare("1D - Cleanings", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FIRST_E_SEALANTS = declare("1E - Sealants", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_A_BITEWING_RADIOGRAPHS = declare("2A - Bitewing Radiographs", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_B_FULL_MOUTH_RADIOGRAPHS = declare("2B - Full Mouth Radiographs", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_C_ALL_OTHER_RADIOGRAPHS = declare("2C - All Other Radiographs", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_E_OTHER_RESTORATIVE = declare("2E - Other Restorative", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_H_PERIODONTICS_PROPHY = declare("2H - Periodontics Prophy", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_G_SIMPLE_PERIODONTICS = declare("2G - Simple Periodontics", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_F_MAJOR_PERIODONTICS = declare("2F - Major Periodontics", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_I_2I_ROOT_CANALS_ENDODONTIC = declare("2I - Root Canals (Endodontic)", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_J_ALL_OTHER_ENDODONTIC = declare("2J - All Other Endodontic", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_K_SIMPLE_EXTRACTIONS = declare("2K - Simple Extractions", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_L_COMPLEX_EXTRACTIONS = declare("2L - Complex Extractions", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_M_ALL_OTHER_ORAL_SURGERY = declare("2M - All Other Oral Surgery", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_O_OTHER_ADJUNCTIVE = declare("2O - Other Adjunctive", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_D_MAJOR_RESTORATIVE = declare("2D - Major Restorative", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SECOND_N_DENTURE_REPAIR = declare("2N - Denture Repair", ComboBox.class);
        public static final AssetDescriptor<ComboBox> THIRD_A_FIXED_BRIDGEWORK = declare("3A - Fixed Bridgework", ComboBox.class);
        public static final AssetDescriptor<ComboBox> THIRD_B_PARTIAL_DENTURES = declare("3B - Partial Dentures", ComboBox.class);
        public static final AssetDescriptor<ComboBox> THIRD_C_FULL_DENTURES = declare("3C - Full Dentures", ComboBox.class);
        public static final AssetDescriptor<ComboBox> THIRD_D_OTHER_DENTURES_BRIDGES = declare("3D - Other Dentures & Bridges", ComboBox.class);
    }

    public static final class DentalPreventAndDiagnosticMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> ORAL_EXAMINATION = declare("Oral Examination", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> TWO_ADDITIONAL_PERIO_MAINTENANCE_VISITS = declare("2 Additional Perio Maintenance Visits", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> INCLUDE_BICUSPID_SEALANT = declare("Include Bicuspid Sealant", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> PROPHYLAXES = declare("Prophylaxes", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROPHYLAXES_WITH_HISTORY = declare("Prophylaxes with History", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FLOURIDE_TREATMENT = declare("Fluoride Treatment", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FLOURIDE_TREATMENT_AGE_LIMIT = declare("Fluoride Treatment Age Limit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SPACE_MAINTAINERS = declare("Space Maintainers", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SPACE_MAINTAINERS_AGE_LIMIT = declare("Space Maintainers Age Limit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BRUSH_BIOPSY = declare("Brush Biopsy", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SEALANTS = declare("Sealants", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SEALANTS_AGE_LIMIT = declare("Sealants Age Limit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> EVIDENCE_BASED_DENTISTRY = declare("Evidence Based Dentistry", ComboBox.class);
    }

    public static final class DentalBasicMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> POSTERIOR_COMPOSITES = declare("Posterior Composites", ComboBox.class);
        public static final AssetDescriptor<ComboBox> OCCLUSAL_GUARD = declare("Occlusal Guard", ComboBox.class);
        public static final AssetDescriptor<ComboBox> ATHLETIC_MOUTHGUARDS = declare("Athletic Mouthguards", ComboBox.class);
        public static final AssetDescriptor<ComboBox> THIRD_MOLAR_REMOVAL = declare("3rd Molar Removal", ComboBox.class);
        public static final AssetDescriptor<ComboBox> AMALGAM_AND_COMPOSITE_RESIN_FILLINGS = declare("Amalgam and Composite Resin Fillings", ComboBox.class);
    }

    public static final class DentalMajorMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> CROWNS = declare("Crowns", ComboBox.class);
        public static final AssetDescriptor<ComboBox> INLAYS = declare("Inlays", ComboBox.class);
        public static final AssetDescriptor<ComboBox> INLAYS_OPTION_BENEFIT = declare("Inlays Option Benefit", ComboBox.class);
        public static final AssetDescriptor<ComboBox> VENEERS = declare("Veneers", ComboBox.class);
        public static final AssetDescriptor<ComboBox> FULL_MOUTH_DEBRIDEMENT = declare("Full Mouth Debridement", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PERIODONTAL_SURGERY = declare("Periodontal Surgery", ComboBox.class);
        public static final AssetDescriptor<ComboBox> ROOT_CANALS = declare("Root Canals", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SCALING_AND_ROOT_PLANNING = declare("Scaling and Root Planning", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIMITED_OCCLUSAL_ADJUSTMENTS = declare("Limited Occlusal Adjustments", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TMD = declare("TMD", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TISSUE_CONDITIONING = declare("Tissue Conditioning", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TMD_COINSURANCE = declare("TMD Co-Insurance", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TMD_MAXIMUM = declare("TMD Maximum", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TMJ_DIAGNOSTICS_XRAY = declare("TMJ Diagnostics - Xray", ComboBox.class);
    }

    public static final class CoveragePackageMetaData extends MetaData {
        public static final AssetDescriptor<CheckBox> STD = declare("STD", CheckBox.class);
        public static final AssetDescriptor<CheckBox> LTD = declare("LTD", CheckBox.class);
        public static final AssetDescriptor<CheckBox> LIFE = declare("LIFE", CheckBox.class);
        public static final AssetDescriptor<CheckBox> VISION = declare("VISION", CheckBox.class);
    }

    public static final class DentalMaximumMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> MAXIMUM_EXPENSE_PERIOD = declare("Maximum Expense Period", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> IS_IT_GRADED_DENTAL_MAXIMUM = declare("Is it graded Maximum", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> PLAN_MAXIMUM_IN_NETWORK = declare("Plan Maximum - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PLAN_MAXIMUM_OUT_NETWORK = declare("Plan Maximum - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> NUMBER_OF_GRADED_YEARS = declare("Number of Graded Years", ComboBox.class, By.id("policyDataGatherForm:sedit_PreconfigGroupDentalPlanMaximumsComponent_numberOfGradedYears"));
        public static final AssetDescriptor<ComboBox> PLAN_MAXIMUM_FIRST_YEAR_IN_NETWORK = declare("Plan Maximum First Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PLAN_MAXIMUM_FIRST_YEAR_OUT_OF_NETWORK = declare("Plan Maximum First Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PLAN_MAXIMUM_SECOND_YEAR_IN_NETWORK = declare("Plan Maximum Second Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PLAN_MAXIMUM_SECOND_YEAR_OUT_OF_NETWORK = declare("Plan Maximum Second Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PLAN_MAXIMUM_THIRD_YEAR_IN_NETWORK = declare("Plan Maximum Third Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PLAN_MAXIMUM_THIRD_YEAR_OUT_OF_NETWORK = declare("Plan Maximum Third Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PLAN_MAXIMUM_FOURTH_YEAR_IN_NETWORK = declare("Plan Maximum Fourth Year - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PLAN_MAXIMUM_FOURTH_YEAR_OUT_OF_NETWORK = declare("Plan Maximum Fourth Year - Out of Network", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> MAXIMUM_ROLL_OVER = declare("Maximum Roll Over", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> PLAN_MAX_EPO = declare("Plan Maximum - EPO", ComboBox.class);
        public static final AssetDescriptor<CheckBox> MAXIMUM_EXTENDER = declare("Maximum Extender", CheckBox.class);
        public static final AssetDescriptor<TextBox> ROLL_OVER_THRESHOLD = declare("Roll Over Threshold", TextBox.class);
        public static final AssetDescriptor<TextBox> ROLL_OVER_BENEFIT = declare("Roll Over Benefit", TextBox.class);
        public static final AssetDescriptor<TextBox> ROLL_OVER_BENEFIT_LIMIT = declare("Roll Over Benefit Limit", TextBox.class);
    }

    public static final class LimitationFrequencyMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> STAINLESS_STEEL_CROWNS = declare("Stainless Steel Crowns", ComboBox.class);
        public static final AssetDescriptor<ComboBox> INLAYS_ONLAYS_CROWNS_DENTURES_BRIDGES = declare("Inlays, Onlays, Crowns, Dentures, Bridges", ComboBox.class);
        public static final AssetDescriptor<AssetList> DENTAL_RADIOGRAPHS = declare("Radiographs", AssetList.class, DentalRadiographsMetadata.class,
                By.xpath("//div[@id='policyDataGatherForm:componentView_RenGroupReplacementLimitationRadiographsViewOnly']"));
        public static final AssetDescriptor<AssetList> DENTAL_PROSTHODONTICS = declare("Prosthodontics", AssetList.class, DentalProsthodonticsMetadata.class,
                By.xpath("//div[@id='policyDataGatherForm:componentView_RenGroupReplacementLimitationProsthodonticsViewOnly']"));
        public static final AssetDescriptor<AssetList> DENTAL_PREVENT_AND_DIAGNOSTIC = declare("Preventative and Diagnostic", AssetList.class, DentalPreventAndDiagnosticMetaData.class,
                By.xpath("//div[@id='policyDataGatherForm:componentView_PreconfigGroupDentalPreventAndDiagnostic']"));
        public static final AssetDescriptor<AssetList> DENTAL_BASIC = declare("Basic", AssetList.class, DentalBasicMetaData.class,
                By.xpath("//div[@id='policyDataGatherForm:componentView_PreconfigGroupDentalBasic']"));
        public static final AssetDescriptor<AssetList> DENTAL_MAJOR = declare("Major", AssetList.class, DentalMajorMetaData.class,
                By.xpath("//div[@id='policyDataGatherForm:componentView_PreconfigGroupDentalMajor']"));
        public static final AssetDescriptor<AssetList> EXCLUSIONS = declare("Exclusions", AssetList.class, ExclusionsMetaData.class,
                By.xpath("//div[@id='policyDataGatherForm:componentView_PreconfigGroupExclusions_body']"));
    }

    public static final class EligibilityMetaData extends MetaData {
        public static final AssetDescriptor<RadioGroup> DOES_MIN_HOURLY_REQUIREMENT_APPLY = declare("Does Min Hourly Requirement Apply?", RadioGroup.class);
        public static final AssetDescriptor<TextBox> MINIMUM_HOURLY_REQUIREMENT = declare("Minimum Hourly Requirement (hours per week)", TextBox.class);
        public static final AssetDescriptor<RadioGroup> ELIGIBILITY_WAITING_PERIOD_WAIVED_FOR_CURRENT_EMPLOYEES = declare("Eligibility Waiting Period Waived For Current Employees?", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> ELIGIBILITY_WAITING_PERIOD_DEFINITION = declare("Eligibility Waiting Period Definition", ComboBox.class);
        public static final AssetDescriptor<TextBox> DEPENDENT_MAXIMUM_AGE = declare("Dependent Maximum Age", TextBox.class);
        public static final AssetDescriptor<TextBox> WAITING_PERIOD_AMOUNT = declare("Waiting Period Amount", TextBox.class);
        public static final AssetDescriptor<ComboBox> WAITING_PERIOD_MODE = declare("Waiting Period Mode", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> ALLOW_MEMBER_AND_SPOUSE_WHO_ARE_PART_OF_GROUP_ON_SEPARATE_CERTIFICATE = declare("Allow Member and Spouse (Who are part of Group) on Separate Certificate?", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> BENEFIT_END_ON = declare("Benefits End On", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> INCLUDE_DISABLED_DEPENDENTS = declare("Include Disabled Dependents", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> INCLUDE_RETIREES = declare("Include Retirees", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> BENEFIT_PERIOD_BASED_ON_MASTER_POLICY = declare("Benefit Period based on Master Policy", RadioGroup.class);
    }

    public static final class BenefitWaitingPeriodsMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> PREVENTIVE_WAITING_PERIOD = declare("Preventive Waiting Period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RADIOGRAPHS_WAIT_PERIOD = declare("Radiographs Waiting Period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIC_WAITING_PERIOD = declare("Basic Waiting Period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MAJOR_WAITING_PERIOD = declare("Major Waiting Period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PROSTHODONTICS_WAIT_PERIOD = declare("Prosthodontics Waiting Period", ComboBox.class);
        public static final AssetDescriptor<ComboBox> EPCOS_WAITING_PERIOD = declare("EPCOS Waiting Period", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> BENEFITS_WAIT_WAIVED_ENROLLEE = declare("Benefits Waiting Period is waived for current enrollees?", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> DOC_RECEIVED_WAIT_PERIOD = declare("Documentation of Waiting Period received?", RadioGroup.class);
    }

    public static final class RatingMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> RATE_TYPE = declare("Rate Type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RATE_BASIS = declare("Rate Basis", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> USE_BRO_RATES = declare("Use Brochure Rates", RadioGroup.class);
        public static final AssetDescriptor<TextBox> EXPERIENCE_CLAIM_AMOUNT = declare("Experience Claim Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> CREDIBILITY_FACTOR = declare("Credibility Factor", TextBox.class);
        public static final AssetDescriptor<TextBox> SIC_CODE = declare("SIC Code", TextBox.class);
        public static final AssetDescriptor<ComboBox> SIC_DESCRIPTION = declare("SIC Description", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RATE_CAP = declare("Rate Cap", ComboBox.class);
        public static final AssetDescriptor<TextBox> SECOND_YEAR_CAP_PCT = declare("2nd Year Cap %", TextBox.class);
        public static final AssetDescriptor<TextBox> THIRD_YEAR_CAP_PCT = declare("3rd Year Cap %", TextBox.class);
    }

    public static final class SponsorParticipantFundingStructureMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> CONTRIBUTION_TYPE = declare("Contribution Type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SPONSOR_PAYMENT_MODE = declare("Sponsor Payment Mode", ComboBox.class);
        public static final AssetDescriptor<TextBox> PARTICIPANT_CONTRIBUTION_PCT = declare("Participant Contribution %", TextBox.class);
        public static final AssetDescriptor<TextBox> REQUIRED_PARTICIPATION_PCT = declare("Required Participation %", TextBox.class);
        public static final AssetDescriptor<TextBox> ASSUMED_PARTICIPATION_PCT = declare("Assumed Participation %", TextBox.class);
        public static final AssetDescriptor<TextBox> MINIMUM_NO_OF_PARTICIPANTS = declare("Minimum Number of Participants", TextBox.class);
        public static final AssetDescriptor<RadioGroup> CONTRIBUTION_PERCENTAGE_BASED = declare("Is Contribution Percentage Based?", RadioGroup.class);
        public static final AssetDescriptor<TextBox> PARTICIPANT_CONTRIBUTION_PCT_EMPLOYEE_COVERAGE = declare("Participant Contribution % Employee Coverage", TextBox.class);
        public static final AssetDescriptor<TextBox> PARTICIPANT_CONTRIBUTION_PCT_DEPENDENT_COVERAGE = declare("Participant Contribution % Dependent Coverage", TextBox.class);
        public static final AssetDescriptor<TextBox> SPONSOR_CONTRIBUTION_AMOUNT_EMPLOYEE_MONTHLY_COVERAGE = declare("Sponsor Contribution Amount Employee Coverage (monthly)", TextBox.class);
        public static final AssetDescriptor<TextBox> SPONSOR_CONTRIBUTION_AMOUNT_DEPENDENT_MONTHLY_COVERAGE = declare("Sponsor Contribution Amount Dependent Coverage (monthly)", TextBox.class);
    }

    public static final class DentalRadiographsMetadata extends MetaData {
        public static final AssetDescriptor<ComboBox> FULL_MOUTH_RADIOGRAPHS = declare("Full Mouth Radiographs", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BITEWINGS = declare("Bitewings", ComboBox.class);
    }

    public static final class DentalProsthodonticsMetadata extends MetaData {
        public static final AssetDescriptor<ComboBox> BRIDGEWORK = declare("Bridgework", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DENTURES = declare("Dentures", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RELINES = declare("Relines", ComboBox.class);
        public static final AssetDescriptor<ComboBox> IMPLANTS = declare("Implants", ComboBox.class);
    }
}
