package com.exigen.ren.main.modules.policy.common.metadata.master;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.main.modules.policy.common.tabs.master.ChangeAgencyTab;

public class ChangeAgencyTabMetaData extends MetaData {

    public static final AssetDescriptor<ComboBox> REASON = declare("Reason", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> TRANSFER_TYPE = declare("Transfer Type", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> COMMISSION_IMPACT = declare("Commission Impact", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> TRANSFER_EFFECTIVE_DATE = declare("Transfer Effective Date", ComboBox.class);

    public static final AssetDescriptor< ChangeAgencyTab.TransferTarget> TRANSFER_TARGET =
            declare("Transfer - Target", ChangeAgencyTab.TransferTarget.class, TransferTargetMetaData.class);

    public static final class TransferTargetMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox>  AGENCY_PRODUCER = declare("Agency / Producer", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> PRIMARY_AGENCY = declare("Primary Agency?", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> AGENT_SUB_PRODUCER = declare("Agent Sub Producer", ComboBox.class);
        public static final AssetDescriptor<TextBox> SPLIT_PERCENTAGE = declare("Split Percentage", TextBox.class);
    }

}
