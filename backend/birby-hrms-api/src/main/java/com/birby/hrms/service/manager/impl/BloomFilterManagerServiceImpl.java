package com.birby.hrms.service.manager.impl;

import com.birby.hrms.model.bo.response.AccountStaffRoleIdsResCliBo;
import com.birby.hrms.cache.BloomCache;
import com.birby.hrms.exception.UnAuthorizedException;
import com.birby.hrms.service.cli.AccountStaffRoleCliService;
import com.birby.hrms.service.manager.BloomFilterManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloomFilterManagerServiceImpl implements BloomFilterManagerService {
    private final AccountStaffRoleCliService accountStaffRoleCliService;
    @Autowired
    public BloomFilterManagerServiceImpl(AccountStaffRoleCliService accountStaffRoleCliService){
        this.accountStaffRoleCliService=accountStaffRoleCliService;
    }
    @Override
    public void addBloom(String uid, List<String> roleIds) {
        BloomCache.put(uid,roleIds);
    }

    @Override
    public void authorize(String uid, List<String> roleIds,String token) throws UnAuthorizedException {
        if(!BloomCache.mightContain(uid,roleIds)){
            return;
        }
        AccountStaffRoleIdsResCliBo data = accountStaffRoleCliService.getStaffRolesByUidMyself(token);
        List<String> dbRoleIds = data.getRoleIds();
        if(!roleIds.equals(dbRoleIds)){
            throw new UnAuthorizedException("Token Expired");
        }
    }
}
