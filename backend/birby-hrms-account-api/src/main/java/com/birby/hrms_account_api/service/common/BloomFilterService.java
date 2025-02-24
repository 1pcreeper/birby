package com.birby.hrms_account_api.service.common;

import com.birby.hrms_account_api.exception.UnAuthorizedException;

import java.util.List;

public interface BloomFilterService {
    void addBloom(String uid, List<String> roleIds);
    void authorize(String uid, List<String> roleIds) throws UnAuthorizedException;
}