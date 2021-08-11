package com.exigen.ren.main.modules.claim.gb_ac.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class BenefitCoverageEvaluationTabMetaData extends MetaData {

    public static final AssetDescriptor<AssetList> LIST_OF_COVERAGE = declare("List of Coverage", AssetList.class, PremiumWaiverIncidentMetaData.class);
    public static final AssetDescriptor<AssetList> COVERAGE_EVALUATION = declare("Coverage Evaluation", AssetList.class, CoverageEvaluationMetaData.class);

    public static final class PremiumWaiverIncidentMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> COVERAGE = declare("Coverage", ComboBox.class);
        public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective Date", TextBox.class);
    }

    public static final class CoverageEvaluationMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> ELIGIBILITY_VERIFIED = declare("Eligibility Verified", ComboBox.class);
        public static final AssetDescriptor<ComboBox> LIABILITY_DECISION = declare("Liability Decision", ComboBox.class);
        public static final AssetDescriptor<TextBox> DATE_OF_VERIFICATION = declare("Date of Verification", TextBox.class);
        public static final AssetDescriptor<TextBox> SUPPORTING_DOCUMENTTATION_RECEIVED = declare("Supporting Documentation Received", TextBox.class);
    }
}