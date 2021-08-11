package com.exigen.ren.main.modules.policy.common.tabs.master;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.policy.common.metadata.master.PolicyInfoEndorseNPBInfoActionTabMetaData;
import org.openqa.selenium.By;

public class PolicyInfoEndorseNPBInfoActionTab extends ActionTab {

    public static final StaticElement helpTextGroupIsMemberCompany = new StaticElement(By.id("policyDataGatherForm:sedit_Policy_groupIsMemberCompany_helpText"));
    public static Button buttonIssue = new Button(By.id("policyDataGatherForm:processPolicyNPBEActionButton_GroupMasterPolicyNPBEAction_footer"), doubleWaiter);

    public PolicyInfoEndorseNPBInfoActionTab() {
        super(PolicyInfoEndorseNPBInfoActionTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        Waiters.AJAX.then(Waiters.SLEEP(500)).go();
        buttonNext.click(doubleWaiter);
        return this;
    }
}
