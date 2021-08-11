/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.webstudio.pages;

import com.exigen.ipb.eisa.controls.webstudio.WSButton;
import com.exigen.ipb.eisa.controls.webstudio.WSEditableElement;
import com.exigen.ipb.eisa.utils.RetryService;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.common.enums.NavigationEnum;
import org.openqa.selenium.By;

public class EditorPage extends WebStudioAbstractPage  {
    private static final String PLAN_TMPL = "//a[.='%s']";
    private static final String TYPE_TMPL = "//span[.='%s']/parent::div[1]/span[1]";
    private static final String TYPE_SECTION_TMPL = "//a[span[.='%s']]";
    private static Table tableSectionData = new Table(By.xpath("//table[@class='te_table']"));
    private static WSButton buttonSave = new WSButton(By.id("t_te_save_all"), wsWaiter);
    private static Button linkProjectSave = new Button(By.id("saveProjectButton"), wsWaiter);
    private static Button submit = new Button(By.xpath("//form[@id='saveForm']//input[@value='Save']"), wsWaiter);

    public EditorPage openPlan(String planName) {
        new Button(By.xpath(String.format(PLAN_TMPL, planName)), wsWaiter).click();
        return this;
    }

    public EditorPage openModules(String planName) {
        Button linkPlanConf = new Button(By.xpath(String.format(PLAN_TMPL, planName)));
        RetryService.run(pred -> linkPlanConf.isPresent());
        linkPlanConf.click(wsWaiter);
        return this;
    }

    public EditorPage openType(NavigationEnum.WebStudioEditorPageLeftMenuNavigation type, String typeSection) {
        Link linkType = new Link(By.xpath(String.format(TYPE_TMPL, type.get())));
        linkType.waitForAccessible(5000);
        linkType.click(wsWaiter);
        new Button(By.xpath(String.format(TYPE_SECTION_TMPL, typeSection)), wsWaiter).click();
        return this;
    }

    public EditorPage fill(int row, int cell, String value) {
        new WSEditableElement().fill(tableSectionData.getRow(row).getCell(cell).getAttribute("id"),
                value);
        return this;
    }

    public EditorPage save() {
        buttonSave.click();
        return this;
    }

    public EditorPage saveProject() {
        linkProjectSave.click();
        submit.click();
        return this;
    }
}
