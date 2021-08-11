package com.exigen.ren.rest.dxp.model.policy.policy_details_ac;

import com.exigen.ren.rest.model.RestError;

public class GroupCoverageDefinitionTiersViewOnlyComponent extends RestError {

    private String coverageTiers;

    public String getCoverageTiers() {
            return coverageTiers;
        }

    public void setCoverageTiers(String coverageTiers) {
            this.coverageTiers = coverageTiers;
        }
}
