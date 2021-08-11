package com.exigen.ren.main.modules.policy.common.metadata.certificate;

import com.exigen.ipb.eisa.controls.billingagent.ComboBox;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import org.openqa.selenium.By;

public class ProcedureCodeSearchMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> PLAN_NAME = declare("Plan Name", ComboBox.class, By.id("policyDataGatherForm:sedit_GroupCertificatePlan_policyPlan"));

    public static final AssetDescriptor<TextBox> PROCEDURE_CODE = declare("Procedure Code", TextBox.class);
    public static final AssetDescriptor<TextBox> DATE = declare("Date", TextBox.class);
    public static final AssetDescriptor<Button> VALIDATE = declare("Validate", Button.class, By.id("policyDataGatherForm:validateProcedureCode"));
    public static final AssetDescriptor<TextBox> CO_INSURANCE_IN_NETWORK = declare("Co-Insurance - In Network", TextBox.class);
    public static final AssetDescriptor<TextBox> CO_INSURANCE_OUT_NETWORK = declare("Co-Insurance - Out of Network", TextBox.class);
    public static final AssetDescriptor<TextBox> CO_INSURANCE_EPO = declare("Co-Insurance - EPO", TextBox.class);
    public static final AssetDescriptor<TextBox> SERVICE_CATEGORY_NAME = declare("Service Category Name", TextBox.class);
    public static final AssetDescriptor<TextBox> COVERED_NOT_COVERED_IN_NETWORK = declare("Covered / Not Covered - In Network", TextBox.class);
    public static final AssetDescriptor<TextBox> COVERED_NOT_COVERED_OUT_OF_NETWORK = declare("Covered / Not Covered - Out of Network", TextBox.class);
    public static final AssetDescriptor<TextBox> COVERED_NOT_COVERED_EPO = declare("Covered / Not Covered - EPO", TextBox.class);
}
