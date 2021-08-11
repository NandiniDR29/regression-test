/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.customer.campaigns.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CampaignModel extends Model {
    private Integer campaignID;
    private String name;
    private String description;
    private String promotionCd;
    private String categoryCd;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate suspendFrom;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate suspendTo;
    private String status;
    private String terminationReason;
    private Double budgetCost;
    private Double actualCost;
    private Double expectedRevenue;
    private List<ChannelsModel> channels;
    private List<ProductsModel> products;
    private boolean autoStart;
    private String owner;
    private TargetCharacteristicsModel targetCharacteristics;

    public void setCampaignID(Integer campaignID) {
        this.campaignID = campaignID;
    }

    public Integer getCampaignID() {
        return campaignID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPromotionCd(String promotionCd) {
        this.promotionCd = promotionCd;
    }

    public String getPromotionCd() {
        return promotionCd;
    }

    public void setCategoryCd(String categoryCd) {
        this.categoryCd = categoryCd;
    }

    public String getCategoryCd() {
        return categoryCd;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setSuspendFrom(LocalDate suspendFrom) {
        this.suspendFrom = suspendFrom;
    }

    public LocalDate getSuspendFrom() {
        return suspendFrom;
    }

    public void setSuspendTo(LocalDate suspendTo) {
        this.suspendTo = suspendTo;
    }

    public LocalDate getSuspendTo() {
        return suspendTo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }

    public String getTerminationReason() {
        return terminationReason;
    }

    public void setBudgetCost(Double budgetCost) {
        this.budgetCost = budgetCost;
    }

    public Double getBudgetCost() {
        return budgetCost;
    }

    public void setActualCost(Double actualCost) {
        this.actualCost = actualCost;
    }

    public Double getActualCost() {
        return actualCost;
    }

    public void setExpectedRevenue(Double expectedRevenue) {
        this.expectedRevenue = expectedRevenue;
    }

    public Double getExpectedRevenue() {
        return expectedRevenue;
    }

    public void setChannels(List<ChannelsModel> channels) {
        this.channels = channels;
    }

    public List<ChannelsModel> getChannels() {
        return channels;
    }

    public void setProducts(List<ProductsModel> products) {
        this.products = products;
    }

    public List<ProductsModel> getProducts() {
        return products;
    }

    public void setAutoStart(boolean autoStart) {
        this.autoStart = autoStart;
    }

    public boolean getAutoStart() {
        return autoStart;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setTargetCharacteristics(TargetCharacteristicsModel targetCharacteristics) {
        this.targetCharacteristics = targetCharacteristics;
    }

    public TargetCharacteristicsModel getTargetCharacteristics() {
        return targetCharacteristics;
    }
}
