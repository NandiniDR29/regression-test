package com.exigen.ren.main.modules.caseprofile.tabs;

import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.caseprofile.metadata.CreateEnrolledCensusFileIntakeManagementTabMetaData;
import org.openqa.selenium.By;

public class CreateEnrolledCensusFileIntakeManagementTab extends DefaultTab {

    public static Button buttonExit = new Button(By.id("caseForm:cancelBtn_footer"));

    public static StaticElement labelCustomerName = new StaticElement(By.id("caseBannerForm:caseList_customerDisplayNameText"));
    public static StaticElement labelCustomerNumber = new StaticElement(By.id("caseBannerForm:caseList_customerNumberText"));
    public static StaticElement labelCustomerStatus = new StaticElement(By.id("caseBannerForm:caseList_statusText"));

    public CreateEnrolledCensusFileIntakeManagementTab() {
        super(CreateEnrolledCensusFileIntakeManagementTabMetaData.class);
    }

    public static void exitCreateEnrolledCensus() {
        buttonExit.click();
        Page.dialogConfirmation.buttonYes.click();
    }
}
