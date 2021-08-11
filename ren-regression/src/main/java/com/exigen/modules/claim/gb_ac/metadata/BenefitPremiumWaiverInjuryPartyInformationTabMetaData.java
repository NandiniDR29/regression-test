package com.exigen.modules.claim.gb_ac.metadata;

import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class BenefitPremiumWaiverInjuryPartyInformationTabMetaData extends MetaData {

    public static final AssetDescriptor<Link> ADD_NEW_BENEFIT_PREMIIUM_WAIVER = declare("Add Benefit: Premium Waiver", Link.class, By.id("productConsolidatedViewForm:addDamagePremiumWaiver"));
    public static final AssetDescriptor<AssetList> PREMIUM_WAIVER_PARTY = declare("Premium Waiver Party", AssetList.class, PremiumWaiverPartyMetaData.class);
    public static final AssetDescriptor<AssetList> INJURY_PARTY_ADDRESS = declare("Injury Party Address", AssetList.class, InjuryPartyAddressMetaData.class);
    public static final AssetDescriptor<AssetList> DEPENDENT_ADDITIONAL_INFORMATION = declare("Dependent Additional Information", AssetList.class, DependentAdditionalInformationMetaData.class);
    public static final AssetDescriptor<AssetList> ELIGIBILITY_VERIFICATION_PARTICIPANT = declare("Eligibility Verification Participant", AssetList.class, EligibilityVerificationParticipantMetaData.class);
    public static final AssetDescriptor<AssetList> ELIGIBILITY_VERIFICATION_DEPENDENT = declare("Eligibility Verification Dependent", AssetList.class, EligibilityVerificationDependentMetaData.class);

    public static final class PremiumWaiverPartyMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> ASSOCIATE_POLICY_PARTY = declare("Associate Policy Party", ComboBox.class);
        public static final AssetDescriptor<ComboBox> RELATIONSHIP_TO_PARTICIPANT = declare("Relationship To Participant", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PREFIX = declare("Prefix", ComboBox.class);
        public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
        public static final AssetDescriptor<TextBox> MIDDLE_NAME = declare("Middle Name", TextBox.class);
        public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
        public static final AssetDescriptor<ComboBox> SUFFIX = declare("Suffix", ComboBox.class);
        public static final AssetDescriptor<TextBox> SOCIAL_SECURITY_NUMBER_SSN = declare("Social Security Number (SSN)", TextBox.class);
        public static final AssetDescriptor<TextBox> DATE_OF_BIRTH = declare("Date of Birth", TextBox.class);
        public static final AssetDescriptor<TextBox> CURRENT_AGE = declare("Current Age", TextBox.class);
        public static final AssetDescriptor<ComboBox> GENDER = declare("Gender", ComboBox.class);
        public static final AssetDescriptor<ComboBox> MARITAL_STATUS = declare("Marital Status", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PHONE_TYPE = declare("Phone Type", ComboBox.class);
        public static final AssetDescriptor<TextBox> PHONE = declare("Phone", TextBox.class);
        public static final AssetDescriptor<TextBox> EMAIL = declare("Email", TextBox.class);
        public static final AssetDescriptor<TextBox> FAX = declare("Fax", TextBox.class);
        public static final AssetDescriptor<ComboBox> CONTACT_PREFERENCE = declare("Contact Preference", ComboBox.class);
        public static final AssetDescriptor<ComboBox> PREFERRED_PAYMENT_METHOD = declare("Preferred Payment method", ComboBox.class);

        public static final AssetDescriptor<ComboBox> BANK_NAME = declare("Bank Name", ComboBox.class);
        public static final AssetDescriptor<TextBox> BANK_ACCOUNT_NUMBER = declare("Bank Account Number", TextBox.class);
        public static final AssetDescriptor<TextBox> BANK_TRANSIT_ROUTING_NUMBER = declare("Bank Transit / Routing Number", TextBox.class);
        public static final AssetDescriptor<Button> VIEW_BUTTON = declare("View", Button.class, By.id("policyDataGatherForm:sedit_PremiumWaiverParty_party_partyEFTDetails_bankAccountNumberUnmaskBtn"));
        public static final AssetDescriptor<ComboBox> BANK_ACCOUNT_TYPE = declare("Bank Account Type", ComboBox.class);
        public static final AssetDescriptor<RadioGroup> SUBJECT_TO_INTERNATIONAL_ACH_FORMATTING = declare("Subject to International ACH Formatting", RadioGroup.class);
    }

    public static final class InjuryPartyAddressMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> ADDRESS_TYPE = declare("Address Type", ComboBox.class);
        public static final AssetDescriptor<ComboBox> COUNTRY = declare("Country", ComboBox.class);
        public static final AssetDescriptor<TextBox> ZIP_POSTAL_CODE = declare("Zip / Postal Code", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_1 = declare("Address Line 1", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_2 = declare("Address Line 2", TextBox.class);
        public static final AssetDescriptor<TextBox> ADDRESS_LINE_3 = declare("Address Line 3", TextBox.class);
        public static final AssetDescriptor<TextBox> CITY = declare("City", TextBox.class);
        public static final AssetDescriptor<ComboBox> STATE_PROVINCE = declare("State / Province", ComboBox.class);
        public static final AssetDescriptor<TextBox> COUNTY = declare("County", TextBox.class);
    }

    public static final class DependentAdditionalInformationMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> FULL_TIME_DEPENDENT_STUDENT = declare("Full Time Dependent Student", ComboBox.class);
        public static final AssetDescriptor<ComboBox> DISABLED_DEPENDENT = declare("Disabled Dependent", ComboBox.class);
        public static final AssetDescriptor<ComboBox> EMPLOYED_DEPENDENT = declare("Employed Dependent", ComboBox.class);
    }

    public static final class EligibilityVerificationParticipantMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> VERIFIED_POLICY_PARTICIPANT = declare("Verified Policy Participant", ComboBox.class);
        public static final AssetDescriptor<TextBox> DATE_OF_VERIFICATION = declare("Date of Verification", TextBox.class);
    }

    public static final class EligibilityVerificationDependentMetaData extends MetaData {
        public static final AssetDescriptor<ComboBox> VERIFIED_POLICY_DEPENDENT = declare("Verified Policy Dependent", ComboBox.class);
        public static final AssetDescriptor<TextBox> DATE_OF_VERIFICATION = declare("Date of Verification", TextBox.class);
    }
}