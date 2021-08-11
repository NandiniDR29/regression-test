package com.exigen.ren.admin.modules.commission.commissioncorrection.pages;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.AssetList;
import com.exigen.ren.admin.modules.commission.commissioncorrection.gbcommissioncorrection.metadata.ComCorrectionMetaData;
import com.exigen.ren.admin.modules.common.pages.AdminPage;
import com.exigen.ren.main.enums.TableConstants;
import org.openqa.selenium.By;

public class CommissionCorrectionPage extends AdminPage {
    public static AssetList assetListSearchForm = new AssetList(By.xpath("//form[contains(@id, 'SearchForm')]"), ComCorrectionMetaData.class);

    public static TableExtended<CommissionCorrection> tableCommissionCorrection = new TableExtended<>("CommissionStrategies", By.id("correctionSearchForm:body_correctionSearchTable"));
    public static Button buttonClear = new Button(By.id("correctionSearchForm:resetBtn_footer"));

    public static TableExtended<TableConstants.Empty> tableAgencySearch = new TableExtended<>("SalesChannelSearchForAgency", By.id("selectPopupForm:body_resultAgenciesTable"));
    public static TableExtended<TableConstants.Empty> tableIndividualSearch = new TableExtended<>("SalesChannelSearchForAgency", By.id("selectPopupForm:body_resultIndividualsTable"));

    public static void search(TestData td) {
        assetListSearchForm.fill(td);
        buttonSearch.click();
    }

    public enum CommissionCorrection implements Named {
        PRODUCT("Product"),
        POLICY("Policy"),
        POLICY_EFFECTIVE_DATE("Policy Effective Date"),
        ACTIONS("Actions");
        private String name;

        CommissionCorrection(String name){
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
