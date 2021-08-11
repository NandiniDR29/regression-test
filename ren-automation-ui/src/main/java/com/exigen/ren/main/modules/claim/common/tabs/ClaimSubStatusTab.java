package com.exigen.ren.main.modules.claim.common.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.main.modules.claim.common.metadata.ClaimSubStatusTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimTab.CLAIM_SUB_STATUS;

public class ClaimSubStatusTab extends DefaultTab {

    public static Button setClaimSubStatusButton = new Button(By.id("policyDataGatherForm:claimSubStatusBtn_ClaimsUpdateClaimSubStatusAction_footer"));

    public ClaimSubStatusTab() {
        super(ClaimSubStatusTabMetaData.class);
    }

    @Override
    public String getTabName() {
        return CLAIM_SUB_STATUS.get();
    }
}
