/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.scheme;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.product.IProduct;
import com.exigen.ren.admin.modules.product.scheme.actions.SchemeCloseAction;
import com.exigen.ren.admin.modules.product.scheme.actions.SchemeDataGatherAction;
import com.exigen.ren.admin.modules.product.scheme.actions.SchemeDisapproveAction;
import com.exigen.ren.admin.modules.product.scheme.actions.SchemeSetRunOffAction;
import com.exigen.ren.admin.modules.product.scheme.pages.SchemePage;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;

public class Scheme implements IProduct {

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/product/scheme");

    public void search(TestData td) {
        navigate();
        SchemePage.search(td);
        SchemePage.buttonSearch.click();
    }

    public void create(TestData testData) {
        initiate();
        getDefaultWorkspace().fill(testData);
        submit();
    }

    public void initiate() {
        navigate();
        SchemePage.buttonAddSchemeProduct.click();
    }

    public void submit() {
        SchemePage.buttonSaveAndExit.click();
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.PRODUCT);
        if (Page.dialogConfirmation.isPresent()) {
            Page.dialogConfirmation.confirm();
        }
        NavigationPage.toLeftMenuTab(NavigationEnum.ProductLeftMenu.SCHEME);
    }

    public void requestApproval() {
        NavigationPage.setActionAndGo("Request Approval");
        Page.dialogConfirmation.confirm();
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(SchemeDataGatherAction.class).getWorkspace();
    }

    public void approve() {
        NavigationPage.setActionAndGo("Approve");
        Page.dialogConfirmation.confirm();
    }

    public void removeSetToRunOff() {
        NavigationPage.setActionAndGo("Remove \"Set to Run-Off\"");
        Page.dialogConfirmation.confirm();
    }

    public SchemeDisapproveAction disapprove() {
        return AutomationContext.getAction(SchemeDisapproveAction.class);
    }

    public SchemeCloseAction close() {
        return AutomationContext.getAction(SchemeCloseAction.class);
    }

    public SchemeSetRunOffAction setRunOff() {
        return AutomationContext.getAction(SchemeSetRunOffAction.class);
    }


    public SchemeDataGatherAction dataGather() {
        return AutomationContext.getAction(SchemeDataGatherAction.class);
    }

    public void inquiry() {
        NavigationPage.setActionAndGo("Inquiry");
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
