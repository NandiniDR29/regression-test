/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.gb_ltd_st_std.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class BenefitCoverageEvaluationTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> ELIGIBILITY_VERIFIED = declare("Eligibility Verified", ComboBox.class);
    public static final AssetDescriptor<ComboBox> LIABILITY_DECISION = declare("Liability Decision", ComboBox.class);
    public static final AssetDescriptor<TextBox> DATE_OF_VERIFICATION = declare("Date of Verification", TextBox.class);
    public static final AssetDescriptor<TextBox> SUPPORTING_DOCUMENTTATION_RECEIVED = declare("Supporting Documentation Received", TextBox.class);
    public static final AssetDescriptor<TextBox> INSURED_PERSON_COVERAGE_EFFECTIVE_DATE = declare("Insured Person Coverage Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> APPROVED_THROUGH_DATE = declare("Approved Through Date", TextBox.class);
}
