package com.birby.hrms_api.app.service.client.impl;

import com.birby.hrms_api.app.model.clidto.res.AccountStaffRoleIdsResCliDto;
import com.birby.hrms_api.app.client.AccountStaffRoleClient;
import com.birby.hrms_api.app.model.exception.ClientServiceException;
import com.birby.hrms_api.app.model.exception.UnAuthorizedException;
import com.birby.hrms_api.app.model.response.ApiResponse;
import com.birby.hrms_api.app.service.client.AccountStaffRoleClientService;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountStaffRoleClientServiceImpl implements AccountStaffRoleClientService {
    private final AccountStaffRoleClient accountStaffRoleClient;
    @Autowired
    public AccountStaffRoleClientServiceImpl(AccountStaffRoleClient accountStaffRoleClient){
        this.accountStaffRoleClient = accountStaffRoleClient;
    }
    @Override
    public AccountStaffRoleIdsResCliDto getStaffRolesByUid(String authorization, String uid) throws ClientServiceException{
        Object object;
        try{
            object = accountStaffRoleClient.getStaffRolesByUid(authorization,uid);
        }catch(RuntimeException e){
            log.error(e.getLocalizedMessage());
            throw new UnAuthorizedException(e.getMessage());
        }
        ApiResponse<AccountStaffRoleIdsResCliDto> data = (ApiResponse<AccountStaffRoleIdsResCliDto>)object;
        return data.getData();
    }

    @Override
    public AccountStaffRoleIdsResCliDto getStaffRolesByUidMyself(String authorization) throws ClientServiceException {
        Object object;
        try{
            object = accountStaffRoleClient.getStaffRolesByUidMyself(authorization);
        } catch (RuntimeException e){
            log.error(e.getLocalizedMessage());
            throw new UnAuthorizedException(e.getMessage());
        }
        ApiResponse<AccountStaffRoleIdsResCliDto> data = (ApiResponse<AccountStaffRoleIdsResCliDto>)object;
        return data.getData();
    }
}
