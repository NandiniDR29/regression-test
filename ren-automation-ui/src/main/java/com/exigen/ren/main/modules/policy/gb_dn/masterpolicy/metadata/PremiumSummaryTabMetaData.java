/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */

package com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

public class PremiumSummaryTabMetaData extends MetaData {
    public static final AssetDescriptor<AssetList> EXPERIENCE_RATING = declare("Experience Rating", AssetList.class, ExperienceRatingMetaData.class, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<ComboBox> SELECT_RATING_CENSUS = declare("Select Rating Census", ComboBox.class);
    public static final AssetDescriptor<Button> APPLY = declare("Apply", Button.class, By.id("policyDataGatherForm:applyRatingCensusBtn"));
    public static final AssetDescriptor<Button> REMOVE = declare("Remove", Button.class, By.id("policyDataGatherForm:removeRatingCensusBtn"));
    public static final StaticElement APPLIED_RATING_CENSUS = new StaticElement(By.id("policyDataGatherForm:appliedCensusFileIdshow"));
    public static final AssetDescriptor<ComboBox> ASO_FEE_BASIS = declare("ASO Fee Basis", ComboBox.class, By.id("policyDataGatherForm:sedit_ASOFeeBasisViewOnly_asoRateBasis"));
    public static final AssetDescriptor<DialogAssetList> UPLOAD_FILE = declare("Upload File Dialog", DialogAssetList.class, com.exigen.ren.main.modules.policy.gb_vs.masterpolicy.metadata.PremiumSummaryTabMetaData.UploadFileDialog.class);
    public static final AssetDescriptor<Button> REMOVE_UPLOAD_FILE = declare("Remove Upload File", Button.class, By.id("policyDataGatherForm:removeAttachedFile"));
    public static final AssetDescriptor<DialogAssetList> VIEW_ADJUST_FINAL_RATES = declare("View/Adjust Final Rates", DialogAssetList.class, ViewAdjustFinalRates.class, false, By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER));
    public static final AssetDescriptor<AssetList> RATE_SECTION = declare("Rate", AssetList.class, RateMetaData.class);
    public static final AssetDescriptor<TextBox> PROPOSED_ASO_FEE = declare("Proposed ASO Fee", TextBox.class, By.id("policyDataGatherForm:renAsoFeeBasis:0:proposedAsoFeeMoney"));

    public static final class ExperienceRatingMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> EXPERIENCE_CLAIM_AMOUNT = declare("Experience Claim Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> CREDIBILITY_FACTOR = declare("Credibility Factor", TextBox.class);
    }

    public static final class RateMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> RATE_REQUEST_DATE = declare("Rate Request Date", TextBox.class);
        public static final AssetDescriptor<ComboBox> BROCHURE_RATE_PROGRAM = declare("Brochure Rate Program", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_RateDateViewOnlyComponent_brochureRateProgram']"));
        public static final AssetDescriptor<TextBox> RATING_FORMULA = declare("Rating Formula", TextBox.class);
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

    public static class ViewAdjustFinalRates extends MetaData {
        public static final AssetDescriptor<TextBox> FINAL_RATE_A_LA_CARTE_EMPLOYEE_ONLY = declare("Final Rate (Plan=A La Carte, Tier=Employee Only)", TextBox.class,
                By.xpath("//table[@class='width100 valignTop' and descendant::span[text()=' A La Carte'] and descendant::td[text()='Employee Only']]//input[contains(@id,'rateMoneyAmtInput_DENTALALACARTE')]"));
        public static final AssetDescriptor<TextBox> FINAL_RATE_DHMO_EMPLOYEE_ONLY = declare("Final Rate (Plan=DHMO, Tier=Employee Only)", TextBox.class,
                By.xpath("//table[@class='width100 valignTop' and descendant::span[text()=' DHMO'] and descendant::td[text()='Employee Only']]//input[contains(@id,'rateMoneyAmtInput_DHMO')]"));
        public static final AssetDescriptor<ComboBox> OVERRIDE_REASON_A_LA_CARTE_EMPLOYEE_ONLY = declare("Override Reason (Plan=A La Carte, Tier=Employee Only)", ComboBox.class,
                By.xpath("//table[@class='width100 valignTop' and descendant::span[text()=' A La Carte'] and descendant::td[text()='Employee Only']]//select[contains(@id,'overrideReasonCd_DENTALALACARTE')]"));
        public static final AssetDescriptor<ComboBox> OVERRIDE_REASON_DHMO_EMPLOYEE_ONLY = declare("Override Reason (Plan=DHMO, Tier=Employee Only)", ComboBox.class,
                By.xpath("//table[@class='width100 valignTop' and descendant::span[text()=' DHMO'] and descendant::td[text()='Employee Only']]//select[contains(@id,'overrideReasonCd_DHMO')]"));
        public static final AssetDescriptor<Button> DEFAULT_POPUP_OPENER_NAME = declare(AbstractDialog.getDefaultPopupOpenerName(),
                Button.class, Waiters.DEFAULT, false, By.id("policyDataGatherForm:callApplyFinalRatePopup"));
    }

}
