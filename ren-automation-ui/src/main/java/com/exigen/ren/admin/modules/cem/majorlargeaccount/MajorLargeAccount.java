/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.cem.majorlargeaccount;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.cem.common.pages.CemPage;
import com.exigen.ren.admin.modules.cem.majorlargeaccount.action.MajorAccountCreateAction;
import com.exigen.ren.admin.modules.cem.majorlargeaccount.action.MajorAccountUpdateAction;
import com.exigen.ren.admin.modules.cem.majorlargeaccount.metadata.MajorLargeAccountMetaData;
import com.exigen.ren.admin.modules.cem.majorlargeaccount.pages.MajorLargeAccountPage;
import com.exigen.ren.admin.modules.cem.majorlargeaccount.tabs.MajorLargeAccountTab;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.enums.NavigationEnum.AdminAppMainTabs;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.CEMConstants;

public class MajorLargeAccount implements IMajorLargeAccount {

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/cem/cem/majorlargeaccount");

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(MajorAccountCreateAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        initiate();
        getDefaultWorkspace().fill(td);
        MajorLargeAccountTab.buttonSave.click();
    }

    @Override
    public void initiate() {
        navigate();
        MajorLargeAccountPage.buttonCreateNewMajorLargeAccount.click();
    }

    public void search(TestData td) {
        CemPage.search(td);
    }

    public void navigate() {
        NavigationPage.toMainTab(AdminAppMainTabs.CEM);
        NavigationPage.toLeftMenuTab(NavigationEnum.CEMLeftMenu.MAJOR_LARGE_ACCOUNT);
    }

    public String createWithId(TestData td) {
        initiate();
        getDefaultWorkspace().fill(td);
        String accountId = new MajorLargeAccountTab().getAssetList().getAsset(MajorLargeAccountMetaData.MAJOR_LARGE_ACCOUNT_ID).getValue();
        MajorLargeAccountTab.buttonSave.click();
        return accountId;
    }

    public void delete(int rowNumber) {
        MajorLargeAccountPage.tableMajorLargeAccount.getRow(rowNumber).getCell(CEMConstants.CEMMajorLargeAccountTable.ACTION).controls.buttons.get("Delete").click();
        Page.dialogConfirmation.confirm();
    }

    public MajorAccountUpdateAction editMajorLargeAccount() {
        return AutomationContext.getAction(MajorAccountUpdateAction.class);
    }


    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
