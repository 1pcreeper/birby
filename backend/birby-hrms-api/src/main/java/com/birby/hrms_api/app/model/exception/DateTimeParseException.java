package com.birby.hrms_api.app.model.exception;

public class DateTimeParseException extends RuntimeException {
    public DateTimeParseException(String message) {
        super(message);
    }
}
