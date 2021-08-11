/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.common;

import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.StaticElement;
import com.exigen.istf.webdriver.controls.composite.assets.AbstractContainer;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiter;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.pages.Page;
import org.openqa.selenium.By;

/**
 * Abstract tab class.
 *
 * @category Static
 */
public abstract class Tab implements Navigational{

    public static Waiter doubleWaiter = Waiters.AJAX.then(Waiters.SLEEP(4000)).then(Waiters.AJAX);
    public static final Button buttonOk = new Button(By.xpath("//input[(@value = 'OK' or @value = 'Ok') and contains(@id, '_footer') "
            + "and not(@class = 'hidden') and not(contains(@class, 'secondaryButton')) and not(contains(@style, 'none')) "
            + "and not(contains(@id, 'Dialog')) and not(contains(@id, 'serviceCallButtonOk')) and not(ancestor::*[@class='popupButtonsPanel'])]"));
    public static final Button buttonCancel = new Button(By.xpath("//*[((@value = 'Cancel') or (text() = 'Cancel')) and (contains(@id, '_footer') or @id='errorsForm:back') "
            + "and not(@class = 'hidden') and not(contains(@style, 'none')) "
            + "and not(contains(@id, 'Dialog')) and not(contains(@id, 'serviceCallButtonCancel')) and not(ancestor::*[@class='popupButtonsPanel'])]|//button[contains(., 'Cancel') "
            + "and not(@class = 'hidden') and not(contains(@style, 'none'))]"));
    public static final Button navButtonCancel = new Button(By.xpath("//*[@class = 'navButtonContainer']//*[@value = 'Cancel' and not(@class = 'hidden') and not(contains(@style, 'none'))]"));
    public static final Button buttonFinish = new Button(By.xpath("//input[@value = 'Finish' and not(@class = 'hidden') and not(contains(@style,'none')) and contains(@id,'_footer')]"));
    public static final Button buttonNext = new Button(By.xpath("//input[@value = 'Next' and not(@class = 'hidden') and not(contains(@style,'none'))]"));
    public static final Button buttonSave = new Button(By.xpath("//input[@value = 'Save' and not(@class = 'hidden') and not(contains(@style,'none'))]"));
    public static final Button buttonBack = new Button(By.xpath("//input[(@value = 'Back' or @value = 'BACK') and not(@class = 'hidden') and not(contains(@style,'none'))]"));
    public static final Button buttonTopSave = new Button(By.id("topSaveLink"));
    public static final Button buttonTopCancel = new Button(By.id("topCancelLink"));
    public static final Button buttonTopRefresh = new Button(By.id("topRefreshLink"));
    public static final Button buttonContinue = new Button(By.xpath("//input[@value = 'Next' and not(@class = 'hidden') and not(contains(@style,'none'))]"));
    public static final Button buttonDone = new Button(By.xpath("//input[@value = 'Done' and not(@class = 'hidden') and not(contains(@style,'none'))]"));
    public static final Button buttonSaveAndFinalize = new Button(By.xpath("//input[@value='Save and Finalize' and not(contains(@style,'none'))]"));
    public static final Button buttonSaveAndExit = new Button(By.id("topSaveAndExitLink"));
    public static final Button buttonCreateVersion = new Button(By.id("topCreateQuoteVersionLink"));
    public static final Button buttonPopupOk = new Button(By.id("policyDataGatherForm:pendingFeaturePopup_ok"));
    public static final Button buttonYes = new Button(By.xpath("//input[(@value = 'Yes' or @value = 'YES') and not(@class = 'hidden') and not(contains(@style,'none'))]"));
    public static final Button buttonGo = new Button(By.xpath("//input[(@value = 'Go' or @value = 'GO') and not(@class = 'hidden') and not(contains(@style,'none'))]"));
    public static final Button buttonUpdate = new Button(By.xpath("(//input[(@value = 'Update' and not(@class = 'hidden'))])[last()]"));
    public static final Button buttonSearch = new Button(By.xpath("//input[(@value = 'Search' and not(@class = 'hidden'))]"));
    public static final Button buttonOverrideRules = new Button(By.xpath("//input[(@value = 'Override Rules' or @value = 'Override')  and not(contains(@style,'none'))]"));
    public static final Button buttonRate = new Button(By.xpath("//input[@value = 'Rate' and not(@class = 'hidden') and not(contains(@style,'none'))]"), doubleWaiter);
    public static final Button buttonSetUpUpdate = new Button(By.id("setUpConsolidatedStatement:setUpButton_footer"));

    public static final Link linkAdminApp = new Link(By.id("logoutForm:switchToAdmin"));
    public static final Link linkMainApp = new Link(By.id("logoutForm:switchToApp"));

    public static final StaticElement labelLoggedUser = new StaticElement(By.id("logoutForm:userDetails"));

    protected AbstractContainer<?, ?> assetList;
    protected Class<? extends MetaData> metaDataClass;

    protected Tab(Class<? extends MetaData> mdClass) {
        metaDataClass = mdClass;
        assetList = new AssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass);
        if (mdClass.getSimpleName().contains("MetaData")) {
            assetList.setName(this.getClass().getSimpleName());
        }
    }

    public Tab() {

    }

    public Tab navigateToTab() {
        if(!isTabSelected()) {
            navigate();
        }
        return this;
    }
    /**
     * Get name of metadata associated with this tab
     *
     * @return metadata name
     */
    public String getMetaKey() {
        return assetList.getName();
    }

    /**
     * Fill this tab.
     * Override if tab is filled in non-standard manner (e.g. there are several asset lists, extra buttons have to be clicked etc.)
     *
     * @param td TestData object which may contain another TestData by key returned by {@link #getMetaKey()} and possibly other keys.
     *           Note: normally the same TestData is passed here as in {@link Workspace#fill(TestData)}.
     */
    public Tab fillTab(TestData td) {
        assetList.fill(td);
        return this;
    }

    /**
     * Finish filling the tab. By default is a NOOP.
     * For multi-tab workspaces it should click "Next" button, but sometimes a different button is used or none at all.
     * Override if some button has to be clicked to finalize filling the tab.
     */
    public Tab submitTab() {
        return this;
    }

    /**
     * Get default asset list of this tab
     *
     * @return asset list
     */
    public AbstractContainer<?, ?> getAssetList() {
        return assetList;
    }

    public boolean isEmpty(TestData td) {
        return td.getTestData(getMetaKey()).getKeys().isEmpty();
    }

    public static void cancelClickAndCloseDialog() {
        Tab.buttonCancel.click();
        Page.dialogConfirmation.confirm();
    }
}
