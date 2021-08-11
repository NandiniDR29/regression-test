package com.exigen.dxp.employee;

public class ColumnValidationException extends RuntimeException {
    private String message;
    public ColumnValidationException(String message){
         this.message=message;
    }
    @Override
    public String  getMessage(){
        return message;
    }
}
