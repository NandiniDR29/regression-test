package com.exigen.ren.rest.dxp.model.policy.policy_details_vs;

import com.exigen.ren.rest.model.RestError;

public class PreconfigGroupCoverageDefinitions extends RestError {

    private GroupCoverageDefinitionTiersViewOnlyComponent groupCoverageDefinitionTiersViewOnlyComponent;

    public GroupCoverageDefinitionTiersViewOnlyComponent getGroupCoverageDefinitionTiersViewOnlyComponent() {
        return groupCoverageDefinitionTiersViewOnlyComponent;
    }

    public void setGroupCoverageDefinitionTiersViewOnlyComponent(GroupCoverageDefinitionTiersViewOnlyComponent groupCoverageDefinitionTiersViewOnlyComponent) {
        this.groupCoverageDefinitionTiersViewOnlyComponent = groupCoverageDefinitionTiersViewOnlyComponent;
    }
}
