package com.birby.hrms_api.model.exception;

public class ClientServiceException extends RuntimeException {
    public ClientServiceException(String message) {
        super(message);
    }
}
