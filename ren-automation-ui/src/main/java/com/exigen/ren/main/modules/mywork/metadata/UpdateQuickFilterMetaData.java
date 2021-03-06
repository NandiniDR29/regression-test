/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.mywork.metadata;

import com.exigen.ipb.eisa.controls.dialog.FilterDialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class UpdateQuickFilterMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> PRIORITY = declare("Priority", ComboBox.class);
    public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
            By.id("cloneableEditBtnId"));
    public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
            By.id("predefinedFilterPopup:createUpdateFilterPopup:updateMyWorkFilterButtonUpdate"));
    public static final AssetDescriptor<Button> BUTTON_DELETE = declare(FilterDialogAssetList.getDefaultDeleteButtonName(), Button.class, Waiters.DEFAULT, false,
            By.id("predefinedFilterPopup:createUpdateFilterPopup:updateMyWorkFilterButtonDelete"));
}
