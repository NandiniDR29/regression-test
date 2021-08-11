package com.exigen.modules.billing.account.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.billing.account.metadata.PaymentMethodsActionTabMetaData;
import org.openqa.selenium.By;

public class PaymentMethodsActionTab extends ActionTab {

    public static final TableExtended<TableConstants.ManagePaymentMethodsTable> tableManagePaymentMethods =new TableExtended<>("Manage Payment Methods", By.id("paymentMethodsForm:recurring_payment_methods_table"));

    public PaymentMethodsActionTab() {
        super(PaymentMethodsActionTabMetaData.class);
    }
}