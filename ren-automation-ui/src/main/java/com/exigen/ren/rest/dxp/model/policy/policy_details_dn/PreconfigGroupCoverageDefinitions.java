package com.exigen.ren.rest.dxp.model.policy.policy_details_dn;

import com.exigen.ren.rest.model.RestError;

public class PreconfigGroupCoverageDefinitions extends RestError {

    private GroupCoverageDefinitionTiersViewOnlyComponent groupCoverageDefinitionTiersViewOnlyComponent;
    private RenGroupCoverageDefinitionPlanNameViewOnlyComponent renGroupCoverageDefinitionPlanNameViewOnlyComponent;

    public GroupCoverageDefinitionTiersViewOnlyComponent getGroupCoverageDefinitionTiersViewOnlyComponent() {
        return groupCoverageDefinitionTiersViewOnlyComponent;
    }

    public void setGroupCoverageDefinitionTiersViewOnlyComponent(GroupCoverageDefinitionTiersViewOnlyComponent groupCoverageDefinitionTiersViewOnlyComponent) {
        this.groupCoverageDefinitionTiersViewOnlyComponent = groupCoverageDefinitionTiersViewOnlyComponent;
    }

    public RenGroupCoverageDefinitionPlanNameViewOnlyComponent getRenGroupCoverageDefinitionPlanNameViewOnlyComponent() {
        return renGroupCoverageDefinitionPlanNameViewOnlyComponent;
    }

    public void setRenGroupCoverageDefinitionPlanNameViewOnlyComponent(RenGroupCoverageDefinitionPlanNameViewOnlyComponent renGroupCoverageDefinitionPlanNameViewOnlyComponent) {
        this.renGroupCoverageDefinitionPlanNameViewOnlyComponent = renGroupCoverageDefinitionPlanNameViewOnlyComponent;
    }
}
