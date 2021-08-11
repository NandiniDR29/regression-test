package com.exigen.ren.rest.claim.model.dental.claimImage;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class MasterPolicyDetailsCoverageDefinitionsModel extends Model {
    private ExclusionsModel exclusions;
    private PreventativeModel preventative;
    private MajorModel major ;

    public ExclusionsModel getExclusions() {
        return exclusions;
    }

    public void setExclusions(ExclusionsModel exclusions) {
        this.exclusions = exclusions;
    }

    public PreventativeModel getPreventative() {
        return preventative;
    }

    public void setPreventative(PreventativeModel preventative) {
        this.preventative = preventative;
    }

    public MajorModel getMajor() {
        return major;
    }

    public void setMajor(MajorModel major) {
        this.major = major;
    }
}