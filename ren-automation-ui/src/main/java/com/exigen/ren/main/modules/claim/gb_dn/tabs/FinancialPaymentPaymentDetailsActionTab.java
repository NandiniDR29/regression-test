package com.exigen.ren.main.modules.claim.gb_dn.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.main.modules.claim.common.tabs.PolicyInformationParticipantParticipantInformationTab;
import com.exigen.ren.main.modules.claim.gb_dn.metadata.FinancialPaymentPaymentDetailsActionTabMetaData;
import org.openqa.selenium.By;

public class FinancialPaymentPaymentDetailsActionTab extends ActionTab {

    public static Button buttonAddPaymentReduction = new Button(By.id("policyDataGatherForm:addClaimsDentalPaymentCalculatorReduction"));
    public static Button buttonRemovePaymentReduction = new Button(By.id("policyDataGatherForm:eliminateClaimsDentalPaymentCalculatorReduction"));
    public static TableExtended<ListClaimsDentalPaymentCalculatorReduction> listOfReductionsAmount = new TableExtended<>("Dental Claims List of Reductions",
            By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListClaimsDentalPaymentCalculatorReduction']/div/table"));


    public FinancialPaymentPaymentDetailsActionTab() {
        super(FinancialPaymentPaymentDetailsActionTabMetaData.class);
    }

    public enum ListClaimsDentalPaymentCalculatorReduction implements Named {
        REDUCTION_AMOUNT("Reduction Amount"),
        CLAIM_ID("Claim #");

        private String name;

        ListClaimsDentalPaymentCalculatorReduction(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}


