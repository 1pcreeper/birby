package com.birby.hrms_resource_api.exception;

public class DatabaseUpdateFailureException extends RuntimeException {
    public DatabaseUpdateFailureException(String message) {
        super(message);
    }
}
