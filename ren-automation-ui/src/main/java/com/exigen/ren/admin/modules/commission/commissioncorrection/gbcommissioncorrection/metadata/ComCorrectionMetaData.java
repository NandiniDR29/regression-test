package com.exigen.ren.admin.modules.commission.commissioncorrection.gbcommissioncorrection.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class ComCorrectionMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> SALES_CHANNEL_TYPE = declare("Sales Channel Type", ComboBox.class);

    public static final AssetDescriptor<TextBox> POLICY = declare("Policy #", TextBox.class);
    public static final AssetDescriptor<TextBox> POLICY_EFFECTIVE_DATE_FROM = declare("Policy Effective Date From", TextBox.class);
    public static final AssetDescriptor<TextBox> POLICY_EFFECTIVE_DATE_TO = declare("Policy Effective Date To", TextBox.class);

    public static final AssetDescriptor<DialogAssetList>
            SALES_CHANNEL_AGENCY = declare("Sales Channel Agency", DialogAssetList.class, SalesChannelAgencySearchMetaData.class, By.id("correctionSearchForm:selectSalesChannelPopupBtn"));

    public static final AssetDescriptor<DialogSingleSelector> SALES_CHANNEL_INTERNAL =
            declare("Sales Channel Internal", DialogSingleSelector.class, SalesChIndividualSearchMetaData.class, By.id("correctionSearchForm:selectSalesChannelPopupBtn"));

    public static final class SalesChannelAgencySearchMetaData extends MetaData {
        public static final AssetDescriptor<Button> OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.AJAX, false, By.id("correctionSearchForm:selectSalesChannelPopupBtn"));
        public static final AssetDescriptor<Button> AGENCY = declare("Agency", Button.class, By.id("selectPopupForm:modeSelector:0"));
        public static final AssetDescriptor<Button> INDIVIDUAL = declare("Individual", Button.class, By.id("selectPopupForm:modeSelector:1"));

        public static final AssetDescriptor<TextBox> AGENCY_CODE = declare("Agency Code", TextBox.class);
        public static final AssetDescriptor<TextBox> AGENCY_NAME = declare("Agency Name", TextBox.class);
        public static final AssetDescriptor<TextBox> ZIP_CODE = declare("Zip code", TextBox.class);
        public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
        public static final AssetDescriptor<TextBox> STATE = declare("State", TextBox.class);

        public static final AssetDescriptor<Button> SEARCH_BUTTON = declare("Search", Button.class, By.id("selectPopupForm:popupSearchBtn"));
        public static final AssetDescriptor<Button> CLEAR_BUTTON = declare("Clear", Button.class, By.id("selectPopupForm:popupClearBtn"));
        public static final AssetDescriptor<Button> CANCEL_BUTTON = declare("Clear", Button.class, By.id("selectPopupForm:popupCloseBtn"));
    }

    public static final class SalesChIndividualSearchMetaData extends MetaData {
        public static final AssetDescriptor<Button> OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.AJAX, false, By.id("correctionSearchForm:selectSalesChannelPopupBtn"));
        public static final AssetDescriptor<Button> AGENCY = declare("Agency", Button.class, By.id("selectPopupForm:modeSelector:0"));
        public static final AssetDescriptor<Button> INDIVIDUAL = declare("Individual", Button.class, By.id("selectPopupForm:modeSelector:1"));

        public static final AssetDescriptor<TextBox> USER_LOGIN = declare("User Login", TextBox.class);
        public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
        public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);

        public static final AssetDescriptor<Button> SEARCH_BUTTON = declare("Search", Button.class, By.id("selectPopupForm:popupSearchBtn"));
        public static final AssetDescriptor<Button> CLEAR_BUTTON = declare("Clear", Button.class, By.id("selectPopupForm:popupClearBtn"));
        public static final AssetDescriptor<Button> CANCEL_BUTTON = declare("Clear", Button.class, By.id("selectPopupForm:popupCloseBtn"));

        public static final AssetDescriptor<Button> SUBMIT_POPUP = declare("Submit Popup", Button.class, By.id("ownerSearchForm:queueOk"));

    }
}
