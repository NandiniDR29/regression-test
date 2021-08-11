/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.commission.commissiontrategy.gbcommissionstrategy.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.controls.TripleTextBox;
import org.openqa.selenium.By;

public class GBCommissionRuleMetaData extends MetaData {

    public static final AssetDescriptor<ComboBox> COMMISSION_TYPE = declare("Commission Type", ComboBox.class);
    public static final AssetDescriptor<DialogAssetList> ADD_COMMISSION_RULE = declare("AddCommissionRule", DialogAssetList.class, AddCommissionRule.class);

    public static final class AddCommissionRule extends MetaData {
        public static final AssetDescriptor<ComboBox> SALES_CHANNEL = declare("Sales Channel", ComboBox.class, Waiters.DEFAULT, false);
        public static final AssetDescriptor<DialogSingleSelector> SELECT_SALES_CHANNEL = declare("Select Sales Channel", DialogSingleSelector.class, SelectSalesChannel.class, false,
                By.xpath("//div[contains(@id, 'selectGroupPopupId') and contains(@id, '_container')]"));
        public static final AssetDescriptor<DialogSingleSelector> SELECT_SALES_INDIVIDUAL = declare("Select Sales Individual", DialogSingleSelector.class, SelectSalesIndividual.class, false,
                By.xpath("//div[contains(@id, 'selectGroupPopupId') and contains(@id, '_container')]"));

        public static final AssetDescriptor<ComboBox> GEOGRAPHY_SELECTION = declare("Geography Selection", ComboBox.class, Waiters.DEFAULT, false);
        public static final AssetDescriptor<DialogAssetList> SELECT_GEOGRAPHY_SELECTION = declare("SelectGeographyMetaData", DialogAssetList.class, SelectGeographyMetaData.class);
        public static final AssetDescriptor<AdvancedSelector> COVERAGE = declare("Coverages", AdvancedSelector.class);
        public static final AssetDescriptor<AdvancedSelector> COMPENSATION_TYPE = declare("Compensation Types", AdvancedSelector.class);

