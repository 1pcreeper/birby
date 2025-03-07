package com.birby.hrms_api.app.service.manager.impl;

import com.birby.hrms_api.app.component.properties.SecurityProperties;
import com.birby.hrms_api.app.model.clidto.res.AccountStaffRoleIdsResCliDto;
import com.birby.hrms_api.app.model.exception.ClientServiceException;
import com.birby.hrms_api.app.model.exception.UnAuthorizedException;
import com.birby.hrms_api.app.service.client.AccountStaffRoleClientService;
import com.birby.hrms_api.app.service.data.BloomDataService;
import com.birby.hrms_api.app.service.manager.BloomFilterManagerService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloomFilterManagerServiceImpl implements BloomFilterManagerService {
    private final AccountStaffRoleClientService accountStaffRoleClientService;
    private final BloomDataService bloomDataService;
    private final SecurityProperties securityProperties;
    @Autowired
    public BloomFilterManagerServiceImpl(
            AccountStaffRoleClientService accountStaffRoleClientService,
            BloomDataService bloomDataService,
            SecurityProperties securityProperties
    ){
        this.accountStaffRoleClientService = accountStaffRoleClientService;
        this.bloomDataService = bloomDataService;
        this.securityProperties = securityProperties;
    }
    @Override
    public void addBloom(String uid, List<String> roleIds,String access) {
        if(!access.equals(securityProperties.getApiKey())){
            throw new UnAuthorizedException("Access Decline");
        }
        bloomDataService.put(uid,roleIds);
        System.out.println(String.format("Added %s to Bloom Filter",uid));
    }

    @Override
    public void authorize(String uid, List<String> roleIds,String token) throws UnAuthorizedException {
        if(!bloomDataService.mightContain(uid,roleIds)){
            return;
        }
        AccountStaffRoleIdsResCliDto data;
        try{
            data = accountStaffRoleClientService.getStaffRolesByUidMyself(token);
        }catch(FeignException e){
            throw new ClientServiceException(e.getMessage());
        }
        List<String> dbRoleIds = data.getRoleIds();
        if(!roleIds.equals(dbRoleIds)){
            throw new UnAuthorizedException("Token Expired");
        }
    }
}
