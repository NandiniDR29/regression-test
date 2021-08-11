/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.main.metadata;

import com.exigen.ipb.eisa.controls.AllocationAmount;
import com.exigen.ipb.eisa.controls.dialog.DialogAssetList;
import com.exigen.ipb.eisa.controls.dialog.DialogMultiSelector;
import com.exigen.ipb.eisa.controls.dialog.DialogSingleSelector;
import com.exigen.ipb.eisa.controls.dialog.type.AbstractDialog;
import com.exigen.istf.webdriver.controls.*;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.AssetDescriptor;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.istf.webdriver.controls.waiters.Waiters;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.modules.billing.paymentsmaintenance.tabs.AddPaymentBatchActionTab.PaymentList;
import org.openqa.selenium.By;

public class PaymentsMaintenanceMetaData {

    public static final class AddBulkPaymentActionTab extends MetaData {
        public static final AssetDescriptor<TextBox> BULK_AMOUNT = declare("Bulk Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> BULK_REFERENCE = declare("Bulk Reference #", TextBox.class);
        public static final AssetDescriptor<DialogMultiSelector> ALLOCATION = declare("Allocation", DialogMultiSelector.class,
                AllocationMultiSelector.class);
        public static final AssetDescriptor<AllocationAmount> ALLOCATED_AMOUNT = declare("Allocated Amount", AllocationAmount.class);

        public static final class AllocationMultiSelector extends MetaData {
            public static final AssetDescriptor<TextBox> BILLING_ACCOUNT_NUMBER = declare("Billing Account #", TextBox.class);
            public static final AssetDescriptor<TextBox> POLICY_NUMBER = declare("Policy #", TextBox.class, Waiters.AJAX(30000));
            public static final AssetDescriptor<ComboBox> BILLING_ACCOUNT_NAME_TYPE = declare("Billing Account Name Type", ComboBox.class);
            public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
            public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
            public static final AssetDescriptor<TextBox> MORTGAGEE = declare("Mortgagee", TextBox.class);
            public static final AssetDescriptor<TextBox> AGENCY = declare("Agency", TextBox.class);
            public static final AssetDescriptor<TextBox> AGENCY_CODE = declare("Agency Code", TextBox.class);

            public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class,
                    Waiters.DEFAULT, false, By.id("bulkPaymentForm:searchForAllocationLink"));
        }
    }

    public static final class AddSuspenseActionTab extends MetaData {
        public static final AssetDescriptor<TextBox> SUSPENSE_AMOUNT = declare("Suspense Amount", TextBox.class);
        public static final AssetDescriptor<TextBox> SUSPENSE_REFERENCE = declare("Suspense Reference #", TextBox.class);
        public static final AssetDescriptor<ComboBox> PAYMENT_DESIGNATION = declare("Payment Designation", ComboBox.class);
        public static final AssetDescriptor<TextBox> RECEIVED_FROM = declare("Received From", TextBox.class);
        public static final AssetDescriptor<ComboBox> PAYMENT_CHANNEL = declare("Payment Channel", ComboBox.class);
    }

    public static final class SelectGroupInsuranceCustomer extends MetaData {

        public static final AssetDescriptor<TextBox> BILLING_ACCOUNT = declare("Billing Account #", TextBox.class);
        public static final AssetDescriptor<TextBox> POLICY = declare("Policy/Quote #", TextBox.class);
        public static final AssetDescriptor<TextBox> GROUP_INSURANCE_CUSTOMER = declare("Group Insurance Customer", TextBox.class);
        public static final AssetDescriptor<TextBox> ACCOUNT = declare("Account #", TextBox.class);
        public static final AssetDescriptor<TextBox> CUSTOMER = declare("Customer #", TextBox.class);
    }



    public static final class SearchSuspenseActionTab extends MetaData {
        public static final AssetDescriptor<TextBox> SUSPENSE_REFERENCE = declare("Suspense Reference #", TextBox.class);
        public static final AssetDescriptor<ComboBox> PAYMENT_DESIGNATION = declare("Payment Designation", ComboBox.class);
        public static final AssetDescriptor<TextBox> BILLING_ACCOUNT = declare("Billing Account", TextBox.class);
    }

    public static final class ClearSuspenseActionTab extends MetaData {
        public static final AssetDescriptor<DialogMultiSelector> ALLOCATION = declare("Allocation", DialogMultiSelector.class,
                AllocationMultiSelector.class);

        public static final class AllocationMultiSelector extends MetaData {
            public static final AssetDescriptor<TextBox> BILLING_ACCOUNT_NUMBER = declare("Billing Account #", TextBox.class);
            public static final AssetDescriptor<TextBox> POLICY_NUMBER = declare("Policy #", TextBox.class);
            public static final AssetDescriptor<ComboBox> BILLING_ACCOUNT_NAME_TYPE = declare("Billing Account Name Type", ComboBox.class);
            public static final AssetDescriptor<TextBox> FIRST_NAME = declare("First Name", TextBox.class);
            public static final AssetDescriptor<TextBox> LAST_NAME = declare("Last Name", TextBox.class);
            public static final AssetDescriptor<TextBox> MORTGAGEE = declare("Mortgagee", TextBox.class);
            public static final AssetDescriptor<TextBox> AGENCY = declare("Agency", TextBox.class);
            public static final AssetDescriptor<TextBox> AGENCY_CODE = declare("Agency Code", TextBox.class);

            public static final AssetDescriptor<Button> BUTTON_OPEN_POPUP = declare(AbstractDialog.getDefaultPopupOpenerName(), Button.class,
                    Waiters.SLEEP(3000), false, By.id("suspenseForm:showPolicySearchPopupLnk"));
        }
    }
}
