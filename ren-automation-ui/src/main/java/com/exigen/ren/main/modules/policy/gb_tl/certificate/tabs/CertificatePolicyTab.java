/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.modules.policy.gb_tl.certificate.tabs;

import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.policy.gb_tl.certificate.metadata.CertificatePolicyTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.CERTIFICATE_POLICY;

public class CertificatePolicyTab extends DefaultTab {
    public CertificatePolicyTab() {
        super(CertificatePolicyTabMetaData.class);
        assetList = new AssetList(By.xpath("//div[@id='policyDataGatherForm:componentView_GroupCertificatePolicy']"), metaDataClass);
        assetList.setName(this.getClass().getSimpleName());
    }

    @Override
    public String getTabName() {
        return CERTIFICATE_POLICY.get();
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(this.getTabName());
        return this;
    }
}
