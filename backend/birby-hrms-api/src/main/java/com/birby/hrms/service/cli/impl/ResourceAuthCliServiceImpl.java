package com.birby.hrms.service.cli.impl;

import com.birby.hrms.client.ResourceAuthClient;
import com.birby.hrms.bo.response.ResourceAuthResCliBo;
import com.birby.hrms.service.cli.ResourceAuthCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceAuthCliServiceImpl implements ResourceAuthCliService {
    private final ResourceAuthClient resourceAuthClient;
    @Autowired
    public ResourceAuthCliServiceImpl(
            ResourceAuthClient resourceAuthClient
    ){
        this.resourceAuthClient = resourceAuthClient;
    }
    @Override
    public ResourceAuthResCliBo getAuthData(String bearer) {
        return resourceAuthClient.getAuthData("Bearer ".concat(bearer));
    }
}
