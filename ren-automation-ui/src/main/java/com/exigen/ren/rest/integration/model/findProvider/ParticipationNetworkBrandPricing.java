package com.exigen.ren.rest.integration.model.findProvider;

import java.util.List;

public class ParticipationNetworkBrandPricing {

    private String description;
    private String name;
    private String networkBrandPricingType;
    private List<String> stateCodes;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetworkBrandPricingType() {
        return networkBrandPricingType;
    }

    public void setNetworkBrandPricingType(String networkBrandPricingType) {
        this.networkBrandPricingType = networkBrandPricingType;
    }

    public List<String> getStateCodes() {
        return stateCodes;
    }

    public void setStateCodes(List<String> stateCodes) {
        this.stateCodes = stateCodes;
    }
}
