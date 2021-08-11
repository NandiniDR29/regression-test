package com.exigen.ren.rest.rating.model.gb_dn;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentBreakdownModel extends Model {

    private String tier;
    private String numberOfLives;

    public String getTier() {
        return tier;
    }

    public EnrollmentBreakdownModel setTier(String tier) {
        this.tier = tier;
        return this;
    }

    public String getNumberOfLives() {
        return numberOfLives;
    }

    public EnrollmentBreakdownModel setNumberOfLives(String numberOfLives) {
        this.numberOfLives = numberOfLives;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EnrollmentBreakdownModel)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        EnrollmentBreakdownModel that = (EnrollmentBreakdownModel) o;
        return Objects.equals(tier, that.tier) &&
                Objects.equals(numberOfLives, that.numberOfLives);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tier, numberOfLives);
    }

    @Override
    public String toString() {
        return "EnrollmentBreakdownModel{" +
                "tier='" + tier + '\'' +
                ", numberOfLives='" + numberOfLives + '\'' +
                '}';
    }
}
