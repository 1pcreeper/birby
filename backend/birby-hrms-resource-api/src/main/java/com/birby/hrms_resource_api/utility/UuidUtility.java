package com.birby.hrms_resource_api.utility;

import java.util.UUID;

public class UuidUtility {
    public static String generate(){
        return UUID.randomUUID().toString();
    }
}
