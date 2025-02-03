package com.birby.hrms_resource_api.exception;

public class RegisterFailureException extends RuntimeException{
    public RegisterFailureException(String message){
        super(message);
    }
}
