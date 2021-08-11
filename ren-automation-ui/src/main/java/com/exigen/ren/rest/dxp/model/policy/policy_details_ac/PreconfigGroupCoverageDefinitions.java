package com.exigen.ren.rest.dxp.model.policy.policy_details_ac;

import com.exigen.ren.rest.model.RestError;

public class PreconfigGroupCoverageDefinitions extends RestError {

    private GroupCoverageDefinitionTiersViewOnlyComponent groupCoverageDefinitionTiersViewOnlyComponent;
    private CoverageFundMultiViewOnlyComponent coverageFundMultiViewOnlyComponent;
    private PreconfigGroupOptionalBenefitComponent preconfigGroupOptionalBenefitComponent;

    public GroupCoverageDefinitionTiersViewOnlyComponent getGroupCoverageDefinitionTiersViewOnlyComponent() {
        return groupCoverageDefinitionTiersViewOnlyComponent;
    }

    public void setGroupCoverageDefinitionTiersViewOnlyComponent(GroupCoverageDefinitionTiersViewOnlyComponent groupCoverageDefinitionTiersViewOnlyComponent) {
        this.groupCoverageDefinitionTiersViewOnlyComponent = groupCoverageDefinitionTiersViewOnlyComponent;
    }

    public CoverageFundMultiViewOnlyComponent getCoverageFundMultiViewOnlyComponent() {
        return coverageFundMultiViewOnlyComponent;
    }

    public void setCoverageFundMultiViewOnlyComponent(CoverageFundMultiViewOnlyComponent coverageFundMultiViewOnlyComponent) {
        this.coverageFundMultiViewOnlyComponent = coverageFundMultiViewOnlyComponent;
    }

    public PreconfigGroupOptionalBenefitComponent getPreconfigGroupOptionalBenefitComponent() {
        return preconfigGroupOptionalBenefitComponent;
    }

    public void setPreconfigGroupOptionalBenefitComponent(PreconfigGroupOptionalBenefitComponent preconfigGroupOptionalBenefitComponent) {
        this.preconfigGroupOptionalBenefitComponent = preconfigGroupOptionalBenefitComponent;
    }
}
