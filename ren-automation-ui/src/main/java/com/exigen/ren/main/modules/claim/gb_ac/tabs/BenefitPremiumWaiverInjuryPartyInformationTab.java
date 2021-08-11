package com.exigen.ren.main.modules.claim.gb_ac.tabs;

import com.exigen.ren.common.DefaultTab;
import com.exigen.ren.common.Tab;
import com.exigen.ren.common.pages.NavigationPage;
import com.exigen.ren.main.modules.claim.gb_ac.metadata.BenefitPremiumWaiverInjuryPartyInformationTabMetaData;

import static com.exigen.ren.common.enums.NavigationEnum.ClaimBenefitLeftMenu.INJURY_PARTY_INFORMATION;
import static com.exigen.ren.common.enums.NavigationEnum.ClaimBenefitLeftMenu.PREMIUM_WAIVER;

public class BenefitPremiumWaiverInjuryPartyInformationTab extends DefaultTab {
    public BenefitPremiumWaiverInjuryPartyInformationTab() {
        super(BenefitPremiumWaiverInjuryPartyInformationTabMetaData.class);
    }

    @Override
    public Tab navigate() {
        NavigationPage.PolicyNavigation.expand(PREMIUM_WAIVER.get(), this.getTabName());
        return this;
    }

    @Override
    public String getTabName() {
        return INJURY_PARTY_INFORMATION.get();
    }
}


