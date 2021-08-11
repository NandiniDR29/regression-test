/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.product.moratorium;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.product.IProduct;
import com.exigen.ren.admin.modules.product.moratorium.actions.MoratoriumCreateAction;
import com.exigen.ren.admin.modules.product.moratorium.actions.MoratoriumUpdateAction;
import com.exigen.ren.admin.modules.product.moratorium.pages.MoratoriumPage;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;

public class Moratorium implements IProduct {
    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/moratorium");

    public void search(TestData td) {
        navigate();
        MoratoriumPage.search(td);
        MoratoriumPage.buttonSearch.click();
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.PRODUCT);
        NavigationPage.toLeftMenuTab(NavigationEnum.ProductLeftMenu.MORATORIUM);
    }

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(MoratoriumCreateAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        initiate();
        getDefaultWorkspace().fill(td);
        submit();
    }

    public void initiate() {
        navigate();
        MoratoriumPage.buttonAddMoratorium.click();
    }

    public void submit() {
        Tab.buttonSave.click();
    }

    public MoratoriumUpdateAction edit() {
        return AutomationContext.getAction(MoratoriumUpdateAction.class);
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
