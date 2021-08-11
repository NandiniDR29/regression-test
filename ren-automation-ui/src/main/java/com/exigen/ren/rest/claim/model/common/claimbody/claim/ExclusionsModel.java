package com.exigen.ren.rest.claim.model.common.claimbody.claim;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class ExclusionsModel extends Model {
    private String cosmeticServicesInd;
    private String completeOcclusalAdjustment;
    private String pulpCaps;
    private String pulpalTherapy;
    private String excisionOfBoneTissue;
    private String biopsyLesionVestibuloplasty;
    private String arestin;

    public String getCosmeticServicesInd() {
        return cosmeticServicesInd;
    }

    public void setCosmeticServicesInd(String cosmeticServicesInd) {
        this.cosmeticServicesInd = cosmeticServicesInd;
    }

    public String getCompleteOcclusalAdjustment() {
        return completeOcclusalAdjustment;
    }

    public void setCompleteOcclusalAdjustment(String completeOcclusalAdjustment) {
        this.completeOcclusalAdjustment = completeOcclusalAdjustment;
    }

    public String getPulpCaps() {
        return pulpCaps;
    }

    public void setPulpCaps(String pulpCaps) {
        this.pulpCaps = pulpCaps;
    }

    public String getPulpalTherapy() {
        return pulpalTherapy;
    }

    public void setPulpalTherapy(String pulpalTherapy) {
        this.pulpalTherapy = pulpalTherapy;
    }

    public String getExcisionOfBoneTissue() {
        return excisionOfBoneTissue;
    }

    public void setExcisionOfBoneTissue(String excisionOfBoneTissue) {
        this.excisionOfBoneTissue = excisionOfBoneTissue;
    }

    public String getBiopsyLesionVestibuloplasty() {
        return biopsyLesionVestibuloplasty;
    }

    public void setBiopsyLesionVestibuloplasty(String biopsyLesionVestibuloplasty) {
        this.biopsyLesionVestibuloplasty = biopsyLesionVestibuloplasty;
    }

    public String getArestin() {
        return arestin;
    }

    public void setArestin(String arestin) {
        this.arestin = arestin;
    }
}