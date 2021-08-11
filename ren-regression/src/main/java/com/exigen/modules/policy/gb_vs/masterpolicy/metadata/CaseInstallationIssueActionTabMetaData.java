/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.modules.policy.gb_vs.masterpolicy.metadata;

import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class CaseInstallationIssueActionTabMetaData extends MetaData {

    public static final AssetDescriptor<RadioGroup> INCLUDE_MEMBERS_ON_COBRA = declare("Include Members on COBRA", RadioGroup.class);
    public static final AssetDescriptor<AssetList> DEFINITION_OF_LEGAL_SPOUSE = declare("Definition of Legal Spouse", AssetList.class, DefinitionOfLegalSpouseMetadata.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));

    public static final class DefinitionOfLegalSpouseMetadata extends MetaData {
        public static final AssetDescriptor<CheckBox> SPOUSE_LEGALLY_RECOGNIZED_POLICY_ISSUE_STATE = declare("Spouse legally recognized by Policy Issue State", CheckBox.class);
        public static final AssetDescriptor<CheckBox> CIVIL_UNION_LEGALLY_RECOGNIZED_POLICY_ISSUE_STATE = declare("Civil Union legally recognized by Policy Issue State", CheckBox.class);
        public static final AssetDescriptor<CheckBox> INCLUDES_DOMESTIC_PARTNER = declare("Includes Domestic Partner", CheckBox.class);
    }
}
