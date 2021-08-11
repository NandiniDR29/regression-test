/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.policy.gb_dn.certificate.metadata;

import com.exigen.ipb.eisa.controls.PartySearchTextBox;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.tabs.PlansTab;
import org.openqa.selenium.By;

public class PlansTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> PLAN_NAME = declare("Plan Name", ComboBox.class);
    public static final AssetDescriptor<TextBox> CLASS_NAME = declare("Class Name", TextBox.class);
    public static final AssetDescriptor<ComboBox> COVERAGE_NAME = declare("Coverage Name", ComboBox.class);
    public static final AssetDescriptor<ComboBox> CONTRIBUTION_TYPE = declare("Contribution Type", ComboBox.class);
    public static final AssetDescriptor<ComboBox> COVERAGE_TIER = declare("Coverage Tier", ComboBox.class, By.id("policyDataGatherForm:sedit_PreconfigGroupCertificateCoverageDetail_coverageTier"));
    public static final AssetDescriptor<TextBox> CLASSIFICATION_SUB_GROUP = declare("Classification Sub-group", TextBox.class);
    public static final AssetDescriptor<TextBox> ORIGINAL_EFFECTIVE_DATE = declare("Original Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> CANCELLATION_DATE = declare("Cancellation Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> MEMBER_PAYMENT_MODE = declare("Member Payment Mode",
            ComboBox.class);
    public static final AssetDescriptor<TextBox> ENROLLMENT_DATE = declare("Enrollment Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> SPONSOR_PAYMENT_MODE = declare("Sponsor Payment Mode", ComboBox.class);
    public static final AssetDescriptor<ComboBox> BENEFIT_TYPE = declare("Benefit Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> DEPENDENT_MAXIMUM_AGE = declare("Dependent Maximum Age", TextBox.class);
    public static final AssetDescriptor<Button> ADD_PARTICIPANT = declare("Add Participant", Button.class, By.id("policyDataGatherForm:addGroupCertificateParticipant"));

    public static final AssetDescriptor<PlansTab.ParticipantsMultiAssetList> PARTICIPANTS = declare("Participants",
            PlansTab.ParticipantsMultiAssetList.class, ParticipantsMetaData.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));

    public static final class ParticipantsMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> PARTICIPANT_SELECTION = declare("Participant Selection", ComboBox.class);
        public static final AssetDescriptor<AssetList> ROLE_INFORMATION = declare("Role Information", AssetList.class, RoleInformationMetaData.class, By.id("policyDataGatherForm:componentView_GroupCertificateParticipantViewOnly"));
        public static final AssetDescriptor<AssetList> GENERAL_INFORMATION = declare("General Information", AssetList.class, GeneralInformationMetaData.class, By.id("policyDataGatherForm:formGrid_GroupCertificateParticipantPersonInfoProxy"));
        public static final AssetDescriptor<AssetList> ADDRESS_INFORMATION = declare("Address Information", AssetList.class, AddressInformationMetaData.class, By.id("policyDataGatherForm:formGrid_GroupCertificateParticipantContactInfoProxy"));
    }

    public static final class RoleInformationMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> ROLE_NAME = declare("Role Name", ComboBox.class);
    }

    public static final class GeneralInformationMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> TITLE = declare("Title", ComboBox.class);
        public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
        public static final AssetDescriptor<TextBox> MIDDLE_NAME = declare("Middle Name", TextBox.class);
        public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
        public static final AssetDescriptor<ComboBox> SUFFIX = declare("Suffix", ComboBox.class);
        public static final AssetDescriptor<TextBox> DATE_OF_BIRTH = declare("Date of Birth", TextBox.class);
        public static final AssetDescriptor<ComboBox> GENDER = declare("Gender", ComboBox.class);
        public static final AssetDescriptor<ComboBox> TOBACCO = declare("Tobacco", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MARITAL_STATUS = declare("Marital Status", ComboBox.class);
        public static final AssetDescriptor<TextBox> TAX_IDENTIFICATION = declare("Tax Identification", TextBox.class);
        public static final AssetDescriptor<ComboBox> RELATIONSHIP_TO_INSURED = declare("Relationship to Insured", ComboBox.class);
    }

    public static final class AddressInformationMetaData extends MetaData {
        public static final AssetDescriptor<RadioGroup> USE_PRIMARY_INSURED_S_ADDRESS = declare("Use Primary Insured's Address", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> ADDRESS_TYPE = declare("Address Type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
        public static final AssetDescriptor<TextBox> ZIP_POST_CODE = declare("Zip / Post Code", TextBox.class);
        public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
        public static final AssetDescriptor<ComboBox> STATE_PROVINCE = declare("State / Province", ComboBox.class);
        public static final AssetDescriptor<PartySearchTextBox> ADDRESS_LINE_1 = declare("Address Line 1", PartySearchTextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_2 = declare("Address Line 2", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_3 = declare("Address Line 3", TextBox.class);
    }

}
