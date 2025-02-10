package com.birby.hrms_resource_api.service.control.impl;

import com.birby.hrms_resource_api.exception.UnAuthorizedException;
import com.birby.hrms_resource_api.service.manager.BloomFilterManagerService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BloomFilterControlServiceImpl implements com.birby.hrms_resource_api.service.control.BloomFilterControlService {
    private final BloomFilterManagerService bloomFilterManagerService;

    public BloomFilterControlServiceImpl(BloomFilterManagerService bloomFilterManagerService) {
        this.bloomFilterManagerService = bloomFilterManagerService;
    }

    @Override
    public void addBloom(String staffId, List<String> roleIds) {
        Collections.sort(roleIds);
        String data = staffId.concat(roleIds.toString());
        bloomFilterManagerService.add(data);
    }

    @Override
    public void authorize(String staffId, List<String> roleIds) throws UnAuthorizedException {
        Collections.sort(roleIds);
        String data = staffId.concat(roleIds.toString());
        if(bloomFilterManagerService.mightContain(data)){
            throw new UnAuthorizedException("Token Expired");
        }
    }
}
