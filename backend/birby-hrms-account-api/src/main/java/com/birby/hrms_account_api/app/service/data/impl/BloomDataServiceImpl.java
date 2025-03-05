package com.birby.hrms_account_api.app.service.data.impl;

import com.birby.hrms_account_api.app.component.data.BloomData;
import com.birby.hrms_account_api.app.service.data.BloomDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloomDataServiceImpl implements BloomDataService {
    private final BloomData bloomData;

    @Autowired
    public BloomDataServiceImpl(BloomData bloomData) {
        this.bloomData = bloomData;
    }

    @Override
    public boolean put(String uid, List<String> roleIds) {
        return bloomData.getData().put(stringify(uid,roleIds));
    }
    @Override
    public boolean mightContain(String uid, List<String> roleIds) {
        return bloomData.getData().mightContain(stringify(uid,roleIds));
    }

    private String stringify(String uid, List<String> roleIds) {
        return BloomDataService.stringifyKey(uid,roleIds);
    }
}
