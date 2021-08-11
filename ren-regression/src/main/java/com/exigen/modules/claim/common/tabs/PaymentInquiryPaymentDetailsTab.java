package com.exigen.modules.claim.common.tabs;

import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.controls.InquiryAssetList;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.claim.common.metadata.PaymentInquiryPaymentDetailsTabMetaData;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimPaymentsTab.PAYMENT_DETAILS;

public class PaymentInquiryPaymentDetailsTab extends DefaultTab {

    InquiryAssetList inquiryAssetList;

    public PaymentInquiryPaymentDetailsTab() {
        super(PaymentInquiryPaymentDetailsTabMetaData.class);
        inquiryAssetList = new InquiryAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass);
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.leftMenu(getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return PAYMENT_DETAILS.get();
    }

    /**
     * Get asset list of this tab in Inquiry Mode
     *
     * @return inquiry asset list
     */
    public InquiryAssetList getInquiryAssetList() {
        return inquiryAssetList;
    }
}
