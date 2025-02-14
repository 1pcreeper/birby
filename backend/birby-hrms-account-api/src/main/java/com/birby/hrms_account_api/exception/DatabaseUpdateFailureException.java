package com.birby.hrms_account_api.exception;

public class DatabaseUpdateFailureException extends RuntimeException {
    public DatabaseUpdateFailureException(String message) {
        super(message);
    }
}
