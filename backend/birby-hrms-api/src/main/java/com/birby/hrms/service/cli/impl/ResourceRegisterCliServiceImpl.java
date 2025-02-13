package com.birby.hrms.service.cli.impl;

import com.birby.hrms.bo.request.ResourceRegisterReqCliBo;
import com.birby.hrms.bo.response.ResourceRegisterResCliBo;
import com.birby.hrms.client.ResourceRegisterClient;
import com.birby.hrms.dto.ApiResponse;
import com.birby.hrms.service.cli.ResourceRegisterCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceRegisterCliServiceImpl implements ResourceRegisterCliService {
    private final ResourceRegisterClient resourceRegisterClient;
    @Autowired
    public ResourceRegisterCliServiceImpl(ResourceRegisterClient resourceRegisterClient){
        this.resourceRegisterClient=resourceRegisterClient;
    }
    @Override
    public ApiResponse<ResourceRegisterResCliBo> register(ResourceRegisterReqCliBo reqCliBo, String token) {
        return resourceRegisterClient.register(token,reqCliBo);
    }
}
