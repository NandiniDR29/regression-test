package com.exigen.ren.rest.claim.model.recoveries;

import java.util.Objects;

public class RecoveryDetailsEFTModel {

    private String bankAccountNumber;
    private String bankTransitNumber;
    private String bankAccountInfo;
    private String bankName;
    private String bankBranchCd;
    private String bankAccountHolderName;
    private String bankCd;
    private String bankAccountTypeCd;

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankTransitNumber() {
        return bankTransitNumber;
    }

    public void setBankTransitNumber(String bankTransitNumber) {
        this.bankTransitNumber = bankTransitNumber;
    }

    public String getBankAccountInfo() {
        return bankAccountInfo;
    }

    public void setBankAccountInfo(String bankAccountInfo) {
        this.bankAccountInfo = bankAccountInfo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranchCd() {
        return bankBranchCd;
    }

    public void setBankBranchCd(String bankBranchCd) {
        this.bankBranchCd = bankBranchCd;
    }

    public String getBankAccountHolderName() {
        return bankAccountHolderName;
    }

    public void setBankAccountHolderName(String bankAccountHolderName) {
        this.bankAccountHolderName = bankAccountHolderName;
    }

    public String getBankCd() {
        return bankCd;
    }

    public void setBankCd(String bankCd) {
        this.bankCd = bankCd;
    }

    public String getBankAccountTypeCd() {
        return bankAccountTypeCd;
    }

    public void setBankAccountTypeCd(String bankAccountTypeCd) {
        this.bankAccountTypeCd = bankAccountTypeCd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecoveryDetailsEFTModel that = (RecoveryDetailsEFTModel) o;
        return Objects.equals(bankAccountNumber, that.bankAccountNumber) &&
                Objects.equals(bankTransitNumber, that.bankTransitNumber) &&
                Objects.equals(bankAccountInfo, that.bankAccountInfo) &&
                Objects.equals(bankName, that.bankName) &&
                Objects.equals(bankBranchCd, that.bankBranchCd) &&
                Objects.equals(bankAccountHolderName, that.bankAccountHolderName) &&
                Objects.equals(bankCd, that.bankCd) &&
                Objects.equals(bankAccountTypeCd, that.bankAccountTypeCd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountNumber, bankTransitNumber, bankAccountInfo, bankName, bankBranchCd, bankAccountHolderName, bankCd, bankAccountTypeCd);
    }

}
