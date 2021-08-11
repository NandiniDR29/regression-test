package com.exigen.ren.main.modules.policy.common.metadata.common;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class FoxBackPolicyInformationMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> PLAN_NAME = declare("Plan Name", ComboBox.class);

    public static final AssetDescriptor<AssetList> FAX_BACK_POLICY_INFORMATION = declare("Fax Back Policy Information", AssetList.class, FaxBackPolicyInfoMetaData.class);

    public static final class FaxBackPolicyInfoMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> DATE = declare("Date", TextBox.class);
        public static final AssetDescriptor<ComboBox> PATIENT_NAME = declare("Patient Name", ComboBox.class);
        public static final AssetDescriptor<Button> GENERATE_DOCUMENT = declare("Generate Document", Button.class, By.id("policyDataGatherForm:generateDocument"));
    }
}
