package com.exigen.ren.rest.rating.model.gb_vs;

import com.exigen.ipb.eisa.ws.rest.model.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentBreakdownModel extends Model {

    private String tier;
    private float numberOfLives;

    public String getTier() {
        return tier;
    }

    public EnrollmentBreakdownModel setTier(String tier) {
        this.tier = tier;
        return this;
    }

    public float getNumberOfLives() {
        return numberOfLives;
    }

    public EnrollmentBreakdownModel setNumberOfLives(float numberOfLives) {
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
        return Float.compare(that.numberOfLives, numberOfLives) == 0 &&
                Objects.equals(tier, that.tier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tier, numberOfLives);
    }

    @Override
    public String toString() {
        return "EnrollmentBreakdownModel{" +
                "tier='" + tier + '\'' +
                ", numberOfLives=" + numberOfLives +
                '}';
    }
}
