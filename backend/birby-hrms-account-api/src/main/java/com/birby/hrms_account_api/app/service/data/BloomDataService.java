package com.birby.hrms_account_api.app.service.data;

import java.util.Collections;
import java.util.List;

public interface BloomDataService {
    static String stringifyKey(String uid, List<String> roleIds){
        Collections.sort(roleIds);
        return uid.concat(roleIds.toString());
    }
    boolean put(String uid, List<String> roleIds);
    boolean mightContain(String uid, List<String> roleIds);
}
