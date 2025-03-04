package com.birby.hrms_api.service.manager.impl;

import com.birby.hrms_api.model.clidto.res.AccountStaffRoleIdsResCliDto;
import com.birby.hrms_api.component.data.BloomData;
import com.birby.hrms_api.model.exception.UnAuthorizedException;
import com.birby.hrms_api.service.client.AccountStaffRoleClientService;
import com.birby.hrms_api.service.data.BloomDataService;
import com.birby.hrms_api.service.manager.BloomFilterManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloomFilterManagerServiceImpl implements BloomFilterManagerService {
    private final AccountStaffRoleClientService accountStaffRoleClientService;
    private final BloomDataService bloomDataService;
    @Autowired
    public BloomFilterManagerServiceImpl(
            AccountStaffRoleClientService accountStaffRoleClientService,
            BloomDataService bloomDataService
    ){
        this.accountStaffRoleClientService = accountStaffRoleClientService;
        this.bloomDataService = bloomDataService;
    }
    @Override
    public void addBloom(String uid, List<String> roleIds) {
        bloomDataService.put(uid,roleIds);
    }

    @Override
    public void authorize(String uid, List<String> roleIds,String token) throws UnAuthorizedException {
        if(!bloomDataService.mightContain(uid,roleIds)){
            return;
        }
        AccountStaffRoleIdsResCliDto data = accountStaffRoleClientService.getStaffRolesByUidMyself(token);
        List<String> dbRoleIds = data.getRoleIds();
        if(!roleIds.equals(dbRoleIds)){
            throw new UnAuthorizedException("Token Expired");
        }
    }
}
