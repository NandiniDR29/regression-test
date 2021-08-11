/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.claim.common.metadata;

import com.exigen.ipb.eisa.controls.AdvancedSelector;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class PolicyInformationParticipantParticipantCoverageTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> PLAN = declare("Plan", ComboBox.class);
    public static final AssetDescriptor<Button> ADD_COVERAGE = declare("Add Coverage", Button.class, By.id("policyDataGatherForm:addPrecClaimsPolicyRiskParticipantCoverage"));
    public static final AssetDescriptor<ComboBox> COVERAGE_NAME = declare("Coverage Name", ComboBox.class);
    public static final AssetDescriptor<TextBox> COVERAGE_EFFECTIVE_DATE = declare("Coverage Effective Date", TextBox.class);
    public static final AssetDescriptor<AdvancedSelector> COVERAGE_TYPE = declare("Coverage Type", AdvancedSelector.class);
    public static final AssetDescriptor<TextBox> COVERAGE_TYPE_TEXT_BOX = declare("Coverage Type Textbox", TextBox.class, By.id("policyDataGatherForm:sedit_PrecClaimsPolicyRiskParticipantCoverage_coverageType"));
    public static final AssetDescriptor<RadioGroup> SELF_ADMINISTERED = declare("Self-Administered?", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> ACCELERATED_BENEFIT = declare("Accelerated Benefit", ComboBox.class);
    public static final AssetDescriptor<TextBox> CONTINUATION = declare("Continuation", TextBox.class);
    public static final AssetDescriptor<TextBox> PORTABILITY = declare("Portability", TextBox.class);
    public static final AssetDescriptor<TextBox> ACCELERATED_BENEFIT_MINIMUM_PERCENTAGE = declare("Accelerated Benefit Minimum Percentage", TextBox.class);
    public static final AssetDescriptor<TextBox> ACCELERATED_BENEFIT_MAXIMUM_PERCENTAGE = declare("Accelerated Benefit Maximum Percentage", TextBox.class);
    public static final AssetDescriptor<TextBox> ACCELERATED_BENEFIT_MINIMUM_AMOUNT = declare("Accelerated Benefit Minimum Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> ACCELERATED_BENEFIT_MAXIMUM_AMOUNT = declare("Accelerated Benefit Maximum Amount", TextBox.class);
    public static final AssetDescriptor<ComboBox> COVERAGE_STATUS = declare("Coverage Status", ComboBox.class);
    public static final AssetDescriptor<TextBox> COVERAGE_EXPIRATION_DATE = declare("Coverage Expiration Date", TextBox.class);
    public static final AssetDescriptor<TextBox> BENEFIT_PERCENTAGE = declare("Benefit Percentage", TextBox.class);
    public static final AssetDescriptor<TextBox> ACCELERATED_BENEFIT_PERCENTAGE = declare("Accelerated Benefit Percentage", TextBox.class);
    public static final AssetDescriptor<ComboBox> ERISA_INDICATOR = declare("ERISA Indicator", ComboBox.class);
    public static final AssetDescriptor<ComboBox> LIMIT_LEVEL = declare("Limit Level", ComboBox.class);
    public static final AssetDescriptor<TextBox> BENEFIT_TYPE = declare("Benefit Type", TextBox.class);
    public static final AssetDescriptor<TextBox> BENEFIT_MINIMUM_AMOUNT = declare("Benefit Minimum Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> MINIMUM_SALARY_MULTIPLE = declare("Minimum Salary Multiple", TextBox.class);
    public static final AssetDescriptor<TextBox> MINIMUM_SALARY_PERCENTAGE = declare("Minimum Salary Percentage %", TextBox.class);
    public static final AssetDescriptor<TextBox> INCREMENT = declare("Increment", TextBox.class);
    public static final AssetDescriptor<TextBox> LIFETIME_BENEFIT_MAXIMUM_AMOUNT = declare("Lifetime Benefit Maximum Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> LIMIT_AMOUNT =
            declare("Limit Amount", TextBox.class, By.id("policyDataGatherForm:sedit_PrecClaimsRiskParticipantCoverageDetails_limitAmount"));
    public static final AssetDescriptor<ComboBox> LIMIT_AMOUNT_COMBOBOX =
            declare("Limit Amount Combobox", ComboBox.class, By.xpath("//select[@id='policyDataGatherForm:sedit_PrecClaimsRiskParticipantCoverageDetails_limitAmount']"));
    public static final AssetDescriptor<ComboBox> SALARY_MULTIPLE = declare("Salary Multiple", ComboBox.class);
    public static final AssetDescriptor<ComboBox> SALARY_PERCENTAGE = declare("Salary Percentage %", ComboBox.class);
    public static final AssetDescriptor<TextBox> BENEFIT_MAXIMUM_AMOUNT = declare("Benefit Maximum Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> COVERAGE_UP_TO_MAX_OF_EMPLOYEE_COVERAGE = declare("Coverage up to Max of Employee Coverage %", TextBox.class);
    public static final AssetDescriptor<TextBox> PERCENTAGE_OF_TAXABLE = declare("Percentage of Taxable", TextBox.class);
    public static final AssetDescriptor<TextBox> MAXIMUM_SALARY_MULTIPLE = declare("Maximum Salary Multiple", TextBox.class);
    public static final AssetDescriptor<TextBox> MAXIMUM_SALARY_PERCENTAGE = declare("Maximum Salary Percentage %", TextBox.class);
    public static final AssetDescriptor<ComboBox> VERIFIED_POLICY_PARTICIPANT = declare("Verified Policy Participant", ComboBox.class);
    public static final AssetDescriptor<TextBox> PARTICIPANT_COVERAGE_EFFECTIVE_DATE = declare("Participant Coverage Effective Date", TextBox.class);
    public static final AssetDescriptor<TextBox> DATE_LAST_WORKED = declare("Date Last Worked", TextBox.class);
    public static final AssetDescriptor<TextBox> DATE_OF_VERIFICATION = declare("Date of Verification", TextBox.class);
    public static final AssetDescriptor<TextBox> PARTICIPANT_COVERAGE_TERMINATION_DATE =
            declare("Participant Coverage Termination Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> PLAN_WAITING_PERIOD_DAYS = declare("Plan Waiting Period (Days)", ComboBox.class);
    public static final AssetDescriptor<TextBox> WAITING_PERIOD_DAYS = declare("Waiting Period (Days)", TextBox.class);

    public static final AssetDescriptor<TextBox> ELIMINATION_PERIOD_DAYS = declare("Elimination Period (days)", TextBox.class);
    public static final AssetDescriptor<ComboBox> ELIMINATION_PERIOD_SICKNESS = declare("Elimination Period - Sickness (Calendar Days)", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ELIMINATION_PERIOD_INJURY = declare("Elimination Period - Injury (Calendar Days)", ComboBox.class);
    public static final AssetDescriptor<ComboBox> ELIMINATION_PERIOD_CALENDAR_DAYS = declare("Elimination Period (Calendar Days)", ComboBox.class);
    public static final AssetDescriptor<TextBox> MAX_BENEFIT_PERIOD_WEEKS = declare("Maximum Benefit Period (Weeks)", TextBox.class); //REN-17784 - For STD/STAT/PFL, rename 'Maximum Benefit period Including EP (Weeks)' to 'Maximum Benefit Period (Weeks)'
    public static final AssetDescriptor<TextBox> MAX_BENEFIT_PERIOD_DAYS = declare("Maximum Benefit Period (Days)", TextBox.class); //REN-17784 - For STD/STAT/PFL, rename 'Maximum Benefit period Including EP (Weeks)' to 'Maximum Benefit Period (Weeks)'
    public static final AssetDescriptor<RadioGroup> END_OF_SALARY_CONTINUATION = declare("End of Salary Continuation", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> END_OF_ACCUMULATED_SICK_LEAVE = declare("End of Accumulated Sick Leave", RadioGroup.class);
    public static final AssetDescriptor<TextBox> ACCUMULATION_PERIOD = declare("Accumulation Period", TextBox.class);
    public static final AssetDescriptor<ComboBox> MAX_BENEFIT_PERIOD = declare("Max Benefit Period", ComboBox.class);
    public static final AssetDescriptor<ComboBox> BENEFIT_AMOUNT_LEVEL = declare("Benefit Amount Level", ComboBox.class);
    public static final AssetDescriptor<TextBox> BENEFIT_AMOUNT = declare("Benefit Amount", TextBox.class);
    public static final AssetDescriptor<ComboBox> RETROACTIVE_BENEFIT = declare("Retroactive Benefit", ComboBox.class);
    public static final AssetDescriptor<ComboBox> FICA_MATCH = declare("FICA Match", ComboBox.class);

    public static final AssetDescriptor<ComboBox> PARTIAL_DISABILITY_CALCULATION = declare("Partial Disability Calculation", ComboBox.class);
    public static final AssetDescriptor<ComboBox> EARNING_TEST = declare("Earning Test(%)", ComboBox.class);
    public static final AssetDescriptor<ComboBox> WIB_DURATION = declare("WIB Duration", ComboBox.class);
    public static final AssetDescriptor<ComboBox> REHABILITATION_INCENTIVE_BENEFIT = declare("Rehabilitation Incentive Benefit", ComboBox.class);
    public static final AssetDescriptor<ComboBox> INITIAL_COLA = declare("Initial COLA %", ComboBox.class);
    public static final AssetDescriptor<ComboBox> NUMBER_OF_ADJUSTMENTS = declare("Number of Adjustments", ComboBox.class);

    public static final AssetDescriptor<TextBox> GUARANTEED_ISSUE_AMOUNT = declare("Guaranteed Issue Amount", TextBox.class);
    public static final AssetDescriptor<RadioGroup> EOI_REQUIRED = declare("EOI Required?", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> EOI_STATUS = declare("EOI Status", ComboBox.class);
    public static final AssetDescriptor<TextBox> APPROVAL_DATE = declare("Approval Date", TextBox.class);
}
