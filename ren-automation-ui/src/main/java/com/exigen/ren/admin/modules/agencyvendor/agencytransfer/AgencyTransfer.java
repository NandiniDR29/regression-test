/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.admin.modules.agencyvendor.agencytransfer;

import com.exigen.istf.data.TestData;
import com.exigen.ren.TestDataProvider;
import com.exigen.ren.admin.modules.agencyvendor.IAgencyVendor;
import com.exigen.ren.admin.modules.agencyvendor.agencytransfer.actions.AgencyTransferCreateAction;
import com.exigen.ren.admin.modules.agencyvendor.agencytransfer.tabs.AgencyTransferTab;
import com.exigen.ren.common.Action;
import com.exigen.ren.common.AutomationContext;
import com.exigen.ren.common.Workspace;
import com.exigen.ren.common.enums.NavigationEnum;
import com.exigen.ren.common.pages.NavigationPage;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;

import java.util.concurrent.TimeUnit;

import static com.exigen.ipb.eisa.utils.RetryService.run;
import static com.exigen.ren.admin.modules.agencyvendor.agencytransfer.metadata.AgencyTransferMetaData.TRANSFER_ID;


public class AgencyTransfer implements IAgencyVendor {

    private TestData defaultTestData = TestDataProvider.getDefaultTestDataProvider().get("modules/platform/admin/agencyvendor/agencytransfer");

    private String transferId;

    @Override
    public Workspace getDefaultWorkspace() {
        return AutomationContext.getAction(AgencyTransferCreateAction.class).getWorkspace();
    }

    @Override
    public void create(TestData td) {
        navigate();
        getDefaultWorkspace().fill(td);
        String transferId = AgencyTransferTab.labelTransferId.getValue();
        AgencyTransferTab.buttonSubmit.click();
        waitForSubmittedStatus(defaultTestData.getTestData("DataGather", "Search")
                .adjust(TestData.makeKeyPath(AgencyTransferTab.class.getSimpleName(), TRANSFER_ID.getLabel()), transferId));
    }

    public String getTransferId() {
        return this.transferId;
    }

    @Override
    public void initiate() {
        throw new UnsupportedOperationException("initiate() method is not supported for this action.");
    }

    @Override
    public Action update() {
        throw new UnsupportedOperationException("update method() is not supported for this action.");
    }

    @Override
    public void navigate() {
        NavigationPage.toMainTab(NavigationEnum.AdminAppMainTabs.AGENCY_VENDOR);
        NavigationPage.toLeftMenuTab(NavigationEnum.AgencyVendorLeftMenu.AGENCY_TRANSFER);
    }

    @Override
    public void search(TestData td) {
        getDefaultWorkspace().fill(td);
        AgencyTransferTab.buttonSearch.click();
    }

    public void waitForSubmittedStatus(TestData td) {
        run(predicate -> !AgencyTransferTab.transfersTable.isPresent(),
                () -> {
                    search(td);
                    return null;
                }, StopStrategies.stopAfterAttempt(35), WaitStrategies.fixedWait(20, TimeUnit.SECONDS));
    }

    @Override
    public TestData defaultTestData() {
        return defaultTestData;
    }
}
