/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.modules.policy.gb_ac.masterpolicy.metadata;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class ClassificationManagementTabMetaData extends MetaData {
    public static final AssetDescriptor<Button> ADD_CLASSIFICATION_GROUP_RELATIONSHIP = declare("Add Classification Group Relationship", Button.class,
            By.id("policyDataGatherForm:addGroupClassGroupCoverageRelationship"));
    public static final AssetDescriptor<ComboBox> CLASSIFICATION_GROUP_NAME = declare("Classification Group Name", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> USE_CLASSIFICATION_SUB_GROUPS = declare("Use Classification Sub-Groups?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> CUSTOMIZE_PLAN = declare("Customize Plan?", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> CLASSIFICATION_SUB_GROUP_NAME = declare("Classification Sub-Group Name", ComboBox.class);
    public static final AssetDescriptor<TextBox> NUMBER_OF_PARTICIPANTS = declare("Number of Participants", TextBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_VOLUME = declare("Total Volume", TextBox.class);
    public static final AssetDescriptor<TextBox> RATE = declare("Rate", TextBox.class);
    public static final AssetDescriptor<TextBox> PROPOSED_RATE = declare("Proposed Rate", TextBox.class);
    public static final AssetDescriptor<ComboBox> COVERAGE_TIER = declare("Coverage Tier", ComboBox.class);
    public static final AssetDescriptor<AssetList> PLAN_TIER_AND_RATING_INFO = declare("Plan Tier And Rating Info ", AssetList.class, ClassificationManagementTabMetaData.class, By.xpath("//div[@id='policyDataGatherForm:componentView_GroupClassDefaultCoverRelationTier']"));
    public static final AssetDescriptor<ComboBox> RATE_BASIS = declare("Rate Basis", ComboBox.class);
    public static final AssetDescriptor<Button> ADD_COVERAGE_TIER = declare("Add Coverage Tier", Button.class, By.id("policyDataGatherForm:addGroupClassDefaultCoverRelationTier"));
    public static final AssetDescriptor<ComboBox> CLASSIFICATION_GROUP = declare("Classification Group", ComboBox.class);
    public static final AssetDescriptor<ComboBox> PLAN = declare("Plan Filter", ComboBox.class, By.id("policyDataGatherForm:sedit_GroupClassGroupCoverageDefinition_classGroupPlanSelection"));
    public static final AssetDescriptor<Button> ADD_CLASSIFICATION_GROUP_TO_THE_PLAN = declare("Add Classification Group to the Plan", Button.class,
            By.id("policyDataGatherForm:addClassToPlan"));


}
