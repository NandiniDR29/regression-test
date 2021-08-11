package com.exigen.ren.admin.modules.commission.commissioncorrection.gbcommissioncorrection.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class ApplyManualComCorrectionMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> SALES_CHANNEL = declare("Sales Channel", ComboBox.class);
    public static final AssetDescriptor<AdvancedSelector> ADD_COVERAGE = declare("Add Coverage", AdvancedSelector.class, By.id("correctionApplyForm:addCoveragePopupBtn"));
}
