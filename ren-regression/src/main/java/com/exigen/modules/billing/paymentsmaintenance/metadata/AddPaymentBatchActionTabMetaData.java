/*
 * Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 * CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.modules.billing.paymentsmaintenance.metadata;

import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.main.metadata.PaymentsMaintenanceMetaData;
import com.exigen.ren.main.modules.billing.paymentsmaintenance.tabs.AddPaymentBatchActionTab;
import org.openqa.selenium.By;

public class AddPaymentBatchActionTabMetaData extends MetaData {
    public static final AssetDescriptor<ComboBox> PAYMENT_DESIGNATION = declare("Payment Designation", ComboBox.class);
    public static final AssetDescriptor<RadioGroup> PAYMENT_TYPE = declare("Payment type", RadioGroup.class, By.id("paymentBatchForm:generalPaymentBatch_paymentType"));
    public static final AssetDescriptor<TextBox> NUMBER_OF_PAYMENTS = declare("# of Payments", TextBox.class);
    public static final AssetDescriptor<TextBox> TOTAL_AMOUNT = declare("Total Amount", TextBox.class);
    public static final AssetDescriptor<TextBox> BATCH_REFERENCE = declare("Batch Reference #", TextBox.class);
    public static final AssetDescriptor<TextBox> DATE = declare("Date", TextBox.class);
    public static final AssetDescriptor<AddPaymentBatchActionTab.PaymentList> PAYMENT_LIST = declare("Payment List", AddPaymentBatchActionTab.PaymentList.class, PaymentListData.class,
            false);
    public static final AssetDescriptor<FileUpload> UPLOAD_A_LIST_OF_PAYMENTS = declare("Upload a List of Payments", FileUpload.class, By.id("paymentBatchForm:generalPaymentBatch_browseButton_input"));


    public static final class PaymentListData extends MetaData {
        public static final AssetDescriptor<TextBox> AMOUNT = declare("Amount", TextBox.class, Waiters.DEFAULT, true,
                By.xpath(".//input[contains(@id, 'paymentBatchForm:batchPaymentsList')]"));
        public static final AssetDescriptor<TextBox> CHECK_NUMBER = declare("Check Number", TextBox.class, Waiters.DEFAULT, true, By.xpath(".//input[contains(@id, 'chequeNumber')]"));
        public static final AssetDescriptor<TextBox> BILLING_ACCOUNT = declare("Billing Account #", TextBox.class, Waiters.DEFAULT, true,
                By.xpath(".//input[contains(@id, 'billingAccountNo')]"));
        public static final AssetDescriptor<TextBox> POLICY = declare("Policy #", TextBox.class, Waiters.DEFAULT, true,
                By.xpath(".//input[contains(@id, 'policyNo')]"));
        public static final AssetDescriptor<TextBox> PAYOR = declare("Payor", TextBox.class, Waiters.DEFAULT, true,
                By.xpath(".//input[contains(@id, 'payor')]"));
        public static final AssetDescriptor<TextBox> CASHABLE_DATE = declare("Cashable Date", TextBox.class, Waiters.DEFAULT, true,
                By.xpath(".//input[contains(@id, 'paymentItem_creationDateInputDate')]"));

        public static final AssetDescriptor<Button> OPEN_GROUP_INSURANCE_CUSTOMER = declare("Open Select Group Insurance Customer Dialog", Button.class,
                Waiters.DEFAULT, By.xpath(".//*[contains(text(), 'Select Group Insurance Customer')]"));
        public static final AssetDescriptor<DialogSingleSelector> SELECT_GROUP_INSURANCE_CUSTOMER = declare("Select Group Insurance Customer Search", DialogSingleSelector.class, PaymentsMaintenanceMetaData.SelectGroupInsuranceCustomer.class, false,
                By.xpath(".//*[@id='paymentBatchForm:searchPayorPopup']"));
        public static final AssetDescriptor<Button> OPEN_ALLOCATE = declare("Open Allocate", Button.class, Waiters.DEFAULT, true, By.xpath(".//a[contains(@id, 'allocateLink')]"));

        public static final AssetDescriptor<DialogAssetList> ALLOCATION_SEARCH = declare("Allocation Search", DialogAssetList.class, AllocationSearchMetaData.class);
        public static final AssetDescriptor<Link> ALLOCATE = declare("Allocate", Link.class, Waiters.DEFAULT, true, By.xpath(".//a[contains(@id, 'directAllocationLink')]"));
    }

    public static final class AllocationSearchMetaData extends MetaData {
        public static final AssetDescriptor<RadioGroup> SELECT_ACTION = declare("Select Action", RadioGroup.class, Waiters.DEFAULT, false);
        public static final AssetDescriptor<ComboBox> BILLING_ACCOUNT = declare("Billing Account #", ComboBox.class, Waiters.DEFAULT, false);
        public static final AssetDescriptor<TextBox> POLICY = declare("Policy #", TextBox.class, Waiters.DEFAULT, false);
        public static final AssetDescriptor<Button> BUTTON_SUBMIT_POPUP = declare(AbstractDialog.getDefaultPopupSubmitterName(), Button.class, Waiters.DEFAULT, false, By.xpath(".//*[@id='batchPaymentItemForm:ok_footer']"));
    }
}