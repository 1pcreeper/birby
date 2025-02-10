package com.birby.hrms_resource_api.service.manager;

public interface BloomFilterManagerService {
    void add(String value);
    boolean mightContain(String value);
}