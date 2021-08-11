package com.exigen.ren.main.modules.policy.common.tabs.certificate;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.TextBox;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.modules.policy.common.metadata.certificate.ProcedureCodeSearchMetaData;
import org.openqa.selenium.By;

public class ProcedureCodeSearchTab extends ActionTab {
    public ProcedureCodeSearchTab() {
        super(ProcedureCodeSearchMetaData.class);
    }

    public static Table procedureCodesTable = new Table(By.xpath("//*[@id='policyDataGatherForm:sedit_RenGroupConfirmCoverageComponent_procedureCode_panel']/table"));


    public static void selectValueInProcedureCode(String procedureCode) {
        new TextBox(By.id("policyDataGatherForm:sedit_RenGroupConfirmCoverageComponent_procedureCode_input")).setValue(procedureCode);
        new Button(By.id("policyDataGatherForm:sedit_RenGroupConfirmCoverageComponent_procedureCode_panel")).click();
    }
}
