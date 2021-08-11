/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cms.printmonitor.pages;

import com.exigen.istf.webdriver.controls.composite.table.Table;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import com.exigen.ren.main.enums.AdminConstants;
import org.openqa.selenium.By;

public class PrintMonitorPage extends AdminPage {
    public static Table tableRefreshResult = new Table(By.xpath("//table[@class='rf-dt table_style']"));

    public static String getRequestId(int rowNumber) {
        return tableRefreshResult.getRow(rowNumber).getCell(AdminConstants.AdminPrintMonitorSearchTable.REQUEST_ID).getValue();
    }

    public static String getRequestIdPrintDocs(int rowNumber) {
        return tableRefreshResult.getRow(rowNumber).getCell(AdminConstants.AdminPrintMonitorSearchTable.REQUEST_ID_PRINT_DOCS).getValue();
    }

}
