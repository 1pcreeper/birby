package com.birby.hrms_api.app.model.exception;

public class DatabaseUpdateFailureException extends RuntimeException {
    public DatabaseUpdateFailureException(String message) {
        super(message);
    }
}
