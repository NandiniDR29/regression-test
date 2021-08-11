package com.exigen.ren.main.modules.claim.gb_dn.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.modules.claim.gb_dn.metadata.PendClaimActionTabMetData;
import org.openqa.selenium.By;

public class PendClaimActionTab extends ActionTab {

    public static final Button buttonPendClaim = new Button(By.id("policyDataGatherForm:pendClaimBtn_DentalPendClaimActionComponent_footer"));

    public PendClaimActionTab() {
        super(PendClaimActionTabMetData.class);
    }
}
