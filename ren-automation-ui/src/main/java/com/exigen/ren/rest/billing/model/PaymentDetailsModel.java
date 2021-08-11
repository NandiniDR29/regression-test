/* Copyright © 2016 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
 CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/
package com.exigen.ren.rest.billing.model;

import com.exigen.ipb.eisa.ws.rest.model.Model;

public class PaymentDetailsModel extends Model {

    private String type;
    private SavedPaymentMethodModel savedPaymentMethod;
    private ChequeModel cheque;
    private AchModel ach;
    private CreditCardModel creditCard;
    private EftModel eft;

    public PaymentDetailsModel() {
    }

    public EftModel getEft() { return eft; }

    public void setEft(EftModel eft) { this.eft = eft; }

    public CreditCardModel getCreditCard() { return creditCard; }

    public void setCreditCard(CreditCardModel creditCard) { this.creditCard = creditCard; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public ChequeModel getCheque() { return cheque; }

    public void setCheque(ChequeModel cheque) { this.cheque = cheque; }

    public AchModel getAch() { return ach; }

    public void setAch(AchModel ach) { this.ach = ach; }

    public SavedPaymentMethodModel getSavedPaymentMethod() { return savedPaymentMethod; }

    public void setSavedPaymentMethod(SavedPaymentMethodModel savedPaymentMethod) { this.savedPaymentMethod = savedPaymentMethod; }
}

class SavedPaymentMethodModel {

    private String id;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}

class ChequeModel {

    private String chequeNumber;

    public String getChequeNumber() { return chequeNumber; }

    public void setChequeNumber(String chequeNumber) { this.chequeNumber = chequeNumber; }
}

class AchModel {

    private String transitNumber;
    private String bankName;
    private String accountNumber;
    private String nameTypeCd;
    private String firstName;
    private String lastName;
    private String otherName;

    public AchModel() {
    }

    public String getTransitNumber() { return transitNumber; }

    public void setTransitNumber(String transitNumber) { this.transitNumber = transitNumber; }

    public String getBankName() { return bankName; }

    public void setBankName(String bankName) { this.bankName = bankName; }

    public String getAccountNumber() { return accountNumber; }

    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getNameTypeCd() { return nameTypeCd; }

    public void setNameTypeCd(String nameTypeCd) { this.nameTypeCd = nameTypeCd; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getOtherName() { return otherName; }

    public void setOtherName(String otherName) { this.otherName = otherName; }
}

class EftModel {

    private String transitNumber;
    private String accountNumber;
    private String countryCd;
    private String bankName;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTransitNumber() { return transitNumber; }

    public void setTransitNumber(String transitNumber) { this.transitNumber = transitNumber; }

    public String getAccountNumber() { return accountNumber; }

    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getCountryCd() { return countryCd; }

    public void setCountryCd(String countryCd) { this.countryCd = countryCd; }
}
