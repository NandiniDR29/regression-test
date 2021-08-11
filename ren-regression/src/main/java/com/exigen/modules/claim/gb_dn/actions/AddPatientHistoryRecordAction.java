package com.exigen.modules.claim.gb_dn.actions;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.gb_dn.tabs.PatientHistoryRecordActionTab;
import org.openqa.selenium.By;

public class AddPatientHistoryRecordAction implements Action {

    private Workspace workspace = new Workspace.Builder()
            .registerTab(PatientHistoryRecordActionTab.class)
            .build();

    @Override
    public String getName() {
        return "Add Patient History Record";
    }

    @Override
    public Workspace getWorkspace() {
        return workspace;
    }

    @Override
    public Action start() {
        NavigationPage.toSubTab(NavigationEnum.ClaimTab.PATIENT_HISTORY.get());
        new Button(By.xpath(String.format("//a[text()='%s']", getName()))).click();
        return this;
    }

    @Override
    public Action submit() {
        PatientHistoryRecordActionTab.buttonAddPatientHistoryRecord.click();
        return this;
    }

}
