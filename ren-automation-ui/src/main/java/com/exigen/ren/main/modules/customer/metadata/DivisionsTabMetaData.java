/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.main.modules.customer.tabs.DivisionsTab;

public class DivisionsTabMetaData extends MetaData{
    public static final AssetDescriptor<TextBox> DIVISION_NUMBER = declare("Division Number", TextBox.class);
    public static final AssetDescriptor<TextBox> DIVISION_NAME = declare("Division Name", TextBox.class);
    public static final AssetDescriptor<TextBox> NUMBER_OF_INSUREDS = declare("Number of Insureds", TextBox.class);
    public static final AssetDescriptor<ComboBox> BILLING_METHOD = declare("Billing Method", ComboBox.class);
    public static final AssetDescriptor<TextBox> EFFECTIVE_DATE = declare("Effective date", TextBox.class);
    public static final AssetDescriptor<TextBox> EXPIRATION_DATE = declare("Expiration Date", TextBox.class);

    public static final AssetDescriptor<DivisionsTab.AddressDetailsDivision> ADDRESS_DETAILS =
            declare("Address Details", DivisionsTab.AddressDetailsDivision.class, AddressDetailsDivisionMetaData.class);
    public static final AssetDescriptor<DivisionsTab.PhoneDetailsDivision> PHONE_DETAILS =
            declare("Phone Details", DivisionsTab.PhoneDetailsDivision.class, PhoneDetailsDivisionMetaData.class);
    public static final AssetDescriptor<DivisionsTab.EmailDetailsDivision> EMAIl_DETAILS =
            declare("Email Details", DivisionsTab.EmailDetailsDivision.class, EmailDetailsDivisionMetaData.class);
    public static final AssetDescriptor<DivisionsTab.ChatDetailsDivision> CHAT_DETAILS =
            declare("Chat Details", DivisionsTab.ChatDetailsDivision.class, ChatDetailsDivisionMetaData.class);
    public static final AssetDescriptor<DivisionsTab.WebUrlDetailsDivision> WEB_URL_DETAILS =
            declare("Web URL Details", DivisionsTab.WebUrlDetailsDivision.class, WebUrlDetailsDivisionMetaData.class);
    public static final AssetDescriptor<DivisionsTab.SocialNetDetailsDivision> SOCIAL_NET_DETAILS =
            declare("Social Net Details", DivisionsTab.SocialNetDetailsDivision.class, SocialNetDetailsDivisionMetaData.class);

    public static final class AddressDetailsDivisionMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> ADDRESS_TYPE = declare("Address Type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
        public static final AssetDescriptor<TextBox> ZIP_POST_CODE = declare("Zip/Post Code", TextBox.class);
        public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
        public static final AssetDescriptor<ComboBox> STATE_PROVINCE = declare("State/Province", ComboBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_1 = declare("Address Line 1", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_2 = declare("Address Line 2", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_3 = declare("Address Line 3", TextBox.class);
        public static final AssetDescriptor<TextBox> COMMENT = declare("Comment", TextBox.class);
        public static final AssetDescriptor<RadioGroup> MAKE_PREFERRED = declare("Make Preferred?", RadioGroup.class);
    }

    public static final class PhoneDetailsDivisionMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> PHONE_TYPE = declare("Phone Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> PHONE_NUMBER = declare("Phone Number", TextBox.class);
        public static final AssetDescriptor<TextBox> COMMENT = declare("Comment", TextBox.class);
        public static final AssetDescriptor<RadioGroup> MAKE_PREFERRED = declare("Make Preferred?", RadioGroup.class);
        public static final AssetDescriptor<ComboBox> CONSENT_STATUS = declare("Consent Status", ComboBox.class);
    }

    public static final class EmailDetailsDivisionMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> EMAIL_TYPE = declare("Email Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> EMAIL_ADDRESS = declare("Email Address", TextBox.class);
        public static final AssetDescriptor<TextBox> COMMENT = declare("Comment", TextBox.class);
        public static final AssetDescriptor<ComboBox> CONSENT_STATUS = declare("Consent Status", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> MAKE_PREFERRED = declare("Make Preferred?", RadioGroup.class);
    }

    public static final class ChatDetailsDivisionMetaData extends MetaData {
        public static final AssetDescriptor<TextBox> CHAT_ID = declare("Chat ID", TextBox.class);
        public static final AssetDescriptor<ComboBox> CHAT_TYPE = declare("Chat Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> COMMENT = declare("Comment", TextBox.class);
        public static final AssetDescriptor<RadioGroup> MAKE_PREFERRED = declare("Make Preferred?", RadioGroup.class);
    }

    public static final class WebUrlDetailsDivisionMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> WEB_URL_TYPE = declare("Web URL Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> WEB_URL = declare("Web URL", TextBox.class);
        public static final AssetDescriptor<TextBox> COMMENT = declare("Comment", TextBox.class);
        public static final AssetDescriptor<RadioGroup> MAKE_PREFERRED = declare("Make Preferred?", RadioGroup.class);
    }

    public static final class SocialNetDetailsDivisionMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> SOCIAL_NET_TYPE = declare("Social Net Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> SOCIAL_NET_ID = declare("Social Net ID", TextBox.class);
        public static final AssetDescriptor<TextBox> COMMENT = declare("Comment", TextBox.class);
        public static final AssetDescriptor<RadioGroup> MAKE_PREFERRED = declare("Make Preferred?", RadioGroup.class);
    }
}
