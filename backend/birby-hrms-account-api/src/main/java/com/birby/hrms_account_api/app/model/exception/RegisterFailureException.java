package com.birby.hrms_account_api.app.model.exception;

public class RegisterFailureException extends RuntimeException{
    public RegisterFailureException(String message){
        super(message);
    }
}
