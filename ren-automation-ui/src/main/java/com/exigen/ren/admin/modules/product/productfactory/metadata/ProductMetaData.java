/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.productfactory.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.ipb.eisa.controls.productfactory.DatePicker;
import com.exigen.ipb.eisa.controls.productfactory.MdCheckBox;
import com.exigen.ipb.eisa.controls.productfactory.ProductFactoryCheckBox;
import com.exigen.ipb.eisa.controls.productfactory.custom.*;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public final class ProductMetaData {

    public static final class ProductAutomatedProcessingTab extends MetaData {
        public static final AssetDescriptor<RadioGroup> STRATEGY_TYPE = declare("Strategy Type", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> RENEWAL_TYPE = declare("Renewal Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> STRATEGY_ID = declare("Strategy ID", TextBox.class);
        public static final AssetDescriptor<TextBox> DESCRIPTION = declare("Description", TextBox.class);
        public static final AssetDescriptor<AdvancedSelector> LINE_OF_BUSINESS = declare("Line of Business", AdvancedSelector.class);
        public static final AssetDescriptor<AdvancedSelector> PRODUCT = declare("Product", AdvancedSelector.class);
        public static final AssetDescriptor<AdvancedSelector> POLICY_FORM = declare("Policy Form", AdvancedSelector.class);
        public static final AssetDescriptor<AdvancedSelector> RISK_STATE = declare("Risk State", AdvancedSelector.class);
        public static final AssetDescriptor<AdvancedSelector> UNDEWRITING_COMPANY = declare("Underwriting Company", AdvancedSelector.class);
        public static final AssetDescriptor<RadioGroup> APPLICABLE_FOR_TERM = declare("Applicable for Term", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> PROCESS_TYPE = declare("Process Type", RadioGroup.class);
        public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective Date", TextBox.class);
        public static final AssetDescriptor<TextBox> EXPIRATION_DATE = declare("Expiration Date", TextBox.class);
        public static final AssetDescriptor<ComboBox> TRIGGER_TYPE = declare("Trigger Type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BASIS_FOR_TIME_BASED_CALCULATION = declare("Basis for Time-based Calculation", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> PENDED_TRANSACTION_HANDLING = declare("Pended Transaction Handling", RadioGroup.class);
        public static final AssetDescriptor<TextBox> OF_DAYS_ALLOWED_FOR_RENEWAL_LAPSE = declare("# of Days allowed for Renewal Lapse", TextBox.class);
        public static final AssetDescriptor<TextBox> DO_NOT_PROCESS_OF_DAYS_BEFORE_TERM_EXPIRES = declare("Do not process # of Days before term expires", TextBox.class);
        public static final AssetDescriptor<RadioGroup> RATE_POLICY = declare("Rate Policy?", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> GENERATE_DOCS = declare("Generate Docs?", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> GENERATE_TASKS = declare("Generate Tasks?", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> POLICIES_FLAGGED_FOR_MANUAL_RENEW = declare("Policies flagged for Manual Renew", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> POLICIES_FLAGGED_AS_DO_NOT_RENEW = declare("Policies flagged as Do Not Renew", RadioGroup.class);
        public static final AssetDescriptor<RadioGroup> POLICIES_FLAGGED_FOR_CANCEL_NOTICE = declare("Policies flagged for Cancel Notice", RadioGroup.class);
        public static final AssetDescriptor<AdvancedSelector> ADDITIONAL_POLICY_SELECTION_RULES_ACTION = declare("Additional Policy Selection Rules Action", AdvancedSelector.class);
        public static final AssetDescriptor<TextBox> INITIATE_QUOTE = declare("Initiate Quote", TextBox.class);
        public static final AssetDescriptor<TextBox> RUN_REPORTS_SERVICES = declare("Run Reports/Services", TextBox.class);
        public static final AssetDescriptor<TextBox> RATE_QUOTE = declare("Rate Quote", TextBox.class);
        public static final AssetDescriptor<TextBox> OFFER_ISSUE_QUOTE = declare("Offer/Issue Quote", TextBox.class);
    }

    public static final class SearchByField extends MetaData {
        public static final AssetDescriptor<TextBox> STRATEGY_ID = declare("Strategy ID", TextBox.class);
    }

    public static final class NewProductTab extends MetaData {
        public static final AssetDescriptor<TextBox> PRODUCT_CODE = declare("Product code", TextBox.class, By.id("product:productCd"));
        public static final AssetDescriptor<DatePicker> PRODUCT_EFFECTIVE_DATE = declare("Product effective date", DatePicker.class);
        public static final AssetDescriptor<TextBox> PRODUCT_NAME = declare("Product name", TextBox.class, By.id("product:productName"));
        public static final AssetDescriptor<DatePicker> APPLIES_TO_POLICY_EFFECTIVE_DATE = declare("Applies to policy effective date", DatePicker.class, By.id("product:usedForPolicyEffectiveDate"));
        public static final AssetDescriptor<DatePicker> APPLIES_TO_ENDORSEMENT_EFFECTIVE_DATE = declare("Applies to endorsement effective date", DatePicker.class, By.id("product:availableForTxDate"));
        public static final AssetDescriptor<ComboBox> BROAD_LINE_OF_BUSINESS = declare("Broad line of business", ComboBox.class, By.id("product:broadLobCd"));
        public static final AssetDescriptor<ComboBox> LINE_OF_BUSINESS = declare("Line of business", ComboBox.class, By.id("product:lobCd"));
        public static final AssetDescriptor<ComboBox> POLICY_TERM_TYPE = declare("Policy term type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> POLICY_CHANGES_ALLOWED_AT = declare("Policy changes allowed at", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RENEWAL_TYPES_ALLOWED = declare("Renewal types allowed", ComboBox.class);
        public static final AssetDescriptor<TextBox> PRODUCT_DESCRIPTION = declare("Product description", TextBox.class);
    }

    public static final class HomeTab extends MetaData {
        public static final AssetDescriptor<PFTextBox> ROOT_NAME = declare("Name", PFTextBox.class, Waiters.DEFAULT, false,
                By.xpath("//input[@id='entityConfigurationCreationForm:entityConfigurationDtoData_entityName']"));
        public static final AssetDescriptor<PFComboBox> ROOT_TYPE = declare("Type", PFComboBox.class, Waiters.DEFAULT, false,
                By.id("entityConfigurationCreationForm:entityConfigurationDtoData_rootEntityType"));
        public static final AssetDescriptor<PFTextBox> ROOT_SUBTYPE = declare("Sub Type", PFTextBox.class, Waiters.DEFAULT, false,
                By.id("entityConfigurationCreationForm:entityConfigurationDtoData_entitySubtype"));
        public static final AssetDescriptor<PFCheckBox> ROOT_ENTRY_POINT = declare("Entry Point", PFCheckBox.class, Waiters.DEFAULT, false,
                By.xpath("//label[input[@id='entityConfigurationCreationForm:entityConfigurationDtoData_entryPointInd']]"));

    }

    public static final class PropertiesTab extends MetaData {
    }

    public static final class ActionsTab extends MetaData {
    }

    public static final class ComponentsTab extends MetaData {
        public static final AssetDescriptor<PFTextBox> ATTRIBUTE_LABEL = declare("Attribute label", PFTextBox.class,
                By.id("attribute-label:label"));
        public static final AssetDescriptor<PFTextBox> REFERENCE_NAME = declare("Reference name", PFTextBox.class,
                By.id("component-reference:name"));
        public static final AssetDescriptor<PFTextBox> COMPONENT_LABEL = declare("Component label", PFTextBox.class,
                By.id("component-label:label"));
        public static final AssetDescriptor<PFCheckBox> SHOW_COMPONENT_LABEL = declare("Show component label", PFCheckBox.class,
                By.xpath("//label[input[@id='component-label:show']]"));
        public static final AssetDescriptor<PFCheckBox> HIDE_COMPONENT_LABEL_IF_NOT_INSTANTIATED = declare("Hide component label if not instantiated", PFCheckBox.class,
                By.xpath("//label[input[@id='component-label:hide-empty']]"));
        public static final AssetDescriptor<PFTextBox> INSTANCE_LABEL = declare("Instance label", PFTextBox.class,
                By.id("instance-label:label"));
        public static final AssetDescriptor<PFTextBox> INSTANCE_SUMMARY = declare("Instance summary", PFTextBox.class,
                By.id("instance-summary:summary"));
        public static final AssetDescriptor<PFTextBox> SERIALIZATION_XPATH = declare("Serialization XPath", PFTextBox.class,
                By.id("serialization:xpath"));
        public static final AssetDescriptor<PFComboBox> INSTANCE_TABLE_DROPDOWN = declare("Instance table dropdown", PFComboBox.class,
                By.id("instance-table:vertical"));
        public static final AssetDescriptor<PFCheckBox> SHOW_TABLE_EVEN_IF_NO_INSTANCES_ARE_CREATED = declare("Show table if at least one instance exists", PFCheckBox.class,
                By.xpath("//label[input[@id='instance-table:show-empty']]"));
        public static final AssetDescriptor<PFCheckBox> HIDE_REMOVE_ACTION = declare("Hide remove action", PFCheckBox.class,
                By.xpath("//label[input[@id='instance-table:hideComponentInstanceRemoveInList']]"));
        public static final AssetDescriptor<PFCheckBox> HIDE_TABLE = declare("Hide table", PFCheckBox.class,
                By.xpath("//label[input[@id='instance-table:hide']]"));
        public static final AssetDescriptor<PFCheckBox> SHOW_CUSTOM_COLUMNS = declare("Show custom columns", PFCheckBox.class,
                By.xpath("//label[input[@id='instance-table:multi-columns']]"));
        public static final AssetDescriptor<PFTextBox> TABLE_LABEL = declare("Table label", PFTextBox.class,
                By.id("instance-table:label"));
        public static final AssetDescriptor<PFCheckBox> HIDE_DEFAULT_LABEL = declare("Hide default label", PFCheckBox.class,
                By.xpath("//label[input[@id='instance-table:empty']]"));
        public static final AssetDescriptor<PFTextBox> ROWS = declare("Rows", PFTextBox.class,
                By.id("instance-table:rows"));
        public static final AssetDescriptor<PFCheckBox> HIDE_ROW_NUMBERS = declare("Hide row numbers", PFCheckBox.class,
                By.xpath("//label[input[@id='instance-table:hide-row-numbers']]"));
        public static final AssetDescriptor<PFComboBox> INSTANCE_TABLE_BUTTONS_VERTICAL = declare("Instance table buttons vertical", PFComboBox.class,
                By.id("instance-table-buttons:vertical"));
        public static final AssetDescriptor<PFComboBox> INSTANCE_TABLE_BUTTONS_HORIZONTAL = declare("Instance table buttons horizontal", PFComboBox.class,
                By.id("instance-table-buttons:horizontal"));
        public static final AssetDescriptor<PFCheckBox> HIDE_ADD_BUTTON = declare("Hide add button", PFCheckBox.class,
                By.xpath("//label[input[@id='instance-table-buttons:add']]"));
        public static final AssetDescriptor<PFCheckBox> HIDE_REMOVE_BUTTON = declare("Hide remove button", PFCheckBox.class,
                By.xpath("//label[input[@id='instance-table-buttons:remove']]"));

        //set conditions
        public static final AssetDescriptor<PFButton> BUTTON_SET_CONDITIONS = declare("Button Set Conditions", PFButton.class, Waiters.SLEEP, false,
                By.id("manage-applicability:manage"));
        public static final AssetDescriptor<PFTextBox> OPTIONAL_QUESTION = declare("Optional question", PFTextBox.class,
                By.xpath("//input[@id='applicability:optional-question']"));
        public static final AssetDescriptor<PFCheckBox> HIDE_OPTIONAL_QUESTION_POP_UP = declare("Hide optional question pop-up", PFCheckBox.class,
                By.xpath("//label[input[@id='applicability:optional-question-popup']]"));
        public static final AssetDescriptor<PFCheckBox> OPTIONAL_QUESTION_IS_REQUIRED = declare("Optional question is required", PFCheckBox.class,
                By.xpath("//label[input[@id='applicability:optional-question-required']]"));
        public static final AssetDescriptor<PFTextBox> OPTIONAL_QUESTION_REQUIRED_EXPRESSION = declare("Optional question required expression", PFTextBox.class,
                By.id("applicability:optional-question-required-expression"));
        public static final AssetDescriptor<PFTextBox> OPTIONAL_QUESTION_TOOLTIP = declare("Optional question tooltip", PFTextBox.class,
                By.xpath("//input[@id='applicability:optional-question-tooltip']"));
        public static final AssetDescriptor<PFComboBox> ANSWER_COMOBOX = declare("Answer combobox", PFComboBox.class,
                By.id("applicability:optional-question-answer"));
        public static final AssetDescriptor<PFTextBox> APPLICABILITY_EXPRESSION = declare("Applicability expression", PFTextBox.class,
                By.xpath("//textarea[@id='applicability:applicability-rule']"));
        public static final AssetDescriptor<PFTextBox> APPLICABILITY_DESCRIPTION = declare("Applicability description", PFTextBox.class,
                By.xpath("//textarea[@id='applicability:applicability-rule-description']"));
        public static final AssetDescriptor<PFButton> BUTTON_APPLICABILITY_SAVE = declare("Applicability Save", PFButton.class, By.id("applicability:save"));


        public static final AssetDescriptor<ProductFactoryCheckBox> REQUIRED = declare("Required", ProductFactoryCheckBox.class,
                By.xpath("//input[@id='manage-attribute-validation:required']"));
        public static final AssetDescriptor<PFButton> BUTTON_SET_PROPERTIES = declare("Button Set Properties", PFButton.class, Waiters.SLEEP, false,
                By.id("manage-component-properties:manage"));
        public static final AssetDescriptor<PFTextBox> COVERAGE_CD = declare("CoverageCd", PFTextBox.class,
                By.xpath("//label[.='CoverageCd']//following-sibling::input"));
        public static final AssetDescriptor<PFButton> BUTTON_SAVE = declare("Button Save", PFButton.class, By.id("component-properties:save"));

        //conditions metaData
        public static final AssetDescriptor<PFLink> SET_CONDITION_ADD = declare("Set condition Hide add button", PFLink.class,
                Waiters.DEFAULT.then(Waiters.SLEEP(500)), By.id("instance-table-buttons:set-add-condition"));
        public static final AssetDescriptor<PFTextBox> VISIBILITY_EXPRESSION_ADD = declare("Visibility Expression Add", PFTextBox.class,
                By.xpath("//textarea[@id='add-condition:add-condition-expression']"));
        public static final AssetDescriptor<PFButton> SAVE_CONDITION_ADD = declare("Save Condition Add", PFButton.class,
                Waiters.DEFAULT.then(Waiters.SLEEP(500)), By.id("add-condition:save"));

        public static final AssetDescriptor<PFLink> SET_CONDITION_REMOVE = declare("Set condition Remove add button", PFLink.class,
                Waiters.DEFAULT.then(Waiters.SLEEP(500)), By.id("instance-table-buttons:set-remove-condition"));
        public static final AssetDescriptor<PFTextBox> VISIBILITY_EXPRESSION_REMOVE = declare("Visibility Expression Remove", PFTextBox.class,
                By.xpath("//textarea[@id='remove-condition:remove-condition-expression']"));
        public static final AssetDescriptor<PFButton> SAVE_CONDITION_REMOVE = declare("Save Condition Remove", PFButton.class,
                Waiters.DEFAULT.then(Waiters.SLEEP(500)), By.id("remove-condition:save"));


        public static final class CreateAttribute extends MetaData {
            public static final AssetDescriptor<PFTextBox> ATTRIBUTE_NAME = declare("Attribute name", PFTextBox.class, By.id("attribute-create:name"));
            public static final AssetDescriptor<PFTextBox> ATTRIBUTE_LABEL = declare("Attribute label", PFTextBox.class, By.id("attribute-create:label"));
            public static final AssetDescriptor<PFComboBox> DATA_TYPE = declare("Data type", PFComboBox.class, By.id("attribute-create:type"));
        }

        public static final class CustomizeColumns extends MetaData {
            public static final AssetDescriptor<PFTextBox> LABEL = declare("Label", PFTextBox.class, By.xpath("//input[@id='component-column:label']"));
            public static final AssetDescriptor<PFTextBox> VALUE_EXPRESSION = declare("Value expression", PFTextBox.class, By.xpath("//textarea[@id='component-column:expression']"));
            public static final AssetDescriptor<PFTextBox> WIDTH = declare("Width", PFTextBox.class, By.xpath("//input[@id='component-column:width']"));
            public static final AssetDescriptor<PFCheckBox> FILTERABLE = declare("Filterable", PFCheckBox.class, By.xpath("//label[input[@id='component-column:filter']]"));
        }
    }

    public static final class WorkspacesTab extends MetaData {
        public static final AssetDescriptor<PFTextBox> WORKSPACE_NAME = declare("Workspace Name", PFTextBox.class,
                Waiters.DEFAULT.then(Waiters.SLEEP(3000)), By.id("ws-name:name"));
    }

    public static final class RulesTab extends MetaData {
        public static final class RuleSearch extends MetaData {
            public static final AssetDescriptor<PFTextBox> RULE_NAME = declare("Rule name", PFTextBox.class, By.xpath("//input[@name='name']"));
        }

        public static final class RuleProperties extends MetaData {
            public static final AssetDescriptor<PFTextBox> RULE_NAME = declare("Rule name", PFTextBox.class, By.xpath("//input[@name='name']"));
            public static final AssetDescriptor<PFTextBox> APPLIED_TO = declare("Applied to", PFTextBox.class, By.xpath("//input[@name='appliedTo']"));
            public static final AssetDescriptor<PFTextBox> DESCRIPTION = declare("Description", PFTextBox.class, By.xpath("//textarea[@name='description']"));
            public static final AssetDescriptor<PFTextBox> ERROR_MEAASGE = declare("Error Meaasge", PFTextBox.class, By.xpath("//textarea[@name='errorMessage']"));
            public static final AssetDescriptor<MdCheckBox> DISABLE_RULE = declare("Disable rule", MdCheckBox.class,
                    By.xpath("//md-checkbox[@aria-label='Disable rule']"));
            public static final AssetDescriptor<MdCheckBox> GLOBAL = declare("Global", MdCheckBox.class,
                    By.xpath("//md-checkbox[@aria-label='Global']"));
            public static final AssetDescriptor<PFTextBox> ASSERTION_EXPRESSION = declare("Assertion expression", PFTextBox.class, By.xpath("//div[@name='assertionExpression']//textarea"));
            public static final AssetDescriptor<PFTextBox> CONDITION_EXPRESSION = declare("Condition expression", PFTextBox.class, By.xpath("//div[@name='conditionExpression']//textarea"));
            public static final AssetDescriptor<PFTextBox> DEFAULT_VALUE_EXPRESSION = declare("Default value expression", PFTextBox.class,
                    By.xpath("//div[@name='defaultValueExpression']//textarea"));
        }
    }

    public static final class RuleSetsTab extends MetaData {
    }

    public static final class ProductProductFactorySearch extends MetaData {
        public static final AssetDescriptor<TextBox> STRATEGY_ID = declare("Strategy ID", TextBox.class);
        public static final AssetDescriptor<TextBox> PRODUCT_NAME = declare("Product Name", TextBox.class);
        public static final AssetDescriptor<TextBox> PRODUCT_CODE = declare("Product Code", TextBox.class);
        public static final AssetDescriptor<ComboBox> LINE_OF_BUSINESS = declare("Line of Business", ComboBox.class);
        public static final AssetDescriptor<ComboBox> BROAD_LINE_OF_BUSINESS = declare("Broad Line of Business", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PRODUCT_TYPE = declare("Product Type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> STATUS = declare("Status", ComboBox.class);
    }

    public static final class ProductProductFactorySelectProductType extends MetaData {
        public static final AssetDescriptor<ComboBox> PRODUCT_TYPE = declare("Product Type", ComboBox.class, By.id("productTypeSelectForm:selectedNewProductType"));
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
                By.id("productTypeSelectForm:productTypeSelectFormSubmit"));
    }

    public static final class ProductProductFactoryExpire extends MetaData {
        public static final AssetDescriptor<TextBox> EXPIRATION_DATE = declare("Expiration Date:", TextBox.class);
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP = declare(AbstractDialog.getDefaultPopupSubmitterName(),
                Button.class, By.id("editProductExpDateForm:productExpDateEditButton"));
    }

    public static final class ProductProductFactoryImport extends MetaData {
        public static final AssetDescriptor<Button> ZIP_TYPE = declare("Zip type", Button.class,
                By.xpath("//table[contains(@id,'importType')]//td[label[.='Zip']]/preceding-sibling::td//div[contains(@class,'ui-radiobutton-box')]"));
        public static final AssetDescriptor<Button> FOLDER_TYPE = declare("Folder type", Button.class,
                By.xpath("//table[contains(@id,'importType')]//td[label[.='Folder']]/preceding-sibling::td//div[contains(@class,'ui-radiobutton-box')]"));
        public static final AssetDescriptor<Button> DELETE_BEFORE_IMPORT = declare("Delete before import", Button.class,
                By.xpath("//table[contains(@id,'importDelete')]//td[label[.='Yes']]/preceding-sibling::td//div[contains(@class,'ui-radiobutton-box')]"));
        public static final AssetDescriptor<Button> DO_NOT_DELETE_BEFORE_IMPORT = declare("Do not delete before import", Button.class,
                By.xpath("//table[contains(@id,'importDelete')]//td[label[.='No']]/preceding-sibling::td//div[contains(@class,'ui-radiobutton-box')]"));
        public static final AssetDescriptor<FileUpload> IMPORT_FILE = declare("Import file", FileUpload.class,
                By.xpath("//form[@id='importProductForm']//input[@id='file']"));

        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(),
                Button.class, Waiters.DEFAULT, false, By.id("searchForm:importBtn"));
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP = declare(AbstractDialog.getDefaultPopupSubmitterName(),
                Button.class, Waiters.DEFAULT, false, By.id("importProductForm:importProductOk"));
    }

    public static final class ProductProductFactoryCopy extends MetaData {
        public static final AssetDescriptor<TextBox> NEW_PRODUCT_CODE = declare("New product code", TextBox.class);
        public static final AssetDescriptor<TextBox> NEW_PRODUCT_NAME = declare("New product name", TextBox.class);
        public static final AssetDescriptor<TextBox> APPLIES_TO_PRODUCT_EFFECTIVE_DATE = declare("Applies to product effective date", TextBox.class);
        public static final AssetDescriptor<TextBox> APPLIES_TO_ENDORSEMENT_EFFECTIVE_DATE = declare("Applies to endorsement effective date", TextBox.class);

        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
                By.id("copyProductForm:copyProductOk"));
    }

    public static final class PackagesTab extends MetaData {
        public static final AssetDescriptor<DialogAssetList> CREATE_TABLE =
                declare("Create table", DialogAssetList.class, ProductMetaData.PackagesTab.AddTableDialog.class, false, By.xpath("//md-dialog"));

        public static final class AddTableDialog extends MetaData {
            public static final AssetDescriptor<PFTextBox> NAME = declare("Name", PFTextBox.class, Waiters.SLEEP, By.xpath("//input[@name='name']"));
            public static final AssetDescriptor<PFJSClickComboBox> TYPE = declare("Type", PFJSClickComboBox.class, Waiters.SLEEP, By.xpath("//md-dialog"));
        }
    }
}