        public static final AssetDescriptor<RadioGroup> USE_TEMPLATE = declare("Use Template", RadioGroup.class, Waiters.DEFAULT, false);
        public static final AssetDescriptor<StaticElement> TIRED_SCHEDULE_LOWER_BOUNDARY = declare("Lower Boundary", StaticElement.class, By.xpath(".//td[text()='Lower Boundary']"));
        public static final AssetDescriptor<StaticElement> TIRED_SCHEDULE_UPPER_BOUNDARY = declare("Upper Boundary", StaticElement.class, By.xpath(".//td[text()='Upper Boundary']"));
        public static final AssetDescriptor<StaticElement> TIRED_SCHEDULE_COMMISSION = declare("Commission %", StaticElement.class, By.xpath(".//td[text()='Commission %']"));
        public static final AssetDescriptor<TripleTextBox> RATE_1 = declare("Rate 1", TripleTextBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<TripleTextBox> RATE_2 = declare("Rate 2", TripleTextBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<TripleTextBox> RATE_3 = declare("Rate 3", TripleTextBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<TripleTextBox> RATE_4 = declare("Rate 4", TripleTextBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<TripleTextBox> TIER_1 = declare("Tier 1", TripleTextBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<TripleTextBox> TIER_2 = declare("Tier 2", TripleTextBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<TripleTextBox> TIER_3 = declare("Tier 3", TripleTextBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<TripleTextBox> TIER_4 = declare("Tier 4", TripleTextBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<TripleTextBox> TIER_5 = declare("Tier 5", TripleTextBox.class, Waiters.DEFAULT);

        public static final AssetDescriptor<Button> ADD_RATE = declare("Add Rate", Button.class, Waiters.DEFAULT, false, By.xpath("//button[@id='addRuleDialogForm_renSubscriberCount:addBandBtn']"));
        public static final AssetDescriptor<Button> ADD_TIER = declare("Add Tier", Button.class, Waiters.DEFAULT, false, By.xpath("//button[contains(@id, 'addRuleDialogForm_ren') and contains(@id, 'addBandBtn')]"));
        public static final AssetDescriptor<Button> SAVE_AND_COPY_TO_OVERRIDE = declare("Save and Copy to Override", Button.class, Waiters.DEFAULT, false, By.xpath("//input[@id='addRuleDialogForm_renSubscriberCount:copyToOverrideBtn']"));
        public static final AssetDescriptor<ComboBox> TEMPLATE_NAME = declare("Template Name", ComboBox.class, Waiters.DEFAULT, false);
        public static final AssetDescriptor<TextBox> COMMISSION_RATE = declare("Commission Rate", TextBox.class, By.id("addRuleDialogForm_groupBenefitsFlat:commissionRate"));
        public static final AssetDescriptor<Button> BUTTON_REMOVE = declare("Remove", Button.class, By.xpath("//button[contains(@id, 'addRuleDialogForm_ren') and contains(@id, 'removeBandBtn')]"));
        public static final AssetDescriptor<Button> BUTTON_CLEAR = declare("Clear", Button.class, By.xpath("//button[contains(@id, 'addRuleDialogForm_ren') and contains(@id, 'clearRuleBtn')]"));
        public static final AssetDescriptor<Button> BUTTON_OK = declare("Ok", Button.class, Waiters.DEFAULT,false, By.xpath("//input[contains(@id, 'addRuleDialogForm_ren') and contains(@id, 'okBtn')]"));

        public static final class SelectSalesChannel extends MetaData {
            public static final AssetDescriptor<TextBox> COMMISSION_CHANNEL_GROUP_NAME = declare("Commission Channel Group Name", TextBox.class, Waiters.DEFAULT, false);

            public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class,
                    By.xpath("//button[contains(@id, 'addRuleDialogForm_') and contains(@id, 'selectGroupBtn')]"));
        }

        public static final class SelectSalesIndividual extends MetaData {
            public static final AssetDescriptor<TextBox> COMMISSION_INDIVIDUAL_GROUP_NAME = declare("Commission Individual Group Name", TextBox.class, Waiters.DEFAULT, false);

            public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class,
                    By.xpath("//button[contains(@id, 'addRuleDialogForm_') and contains(@id, 'selectGroupBtn')]"));
        }

        public static final class SelectGeographyMetaData extends MetaData {
            public static final AssetDescriptor<ListBox> COUNTRIES = declare("Countries", ListBox.class, Waiters.AJAX, false, By.xpath("//*[starts-with(@id, 'gForm_geography_') and contains(@id, 'countries')]"));
            public static final AssetDescriptor<ListBox> STATES = declare("States", ListBox.class, Waiters.AJAX, false, By.xpath("//*[starts-with(@id, 'gForm_geography_') and contains(@id, 'states')]"));
            public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                    By.xpath("//button[contains(@id, 'selectGeographyBtn')]"));
            public static final AssetDescriptor<Button> DEFAULT_POPUP_SUBMITTER_NAME = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
                    By.xpath("//div[contains(@id, 'mPanel_geography_') and contains(@id, '_container')]//input[contains(@id, 'okBtn')]"));
        }

        public static final class PolicyYear extends MetaData {
            public static final AssetDescriptor<TextBox> LOWER_BOUNDARY = declare("Lower Boundary", TextBox.class, Waiters.DEFAULT, false, By.id("addRuleDialogForm_groupBenefitsGraded:startYear"));
            public static final AssetDescriptor<TextBox> UPPER_BOUNDARY = declare("Upper Boundary", TextBox.class, Waiters.DEFAULT, false, By.id("addRuleDialogForm_groupBenefitsGraded:endYear"));
            public static final AssetDescriptor<TextBox> END_YEAR = declare("End Year", TextBox.class, Waiters.DEFAULT, false, By.id("addRuleDialogForm_groupBenefitsHeap:endYear"));
            public static final AssetDescriptor<TextBox> COMMISSION = declare("Commission %", TextBox.class, Waiters.DEFAULT, false,
                    By.xpath("//input[contains(@id, 'rate') and contains(@id, 'addRuleDialogForm') and not(@disabled)]"));
        }
    }
}
