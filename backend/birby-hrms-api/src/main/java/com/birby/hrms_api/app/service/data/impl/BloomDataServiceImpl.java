package com.birby.hrms_api.service.data.impl;

import com.birby.hrms_api.component.data.BloomData;
import com.birby.hrms_api.service.data.BloomDataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BloomDataServiceImpl implements BloomDataService {
    private final BloomData bloomData;

    @Autowired
    public BloomDataServiceImpl(BloomData bloomData) {
        this.bloomData = bloomData;
    }

    @Override
    public boolean put(String uid, List<String> roleIds) {
        return bloomData.getData().put(stringifyKey(uid,roleIds));
    }
    @Override
    public boolean mightContain(String uid, List<String> roleIds) {
        return bloomData.getData().mightContain(stringifyKey(uid,roleIds));
    }
    private String stringifyKey(String uid, List<String> roleIds) {
        return BloomDataService.stringifyKey(uid,roleIds);
    }
}
