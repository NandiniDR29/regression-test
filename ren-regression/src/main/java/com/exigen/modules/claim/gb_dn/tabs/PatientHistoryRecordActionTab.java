package com.exigen.modules.claim.gb_dn.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.claim.gb_dn.metadata.PatientHistoryRecordTabMetaData;
import org.openqa.selenium.By;

public class PatientHistoryRecordActionTab extends ActionTab {

    public static Button buttonAddPatientHistoryRecord = new Button(By.id("policyDataGatherForm:okProcessClaimActionBtn_ClaimsDentalAddPatientHistoryAction_footer"));
    public static Button buttonUpdatePatientHistoryRecord = new Button(By.id("policyDataGatherForm:okProcessClaimActionBtn_ClaimsDentalUpdatePatientHistoryAction_footer"));

    public PatientHistoryRecordActionTab() {
        super(PatientHistoryRecordTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        return this;
    }

}
