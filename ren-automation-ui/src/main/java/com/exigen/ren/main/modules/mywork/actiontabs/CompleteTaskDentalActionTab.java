package com.exigen.ren.main.modules.mywork.actiontabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.main.modules.mywork.metadata.CompleteTaskDentalActionTabMetaData;
import org.openqa.selenium.By;

public class CompleteTaskDentalActionTab extends ActionTab {

    public static Button buttonComplete = new Button(By.id("taskCompleteForm:submitComplete_footer"));
    public static Button buttonCancel = new Button(By.id("taskCompleteForm:navigateBack_footer"));

    public CompleteTaskDentalActionTab() {
        super(CompleteTaskDentalActionTabMetaData.class);
    }

    @Override
    public Tab submitTab() {
        buttonComplete.click();
        return this;
    }
}
