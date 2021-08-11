package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;

import java.util.Objects;

public class PatientHistoryModel extends Model {
    private String toothArea;
    private String oralCavityArea;
    private String irCode;

    public String getToothArea() {
        return toothArea;
    }

    public void setToothArea(String toothArea) {
        this.toothArea = toothArea;
    }

    public String getOralCavityArea() {
        return oralCavityArea;
    }

    public void setOralCavityArea(String oralCavityArea) {
        this.oralCavityArea = oralCavityArea;
    }

    public String getIrCode() {
        return irCode;
    }

    public void setIrCode(String irCode) {
        this.irCode = irCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PatientHistoryModel that = (PatientHistoryModel) o;
        return Objects.equals(toothArea, that.toothArea) &&
                Objects.equals(oralCavityArea, that.oralCavityArea) &&
                Objects.equals(irCode, that.irCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), toothArea, oralCavityArea, irCode);
    }
}
