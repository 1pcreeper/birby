package com.birby.hrms.service.cli.impl;

import com.birby.hrms.bo.response.AccountStaffRoleIdsResCliBo;
import com.birby.hrms.client.AccountStaffRoleClient;
import com.birby.hrms.dto.ApiResponse;
import com.birby.hrms.service.cli.AccountStaffRoleCliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountStaffRoleCliServiceImpl implements AccountStaffRoleCliService {
    private final AccountStaffRoleClient accountStaffRoleClient;
    @Autowired
    public AccountStaffRoleCliServiceImpl(AccountStaffRoleClient accountStaffRoleClient){
        this.accountStaffRoleClient = accountStaffRoleClient;
    }
    @Override
    public AccountStaffRoleIdsResCliBo getStaffRolesByUid(String authorization, String uid) {
        Object object = accountStaffRoleClient.getStaffRolesByUid(authorization,uid);
        ApiResponse<AccountStaffRoleIdsResCliBo> data = (ApiResponse<AccountStaffRoleIdsResCliBo>)object;
        return data.getData();
    }

    @Override
    public AccountStaffRoleIdsResCliBo getStaffRolesByUidMyself(String authorization) {
        Object object = accountStaffRoleClient.getStaffRolesByUidMyself(authorization);
        ApiResponse<AccountStaffRoleIdsResCliBo> data = (ApiResponse<AccountStaffRoleIdsResCliBo>)object;
        return data.getData();
    }
}
