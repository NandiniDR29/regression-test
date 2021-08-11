/*
 *  Copyright © 2019 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 *  CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.
 */
package com.exigen.ren.main.modules.policy.gb_dn.certificate.tabs;

import com.exigen.ipb.eisa.controls.composite.TableExtended;
import com.exigen.istf.data.TestData;
import com.exigen.istf.webdriver.controls.BaseElement;
import com.exigen.istf.webdriver.controls.Button;
import com.exigen.istf.webdriver.controls.composite.assets.MultiAssetList;
import com.exigen.istf.webdriver.controls.composite.assets.metadata.MetaData;
import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.common.pages.Page;
import com.exigen.ren.main.enums.TableConstants;
import com.exigen.ren.main.modules.policy.gb_dn.certificate.metadata.PlansTabMetaData;
import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;

import static com.exigen.ren.common.enums.NavigationEnum.GroupBenefitsTab.COVERAGES;
import static com.exigen.ren.main.enums.ActionConstants.CHANGE;
import static com.exigen.ren.main.enums.ActionConstants.REMOVE;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.GroupDentalCertificatePolicyContext.coveragesTab;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.metadata.PlansTabMetaData.ParticipantsMetaData.PARTICIPANT_SELECTION;
import static com.exigen.ren.main.modules.policy.gb_dn.certificate.metadata.PlansTabMetaData.ParticipantsMetaData.ROLE_INFORMATION;

public class PlansTab extends DefaultTab {

    public static final TableExtended<TableConstants.CertificateParticipants> tableParticipantsList = new TableExtended<>("Participants", By.xpath("//div[@id='policyDataGatherForm:dataGatherView_ListGroupCertificateParticipant']/div/table"));

    public static Button buttonAddParticipant = new Button(By.id("policyDataGatherForm:addGroupCertificateParticipant"));

    public PlansTab() {
        super(PlansTabMetaData.class);
    }

    public static class ParticipantsMultiAssetList extends MultiAssetList {

        public ParticipantsMultiAssetList(BaseElement<?, ?> parent, By locator, Class<? extends MetaData> metaDataClass) {
            super(parent, locator, metaDataClass);
        }

        public ParticipantsMultiAssetList(By locator, Class<? extends MetaData> metaDataClass) {
            super(locator, metaDataClass);
        }

        @Override
        protected void addSection(int index, int size) {}

        @Override
        protected void selectSection(int i) {
        }

        @Override
        public void fill(TestData td) {
            if (td.containsKey(name)) {
                fillSection(td);
            }
        }

        private void fillSection(TestData td) {
            for (TestData participant : td.getTestDataList(name)) {
                if (participant.containsKey(PARTICIPANT_SELECTION.getLabel())) {
                    buttonAddParticipant.click();
                }
                if (participant.containsKey("RemoveParticipant")) {
                    tableParticipantsList.getRow(TableConstants.CertificateParticipants.CUSTOMER_NAME.getName(), participant.getValue(TableConstants.CertificateParticipants.CUSTOMER_NAME.getName())).getCell(6).controls.links.get(REMOVE).click();
                    Page.dialogConfirmation.confirm();
                }
                else if (participant.containsKey("ChangeParticipant")) {
                    tableParticipantsList.getRow(TableConstants.CertificateParticipants.CUSTOMER_NAME.getName(), participant.getValue("ChangeParticipant")).getCell(6).controls.links.get(CHANGE).click();
                }
                setValue(ImmutableList.of(participant));
            }
        }
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.expand(COVERAGES.get(), this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return COVERAGES.get();
    }

    public static void addNewPersonParticipant(String roleNameValue) {
        PlansTab.buttonAddParticipant.click();
        coveragesTab.getAssetList().getAsset(PlansTabMetaData.PARTICIPANTS).getAsset(PARTICIPANT_SELECTION).setValue("New Person");
        coveragesTab.getAssetList().getAsset(PlansTabMetaData.PARTICIPANTS).getAsset(ROLE_INFORMATION).getAsset(PlansTabMetaData.RoleInformationMetaData.ROLE_NAME).setValue(roleNameValue);
    }

    public static void updateExistingParticipantByRoleName(String roleName) {
        LOGGER.info(String.format("Update participant : '%s'", roleName));
        PlansTab.tableParticipantsList.getRow(TableConstants.CertificateParticipants.ROLE_NAME.getName(), roleName).getCell(6).controls.links.get(CHANGE).click();
    }

    public static void removeExistingParticipantByRoleName(String roleName) {
        LOGGER.info(String.format("Remove participant : '%s'", roleName));
        PlansTab.tableParticipantsList.getRow(TableConstants.CertificateParticipants.ROLE_NAME.getName(), roleName).getCell(6).controls.links.get(REMOVE).click();
        Page.dialogConfirmation.confirm();
    }
}
