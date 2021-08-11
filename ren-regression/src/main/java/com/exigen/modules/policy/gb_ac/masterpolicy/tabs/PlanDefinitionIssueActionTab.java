package com.exigen.modules.policy.gb_ac.masterpolicy.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.modules.policy.common.metadata.master.PlanDefinitionIssueActionTabMetaData;
import com.exigen.ren.common.ActionTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.PolicyConstants;
import com.exigen.ren.main.enums.TableConstants;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class PlanDefinitionIssueActionTab extends ActionTab {

    public static final TableExtended<TableConstants.Empty> planTable = new TableExtended<>("Plan", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListPreconfigGroupCoverageDefinition']/div/table"));
    public PlanDefinitionIssueActionTab() {
        super(PlanDefinitionIssueActionTabMetaData.class);

        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {

            @Override
            protected void addSection(int index, int size) {
            }

            @Override
            protected void selectSection(int index) {}

            @Override
            public void fill(TestData td) {
                if (td.containsKey(name)) {
                    fillSection(td);
                }
            }

            private void fillSection(TestData td) {
                for (TestData plan : td.getTestDataList(name)) {
                    if (plan.containsKey("PlanKey")) {
                        planTable.getRow(PolicyConstants.PolicyPlanTable.PLAN, plan.getValue("PlanKey")).getCell(6).controls.links.get(ActionConstants.CHANGE).click();
                    }
                    List<TestData> list = new ArrayList<>();
                    list.add(plan);
                    setValue(list);
                }
            }

        };
        assetList.setName(this.getClass().getSimpleName());
    }

    @Override
    public Tab submitTab() {
        buttonNext.click(doubleWaiter);
        return this;
    }
}
