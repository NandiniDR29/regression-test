package com.exigen.ren.rest.dxp.model.claim.claimsEmployerModels.claimsAccidentEmployerModels;

import com.exigen.ren.rest.dxp.model.claim.claimsEmployerModels.ClaimsEmployerIncidentAbstractModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccidentalDeathIncidentModel extends ClaimsEmployerIncidentAbstractModel {
}
