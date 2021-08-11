/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.modules.policy.gb_ac.masterpolicy.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

import static com.exigen.ren.common.Tab.doubleWaiter;

public class PlanDefinitionTabMetaData extends MetaData {
    public static final AssetDescriptor<AdvancedSelector> PLAN = declare("Plan", AdvancedSelector.class);
    public static final AssetDescriptor<Button> ADD_COVERAGE = declare("Add Coverage", Button.class, doubleWaiter, By.id("policyDataGatherForm:addPreconfigGroupCoverageDefinition"));
    public static final AssetDescriptor<DialogAssetList> COPY_PLAN = declare("Copy Plan", DialogAssetList.class, CopyPlanPopup.class, false, By.xpath("//div[@id = 'contents']//div[@id = 'plansCopyPopup']"));

    public static final AssetDescriptor<ComboBox> PLAN_COMBOBOX = declare("Plan ComboBox", ComboBox.class, Waiters.AJAX, By.id("policyDataGatherForm:sedit_GroupCoverageDefinitionCodeViewOnlyComponent_packageCd"));
    public static final AssetDescriptor<ComboBox> COVERAGE_NAME = declare("Coverage Name", ComboBox.class, Waiters.SLEEP(15000));
    public static final AssetDescriptor<TextBox> SIC_CODE = declare("SIC Code", TextBox.class);
    public static final AssetDescriptor<ComboBox> SIC_DESCRIPTION = declare("SIC Description", ComboBox.class, Waiters.DEFAULT);
    public static final AssetDescriptor<ComboBox> CENSUS_TYPE = declare("Census Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> PLAN_NAME = declare("Plan Name", TextBox.class);
    public static final AssetDescriptor<AdvancedSelector> COVERAGE_TIERS = declare("Coverage Tiers", AdvancedSelector.class, Waiters.AJAX);
    public static final AssetDescriptor<Button> COVERAGE_TIERS_CHANGE_CONFIRMATION = declare("Coverage Tiers Change Confirmation", Button.class, Waiters.SLEEP(2000), By.id("tierChangeWarningPopupForm:okBtn"));
    public static final AssetDescriptor<ComboBox> NUMBER_OF_UNITS = declare("Number of Units", ComboBox.class);
    public static final AssetDescriptor<ComboBox> COVERAGE_BASIS = declare("Coverage Basis", ComboBox.class);

    public static final AssetDescriptor<AssetList> SPONSOR_PARTICIPANT_FUNDING_STRUCTURE = declare("Sponsor/Participant Funding Structure", AssetList.class, SponsorParticipantFundingStructureMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> AGE_TERMINATION = declare("Age Termination", AssetList.class, AgeTerminationSection.class, false,
            By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> ELIGIBILITY = declare("Eligibility", AssetList.class, EligibilityMetadata.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));

    public static final class SponsorParticipantFundingStructureMetaData extends MetaData {
        public static final AssetDescriptor<RadioGroup> SELF_ADMINISTERED = declare("Self-administered?", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> CONTRIBUTION_TYPE = declare("Contribution Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> PARTICIPANT_CONTRIBUTION = declare("Participant Contribution %", TextBox.class);
        public static final AssetDescriptor<TextBox> PARTICIPANT_CONTRIBUTION_PCT_EMPLOYEE_COVERAGE = declare("Participant Contribution % Employee Coverage", TextBox.class);
        public static final AssetDescriptor<TextBox> PARTICIPANT_CONTRIBUTION_PCT_DEPENDENT_COVERAGE = declare("Participant Contribution % Dependent Coverage", TextBox.class);
        public static final AssetDescriptor<TextBox> MINIMUM_NUMBER_OF_PARTICIPANTS = declare("Minimum Number of Participants", TextBox.class);
        public static final AssetDescriptor<ComboBox> REQUIRED_PARTICIPATION = declare("Required Participation %", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TAXABILITY = declare("Taxability", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> PREMIUM_PAID_POST_TAX = declare("Premium Paid-Post Tax", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> SPONSOR_PAYMENT_MODE = declare("Sponsor Payment Mode", ComboBox.class);
        public static final AssetDescriptor<AdvancedSelector> MEMBER_PAYMENT_MODE = declare("Member Payment Mode", AdvancedSelector.class);
    }

    public static final class AgeTerminationSection extends MetaData {
        public static final AssetDescriptor<CheckBox> TERMINATION_AGE_APPLIED = declare("Termination Age Applied?", CheckBox.class);
        public static final AssetDescriptor<ComboBox> TERMINATION_AGE = declare("Termination Age", ComboBox.class);
    }

    public static final class EligibilityMetadata extends MetaData {
        public static final AssetDescriptor<TextBox> MINIMUM_HOURLY_REQUIREMENT = declare("Minimum Hourly Requirement (hours per week)", TextBox.class);
        public static final AssetDescriptor<ComboBox> ELIGIBILITY_WAITING_PERIOD_DEFINITION = declare("Eligibility Waiting Period Definition", ComboBox.class);
        public static final AssetDescriptor<TextBox> WAITING_PERIOD = declare("Waiting Period", TextBox.class);
        public static final AssetDescriptor<ComboBox> WAITING_PERIOD_MODE = declare("Waiting Period Mode", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> WAITING_PERIOD_WAIVED_FOR_CURRENT_EMPLOYEES = declare("Waiting Period Waived For Current Employees?", RadioGroup.class);
    }

    public static final class CopyPlanPopup extends MetaData {
        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                By.id("policyDataGatherForm:copyPlanButton"));
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
                By.xpath("//div[@id = 'plansCopyPopup']//button[1]"));
        public static final AssetDescriptor<ComboBox> PLAN_TO_COPY_FROM = declare("Plan To Copy From", ComboBox.class);
        public static final AssetDescriptor<TextBox> NEW_PLAN_CODE = declare("New Plan Code", TextBox.class);
        public static final AssetDescriptor<TextBox> NEW_PLAN_NAME = declare("New Plan Name", TextBox.class);
    }
}