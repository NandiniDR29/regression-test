/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.customer.metadata;

import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;

/**
 * Created by IGuliam on 11/19/2018.
 */
public class EmployeeInfoTabMetaData extends MetaData {
    public static final AssetDescriptor<TextBox> EMPLOYEE_ID = declare("Employee ID", TextBox.class);
    public static final AssetDescriptor<TextBox> JOB_TITLE = declare("Job Title", TextBox.class);
    public static final AssetDescriptor<ComboBox> JOB_CODE = declare("Job Code", ComboBox.class);
    public static final AssetDescriptor<TextBox> ORIGINAL_HIRE_DATE = declare("Original Hire Date", TextBox.class);
    public static final AssetDescriptor<ComboBox> EMPLOYMENT_STATUS = declare("Employment Status", ComboBox.class);
    public static final AssetDescriptor<TextBox> DEPARTMENT_ID = declare("Department ID", TextBox.class);
    public static final AssetDescriptor<TextBox> DIVISION_ID = declare("Division ID", TextBox.class);
    public static final AssetDescriptor<TextBox> LOCATION_ID = declare("Location ID", TextBox.class);
    public static final AssetDescriptor<ComboBox> EMPLOYEE_TYPE = declare("Employment Type", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> PAY_CLASS = declare("Pay Class", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> PAY_TYPE = declare("Pay Type", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> PAYROLL_FREQUENCY = declare("Payroll Frequency", ComboBox.class);
    public static final AssetDescriptor<TextBox> SALARY_AMOUNT = declare("Salary Amount", TextBox.class);
    public static final AssetDescriptor<RadioGroup> UNION_MEMBER = declare("Union Member", RadioGroup.class);
}
