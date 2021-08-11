package com.exigen.ren.main.modules.claim.gb_dn.metadata;

import com.exigen.ipb.eisa.controls.AutoCompleteBox;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class PatientHistoryRecordTabMetaData extends MetaData {

    public static final AssetDescriptor<TextBox> PATIENT_ID = declare("Patient ID", TextBox.class);
    public static final AssetDescriptor<TextBox> POLICY = declare("Policy #", TextBox.class);
    public static final AssetDescriptor<TextBox> CLAIM = declare("Claim #", TextBox.class);
    public static final AssetDescriptor<TextBox> DOS = declare("DOS", TextBox.class);
    public static final AssetDescriptor<AutoCompleteBox> SUBMITTED_CDT_CODE = declare("Submitted CDT Code", AutoCompleteBox.class);
    public static final AssetDescriptor<AutoCompleteBox> COVERED_CDT_CODE = declare("Covered CDT Code", AutoCompleteBox.class);
    public static final AssetDescriptor<TextBox> TOOTH = declare("Tooth", TextBox.class);
    public static final AssetDescriptor<TextBox> ORAL_CAVITY = declare("Oral Cavity", TextBox.class);
    public static final AssetDescriptor<TextBox> IR_CODE = declare("IR Code", TextBox.class);
    public static final AssetDescriptor<TextBox> PROVIDER_ID = declare("Provider ID", TextBox.class);
    public static final AssetDescriptor<TextBox> SURFACE = declare("Surface", TextBox.class);
    public static final AssetDescriptor<ComboBox> DECISION = declare("Decision", ComboBox.class);
    public static final AssetDescriptor<ComboBox> INN_OON = declare("INN / OON", ComboBox.class);

}
