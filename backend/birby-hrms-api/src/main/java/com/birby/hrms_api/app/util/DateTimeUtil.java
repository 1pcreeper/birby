package com.birby.hrms_api.app.util;

import com.birby.hrms_api.app.model.exception.DateTimeParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
    private static final SimpleDateFormat dateFormat;
    static {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }
    public static Date toDate(String str) throws DateTimeParseException {
        try {
            return dateFormat.parse(str);
        } catch (ParseException e) {
            throw new DateTimeParseException("Date parse Error");
        }
    }
}
