/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.policy.gb_vs.masterpolicy.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.FileUpload;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class PremiumSummaryTabMetaData extends MetaData {

    public static final AssetDescriptor<ComboBox> SELECT_RATING_CENSUS = declare("Select Rating Census", ComboBox.class);
    public static final AssetDescriptor<Button> APPLY = declare("Apply", Button.class, By.id("policyDataGatherForm:applyRatingCensusBtn"));
    public static final AssetDescriptor<AssetList> EXPERIENCE_RATING = declare("Experience Rating", AssetList.class, ExperienceRatingMetaData.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<DialogAssetList> UPLOAD_FILE = declare("Upload File Dialog", DialogAssetList.class, UploadFileDialog.class);
    public static final AssetDescriptor<Button> REMOVE = declare("Remove Upload File", Button.class, By.id("policyDataGatherForm:removeAttachedFile"));
    public static final AssetDescriptor<TextBox> RATE_REQUEST_DATE = declare("Rate Request Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> BROCHURE_RATE_PROGRAM = declare("Brochure Rate Program", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ASO_FEE_BASIS = declare("ASO Fee Basis", ComboBox.class);

    public static final class ExperienceRatingMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> EXPERIENCE_CLAIM_AMOUNT = declare("Experience Claim Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> CREDIBILITY_FACTOR = declare("Credibility Factor", TextBox.class);
    }

    public static class UploadFileDialog extends MetaData {
        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                By.id("policyDataGatherForm:areaMappingFileUploadPopupBtn"));
        public static final AssetDescriptor<Button> DEFAULT_POPUP_SUBMITTER_NAME = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
                By.id("fileUploadForm:saveFileUploadBtn"));
        public static final AssetDescriptor<TextBox> FILE_NAME = declare("File Name", TextBox.class);
        public static final AssetDescriptor<Button> BUTTON_ClOSE_POPUP = declare(AbstractDialog.getDefaultPopupCloserName(), Button.class, Waiters.DEFAULT, false,
                By.id("fileUploadForm:closeAreaMappingUploadPopupBtn"));
        public static final AssetDescriptor<FileUpload> FILE_UPLOAD = declare("File Upload", FileUpload.class, By.id("areaMappingFile"));
    }
}
