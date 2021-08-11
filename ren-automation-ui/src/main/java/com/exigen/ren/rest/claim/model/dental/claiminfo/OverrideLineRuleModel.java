package com.exigen.ren.rest.claim.model.dental.claiminfo;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class OverrideLineRuleModel extends Model {

    private String remarkCode;
    private String skipSpecialReview;
    private String skipFocusedReview;
    private String skipMemberEligibility;
    private String skipSubmissionTimeLimit;
    private String skipAgeLimit;
    private String skipBenefitWaitingPeriod;
    private String maximumNotApplicable;
    private String skipGeneralDuplication;
    private String skipSubstitution;
    private String skipProcedureReview;
    private String skipDiagnostics;
    private String isAllowed;
    private String isOverrideRemarkCode;
    private String isDenied;

    public String getRemarkCode() {
        return remarkCode;
    }

    public void setRemarkCode(String remarkCode) {
        this.remarkCode = remarkCode;
    }

    public String getSkipSpecialReview() {
        return skipSpecialReview;
    }

    public void setSkipSpecialReview(String skipSpecialReview) {
        this.skipSpecialReview = skipSpecialReview;
    }

    public String getSkipFocusedReview() {
        return skipFocusedReview;
    }

    public void setSkipFocusedReview(String skipFocusedReview) {
        this.skipFocusedReview = skipFocusedReview;
    }

    public String getSkipMemberEligibility() {
        return skipMemberEligibility;
    }

    public void setSkipMemberEligibility(String skipMemberEligibility) {
        this.skipMemberEligibility = skipMemberEligibility;
    }

    public String getSkipSubmissionTimeLimit() {
        return skipSubmissionTimeLimit;
    }

    public void setSkipSubmissionTimeLimit(String skipSubmissionTimeLimit) {
        this.skipSubmissionTimeLimit = skipSubmissionTimeLimit;
    }

    public String getSkipAgeLimit() {
        return skipAgeLimit;
    }

    public void setSkipAgeLimit(String skipAgeLimit) {
        this.skipAgeLimit = skipAgeLimit;
    }

    public String getSkipBenefitWaitingPeriod() {
        return skipBenefitWaitingPeriod;
    }

    public void setSkipBenefitWaitingPeriod(String skipBenefitWaitingPeriod) {
        this.skipBenefitWaitingPeriod = skipBenefitWaitingPeriod;
    }

    public String getMaximumNotApplicable() {
        return maximumNotApplicable;
    }

    public void setMaximumNotApplicable(String maximumNotApplicable) {
        this.maximumNotApplicable = maximumNotApplicable;
    }

    public String getSkipGeneralDuplication() {
        return skipGeneralDuplication;
    }

    public void setSkipGeneralDuplication(String skipGeneralDuplication) {
        this.skipGeneralDuplication = skipGeneralDuplication;
    }

    public String getSkipSubstitution() {
        return skipSubstitution;
    }

    public void setSkipSubstitution(String skipSubstitution) {
        this.skipSubstitution = skipSubstitution;
    }

    public String getSkipProcedureReview() {
        return skipProcedureReview;
    }

    public void setSkipProcedureReview(String skipProcedureReview) {
        this.skipProcedureReview = skipProcedureReview;
    }

    public String getSkipDiagnostics() {
        return skipDiagnostics;
    }

    public void setSkipDiagnostics(String skipDiagnostics) {
        this.skipDiagnostics = skipDiagnostics;
    }

    public String getIsAllowed() {
        return isAllowed;
    }

    public void setIsAllowed(String isAllowed) {
        this.isAllowed = isAllowed;
    }

    public String getIsOverrideRemarkCode() {
        return isOverrideRemarkCode;
    }

    public void setIsOverrideRemarkCode(String isOverrideRemarkCode) {
        this.isOverrideRemarkCode = isOverrideRemarkCode;
    }

    public String getIsDenied() {
        return isDenied;
    }

    public void setIsDenied(String isDenied) {
        this.isDenied = isDenied;
    }
}