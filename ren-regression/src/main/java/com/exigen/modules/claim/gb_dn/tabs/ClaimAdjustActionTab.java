package com.exigen.modules.claim.gb_dn.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.modules.claim.gb_dn.metadata.ClaimAdjustActionTabMetaData;
import org.openqa.selenium.By;

public class ClaimAdjustActionTab extends ActionTab {

    public static final Button buttonAdjustClaim = new Button(By.id("policyDataGatherForm:okProcessClaimActionBtn_ClaimsDentalAdjustClaimAction_footer"));

    public ClaimAdjustActionTab() {
        super(ClaimAdjustActionTabMetaData.class);
    }
}
