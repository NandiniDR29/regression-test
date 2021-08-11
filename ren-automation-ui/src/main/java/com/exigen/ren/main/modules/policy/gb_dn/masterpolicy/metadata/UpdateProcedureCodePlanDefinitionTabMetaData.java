package com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.metadata;

import com.exigen.ipb.eisa.controls.AutoCompleteBox;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.ComboBox;
import com.exigen.istf.webdriver.controls.RadioGroup;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.main.modules.policy.gb_dn.masterpolicy.tabs.PlanDefinitionIssueActionTab;
import org.openqa.selenium.By;

public class UpdateProcedureCodePlanDefinitionTabMetaData extends MetaData {

    public static final AssetDescriptor<RadioGroup> OVERRIDE_PROCEDURE_CODE_CO_INSURANCE = declare("Override Procedure Code Co-Insurance?", RadioGroup.class);

    public static final AssetDescriptor<PlanDefinitionIssueActionTab.ProcedureCodeCoInsuranceOverrideMultiAssetList> PROCEDURE_CODE_CO_INSURANCE_OVERRIDE =
            declare("Procedure Code Co-Insurance Override", PlanDefinitionIssueActionTab.ProcedureCodeCoInsuranceOverrideMultiAssetList.class, PlanDefinitionIssueActionTabMetaData.ProcedureCodeCoInsuranceOverride.class,
                    By.xpath("//div[@id='policyDataGatherForm:componentView_RenGroupProcedureOverriddenComponent_body']"));

    public static final class ProcedureCodeCoInsuranceOverride extends MetaData {
        public static final AssetDescriptor<Button> ADD_CODE = declare("Add Code", Button.class, By.id("policyDataGatherForm:addRenGroupProcedureOverriddenComponent"));
        public static final AssetDescriptor<AutoCompleteBox> PROCEDURE_CODE = declare("Procedure Code", AutoCompleteBox.class); //D1110
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_IN_NETWORK = declare("Co-Insurance - In Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_OUT_NETWORK = declare("Co-Insurance - Out of Network", ComboBox.class);
        public static final AssetDescriptor<ComboBox> CO_INSURANCE_EPO = declare("Co-Insurance - EPO", ComboBox.class);
    }
}
