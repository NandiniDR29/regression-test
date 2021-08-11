/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.agency.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class AgencyInfoMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> CHANNEL = declare("Channel", ComboBox.class);
    public static final AssetDescriptor<ComboBox> AGENCY_TYPE = declare("Agency Type", ComboBox.class);
    public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
    public static final AssetDescriptor<TextBox> AGENCY_CODE = declare("Agency Code", TextBox.class);
    public static final AssetDescriptor<TextBox> AGENCY_NAME = declare("Agency Name", TextBox.class);
    public static final AssetDescriptor<TextBox> AGENCY_NAME_ALTERNATE = declare("Agency Name - Alternate", TextBox.class);
    public static final AssetDescriptor<TextBox> AGENCY_EFFECTIVE_DATE = declare("Agency Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> AGENCY_EXPIRATION_DATE = declare("Agency Expiration Date", TextBox.class);
    public static final AssetDescriptor<TextBox> TAX_ID = declare("Tax ID", TextBox.class);
    public static final AssetDescriptor<TextBox> EXTERNAL_REFERENCE_ID = declare("External Reference ID", TextBox.class);
    public static final AssetDescriptor<RadioGroup> PRIMARY_AGENCY = declare("Primary Agency", RadioGroup.class);
    public static final AssetDescriptor<DialogSingleSelector> RELATED_PRIMARY_AGENCY = declare("Related Primary Agency", DialogSingleSelector.class, AddRelatedPrimaryAgency.class, false,
            By.id("searchPopupselectPrimaryAgency_container"));
    public static final AssetDescriptor<DialogSingleSelector> REGION = declare("Region", DialogSingleSelector.class, AddRegionMetaData.class, false, By.id("regionsSearch_container"));
    public static final AssetDescriptor<TextBox> ZONE = declare("Zone", TextBox.class);
    public static final AssetDescriptor<TextBox> OWNER_NAME = declare("Owner Name", TextBox.class);
    public static final AssetDescriptor<TextBox> COMPANY_REGISTRATION = declare("Company Registration #", TextBox.class);
    public static final AssetDescriptor<TextBox> FSP_NUMBER = declare("FSP Number", TextBox.class);
    public static final AssetDescriptor<RadioGroup> VAT_VENDOR = declare("VAT Vendor", RadioGroup.class);
    public static final AssetDescriptor<TextBox> VAT_NUMBER = declare("VAT Number", TextBox.class);
    public static final AssetDescriptor<ComboBox> LEVEL_AT_WHICH_FEES_ARE_DISBURSED = declare("Level at which Fees are disbursed", ComboBox.class);
    public static final AssetDescriptor<ComboBox> TIME_ZONE = declare("Time Zone", ComboBox.class);
    public static final AssetDescriptor<ComboBox> HOLIDAYS_CALENDAR = declare("Holidays Calendar", ComboBox.class);
    public static final AssetDescriptor<ComboBox> WORK_HOURS_CALENDAR = declare("Work Hours Calendar", ComboBox.class);
    public static final AssetDescriptor<AdvancedSelector> BRANDS = declare("Brands", AdvancedSelector.class,
            By.xpath("//table[@class='pfForm pfSimpleForm' and .//a[@id='brokerAgencyInfoForm:BrandsSelect']]"));
    public static final AssetDescriptor<RadioGroup> APPLICABLE_FOR_COMMISSIONS_EXTRACT = declare("Applicable for commissions Extract?", RadioGroup.class,
            Waiters.AJAX(60000).then(Waiters.SLEEP(5000)));
    public static final AssetDescriptor<ComboBox> COMMISSION_PAYMENT_SENT_TO = declare("Commission Payment Sent To", ComboBox.class);
    public static final AssetDescriptor<ComboBox> STATEMENT_DELIVERY_METHOD = declare("Statement Delivery Method", ComboBox.class);
    public static final AssetDescriptor<ComboBox> COMMISSION_PAYMENT_STATUS = declare("Commission Payment Status", ComboBox.class);
    public static final AssetDescriptor<AdvancedSelector> COMMISSION_GROUPS = declare("Commission Groups", AdvancedSelector.class);

    public static final AssetDescriptor<RadioGroup> ELIGIBLE_FOR_AGENCY_BILLING = declare("Eligible for Agency Billing?", RadioGroup.class);
    public static final AssetDescriptor<TextBox> AGENCY_BILL_DUE_DAY = declare("Agency Bill Due Day", TextBox.class);
    public static final AssetDescriptor<RadioGroup> EXCLUDE_COMMISSIONS_FROM_BILLING = declare("Exclude commissions from billing", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> RETAIN_COMMISSION_FROM_PAY = declare("Retain Commission From Pay", RadioGroup.class);

    public static final class AddRegionMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> NAME = declare("Name", TextBox.class, By.id("searchForm_regionsSearch:searchTemplate_regionsSearch"));

        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                By.id("brokerAgencyInfoForm:regionButton"));
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false,
                By.id("searchForm_regionsSearch:save_single_regionsSearch"));
    }

    public static final class AddRelatedPrimaryAgency extends MetaData {
        public static final AssetDescriptor<ComboBox> CHANNEL = declare("Channel", ComboBox.class);
        public static final AssetDescriptor<TextBox> AGENCY_NAME = declare("Agency Name", TextBox.class);

        public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class, Waiters.DEFAULT, false,
                By.id("brokerAgencyInfoForm:changePrimaryAgencyCd"));
    }
}
