/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.tabs.PolicyInformationTab;
import org.openqa.selenium.By;

public class PolicyInformationTabMetaData extends MetaData {

    public static final AssetDescriptor<TextBox> QUOTE_CREATION_DATE = declare("Quote Creation Date", TextBox.class);
    public static final AssetDescriptor<TextBox> QUOTE_EXPIRATION_DATE = declare("Quote Expiration Date", TextBox.class);
    public static final AssetDescriptor<TextBox> POLICY_EFFECTIVE_DATE = declare("Policy Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> CURRENT_POLICY_YEAR_START_DATE = declare("Current Policy Year Start Date", TextBox.class);
    public static final AssetDescriptor<TextBox> NEXT_POLICY_YEAR_START_DATE = declare("Next Policy Year Start Date", TextBox.class);
    public static final AssetDescriptor<RadioGroup> USE_POLICY_TERM = declare("Use Policy Term?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> ASO_PLAN = declare("ASO Plan", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> SHORT_TERM = declare("Short Term", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> PRIOR_DENTAL_COVERAGE = declare("Prior Dental Coverage", RadioGroup.class);
    public static final AssetDescriptor<TextBox> TOTAL_NUMBER_OF_ELIGIBLE_LIVES = declare("Total Number of Eligible Lives", TextBox.class);
    public static final AssetDescriptor<CheckBox> PRIOR_CLAIMS_ALLOWED = declare("Prior Claims Allowed?", CheckBox.class);
    public static final AssetDescriptor<ComboBox> SITUS_STATE = declare("Situs State", ComboBox.class, Waiters.DEFAULT);
    public static final AssetDescriptor<TextBox> NEXT_RENEWAL_EFFECTIVE_DATE = declare("Next Renewal Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> NEXT_RENEWAL_QUOTE_START_DATE = declare("Next Renewal Quote Start Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> RENEWAL_FREQUENCY = declare("Renewal Frequency", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> ALLOW_INDEPENDENT_COMMISSIONABLE_PRODUCERS = declare("Allow Independent Commissionable Producers?", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> PRIOR_CARRIER_NAME = declare("Prior Carrier Name", ComboBox.class);
    public static final AssetDescriptor<ComboBox> RATE_BASIS = declare("Rate Basis", ComboBox.class);
    public static final AssetDescriptor<ComboBox> RATE_GUARANTEE = declare("Rate Guarantee", ComboBox.class);
    public static final AssetDescriptor<DialogSingleSelector> AGENCY_PRODUCER = declare("Agency/Producer", DialogSingleSelector.class, AddAgencyMetaData.class);
    public static final AssetDescriptor<ComboBox> AGENT_SUB_PRODUCER = declare("Agent Sub Producer", ComboBox.class);
    public static final AssetDescriptor<ComboBox> AGENCY_PRODUCER_COMBO = declare("Agency / Producer", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> INDEPENDENT_COMMISSIONABLE_PRODUCER_ICP = declare("Independent Commissionable Producer (ICP)?", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> UNDEWRITING_COMPANY = declare("Underwriting Company", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> GROUP_IS_MEMBER_COMPANY = declare("Group is Member Company", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> MEMBER_COMPANY_NAME = declare("Member Company Name", ComboBox.class);
    public static final AssetDescriptor<ComboBox> NAME_TO_DISPLAY_ON_MP_DOCUMENTS = declare("Name to Display on Master Policy Documents", ComboBox.class);
    public static final AssetDescriptor<AssetList> INTERNAL_TEAM = declare("Internal Team", AssetList.class, InternalTeamMetaData.class,
            By.id("policyDataGatherForm:componentView_InternalTeamComponent_body"));
    public static final AssetDescriptor<TextBox> RENEWAL_NOTIFICATION_DAYS = declare("Renewal Notification Days", TextBox.class);
    public static final AssetDescriptor<RadioGroup> GROUP_IS_AN_ASSOCIATION = declare("Group is an Association?", RadioGroup.class);
    public static final AssetDescriptor<TextBox> ZIP_CODE = declare("Zip Code", TextBox.class);
    public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> BLEND_DEMOGRAPHICS = declare("Blend Demographics", RadioGroup.class);
    public static final AssetDescriptor<TextBox> POLICY_TERM = declare("Policy Term", TextBox.class);
    public static final AssetDescriptor<TextBox> RATE_GUARANTEE_MONTHS = declare("Rate Guarantee (Months)", TextBox.class);
    public static final AssetDescriptor<TextBox> AGENCY_TYPE = declare("Agency Type", TextBox.class);
    public static final AssetDescriptor<Button> ADD_AGENCY = declare("Add Agency", Button.class, By.id("policyDataGatherForm:addGroupMasterPolicyMultiProducerInfo"));
    public static final AssetDescriptor<ComboBox> COUNTY_CODE = declare("County Code", ComboBox.class, Waiters.DEFAULT);
    public static final AssetDescriptor<ComboBox> DEDUCTION_BY_PAY_PERIOD = declare("Deduction by Pay Period", ComboBox.class);
    public static final AssetDescriptor<ComboBox> AGING_FREQUENCY = declare("Aging Frequency", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ANNIVERSARY_DAY_MONTH = declare("Anniversary Day (Month)", ComboBox.class, By.id("policyDataGatherForm:sedit_GroupMasterAnniversary_month"));
    public static final AssetDescriptor<ComboBox> ANNIVERSARY_DAY_DAY = declare("Anniversary Day (Day)", ComboBox.class, By.id("policyDataGatherForm:anniversaryDay"));

    //TODO OLapai: remove duplicated fields for Agency
    public static final AssetDescriptor<PolicyInformationTab.AssignedAgencies> ASSIGNED_AGENCIES =
            declare("Assigned Agencies", PolicyInformationTab.AssignedAgencies.class, AssignedAgenciesMetaData.class);

    public static final class AssignedAgenciesMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> AGENCY_PRODUCER = declare("Agency / Producer", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> PRIMARY_AGENCY = declare("Primary Agency?", RadioGroup.class);
        public static final AssetDescriptor<TextBox> SPLIT_PERCENTAGE = declare("Split Percentage", TextBox.class);
        public static final AssetDescriptor<ComboBox> AGENT_SUB_PRODUCER = declare("Agent Sub Producer", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> COMMISSION_SPLIT = declare("Commission Split", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> INDEPENDENT_COMMISSIONABLE_PRODUCER_ICP = declare("Independent Commissionable Producer (ICP)?", RadioGroup.class);
    }


    public static final class AddAgencyMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> CHANNEL = declare("Channel", ComboBox.class);
        public static final AssetDescriptor<TextBox> AGENCY_NAME = declare("Agency Name", TextBox.class);
        public static final AssetDescriptor<TextBox> AGENCY_CODE = declare("Agency Code", TextBox.class);
        public static final AssetDescriptor<TextBox> ZIP_CODE = declare("Zip Code", TextBox.class);
        public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
        public static final AssetDescriptor<TextBox> STATE = declare("State", TextBox.class);

        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                By.xpath("//a[.='Change Agency']"));
    }

    public static final class InternalTeamMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> SALES_REPRESENTATIVE = declare("Sales Representative", ComboBox.class);
        public static final AssetDescriptor<ComboBox> SALES_SUPPORT_ASSOCIATE = declare("Sales Support Associate", ComboBox.class);
        public static final AssetDescriptor<ComboBox> UNDERWRITER = declare("Underwriter", ComboBox.class);
    }
}
