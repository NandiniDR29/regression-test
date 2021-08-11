package com.exigen.ren.rest.dxp.model.policy.policy_details_ac;

import com.exigen.ren.rest.model.RestError;

public class CoverageFundMultiViewOnlyComponent extends RestError {

    private String groupFundingStructureTaxability;

    public String getGroupFundingStructureTaxability() {
        return groupFundingStructureTaxability;
    }

    public void setGroupFundingStructureTaxability(String groupFundingStructureTaxability) {
        this.groupFundingStructureTaxability = groupFundingStructureTaxability;
    }
}
