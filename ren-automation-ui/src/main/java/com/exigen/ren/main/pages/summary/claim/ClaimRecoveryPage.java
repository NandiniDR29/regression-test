package com.exigen.ren.main.pages.summary.claim;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.ren.main.pages.summary.SummaryPage;
import org.openqa.selenium.By;

public class ClaimRecoveryPage extends SummaryPage {
    public static TableExtended<ClaimsRecoveryView> tableClaimsRecoveryView = new TableExtended<>("Claims Recovery View", By.id("policyDataGatherForm:body_transactionInstanceTable_ClaimsRecoveryView"));

    public enum ClaimsRecoveryView implements Named {
        PAYMENT_NUMBER("Payment Number"),
        AMOUNT("Amount"),
        RECOVERED_FROM("Recovered From"),
        POSTING_DATE("Posting Date"),
        PERFORMER("Performer"),
        PAYMENT_STATUS("Payment status");

        private String name;

        ClaimsRecoveryView(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
