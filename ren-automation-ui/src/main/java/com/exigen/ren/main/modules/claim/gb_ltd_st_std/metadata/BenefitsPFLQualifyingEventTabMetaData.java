package com.exigen.ren.main.modules.claim.gb_ltd_st_std.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector2;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import org.openqa.selenium.By;

public class BenefitsPFLQualifyingEventTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> PFL_REASON = declare("PFL Reason", ComboBox.class);
    public static final AssetDescriptor<ComboBox> THE_FAMILY_MEMBER_IS_EMPLOYEES = declare("The family member is employee's:", ComboBox.class);
    public static final AssetDescriptor<ComboBox> CONTINUOUS_OF_PERIODIC = declare("Continuous or Periodic", ComboBox.class);

    public static final AssetDescriptor<ComboBox> TYPE = declare("Type", ComboBox.class);
    public static final AssetDescriptor<TextBox> DATE = declare("Date", TextBox.class);
    public static final AssetDescriptor<TextBox> DATE_OF_HIRE = declare("Date of hire", TextBox.class, Waiters.DEFAULT);
    public static final AssetDescriptor<TextBox> OCCUPATION_CODE = declare("Occupation Code", TextBox.class,Waiters.DEFAULT);

    public static final AssetDescriptor<TextBox> ADVANCE_NOTICE = declare("If providing less than 30 day's advance notice to the employer, please explain:", TextBox.class);
    public static final AssetDescriptor<RadioGroup> FORM_SUBMITTED_IN_ADVANCE = declare("Form submitted in Advance", RadioGroup.class,Waiters.DEFAULT);

    public static final AssetDescriptor<RadioGroup> REQUEST_REIMBURSEMENT =
            declare("If employee received or will receive full wages while on PFL, will employer be requesting reimbursement?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> FMLA_CONCURRENTLY_WITH_PFL = declare("FMLA concurrently with PFL", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> OTHER_DISABILITY = declare("Other Disability/ PFL in last 52 weeks", ComboBox.class);

    public static final AssetDescriptor<ComboBox> RELATIONSHIP_TO_PARTICIPANT = declare("Relationship to Participant", ComboBox.class);
    public static final AssetDescriptor<ComboBox> CHILD_GENDER = declare("Child's gender", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> LIVE_WITH_PARTICIPANT = declare("Live with participant?", RadioGroup.class);
    public static final AssetDescriptor<TextBox> CHILD_DATE_OF_BIRTH = declare("Child's date of birth", TextBox.class);
    public static final AssetDescriptor<RadioGroup> FOSTER_CARE_OR_ADOPTION_PLACEMENT = declare("Foster care or Adoption placement", RadioGroup.class);
    public static final AssetDescriptor<TextBox> DATE_OF_FOSTER_CARE_OR_ADOPTION_PLACEMENT = declare("Date of foster care or adoption placement", TextBox.class);

    public static final AssetDescriptor<TextBox> FIRST_DATE_CARE_FOR_PATIENT_IS_NEEDED = declare("First date care for patient is needed", TextBox.class);
    public static final AssetDescriptor<TextBox> EXPECTED_DATE_PATIENT_WILL_NO_LONGER_REQUIRE_CARE = declare(
            "Expected date patient will no longer require care", TextBox.class);
    public static final AssetDescriptor<TextBox> LICENSE_NUMBER = declare("License Number", TextBox.class);

    public static final AssetDescriptor<TextBox> BEGINNING_DATE = declare("Beginning Date", TextBox.class);
    public static final AssetDescriptor<TextBox> TO_DATE = declare("To Date", TextBox.class);
    public static final AssetDescriptor<AdvancedSelector2> REASON_TO_REQUEST_FOR_MILITARY =
            declare("Reason to request PFL for Military qualifying event", AdvancedSelector2.class, Waiters.AJAX, false);
    public static final AssetDescriptor<TextBox> OTHER_REASON = declare("Other Reason", TextBox.class);

    public static final AssetDescriptor<Button> ADD_PFL_DATE = declare("Add PFL Date",
            Button.class, By.id("policyDataGatherForm:addClaimsPaidFamilyLeaveDate"));
    public static final AssetDescriptor<Button> REMOVE_PFL_DATE = declare("Remove PFL Date",
            Button.class, By.id("policyDataGatherForm:eliminateClaimsPaidFamilyLeaveDate"));

    public static final AssetDescriptor<Button> ADD_HEALTH_CARE_PROVIDER_CERTIFICATION = declare("Add Health care provider certification",
            Button.class, By.id("policyDataGatherForm:addHealthCareProviderCertification"));
    public static final AssetDescriptor<Button> REMOVE_HEALTH_CARE_PROVIDER_CERTIFICATION = declare("Remove Health care provider certification",
            Button.class, By.id("policyDataGatherForm:eliminateHealthCareProviderCertification"));

    public static final AssetDescriptor<Button> ADD_HEALTH_CARE_PROVIDER_INFORMATION = declare("Add Health care provider Information",
            Button.class, By.id("policyDataGatherForm:addClaimsHCPInformation"));
    public static final AssetDescriptor<Button> REMOVE_HEALTH_CARE_PROVIDER_INFORMATION = declare("Remove Health care provider Information",
            Button.class, By.id("policyDataGatherForm:eliminateClaimsHCPInformation"));

    public static final AssetDescriptor<Button> ADD_MILITARY_QUALIFYING_EVENT_INFORMATION = declare("Add Military Qualifying Event Information",
            Button.class, By.id("policyDataGatherForm:addClaimsMilitaryQualifyingEventInformation"));
    public static final AssetDescriptor<Button> REMOVE_MILITARY_QUALIFYING_EVENT_INFORMATION = declare("Remove Military Qualifying Event Information",
            Button.class, By.id("policyDataGatherForm:eliminateClaimsMilitaryQualifyingEventInformation"));
}
