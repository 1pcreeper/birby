package com.birby.hrms.exception;

public class DatabaseUpdateFailureException extends RuntimeException {
    public DatabaseUpdateFailureException(String message) {
        super(message);
    }
}
