package com.exigen.ren.main.modules.claim.gb_dn.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

public class RecoveryDetailsActionTabMetaData extends MetaData {

    public static final AssetDescriptor<ComboBox> TYPE_OF_RECOVERY = declare("Type of Recovery", ComboBox.class);
    public static final AssetDescriptor<TextBox> RECOVERY_AMOUNT = declare("Recovery Amount", TextBox.class);
    public static final AssetDescriptor<ComboBox> RECOVERED_FROM = declare("Recovered From", ComboBox.class);
    public static final AssetDescriptor<TextBox> RECOVERY_POST_DATE = declare("Recovery Post Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> RECOVERY_METHOD = declare("Recovery Method", ComboBox.class);
    public static final AssetDescriptor<TextBox> BANK_ACCOUNT_NUMBER = declare("Bank Account Number", TextBox.class);
    public static final AssetDescriptor<TextBox> RECOVERY_MEMO = declare("Recovery Memo", TextBox.class);
    public static final AssetDescriptor<TextBox> CHECK = declare("Check #", TextBox.class);
    public static final AssetDescriptor<TextBox> DETAILS = declare("Details", TextBox.class);

}