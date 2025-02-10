package com.birby.hrms_resource_api.data;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.StandardCharsets;

public class BloomData {
    private static final BloomFilter<String> data;
    static {
        data = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), 1000, 0.01);
    }
    public static BloomFilter<String> getData() {
        return data;
    }
}
