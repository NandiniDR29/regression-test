/* Copyright © 2018 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.customer.groupSponsors.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.exigen.ren.rest.customer.model.CustomerModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupSponsorModel extends Model {

    private ParticipantModel participant;
    private ParticipationDetailsModel participationDetails;

    public GroupSponsorModel() {
    }

    public GroupSponsorModel(CustomerModel customer, ParticipationDetailsModel participationDetailsModel) {
        setParticipant(customer);
        setParticipationDetails(participationDetailsModel);
    }

    @JsonSetter("participant")
    public void setParticipant(ParticipantModel participant) {
        this.participant = participant;
    }

    public void setParticipant(CustomerModel customer) {
        participant = new ParticipantModel();
        participant.setCustomerNumber(customer.getCustomerNumber());
        participant.setAccountNumber(customer.getAccountNumber());
        participant.setCustomerType(customer.getCustomerType());
        participant.setCustomerStatus(customer.getCustomerStatus());
        participant.setSourceCd(customer.getSourceCd());
        participant.setRatingCd(customer.getRatingCd());
        participant.setDisplayValue(customer.getDisplayValue());
    }

    public ParticipantModel getParticipant() {
        return this.participant;
    }

    public void setParticipationDetails(ParticipationDetailsModel participationDetails) {
        this.participationDetails = participationDetails;
    }

    public ParticipationDetailsModel getParticipationDetails() {
        return this.participationDetails;
    }

}