package com.birby.hrms_api.service.client.impl;

import com.birby.hrms_api.model.clidto.res.AccountStaffRoleIdsResCliDto;
import com.birby.hrms_api.client.AccountStaffRoleClient;
import com.birby.hrms_api.model.response.ApiResponse;
import com.birby.hrms_api.service.client.AccountStaffRoleClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountStaffRoleClientServiceImpl implements AccountStaffRoleClientService {
    private final AccountStaffRoleClient accountStaffRoleClient;
    @Autowired
    public AccountStaffRoleClientServiceImpl(AccountStaffRoleClient accountStaffRoleClient){
        this.accountStaffRoleClient = accountStaffRoleClient;
    }
    @Override
    public AccountStaffRoleIdsResCliDto getStaffRolesByUid(String authorization, String uid) {
        Object object = accountStaffRoleClient.getStaffRolesByUid(authorization,uid);
        ApiResponse<AccountStaffRoleIdsResCliDto> data = (ApiResponse<AccountStaffRoleIdsResCliDto>)object;
        return data.getData();
    }

    @Override
    public AccountStaffRoleIdsResCliDto getStaffRolesByUidMyself(String authorization) {
        Object object = accountStaffRoleClient.getStaffRolesByUidMyself(authorization);
        ApiResponse<AccountStaffRoleIdsResCliDto> data = (ApiResponse<AccountStaffRoleIdsResCliDto>)object;
        return data.getData();
    }
}
