package com.birby.hrms_resource_api.service.control;

import com.birby.hrms_resource_api.exception.UnAuthorizedException;

import java.util.List;

public interface BloomFilterControlService {
    void addBloom(String staffId, List<String> roleIds);
    void authorize(String staffId, List<String> roleIds) throws UnAuthorizedException;
}
