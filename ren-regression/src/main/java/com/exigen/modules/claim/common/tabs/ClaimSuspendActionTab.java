package com.exigen.modules.claim.common.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.modules.claim.common.metadata.ClaimSuspendActionTabMetaData;
import org.openqa.selenium.By;

public class ClaimSuspendActionTab extends ActionTab {
    public static Button buttonSuspendClaim = new Button(By.xpath("//input[@value='Suspend Claim' and not(contains(@style, 'none'))]"));

    public ClaimSuspendActionTab() {
        super(ClaimSuspendActionTabMetaData.class);
    }
}
