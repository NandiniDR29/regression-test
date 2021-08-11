package com.exigen.ren.rest.claim.model.common.claimbody.serviceRequests;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.List;
import java.util.Objects;

public class ServiceRequestModel extends Model {
    private String componentName;
    private List<VendorModel> vendors;

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public List<VendorModel> getVendors() {
        return vendors;
    }

    public void setVendors(List<VendorModel> vendors) {
        this.vendors = vendors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        ServiceRequestModel that = (ServiceRequestModel) o;
        return Objects.equals(componentName, that.componentName) &&
                Objects.equals(vendors, that.vendors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), componentName, vendors);
    }
}
