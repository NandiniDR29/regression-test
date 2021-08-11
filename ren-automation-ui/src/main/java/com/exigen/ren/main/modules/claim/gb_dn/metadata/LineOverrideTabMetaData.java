package com.exigen.ren.main.modules.claim.gb_dn.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.CheckBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.controls.AutoCompleteBox;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class LineOverrideTabMetaData extends MetaData {
    public static final AssetDescriptor<AssetList> RESULTS_OF_ADJUDICATION = declare("Results of Adjudication",
            AssetList.class, ResultsOfAdjudicationSection.class, By.xpath("//div[@id='policyDataGatherForm:componentView_DentalEvaluationFeature']"));
    public static final AssetDescriptor<AssetList> OVERRIDE_LINE_VALUES = declare("Override Line Values",
            AssetList.class, OverrideLineValuesSection.class, By.xpath("//div[@id='policyDataGatherForm:componentView_ClaimsDentalValuesOverride']"));
    public static final AssetDescriptor<AssetList> OVERRIDE_LINE_RULES = declare("Override Line Rules",
            AssetList.class, OverrideLineRulesSection.class, By.xpath("//div[@id='policyDataGatherForm:componentView_ClaimsDentalRulesOverride']"));
    public static final AssetDescriptor<AssetList> CONSULTANT_REVIEW = declare("Consultant Review",
            AssetList.class, ConsultantReviewSection.class, By.xpath("//div[@id='policyDataGatherForm:componentView_ClaimsDentalConsultantReview']"));
    public static final AssetDescriptor<AssetList> INFORMATION_REQUESTS = declare("Information Requests",
            AssetList.class, InformationRequestsSection.class, By.xpath("//div[@id='policyDataGatherForm:componentView_RenDentalInformationRequest']"));
    public static final AssetDescriptor<TextBox> REASON = declare("Reason", TextBox.class);

    public static final class OverrideLineValuesSection extends MetaData {
        public static final AssetDescriptor<TextBox> COPAY = declare("Copay", TextBox.class);
        public static final AssetDescriptor<AutoCompleteBox> COVERED_CDT_CODE = declare("Covered CDT Code", AutoCompleteBox.class);
        public static final AssetDescriptor<TextBox> CATEGORY = declare("Category", TextBox.class);
        public static final AssetDescriptor<TextBox> COINSURANCE_PERCENTAGE = declare("Coinsurance %", TextBox.class);
        public static final AssetDescriptor<TextBox> PATIENT_RESPONSIBILITY = declare("Patient Responsibility", TextBox.class);
        public static final AssetDescriptor<TextBox> COB_APPLIED = declare("COB Applied", TextBox.class);
        public static final AssetDescriptor<TextBox> COVERED = declare("Covered", TextBox.class, By.id("policyDataGatherForm:sedit_ClaimsDentalValuesOverride_covered"));
        public static final AssetDescriptor<TextBox> DEDUCTIBLE = declare("Deductible", TextBox.class, By.id("policyDataGatherForm:sedit_ClaimsDentalValuesOverride_deductible"));
        public static final AssetDescriptor<TextBox> COINSURANCE = declare("Coinsurance %", TextBox.class, By.id("policyDataGatherForm:sedit_ClaimsDentalValuesOverride_coinsurancePercentage"));
    }

    public static final class OverrideLineRulesSection extends MetaData {
        public static final AssetDescriptor<CheckBox> OVERRIDE_REMARK_CODE = declare("Override Remark Code", CheckBox.class);
        public static final AssetDescriptor<AutoCompleteBox> NEW_REMARK_CODE = declare("New Remark Code", AutoCompleteBox.class);
        public static final AssetDescriptor<CheckBox> ALLOW_SERVICE = declare("Allow Service", CheckBox.class);
        public static final AssetDescriptor<CheckBox> DENY_SERVICE = declare("Deny Service", CheckBox.class);
        public static final AssetDescriptor<CheckBox> PROCEDURE_REVIEW = declare("Procedure Review", CheckBox.class);
        public static final AssetDescriptor<CheckBox> SUBSTITUTION = declare("Substitution", CheckBox.class);
        public static final AssetDescriptor<CheckBox> SKIP_DIAGNOSTICS = declare("Skip Diagnostics", CheckBox.class);
        public static final AssetDescriptor<CheckBox> GENERAL_DUPLICATION = declare("General Duplication", CheckBox.class);
        public static final AssetDescriptor<CheckBox> BENEFIT_WAITING_PERIOD = declare("Benefit Waiting Period", CheckBox.class);
        public static final AssetDescriptor<CheckBox> AGE_LIMIT = declare("Age Limit", CheckBox.class);
        public static final AssetDescriptor<CheckBox> MAXIMUM_NOT_APPLICABLE = declare("Maximum Not Applicable", CheckBox.class);
        public static final AssetDescriptor<CheckBox> SUBMISSION_TIME_LIMIT = declare("Submission Time Limit", CheckBox.class);
        public static final AssetDescriptor<CheckBox> MEMBER_ELIGIBILITY = declare("Member Eligibility", CheckBox.class);
        public static final AssetDescriptor<CheckBox> FOCUSED_REVIEW = declare("Focused Review", CheckBox.class);
        public static final AssetDescriptor<CheckBox> SPECIAL_REVIEW = declare("Special Review", CheckBox.class);
    }

    public static final class ConsultantReviewSection extends MetaData {
        public static final AssetDescriptor<AutoCompleteBox> ALTERNATE_CDT_CODE = declare("Alternate CDT Code", AutoCompleteBox.class, Waiters.DEFAULT);
        public static final AssetDescriptor<TextBox> NOTES = declare("Notes", TextBox.class, By.id("policyDataGatherForm:sedit_ClaimsDentalConsultantReview_notes"));
        public static final AssetDescriptor<TextBox> CONSULTANT_REMARK_CODE = declare("Consultant Remark Code", TextBox.class);
    }

    public static final class ResultsOfAdjudicationSection extends MetaData {
        public static final AssetDescriptor<TextBox> DECISION = declare("Decision", TextBox.class);
        public static final AssetDescriptor<TextBox> COPAY = declare("Copay", TextBox.class);
        public static final AssetDescriptor<TextBox> CATEGORY = declare("Category", TextBox.class);
        public static final AssetDescriptor<TextBox> COINSURANCE = declare("Coinsurance %", TextBox.class, By.id("policyDataGatherForm:sedit_DentalEvaluationFeature_dentalFeature_coinsurancePercentage"));
    }

    public static final class InformationRequestsSection extends MetaData {
        public static final AssetDescriptor<AdvancedSelector> IR_CODES = declare("IR Codes", AdvancedSelector.class);
        public static final AssetDescriptor<TextBox> IR_DESCRIPTION_FOR_IR99999 = declare("IR Description for IR99999", TextBox.class);
    }
}
