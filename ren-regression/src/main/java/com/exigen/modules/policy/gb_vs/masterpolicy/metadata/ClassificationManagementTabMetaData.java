/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.policy.gb_vs.masterpolicy.metadata;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.modules.policy.gb_vs.masterpolicy.tabs.ClassificationManagementTab.PlanTierAndRatingInfoMultiAssetList;
import org.openqa.selenium.By;

public class ClassificationManagementTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> CLASSIFICATION_GROUP = declare("Classification Group Combobox", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PLAN = declare("Plan Combobox", ComboBox.class);
    public static final AssetDescriptor<Button> ADD_CLASSIFICATION_GROUP_TO_THE_PLAN = declare("Add Classification Group to the Plan", Button.class,
            By.id("policyDataGatherForm:addClassToPlan"));
    public static final AssetDescriptor<Button> ADD_CLASSIFICATION_GROUP_RELATIONSHIP = declare("Add Classification Group Relationship", Button.class,
            By.id("policyDataGatherForm:addGroupClassGroupCoverageRelationship"));
    public static final AssetDescriptor<ComboBox> CLASSIFICATION_GROUP_NAME = declare("Classification Group Name", ComboBox.class);
    public static final AssetDescriptor<ComboBox> CLASSIFICATION_SUB_GROUP_NAME = declare("Classification Sub-Group Name", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> USE_CLASSIFICATION_SUB_GROUPS = declare("Use Classification Sub-Groups?", RadioGroup.class);

    public static final AssetDescriptor<PlanTierAndRatingInfoMultiAssetList> PLAN_TIER_AND_RATING_INFO =
            declare("Plan Tier And Rating Info", PlanTierAndRatingInfoMultiAssetList.class, PlanTierAndRatingInfoMetaData.class);

    public static final class PlanTierAndRatingInfoMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> COVERAGE_TIER = declare("Coverage Tier", ComboBox.class);
        public static final AssetDescriptor<TextBox> NUMBER_OF_PARTICIPANTS = declare("Number of Participants", TextBox.class);
        public static final AssetDescriptor<TextBox> RATE = declare("Rate", TextBox.class);
        public static final AssetDescriptor<TextBox> PROPOSED_RATE = declare("Proposed Rate", TextBox.class);
        public static final AssetDescriptor<ComboBox> PROPOSED_RATE_UPDATE_REASON = declare("Proposed Rate Update Reason", ComboBox.class);
    }
}