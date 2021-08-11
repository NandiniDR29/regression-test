package com.exigen.ren.rest.billing.model;

public class InvoicingCalendarModel {

    private String frequency;
    private String dueDay;


    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDueDay() {
        return dueDay;
    }

    public void setDueDay(String dueDay) {
        this.dueDay = dueDay;
    }
}
