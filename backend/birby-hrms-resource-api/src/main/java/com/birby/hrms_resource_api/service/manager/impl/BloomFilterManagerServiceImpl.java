package com.birby.hrms_resource_api.service.manager.impl;

import com.birby.hrms_resource_api.data.BloomData;
import com.birby.hrms_resource_api.service.manager.BloomFilterManagerService;
import org.springframework.stereotype.Service;

@Service
public class BloomFilterManagerServiceImpl implements BloomFilterManagerService {

    public void add(String value) {
        BloomData.getData().put(value);
    }

    public boolean mightContain(String value) {
        return BloomData.getData().mightContain(value);
    }
}