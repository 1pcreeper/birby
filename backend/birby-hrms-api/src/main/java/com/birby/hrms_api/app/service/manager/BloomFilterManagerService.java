package com.birby.hrms_api.app.service.manager;

import com.birby.hrms_api.app.model.exception.UnAuthorizedException;

import java.util.List;

public interface BloomFilterManagerService {
    void addBloom(String uid, List<String> roleIds);
    void authorize(String uid, List<String> roleIds,String token) throws UnAuthorizedException;
}
