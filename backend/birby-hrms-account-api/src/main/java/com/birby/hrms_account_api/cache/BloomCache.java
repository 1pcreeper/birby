package com.birby.hrms_account_api.cache;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class BloomCache {
    private static final BloomFilter<String> INSTANCE;
    static {
        INSTANCE = BloomFilter.create(
                Funnels.stringFunnel(StandardCharsets.UTF_8),
                1000,
                0.01
        );
    }
    public static boolean put(String uid, List<String> roleIds) {
        return INSTANCE.put(stringify(uid,roleIds));
    }
    public static boolean mightContain(String uid, List<String> roleIds) {
        return INSTANCE.mightContain(stringify(uid,roleIds));
    }
    private static String stringify(String uid, List<String> roleIds){
        Collections.sort(roleIds);
        return uid.concat(roleIds.toString());
    }
}
