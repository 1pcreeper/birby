package com.birby.hrms.service.manager;

import com.birby.hrms.exception.UnAuthorizedException;

import java.util.List;

public interface BloomFilterManagerService {
    void addBloom(String staffId, List<String> roleIds);
    void authorize(String uid, List<String> roleIds,String token) throws UnAuthorizedException;
}
