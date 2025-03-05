package com.birby.hrms_account_api.app.util;

import java.util.UUID;

public class UuidUtil {
    public static String generate(){
        return UUID.randomUUID().toString();
    }
}
