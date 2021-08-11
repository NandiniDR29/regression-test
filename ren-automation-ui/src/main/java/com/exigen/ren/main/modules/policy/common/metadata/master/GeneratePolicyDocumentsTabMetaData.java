package com.exigen.ren.main.modules.policy.common.metadata.master;

import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class GeneratePolicyDocumentsTabMetaData extends MetaData {
    public static final AssetDescriptor<RadioGroup> GENERATE_MASTER_POLICY_DOCUMENT = declare("Generate Master Policy document", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> GENERATE_MASTER_POLICY_AND_CERTIFICATE_POLICY_DOCUMENTS = declare("Generate Master Policy and Certificate Policy documents", RadioGroup.class);
}
