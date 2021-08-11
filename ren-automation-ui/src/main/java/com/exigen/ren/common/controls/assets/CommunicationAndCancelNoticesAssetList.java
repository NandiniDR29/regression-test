package com.exigen.ren.common.controls.assets;

import com.exigen.istf.config.ClassConfigurator;
import com.exigen.istf.webdriver.ByT;
import com.exigen.istf.webdriver.ByTTuple;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.composite.assets.RepeatAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.admin.modules.billing.billingcycle.cancellations.benefits.tabs.CancellationsBenefitsTab;
import org.openqa.selenium.By;

public class CommunicationAndCancelNoticesAssetList extends RepeatAssetList {

    @ClassConfigurator.Configurable
    private static String defaultLocatorTemplate = "//*[contains(@id, 'cancelForm:NoticesRepeat:%s')]//ancestor::table[@class='pfForm']";

    public CommunicationAndCancelNoticesAssetList(BaseElement<?, ?> parent, By locatorTemplate, Class<? extends MetaData> metaDataClass) {
        super(parent, new ByTTuple(parent.getLocator(), ByT.xpath(defaultLocatorTemplate)), metaDataClass);
    }

    public CommunicationAndCancelNoticesAssetList(ByT locatorTemplate, Class<? extends MetaData> metaDataClass) {
        super(ByT.xpath(defaultLocatorTemplate), metaDataClass);
    }

    public CommunicationAndCancelNoticesAssetList(By locatorTemplate, Class<? extends MetaData> metaDataClass) {
        super(ByT.xpath(defaultLocatorTemplate), metaDataClass);
    }

    @Override
    protected void addSection(int index, int size) {
        CancellationsBenefitsTab.buttonAddCommunicationAndCancelNotices.click();
    }
}