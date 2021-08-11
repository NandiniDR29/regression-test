package com.exigen.ren.rest.dxp.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.List;
import java.util.Objects;

public class CustomerRenContact extends Model {
    private List<String> communicationPreferences;
    private String id;

    public List<String> getCommunicationPreferences() {
        return communicationPreferences;
    }

    public void setCommunicationPreferences(List<String> communicationPreferences) {
        this.communicationPreferences = communicationPreferences;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CustomerRenContact that = (CustomerRenContact) o;
        return Objects.equals(communicationPreferences, that.communicationPreferences) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), communicationPreferences, id);
    }
}
