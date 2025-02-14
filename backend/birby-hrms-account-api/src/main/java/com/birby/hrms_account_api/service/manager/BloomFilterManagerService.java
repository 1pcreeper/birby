package com.birby.hrms_account_api.service.manager;

import com.birby.hrms_account_api.exception.UnAuthorizedException;

import java.util.List;

public interface BloomFilterManagerService {
    void addBloom(String staffId, List<String> roleIds);
    void authorize(String uid, List<String> roleIds) throws UnAuthorizedException;
}