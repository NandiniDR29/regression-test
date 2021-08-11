/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package com.exigen.modules.policy.common.metadata.master;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class PlanDefinitionIssueActionTabMetaData extends MetaData {

    public static final AssetDescriptor<Link> CHANGE=declare("Change", Link.class, By.xpath("policyDataGatherForm:dataGatherView_ListPreconfigGroupCoverageDefinition:1:dataGatherView_List_Change"));
    public static final AssetDescriptor<RadioGroup> INCLUDE_RETIREES = declare("Include Retirees", RadioGroup.class);
    public static final AssetDescriptor<TextBox> MINIMUM_HOURLY_REQUIREMENT = declare("Minimum Hourly Requirement (hours per week)", TextBox.class);
    public static final AssetDescriptor<ComboBox> ELIGIBILITY_WAITING_PERIOD_DEFINITION = declare("Eligibility Waiting Period Definition", ComboBox.class);
    public static final AssetDescriptor<ComboBox> WAITING_PERIOD_MODE = declare("Waiting Period Mode", ComboBox.class);
    public static final AssetDescriptor<TextBox> WAITING_PERIOD = declare("Waiting Period", TextBox.class);
    public static final AssetDescriptor<RadioGroup> Waiting_Period_Waived_For_Current_Employees=declare("Waiting Period Waived For Current Employees?", RadioGroup.class);
    public static final AssetDescriptor<TextBox> WAITING_PERIOD_AMOUNT = declare("Waiting Period Amount", TextBox.class);

}
