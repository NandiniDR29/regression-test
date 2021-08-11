package com.exigen.ren.main.modules.caseprofile.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.Link;
import com.exigen.istf.webdriver.controls.Named;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.ActionConstants;
import com.exigen.ren.main.enums.PolicyConstants;
import com.exigen.ren.main.modules.caseprofile.metadata.LocationManagementTabMetaData;
import jersey.repackaged.com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.exigen.ren.main.modules.caseprofile.tabs.LocationManagementTab.BillingLocationsTable.LOCATION_NAME;

public class LocationManagementTab extends DefaultTab {

    public static TableExtended<BillingLocationsTable> tableBillingLocations = new TableExtended<>("Billing Locations", By.xpath("//table[@id='caseForm:body_caseProfileLocations']"));

    public static Link linkNext = new Link(By.xpath("//a[.='Next']"));
    public static Button buttonAddLocation = new Button(By.xpath("//input[@id='caseForm:addBillingLocation']"));
    public static Button buttonSave = new Button(By.xpath("//input[@id='caseForm:saveBtn_footer']"));

    public LocationManagementTab() {
        super(LocationManagementTabMetaData.class);
        assetList = new MultiAssetList(By.xpath(Page.DEFAULT_ASSETLIST_CONTAINER), metaDataClass) {
            @Override
            protected void selectSection(int index) {
                tableBillingLocations.getRow(index).getCell(ClassificationManagementTab.ClassificationGroupsTable.ACTIONS.getName()).controls.links.get(ActionConstants.CHANGE).click();
            }

            @Override
            protected void addSection(int arg0, int arg1) {
                buttonAddLocation.click();
            }

            @Override
            public void fill(TestData td) {
                if (td.containsKey(name)) {
                    fillSection(td);
                }
            }

            private void fillSection(TestData td) {
                for (TestData tdTab : td.getTestDataList(name)) {
                    if (!tdTab.getKeys().isEmpty()) {
                        List<TestData> list = new ArrayList<>();
                        list.add(tdTab);
                        setValue(list);
                    }
                }
            }
        };
        assetList.setName(this.getClass().getSimpleName());
    }

    @Override
    public Tab submitTab() {
        linkNext.click();
        return this;
    }

    @Override
    public Tab navigate() {
        NavigationPage.toSubTab("Location Management");
        return this;
    }



    public enum BillingLocationsTable implements Named {
        LOCATION_NAME("Location Name"),
        LOCATION_NUMBER("Location Number"),
        TAX_IDENTIFICATION("Tax Identification"),
        LOCATION_COUNTRY("Location Country"),
        LOCATION_CITY("Location City"),
        LOCATION_STATE_PROVINCE("Location State/Province"),
        ACTIONS("Actions");

        private String name;

        BillingLocationsTable(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }
    }

}
