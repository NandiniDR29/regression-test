package com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.metadata;

import com.exigen.ipb.eisa.controls.AutoCompleteBox;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.tabs.PlanDefinitionIssueActionTab;
import org.openqa.selenium.By;

public class PlanDefinitionIssueActionTabMetaData extends MetaData {

    public static final AssetDescriptor<RadioGroup> INCLUDE_RETIREES = declare("Include Retirees", RadioGroup.class);
    public static final AssetDescriptor<TextBox> MINIMUM_HOURLY_REQUIREMENT = declare("Minimum Hourly Requirement (hours per week)", TextBox.class);
    public static final AssetDescriptor<RadioGroup> ELIGIBILITY_WAITING_PERIOD_WAIVED_FOR_CURRENT_EMPLOYEES = declare("Eligibility Waiting Period Waived For Current Employees?", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> ELIGIBILITY_WAITING_PERIOD_DEFINITION = declare("Eligibility Waiting Period Definition", ComboBox.class);
    public static final AssetDescriptor<TextBox> DEPENDENT_MAXIMUM_AGE = declare("Dependent Maximum Age", TextBox.class);
    public static final AssetDescriptor<ComboBox> WAITING_PERIOD_MODE = declare("Waiting Period Mode", ComboBox.class);
    public static final AssetDescriptor<TextBox> WAITING_PERIOD = declare("Waiting Period", TextBox.class);
    public static final AssetDescriptor<TextBox> WAITING_PERIOD_AMOUNT = declare("Waiting Period Amount", TextBox.class);
    public static final AssetDescriptor<RadioGroup> OVERRIDE_PROCEDURE_CODE_CO_INSURANCE = declare("Override Procedure Code Co-Insurance?", RadioGroup.class);
    public static final AssetDescriptor<RadioGroup> ALLOW_MEMBER_AND_SPOUSE_ON_SEPARATE_CERTIFICATE = declare("Allow Member and Spouse (Who are part of Group) on Separate Certificate?", RadioGroup.class);
    public static final AssetDescriptor<ComboBox> BENEFITS_END_ON = declare("Benefits End On", ComboBox.class);

    public static final AssetDescriptor<PlanDefinitionIssueActionTab.ProcedureCodeCoInsuranceOverrideMultiAssetList> PROCEDURE_CODE_CO_INSURANCE_OVERRIDE =
            declare("Procedure Code Co-Insurance Override", PlanDefinitionIssueActionTab.ProcedureCodeCoInsuranceOverrideMultiAssetList.class, ProcedureCodeCoInsuranceOverride.class,
                    By.xpath("//div[@id='policyDataGatherForm:componentView_RenGroupProcedureOverriddenComponent_body']"));

    public static final class ProcedureCodeCoInsuranceOverride extends MetaData {
        public static final AssetDescriptor<Button> ADD_CODE = declare ("Add Code" , Button.class, By.id("policyDataGatherForm:addRenGroupProcedureOverriddenComponent") );
        public static final AssetDescriptor<AutoCompleteBox> PROCEDURE_CODE = declare("Procedure Code", AutoCompleteBox.class); //D1110
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_IN_NETWORK = declare("Co-Insurance - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_OUT_NETWORK = declare("Co-Insurance - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_EPO = declare("Co-Insurance - EPO", ComboBox.class);
    }

}
