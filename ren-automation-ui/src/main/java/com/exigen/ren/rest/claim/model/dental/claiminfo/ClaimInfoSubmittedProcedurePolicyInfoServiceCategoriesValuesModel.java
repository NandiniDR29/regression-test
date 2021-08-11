package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ren.rest.model.RestError;

public class ClaimInfoSubmittedProcedurePolicyInfoServiceCategoriesValuesModel extends RestError {

    private String procedureCategory;
    private String procedureCategoryValue;

    public String getProcedureCategory() {
        return procedureCategory;
    }

    public void setProcedureCategory(String procedureCategory) {
        this.procedureCategory = procedureCategory;
    }

    public String getProcedureCategoryValue() {
        return procedureCategoryValue;
    }

    public void setProcedureCategoryValue(String procedureCategoryValue) {
        this.procedureCategoryValue = procedureCategoryValue;
    }

}
